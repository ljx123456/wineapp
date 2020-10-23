package yongchao.com.wineapp.utils

import android.view.Gravity
import com.blankj.utilcode.util.ToastUtils
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseContext.getContext


/**
 * Created by Administrator on 2018/2/1 0001.
 */
object Toast {

    fun Tips(msg: String) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 150)
        ToastUtils.setBgColor(getContext().resources.getColor(R.color.toastBg))
        ToastUtils.setMsgColor(getContext().resources.getColor(R.color.toastColor))
        ToastUtils.showShort(msg)
    }

    fun LongTips(msg: String) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 150)
        ToastUtils.setBgColor(getContext().resources.getColor(R.color.toastBg))
        ToastUtils.setMsgColor(getContext().resources.getColor(R.color.toastColor))
        ToastUtils.showLong(msg)
    }
}