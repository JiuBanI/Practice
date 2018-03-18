package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dao.BaseDao;
import dao.ImagesDao;
import entity.Autograph;
import entity.Images;
import entity.User;

public class ImagesDaoImpl implements ImagesDao {
	@Override
	public int insert(Images images) throws Exception {
		String sql = "insert into imagestb values(DEFAULT,?,?,?)";
		Object[] arr = { images.getImage_name(), images.getUse(),
				images.getUse_id() };
		return BaseDao.update(sql, arr);
	}

//	public static void main(String[] args) {
//		int a = 66;
//		for (int i = 0; i < 469; i++) {
//			ImagesDaoImpl idi = new ImagesDaoImpl();
//			Images images = new Images();
//			images.setImage_name("ABC" + i + ".jpg");
//			images.setUse("签名");
//			images.setUse_id(a);
//			try {
//				idi.insert(images);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			a++;
//			if (a > 132) {
//				a = 66;
//			}
//		}

//		// int a = 0;
//		// ImagesDaoImpl idi = new ImagesDaoImpl();
//		// try {
//		// for (int i = 0; i < 149; i++) {
//		// Images images = new Images();
//		// images.setImage_name("ABC" + (i + 150) + ".jpg");
//		// if (i <= 66) {
//		// a++;
//		// if (a <= 33) {
//		// images.setUse("签名");
//		// images.setUse_id(a);
//		// System.out.println(a + "---" + images.getImage_name()
//		// + "----" + images.getUse() + "---" + i);
//		// idi.insert(images);
//		// } else {
//		// a = 0;
//		// }
//		// } else {
//		// if (i <= 108) {
//		// images.setUse("表情包");
//		// images.setUse_id(1);
//		// System.out.println(1 + "---" + images.getImage_name()
//		// + "----" + images.getUse() + "---" + i);
//		// idi.insert(images);
//		// } else {
//		// images.setUse("表情包");
//		// images.setUse_id(2);
//		// System.out.println(2 + "---" + images.getImage_name()
//		// + "----" + images.getUse() + "---" + i);
//		// idi.insert(images);
//		// }
//		// }
//		//
//		// try {
//		// } catch (Exception e) {
//		// e.printStackTrace();
//		// }
//		//
//		// }
//		// } catch (Exception e) {
//		// // TODO: handle exception
//		// }
//
//		// // try {
//		// // List<String> lis = idi.queryImages("头像", 1);
//		// // System.out.println(lis.size());
//		// // System.out.println(new Gson().toJson(lis));
//		// // } catch (Exception e) {
//		// // // TODO Auto-generated catch block
//		// // e.printStackTrace();
//		// // }
//
//	}

	@Override
	public List<Images> queryImages(String use, int use_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Images> list = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from imagestb where `use`=? and useid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, use);
			pstmt.setInt(2, use_id);
			rs = pstmt.executeQuery();
			list = new ArrayList<Images>();
			while (rs.next()) {
				Images images = new Images();
				images.setImage_id(rs.getInt("imageid"));
				images.setImage_name("http://" + BaseDao.getIP()
						+ ":8080/SMT/images/" + rs.getString("imagename"));
				images.setUse(rs.getString("use"));
				images.setUse_id(rs.getInt("useid"));
				list.add(images);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
