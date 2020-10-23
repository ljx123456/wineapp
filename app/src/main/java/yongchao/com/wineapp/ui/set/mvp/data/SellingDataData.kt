package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.SellingDataBean
import yongchao.com.wineapp.ui.set.mvp.body.SellingDataBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class SellingDataData(val data:SellingData): BaseData<SellingDataBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getSellingData(body:SellingDataBody){
        api(Api.getApi().getSellingData(body)).build()
    }

    override fun onSucceedRequest(dat: SellingDataBean, what: Int) {
        data.getSellingDataRequest(dat)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        data.getSellingDataError()
    }


    interface SellingData{
        fun getSellingDataRequest(data:SellingDataBean)
        fun getSellingDataError()
    }
}