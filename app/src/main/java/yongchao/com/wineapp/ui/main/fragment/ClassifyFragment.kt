package yongchao.com.wineapp.ui.main.fragment

import kotlinx.android.synthetic.main.fragment_classify.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.ui.classify.adapter.FragmentAdapter
import yongchao.com.wineapp.ui.classify.fragment.ClassifyGoodsFragment
import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean
import yongchao.com.wineapp.ui.main.mvp.presenter.ClassifyPresenter
import yongchao.com.wineapp.ui.main.mvp.view.ClassifyView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class ClassifyFragment:BaseFragment(),ClassifyView {
    override fun getGoodsTypeRequest(data: GoodsTypeBean) {
        var titles = ArrayList<String>()
//        titles.add("啤酒")
//        titles.add("葡萄酒")
//        titles.add("黄酒")
//        titles.add("白酒")
//        titles.add("洋酒")
//        titles.add("茗茶")


        data.data.forEach {
            tab.addTab(tab.newTab().setText(it.name))
            titles.add(it.name)
            fragments.add(ClassifyGoodsFragment(it))
        }
        mFragmentAdapter = FragmentAdapter(childFragmentManager, fragments, titles)
        vp_classify.adapter = mFragmentAdapter
        tab.setupWithViewPager(vp_classify)
        tab.setTabsFromPagerAdapter(mFragmentAdapter)
        vp_classify.setOffscreenPageLimit(2)
    }

    override fun getGoodsTypeError() {

    }

    private val presenter by lazy { ClassifyPresenter(this,this,activity!!) }
    var mFragmentAdapter: FragmentAdapter? = null
    var fragments = ArrayList<ClassifyGoodsFragment>()

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {
        presenter.getTypes()


    }

    override fun setFragmentListener() {
        Click.viewClick(search).subscribe {
            intentUtils.intentSearch()
        }

        Click.viewClick(layout_cart).subscribe {
            intentUtils.intentShoppingCart()
        }
    }

    override fun layoutID(): Int = R.layout.fragment_classify
}