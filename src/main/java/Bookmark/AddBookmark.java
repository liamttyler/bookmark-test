package Bookmark;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
public class AddBookmark extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String category = req.getParameter("category");
		
		DAL dal = new DAL();
		Key key = dal.add(name, url, category);
		
		try {
			
			if(key != null)
				req.setAttribute("Message","Success");
			else
				req.setAttribute("Message", "Failed");
			
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
		catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
 