package yongchao.com.wineapp.ui.login.mvp.body;

public class LoginBindBody {
    private String inviteCode;

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public LoginBindBody(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
