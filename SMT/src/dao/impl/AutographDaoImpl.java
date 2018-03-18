package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Utils;
import entity.Autograph;
import entity.Images;
import entity.User;
import dao.AutographDao;
import dao.BaseDao;

public class AutographDaoImpl implements AutographDao {
	@Override
	public List<Autograph> queryByKind(int kindid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Autograph> list = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from autographtb a,kindtb k,usertb u where a.kindid=k.kindid and a.account=u.account and k.`use`='签名' and a.kindid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kindid);
			rs = pstmt.executeQuery();
			list = new ArrayList<Autograph>();
			ImagesDaoImpl idi = new ImagesDaoImpl();
			while (rs.next()) {
				Autograph ag = new Autograph();
				ag.setAccount(rs.getString("account"));
				ag.setAutograph_id(rs.getInt("autographid"));
				ag.setContent(rs.getString("content"));
				ag.setContent(rs.getString("content"));
				ag.setDate(rs.getString("date"));
				ag.setKind_id(rs.getInt("kindid"));
				ag.setRose(rs.getInt("rose"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				ag.setUser(user);
				ag.setImgURL(idi.queryImages("签名", ag.getAutograph_id()));
				;
				list.add(ag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	public int insert(Autograph autograph) throws Exception {
		String sql = "insert into autographtb VALUES(DEFAULT,?,?,?,?,?)";
		Object[] arr = { autograph.getContent(), autograph.getAccount(),
				autograph.getDate(), autograph.getRose(),
				autograph.getKind_id() };
		return BaseDao.update(sql, arr);
	}

	@Override
	public Autograph queryOne(int autograpgid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Autograph ag = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from autographtb a,kindtb k,usertb u where a.kindid=k.kindid and a.account=u.account and a.autographid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, autograpgid);
			rs = pstmt.executeQuery();
			ImagesDaoImpl idi = new ImagesDaoImpl();
			while (rs.next()) {
				ag = new Autograph();
				ag.setAccount(rs.getString("account"));
				ag.setAutograph_id(rs.getInt("autographid"));
				ag.setContent(rs.getString("content"));
				ag.setContent(rs.getString("content"));
				ag.setDate(rs.getString("date"));
				ag.setKind_id(rs.getInt("kindid"));
				ag.setRose(rs.getInt("rose"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				ag.setUser(user);
				ag.setImgURL(idi.queryImages("签名", ag.getAutograph_id()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return ag;
	}
	// public static void main(String[] args) {
	// AutographDaoImpl adi = new AutographDaoImpl();
	// int a =4;
	// try {
	// for (int i = 0; i < 30; i++) {
	// if(i%7==0){
	// a++;
	// }
	// Autograph autograph = new Autograph();
	// autograph.setContent("我叫赵日天" + i + 1);
	// autograph.setAccount("123");
	// autograph.setDate(Utils.getDateNow());
	// autograph.setRose(11*a);
	// autograph.setKind_id(a);
	// System.out.println(adi.insert(autograph)+"--"+a);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
