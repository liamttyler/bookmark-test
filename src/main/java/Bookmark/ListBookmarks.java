package Bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class ListBookmarks extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		DAL dal = new DAL();
		List<Entity> list = dal.getAll();
	
		try {
			
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("list.jsp").forward(req, resp);
			
		}
		catch (ServletException e){
			e.printStackTrace();
		}
	}
}
