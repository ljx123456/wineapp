package yongchao.com.wineapp.ui.order.activity

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_goods_comment.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.image.ImageInfo
import yongchao.com.wineapp.ui.main.mvp.view.QiniuView
import yongchao.com.wineapp.ui.order.adapter.PictureAdapter
import yongchao.com.wineapp.utils.CameraSelect
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class GoodsCommentActivity:BaseActivity(), CameraSelect.CameraSelectFace , QiniuView,PictureAdapter.NonePiceture {
    override fun setNone() {

    }

    override fun returnCameraImageList(list: java.util.ArrayList<String>) {

        iv_add.visibility= View.GONE
        gv_picture.visibility= View.VISIBLE
        if (adapter!=null){
            adapter!!.addList(list)
        }else{
            adapter= PictureAdapter(this,6)
            adapter!!.addList(list)
            gv_picture.adapter=adapter
        }
    }

    override fun sendSucceedImage(fileUrlList: ArrayList<String>) {

    }

    override fun sendFileErrorImage() {

    }

    private var cameraSelect = CameraSelect(this)
    private var adapter: PictureAdapter?=null

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_goods_comment

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {

        edit_comment.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().isNotEmpty()){
                    tv_num.text=s.toString().length.toString()+"/120"
                }else{
                    tv_num.text="0/120"
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        gv_picture.setOnItemClickListener { parent, view, position, id ->
            if (adapter!=null&&adapter!!.list.size<6&&position==parent.childCount-1){
//                cameraSelect.openCamera()
                cameraSelect.initMultiCameraSdk(this,6-adapter!!.list.size)
                cameraSelect.openCamera()
            }else{
                var imagelist = ArrayList<ImageInfo>()
                adapter!!.list.forEach {
                    imagelist.add(ImageInfo(it, false, 2))
                }
                intentUtils.intentImage(false, imagelist, position)
            }
        }

        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(iv_add).subscribe {
            cameraSelect.initMultiCameraSdk(this,6)
            cameraSelect.openCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        cameraSelect.onActivityCameraResult(requestCode, resultCode, data)
    }


}