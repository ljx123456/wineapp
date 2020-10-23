package yongchao.com.wineapp.ui.order.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.makeramen.roundedimageview.RoundedImageView
import yongchao.com.wineapp.R
import yongchao.com.wineapp.utils.image.ImageLoad

class ImageAdapter(list: MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_images, list) {
    override fun convert(helper: BaseViewHolder, item: String) {

//        ImageLoad.setImage(item+"?vframe/jpg/offset/1", helper.getView(R.id.itemImage) as RoundedImageView)
        ImageLoad.setImage(item, helper.getView(R.id.itemImage) as RoundedImageView)
//        helper.setVisible(R.id.itemVideo, true)
//        when (item.imageId) {
//            1 -> {
//                ImageLoad.setImage(item.url+"?vframe/jpg/offset/1", helper.getView(R.id.itemImage) as RoundedImageView)
//                helper.setVisible(R.id.itemVideo, true)
//            }
//            else ->{
//                helper.setVisible(R.id.itemVideo, false)
//                ImageLoad.setImage(item.url+"?imageView2/1/w/200/h/200/q/75", helper.getView(R.id.itemImage) as RoundedImageView)
//            }
//        }
    }

//    override fun onViewRecycled(holder: BaseViewHolder) {
//        super.onViewRecycled(holder)
//        var imageView = holder.getView<RoundedImageView>(R.id.itemImage)
//        if (imageView != null) {
//            Glide.with(mContext).clear(imageView)
//        }
//    }

}