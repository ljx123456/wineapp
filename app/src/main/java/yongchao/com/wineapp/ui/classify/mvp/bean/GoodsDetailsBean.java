package yongchao.com.wineapp.ui.classify.mvp.bean;

import java.util.List;

public class GoodsDetailsBean {


    /**
     * code : 0
     * msg : 请求成功
     * data : {"goodsId":1,"goodsName":"53度茅台王子酒500ml","sellingPrice":168,"price":228,"specValue":500,"spec":"ML","unit":"瓶","images":["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"],"details":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg","deliverFee":20,"isFavorite":true}
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
         * goodsId : 1
         * goodsName : 53度茅台王子酒500ml
         * sellingPrice : 168
         * price : 228
         * specValue : 500
         * spec : ML
         * unit : 瓶
         * images : ["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"]
         * details : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg
         * deliverFee : 20
         * isFavorite : true
         */

        private int goodsId;
        private String goodsName;
        private int sellingPrice;
        private int price;
        private int specValue;
        private String spec;
        private String unit;
        private String details;
        private int deliverFee;
        private boolean isFavorite;
        private List<String> images;

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

        public int getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(int sellingPrice) {
            this.sellingPrice = sellingPrice;
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

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public int getDeliverFee() {
            return deliverFee;
        }

        public void setDeliverFee(int deliverFee) {
            this.deliverFee = deliverFee;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
