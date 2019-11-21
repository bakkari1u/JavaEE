import java.io.IOException;
  import java.io.Writer;

  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;


  @WebServlet("/bonjour")
  public class MyServlet extends HttpServlet {

  	@Override
  	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  		String name = req.getParameter("nom");
  		if ( name == null || name.isEmpty() ) name = "jooj tout le monde";

  		Writer out = resp.getWriter();
  		out.write("<p>Bonjour <b>" + name + "</b> !</p>");
  	}

  }
