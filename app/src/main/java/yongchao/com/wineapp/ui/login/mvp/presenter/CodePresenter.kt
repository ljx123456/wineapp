package yongchao.com.wineapp.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.login.mvp.bean.CodeBean
import yongchao.com.wineapp.ui.login.mvp.body.CodeBody
import yongchao.com.wineapp.ui.login.mvp.data.CodeData
import yongchao.com.wineapp.ui.login.mvp.view.LoginCodeView
import java.util.ArrayList

class CodePresenter(owner: LifecycleOwner, val view: LoginCodeView, val mContext: Context) : BasePresenter(owner, view, mContext),CodeData.Code {

    private val code=CodeData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        code.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    //获取验证码
    fun getCode(body: CodeBody){
        code.getCode(body)
    }

    override fun getCodeRequest(data: CodeBean) {

    }

    override fun getCodeError() {

    }
}