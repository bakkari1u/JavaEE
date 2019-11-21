package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;



import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/bag")
public class BagServlet extends HttpServlet {



	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {


				res.setContentType("text/html");

				PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true);
		Bag myBag = new Bag();
		if (session.isNew())
				session.setAttribute("myBag", myBag);
			 else {
				myBag = (Bag)session.getAttribute("myBag");
				myBag.print(out);
			}

		//session.setAttribute("bag",myBag);
		//session.setAttribute("bag",myBag);
	  //myBag =(session.getAttribute("bag")!=null) ? (Bag)session.getAttribute("bag") : myBag;
	//	myBag.print(out);
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
Bag myBag = new Bag();
		res.setContentType("text/html");
   //Bag myBag = new Bag();
   HttpSession session = req.getSession();

		PrintWriter out = res.getWriter();

		/*out.append("<!DOCTYPE html>\r\n")
				.append("<html>\r\n")
				.append("		<head>\r\n")
				.append("			<title>Welcome message</title>\r\n")
				.append("		</head>\r\n")
				.append("		<body>\r\n");*/

	  if (ref != null && !ref.trim().isEmpty() && qty != null && !qty.trim().isEmpty()) {
			//out.append("	your ref is " + ref + ".\r\n");
			//out.append("	your qty is " + qty + ".\r\n");
			Integer qt=Integer.parseInt(qty);
			//Bag bag = (Bag) session.getAttribute("bag");
      myBag.setItem(ref,qt);
			session.setAttribute("myBag", myBag);
      res.sendRedirect("bag.jsp");
	}

	  else{
			res.setStatus(400);
		}
		/*out.append("		</body>\r\n")
				.append("</html>\r\n");*/


}
}
