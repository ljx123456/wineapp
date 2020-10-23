package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.UserInfoBean
import yongchao.com.wineapp.ui.set.mvp.data.UserInfoData
import yongchao.com.wineapp.ui.set.mvp.view.MineView
import java.util.ArrayList

class MinePresenter(owner: LifecycleOwner, val view: MineView, val mContext: Context) : BasePresenter(owner, view, mContext),UserInfoData.UserInfo {

    private val data=UserInfoData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getUserInfo(){
        data.getUserInfo()
    }

    override fun getUserInfoRequest(data: UserInfoBean) {
        view.getUserInfoRequest(data)
    }

    override fun getUserInfoError() {
        view.getUserInfoError()
    }
}