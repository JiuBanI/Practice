package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.impl.AutographDaoImpl;
import dao.impl.NickNameDaoImpl;

public class NickNameServlet extends HttpServlet {


	NickNameDaoImpl ndi = new NickNameDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void query(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		int kindid = Integer.parseInt(request.getParameter("kindid"));
		Gson gson = new Gson();
		out.print(gson.toJson(ndi.queryByKind(kindid)));
	}

	private void queryOne(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		int autograpgid = Integer.parseInt(request.getParameter("autograpgid"));
		Gson gson = new Gson();
		out.print(gson.toJson(ndi.queryOne(autograpgid)));
	}
}

