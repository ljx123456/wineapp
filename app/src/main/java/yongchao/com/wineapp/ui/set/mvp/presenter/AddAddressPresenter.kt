package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.AddAddressBody
import yongchao.com.wineapp.ui.set.mvp.data.AddAddressData
import yongchao.com.wineapp.ui.set.mvp.view.AddAddressView
import java.util.ArrayList

class AddAddressPresenter(owner: LifecycleOwner, val view: AddAddressView, val mContext: Context) : BasePresenter(owner, view, mContext), AddAddressData.AddAddress {

    private val data=AddAddressData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getAddAddress(body:AddAddressBody){
        view.showLoading(mContext)
        data.getAddAddress(body)
    }

    override fun getAddAddressRequest(data: SuccessBean) {
        view.dismissLoading(mContext)
        view.getAddAddressRequest(data)
    }

    override fun getAddAddressError() {
        view.dismissLoading(mContext)
        view.getAddAddressError()
    }
}