package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Utils;

import com.google.gson.Gson;

import dao.impl.AutographDaoImpl;
import dao.impl.CommentDaoImpl;
import entity.Comment;

public class CommentServlet extends HttpServlet {
	CommentDaoImpl cdi = new CommentDaoImpl();

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
			} else if (type.equals("insert")) {
				insert(request, response, out);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void query(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String use = request.getParameter("use");
		use = new String(use.getBytes("ISO-8859-1"), "utf-8");
		int useid = Integer.parseInt(request.getParameter("useid"));
		System.out.println(use + "---" + useid);
		Gson gson = new Gson();
		out.print(gson.toJson(cdi.query(use, useid)));
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String content = request.getParameter("content");
		content = new String(content.getBytes("ISO-8859-1"), "utf-8");
		String use = request.getParameter("use");
		use = new String(use.getBytes("ISO-8859-1"), "utf-8");
		int useid = Integer.parseInt(request.getParameter("useid"));
		String account = request.getParameter("account");
		// System.out.println(content + "--" + use + "--" + useid + "--" + account);
		Comment comment = new Comment();
		comment.setAccount(account);
		comment.setContent(content);
		comment.setDate(Utils.getDateNow());
		comment.setUse(use);
		comment.setUse_id(useid);
		out.print(cdi.insert(comment));
	}

}
