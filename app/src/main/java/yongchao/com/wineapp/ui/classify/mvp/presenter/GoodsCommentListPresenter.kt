package yongchao.com.wineapp.ui.classify.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsCommentListBody
import yongchao.com.wineapp.ui.classify.mvp.data.GoodsCommentListData
import yongchao.com.wineapp.ui.classify.mvp.view.GoodsCommentListView
import java.util.ArrayList

class GoodsCommentListPresenter(owner: LifecycleOwner, val view: GoodsCommentListView, val mContext: Context) : BasePresenter(owner, view, mContext),GoodsCommentListData.GoodsCommentList {

    private val data=GoodsCommentListData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getGoodsComment(body:GoodsCommentListBody){
        data.getGoodsCommentList(body)
    }

    override fun getGoodsCommentListRequest(data: GoodsCommentListBean) {
        view.getGoodsCommentListRequest(data)
    }

    override fun getGoodsCommentListError() {
        view.getGoodsCommentListError()
    }
}