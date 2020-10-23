package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean

interface AddAddressView:BaseView{

    fun getAddAddressRequest(data: SuccessBean)
    fun getAddAddressError()
}