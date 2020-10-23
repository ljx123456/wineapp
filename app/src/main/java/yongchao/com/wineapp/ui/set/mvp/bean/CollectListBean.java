package yongchao.com.wineapp.ui.set.mvp.bean;

import java.util.List;

public class CollectListBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"goodsId":1,"goodsName":"53度茅台王子酒500ml","preview":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg","sellingPrice":168,"goodsState":1,"price":228,"specValue":500,"spec":"ML","unit":"瓶"}]
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
         * goodsId : 1
         * goodsName : 53度茅台王子酒500ml
         * preview : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg
         * sellingPrice : 168
         * goodsState : 1
         * price : 228
         * specValue : 500
         * spec : ML
         * unit : 瓶
         */

        private int goodsId;
        private String goodsName;
        private String preview;
        private int sellingPrice;
        private int goodsState;
        private int price;
        private int specValue;
        private String spec;
        private String unit;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public int getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(int sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public int getGoodsState() {
            return goodsState;
        }

        public void setGoodsState(int goodsState) {
            this.goodsState = goodsState;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSpecValue() {
            return specValue;
        }

        public void setSpecValue(int specValue) {
            this.specValue = specValue;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
