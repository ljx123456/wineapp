package yongchao.com.wineapp.ui.image

/**
 * Created by Administrator on 2018/8/20 0020.
 */
data class ImageBannerInfo(val imageUrl: String?, var isAddButton: Boolean, var url:String,var id:Int,var type:Int,var goodsId: Int)
data class ImageInfo(val imageUrl: String?, var isAddButton: Boolean, var imageId: Int)
data class ImageShopInfo(val imageUrl: String?, var isAddButton: Boolean, var imageId: Int,var id:String)
data class ImageExploreInfo(val imageUrl: String?, var isAddButton: Boolean, var imageId: Int,var id:Int,var type:Int,var objectId:Int?)
