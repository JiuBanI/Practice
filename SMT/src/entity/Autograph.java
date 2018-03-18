package entity;

import java.util.List;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */

// 绛惧悕璇磋
public class Autograph {
	private int autograph_id;
	private String content;
	private String account;
	private String date;
	private int rose;
	private int kind_id;
	private User user;
	private List<Images> imgURL;

	public List<Images> getImgURL() {
		return imgURL;
	}

	public void setImgURL(List<Images> imgURL) {
		this.imgURL = imgURL;
	}

	public int getAutograph_id() {
		return autograph_id;
	}

	public void setAutograph_id(int autograph_id) {
		this.autograph_id = autograph_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Autograph() {
	}

	public Autograph(User user, int kind_id, String content, String account,
			String date, int rose, int autograph_id) {
		this.user = user;
		this.kind_id = kind_id;
		this.content = content;
		this.account = account;
		this.date = date;
		this.rose = rose;
		this.autograph_id = autograph_id;
	}
}
