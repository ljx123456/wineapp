package yongchao.com.wineapp.ui.set.mvp.data

import yongchao.com.wineapp.ui.set.mvp.bean.UserInfoBean
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class UserInfoData(val info:UserInfo): BaseData<UserInfoBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getUserInfo(){
        api(Api.getApi().getUserInfo()).build()
    }

    override fun onSucceedRequest(data: UserInfoBean, what: Int) {
        info.getUserInfoRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        info.getUserInfoError()
    }


    interface UserInfo{
        fun getUserInfoRequest(data:UserInfoBean)
        fun getUserInfoError()
    }
}