package yongchao.com.wineapp.ui.main.mvp.bean;

import java.util.List;

public class GoodsTypeBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"id":1,"name":"白酒","children":[{"id":2,"name":"茅台"}]}]
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
         * id : 1
         * name : 白酒
         * children : [{"id":2,"name":"茅台"}]
         */

        private int id;
        private String name;
        private List<ChildrenBean> children;


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

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 2
             * name : 茅台
             */

            private int id;
            private String name;
            private boolean flag=false;

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }

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
        }


        public DataBean() {
        }
    }
}
