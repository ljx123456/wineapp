package yongchao.com.wineapp.ui.main.mvp.bean;

import java.util.ArrayList;
import java.util.List;

public class BannerBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"id":1,"name":"测试1","image":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg","type":1,"goodsId":1,"details":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"}]
     */

    private int code;
    private String msg;
    private ArrayList<DataBean> data;

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

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 测试1
         * image : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg
         * type : 1
         * goodsId : 1
         * details : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg
         */

        private int id;
        private String name;
        private String image;
        private int type;
        private int goodsId;
        private String details;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}
