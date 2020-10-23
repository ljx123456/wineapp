package yongchao.com.wineapp.ui.login.activity

import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_login_bind.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBindBean
import yongchao.com.wineapp.ui.login.mvp.body.LoginBindBody
import yongchao.com.wineapp.ui.login.mvp.presenter.LoginBindPresenter
import yongchao.com.wineapp.ui.login.mvp.view.LoginBindView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class LoginBindActivity:BaseActivity() ,LoginBindView{
    override fun getLoginBindRequest(data: LoginBindBean) {
        intentUtils.intentMain()
    }

    override fun getLoginBindError() {

    }


    private val presenter by lazy { LoginBindPresenter(this,this,this) }
    override fun openEventBus(): Boolean = false
    override fun getActivityLayout(): Int = R.layout.activity_login_bind

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(tv_skip).subscribe {
            intentUtils.intentMain()
        }

        edit_bind.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.isNotEmpty()&&s.toString().length>0){
                    btn_bind.isEnabled=true
                }else{
                    btn_bind.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        Click.viewClick(btn_bind).subscribe {
            presenter.getBind(LoginBindBody(edit_bind.text.toString()))
        }


    }
}