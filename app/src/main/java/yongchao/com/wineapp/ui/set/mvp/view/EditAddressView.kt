package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean

interface EditAddressView:BaseView{

    fun getEditAddressRequest(data: SuccessBean)
    fun getEditAddressError()

    fun getDelAddressRequest(data: SuccessBean)
    fun getDelAddressError()
}