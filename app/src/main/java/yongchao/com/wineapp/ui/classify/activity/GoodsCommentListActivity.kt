package yongchao.com.wineapp.ui.classify.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_goods_comment_list.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.classify.adapter.GoodsCommentListAdapter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsCommentListBody
import yongchao.com.wineapp.ui.classify.mvp.presenter.GoodsCommentListPresenter
import yongchao.com.wineapp.ui.classify.mvp.view.GoodsCommentListView
import yongchao.com.wineapp.utils.Click

class GoodsCommentListActivity:BaseActivity() ,GoodsCommentListView{
    override fun getGoodsCommentListRequest(data: GoodsCommentListBean) {
        tv_title.text="全部评价"+"("+data.data.totalRecord+")"

        if (pageIndex==1){
            adapter=GoodsCommentListAdapter(data.data.list)
            var manager=LinearLayoutManager(this)
            manager.orientation=LinearLayout.VERTICAL
            recy.layoutManager=manager
            recy.adapter=adapter
        }else{
            adapter.addData(data.data.list)
        }

        adapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex=pageIndex+1
                presenter.getGoodsComment(GoodsCommentListBody(intent.getStringExtra("id"),pageIndex,pageSize))
            }
        },recy)

        if (data.data.list.size<10){
            adapter.loadMoreEnd()
        }else{
            adapter.loadMoreComplete()
        }

    }

    override fun getGoodsCommentListError() {

    }

    private val presenter by lazy { GoodsCommentListPresenter(this,this,this) }

    private lateinit var adapter:GoodsCommentListAdapter
    private var pageIndex=1
    private var pageSize=10

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_goods_comment_list

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        presenter.getGoodsComment(GoodsCommentListBody(intent.getStringExtra("id"),pageIndex,pageSize))

    }

    override fun clickListener() {

        Click.viewClick(back).subscribe {
            finish()
        }

    }


}