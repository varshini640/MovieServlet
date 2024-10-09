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
@WebServlet("/addmovie")
public class AddMovies extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("desc");
		Part image = req.getPart("poster");
		String language=req.getParameter("lang");
		int rateing =(Integer.parseInt(req.getParameter("rateing")));
//		the getParameterValues will take String[] as checkbox can be taken more than 1 value
		String[] gere=req.getParameterValues("genre");
		
//		adding the values to the variables
		Movies movie=new Movies();
		movie.setMname(name);
		movie.setDescription(description);
		movie.setGenre(gere);
		movie.setLanguage(language);
		movie.setRateing(rateing);
		
		byte[] poster=new byte[image.getInputStream().available()];
		image.getInputStream().read(poster);
		movie.setPoster(poster);
		
//		adding to the database
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("m5");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
		
		
		resp.getWriter().print("<h1>movie added  successfully</h1>");
		req.getRequestDispatcher("home.html").include(req,resp);
		
	}
	
	

}
