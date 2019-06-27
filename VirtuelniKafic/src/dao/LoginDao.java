package dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;


public class LoginDao {
	
  
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public boolean DaLiPostojiUserUbazi (String userName) {
			
		 Session session = sf.openSession();
		 session.beginTransaction();
		
		
		 try {
			 String upit = "FROM User where userName = :korisnickoIme";
			 Query query = session.createQuery(upit);
			 query.setParameter("korisnickoIme", userName);
			 
			 
			  List<User> listaUsera = query.getResultList();
			     if(listaUsera.isEmpty()) {
			    	 session.getTransaction().commit();
			    	 System.out.println("Ne postoji taj user");
			    	 return false;
			    	 
			     }else {
			    	 session.getTransaction().commit();
			    	 System.out.println("Dobar je user");
			    	 return true;
			    	 
			     }
				 
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije dobar username !");
			return false;
			
		}finally {
			session.close();
		}	
		
	}
	
	  
	public boolean DaLiPasswordOdgovaraUseru (String userName, String password) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		boolean vrati = false;
		
		
		try {
			
			String upit = "From User Where Username = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", userName);
			
			List<User> listaUsera = query.getResultList();
			for(User userIzBaze: listaUsera) {
				
				if(userIzBaze.getPassword().equals(password)) {
					System.out.println("Pustaj !");
					session.getTransaction().commit();
					vrati = true;
					
					
				}else {
					
					System.out.println("NEEEEEEEE!!!!!!");
					session.beginTransaction().commit();
					vrati = false;
				}
					
			}
					
			return vrati;
			
		} catch (Exception e) {
			session.beginTransaction().rollback();
			return false;
			
		}finally {
			session.close();
		}
		
	}
	
       public User vratiUsera(String userName) {
		
		User user = new User();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String upit = "FROM User WHERE userName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", userName);
			
			List<User> listaUsera = query.getResultList();
			
			user = listaUsera.get(0);
			
			return user;		
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}
	
}
