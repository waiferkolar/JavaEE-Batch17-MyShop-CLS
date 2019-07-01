package coder.controllers;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	public PageController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		InitialContext cont;
		try {
			cont = new InitialContext();
			Context context = (Context) cont.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPage = "/home.jsp";
		if (request.getParameter("page") != null) {
			switch (request.getParameter("page")) {
			case "single":
				int id = Integer.parseInt(request.getParameter("id"));
				request.getSession().setAttribute("id", id);
				forwardPage = "/category.jsp";
				break;
			case "cart_detail":
				forwardPage = "/cart_detail.jsp";
				break;
			}
		}
		request.getRequestDispatcher(forwardPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
