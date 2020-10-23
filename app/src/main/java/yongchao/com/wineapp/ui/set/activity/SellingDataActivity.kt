package yongchao.com.wineapp.ui.set.activity

import android.graphics.Color
import cn.qqtheme.framework.picker.DatePicker
import com.androidkun.xtablayout.XTabLayout
import kotlinx.android.synthetic.main.activity_data.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.mvp.bean.SellingDataBean
import yongchao.com.wineapp.ui.set.mvp.body.SellingDataBody
import yongchao.com.wineapp.ui.set.mvp.presenter.SellingDataPresenter
import yongchao.com.wineapp.ui.set.mvp.view.SellingDataView
import yongchao.com.wineapp.ui.set.util.StringUtils
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.picker.pickerUtils
import java.util.*
import java.text.ParseException
import java.text.SimpleDateFormat



class SellingDataActivity:BaseActivity() ,SellingDataView{
    override fun getSellingDataRequest(data: SellingDataBean) {
        if (data.data.orderNum>0) {
            tv_order_num.text = StringUtils.num2thousand(data.data.orderNum.toString())
        }else{
            tv_order_num.text="0"
        }

        if (data.data.sellingAmount>0){
            tv_sales_volume.text=StringUtils.num2thousand00(data.data.sellingAmount.toString())
        }else{
            tv_sales_volume.text="0.00"
        }

        if (data.data.profit>0){
            tv_profit.text=StringUtils.num2thousand00(data.data.profit.toString())
        }else{
            tv_profit.text="0.00"
        }
    }

    override fun getSellingDataError() {

    }

    private val presenter by lazy { SellingDataPresenter(this,this,this) }

    var flag=false

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_data

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

        var titles = ArrayList<String>()
        titles.add("今日")
        titles.add("本月")

        titles.forEach {
            tab.addTab(tab.newTab().setText(it))
        }
//
//        if (months<10){
//            m="0"+months.toString()
//        }else{
//            m=months.toString()
//        }
//
//        if (dates<10){
//            d="0"+dates.toString()
//        }else{
//            d=dates.toString()
//        }


//        tv_time.text=years.toString()+"."+m+"."+d

        tv_time.text=SimpleDateFormat("yyyy.MM.dd").format(Date(System.currentTimeMillis())).toString()
        presenter.getSellingData(SellingDataBody(0,SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date(System.currentTimeMillis())).toString()))
    }

    override fun clickListener() {

        tab.addOnTabSelectedListener(object :XTabLayout.OnTabSelectedListener{
            override fun onTabReselected(ta: XTabLayout.Tab?) {
                tab.setSelectedTabIndicatorColor(Color.parseColor("#D3AA71"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#D3AA71"))
                tv_time.setTextColor(Color.parseColor("#555555"))

                if (ta!!.text=="今日"){
//                    tv_time.text=years.toString()+"."+m+"."+d
                    flag=false
                    tv_time.text=SimpleDateFormat("yyyy.MM.dd").format(Date(System.currentTimeMillis())).toString()
                    presenter.getSellingData(SellingDataBody(0,SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date(System.currentTimeMillis())).toString()))
                }else{
//                    tv_time.text=years.toString()+"."+m
                    flag=true
                    tv_time.text=SimpleDateFormat("yyyy.MM").format(Date(System.currentTimeMillis())).toString()
                    presenter.getSellingData(SellingDataBody(1,SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date(System.currentTimeMillis())).toString()))
                }
            }

            override fun onTabUnselected(tab: XTabLayout.Tab?) {

            }

            override fun onTabSelected(ta: XTabLayout.Tab) {

                tab.setSelectedTabIndicatorColor(Color.parseColor("#D3AA71"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#D3AA71"))
                tv_time.setTextColor(Color.parseColor("#555555"))

                if (ta!!.text=="今日"){
//                    tv_time.text=years.toString()+"."+m+"."+d
                    flag=false
                    tv_time.text=SimpleDateFormat("yyyy.MM.dd").format(Date(System.currentTimeMillis())).toString()
                    presenter.getSellingData(SellingDataBody(0,SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date(System.currentTimeMillis())).toString()))
                }else{
//                    tv_time.text=years.toString()+"."+m
                    flag=true
                    tv_time.text=SimpleDateFormat("yyyy.MM").format(Date(System.currentTimeMillis())).toString()
                    presenter.getSellingData(SellingDataBody(1,SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date(System.currentTimeMillis())).toString()))
                }
            }
        })



        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(tv_time).subscribe {
            getTime()
        }

        Click.viewClick(iv_left).subscribe {
            if (flag){
                tv_time.setText(getSpecifiedMonthBefore(tv_time.text.toString()))
                tv_time.setTextColor(Color.parseColor("#D3AA71"))

                tab.setSelectedTabIndicatorColor(Color.parseColor("#00FFFFFF"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#888888"))
                presenter.getSellingData(SellingDataBody(1,tv_time.text.toString().replace(".","-")+"-01 00:00:00"))
            }else{
                tv_time.setText(getSpecifiedDayBefore(tv_time.text.toString()))
                tv_time.setTextColor(Color.parseColor("#D3AA71"))

                tab.setSelectedTabIndicatorColor(Color.parseColor("#00FFFFFF"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#888888"))
                presenter.getSellingData(SellingDataBody(0,tv_time.text.toString().replace(".","-")+" 00:00:00"))
            }

        }

        Click.viewClick(iv_right).subscribe {
            if (flag){
                tv_time.setText(getSpecifiedMonthAfter(tv_time.text.toString()))
                tv_time.setTextColor(Color.parseColor("#D3AA71"))

                tab.setSelectedTabIndicatorColor(Color.parseColor("#00FFFFFF"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#888888"))
                presenter.getSellingData(SellingDataBody(1,tv_time.text.toString().replace(".","-")+"-01 00:00:00"))
            }else {
                tv_time.setText(getSpecifiedDayAfter(tv_time.text.toString()))
                tv_time.setTextColor(Color.parseColor("#D3AA71"))

                tab.setSelectedTabIndicatorColor(Color.parseColor("#00FFFFFF"))
                tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#888888"))
                presenter.getSellingData(SellingDataBody(0,tv_time.text.toString().replace(".","-")+" 00:00:00"))
            }
        }
    }

    //指定日期前一天
    fun getSpecifiedDayBefore(specifiedDay: String): String {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        val c = Calendar.getInstance()
        var date: Date? = null
        try {
            date = SimpleDateFormat("yyyy.MM.dd").parse(specifiedDay)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        c.time = date
        val day = c.get(Calendar.DATE)
        c.set(Calendar.DATE, day - 1)

        return SimpleDateFormat("yyyy.MM.dd").format(c.time)
    }

    //指定日期后一天
    fun getSpecifiedDayAfter(specifiedDay: String): String {
        val c = Calendar.getInstance()
        var date: Date? = null
        try {
            date = SimpleDateFormat("yyyy.MM.dd").parse(specifiedDay)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        c.time = date
        val day = c.get(Calendar.DATE)
        c.set(Calendar.DATE, day + 1)

        return SimpleDateFormat("yyyy.MM.dd").format(c.time)
    }

    //指定日期前一月
    fun getSpecifiedMonthBefore(specifiedDay: String): String {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        val c = Calendar.getInstance()
        var date: Date? = null
        try {
            date = SimpleDateFormat("yyyy.MM").parse(specifiedDay)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        c.time = date
        val day = c.get(Calendar.MONTH)
        c.set(Calendar.MONTH, day - 1)

        return SimpleDateFormat("yyyy.MM").format(c.time)
    }

    //指定日期后一月
    fun getSpecifiedMonthAfter(specifiedDay: String): String {
        val c = Calendar.getInstance()
        var date: Date? = null
        try {
            date = SimpleDateFormat("yyyy.MM").parse(specifiedDay)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        c.time = date
        val day = c.get(Calendar.MONTH)
        c.set(Calendar.MONTH, day + 1)

        return SimpleDateFormat("yyyy.MM").format(c.time)
    }

    val c = Calendar.getInstance()//可以对每个时间域单独修改
    var years = c.get(Calendar.YEAR)
    var months = c.get(Calendar.MONTH) + 1
    var dates = c.get(Calendar.DATE)

    var m=""
    var d=""
    var day=c.get(Calendar.DATE)

    /**
     * 设置日期
     */

    fun getTime() {
        var picker = DatePicker(this)
        pickerUtils.showPicker(picker)
        picker.setSelectedItem(years, months, dates)
        picker.setBackgroundColor(Color.parseColor("#FAFAFA"))
        picker.setTopBackgroundColor(Color.parseColor("#ffffff"))
        picker.setLabelTextColor(Color.parseColor("#999999"))
        picker.setTitleText("选择日期")
        picker.setTitleTextColor(Color.parseColor("#222222"))
        picker.setTitleTextSize(16)
        picker.setOnDatePickListener(cn.qqtheme.framework.picker.DatePicker.OnYearMonthDayPickListener { year, month, day ->
            years = year.toInt()
            months = month.toInt()
            dates = day.toInt()
            tv_time.setText("$year.$month.$day")
            tv_time.setTextColor(Color.parseColor("#D3AA71"))
            flag=false
            tab.setSelectedTabIndicatorColor(Color.parseColor("#00FFFFFF"))
            tab.setTabTextColors(Color.parseColor("#888888"), Color.parseColor("#888888"))
            presenter.getSellingData(SellingDataBody(0,tv_time.text.toString().replace(".","-")+" 00:00:00"))
        })
        picker.show()
    }
}