package yongchao.com.wineapp.ui.classify.activity


import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import com.androidkun.xtablayout.XTabLayout
import kotlinx.android.synthetic.main.activity_details.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.classify.adapter.GoodsCommentListAdapter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsDetailsBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsCommentListBody
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsDetailsBody
import yongchao.com.wineapp.ui.classify.mvp.presenter.GoodsDetaisPresenter
import yongchao.com.wineapp.ui.classify.mvp.view.GoodsDetailsView
import yongchao.com.wineapp.ui.image.ImageBrowseAdapter
import yongchao.com.wineapp.ui.image.ImageBrowseInfo
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils
import yongchao.com.wineapp.utils.view.scrollview.SizeUtils
import java.util.*
import android.support.v4.view.ViewCompat.getMinimumHeight
import android.support.v4.view.ViewCompat.getMinimumWidth
import android.graphics.drawable.Drawable



class GoodsDetailsActivity:BaseActivity() , ViewPager.OnPageChangeListener,GoodsDetailsView{
    override fun getGoodsCommentListRequest(data: GoodsCommentListBean) {

        if (data.data.totalRecord>0){
            hascomment.visibility=View.VISIBLE
            nocomment.visibility=View.GONE
            var adapter= GoodsCommentListAdapter(data.data.list)
            var manager= LinearLayoutManager(this)
            manager.orientation= LinearLayout.VERTICAL
            recy_comment.layoutManager=manager
            recy_comment.adapter=adapter
        }else{
            hascomment.visibility=View.GONE
            nocomment.visibility=View.VISIBLE
        }

    }

    override fun getGoodsCommentListRequest() {

    }

    override fun getGoodsDetailsRequest(data: GoodsDetailsBean) {
        var list=ArrayList<String>()
        list.add("商品")
        list.add("评价")
        list.add("详情")

        list.forEach {
            tab.addTab(tab.newTab().setText(it))
        }

        val views = LinkedList<View>()
        views.add(goods)
        views.add(comment)
        views.add(details)
        scrollView.setAnchorList(views) // 设置视图集合

        scrollView.setupWithTabLayout(tab)

        data.data.images.forEach {
            images.add(ImageBrowseInfo(it,false,0))
        }
        adapter = ImageBrowseAdapter(images)
        vp_goods.adapter = adapter

        tv_goods_page_num.text="1/"+images.size

        vp_goods.setOnPageChangeListener(this)



//        var str="<p><img src=\"https://img.alicdn.com/imgextra/i2/859665208/O1CN01VdsNqS1oLJIJmGfcj_!!859665208.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\"><img src=\"https://img.alicdn.com/imgextra/i1/859665208/O1CN01P9ZnvS1oLJIUXIu9z_!!859665208.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\"><img src=\"https://img.alicdn.com/imgextra/i3/859665208/O1CN01WChqnQ1oLJITXQAEY_!!859665208.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\"><img src=\"https://img.alicdn.com/imgextra/i2/859665208/O1CN01VQnVX51oLJIPklJPy_!!859665208.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\"> </p>\n"
//        var str = data.data.details.replace("<img", "<img style=\"display:        ;max-width:100%;\"");
//        web.loadDataWithBaseURL(null,str,"text/html","utf-8",null)
//        web.getSettings().setUseWideViewPort    (true);//将图片调整到适合webView的大小
        web.loadUrl(data.data.details)
        web.getSettings().setLoadWithOverviewMode(true);//缩放至屏幕大小

        tv_goods_name.text=data.data.goodsName
        tv_price.text=data.data.sellingPrice.toString()
        tv_original_price.text=data.data.price.toString()
        tv_original_price.getPaint().setFlags( Paint.STRIKE_THRU_TEXT_FLAG and Paint.ANTI_ALIAS_FLAG )
        tv_unit.text=data.data.specValue.toString()+data.data.spec+"*1"+data.data.unit
        if (data.data.isIsFavorite){
            val drawable = resources.getDrawable(R.mipmap.tabbar_button_collection_pre)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight) //设置边界
            tv_collect.setCompoundDrawables(drawable, null, null, null)//画在右边
            tv_collect.setTextColor(Color.parseColor("#F88275"))
        }else{
            val drawable = resources.getDrawable(R.mipmap.tabbar_button_collection_sel)
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight) //设置边界
            tv_collect.setCompoundDrawables(drawable, null, null, null)//画在右边
            tv_collect.setTextColor(Color.parseColor("#FF222222"))
        }

    }

    override fun getGoodsDetailsError() {

    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(p0: Int) {
        tv_goods_page_num.text = (p0 + 1).toString() + "/" + images.size
    }

    private var images = ArrayList<ImageBrowseInfo>()
    private lateinit var adapter: ImageBrowseAdapter

    private var flag=true
    private var flag2=true

    private val presenter by lazy { GoodsDetaisPresenter(this,this,this) }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_details

    override fun setActivityTitle() {

    }
    override fun initActivityData() {

        presenter.getGoodsDetails(GoodsDetailsBody(intent.getStringExtra("id")))

        presenter.getGoodsCommnet(GoodsCommentListBody(intent.getStringExtra("id"),1,3))
    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(tv_comment).subscribe {
            intentUtils.intentGoodsCommentList(intent.getStringExtra("id"))
        }

//        scroll.setOnTouchListener { v, event ->
//            //            if (event.action==MotionEvent.ACTION_DOWN){
//            flag2=false
//            flag=true
////            }
//            Log.e("测试","scroll触摸了")
//            return@setOnTouchListener false
//        }


//        scroll.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener{
//            override fun onScrollChange(p0: NestedScrollView?, x: Int, scrollY: Int, p3: Int, oldScrollY: Int) {
//                if (flag&&!flag2) {
//                    Log.e("测试", "滑动到+"+scroll.getScrollY())
//                    Log.e("测试", "评论高度+"+layout_comment.getTop())
//                    Log.e("测试", "详情高度+"+tv_details.getTop())
//                    var s=scroll.getChildAt(0).getMeasuredHeight()-scroll.getMeasuredHeight()
//                    tagFlag = true
//                    if (scrollY > oldScrollY) {
//                        if (scrollY >= layout_comment.getTop() && scrollY < tv_details.getTop()) {
//                            Log.e("测试", "滑动到评论")
//                            refreshContent2NavigationFlag(1)
//                        } else if (scrollY >= tv_details.getTop()) {
//                            Log.e("测试", "滑动到详情")
//                            refreshContent2NavigationFlag(2)
//                        } else {
//                            Log.e("测试", "滑动到顶部")
//                            refreshContent2NavigationFlag(0)
//                        }
//                    }
//                }
//
//
//            }
//
//        })

    }

    /**
     * 是否是ScrollView主动动作
     * false:是ScrollView主动动作
     * true:是TabLayout 主动动作
     */
    private var tagFlag = false
    /**
     * 用于切换内容模块，相应的改变导航标签，表示当一个所处的位置
     */
    private var lastTagIndex = 0
    /**
     * 用于在同一个内容模块内滑动，锁定导航标签，防止重复刷新标签
     * true: 锁定
     * false ; 没有锁定
     */
    private var content2NavigateFlagInnerLock = false


    /**
     * 刷新标签
     *
     * @param currentTagIndex 当前模块位置
     */
    fun refreshContent2NavigationFlag(currentTagIndex:Int) {
        // 上一个位置与当前位置不一致是，解锁内部锁，是导航可以发生变化
        if (lastTagIndex != currentTagIndex) {
            content2NavigateFlagInnerLock = false
        }
        if (!content2NavigateFlagInnerLock) {
            // 锁定内部锁
            content2NavigateFlagInnerLock = true
            // 动作是由ScrollView触发主导的情况下，导航标签才可以滚动选中
            if (tagFlag) {
                tab.setScrollPosition(currentTagIndex, 0f, true)
            }
            lastTagIndex = currentTagIndex
            flag=false
        }

    }


}