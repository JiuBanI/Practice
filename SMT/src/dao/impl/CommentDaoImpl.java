package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Utils;
import dao.BaseDao;
import dao.CollectDao;
import dao.CommentDao;
import entity.Autograph;
import entity.Comment;
import entity.User;

public class CommentDaoImpl implements CommentDao {
	@Override
	public List<Comment> query(String use, int useid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> list = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from commenttb c,usertb u where c.account = u.account and `use`=? and useid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, use);
			pstmt.setInt(2, useid);
			rs = pstmt.executeQuery();
			list = new ArrayList<Comment>();
			while (rs.next()) {
				Comment c = new Comment();
				c.setAccount(rs.getString("account"));
				c.setContent(rs.getString("content"));
				c.setDate(rs.getString("date"));
				c.setUse(rs.getString("use"));
				c.setUse_id(rs.getInt("useid"));
				User user = new User();
				user.setAccount(rs.getString("account"));
				user.setImg("http://" + BaseDao.getIP() + ":8080/SMT/images/"
						+ rs.getString("img"));
				user.setNickName(rs.getString("nickName"));
				c.setUser(user);
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int insert(Comment comment) throws Exception {
		String sql = "insert into commenttb values(DEFAULT,?,?,?,?,?)";
		Object[] arr = { comment.getContent(), comment.getUse(),
				comment.getUse_id(), comment.getDate(), comment.getAccount() };
		return BaseDao.update(sql, arr);
	}

	public static void main(String[] args) {
		// for (int j = 21; j <= 42; j++) {
		// for (int i = 1; i <= 10; i++) {
		// Comment comment = new Comment();
		// comment.setAccount("123");
		// comment.setContent("我是" + i + "楼,我觉得这是,神句/神图,我喜欢！");
		// comment.setDate(Utils.getDateNow());
		// comment.setUse("网名");
		// comment.setUse_id(1);
		// try {
		// CommentDaoImpl cdi = new CommentDaoImpl();
		// System.out.println(cdi.insert(comment) + "----" + i
		// + "++++" + comment.getContent() + "--"
		// + comment.getUse() + "--" + comment.getUse_id());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// }
	}
}
