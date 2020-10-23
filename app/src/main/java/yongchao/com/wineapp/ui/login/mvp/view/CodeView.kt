package yongchao.com.wineapp.ui.login.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.login.mvp.data.CodeData

interface CodeView:BaseView{
    fun getCodeRequest(data:CodeData)
    fun getCodeError()
}