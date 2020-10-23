package yongchao.com.wineapp.ui.login.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean

interface LoginCodeView:BaseView{
    fun getLoginCodeRequest(data:LoginBean)
    fun getLoginCodeError()
}