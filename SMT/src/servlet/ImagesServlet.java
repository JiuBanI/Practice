package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.impl.ImagesDaoImpl;

public class ImagesServlet extends HttpServlet {
	ImagesDaoImpl idi = new ImagesDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 传值编码
		response.setContentType("text/html;charset=UTF-8");// 设置传输编码
		PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 传值编码
		response.setContentType("text/html;charset=UTF-8");// 设置传输编码
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		try {
			if (type.equals("queryAuto")) {
				queryAuto(request, response, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void queryAuto(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) throws Exception {
		String use = request.getParameter("use");
		use=new String(use.getBytes("ISO-8859-1"),"utf-8");
		String use_id = request.getParameter("useid");
		System.out.println(use + "---" + use_id);
		out.print(new Gson().toJson(idi.queryImages(use,
				Integer.parseInt(use_id))));
	}
}
