package coder.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;

import coder.models.Product;

@WebServlet("/ApiController")
public class ApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	public ApiController() {
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

		String route = request.getParameter("route");
		if (route.contentEquals("cart_detail")) {
			String param = request.getParameter("ids");
			String[] ary = param.split(",");
			List<Product> products = getCartProduct(ary);
			Gson gson = new Gson();
			String json = gson.toJson(products);
			response.getWriter().write(json);
		}

	}

	public List<Product> getCartProduct(String[] ary) {
		List<Product> products = new ArrayList<Product>();
		for (String id : ary) {
			try {
				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?");
				ps.setInt(1, Integer.parseInt(id));

				ResultSet set = ps.executeQuery();

				while (set.next()) {
					products.add(new Product(set.getInt("id"), set.getInt("cat_id"), set.getInt("price"),
							set.getString("name"), set.getString("image"), set.getString("description"),
							set.getString("deleted_at"), set.getString("created_at"), set.getString("updated_at")));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return products;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
