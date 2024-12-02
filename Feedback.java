package com.google.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.goole.bean.FeedbackBean;
import com.goole.bean.feedback;


@WebServlet("/")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path= req.getServletPath();
		
		System.out.println("Servlet path: " + path);

		switch(path){
			
		
		case "/login": login(req,res);
		break;
		
		case"/reg": register(req,res);
		break;
		
		
		
		case "/add": addfeedbak(req,res);
			break;
			
			
		case"/edit": edit(req,res);	
		break;
		
		
		case "/update": update(req,res);
			break;
			
		case "/delete": delete(req,res);	
		break;
		
		}
		
		
		
		
	}


	private void delete(HttpServletRequest req, HttpServletResponse res) {

		int id= Integer.parseInt(req.getParameter("id"));


		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction t=s.beginTransaction();
		
		feedback f= s.get(feedback.class, id) ;
		
		s.delete(f);
		t.commit();
		
		  
	  	  Criteria c1= s.createCriteria(feedback.class);
	  	  
	  	  c1.add(Restrictions.eq("id", id));
	  	  
	  	 List<feedback> li= c1.list();    	  
	  	  
	  	  
	  	 sf.close();
	 	  s.close();
	  	  
	  	req.setAttribute("mydata", li);
	  	
	  	RequestDispatcher rd= req.getRequestDispatcher("thankyou.jsp");
	  	
	  	try {
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	  
		
	}


	private void update(HttpServletRequest req, HttpServletResponse res) {

		String newname=req.getParameter("txtname");
		
		String newemail=req.getParameter("txtemail");
		
		String newmessage=req.getParameter("txtmessage");
		
		int id= Integer.parseInt(req.getParameter("id"));

		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction t=s.beginTransaction();
		
		feedback f= s.get(feedback.class, id) ;
		
		f.setEmail(newemail);
		f.setName(newname);
		f.setMessage(newmessage);
		
		s.update(f);
		
		t.commit();
		  
  	  Criteria c1= s.createCriteria(feedback.class);
  	  
  	  c1.add(Restrictions.eq("email", newemail));
  	  
  	 List<feedback> li= c1.list();    	  
  	  
  	  
  	 sf.close();
 	  s.close();
  	  
  	req.setAttribute("mydata", li);
  	
  	RequestDispatcher rd= req.getRequestDispatcher("thankyou.jsp");
  	
  	try {
		rd.forward(req, res);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	  
		
	}


	private void edit(HttpServletRequest req, HttpServletResponse res) {
		
		
			
		int id= Integer.parseInt(req.getParameter("id"));
		
      SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction t=s.beginTransaction();
		
         feedback f=s.get(feedback.class, id);
         
        t.commit();
        
        sf.close();
        
        s.close();
        
        req.setAttribute("data", f);
        
        RequestDispatcher rd= req.getRequestDispatcher("home.jsp");
        
        try {
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	private void addfeedbak(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= req.getParameter("txtname");
		String email= req.getParameter("txtemail");
		String message= req.getParameter("txtmessage");
		
	
      SessionFactory sf= new Configuration().configure().buildSessionFactory();
      
      Session s=sf.openSession();
      
      Transaction t=s.beginTransaction();
      
    Criteria c= s.createCriteria(feedback.class);
    
   
      List<feedback> l = c.list();
      
      
      boolean ispresent= true;
      for( feedback f : l) {
    	  
    	  if(f.getEmail().equals(email)) {
    		  
    		
    		  req.setAttribute("message", "You have already given the feedback!");
    		  
    		  RequestDispatcher rd= req.getRequestDispatcher("home.jsp");
    		  
    		  rd.forward(req, res);
    		  ispresent=false;
    		  break;
    	  }
    	  
      
      }  
      
      if(ispresent) {
    	  
    	  feedback f = new feedback(name, message, email);
    	  
    	  s.save(f);
    	  t.commit();
    	  
    	  
    	  Criteria c1= s.createCriteria(feedback.class);
    	  
    	  c1.add(Restrictions.eq("email", email));
    	  
    	 List<feedback> li= c1.list();    	  
    	  
    	  
    	  sf.close();
    	  s.close();
    	  
    	req.setAttribute("mydata", li);
    	
    	RequestDispatcher rd= req.getRequestDispatcher("thankyou.jsp");
    	
    	rd.forward(req, res);
    	  
      }
      
		
		
		
		
	}


	private void register(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		
		String name=req.getParameter("txtname");
		String username= req.getParameter("txtemail");
		String password= req.getParameter("txtpassword"); 
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction t=s.beginTransaction();
		
		
		
		FeedbackBean b = null;
		
		if(!username.equals(b.getUsername())) {
		 b =new FeedbackBean(name,password,username);
		
		s.save(b);
		t.commit();
		
		}
		else {
			req.setAttribute("message", "user already exists");
			
			RequestDispatcher rd=  req.getRequestDispatcher("register.jsp");
			
			try {
				rd.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		sf.close();
		
		s.close();
		
		try {
			res.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}


	private void login(HttpServletRequest req, HttpServletResponse res) {

		
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction t =s.beginTransaction();
		
		
		Criteria c = s.createCriteria(FeedbackBean.class);
		
		List<FeedbackBean> l= c.list();
		
		String username= req.getParameter("txtname");
		
		String password= req.getParameter("txtpassword");
		
		boolean ispresent=false;
		for(FeedbackBean x : l) {
			
			if(x.getUsername().equals(username)&& x.getPassword().equals(password)) {
				
				ispresent=true;
				break;
				
			}
		}
		
		if(ispresent) {
			try {
				res.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			
			req.setAttribute("message", "invalid credential");
			
			RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
			try {
				rd.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		sf.close(); s.close();
	}

}
