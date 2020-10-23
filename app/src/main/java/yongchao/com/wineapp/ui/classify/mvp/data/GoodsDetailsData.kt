package yongchao.com.wineapp.ui.classify.mvp.data

import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsDetailsBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsDetailsBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class GoodsDetailsData(val details:GoodsDetails): BaseData<GoodsDetailsBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getGoodsDetails(body: GoodsDetailsBody){
        api(Api.getApi().getGoodsDetails(body)).build()
    }

    override fun onSucceedRequest(data: GoodsDetailsBean, what: Int) {
        details.getGoodsDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        details.getGoodsDetailsError()
    }


    interface GoodsDetails{
        fun getGoodsDetailsRequest(data:GoodsDetailsBean)
        fun getGoodsDetailsError()
    }
}