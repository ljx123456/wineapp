package yongchao.com.wineapp.ui.order.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.order.mvp.bean.OrderListBean
import yongchao.com.wineapp.utils.TimeUtils

class OrderListAdapter(val list: MutableList<OrderListBean.DataBean>):BaseQuickAdapter<OrderListBean.DataBean,BaseViewHolder>(R.layout.item_order,list),TimeUtils.TimeUtilCallBack {

    private var callBack:CallBack?=null

    override fun finishTime() {
        callBack!!.finish()
    }
    override fun convert(helper: BaseViewHolder, item: OrderListBean.DataBean) {
        var timeutils = TimeUtils()
        timeutils.setCallBack(this)

        if (item.remainingPayTime != null && item.remainingPayTime > 0) {
//            helper.setVisible(R.id.tv_countdown, false)
            var timeView = helper.getView<TextView>(R.id.tv_countdown)
            timeutils.setEndTimer(item.remainingPayTime.toLong())
            timeutils.codeCountTimerOrder(timeView)
        }
//        else {
//            helper.setVisible(R.id.orderTime, true)
//        }


        when(item.orderState){//状态：-1 订单取消，0 等待付款，1 已付款，待配送，2 配送中，3 已完成，4 退款

            0->{//待付款
                helper.setText(R.id.tv_orderType,"待付款")
                        .setGone(R.id.layout_bottom,true)
                        .setGone(R.id.tv_countdown,true)
                        .setGone(R.id.btn_pay,true)
                        .setGone(R.id.btn_cancel,true)
                        .setGone(R.id.btn_buy_again,false)
                        .setGone(R.id.btn_comment,false)
            }

            1->{//待配送
                helper.setText(R.id.tv_orderType,"待配送")
                        .setGone(R.id.layout_bottom,false)
                        .setGone(R.id.tv_countdown,false)
                        .setGone(R.id.btn_pay,false)
                        .setGone(R.id.btn_cancel,false)
                        .setGone(R.id.btn_buy_again,false)
                        .setGone(R.id.btn_comment,false)
            }

            2->{//配送中
                helper.setText(R.id.tv_orderType,"配送中")
                        .setGone(R.id.layout_bottom,false)
                        .setGone(R.id.tv_countdown,false)
                        .setGone(R.id.btn_pay,false)
                        .setGone(R.id.btn_cancel,false)
                        .setGone(R.id.btn_buy_again,false)
                        .setGone(R.id.btn_comment,false)
            }

            3->{//已完成
                helper.setText(R.id.tv_orderType,"已完成")
                        .setGone(R.id.layout_bottom,true)
                        .setGone(R.id.tv_countdown,false)
                        .setGone(R.id.btn_pay,false)
                        .setGone(R.id.btn_cancel,false)
                        .setGone(R.id.btn_buy_again,true)
                        .setGone(R.id.btn_comment,true)
            }

            4->{//退款

            }

            -1->{//订单取消
                helper.setText(R.id.tv_orderType,"已取消")
                        .setGone(R.id.layout_bottom,true)
                        .setGone(R.id.tv_countdown,false)
                        .setGone(R.id.btn_pay,false)
                        .setGone(R.id.btn_cancel,false)
                        .setGone(R.id.btn_buy_again,true)
                        .setGone(R.id.btn_comment,false)
            }

        }

        helper.setText(R.id.tv_time,item.createTime)
                .setText(R.id.tv_num,"共"+item.totalNum+"件")
                .setText(R.id.tv_price,"合计：¥ "+item.totalMoney)

        var lists = helper.getView(R.id.goodsList) as RecyclerView
        var adapters= ImageAdapter(item.previews)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.HORIZONTAL
        lists.layoutManager = manager
        lists.adapter = adapters

        helper.addOnClickListener(R.id.btn_pay)
                .addOnClickListener(R.id.btn_cancel)
                .addOnClickListener(R.id.btn_buy_again)
                .addOnClickListener(R.id.btn_comment)




    }

    public fun setCallBack(callBack: CallBack){
        this.callBack=callBack
    }

    interface CallBack{
        fun finish()
    }
}