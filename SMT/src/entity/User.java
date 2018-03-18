package entity;


/**
 * Created by 涔呬即銆�on 2018/1/25.
 */
//鐢ㄦ埛琛�
public class User {
    private String account;
    private String phone;
    private String pwd;
    private String img;
    private String nickName;
    private String sex;
    private String birthday;
    private String autograph;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public User() {
    }

    public User(String account, String phone, String pwd, String img, String nickName, String sex, String birthday, String autograph) {
        this.account = account;
        this.phone = phone;
        this.pwd = pwd;
        this.img = img;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.autograph = autograph;
    }
}
