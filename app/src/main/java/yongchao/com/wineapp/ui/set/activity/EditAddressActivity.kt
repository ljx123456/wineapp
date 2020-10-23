package yongchao.com.wineapp.ui.set.activity

import kotlinx.android.synthetic.main.activity_edit_address.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.set.dialog.AreaDialog
import yongchao.com.wineapp.ui.set.mvp.bean.SuccessBean
import yongchao.com.wineapp.ui.set.mvp.body.DelAddressBody
import yongchao.com.wineapp.ui.set.mvp.body.EditAddressBody
import yongchao.com.wineapp.ui.set.mvp.presenter.EditAddressPresenter
import yongchao.com.wineapp.ui.set.mvp.view.EditAddressView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.Toast

class EditAddressActivity:BaseActivity(),EditAddressView ,AreaDialog.CallBack{
    override fun choose(p_id: Int, c_id: Int, a_id: Int) {
        districtId=a_id
    }

    private val presenter by lazy { EditAddressPresenter(this,this,this) }
    private var id=0
    private var districtId=0

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_edit_address

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        edit_name.setText(intent.getStringExtra("name"))
        edit_phone.setText(intent.getStringExtra("phone"))
        edit_area.setText(intent.getStringExtra("area"))
        edit_address.setText(intent.getStringExtra("address"))
        id=intent.getIntExtra("id",0)
        districtId=intent.getIntExtra("districtId",0)
        cb.isChecked=intent.getBooleanExtra("isDefault",false)
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
                presenter.getEditAddress(EditAddressBody(id,districtId,edit_name.text.toString(),edit_phone.text.toString(),edit_address.text.toString(),cb.isChecked))
            }else{
                Toast.Tips("请填写完整的收货地址")
            }
        }

        Click.viewClick(tv_del).subscribe {
            var list=ArrayList<Int>()
            list.add(id)
            presenter.getDelAddress(DelAddressBody(list))
        }
    }

    override fun getEditAddressRequest(data: SuccessBean) {
        Toast.Tips("编辑成功")
        finish()
    }

    override fun getEditAddressError() {

    }

    override fun getDelAddressRequest(data: SuccessBean) {
        Toast.Tips("删除成功")
        finish()
    }

    override fun getDelAddressError() {

    }
}