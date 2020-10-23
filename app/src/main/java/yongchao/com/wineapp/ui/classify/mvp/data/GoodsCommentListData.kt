package yongchao.com.wineapp.ui.classify.mvp.data

import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsCommentListBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class GoodsCommentListData(val list:GoodsCommentList): BaseData<GoodsCommentListBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getGoodsCommentList(body: GoodsCommentListBody){
        api(Api.getApi().getGoodsCommentList(body)).build()
    }

    override fun onSucceedRequest(data: GoodsCommentListBean, what: Int) {
        list.getGoodsCommentListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        list.getGoodsCommentListError()
    }


    interface GoodsCommentList{
        fun getGoodsCommentListRequest(data:GoodsCommentListBean)
        fun getGoodsCommentListError()
    }
}