package yongchao.com.wineapp.ui.classify.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsListBody
import yongchao.com.wineapp.ui.classify.mvp.data.GoodsListData
import yongchao.com.wineapp.ui.classify.mvp.view.ClassifyGoodsView
import java.util.ArrayList

class GoodsListPresenter(owner: LifecycleOwner, val view: ClassifyGoodsView, val mContext: Context) : BasePresenter(owner, view, mContext),GoodsListData.GoodsList {

    private val data=GoodsListData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getGoodList(body:GoodsListBody){

        data.getGoodsList(body)
    }

    override fun getGoodsListRequest(data: GoodsListBean) {
        view.getGoodsListRequest(data)
    }

    override fun getGoodsListError() {
        view.getGoodsListError()
    }
}