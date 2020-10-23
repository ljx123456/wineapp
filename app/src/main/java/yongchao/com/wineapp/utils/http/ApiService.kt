package  yongchao.com.wineapp.utils.http

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import yongchao.com.wineapp.ui.classify.mvp.bean.*
import yongchao.com.wineapp.ui.classify.mvp.body.*
import yongchao.com.wineapp.ui.login.mvp.bean.*
import yongchao.com.wineapp.ui.login.mvp.body.*
import yongchao.com.wineapp.ui.main.mvp.bean.*
import yongchao.com.wineapp.ui.order.mvp.bean.*
import yongchao.com.wineapp.ui.order.mvp.body.*
import yongchao.com.wineapp.ui.set.mvp.bean.*
import yongchao.com.wineapp.ui.set.mvp.body.*

/**
 * Created by Administrator on 2017/12/18 0018.
 */
interface ApiService {

    //发送验证码
    @POST("sendLoginCode")
    fun getCode(@Body body: CodeBody): Observable<CodeBean>

    //验证码登录
    @POST("login")
    fun getLogin(@Body body: LoginBody): Observable<LoginBean>

    //获取七牛token
    @POST("user/uploadToken")
    fun getQiniuToken(): Observable<QiniuTokenBean>

    //绑定商家
    @POST("user/bindAgent")
    fun getLoginBind(@Body body: LoginBindBody): Observable<LoginBindBean>

    //首页banner
    @POST("home/banner")
    fun getBanner(): Observable<BannerBean>

    //商品分类
    @POST("goods/types")
    fun getGoodsType(): Observable<GoodsTypeBean>

    //商品列表
    @POST("goods/list")
    fun getGoodsList(@Body body:GoodsListBody): Observable<GoodsListBean>

    //商品详情
    @POST("goods/details")
    fun getGoodsDetails(@Body body:GoodsDetailsBody): Observable<GoodsDetailsBean>

    //商品评论列表
    @POST("comm/list")
    fun getGoodsCommentList(@Body body:GoodsCommentListBody): Observable<GoodsCommentListBean>

    //用户信息
    @POST("goods/details")
    fun getUserInfo(): Observable<UserInfoBean>

    //用户收货地址
    @POST("user/address")
    fun getAddressList(@Body body:AddressListBody): Observable<AddressListBean>

    //获取地区列表
    @POST("loginRegistry/regions/list")
    fun getArea(@Body body: AreaBody): Observable<AreaBean>

    //新增收货地址
    @POST("user/address/add")
    fun getAddAddress(@Body body:AddAddressBody): Observable<SuccessBean>

    //编辑收货地址
    @POST("user/address/edit")
    fun getEditAddress(@Body body:EditAddressBody): Observable<SuccessBean>

    //删除收货地址
    @POST("user/address/del")
    fun getDelAddress(@Body body:DelAddressBody): Observable<SuccessBean>

    //编辑用户信息
    @POST("user/info/edit")
    fun getEditUserInfo(@Body body:EditUserInfoBody): Observable<SuccessBean>

    //收藏列表
    @POST("user/fav")
    fun getCollectList(@Body body:CollectListBody): Observable<CollectListBean>

    //销售数据
    @POST("user/sellingData")
    fun getSellingData(@Body body:SellingDataBody): Observable<SellingDataBean>

    //订单列表
    @POST("order/list")
    fun getOrderList(@Body body: OrderListBody): Observable<OrderListBean>

}