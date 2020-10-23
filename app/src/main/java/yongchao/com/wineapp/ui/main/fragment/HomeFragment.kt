package yongchao.com.wineapp.ui.main.fragment

import kotlinx.android.synthetic.main.fragment_home.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.ui.image.ImageBannerInfo
import yongchao.com.wineapp.ui.main.mvp.bean.BannerBean
import yongchao.com.wineapp.ui.main.mvp.presenter.HomePresenter
import yongchao.com.wineapp.ui.main.mvp.view.HomeView
import yongchao.com.wineapp.ui.main.util.BannerUtil
import yongchao.com.wineapp.utils.Click

class HomeFragment:BaseFragment(),HomeView {
    override fun getBannerRequest(data: BannerBean) {
        BannerUtil.setBanner(banner,data.data)
    }

    override fun getBannerError() {

    }

    private val presenter by lazy { HomePresenter(this,this,context!!) }

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
        presenter.getBanner()
    }

    override fun setFragmentListener() {



    }

    override fun layoutID(): Int = R.layout.fragment_home

    override fun onResume() {
        super.onResume()

    }
}