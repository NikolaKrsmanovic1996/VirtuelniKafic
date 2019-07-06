package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

import dao.LoginDao;
import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "servlet za logovanje", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		LoginDao loginDAO = new LoginDao();
		User user = new User();
		
		boolean proveriUsera = loginDAO.DaLiPostojiUserUbazi(userName);
		
			if(proveriUsera) {
				
				boolean proveriPassword = loginDAO.DaLiPasswordOdgovaraUseru(userName, password);
				
					if(proveriPassword) {
						user = loginDAO.vratiUsera(userName);
						HttpSession session = request.getSession();
						session.setAttribute("ovdeJeUserObjekat", user);
							if(user.getRola().equals(Rola.ADMINISTRATOR)) {
								response.sendRedirect("view/administrator.jsp");
							}else {
								response.sendRedirect("view/user.jsp");
							}
					}else {
						response.sendRedirect("login.html");
					}
					
			}else {
				response.sendRedirect("login.html");
			}
		
		
	}

}
			      