package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import javafx.stage.Window;


@WebServlet("/bag")
public class BagServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Bag myBag = new Bag();

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		  if (session.isNew())
	    	  session.setAttribute("myBag", myBag);
	       else {
	    	  myBag = (Bag)session.getAttribute("myBag");
	    	  myBag.print(out);
	      }

		res.setContentType("text/html");

		out.append("<!DOCTYPE html>")
	      .append("<html>")
	      .append("<head>")
	      .append("<title>Form input</title>")
	      .append("</head>")
	      .append("<body>")
	      .append("<form action=\"bag\" method=\"post\">")
	      .append("Enter your ref: ")
	      .append("<input type=\"text\" id=\"ref\" name=\"ref\" />")
				.append("Enter your qty: ")
	      .append("<input type=\"text\" id=\"qty\" name=\"qty\" />")
	      .append("<input type=\"submit\" value=\"Submit\" />")
	      .append("</form>")
	      .append("</body>")
	      .append("</html>");
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");
		PrintWriter out = res.getWriter();


		res.setContentType("text/html");


		if (ref != null && !ref.trim().isEmpty() && qty != null && !qty.trim().isEmpty()) {
		  	myBag.setItem(ref,Integer.parseInt(qty));
		    res.sendRedirect("/exo103/bag");
	}

	  else{
			res.setStatus(400);
		}


}
}
