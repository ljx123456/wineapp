package yongchao.com.wineapp.ui.set.mvp.body;

public class EditAddressBody {

    /**
     * addressId : 1
     * districtId : 5
     * userName : 张三
     * phone : 13612345679
     * address : 朝阳街道86号附2号
     * isDefault : false
     */

    private int addressId;
    private int districtId;
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

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
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

    public EditAddressBody(int addressId, int districtId, String userName, String phone, String address, boolean isDefault) {
        this.addressId = addressId;
        this.districtId = districtId;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.isDefault = isDefault;
    }
}
