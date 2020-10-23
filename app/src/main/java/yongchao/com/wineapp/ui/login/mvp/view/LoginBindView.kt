package yongchao.com.wineapp.ui.login.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBindBean

interface LoginBindView:BaseView{

    fun getLoginBindRequest(data:LoginBindBean)
    fun getLoginBindError()
}