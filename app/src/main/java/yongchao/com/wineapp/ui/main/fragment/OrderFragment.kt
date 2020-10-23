package yongchao.com.wineapp.ui.main.fragment

import kotlinx.android.synthetic.main.fragment_order.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.ui.classify.adapter.FragmentAdapter
import yongchao.com.wineapp.ui.order.fragment.OrderListFragment

class OrderFragment:BaseFragment() {

    var mFragmentAdapter: FragmentAdapter? = null
    var fragments = ArrayList<OrderListFragment>()

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {

        var titles = ArrayList<String>()
        titles.add("全部")
        titles.add("待付款")
        titles.add("待配送")
        titles.add("配送中")
        titles.add("已完成")



        titles.forEach {
            tab.addTab(tab.newTab().setText(it))
            fragments.add(OrderListFragment(it))
        }
        mFragmentAdapter = FragmentAdapter(childFragmentManager, fragments, titles)
        vp_order.adapter = mFragmentAdapter
        tab.setupWithViewPager(vp_order)
        tab.setTabsFromPagerAdapter(mFragmentAdapter)
        vp_order.setOffscreenPageLimit(2)
    }

    override fun setFragmentListener() {

    }

    override fun layoutID(): Int = R.layout.fragment_order
}