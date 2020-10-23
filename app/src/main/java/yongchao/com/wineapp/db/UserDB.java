package yongchao.com.wineapp.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserDB {

    @Id
    private Long id;
    private String token;
    private int userId;
    private String nickname;
    private String avatar;
    private String phone;
    private String inviteCode;
    private int role;
    @Generated(hash = 783278656)
    public UserDB(Long id, String token, int userId, String nickname, String avatar,
            String phone, String inviteCode, int role) {
        this.id = id;
        this.token = token;
        this.userId = userId;
        this.nickname = nickname;
        this.avatar = avatar;
        this.phone = phone;
        this.inviteCode = inviteCode;
        this.role = role;
    }
    @Generated(hash = 1312299826)
    public UserDB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getInviteCode() {
        return this.inviteCode;
    }
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
    public int getRole() {
        return this.role;
    }
    public void setRole(int role) {
        this.role = role;
    }



}
