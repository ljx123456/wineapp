package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.SellingDataBean
import yongchao.com.wineapp.ui.set.mvp.body.SellingDataBody
import yongchao.com.wineapp.ui.set.mvp.data.SellingDataData
import yongchao.com.wineapp.ui.set.mvp.view.SellingDataView
import java.util.ArrayList

class SellingDataPresenter(owner: LifecycleOwner, val view: SellingDataView, val mContext: Context) : BasePresenter(owner, view, mContext), SellingDataData.SellingData {

    private val data=SellingDataData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getSellingData(body:SellingDataBody){
        view.showLoading(mContext)
        data.getSellingData(body)
    }

    override fun getSellingDataRequest(data: SellingDataBean) {
        view.dismissLoading(mContext)
        view.getSellingDataRequest(data)
    }

    override fun getSellingDataError() {
        view.dismissLoading(mContext)
        view.getSellingDataError()
    }
}