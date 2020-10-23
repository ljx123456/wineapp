package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.DelAddressBody
import yongchao.com.wineapp.ui.set.mvp.body.EditAddressBody
import yongchao.com.wineapp.ui.set.mvp.data.DelAddressData
import yongchao.com.wineapp.ui.set.mvp.data.EditAddressData
import yongchao.com.wineapp.ui.set.mvp.view.EditAddressView
import java.util.ArrayList

class EditAddressPresenter(owner: LifecycleOwner, val view: EditAddressView, val mContext: Context) : BasePresenter(owner, view, mContext),EditAddressData.EditAddress,DelAddressData.DelAddress {

    private val del=DelAddressData(this)
    fun getDelAddress(body:DelAddressBody){
        view.showLoading(mContext)
        del.getDelAddress(body)
    }
    override fun getDelAddressRequest(data: SuccessBean) {
        view.dismissLoading(mContext)
        view.getDelAddressRequest(data)
    }

    override fun getDelAddressError() {
        view.dismissLoading(mContext)
        view.getDelAddressError()
    }

    private val data=EditAddressData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getEditAddress(body:EditAddressBody){
        view.showLoading(mContext)
        data.getEditAddress(body)
    }

    override fun getEditAddressRequest(data: SuccessBean) {
        view.dismissLoading(mContext)
        view.getEditAddressRequest(data)
    }

    override fun getEditAddressError() {
        view.dismissLoading(mContext)
        view.getEditAddressError()
    }
}