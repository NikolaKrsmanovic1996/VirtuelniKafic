package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.LoginDao;
import model.User;

/**
 * Servlet implementation class UpdateBalanceServlet
 */
@WebServlet("/UpdateBalanceServlet")
public class UpdateBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String balance = request.getParameter("balance");
		
		LoginDao login = new LoginDao();
		
		boolean proveriUsera = login.DaLiPostojiUserUbazi(userName);
		
		
		if(proveriUsera) {
			User user = login.vratiUsera(userName);			
			boolean updateNovac = AdminDao.UpdateNovcanik(user, balance);
			if(updateNovac) {
				   response.sendRedirect("view/administrator.jsp");
			}else {
				   response.sendRedirect("view/addBalanceError.jsp");
			}
		}else {
			  response.sendRedirect("view/addBalanceError.jsp");
		}
			
	}

}
