package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.impl.UserDaoImpl;
import entity.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	UserDaoImpl udi = new UserDaoImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		try {
			if (type.equals("login")) {
				login(request, response, out);
			} else if (type.equals("register")) {
				register(request, response, out);
			}else if(type.equals("queryOne")){
				queryOne(request, response, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		Gson gson = new Gson();
		out.print(gson.toJson(udi.login(account, pwd)));
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setPhone(phone);
		user.setPwd(pwd);
		Gson gson = new Gson();
		out.print(gson.toJson(udi.register(user)));
	}
	
	private void queryOne(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String account = request.getParameter("account");
		Gson gson = new Gson();
		out.print(gson.toJson(udi.queryOneByAccount(account)));
	}
}
