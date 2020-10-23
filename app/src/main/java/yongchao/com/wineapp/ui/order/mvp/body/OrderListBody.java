package yongchao.com.wineapp.ui.order.mvp.body;

public class OrderListBody {

    /**
     * state : 1
     * pageIndex : 1
     * pageSize : 10
     */

    private int state;
    private int pageIndex;
    private int pageSize;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public OrderListBody(int state, int pageIndex, int pageSize) {
        this.state = state;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
