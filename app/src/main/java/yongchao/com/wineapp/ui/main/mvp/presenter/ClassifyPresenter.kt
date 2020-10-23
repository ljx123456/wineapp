package yongchao.com.wineapp.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean
import yongchao.com.wineapp.ui.main.mvp.data.GoodsTypeData
import yongchao.com.wineapp.ui.main.mvp.view.ClassifyView
import java.util.ArrayList

class ClassifyPresenter(owner: LifecycleOwner, val view: ClassifyView, val mContext: Context) : BasePresenter(owner, view, mContext),GoodsTypeData.GoodsType{

    private val types=GoodsTypeData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        types.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getTypes(){
        types.getGoodsType()
    }

    override fun getGoodsTypeRequest(data: GoodsTypeBean) {
        view.getGoodsTypeRequest(data)
    }

    override fun getGoodsTypeError() {
        view.getGoodsTypeError()
    }
}