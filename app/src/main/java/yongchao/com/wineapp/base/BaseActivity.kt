package yongchao.com.wineapp.base

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.OnApplyWindowInsetsListener
import android.support.v4.view.ViewCompat
import android.support.v4.view.WindowInsetsCompat
import android.view.View
import org.greenrobot.eventbus.EventBus


/**
 * Created by Administrator on 2017/12/18 0018.
 */
abstract class BaseActivity : BaseAppActivity() {




    override fun onStartActivity(bundle: Bundle?) {
        setContentView(getActivityLayout())
//        onSavedInstanceState(bundle)
        openActivityEventBus()
        setActivityTitle()
        initActivityData()
        clickListener()
        //注册sdk的event用于接收各种event事件
//        JMessageClient.registerEventReceiver(this)
    }


    protected abstract fun openEventBus(): Boolean

    protected abstract fun getActivityLayout(): Int

    protected abstract fun setActivityTitle()

    protected abstract fun initActivityData()

    protected abstract fun clickListener()


    protected open fun onSavedInstanceState(bundle: Bundle?) {

    }


    private fun openActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().register(this)
        }
    }

    private fun closeActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        closeActivityEventBus()
//        JMessageClient.unRegisterEventReceiver(this)
    }

//    private fun setTitleColor() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = resources.getColor(R.color.content_color)
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//    }

//    fun showLoading() = LoadDialog.show(mContext)
//
//
//    fun dismissLoading() = LoadDialog.dismiss(mContext)

//    fun onEventMainThread(event: LoginStateChangeEvent) {
//        val reason = event.reason
//        val myInfo = event.myInfo
//    }


}