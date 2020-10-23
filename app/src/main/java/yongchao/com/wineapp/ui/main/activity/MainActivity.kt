package yongchao.com.wineapp.ui.main.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.main.adapter.ViewPageAdapter
import yongchao.com.wineapp.ui.main.fragment.ClassifyFragment
import yongchao.com.wineapp.ui.main.fragment.HomeFragment
import yongchao.com.wineapp.ui.main.fragment.MineFragment
import yongchao.com.wineapp.ui.main.fragment.OrderFragment
import yongchao.com.wineapp.utils.Click
import android.view.MotionEvent



class MainActivity:BaseActivity() {

    var mFragmentAdapter: ViewPageAdapter? = null
    var fragments = ArrayList<Fragment>()

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_main

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        fragments.add(HomeFragment())
        fragments.add(ClassifyFragment())
        fragments.add(OrderFragment())
        fragments.add(MineFragment())
        mFragmentAdapter= ViewPageAdapter(supportFragmentManager,fragments)
        vp_main.adapter=mFragmentAdapter
        vp_main.offscreenPageLimit=3
    }

    override fun clickListener() {
        Click.viewClick(tv_home).subscribe {
            chooseBottom(1)
        }

        Click.viewClick(tv_type).subscribe {
            chooseBottom(2)
        }

        Click.viewClick(tv_order).subscribe {
            chooseBottom(3)
        }

        Click.viewClick(tv_mine).subscribe {
            chooseBottom(4)
        }
    }

    fun chooseBottom(i:Int){
        when(i){
            1 ->{
                vp_main.currentItem=0
                tv_home.setTextColor(Color.parseColor("#D3AA71"))
                var draw_home=resources.getDrawable(R.mipmap.tabbar_homepage_sel)
                draw_home.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_home.setCompoundDrawables(null,draw_home,null,null)

                tv_type.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_type=resources.getDrawable(R.mipmap.tabbar_classification_nor)
                draw_type.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_type.setCompoundDrawables(null,draw_type,null,null)

                tv_order.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_order=resources.getDrawable(R.mipmap.tabbar_order_nor)
                draw_order.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_order.setCompoundDrawables(null,draw_order,null,null)

                tv_mine.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_mine=resources.getDrawable(R.mipmap.tabbar_mine_nor)
                draw_mine.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_mine.setCompoundDrawables(null,draw_mine,null,null)

            }

            2 ->{
                vp_main.currentItem=1
                tv_home.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_home=resources.getDrawable(R.mipmap.tabbar_homepage_nor)
                draw_home.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_home.setCompoundDrawables(null,draw_home,null,null)

                tv_type.setTextColor(Color.parseColor("#D3AA71"))
                var draw_type=resources.getDrawable(R.mipmap.tabbar_classification_sel)
                draw_type.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_type.setCompoundDrawables(null,draw_type,null,null)

                tv_order.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_order=resources.getDrawable(R.mipmap.tabbar_order_nor)
                draw_order.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_order.setCompoundDrawables(null,draw_order,null,null)

                tv_mine.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_mine=resources.getDrawable(R.mipmap.tabbar_mine_nor)
                draw_mine.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_mine.setCompoundDrawables(null,draw_mine,null,null)

            }

            3 ->{
                vp_main.currentItem=2
                tv_home.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_home=resources.getDrawable(R.mipmap.tabbar_homepage_nor)
                draw_home.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_home.setCompoundDrawables(null,draw_home,null,null)

                tv_type.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_type=resources.getDrawable(R.mipmap.tabbar_classification_nor)
                draw_type.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_type.setCompoundDrawables(null,draw_type,null,null)

                tv_order.setTextColor(Color.parseColor("#D3AA71"))
                var draw_order=resources.getDrawable(R.mipmap.tabbar_order_sel)
                draw_order.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_order.setCompoundDrawables(null,draw_order,null,null)

                tv_mine.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_mine=resources.getDrawable(R.mipmap.tabbar_mine_nor)
                draw_mine.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_mine.setCompoundDrawables(null,draw_mine,null,null)

            }

            4 ->{
                vp_main.currentItem=3

                tv_home.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_home=resources.getDrawable(R.mipmap.tabbar_homepage_nor)
                draw_home.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_home.setCompoundDrawables(null,draw_home,null,null)

                tv_type.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_type=resources.getDrawable(R.mipmap.tabbar_classification_nor)
                draw_type.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_type.setCompoundDrawables(null,draw_type,null,null)

                tv_order.setTextColor(Color.parseColor("#CCCCCC"))
                var draw_order=resources.getDrawable(R.mipmap.tabbar_order_nor)
                draw_order.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_order.setCompoundDrawables(null,draw_order,null,null)

                tv_mine.setTextColor(Color.parseColor("#D3AA71"))
                var draw_mine=resources.getDrawable(R.mipmap.tabbar_mine_sel)
                draw_mine.setBounds(0,0,draw_home.minimumWidth,draw_home.minimumHeight)
                tv_mine.setCompoundDrawables(null,draw_mine,null,null)

            }
        }
    }


    interface MyTouchListener {
        /** onTouchEvent的实现  */
        fun onTouchEvent(event: MotionEvent): Boolean
    }

    /** 保存MyTouchListener接口的列表  */
    private val myTouchListeners = ArrayList<MyTouchListener>()

    /** 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法  */
    fun registerMyTouchListener(listener: MyTouchListener) {
        myTouchListeners.add(listener)
    }

    /** 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法  */
    fun unRegisterMyTouchListener(listener: MyTouchListener) {
        myTouchListeners.remove(listener)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        for (listener in myTouchListeners) {
            listener.onTouchEvent(ev)
        }
        return super.dispatchTouchEvent(ev)
    }
}