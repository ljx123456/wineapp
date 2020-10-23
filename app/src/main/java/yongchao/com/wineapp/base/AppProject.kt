package yongchao.com.wineapp.base

import android.app.Notification
import android.content.Context
import io.reactivex.internal.functions.Functions
import io.reactivex.plugins.RxJavaPlugins
import yongchao.com.wineapp.db.GreenDaoHelper.initDatabase

class AppProject:BaseApplication() {


    override fun initCreate() {
        //context初始化
        BaseContext.initContext(this)

        //RxJava异常处理
//        RxJavaPlugins.setErrorHandler {
//            Log.e("测试","onRxJavaErrorHandler ---->: $it")
//        }
        RxJavaPlugins.setErrorHandler(Functions.emptyConsumer())
        //初始化数据库
        initDatabase(this)

        //初始化极光
        initJPush(this)

        //初始化微博
        initWeibo()

        //注册到微信
        regToWx()

        initImageLoader()
    }

    override fun initLibrary() {
        //七牛云初始化
//        initConfiguration()
    }

    override fun initDataSave() {

    }

    fun initJPush(context: Context) {
//        JPushInterface.setDebugMode(true)
//        JPushInterface.init(context)
//        setStyleBasic(context)
//
//        JMessageClient.setDebugMode(true)
//        JMessageClient.init(context)
//        JMessageClient.registerEventReceiver(this)
//        setTag(context)
    }

    /**
     * 激光推送设置通知提示方式 - 基础属性
     */
    private fun setStyleBasic(context: Context) {
//        val builder = BasicPushNotificationBuilder(context)
//        builder.statusBarDrawable = R.mipmap.ic_launcher
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
//        builder.notificationDefaults = Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS
//        JPushInterface.setPushNotificationBuilder(1, builder)

//        val builder = BasicPushNotificationBuilder(context)
//        builder.statusBarDrawable = R.mipmap.ic_app
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL or Notification.FLAG_SHOW_LIGHTS  //设置为自动消失和呼吸灯闪烁
//        builder.notificationDefaults = (Notification.DEFAULT_SOUND
//                or Notification.DEFAULT_VIBRATE
//                or Notification.DEFAULT_LIGHTS)  // 设置为铃声、震动、呼吸灯闪烁都要
//        JPushInterface.setPushNotificationBuilder(1, builder)

    }

    private fun initImageLoader() {
//        val configuration = ImageLoaderConfiguration.createDefault(this)
//        ImageLoader.getInstance().init(configuration)

    }

    /**
     * 初始化微博
     */

    private fun initWeibo() {
//        var authInfo = AuthInfo(this, "22909893", "https://api.weibo.com/oauth2/default.html", null)
////        var mWBAPI=WBAPIFactory.createWBAPI(this)
////        mWBAPI.registerApp(this,authInfo)
//        WbSdk.install(this, authInfo)
    }

    /**
     * 初始化微信
     */
    fun regToWx() {
//        val APP_ID = "wx8730168ee272799a"
//        var api: IWXAPI = WXAPIFactory.createWXAPI(this, APP_ID, true)
//        api.registerApp(APP_ID)
    }
}