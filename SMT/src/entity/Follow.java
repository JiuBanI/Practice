package entity;


/**
 * Created by 涔呬即銆�on 2018/1/25.
 */

//鍏虫敞琛�
public class Follow {
    private int follow_id;
    private String beaccount;
    private String account;
    private User beUser;
    private User user;

    public int getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }

    public String getBeaccount() {
        return beaccount;
    }

    public void setBeaccount(String beaccount) {
        this.beaccount = beaccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public User getBeUser() {
        return beUser;
    }

    public void setBeUser(User beUser) {
        this.beUser = beUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Follow(int follow_id, String beaccount, String account, User beUser, User user) {
        this.follow_id = follow_id;
        this.beaccount = beaccount;
        this.account = account;
        this.beUser = beUser;
        this.user = user;
    }
}
