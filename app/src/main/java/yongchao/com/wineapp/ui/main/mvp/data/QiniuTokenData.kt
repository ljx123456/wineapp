package yongchao.com.wineapp.ui.main.mvp.data

import yongchao.com.wineapp.ui.main.mvp.bean.QiniuTokenBean
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo


class QiniuTokenData(val qiniutoken: QiniuToken) : BaseData<QiniuTokenBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getQiniuToken() {
        api(Api.getApi().getQiniuToken()).build()
    }

    override fun onSucceedRequest(data: QiniuTokenBean, what: Int) {
        qiniutoken.getQiniuTokenRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        qiniutoken.getQiniuTokenError()
    }

    interface QiniuToken {
        fun getQiniuTokenRequest(data: QiniuTokenBean)
        fun getQiniuTokenError()
    }
}