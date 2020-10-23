package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.EditAddressBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class EditAddressData(val edit:EditAddress): BaseData<SuccessBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getEditAddress(body: EditAddressBody){
        api(Api.getApi().getEditAddress(body)).build()
    }

    override fun onSucceedRequest(data: SuccessBean, what: Int) {
        edit.getEditAddressRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        edit.getEditAddressError()
    }


    interface EditAddress{
        fun getEditAddressRequest(data: SuccessBean)
        fun getEditAddressError()
    }
}