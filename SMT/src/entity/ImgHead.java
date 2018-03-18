package entity;

import java.util.List;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */
// 澶村儚璇磋
public class ImgHead {
	private int imgHead_id;
	private String account;
	private String date;
	private int rose;
	private User user;
	private List<Images> imgURL;

	public List<Images> getImgURL() {
		return imgURL;
	}

	public void setImgURL(List<Images> imgURL) {
		this.imgURL = imgURL;
	}

	public int getImgHead_id() {
		return imgHead_id;
	}

	public void setImgHead_id(int imgHead_id) {
		this.imgHead_id = imgHead_id;
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

	public ImgHead() {
	}

	public ImgHead(int imgHead_id, String account, String date, int rose,
			User user) {
		this.imgHead_id = imgHead_id;
		this.account = account;
		this.date = date;
		this.rose = rose;
		this.user = user;
	}
}
