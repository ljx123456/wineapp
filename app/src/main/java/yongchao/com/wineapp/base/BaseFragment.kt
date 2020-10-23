package yongchao.com.wineapp.base

import android.content.DialogInterface
import android.view.View


import com.blankj.utilcode.util.ActivityUtils

import org.greenrobot.eventbus.EventBus



open abstract class BaseFragment : FatherFragment() {


    override fun onCreateFragment(contentView: View?) {
        openActivityEventBus()
        setLayoutTitle()
        initFragmentData()
        setFragmentListener()
//        //注册sdk的event用于接收各种event事件
//        JMessageClient.registerEventReceiver(this)
    }

    protected abstract fun openEventBus(): Boolean

    protected abstract fun setLayoutTitle()

    protected abstract fun initFragmentData()

    protected abstract fun setFragmentListener()

//    fun show() {
//        LoadDialog.show(mContext)
//    }
//
//    fun dismiss() {
//        LoadDialog.dismiss(mContext)
//    }

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

//    fun onEventMainThread(event: LoginStateChangeEvent) {


//    }


}
