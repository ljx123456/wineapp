package yongchao.com.wineapp.ui.classify.activity

import android.app.Activity
import android.support.v7.widget.GridLayoutManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_search.*
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseActivity

import yongchao.com.wineapp.ui.classify.adapter.SearchGoodsAdapter
import yongchao.com.wineapp.ui.classify.mvp.bean.GoodsListBean
import yongchao.com.wineapp.ui.classify.mvp.body.GoodsListBody
import yongchao.com.wineapp.ui.classify.mvp.presenter.GoodsListPresenter
import yongchao.com.wineapp.ui.classify.mvp.view.ClassifyGoodsView
import yongchao.com.wineapp.utils.Click
import yongchao.com.wineapp.utils.Toast

class SearchGoodsActivity:BaseActivity() ,ClassifyGoodsView{
    override fun getGoodsListRequest(data: GoodsListBean) {
        if (pageIndex==1) {
            adapter = SearchGoodsAdapter(data.data)
            var manager = GridLayoutManager(this, 2)
            recy.layoutManager = manager
            recy.adapter = adapter
        }else{
            adapter.addData(data.data)
        }

        adapter.setOnLoadMoreListener(object:BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {
                pageIndex=pageIndex+1
                var body=GoodsListBody()
                body.pageIndex=pageIndex
                body.pageSize=pageSize
                body.sortType=0
                body.like=search
                presenter.getGoodList(body)
            }
        },recy)

        if (data.data.size<10){
            adapter.loadMoreEnd()
        }else{
            adapter.loadMoreComplete()
        }
    }

    override fun getGoodsListError() {

    }

    private lateinit var adapter:SearchGoodsAdapter
    private val presenter by lazy { GoodsListPresenter(this,this,this) }
    private var pageIndex=1
    private var pageSize=10
    private var search=""

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_search

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        edit_search.requestFocus()
        var imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edit_search, InputMethodManager.SHOW_IMPLICIT)

    }

    override fun clickListener() {
        Click.viewClick(tv_cancel).subscribe {
            finish()
        }


        edit_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId== EditorInfo.IME_ACTION_SEARCH){
                if (edit_search.text!=null&&edit_search.text.toString().isNotEmpty()){
                    search=edit_search.text.toString()
                    pageIndex=1
                    var body=GoodsListBody()
                    body.pageIndex=pageIndex
                    body.pageSize=pageSize
                    body.sortType=0
                    body.like=search
                    presenter.getGoodList(body)
                }else{
                    Toast.Tips("请输入搜索内容")
                }
                val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(edit_search.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
            }
            return@setOnEditorActionListener false
        }
    }



}