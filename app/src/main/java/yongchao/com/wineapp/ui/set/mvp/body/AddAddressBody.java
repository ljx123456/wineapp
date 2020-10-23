package yongchao.com.wineapp.ui.set.mvp.body;

public class AddAddressBody {

    /**
     * districtId : 3
     * userName : 李四
     * phone : 13612345666
     * address : 朝阳街道86号附100号
     * isDefault : true
     */

    private int districtId;
    private String userName;
    private String phone;
    private String address;
    private boolean isDefault;

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

    public AddAddressBody(int districtId, String userName, String phone, String address, boolean isDefault) {
        this.districtId = districtId;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.isDefault = isDefault;
    }
}

