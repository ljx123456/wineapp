package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.CollectListBean
import yongchao.com.wineapp.ui.set.mvp.body.CollectListBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class CollectListData(val list:CollectList): BaseData<CollectListBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getCollectList(body:CollectListBody){
        api(Api.getApi().getCollectList(body)).build()
    }

    override fun onSucceedRequest(data: CollectListBean, what: Int) {
        list.getCollectListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        list.getCollectListError()
    }


    interface CollectList{
        fun getCollectListRequest(data:CollectListBean)
        fun getCollectListError()
    }
}