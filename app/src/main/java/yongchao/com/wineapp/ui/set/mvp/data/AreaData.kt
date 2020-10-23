package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.AreaBean
import yongchao.com.wineapp.ui.set.mvp.body.AreaBody
import yongchao.com.wineapp.utils.Toast
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class AreaData(val area:Area): BaseData<AreaBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getArea(body: AreaBody){
        api(Api.getApi().getArea(body)).build()
    }

    override fun onSucceedRequest(data: AreaBean, what: Int) {
        area.getAreaRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        Toast.Tips(msg)
        area.getAreaError()
    }

    interface Area{
        fun getAreaRequest(data: AreaBean)
        fun getAreaError()
    }
}