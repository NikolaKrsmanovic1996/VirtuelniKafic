package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.RegistracijaDao;
import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "ovo je servlet koji regulise registraciju usera", urlPatterns = { "/PutanjaServletaZaRegistraciju" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RegistracijaDao registracijaDAO = new RegistracijaDao();
		
		System.out.println("Pozdrav iz servleta!");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		
		
		
		LoginDao loginDao = new LoginDao();
		User user = new User();
		

       boolean provera = ValidacijaZaRegistraciju.proveraPassword(password, repeatedPassword);
		
		if(provera) {
			boolean upisanUbazu = registracijaDAO.upisiUseraUbazu(userName, password);
				if(upisanUbazu) {
					response.sendRedirect("index.html");
				}else {
					response.sendRedirect("registracija.html");
				}
		}else {
			response.sendRedirect("registracija.html");
		}
		
		
		
	}
			
			


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pozdrav iz servleta, do post metode!");
	}

}
