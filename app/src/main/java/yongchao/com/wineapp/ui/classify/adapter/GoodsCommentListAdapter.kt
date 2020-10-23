package yongchao.com.wineapp.ui.classify.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import yongchao.com.wineapp.R
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsCommentListBean

import yongchao.com.wineapp.utils.image.ImageLoad

class GoodsCommentListAdapter(var list: MutableList<GoodsCommentListBean.DataBean.ListBean>):BaseQuickAdapter<GoodsCommentListBean.DataBean.ListBean,BaseViewHolder>(R.layout.item_comment,list) {
    override fun convert(helper: BaseViewHolder, item: GoodsCommentListBean.DataBean.ListBean) {

        ImageLoad.setImage(item.userInfo.avatar,helper.getView(R.id.iv_head))

        helper.setText(R.id.tv_name,item.userInfo.nickname)
                .setText(R.id.tv_time,item.createTime)
                .setText(R.id.tv_comment,item.content)

        if (item.images.size>0) {
            helper.setGone(R.id.recy,true)
            var recy = helper.getView<RecyclerView>(R.id.recy)

            var adapter = GoodsCommentImageAdapter(item.images)
            var manager = GridLayoutManager(mContext,3)
            recy.layoutManager = manager
            recy.adapter = adapter
        }else{
            helper.setGone(R.id.recy,false)
        }

    }
}