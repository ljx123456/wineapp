package yongchao.com.wineapp.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.order.mvp.bean.OrderListBean
import yongchao.com.wineapp.ui.order.mvp.body.OrderListBody
import yongchao.com.wineapp.ui.order.mvp.data.OrderListData
import yongchao.com.wineapp.ui.order.mvp.view.OrderListView
import java.util.ArrayList

class OrderListPresenter(owner: LifecycleOwner, val view: OrderListView, val mContext: Context) : BasePresenter(owner, view, mContext),OrderListData.OrderList {

    private val order=OrderListData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        order.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getOrderList(body:OrderListBody){
        order.getOrderList(body)
    }

    override fun getOrderListRequest(data: OrderListBean) {
        view.getOrderListRequest(data)
    }

    override fun getOrderListError() {
        view.getOrderListError()
    }
}