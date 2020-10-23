package yongchao.com.wineapp.ui.classify.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsDetailsBean

interface GoodsDetailsView:BaseView{

    fun getGoodsDetailsRequest(data:GoodsDetailsBean)
    fun getGoodsDetailsError()

    fun getGoodsCommentListRequest(data:GoodsCommentListBean)
    fun getGoodsCommentListRequest()

}