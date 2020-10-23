package yongchao.com.wineapp.ui.classify.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_classify_goods.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.ui.classify.adapter.ClassifyAdapter
import yongchao.com.wineapp.ui.classify.adapter.SearchGoodsAdapter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsListBody
import yongchao.com.wineapp.ui.classify.mvp.presenter.GoodsListPresenter
import yongchao.com.wineapp.ui.classify.mvp.view.ClassifyGoodsView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils
import yongchao.com.wineapp.ui.main.activity.MainActivity
import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean


@SuppressLint("ValidFragment")
class ClassifyGoodsFragment(val data:GoodsTypeBean.DataBean):BaseFragment(),ClassifyGoodsView {
    override fun getGoodsListRequest(dat: GoodsListBean) {
        if (pageIndex==1) {
            goodsAdapter = SearchGoodsAdapter(dat.data)
            var manage = GridLayoutManager(mContext, 2)
            recy.layoutManager = manage
            recy.adapter = goodsAdapter
            recy.smoothScrollToPosition(0)
        }else{
            goodsAdapter.addData(dat.data)
        }

        goodsAdapter.setOnLoadMoreListener(object :BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                val body=GoodsListBody()
                body.goodsTypeId=data.id
                body.goodsChildTypeId=data.children[position].id
                body.sortType=sort
                body.pageIndex=pageIndex
                body.pageSize=10
                presenter.getGoodList(body)
            }
        },recy)

        if (dat.data.size<10){
            goodsAdapter.loadMoreEnd()
            flag=false
        }else{
            goodsAdapter.loadMoreComplete()
            flag=true
        }

        goodsAdapter.setOnItemClickListener { mAdapter, view, position ->
            intentUtils.intentGoodsDetails(goodsAdapter.data[position].goodsId.toString())
        }
    }

    override fun getGoodsListError() {

    }

    private lateinit var adapter:ClassifyAdapter
    private lateinit var goodsAdapter: SearchGoodsAdapter
    private var sort=0
    private var pageIndex=1
    private val presenter by lazy { GoodsListPresenter(this,this,activity!!) }


    private var position=0
    private var flag=true
    var fla=false

    private lateinit var gestureDetector:GestureDetector

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {
        /** 触摸事件的注册 */
        (this.activity as MainActivity).registerMyTouchListener(myTouchListener)
        gestureDetector = GestureDetector(mContext, MyGestureListener())
    }

    override fun initFragmentData() {

//        when(type){
//            "啤酒"->{
////                var ada
//                get()
//            }
//
//            "葡萄酒"->{
////                var ada
//                get()
//            }
//
//            "洋酒"->{
////                var ada
//                get()
//            }
//
//
//        }
        get()
    }

    override fun setFragmentListener() {

        Click.viewClick(tv_all).subscribe {
            if (sort!=0){
                sort=0
                tv_all.setTextColor(Color.parseColor("#D3AA71"))
                tv_price.setTextColor(Color.parseColor("#888888"))
                var nav_up=getResources().getDrawable(R.mipmap.topnav_icon_sort_nor)
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight())
                tv_price.setCompoundDrawables(null, null, nav_up, null)

                val body=GoodsListBody()
                body.goodsTypeId=data.id
                body.goodsChildTypeId=data.children[position].id
                body.sortType=sort
                body.pageIndex=pageIndex
                body.pageSize=10
                presenter.getGoodList(body)
            }
        }

        Click.viewClick(tv_price).subscribe {
            if (sort!=0) {
                if (sort == 1) {
                    sort = 2
                    var nav_up=getResources().getDrawable(R.mipmap.topnav_icon_sort_drop)
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight())
                    tv_price.setCompoundDrawables(null, null, nav_up, null)
                }else{
                    sort=1
                    var nav_up=getResources().getDrawable(R.mipmap.topnav_icon_sort_rise)
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight())
                    tv_price.setCompoundDrawables(null, null, nav_up, null)
                }
            }else{
                sort=1
                tv_all.setTextColor(Color.parseColor("#888888"))
                tv_price.setTextColor(Color.parseColor("#D3AA71"))
                var nav_up=getResources().getDrawable(R.mipmap.topnav_icon_sort_rise)
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight())
                tv_price.setCompoundDrawables(null, null, nav_up, null)
            }
            pageIndex=1
            val body=GoodsListBody()
            body.goodsTypeId=data.id
            body.goodsChildTypeId=data.children[position].id
            body.sortType=sort
            body.pageIndex=pageIndex
            body.pageSize=10
            presenter.getGoodList(body)
        }

//        recy.addOnScrollListener(object :RecyclerView.OnScrollListener(){
//            var mScrollThreshold=0
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                var isSignificantDelta = Math.abs(dy) > mScrollThreshold
//                if(recy.canScrollVertically(1)){
//                    fla=false
//                }else {//滑动到底部
//                    if (isSignificantDelta&&fla) {
//                        if (dy > 50) {
//                            if (!flag) {
//                                if (position < 11) {
//                                    fla=false
//                                    position = position + 1
//                                    adapter.data.forEachIndexed { index, dataBean ->
//                                        if (index == position) {
//                                            adapter.data[position].flag = true
//                                        } else {
//                                            adapter.data[index].flag = false
//                                        }
//                                    }
//                                    adapter.notifyDataSetChanged()
//                                    lv.smoothScrollToPosition(position)
//                                    pageIndex = 1
//                                    getData()
//                                }
//                            }
//                        } else {
//
//                        }
//                    }
//                    fla=true
//                }
//
//                super.onScrolled(recyclerView, dx, dy)
//            }
//        })

    }

    override fun layoutID(): Int = R.layout.fragment_classify_goods

    fun get(){
//        var list=ArrayList<ClassifyBean.DataBean>()
//        list.add(ClassifyBean.DataBean("百威",1,true))
//        list.add(ClassifyBean.DataBean("雪花",2,false))
//        list.add(ClassifyBean.DataBean("科罗娜",3,false))
//        list.add(ClassifyBean.DataBean("乐堡",4,false))
//        list.add(ClassifyBean .DataBean("嘉士伯",5,false))
//        list.add(ClassifyBean.DataBean("1664",6,false))
//        list.add(ClassifyBean.DataBean("百威",1,false))
//        list.add(ClassifyBean.DataBean("雪花",2,false))
//        list.add(ClassifyBean.DataBean("科罗娜",3,false))
//        list.add(ClassifyBean.DataBean("乐堡",4,false))
//        list.add(ClassifyBean.DataBean("嘉士伯",5,false))
//        list.add(ClassifyBean.DataBean("1664",6,false))

        adapter=ClassifyAdapter(data.children)
        var manager=LinearLayoutManager(mContext)
        manager.orientation=LinearLayout.VERTICAL
        lv.layoutManager=manager
        lv.adapter=adapter
        pageIndex=1

        val body=GoodsListBody()
        body.goodsTypeId=data.id
        body.goodsChildTypeId=data.children[0].id
        body.sortType=sort
        body.pageIndex=pageIndex
        body.pageSize=10
        presenter.getGoodList(body)

        adapter.setOnItemClickListener { mAdapter, view, posi ->

            this.position=posi
            adapter.data.forEachIndexed { index, dataBean ->
                if (index==posi){
                    adapter.data[posi].isFlag=true
                }else{
                    adapter.data[index].isFlag=false
                }
            }
            adapter.notifyDataSetChanged()
            lv.smoothScrollToPosition(position)
            pageIndex=1
            sort=0
            val body=GoodsListBody()
            body.goodsTypeId=data.id
            body.goodsChildTypeId=data.children[position].id
            body.sortType=sort
            body.pageIndex=pageIndex
            body.pageSize=10
            presenter.getGoodList(body)

        }

//        recy.setOnTouchListener(object :View.OnTouchListener{
//            override fun onTouch(v: View, event: MotionEvent): Boolean {
//                var downy=0f
//                var move=0f
//                when(event.action){
//                    MotionEvent.ACTION_DOWN->{
//                        downy=event.getY();
//                    }
//                    MotionEvent.ACTION_MOVE->{
//                        move=downy-event.getY()
//                        if (move > 15&&!flag) {
//                            Log.e("测试", "向上滑...")
//                        }
//                    }
//                }
//
//                return false
//            }
//        })

//        var mDetector=GestureDetector(activity,object :GestureDetector.OnGestureListener{
//            override fun onShowPress(e: MotionEvent?) {
//
//            }
//
//            override fun onSingleTapUp(e: MotionEvent?): Boolean {
//                return false
//            }
//
//            override fun onDown(e: MotionEvent?): Boolean {
//                return false
//            }
//
//            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
//                if (e1.getY() - e2.getY() > 15&&!flag) {
//                    Log.e("测试", "向上滑...")
//
//                    return true
//                }
//                return false
//            }
//
//            override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
//                return false
//            }
//
//            override fun onLongPress(e: MotionEvent?) {
//
//            }
//        })

    }



    /**
     * 自定义手势监听接口
     */
    internal inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            if (e1.y - e2.y > 500) {
                Log.e("滑动","${e1.y - e2.y}")
                if (!flag){
                    if (position<11) {
                        position=position+1
                        adapter.data.forEachIndexed { index, dataBean ->
                            if (index == position) {
                                adapter.data[position].isFlag = true
                            } else {
                                adapter.data[index].isFlag = false
                            }
                        }
                        adapter.notifyDataSetChanged()
                        lv.smoothScrollToPosition(position)
                        pageIndex = 1
                        val body=GoodsListBody()
                        body.goodsTypeId=data.id
                        body.goodsChildTypeId=data.children[position].id
                        body.sortType=sort
                        body.pageIndex=pageIndex
                        body.pageSize=10
                        presenter.getGoodList(body)
                    }
                }
            } else if (e1.y - e2.y < 20) {

            }
            return true
        }
    }

    /** 接收MainActivity的Touch回调的对象，重写其中的onTouchEvent函数  */
    var myTouchListener: MainActivity.MyTouchListener = object : MainActivity.MyTouchListener {
        override fun onTouchEvent(event: MotionEvent): Boolean {
            //处理手势事件（根据个人需要去返回和逻辑的处理）
            return gestureDetector.onTouchEvent(event)
        }
    }

}