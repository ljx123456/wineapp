package yongchao.com.wineapp.ui.login.mvp.data

import yongchao.com.wineapp.ui.login.mvp.bean.LoginBindBean
import yongchao.com.wineapp.ui.login.mvp.body.LoginBindBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class LoginBindData(val login:LoginBind): BaseData<LoginBindBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getBind(body: LoginBindBody){
        api(Api.getApi().getLoginBind(body)).build()
    }

    override fun onSucceedRequest(data: LoginBindBean, what: Int) {
        login.getLoginBindRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        login.getLoginBindError()
    }


    interface LoginBind{
        fun getLoginBindRequest(data: LoginBindBean)
        fun getLoginBindError()
    }
}