package yongchao.com.wineapp.ui.set.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_area.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseDialogFragment
import yongchao.com.wineapp.ui.set.adapter.AreaAdapter
import yongchao.com.wineapp.ui.set.adapter.CityAdapter
import yongchao.com.wineapp.ui.set.adapter.ProvinceAdapter
import yongchao.com.wineapp.ui.set.mvp.bean.AreaBean
import yongchao.com.wineapp.ui.set.mvp.body.AreaBody
import yongchao.com.wineapp.ui.set.mvp.presenter.AreaPresenter
import yongchao.com.wineapp.ui.set.mvp.view.AreaView
import yongchao.com.wineapp.utils.Click


@SuppressLint("ValidFragment")
class AreaDialog(var tv: TextView): BaseDialogFragment(), ProvinceAdapter.CallBack, CityAdapter.CallBack, AreaAdapter.CallBack, AreaView {

    override fun getAreaRequest(data: AreaBean) {
        if (isProvicne){
            recy_province.visibility=View.GONE
            recy_city.visibility=View.VISIBLE
            recy_area.visibility=View.GONE
            var adapter=CityAdapter(data.data)
            adapter.setCallBack(this)
            var manager=LinearLayoutManager(activity!!)
            manager.orientation=LinearLayout.VERTICAL
            recy_city.layoutManager=manager
            recy_city.adapter=adapter
        }else if (isCity){
            recy_province.visibility=View.GONE
            recy_city.visibility=View.GONE
            recy_area.visibility=View.VISIBLE
            var adapter=AreaAdapter(data.data)
            adapter.setCallBack(this)
            var manager=LinearLayoutManager(activity!!)
            manager.orientation=LinearLayout.VERTICAL
            recy_area.layoutManager=manager
            recy_area.adapter=adapter
        }else{
            layout_area.visibility= View.GONE
            recy_province.visibility=View.VISIBLE
            recy_city.visibility=View.GONE
            recy_area.visibility=View.GONE
            var adapter=ProvinceAdapter(data.data)
            adapter.setCallBack(this)
            var manager=LinearLayoutManager(activity!!)
            manager.orientation=LinearLayout.VERTICAL
            recy_province.layoutManager=manager
            recy_province.adapter=adapter
        }

    }

    override fun getAreaError() {

    }

    private val presenter by lazy { AreaPresenter(this,this,activity!!) }
    private var isProvicne=false
    private var isCity=false
//    private var isArea=false
    private var p=""
    private var c=""
    private var a=""
    private var p_id=0
    private var c_id=0
    private var a_id=0

    override fun setLayoutID(): Int = R.layout.dialog_area

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        presenter.getArea(AreaBody("0"))
    }

    override fun clickListener() {
        Click.viewClick(tv_province).subscribe {
//            isProvicne=false
//            isCity=false
            recy_province.visibility=View.VISIBLE
            recy_area.visibility=View.GONE
            recy_city.visibility=View.GONE
            tv_province.setText("")
            tv_city.setText("")
            tv_area.setText("")
        }

        Click.viewClick(tv_city).subscribe {
            recy_province.visibility=View.GONE
            recy_area.visibility=View.GONE
            recy_city.visibility=View.VISIBLE
            tv_city.setText("")
            tv_area.setText("")
        }

        Click.viewClick(dialogOver).subscribe {
            dismiss()
        }

        Click.viewClick(dialog_close).subscribe {
            dismiss()
        }
    }

    override fun chooseProvince(str:String,id:Int) {
        p=str
        p_id=id
        isProvicne=true
        isCity=false
//        isArea=false
        layout_area.visibility=View.VISIBLE
        tv_province.visibility=View.VISIBLE
        tv_city.visibility=View.GONE
        tv_area.visibility=View.GONE
        tv_province.setText(str)
        tv_city.setText("")
        tv_area.setText("")
        presenter.getArea(AreaBody("${id}"))
    }

    override fun chooseCity(str:String,id:Int) {
        c=str
        c_id=id
        isProvicne=false
        isCity=true
//        isArea=false
//        layout_area.visibility=View.VISIBLE
//        tv_province.visibility=View.VISIBLE
        tv_city.visibility=View.VISIBLE
        tv_area.visibility=View.GONE
//        tv_province.setText(str)
        tv_city.setText(str)
        tv_area.setText("")
        presenter.getArea(AreaBody("${id}"))
    }

    override fun chooseArea(str:String,id:Int) {
        a=str
        a_id=id
        isProvicne=false
        isCity=false
//        isArea=true
//        layout_area.visibility=View.VISIBLE
//        tv_province.visibility=View.VISIBLE
//        tv_city.visibility=View.GONE
        tv_area.visibility=View.VISIBLE
//        tv_province.setText(str)
//        tv_city.setText("")
        tv_area.setText(str)
        tv.text=p+" "+c+" "+a
        callBack!!.choose(p_id,c_id,a_id)
        dismiss()
    }

    private var callBack:CallBack?=null

    public fun setCallBack(callBack: CallBack){
        this.callBack=callBack
    }

    interface CallBack{
        fun choose(p_id:Int,c_id:Int,a_id:Int)
    }

}