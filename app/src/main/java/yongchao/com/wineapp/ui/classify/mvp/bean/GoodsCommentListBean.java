package yongchao.com.wineapp.ui.classify.mvp.bean;

import java.util.List;

public class GoodsCommentListBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : {"list":[{"commentId":1,"content":"好酒好酒！！","images":["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"],"createTime":"2020-09-21 19:21:40","userInfo":{"nickname":"张三","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132"}}],"pageIndex":1,"pageSize":10,"totalPage":1,"totalRecord":2}
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
         * list : [{"commentId":1,"content":"好酒好酒！！","images":["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"],"createTime":"2020-09-21 19:21:40","userInfo":{"nickname":"张三","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132"}}]
         * pageIndex : 1
         * pageSize : 10
         * totalPage : 1
         * totalRecord : 2
         */

        private int pageIndex;
        private int pageSize;
        private int totalPage;
        private int totalRecord;
        private List<ListBean> list;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * commentId : 1
             * content : 好酒好酒！！
             * images : ["https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2384653776,3124788629&fm=26&gp=0.jpg"]
             * createTime : 2020-09-21 19:21:40
             * userInfo : {"nickname":"张三","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132"}
             */

            private int commentId;
            private String content;
            private String createTime;
            private UserInfoBean userInfo;
            private List<String> images;

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public UserInfoBean getUserInfo() {
                return userInfo;
            }

            public void setUserInfo(UserInfoBean userInfo) {
                this.userInfo = userInfo;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public static class UserInfoBean {
                /**
                 * nickname : 张三
                 * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/PygibYE4mXhibYIzbHHW5NTYpicBmkibW6Q0LhH9ajicu69kmDalBgLHZ1gHLgCSWsTSZbptDdL6wvSjK68lR5lX0yg/132
                 */

                private String nickname;
                private String avatar;

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
            }
        }
    }
}
