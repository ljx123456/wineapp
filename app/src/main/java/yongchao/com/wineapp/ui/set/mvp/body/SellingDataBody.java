package yongchao.com.wineapp.ui.set.mvp.body;

public class SellingDataBody {

    /**
     * type : 0
     * time : 2020-10-09 14:24:25
     */

    private int type;
    private String time;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SellingDataBody(int type, String time) {
        this.type = type;
        this.time = time;
    }

}
