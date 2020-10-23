package yongchao.com.wineapp.ui.main.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean

interface ClassifyView:BaseView{

    fun getGoodsTypeRequest(data:GoodsTypeBean)
    fun getGoodsTypeError()
}