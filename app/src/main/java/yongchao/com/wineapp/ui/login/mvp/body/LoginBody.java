package yongchao.com.wineapp.ui.login.mvp.body;

public class LoginBody {

    private String phone;
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LoginBody(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }
}
