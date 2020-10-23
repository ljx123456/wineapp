package yongchao.com.wineapp.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import io.reactivex.disposables.Disposable
import yongchao.com.wineapp.base.BasePresenter
import yongchao.com.wineapp.ui.main.mvp.bean.BannerBean
import yongchao.com.wineapp.ui.main.mvp.data.BannerData
import yongchao.com.wineapp.ui.main.mvp.view.HomeView
import java.util.ArrayList

class HomePresenter(owner: LifecycleOwner, val view: HomeView, val mContext: Context) : BasePresenter(owner, view, mContext),BannerData.Banner {

    private val banner=BannerData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        banner.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getBanner(){
        banner.getBanner()
    }

    override fun getBannerRequest(data: BannerBean) {
        view.getBannerRequest(data)
    }

    override fun getBannerError() {
        view.getBannerError()
    }
}