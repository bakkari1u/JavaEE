package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/bag")
public class BagServlet extends HttpServlet {

	//Bag myBag = new Bag();
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

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

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		out.append("<!DOCTYPE html>\r\n")
				.append("<html>\r\n")
				.append("		<head>\r\n")
				.append("			<title>Welcome message</title>\r\n")
				.append("		</head>\r\n")
				.append("		<body>\r\n");

	  if (ref != null && !ref.trim().isEmpty() && qty != null && !qty.trim().isEmpty()) {
			out.append("	your ref is " + ref + ".\r\n");
			out.append("	your qty is " + qty + ".\r\n");
	}

	  else{
			//out.append("ERREUR" + ".\r\n");
			res.setStatus(400);
		}
		out.append("		</body>\r\n")
				.append("</html>\r\n");


}
}
