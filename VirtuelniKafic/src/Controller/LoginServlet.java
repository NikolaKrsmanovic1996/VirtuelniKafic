package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.LoginDao;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		LoginDao LoginDao = new LoginDao();
		User user = new User();
		
		
		
		boolean proveriUsera = LoginDao.DaLiPostojiUserUbazi(userName);
		
		  if(proveriUsera) {
			  
			  boolean proveriPassword = LoginDao.DaLiPasswordOdgovaraUseru(userName, password);
			  
			  
			if(proveriPassword) {
				user = LoginDao.vratiUsera(userName);
				if(user.getRola().getUloga().equals("administrator")) {
					//posalji ga na admin page
				}else {
					//posalji ga na user
				}
			}else {
				response.sendRedirect("login.html");
			}
			}else {
				response.sendRedirect("login.html");
			}
			
	}
}
			      