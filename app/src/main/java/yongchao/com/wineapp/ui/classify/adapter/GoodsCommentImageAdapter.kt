package yongchao.com.wineapp.ui.classify.adapter

import com.blankj.utilcode.util.SizeUtils.dp2px
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.utils.image.ImageLoad

class GoodsCommentImageAdapter(var list: MutableList<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_comment_goods,list) {
    override fun convert(helper: BaseViewHolder, item: String) {
        ImageLoad.setImage(item,helper.getView(R.id.itemImage))
    }
}

