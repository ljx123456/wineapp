package yongchao.com.wineapp.ui.main.mvp.bean;

public class QiniuTokenBean {


    /**
     * code : 0
     * msg : 请求成功
     * data : {"uploadToken":"a-eT7dVVA0PgfHo0rgGL1NMVtLLSqe5lyiVtU8YE:4yaS1KeJnkoK5BxhLfil67QpFYY=:eyJzY29wZSI6IndpbmUtc3RvcmFnZSIsImRlYWRsaW5lIjoxNjAyMjk5NzQ1fQ=="}
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
         * uploadToken : a-eT7dVVA0PgfHo0rgGL1NMVtLLSqe5lyiVtU8YE:4yaS1KeJnkoK5BxhLfil67QpFYY=:eyJzY29wZSI6IndpbmUtc3RvcmFnZSIsImRlYWRsaW5lIjoxNjAyMjk5NzQ1fQ==
         */

        private String uploadToken;

        public String getUploadToken() {
            return uploadToken;
        }

        public void setUploadToken(String uploadToken) {
            this.uploadToken = uploadToken;
        }
    }
}
