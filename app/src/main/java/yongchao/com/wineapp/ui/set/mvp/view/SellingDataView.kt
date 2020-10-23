package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.SellingDataBean

interface SellingDataView:BaseView{
    fun getSellingDataRequest(data:SellingDataBean)
    fun getSellingDataError()
}