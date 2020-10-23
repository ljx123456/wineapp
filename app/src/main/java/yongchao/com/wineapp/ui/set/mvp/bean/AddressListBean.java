package yongchao.com.wineapp.ui.set.mvp.bean;

import java.util.List;

public class AddressListBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"addressId":1,"provinceId":1,"cityId":2,"districtId":5,"provinceName":"北京","cityName":"北京市","districtName":"朝阳区","userName":"李四","phone":"13612345678","address":"朝阳街道86号附1号","isDefault":true}]
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
         * addressId : 1
         * provinceId : 1
         * cityId : 2
         * districtId : 5
         * provinceName : 北京
         * cityName : 北京市
         * districtName : 朝阳区
         * userName : 李四
         * phone : 13612345678
         * address : 朝阳街道86号附1号
         * isDefault : true
         */

        private int addressId;
        private int provinceId;
        private int cityId;
        private int districtId;
        private String provinceName;
        private String cityName;
        private String districtName;
        private String userName;
        private String phone;
        private String address;
        private boolean isDefault;

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isIsDefault() {
            return isDefault;
        }

        public void setIsDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }
    }
}
