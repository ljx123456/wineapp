package yongchao.com.wineapp.ui.classify.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean

interface ClassifyGoodsView:BaseView{
    fun getGoodsListRequest(data:GoodsListBean)
    fun getGoodsListError()
}