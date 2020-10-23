package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.CollectListBean

interface CollectView:BaseView{
    fun getCollectListRequest(data:CollectListBean)
    fun getCollectListError()
}