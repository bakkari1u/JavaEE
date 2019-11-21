package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/bag")
public class BagServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		PrintWriter out = res.getWriter();
		Bag myBag = (Bag) session.getAttribute("bag");
		if(myBag != null)
			myBag.print(out);

		res.setContentType("text/html");

		out.append("<!DOCTYPE html>").append("<html>").append("<head>").append("<title>Form input</title>")
				.append("</head>").append("<body>").append("<form action=\"bag\" method=\"post\">")
				.append("Enter your ref: ").append("<input type=\"text\" id=\"ref\" name=\"ref\" />")
				.append("Enter your qty: ").append("<input type=\"text\" id=\"qty\" name=\"qty\" />")
				.append("<input type=\"submit\" value=\"Submit\" />").append("</form>").append("</body>")
				.append("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		res.setContentType("text/html");
		HttpSession session = req.getSession(true);

		PrintWriter out = res.getWriter();

		if (ref != null && !ref.trim().isEmpty() && qty != null && !qty.trim().isEmpty()) {
			Integer qt = Integer.parseInt(qty);
			Bag myBag = (Bag) session.getAttribute("bag");
			if(myBag == null)
				myBag = new Bag();

			myBag.setItem(ref, qt);
			session.setAttribute("bag", myBag);
			res.sendRedirect("bag.jsp");
		}

		else {
			res.setStatus(400);
		}

	}
}
