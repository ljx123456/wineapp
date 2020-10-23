package yongchao.com.wineapp.ui.set.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_collect.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.adapter.CollectListAdapter
import yongchao.com.wineapp.ui.set.mvp.bean.CollectListBean
import yongchao.com.wineapp.ui.set.mvp.body.CollectListBody
import yongchao.com.wineapp.ui.set.mvp.presenter.CollectPresenter
import yongchao.com.wineapp.ui.set.mvp.view.CollectView
import yongchao.com.wineapp.utils.Click

class CollectActivity:BaseActivity() ,CollectView{
    override fun getCollectListRequest(data: CollectListBean) {
        swip.isRefreshing=false
        if (pageIndex==1&&data.data.size>0){
            adapter= CollectListAdapter(data.data)
            var manager= LinearLayoutManager(mContext)
            manager.orientation= LinearLayout.VERTICAL
            recy.layoutManager=manager
            recy.adapter=adapter
        }else{
            adapter.addData(data.data)
        }

        adapter.setOnLoadMoreListener(object :BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex=pageIndex+1
                presenter.getCollectList(CollectListBody(pageIndex,pageSize))
            }
        },recy)

        if (data.data.size<10){
            adapter.loadMoreEnd()
        }else{
            adapter.loadMoreComplete()
        }


    }

    override fun getCollectListError() {

    }

    private val presenter by lazy { CollectPresenter(this,this,this) }
    private var pageIndex=1
    private var pageSize=10
    private lateinit var adapter:CollectListAdapter

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_collect

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        presenter.getCollectList(CollectListBody(pageIndex,pageSize))
    }

    override fun clickListener() {

        Click.viewClick(back).subscribe {
            finish()
        }

        swip.setOnRefreshListener {
            pageIndex=1
            presenter.getCollectList(CollectListBody(pageIndex,pageSize))
        }

    }
}