package yongchao.com.wineapp.ui.set.adapter

import android.graphics.Paint
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.set.mvp.bean.CollectListBean
import yongchao.com.wineapp.utils.image.ImageLoad

class CollectListAdapter(list: MutableList<CollectListBean.DataBean>): BaseQuickAdapter<CollectListBean.DataBean, BaseViewHolder>(R.layout.item_collect,list) {
    override fun convert(helper: BaseViewHolder, item: CollectListBean.DataBean) {
        ImageLoad.setImage(item.preview,helper.getView(R.id.iv_goods))
        helper.setText(R.id.tv_name,item.goodsName)
                .setText(R.id.tv_specs,"规格："+item.specValue+item.spec+"*"+item.unit)
                .setText(R.id.tv_price,item.sellingPrice.toString())
                .setText(R.id.tv_original_price,item.price.toString())
        helper.getView<TextView>(R.id.tv_original_price).getPaint().setFlags( Paint.STRIKE_THRU_TEXT_FLAG and Paint.ANTI_ALIAS_FLAG )
    }
}