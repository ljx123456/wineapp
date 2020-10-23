package yongchao.com.wineapp.ui.classify.mvp.body;

public class GoodsListBody {

    /**
     * goodsTypeId : 1
     * goodsChildTypeId : 3
     * like : 五粮液
     * sortType : 1
     * pageIndex : 1
     * pageSize : 10
     */

    private int goodsTypeId;
    private int goodsChildTypeId;
    private String like;
    private int sortType;
    private int pageIndex;
    private int pageSize;

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public int getGoodsChildTypeId() {
        return goodsChildTypeId;
    }

    public void setGoodsChildTypeId(int goodsChildTypeId) {
        this.goodsChildTypeId = goodsChildTypeId;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
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

    public GoodsListBody() {
    }
}
