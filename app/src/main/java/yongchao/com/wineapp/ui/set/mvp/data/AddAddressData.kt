package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.AddAddressBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class AddAddressData(val add:AddAddress): BaseData<SuccessBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getAddAddress(body:AddAddressBody){
        api(Api.getApi().getAddAddress(body)).build()
    }

    override fun onSucceedRequest(data: SuccessBean, what: Int) {
        add.getAddAddressRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        add.getAddAddressError()
    }


    interface AddAddress{
        fun getAddAddressRequest(data: SuccessBean)
        fun getAddAddressError()
    }
}