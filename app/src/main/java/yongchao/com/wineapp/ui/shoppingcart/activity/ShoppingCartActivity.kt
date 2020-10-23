package yongchao.com.wineapp.ui.shoppingcart.activity

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_shoppingcart.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity
import yongchao.com.wineapp.ui.shoppingcart.adapter.ShoppingCartAdapter
import yongchao.com.wineapp.ui.shoppingcart.dialog.GoodsTypeDialog
import yongchao.com.wineapp.ui.shoppingcart.mvp.bean.ShoppingCartGoodsBean
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.Toast
import java.math.BigDecimal

class ShoppingCartActivity:BaseActivity(),GoodsTypeDialog.GoodsTypeDialogFace {
    override fun sureBtn() {

    }

    private lateinit var adapter:ShoppingCartAdapter
    private var type=0
    private var money=BigDecimal(0)
    private var all=true
    var list=ArrayList<ShoppingCartGoodsBean.DataBean>()
    private lateinit var dialog:GoodsTypeDialog

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_shoppingcart
    override fun setActivityTitle() {

    }

    override fun initActivityData() {


        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","125.00","1664白啤啤酒",3,"箱(12罐)","罐",1))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","220.00","科罗娜啤酒",10,"箱(12罐)","箱",2))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","100.00","青岛啤酒",3,"箱(12罐)","罐",3))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","80.00","雪花啤酒",1,"箱(12罐)","罐",4))
        list.add(ShoppingCartGoodsBean.DataBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1586761644&di=ef204bd849a54db427c4bd09fc4bbe39&src=http://pic1.16pic.com/00/07/22/16pic_722454_b.jpg","40.00","嘉士伯啤酒",5,"箱(12罐)","罐",5))

        adapter= ShoppingCartAdapter(list)
        var manager=LinearLayoutManager(this)
        manager.orientation=LinearLayout.VERTICAL
        recy.layoutManager=manager
        recy.adapter=adapter

        adapter.setOnItemChildClickListener { mAdapter, view, position ->
            when(view.id){
                R.id.cb->{
                    all=false
                    if (adapter.data[position].flag==false){
                        adapter.data[position].flag=true
                    }else{
                        adapter.data[position].flag=false
                        cb.isChecked=false
                    }
                    adapter.notifyDataSetChanged()
                    all=true
                }

                R.id.iv_reduce->{
                    if (adapter.data[position].num>1){
                        adapter.data[position].num=adapter.data[position].num-1
//                        adapter.notifyItemChanged(position)
                        (adapter.getViewByPosition(recy,position,R.id.tv_num) as TextView).text=adapter.data[position].num.toString()
                    }
                }

                R.id.iv_add->{
                    adapter.data[position].num=adapter.data[position].num+1

//                    adapter.notifyItemChanged(position)
                    (adapter.getViewByPosition(recy,position,R.id.tv_num) as TextView).text=adapter.data[position].num.toString()
                }

                R.id.tv_type ->{
                    dialog= GoodsTypeDialog(this)
                    dialog.setDialogFace(this)
                    dialog.showDialog()
                }
            }

        }


    }

    override fun clickListener() {
        Click.viewClick(back).subscribe {
            finish()
        }

        cb.setOnCheckedChangeListener { buttonView, isChecked ->
            if (all) {
                if (isChecked) {
                    adapter.data.forEachIndexed { index, dataBean ->
                        adapter.data[index].flag = true
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    adapter.data.forEachIndexed { index, dataBean ->
                        adapter.data[index].flag = false
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }

        Click.viewClick(tv_set).subscribe {
            if (type==0){
                type=1
                tv_set.text="完成"
                layout_price.visibility=View.GONE
                tv_do.text="删除"
            }else{
                type=0
                tv_set.text="编辑"
                layout_price.visibility=View.VISIBLE
                tv_do.text="结算"
            }
        }

        Click.viewClick(tv_do).subscribe {
            Log.e("点击","点击"+type)
            if (type==0){
                Toast.Tips("结算")
            }else{
                var li=ArrayList<ShoppingCartGoodsBean.DataBean>()
                Log.e("点击","删除点击"+adapter.data.size)
                adapter.data.forEachIndexed { index, dataBean ->
                    if (adapter.data[index].flag==true){
                        Log.e("点击","删除+"+index)
//                        adapter.remove(index)
                        li.add(dataBean)
                    }
                }
                Log.e("点击","list大小"+list.size)

                if (li.size==adapter.data.size){
                    adapter.setNewData(null)
                    recy.visibility=View.INVISIBLE
                }else{
                    adapter.data.removeAll(li)
                    adapter.notifyDataSetChanged()
                }


                Log.e("点击","删除后"+adapter.data.size)

            }
        }
    }
}