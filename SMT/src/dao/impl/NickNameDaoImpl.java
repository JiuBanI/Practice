package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.NickNameDao;
import entity.Autograph;
import entity.NickName;
import entity.User;

public class NickNameDaoImpl implements NickNameDao {
	@Override
	public List<NickName> queryByKind(int kindid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NickName> nn = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from nicknametb n,kindtb k,usertb u where n.kindid=k.kindid and n.account=u.account and k.`use`='ÍøÃû' and n.kindid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kindid);
			rs = pstmt.executeQuery();
			nn = new ArrayList<NickName>();
			while (rs.next()) {
				NickName n = new NickName();
				n.setAccount(rs.getString("account"));
				n.setContent1(rs.getString("content1"));
				n.setContent2(rs.getString("content2"));
				n.setDate(rs.getString("date"));
				n.setNickName_id(rs.getInt("nickNameid"));
				n.setRose(rs.getInt("rose"));
				n.setKind_id(rs.getInt("kindid"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				n.setUser(user);
				nn.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return nn;
	}

	@Override
	public NickName queryOne(int nickNameid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
