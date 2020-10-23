package yongchao.com.wineapp.ui.order.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_order_details.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.order.adapter.GoodsOrderAdapter
import yongchao.com.wineapp.ui.shoppingcart.mvp.bean.ShoppingCartGoodsBean
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.intent.intentUtils

class OrderDetailsActivity:BaseActivity(){

    private lateinit var adapter:GoodsOrderAdapter
    var list=ArrayList<ShoppingCartGoodsBean.DataBean>()

    override fun openEventBus(): Boolean = false
    override fun getActivityLayout(): Int = R.layout.activity_order_details

    override fun setActivityTitle() {

    }

    override fun initActivityData() {

        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","125.00","1664白啤啤酒",3,"500ml*1罐","箱(12罐)",1))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","220.00","科罗娜啤酒",10,"500ml*1罐","箱(12罐)",2))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","100.00","青岛啤酒",3,"500ml*1罐","箱(12罐)",3))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","80.00","雪花啤酒",1,"500ml*1罐","箱(12罐)",4))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","40.00","嘉士伯啤酒",5,"500ml*1罐","箱(12罐)",5))

        adapter= GoodsOrderAdapter(list,true)
        var manager= LinearLayoutManager(this)
        manager.orientation= LinearLayout.VERTICAL
        recy_goods.layoutManager=manager
        recy_goods.adapter=adapter

        adapter.setOnItemChildClickListener { mAdapter, view, position ->

            intentUtils.intentGoodsComment()

        }
    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        Click.viewClick(btn_pay).subscribe {

        }


    }
}