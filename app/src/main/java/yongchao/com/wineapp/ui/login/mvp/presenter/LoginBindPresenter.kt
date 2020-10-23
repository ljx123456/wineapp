package yongchao.com.wineapp.ui.login.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBindBean
import yongchao.com.wineapp.ui.login.mvp.body.LoginBindBody
import yongchao.com.wineapp.ui.login.mvp.data.LoginBindData
import yongchao.com.wineapp.ui.login.mvp.view.LoginBindView
import java.util.ArrayList

class LoginBindPresenter(owner: LifecycleOwner, val view:LoginBindView, val mContext: Context) : BasePresenter(owner, view, mContext),LoginBindData.LoginBind {

    private val data=LoginBindData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getBind(body:LoginBindBody){
        view.showLoading(mContext)
        data.getBind(body)
    }

    override fun getLoginBindRequest(data: LoginBindBean) {
        view.dismissLoading(mContext)
        view.getLoginBindRequest(data)
    }

    override fun getLoginBindError() {
        view.dismissLoading(mContext)
        view.getLoginBindError()
    }
}