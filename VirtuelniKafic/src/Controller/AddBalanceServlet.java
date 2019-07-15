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
 * Servlet implementation class AddBalanceServlet
 */
@WebServlet("/AddBalanceServlet")
public class AddBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String balance = request.getParameter("balance");
		
		LoginDao ld = new LoginDao();
		
		boolean proveriUsername = ld.DaLiPostojiUserUbazi(userName);
		
		if(proveriUsername) {
			//idemo dalje
			User user = ld.vratiUsera(userName);
			boolean dodajNovac = AdminDao.dodajUnovcanik(user, balance);
				if(dodajNovac) {
					response.sendRedirect("view/administrator.jsp");
				}else {
					response.sendRedirect("view/addBalanceError.jsp");
				}	
		}else {
			response.sendRedirect("view/addBalanceError.jsp");
		}
	}

}
