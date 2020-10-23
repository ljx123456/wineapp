package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.AddressListBean
import yongchao.com.wineapp.ui.set.mvp.body.AddressListBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class AddressListData(val list:AddressList): BaseData<AddressListBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getAddressList(body:AddressListBody){
        api(Api.getApi().getAddressList(body)).build()
    }

    override fun onSucceedRequest(data: AddressListBean, what: Int) {
        list.getAddressListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        list.getAddressListError()
    }


    interface AddressList{
        fun getAddressListRequest(data:AddressListBean)
        fun getAddressListError()
    }
}