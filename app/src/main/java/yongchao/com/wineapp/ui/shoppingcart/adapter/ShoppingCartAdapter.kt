package yongchao.com.wineapp.ui.shoppingcart.adapter

import android.widget.CheckBox
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.makeramen.roundedimageview.RoundedImageView
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.shoppingcart.mvp.bean.ShoppingCartGoodsBean
import yongchao.com.wineapp.utils.image.ImageLoad
import java.math.BigDecimal

class ShoppingCartAdapter(list: MutableList<ShoppingCartGoodsBean.DataBean>):BaseQuickAdapter<ShoppingCartGoodsBean.DataBean,BaseViewHolder>(R.layout.item_shoppingcart,list) {

    var fla=true
    override fun convert(helper: BaseViewHolder, item: ShoppingCartGoodsBean.DataBean) {

        ImageLoad.setImage(item.image,helper.getView(R.id.iv_goods) as RoundedImageView)

        helper.setText(R.id.tv_name,item.name)
                .setText(R.id.tv_type,item.type)
                .setText(R.id.tv_unit,"规格："+item.unit)
                .setText(R.id.tv_num,""+item.num)
                .setText(R.id.tv_money,"¥ "+BigDecimal(item.price).setScale(2,BigDecimal.ROUND_DOWN).toString())

        if (item.flag){
            helper.setChecked(R.id.cb,true)
        }else{
            helper.setChecked(R.id.cb,false)
        }
//
        helper.addOnClickListener(R.id.cb)
                .addOnClickListener(R.id.tv_type)
                .addOnClickListener(R.id.iv_reduce)
                .addOnClickListener(R.id.iv_add)
//        helper.getView<CheckBox>(R.id.cb).setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked){
//                item.flag=true
//            }else{
//                item.flag=false
//            }
//        }

    }
}