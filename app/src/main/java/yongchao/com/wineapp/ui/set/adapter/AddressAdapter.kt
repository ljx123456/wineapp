package yongchao.com.wineapp.ui.set.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.set.mvp.bean.AddressListBean

class AddressAdapter(list: MutableList<AddressListBean.DataBean>): BaseQuickAdapter<AddressListBean.DataBean, BaseViewHolder>(R.layout.item_my_address,list) {
    override fun convert(helper: BaseViewHolder, item: AddressListBean.DataBean) {
        helper.setText(R.id.tv_name,item.userName)
                .setText(R.id.tv_phone,item.phone)
                .setText(R.id.tv_address,item.address)
                .addOnClickListener(R.id.iv_edit)
        if (item.isIsDefault){
            helper.setGone(R.id.tv_default,true)
        }else{
            helper.setGone(R.id.tv_default,false)
        }
    }
}