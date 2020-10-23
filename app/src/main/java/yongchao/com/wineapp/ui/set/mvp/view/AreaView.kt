package yongchao.com.wineapp.ui.set.mvp.view

import yongchao.com.wineapp.base.BaseView
import yongchao.com.wineapp.ui.set.mvp.bean.AreaBean

interface AreaView: BaseView {
    fun getAreaRequest(data: AreaBean)
    fun getAreaError()
}