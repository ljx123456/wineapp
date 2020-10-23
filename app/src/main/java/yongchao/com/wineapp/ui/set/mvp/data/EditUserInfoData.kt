package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.EditUserInfoBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class EditUserInfoData(val info:EditUserInfo): BaseData<SuccessBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getEditUserInfo(body:EditUserInfoBody){
        api(Api.getApi().getEditUserInfo(body)).build()
    }

    override fun onSucceedRequest(data: SuccessBean, what: Int) {
        info.getEditUserInfoRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        info.getEditUserInfoError()
    }


    interface EditUserInfo{
        fun getEditUserInfoRequest(data:SuccessBean)
        fun getEditUserInfoError()
    }
}