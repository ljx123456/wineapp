package yongchao.com.wineapp.ui.set.adapter

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R

import yongchao.com.wineapp.ui.set.mvp.bean.AreaBean

class ProvinceItemAdapter(list: MutableList<AreaBean.DataBean.CitiesBean>): BaseQuickAdapter<AreaBean.DataBean.CitiesBean, BaseViewHolder>(R.layout.item_area_item,list){
    override fun convert(helper: BaseViewHolder, item: AreaBean.DataBean.CitiesBean) {
        helper.setText(R.id.tv_item_area,item.name)
        if (item.flag){
            helper.setTextColor(R.id.tv_item_area,Color.parseColor("#D3AA71"))
                    .setVisible(R.id.iv_choose,true)
        }else{
            helper.setTextColor(R.id.tv_item_area,Color.parseColor("#555555"))
                    .setVisible(R.id.iv_choose,false)
        }
    }

}