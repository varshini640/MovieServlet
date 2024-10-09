package movie.demo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Manager;

@WebServlet("/delete")
public class Delete extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("m5");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		int id=(Integer.parseInt(req.getParameter("id")));
		
	     Movies movie=manager.find(Movies.class, id);
	   
	     transaction.begin();
	     manager.remove(movie);
	     transaction.commit();
	     resp.getWriter().print("<h1 align='center'> Movie deleted successfully</h1>");
	     req.getRequestDispatcher("fetchall").include(req, resp);
//	     
	}
	
	
	
	
}
