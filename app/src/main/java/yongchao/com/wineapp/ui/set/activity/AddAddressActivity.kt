package yongchao.com.wineapp.ui.set.activity

import kotlinx.android.synthetic.main.activity_add_address.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.dialog.AreaDialog
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.AddAddressBody
import yongchao.com.wineapp.ui.set.mvp.presenter.AddAddressPresenter
import yongchao.com.wineapp.ui.set.mvp.view.AddAddressView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.Toast

class AddAddressActivity:BaseActivity() ,AddAddressView, AreaDialog.CallBack{
    override fun choose(p_id: Int, c_id: Int, a_id: Int) {
        districtId=a_id
    }

    override fun getAddAddressRequest(data: SuccessBean) {
        Toast.Tips("添加成功")
        finish()
    }

    override fun getAddAddressError() {

    }

    private val presenter by lazy { AddAddressPresenter(this,this,this) }
    private var districtId=0

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_add_address

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(back).subscribe { finish() }
        Click.viewClick(edit_area).subscribe {
            var dialog= AreaDialog(edit_area)
            dialog.setCallBack(this)
            dialog.show(supportFragmentManager,"")
        }

        Click.viewClick(tv_keep).subscribe {
            if (edit_name.text!=null&&edit_name.text.toString().isNotEmpty()&&edit_phone.text!=null&&edit_phone.text.toString().isNotEmpty()
                    &&edit_address.text!=null&&edit_address.text.toString().isNotEmpty()&&edit_area.text!=null&&edit_area.text.toString().isNotEmpty()){
                presenter.getAddAddress(AddAddressBody(districtId,edit_name.text.toString(),edit_phone.text.toString(),edit_address.text.toString(),cb.isChecked))
            }else{
                Toast.Tips("请填写完整的收货地址")
            }
        }
    }
}