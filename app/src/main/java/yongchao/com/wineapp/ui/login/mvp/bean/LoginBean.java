package yongchao.com.wineapp.ui.login.mvp.bean;

public class LoginBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : {"token":" 69TWUq3enYpuorqeJKhYIb3 LgBuUxbADWh3X4Go7t7sBFSgG6a9gkC4fycISQ06JSiLwxD7cI2Ef3E8SZh5r io2E69ijGc7ak15Unf906X/9KBrwDgKrpLUIbhi8afoh 0eBkiaOogJ8yWLzLTw==","loginExTimeStamp":1601277388499,"info":{"id":2,"nickname":"张三","avatar":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg","inviteCode":"123456789","phone":"18783014636","createTime":"2020-05-19 17:09:42","role":0,"hasAgent":true},"isRegister":false}
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
         * token :  69TWUq3enYpuorqeJKhYIb3 LgBuUxbADWh3X4Go7t7sBFSgG6a9gkC4fycISQ06JSiLwxD7cI2Ef3E8SZh5r io2E69ijGc7ak15Unf906X/9KBrwDgKrpLUIbhi8afoh 0eBkiaOogJ8yWLzLTw==
         * loginExTimeStamp : 1601277388499
         * info : {"id":2,"nickname":"张三","avatar":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg","inviteCode":"123456789","phone":"18783014636","createTime":"2020-05-19 17:09:42","role":0,"hasAgent":true}
         * isRegister : false
         */

        private String token;
        private long loginExTimeStamp;
        private InfoBean info;
        private boolean isRegister;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getLoginExTimeStamp() {
            return loginExTimeStamp;
        }

        public void setLoginExTimeStamp(long loginExTimeStamp) {
            this.loginExTimeStamp = loginExTimeStamp;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public boolean isIsRegister() {
            return isRegister;
        }

        public void setIsRegister(boolean isRegister) {
            this.isRegister = isRegister;
        }

        public static class InfoBean {
            /**
             * id : 2
             * nickname : 张三
             * avatar : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg
             * inviteCode : 123456789
             * phone : 18783014636
             * createTime : 2020-05-19 17:09:42
             * role : 0
             * hasAgent : true
             */

            private int id;
            private String nickname;
            private String avatar;
            private String inviteCode;
            private String phone;
            private String createTime;
            private int role;
            private boolean hasAgent;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getInviteCode() {
                return inviteCode;
            }

            public void setInviteCode(String inviteCode) {
                this.inviteCode = inviteCode;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }

            public boolean isHasAgent() {
                return hasAgent;
            }

            public void setHasAgent(boolean hasAgent) {
                this.hasAgent = hasAgent;
            }
        }
    }
}
