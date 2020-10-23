package yongchao.com.wineapp.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.login.mvp.bean.CodeBean
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean
import yongchao.com.wineapp.ui.login.mvp.body.CodeBody
import yongchao.com.wineapp.ui.login.mvp.body.LoginBody
import yongchao.com.wineapp.ui.login.mvp.data.CodeData
import yongchao.com.wineapp.ui.login.mvp.data.LoginData
import yongchao.com.wineapp.ui.login.mvp.view.LoginCodeView
import java.util.ArrayList

class LoginCodePresenter(owner: LifecycleOwner, val view:LoginCodeView, val mContext: Context) : BasePresenter(owner, view, mContext),CodeData.Code,LoginData.Login {

    private val code=CodeData(this)
    private val login=LoginData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        login.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    //获取验证码
    fun getCode(body:CodeBody){
        view.showLoading(mContext)
        code.getCode(body)
    }

    override fun getCodeRequest(data: CodeBean) {
        view.dismissLoading(mContext)
    }

    override fun getCodeError() {
        view.dismissLoading(mContext)
    }

    fun getLogin(body:LoginBody){
        view.showLoading(mContext)
        login.getLogin(body)
    }

    override fun getLoginRequest(data: LoginBean) {
        view.dismissLoading(mContext)
        view.getLoginCodeRequest(data)
    }

    override fun getLoginError() {
        view.dismissLoading(mContext)
        view.getLoginCodeError()
    }
}