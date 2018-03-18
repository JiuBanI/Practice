package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.impl.ImgHeadDaoImpl;

public class ImgHeadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	ImgHeadDaoImpl idi = new ImgHeadDaoImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		try {
			if (type.equals("query")) {
				query(request, response, out);
			} else if (type.equals("queryOne")) {
				queryOne(request, response, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// try {
	// ImgHeadDaoImpl idi = new ImgHeadDaoImpl();
	// Gson gson = new Gson();
	// System.out.print(gson.toJson(idi.queryByKind(10)));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	private void query(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		int kindid = Integer.parseInt(request.getParameter("kindid"));
		Gson gson = new Gson();
		out.print(gson.toJson(idi.queryByKind(kindid)));
	}

	private void queryOne(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		int imgHeadid = Integer.parseInt(request.getParameter("imgHeadid"));
		Gson gson = new Gson();
		out.print(gson.toJson(idi.queryOne(imgHeadid)));
	}

}
