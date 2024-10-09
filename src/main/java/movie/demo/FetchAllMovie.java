package movie.demo;

import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/fetchall")
public class FetchAllMovie extends HttpServlet {
	@Override

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("m5");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Query q = manager.createNativeQuery("select * from Movies", Movies.class);
		@SuppressWarnings("unchecked")
		List<Movies> l = q.getResultList();
         
		if(l.isEmpty())
		{
			resp.getWriter().print("<h1>No movies found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}
		
		else {
			req.setAttribute("Movies",l);
			req.getRequestDispatcher("fetch.jsp").include(req, resp);
		}
	}
}
