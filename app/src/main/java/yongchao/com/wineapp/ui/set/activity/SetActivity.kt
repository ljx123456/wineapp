package yongchao.com.wineapp.ui.set.activity

import kotlinx.android.synthetic.main.activity_set.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.dialog.LogoutDialog
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class SetActivity:BaseActivity() ,LogoutDialog.LogoutDialogFace{
    override fun logoutBtn() {

    }

    override fun cancelBtn() {

    }

    private lateinit var dialog : LogoutDialog

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_set

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        dialog= LogoutDialog(this)
        dialog.setDialogFace(this)
    }

    override fun clickListener() {

        Click.viewClick(back).subscribe {
            finish()
        }
        Click.viewClick(tv_data).subscribe {
            intentUtils.intentUserInfo()
        }

        Click.viewClick(tv_logout).subscribe {
            dialog.showDialog()
        }

    }
}