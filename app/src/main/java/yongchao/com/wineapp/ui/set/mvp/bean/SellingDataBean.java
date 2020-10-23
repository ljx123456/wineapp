package yongchao.com.wineapp.ui.set.mvp.bean;

public class SellingDataBean {


    /**
     * code : 0
     * msg : 请求成功
     * data : {"orderNum":1,"sellingAmount":11712,"profit":2092}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderNum : 1
         * sellingAmount : 11712
         * profit : 2092
         */

        private int orderNum;
        private int sellingAmount;
        private int profit;

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public int getSellingAmount() {
            return sellingAmount;
        }

        public void setSellingAmount(int sellingAmount) {
            this.sellingAmount = sellingAmount;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }
}
