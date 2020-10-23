package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.AddressListBean

interface MyAddressView:BaseView{

    fun getAddressListRequest(data:AddressListBean)
    fun getAddressListError()
}