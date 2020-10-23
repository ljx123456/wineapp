package yongchao.com.wineapp.ui.login.activity

import kotlinx.android.synthetic.main.activity_login_code.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.db.DBUtil
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean
import yongchao.com.wineapp.ui.login.mvp.body.CodeBody
import yongchao.com.wineapp.ui.login.mvp.body.LoginBody
import yongchao.com.wineapp.ui.login.mvp.presenter.LoginCodePresenter
import yongchao.com.wineapp.ui.login.mvp.view.LoginCodeView
import yongchao.com.wineapp.ui.login.util.CodeTime
import yongchao.com.wineapp.utils.intent.intentUtils

class LoginCodeActivity:BaseActivity() ,LoginCodeView{
    override fun getLoginCodeRequest(data: LoginBean) {

        if (data.data.isIsRegister){
            intentUtils.intentBind()
        }else{
            DBUtil.setUser(data.data)
            intentUtils.intentMain()
        }

    }

    override fun getLoginCodeError() {

    }

    private val presenter by lazy { LoginCodePresenter(this,this,this) }
    private val codeTime = CodeTime()

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_login_code

    override fun setActivityTitle() {
        tv_phone.text="验证码已发送至："+intent.getStringExtra("phone").replaceRange(3,7,"****")
        codeTime.codeCountTimer(btn)
    }

    override fun initActivityData() {
        presenter.getCode(CodeBody(intent.getStringExtra("phone")))

    }

    override fun clickListener() {
        pc_login.finish={
            presenter.getLogin(LoginBody(intent.getStringExtra("phone"),it))
            pc_login.clear()
        }
    }
}