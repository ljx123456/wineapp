package yongchao.com.wineapp.ui.login.activity

import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_login.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.login.mvp.view.CodeView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class LoginActivity:BaseActivity(){
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_login

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        edit_login_phone.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.isNotEmpty()&&s.toString().length==11){
                    btn.isEnabled=true
                }else{
                    btn.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        Click.viewClick(btn).subscribe {
            intentUtils.intentLoginCode(edit_login_phone.text.toString())
        }
    }
}