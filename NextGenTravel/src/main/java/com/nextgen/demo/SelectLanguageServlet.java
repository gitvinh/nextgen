package com.nextgen.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "selectlanguageservlet",
		urlPatterns = "/SelectLanguage"
		)
public class SelectLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cheeseType = req.getParameter("Lang");

		CheeseService cheeseService = new CheeseService();
		LanguageType lang = LanguageType.valueOf(cheeseType);

		List cheeseBrands = cheeseService.getCheeseBasedOnLanguage(lang);

		req.setAttribute("types", cheeseBrands);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);

	}
}
