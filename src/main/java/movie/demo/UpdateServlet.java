package movie.demo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/updateMovie")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("m5");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		String name = req.getParameter("name");
		String description = req.getParameter("desc");
		Part image = req.getPart("poster");
		String language=req.getParameter("lang");
		int rateing =Integer.parseInt(req.getParameter("rateing"));
//		the getParameterValues will take String[] as checkbox can be taken more than 1 value
		String[] genre=req.getParameterValues("genre");
		
	     int id =Integer.parseInt(req.getParameter("id"));
	     
	     //find the object with this id
	     
	    Movies movie = manager.find(Movies.class,id);
	    movie.setMname(name);
	    movie.setDescription(description);
	    movie.setLanguage(language);
	    movie.setRateing(rateing);
	    movie.setGenre(genre);
	    
	    byte[] arr=new byte[image.getInputStream().available()];
	    image.getInputStream().read(arr);
	    movie.setPoster(arr);
	    
	    transaction.begin();
	    manager.merge(movie);
	    transaction.commit();
	    
	    resp.getWriter().print("<h1> UPDATED SUCCESSFULLY!!!!!</h1>");
	    req.getRequestDispatcher("fetchall").include(req, resp);
		
		
		
	}

}
