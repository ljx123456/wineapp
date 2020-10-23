package yongchao.com.wineapp.ui.main.mvp.data

import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class GoodsTypeData(val type:GoodsType): BaseData<GoodsTypeBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getGoodsType(){
        api(Api.getApi().getGoodsType()).build()
    }

    override fun onSucceedRequest(data: GoodsTypeBean, what: Int) {
        type.getGoodsTypeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        type.getGoodsTypeError()
    }


    interface GoodsType{
        fun getGoodsTypeRequest(data:GoodsTypeBean)
        fun getGoodsTypeError()
    }
}