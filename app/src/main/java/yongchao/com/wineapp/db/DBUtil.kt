package yongchao.com.wineapp.db

import android.util.Log
import com.blankj.utilcode.util.LogUtils
import yongchao.com.wineapp.db.GreenDaoHelper.getDaoSessions
import yongchao.com.wineapp.ui.login.mvp.bean.LoginBean

object DBUtil{

    fun getUser(): UserDB {
        var user = getDaoSessions().userDBDao
        var data = user.loadAll().get(0)
        return data
    }

    fun setUser(info:LoginBean.DataBean){

        Log.e("测试","测试1")
        var name=""
        if (info.info.nickname!=null){
            name=info.info.nickname
        }
        var avatar=""
        if (info.info.avatar!=null){
            avatar=info.info.avatar
        }
        var code=""
        if (info.info.inviteCode!=null){
            code=info.info.inviteCode
        }
        Log.e("测试","测试2")
        var userDB=UserDB(0,info.token,info.info.id,name,avatar,info.info.phone,code,info.info.role)
        var userdata = getDaoSessions().userDBDao
        if (userdata != null) {
            userdata.deleteAll()
        }
        Log.e("测试","测试3")
        try {
            userdata.insert(userDB)
        } catch (e: Exception) {
            LogUtils.a("DB", e.toString())
        }

    }

    fun DelUser(){
        var user = getDaoSessions().userDBDao
        user.deleteAll()
    }
}