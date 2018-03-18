package dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	private static String IP ;
//自动获取本机IP
	public static String getIP() {
		InetAddress ia = null;
		try {
			ia = ia.getLocalHost();
			IP = ia.getHostAddress();
//			String localname = ia.getHostName();
//			String localip = ia.getHostAddress();
//			System.out.println("本机名称是：" + localname);
//			System.out.println("本机的ip是 ：" + localip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IP;
	}


	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/smt",
				"root", "123456");
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from usertb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("account"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				BaseDao.closeAll(conn, pstmt, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs)
			throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public static int update(String sql, Object[] arr) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (arr != null) {
				for (int i = 0; i < arr.length; i++) {
					pstmt.setObject(i + 1, arr[i]);
				}
			}
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			closeAll(conn, pstmt, null);
		}
	}
}