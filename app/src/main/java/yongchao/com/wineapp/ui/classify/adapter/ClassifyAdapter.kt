package yongchao.com.wineapp.ui.classify.adapter

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.classify.mvp.bean.ClassifyBean
import yongchao.com.wineapp.ui.main.mvp.bean.GoodsTypeBean

class ClassifyAdapter(list: MutableList<GoodsTypeBean.DataBean.ChildrenBean>):BaseQuickAdapter<GoodsTypeBean.DataBean.ChildrenBean,BaseViewHolder>(R.layout.item_classify,list) {
    override fun convert(helper: BaseViewHolder, item: GoodsTypeBean.DataBean.ChildrenBean) {
        helper.setText(R.id.tv_name,item.name)

        if (item.isFlag){
            helper.setBackgroundColor(R.id.layout,Color.parseColor("#FFFFFF"))
                    .setGone(R.id.view,true)
        }else{
            helper.setBackgroundColor(R.id.layout,Color.parseColor("#14D3AA71"))
                    .setGone(R.id.view,false)
        }
    }
}