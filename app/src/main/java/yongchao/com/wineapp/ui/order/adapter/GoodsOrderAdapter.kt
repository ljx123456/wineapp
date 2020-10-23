package yongchao.com.wineapp.ui.order.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.shoppingcart.mvp.bean.ShoppingCartGoodsBean
import yongchao.com.wineapp.utils.image.ImageLoad

class GoodsOrderAdapter(val list:MutableList<ShoppingCartGoodsBean.DataBean>,val flag:Boolean):BaseQuickAdapter<ShoppingCartGoodsBean.DataBean,BaseViewHolder>(R.layout.item_order_goods,list) {
    override fun convert(helper: BaseViewHolder, item: ShoppingCartGoodsBean.DataBean) {

        ImageLoad.setImage(item.image,helper.getView(R.id.iv_goods))
        helper.setText(R.id.tv_name,item.name)
                .setText(R.id.tv_type,"规格："+item.type)
                .setText(R.id.tv_unit,"单位："+item.unit)
                .setText(R.id.tv_price,"价格："+item.price)
                .setText(R.id.tv_num,"数量：x "+item.num)

        if (flag){
            helper.setGone(R.id.btn_comment,true)
        }else{
            helper.setGone(R.id.btn_comment,false)
        }

        helper.addOnClickListener(R.id.btn_comment)

    }
}