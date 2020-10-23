package yongchao.com.wineapp.qiniu

/**
 * Created by Administrator on 2018/10/12 0012.
 */
interface SendFileInterface {

    fun sendSucceed(fileUrlList: ArrayList<String>)
    fun sendFileError(msg: String)


}