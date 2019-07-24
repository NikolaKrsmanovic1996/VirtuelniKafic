package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.UserDao;
import model.Artikal;
import model.Racun;
import model.User;
import validacija.UserValidacija;


/**
 * Servlet implementation class PlatiRacunServlet
 */
@WebServlet("/PlatiRacunServlet")
public class PlatiRacunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserValidacija uv = new UserValidacija();
		UserDao ud = new UserDao();
		
		String [] check = request.getParameterValues("check");
		String [] kolicina = request.getParameterValues("kolicina");
		
		
		List<Artikal> listaArtikala = ud.artikliSaRacuna(check);
		List<String> listaKolicina = uv.urediKolicinu(kolicina);
		
		
		double totalPrice = ud.IznosRacuna(listaArtikala, listaKolicina);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("ovdeJeUserObjekat");
		Date date = new Date();
		Racun racun = ud.sacuvajRacun(user, date, listaArtikala);
		
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("listaArtikala", listaArtikala);
		request.setAttribute("listaKolicina", listaKolicina);
		
		
		if(user.getNovcanik()>=totalPrice) {
			ud.updateNovcanik(user, totalPrice);
			ud.updateStanje(listaArtikala, listaKolicina);
			RequestDispatcher rd = request.getRequestDispatcher("view/racun.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("view/user.jsp");
		}
		
		
		
		
		
		
	}

}
