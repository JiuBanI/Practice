package entity;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */

// 缃戝悕璇磋
public class NickName {
	private int nickName_id;
	private String content1;
	private String content2;
	private String account;
	private String date;
	private int rose;
	private int kind_id;
	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	private User user;

	public int getNickName_id() {
		return nickName_id;
	}

	public void setNickName_id(int nickName_id) {
		this.nickName_id = nickName_id;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRose() {
		return rose;
	}

	public void setRose(int rose) {
		this.rose = rose;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NickName() {
	}

	public NickName(int nickName_id, String content1, String content2,
			String account, String date, int rose, User user) {
		this.nickName_id = nickName_id;
		this.content1 = content1;
		this.content2 = content2;
		this.account = account;
		this.date = date;
		this.rose = rose;
		this.user = user;
	}
}
