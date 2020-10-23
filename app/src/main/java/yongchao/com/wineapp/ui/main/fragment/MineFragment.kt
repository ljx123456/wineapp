package yongchao.com.wineapp.ui.main.fragment

import android.view.View
import kotlinx.android.synthetic.main.fragment_mine.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseFragment
import yongchao.com.wineapp.db.DBUtil
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean
import yongchao.com.wineapp.ui.set.mvp.bean.UserInfoBean
import yongchao.com.wineapp.ui.set.mvp.presenter.MinePresenter
import yongchao.com.wineapp.ui.set.mvp.view.MineView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.image.ImageLoad
import yongchao.com.wineapp.utils.intent.intentUtils

class MineFragment:BaseFragment(),MineView {
    override fun getUserInfoRequest(data: UserInfoBean) {
        ImageLoad.setUserHead(data.data.avatar,iv_user)
        tv_id.text=data.data.role.toString()

        if (data.data.role==0){//用户
            tv_role.text="成为经销商"
            tv_phone.setBackgroundResource(R.drawable.tv_mine_bg)
            tv_phone.text="联系我们"
            tv_data.visibility=View.GONE
        }else{
            tv_role.text="我的邀请码："
            tv_phone.setBackground(null)
            tv_phone.text=data.data.inviteCode
            tv_data.visibility=View.VISIBLE
        }


        var info=LoginBean.DataBean.InfoBean()
        info.avatar=data.data.avatar
        info.createTime=data.data.createTime
        info.role=data.data.role
        info.id=data.data.id
        info.nickname=data.data.nickname
        info.inviteCode=data.data.inviteCode
        info.phone=DBUtil.getUser().phone
        var bean=LoginBean.DataBean()
        bean.info=info
        bean.token=DBUtil.getUser().token
        DBUtil.setUser(bean)

    }

    override fun getUserInfoError() {

    }

    private val presenter by lazy { MinePresenter(this,this,activity!!) }

    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {

    }

    override fun initFragmentData() {

    }

    override fun setFragmentListener() {

        Click.viewClick(tv_set).subscribe {
            intentUtils.intentSet()
        }

        Click.viewClick(tv_address).subscribe {
            intentUtils.intentMyAddress()
        }

        Click.viewClick(tv_collect).subscribe {
            intentUtils.intentCollect()
        }

        Click.viewClick(tv_data).subscribe {
            intentUtils.intentData()
        }
    }

    override fun layoutID(): Int = R.layout.fragment_mine

    override fun onResume() {
        super.onResume()
        presenter.getUserInfo()
    }
}