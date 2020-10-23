package yongchao.com.wineapp.ui.main.mvp.view

import yongchao.com.wineapp.base.BaseView


interface QiniuView: BaseView {
    fun sendSucceedImage(fileUrlList: ArrayList<String>)
    fun sendFileErrorImage()
}