package yongchao.com.wineapp.ui.order.mvp.data

import yongchao.com.wineapp.ui.order.mvp.bean.OrderListBean
import yongchao.com.wineapp.ui.order.mvp.body.OrderListBody
import yongchao.com.wineapp.utils.Toast
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class OrderListData(val list:OrderList): BaseData<OrderListBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getOrderList(body: OrderListBody){
        api(Api.getApi().getOrderList(body)).build()
    }

    override fun onSucceedRequest(data: OrderListBean, what: Int) {
        list.getOrderListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        Toast.Tips(msg)
        list.getOrderListError()
    }

    interface OrderList{
        fun getOrderListRequest(data: OrderListBean)
        fun getOrderListError()
    }
}