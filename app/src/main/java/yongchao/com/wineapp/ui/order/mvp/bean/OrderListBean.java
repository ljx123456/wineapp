package yongchao.com.wineapp.ui.order.mvp.bean;

import java.util.List;

public class OrderListBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"orderNo":"20100910472432784330","createTime":"2020-10-09 10:47:19","orderState":0,"totalMoney":11732,"totalNum":5,"previews":["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776","3124788629&fm=26&gp=0.jpg","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776","3124788629&fm=26&gp=0.jpg"],"remainingPayTime":2738}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderNo : 20100910472432784330
         * createTime : 2020-10-09 10:47:19
         * orderState : 0
         * totalMoney : 11732
         * totalNum : 5
         * previews : ["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776","3124788629&fm=26&gp=0.jpg","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776","3124788629&fm=26&gp=0.jpg"]
         * remainingPayTime : 2738
         */

        private String orderNo;
        private String createTime;
        private int orderState;
        private int totalMoney;
        private int totalNum;
        private int remainingPayTime;
        private List<String> previews;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getOrderState() {
            return orderState;
        }

        public void setOrderState(int orderState) {
            this.orderState = orderState;
        }

        public int getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(int totalMoney) {
            this.totalMoney = totalMoney;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getRemainingPayTime() {
            return remainingPayTime;
        }

        public void setRemainingPayTime(int remainingPayTime) {
            this.remainingPayTime = remainingPayTime;
        }

        public List<String> getPreviews() {
            return previews;
        }

        public void setPreviews(List<String> previews) {
            this.previews = previews;
        }
    }
}
