package yongchao.com.wineapp.ui.set.mvp.bean;

public class UserInfoBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : {"id":1,"nickname":"张三","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132","inviteCode":"12345678","createTime":"2020-05-19 16:31:06","role":1}
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
         * id : 1
         * nickname : 张三
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132
         * inviteCode : 12345678
         * createTime : 2020-05-19 16:31:06
         * role : 1
         */

        private int id;
        private String nickname;
        private String avatar;
        private String inviteCode;
        private String createTime;
        private int role;

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
    }
}
