package yongchao.com.wineapp.ui.main.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.main.mvp.bean.BannerBean

interface HomeView:BaseView{

    fun getBannerRequest(data: BannerBean)
    fun getBannerError()
}