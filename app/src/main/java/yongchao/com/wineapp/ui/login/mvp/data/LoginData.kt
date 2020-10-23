package yongchao.com.wineapp.ui.login.mvp.data

import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean
import yongchao.com.wineapp.ui.login.mvp.body.LoginBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class LoginData(val login:Login): BaseData<LoginBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getLogin(body: LoginBody){
        api(Api.getApi().getLogin(body)).build()
    }

    override fun onSucceedRequest(data: LoginBean, what: Int) {
        login.getLoginRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        login.getLoginError()
    }


    interface Login{
        fun getLoginRequest(data: LoginBean)
        fun getLoginError()
    }
}