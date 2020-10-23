package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.DelAddressBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class DelAddressData(val del:DelAddress): BaseData<SuccessBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getDelAddress(body: DelAddressBody){
        api(Api.getApi().getDelAddress(body)).build()
    }

    override fun onSucceedRequest(data: SuccessBean, what: Int) {
        del.getDelAddressRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        del.getDelAddressError()
    }


    interface DelAddress{
        fun getDelAddressRequest(data: SuccessBean)
        fun getDelAddressError()
    }
}