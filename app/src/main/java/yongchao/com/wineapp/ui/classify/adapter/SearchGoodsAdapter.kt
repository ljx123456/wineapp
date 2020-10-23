package yongchao.com.wineapp.ui.classify.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean
import yongchao.com.wineapp.utils.image.ImageLoad

class SearchGoodsAdapter(list: MutableList<GoodsListBean.DataBean>):BaseQuickAdapter<GoodsListBean.DataBean,BaseViewHolder>(R.layout.item_search_goods,list) {
    override fun convert(helper: BaseViewHolder, item: GoodsListBean.DataBean) {
        ImageLoad.setImage(item.preview,helper.getView(R.id.iv_goods))

        helper.setText(R.id.tv_name,item.goodsName)
                .setText(R.id.tv_price,item.sellingPrice.toString())
    }
}