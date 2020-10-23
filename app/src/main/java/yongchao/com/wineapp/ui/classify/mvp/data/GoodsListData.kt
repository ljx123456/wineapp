package yongchao.com.wineapp.ui.classify.mvp.data

import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsListBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class GoodsListData(val list:GoodsList): BaseData<GoodsListBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getGoodsList(body:GoodsListBody){
        api(Api.getApi().getGoodsList(body)).build()
    }

    override fun onSucceedRequest(data: GoodsListBean, what: Int) {
        list.getGoodsListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        list.getGoodsListError()
    }


    interface GoodsList{
        fun getGoodsListRequest(data:GoodsListBean)
        fun getGoodsListError()
    }
}