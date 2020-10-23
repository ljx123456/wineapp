package yongchao.com.wineapp.ui.set.activity

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_userinfo.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.db.DBUtil
import yongchao.com.wineapp.ui.main.mvp.presenter.QiniuPresenter
import yongchao.com.wineapp.ui.main.mvp.view.QiniuView
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.EditUserInfoBody
import yongchao.com.wineapp.ui.set.mvp.presenter.EditUserInfoPresenter
import yongchao.com.wineapp.ui.set.mvp.view.EditUserInfoView
import yongchao.com.wineapp.utils.CameraSelect
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.image.ImageLoad
import java.io.File
import kotlin.collections.ArrayList

class EditUserInfoActivity:BaseActivity(), CameraSelect.CameraSelectFace , QiniuView,EditUserInfoView {
    override fun getEditUserInfoRequest(data: SuccessBean) {

    }

    override fun getEditUserInfoError() {

    }

    override fun sendSucceedImage(fileUrlList: ArrayList<String>) {
        if (fileUrlList.size>0){
            var body=EditUserInfoBody()
            body.avatar=fileUrlList[0]
            presenter.getEditUserInfo(body)
        }
    }

    override fun sendFileErrorImage() {

    }


    private var cameraSelect = CameraSelect(this)

    override fun returnCameraImageList(list: ArrayList<String>) {
        Log.e("测试返回结果",list.size.toString())
        if (list!=null&&list.size>0&& File(list[0]).length()>0) {
            list.forEach {
                Log.e("测试返回结果图片",it)
            }

            ImageLoad.setImage(list[0],iv_head)

            qiniuPresenter.setImage(list)
//            if (list.size==1) {
//                file = File(list[0])
//            }
        }
    }

    private val qiniuPresenter by lazy { QiniuPresenter(this,this,this) }
    private val presenter by lazy { EditUserInfoPresenter(this,this,this) }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_userinfo

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        cameraSelect.initSingleCameraSdk(this)
        ImageLoad.setUserHead(DBUtil.getUser().avatar,iv_head)
        edit_nickname.setText(DBUtil.getUser().nickname)
    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(layout_head).subscribe {
            cameraSelect.openCamera()
        }

        Click.viewClick(layout_nickname).subscribe {
            edit_nickname.setFocusable(true)
            edit_nickname.setFocusableInTouchMode(true)
            edit_nickname.requestFocus()
            edit_nickname.setSelection(edit_nickname.text.length)
            val inManager = edit_nickname.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        Click.viewClick(edit_nickname).subscribe {
            edit_nickname.setFocusable(true)
            edit_nickname.setFocusableInTouchMode(true)
            edit_nickname.requestFocus()
            edit_nickname.setSelection(edit_nickname.text.length)
            val inManager = edit_nickname.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        edit_nickname.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.length>0){
                    var body=EditUserInfoBody()
                    body.nickname=edit_nickname.text.toString()
                    presenter.getEditUserInfo(body)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        cameraSelect.onActivityCameraResult(requestCode, resultCode, data)
    }
}