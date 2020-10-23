package yongchao.com.wineapp.ui.login.mvp.data

import yongchao.com.wineapp.ui.login.mvp.bean.CodeBean
import yongchao.com.wineapp.ui.login.mvp.body.CodeBody
import yongchao.com.wineapp.utils.http.Api
import yongchao.com.wineapp.utils.http.BaseData
import yongchao.com.wineapp.utils.http.SaveInfo

class CodeData(val code:Code):BaseData<CodeBean>(){
    override fun requestCache(): SaveInfo = SaveInfo(false,javaClass.name)


    fun getCode(body:CodeBody){
        api(Api.getApi().getCode(body)).build()
    }

    override fun onSucceedRequest(data: CodeBean, what: Int) {
        code.getCodeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
        code.getCodeError()
    }


    interface Code{
        fun getCodeRequest(data:CodeBean)
        fun getCodeError()
    }
}