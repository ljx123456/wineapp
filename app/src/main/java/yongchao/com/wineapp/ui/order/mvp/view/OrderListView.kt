package yongchao.com.wineapp.ui.order.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.order.mvp.bean.OrderListBean

interface OrderListView:BaseView{
    fun getOrderListRequest(data:OrderListBean)
    fun getOrderListError()
}