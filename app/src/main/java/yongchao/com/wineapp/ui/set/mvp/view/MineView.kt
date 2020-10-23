package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.UserInfoBean

interface MineView:BaseView{
    fun getUserInfoRequest(data:UserInfoBean)
    fun getUserInfoError()

}