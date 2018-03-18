package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ImgHeadDao;
import entity.Autograph;
import entity.Images;
import entity.ImgHead;
import entity.User;

public class ImgHeadDaoImpl implements ImgHeadDao {

	public List<ImgHead> queryByKind(int kindid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ImgHead> list = null;
		String use = "头像";
		if (kindid > 16) {
			use = "表情包";
		}
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from imgheadtb i,kindtb k,usertb u where i.kindid=k.kindid and i.account=u.account and k.use='"
					+ use + "' and i.kindid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kindid);
			rs = pstmt.executeQuery();
			list = new ArrayList<ImgHead>();
			ImagesDaoImpl idi = new ImagesDaoImpl();
			while (rs.next()) {
				ImgHead ih = new ImgHead();
				ih.setAccount(rs.getString("account"));
				ih.setRose(rs.getInt("rose"));
				ih.setDate(rs.getString("date"));
				ih.setImgHead_id(rs.getInt("imgHeadid"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				ih.setUser(user);
				ih.setImgURL(idi.queryImages(use, ih.getImgHead_id()));
				list.add(ih);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public ImgHead queryOne(int imgHeadid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ImgHead ih = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from imgheadtb i,kindtb k,usertb u where i.kindid=k.kindid and i.account=u.account and k.use='头像' and i.imgheadid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, imgHeadid);
			rs = pstmt.executeQuery();
			ImagesDaoImpl idi = new ImagesDaoImpl();
			while (rs.next()) {
				ih = new ImgHead();
				ih.setAccount(rs.getString("account"));
				ih.setRose(rs.getInt("rose"));
				ih.setDate(rs.getString("date"));
				ih.setImgHead_id(rs.getInt("imgHeadid"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				ih.setUser(user);
				ih.setImgURL(idi.queryImages("头像", ih.getImgHead_id()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return ih;
	}

	@Override
	public int insert(ImgHead imgHead) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
