package yongchao.com.wineapp.ui.main.mvp.data

import yongchao.com.wineapp.ui.main.mvp.bean.BannerBean
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class BannerData(val banner:Banner): BaseData<BannerBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getBanner(){
        api(Api.getApi().getBanner()).build()
    }

    override fun onSucceedRequest(data: BannerBean, what: Int) {
        banner.getBannerRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        banner.getBannerError()
    }


    interface Banner{
        fun getBannerRequest(data:BannerBean)
        fun getBannerError()
    }
}