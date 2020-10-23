package yongchao.com.wineapp.ui.classify.mvp.body;

public class GoodsCommentListBody {


    /**
     * goodsId : 1
     * pageIndex : 1
     * pageSize : 10
     */

    private String goodsId;
    private int pageIndex;
    private int pageSize;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public GoodsCommentListBody(String goodsId, int pageIndex, int pageSize) {
        this.goodsId = goodsId;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
