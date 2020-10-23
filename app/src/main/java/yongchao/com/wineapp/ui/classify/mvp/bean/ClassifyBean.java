package yongchao.com.wineapp.ui.classify.mvp.bean;

import java.util.ArrayList;

public class ClassifyBean {

    private int code;
    private String message;
    private ArrayList<ClassifyBean.DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ClassifyBean.DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<ClassifyBean.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private int id;
        private Boolean flag=false;

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public DataBean(String name, int id, Boolean flag) {
            this.name = name;
            this.id = id;
            this.flag = flag;
        }
    }

}
