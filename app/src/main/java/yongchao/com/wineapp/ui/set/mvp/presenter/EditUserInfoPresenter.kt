package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.EditUserInfoBody
import yongchao.com.wineapp.ui.set.mvp.data.EditUserInfoData
import yongchao.com.wineapp.ui.set.mvp.view.EditUserInfoView
import java.util.ArrayList

class EditUserInfoPresenter(owner: LifecycleOwner, val view: EditUserInfoView, val mContext: Context) : BasePresenter(owner, view, mContext),EditUserInfoData.EditUserInfo {

    private val data=EditUserInfoData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getEditUserInfo(body:EditUserInfoBody){
        data.getEditUserInfo(body)
    }

    override fun getEditUserInfoRequest(data: SuccessBean) {
        view.getEditUserInfoRequest(data)
    }

    override fun getEditUserInfoError() {
        view.getEditUserInfoError()
    }
}