package yongchao.com.wineapp.ui.classify.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean

interface GoodsCommentListView:BaseView{
    fun getGoodsCommentListRequest(data:GoodsCommentListBean)
    fun getGoodsCommentListError()

}