package yongchao.com.wineapp.base
import android.content.Context
import yongchao.com.wineapp.utils.dialog.LoadDialog


/**
 * Created by Administrator on 2017/12/18 0018.
 */
interface BaseView {

    fun showLoading(context: Context) {
        LoadDialog.show(context)
    }

    fun dismissLoading(context: Context) {
        LoadDialog.dismiss(context)
    }


}