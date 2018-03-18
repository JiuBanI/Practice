package entity;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */
//鏀惰棌琛�
public class Collect {
    private int collect_id;
    private String use;
    private int use_id;
    private String account;
    private User user;

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collect() {
    }

    public Collect(int collect_id, String use, int use_id, String account, User user) {
        this.collect_id = collect_id;
        this.use = use;
        this.use_id = use_id;
        this.account = account;
        this.user = user;
    }
}
