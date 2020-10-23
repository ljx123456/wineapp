package yongchao.com.wineapp.utils

import android.view.LayoutInflater
import android.view.View
import yongchao.com.wineapp.R
import yongchao.com.wineapp.base.BaseContext.getContext


object layoutUtils {

    fun getNoneSearch(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_none_search, null)
    }
//

    fun getNoneAddress(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_none_address, null)
    }

    fun getNoneCollect(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_none_collect, null)
    }

    fun getNoneShoppingcart(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_none_shoppingcart, null)
    }

    fun getNoneOrder(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_none_order, null)
    }



}