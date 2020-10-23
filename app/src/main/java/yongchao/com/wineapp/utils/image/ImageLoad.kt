package yongchao.com.wineapp.utils.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import yongchao.com.wineapp.base.BaseContext.getContext
import yongchao.com.wineapp.utils.UtilBitmap
import yongchao.com.wineapp.utils.image.ImageConfiguration.imagePlaceholder
import yongchao.com.wineapp.utils.image.ImageConfiguration.userHeadPlaceholder


/**
 * Created by Administrator on 2018/3/1 0001.
 * 加载普通图片
 */
object ImageLoad {


    //加载一般图片
    fun setImage(url: String, image: ImageView) {
        Glide.with(getContext())
                .load(url)
                .placeholder(imagePlaceholder)
                .dontAnimate()
//                .diskCacheStrategy(DiskCacheStrategy.)
                .into(image)
    }

    //无占位图加载
    fun setImageNull(url: String, image: ImageView) {
        Glide.with(getContext())
                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image)
    }

    //加载本地资源
    fun setResourceImage(id: Int, image: ImageView) {
        Glide.with(getContext()).load(id).dontAnimate().into(image)
    }


    //加载头像
    fun setUserHead(url: String, image: ImageView) {
        if (url != null && !url.equals("")) {
            Glide.with(getContext())
                    .load(url)
                    .placeholder(userHeadPlaceholder)
                    .dontAnimate()
                    .error(userHeadPlaceholder)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(image)
        } else
            Glide.with(getContext())
                    .load(url)
                    .placeholder(userHeadPlaceholder)
                    .dontAnimate()
                    .error(userHeadPlaceholder)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(image)
    }



    //高斯模糊
    fun setMaskImage(url: String, image: ImageView,context: Context) {
        Glide.with(getContext())
                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(object :SimpleTarget<Drawable>(){
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        image.setImageDrawable(resource)
                        UtilBitmap().blurImageView(context,image,25f)
                    }
                })

    }



}