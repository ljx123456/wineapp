package yongchao.com.wineapp.ui.classify.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsDetailsBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsCommentListBody
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsDetailsBody
import yongchao.com.wineapp.ui.classify.mvp.data.GoodsCommentListData
import yongchao.com.wineapp.ui.classify.mvp.data.GoodsDetailsData
import yongchao.com.wineapp.ui.classify.mvp.view.GoodsDetailsView
import java.util.ArrayList

class GoodsDetaisPresenter(owner: LifecycleOwner, val view: GoodsDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext),GoodsDetailsData.GoodsDetails,GoodsCommentListData.GoodsCommentList {

    private val comment=GoodsCommentListData(this)
    fun getGoodsCommnet(body:GoodsCommentListBody){
        comment.getGoodsCommentList(body)
    }

    override fun getGoodsCommentListRequest(data: GoodsCommentListBean) {
        view.getGoodsCommentListRequest(data)
    }

    override fun getGoodsCommentListError() {
        view.getGoodsDetailsError()
    }

    private val data=GoodsDetailsData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        data.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getGoodsDetails(body: GoodsDetailsBody){
        view.showLoading(mContext)
        data.getGoodsDetails(body)
    }

    override fun getGoodsDetailsRequest(data: GoodsDetailsBean) {
        view.dismissLoading(mContext)
        view.getGoodsDetailsRequest(data)
    }

    override fun getGoodsDetailsError() {
        view.dismissLoading(mContext)
        view.getGoodsDetailsError()
    }
}