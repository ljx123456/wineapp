package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean

interface EditUserInfoView:BaseView{
    fun getEditUserInfoRequest(data:SuccessBean)
    fun getEditUserInfoError()
}