package yongchao.com.wineapp.ui.order.fragment

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_order_list.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.ui.order.adapter.OrderListAdapter
import yongchao.com.wineapp.ui.order.mvp.bean.OrderListBean
import yongchao.com.wineapp.ui.order.mvp.body.OrderListBody
import yongchao.com.wineapp.ui.order.mvp.presenter.OrderListPresenter
import yongchao.com.wineapp.ui.order.mvp.view.OrderListView
import yongchao.com.wineapp.utils.intent.intentUtils

@SuppressLint("ValidFragment")
class OrderListFragment(val type:String):BaseFragment() ,OrderListView{
    override fun getOrderListRequest(data: OrderListBean) {
        swip.isRefreshing=false
        if (pageIndex==1&&data.data.size>0) {
            adapter = OrderListAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            recy.layoutManager = manager
            recy.adapter = adapter
        }else{
            adapter.addData(data.data)
        }
        adapter.setOnItemChildClickListener { mAdapter, view, position ->

            when(view.id){

                R.id.btn_comment ->{

                }

            }

        }

        adapter.setOnLoadMoreListener(object :BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex=pageIndex+1
                when(type){//筛选：-1 全部，0 待付款，1待配送，2 配送中，3 已完成

                    "全部" ->{
                        presenter.getOrderList(OrderListBody(-1,pageIndex,pageSize))
                    }

                    "待付款" ->{
                        presenter.getOrderList(OrderListBody(0,pageIndex,pageSize))
                    }

                    "待配送" ->{
                        presenter.getOrderList(OrderListBody(1,pageIndex,pageSize))
                    }

                    "配送中" ->{
                        presenter.getOrderList(OrderListBody(2,pageIndex,pageSize))
                    }

                    "已完成" ->{
                        presenter.getOrderList(OrderListBody(3,pageIndex,pageSize))
                    }

                }
            }
        },recy)

        if (data.data.size<10){
            adapter.loadMoreEnd()
        }else{
            adapter.loadMoreComplete()
        }

        adapter.setOnItemClickListener { mAdapter, view, position ->
            intentUtils.intentOrderDetails()
        }



    }

    override fun getOrderListError() {
        swip.isRefreshing=false
    }

    private lateinit var adapter:OrderListAdapter
    private val presenter by lazy { OrderListPresenter(this,this,activity!!) }
    private var pageIndex=1
    private var pageSize=10

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
        when(type){//筛选：-1 全部，0 待付款，1待配送，2 配送中，3 已完成

            "全部" ->{
                presenter.getOrderList(OrderListBody(-1,pageIndex,pageSize))
            }

            "待付款" ->{
                presenter.getOrderList(OrderListBody(0,pageIndex,pageSize))
            }

            "待配送" ->{
                presenter.getOrderList(OrderListBody(1,pageIndex,pageSize))
            }

            "配送中" ->{
                presenter.getOrderList(OrderListBody(2,pageIndex,pageSize))
            }

            "已完成" ->{
                presenter.getOrderList(OrderListBody(3,pageIndex,pageSize))
            }

        }
    }

    override fun setFragmentListener() {

        swip.setOnRefreshListener {
            pageIndex=1
            when(type){//筛选：-1 全部，0 待付款，1待配送，2 配送中，3 已完成

                "全部" ->{
                    presenter.getOrderList(OrderListBody(-1,pageIndex,pageSize))
                }

                "待付款" ->{
                    presenter.getOrderList(OrderListBody(0,pageIndex,pageSize))
                }

                "待配送" ->{
                    presenter.getOrderList(OrderListBody(1,pageIndex,pageSize))
                }

                "配送中" ->{
                    presenter.getOrderList(OrderListBody(2,pageIndex,pageSize))
                }

                "已完成" ->{
                    presenter.getOrderList(OrderListBody(3,pageIndex,pageSize))
                }

            }
        }

    }

    override fun layoutID(): Int = R.layout.fragment_order_list



}