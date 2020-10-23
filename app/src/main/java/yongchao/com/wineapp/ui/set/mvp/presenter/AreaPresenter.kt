package yongchao.com.wineapp.ui.set.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.set.mvp.bean.AreaBean
import yongchao.com.wineapp.ui.set.mvp.body.AreaBody
import yongchao.com.wineapp.ui.set.mvp.data.AreaData
import yongchao.com.wineapp.ui.set.mvp.view.AreaView
import java.util.ArrayList

class AreaPresenter(owner: LifecycleOwner, val view: AreaView, val mContext: Context) : BasePresenter(owner, view, mContext), AreaData.Area{

    private val area=AreaData(this)

    fun getArea(body: AreaBody){
        area.getArea(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        area.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getAreaRequest(data: AreaBean) {
        view.getAreaRequest(data)
    }

    override fun getAreaError() {
        view.getAreaError()
    }
}