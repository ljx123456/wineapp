package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.AddressListBean
import yongchao.com.wineapp.ui.set.mvp.body.AddressListBody
import yongchao.com.wineapp.ui.set.mvp.data.AddressListData
import yongchao.com.wineapp.ui.set.mvp.view.MyAddressView
import java.util.ArrayList

class MyAddressPresenter(owner: LifecycleOwner, val view: MyAddressView, val mContext: Context) : BasePresenter(owner, view, mContext),AddressListData.AddressList {

    private val data=AddressListData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getAddressList(body:AddressListBody){
        data.getAddressList(body)
    }

    override fun getAddressListRequest(data: AddressListBean) {
        view.getAddressListRequest(data)
    }

    override fun getAddressListError() {
        view.getAddressListError()
    }
}