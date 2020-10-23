package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.CollectListBean
import yongchao.com.wineapp.ui.set.mvp.body.CollectListBody
import yongchao.com.wineapp.ui.set.mvp.data.CollectListData
import yongchao.com.wineapp.ui.set.mvp.view.CollectView
import java.util.ArrayList

class CollectPresenter(owner: LifecycleOwner, val view: CollectView, val mContext: Context) : BasePresenter(owner, view, mContext),CollectListData.CollectList {

    private val data=CollectListData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getCollectList(body:CollectListBody){
        data.getCollectList(body)
    }

    override fun getCollectListRequest(data: CollectListBean) {
        view.getCollectListRequest(data)
    }

    override fun getCollectListError() {
        view.getCollectListError()
    }
}