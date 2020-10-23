package yongchao.com.wineapp.ui.set.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_my_address.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.adapter.AddressAdapter
import yongchao.com.wineapp.ui.set.mvp.bean.AddressListBean
import yongchao.com.wineapp.ui.set.mvp.body.AddressListBody
import yongchao.com.wineapp.ui.set.mvp.presenter.MyAddressPresenter
import yongchao.com.wineapp.ui.set.mvp.view.MyAddressView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class MyAddressActivity:BaseActivity(),MyAddressView{
    override fun getAddressListRequest(data: AddressListBean) {
        swip.isRefreshing=false
        if (pageIndex==1&&data.data.size>0){
            adapter=AddressAdapter(data.data)
            var manager= LinearLayoutManager(mContext)
            manager.orientation= LinearLayout.VERTICAL
            recy.layoutManager=manager
            recy.adapter=adapter
        }else{
            adapter.addData(data.data)
        }

        adapter.setOnLoadMoreListener(object :BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex=pageIndex+1
                presenter.getAddressList(AddressListBody(pageIndex,pageSize))
            }
        },recy)

        if (data.data.size<10){
            adapter.loadMoreEnd()
        }else{
            adapter.loadMoreComplete()
        }

        adapter.setOnItemChildClickListener { mAdapter, view, position ->
            intentUtils.intentEditAddress(adapter.data[position].addressId,adapter.data[position].userName,adapter.data[position].phone
                    ,adapter.data[position].address,adapter.data[position].districtId,adapter.data[position].provinceName+adapter.data[position].cityName+adapter.data[position].districtName
                    ,adapter.data[position].isIsDefault)
        }

    }

    override fun getAddressListError() {

    }

    private val presenter by lazy { MyAddressPresenter(this,this,this) }
    private var pageIndex=1
    private var pageSize=10
    private lateinit var adapter:AddressAdapter

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_my_address

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(tv_add).subscribe {
            intentUtils.intentAddAddress()
        }

        swip.setOnRefreshListener {
            pageIndex=1
            presenter.getAddressList(AddressListBody(pageIndex,pageSize))
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getAddressList(AddressListBody(pageIndex,pageSize))
    }
}