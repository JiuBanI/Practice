package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Utils;
import dao.BaseDao;
import dao.UserDao;
import entity.ImgHead;
import entity.User;

public class UserDaoImpl implements UserDao {
	@Override
	public User login(String account, String pwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from usertb where account=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				user.setAutograph(rs.getString("autograph"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setPwd(pwd);
				user.setSex(rs.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public User queryOneByAccount(String account) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from usertb where account=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				user.setAutograph(rs.getString("autograph"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setSex(rs.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public User queryOneByPhone(String phone) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from usertb where phone=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				user.setAutograph(rs.getString("autograph"));
				user.setBirthday(rs.getString("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setSex(rs.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public User register(User user) throws Exception {
		String account = null;
		do {
			account = Utils.randomAccount();
		} while ((queryOneByAccount(account) != null));
		if (queryOneByPhone(user.getPhone()) != null) {
			return null;
		}
		String sql = "insert into usertb values(?,?,?,?,?,?,?,?)";
		Object[] arr = { account, user.getPhone(), user.getPwd(), "ABC0.jpg",
				account, "ÄÐ", Utils.getDateNow(), "" };
		if(BaseDao.update(sql, arr)>0){
			return queryOneByPhone(user.getPhone());
		}else{
			return null;
		}
	}
}
