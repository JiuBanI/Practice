package entity;


/**
 * Created by 涔呬即銆�on 2018/1/25.
 */

//璇勮
public class Comment {
    private int comment_id;
    private String content;
    private String use;
    private int use_id;
    private String date;
    private String account;

    private User user;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Comment() {
    }

    public Comment(int comment_id, String content, String use, int use_id, String date, String account, User user) {
        this.comment_id = comment_id;
        this.content = content;
        this.use = use;
        this.use_id = use_id;
        this.date = date;
        this.account = account;
        this.user = user;
    }
}
