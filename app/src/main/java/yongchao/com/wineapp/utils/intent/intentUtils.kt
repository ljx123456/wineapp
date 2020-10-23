package yongchao.com.wineapp.utils.intent

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import yongchao.com.wineapp.base.BaseContext.getContext
import yongchao.com.wineapp.ui.classify.activity.*
import yongchao.com.wineapp.ui.image.*
import yongchao.com.wineapp.ui.login.activity.*
import yongchao.com.wineapp.ui.main.activity.*
import yongchao.com.wineapp.ui.order.activity.*
import yongchao.com.wineapp.ui.set.activity.*
import yongchao.com.wineapp.ui.shoppingcart.activity.*

object intentUtils{
    /**
     * 图片详情-查看自己的
     */
    fun intentImage(delete: Boolean, list: ArrayList<ImageInfo>, index: Int) {
        val imageList = ArrayList<ImageBrowseInfo>()
        list.forEach { if (!it.isAddButton) imageList.add(ImageBrowseInfo(it.imageUrl!!, false, it.imageId)) }
        val intent = Intent(getContext(), ImageActivity::class.java)
        intent.putExtra("images", imageList)
        intent.putExtra("delete", delete)
        intent.putExtra("index", index)
        ActivityUtils.startActivity(intent)
    }

    fun intentLogin(){
        val intent= Intent(getContext(),LoginActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentLoginCode(phone:String){
        val intent = Intent(getContext(), LoginCodeActivity::class.java)
        intent.putExtra("phone", phone)
        ActivityUtils.startActivity(intent)
    }


    fun intentMain(){
        val intent= Intent(getContext(),MainActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentBind(){
        val intent= Intent(getContext(),LoginBindActivity::class.java)
        ActivityUtils.startActivity(intent)
    }


    fun intentSet(){
        val intent= Intent(getContext(),SetActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentUserInfo(){
        val intent=Intent(getContext(),EditUserInfoActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentMyAddress(){
        val intent=Intent(getContext(),MyAddressActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentAddAddress(){
        val intent=Intent(getContext(),AddAddressActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentEditAddress(id:Int,name:String,phone:String,address:String,districtId:Int,area:String,isDefault: Boolean){
        val intent=Intent(getContext(),EditAddressActivity::class.java)
        intent.putExtra("id",id)
        intent.putExtra("name",name)
        intent.putExtra("phone",phone)
        intent.putExtra("address",address)
        intent.putExtra("area",area)
        intent.putExtra("districtId",districtId)
        intent.putExtra("isDefault",isDefault)
        ActivityUtils.startActivity(intent)
    }

    fun intentCollect(){
        val intent=Intent(getContext(),CollectActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentData(){
        val intent=Intent(getContext(),SellingDataActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentSearch(){
        val intent=Intent(getContext(),SearchGoodsActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentGoodsDetails(id:String){
        val intent=Intent(getContext(), GoodsDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    fun intentGoodsCommentList(id:String){
        val intent=Intent(getContext(),GoodsCommentListActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    fun intentShoppingCart(){
        val intent=Intent(getContext(),ShoppingCartActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentGoodsComment(){
        val intent=Intent(getContext(),GoodsCommentActivity::class.java)
        ActivityUtils.startActivity(intent)
    }

    fun intentOrderDetails(){
        val intent=Intent(getContext(),OrderDetailsActivity::class.java)
        ActivityUtils.startActivity(intent)
    }


}