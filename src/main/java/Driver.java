import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.jdbc.Expectations;
import org.hibernate.query.Query;



public class Driver {
	
public static void main(String[] args) 
{
	  // loads configuration and creates a session factory
	
    Configuration con = new Configuration();
    con.configure("hibernate.cfg.xml");
    con.configure().addAnnotatedClass(Accounts.class);
    SessionFactory sf= con.buildSessionFactory();
   // System.out.println("Please Register yourself!");
    Session session= sf.openSession();
    Transaction trans= session.beginTransaction();
    boolean flag=true;
    boolean FileFlag=true;
 //   Payment p=new Payment();
    
    
    
    /*
  
    Scanner obj= new Scanner(System.in);                   //party joining
   	System.out.println("joinig a Kameti party");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=Accounts.getAccount(session,cnic);
   	if(acc!=null)
   	{
   		KametiParty.ShowParties(session);
   		System.out.println("Enter Desire Party ID");
   	   	int pid=obj.nextInt();
   	 KametiParty party = KametiParty.getParty(session,pid);
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   	 if(party!=null)
     {
   		 KametiMember m=new KametiMember(party.getKametiName(),pid,cnic,acc);
    // mem.add(m);
   		 
     session.save(m);
     party.setMembers(m);
     session.update(party);
     }
        
       
    	 trans.commit();
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
   */
       
    
    
    
     
    
    /*
    Scanner obj= new Scanner(System.in);                   //Deposite
   	System.out.println("Deposite");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=Accounts.getAccount(session,cnic);
   	if(acc!=null)
   	{
   		KametiParty.ShowPartiesofMember(session,cnic);
   		System.out.println("Enter  Party ID");
   	   	int pid=obj.nextInt();
   	   	
   	 System.out.println("Enter  amount");
	   	double am=obj.nextDouble();
   	
   	 KametiParty party = KametiParty.getParty(session,pid);
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   	 if(party!=null)
     {
   		KametiMember.Deposite( session, am, cnic,trans);
     }
        
       
    	 
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
    
    */
    /*
    Scanner obj= new Scanner(System.in);                   //withdraw
   	System.out.println("withdarw");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=Accounts.getAccount(session,cnic);
   	if(acc!=null)
   	{
   		KametiParty.ShowPartiesofMember(session,cnic);
   		System.out.println("Enter  Party ID");
   	   	int pid=obj.nextInt();
   	   	
   	 KametiParty party = KametiParty.getParty(session,pid);
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   	 if(party!=null)
     {
   		KametiMember.Withdraw( session,cnic,trans);
     }
        
       
    	 
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
    
    
    */
    
  
    
	Scanner obj= new Scanner(System.in);
	System.out.println("Party creating");
	System.out.println("Enter your CNIC");
	int cnic=obj.nextInt();
	System.out.println("Enter Kameti Name");
	String kname=obj.next();
	System.out.println("Enter Kameti Capecity");
	int capecity=obj.nextInt();
	System.out.println("Enter Installent per month");
	double ins=obj.nextDouble();
	 obj.close();
	
	if(!FileFlag)
	{Accounts acc=Accounts.getAccount(session,cnic);
	if(acc!=null)
	{
		 KametiParty kp=new KametiParty(kname);
		 kp.setCapecity(capecity);
		 kp.setInstallment_per_month(ins);
		 kp.setVacant_Position(capecity);
		 ArrayList<KametiParty> pr = new ArrayList<KametiParty>();
		    pr.add(kp);
		 Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
		    kp.setDates(d);
		    session.save(kp);
		KametiOwner owner =KametiOwner.getAccount(session,cnic);
		if(owner==null)
		{  owner=new KametiOwner(acc,pr,cnic);
	    session.save(owner);
		}
		else
		{
			owner.setParties(kp);
			 session.update(owner);
		}
	    
	}
	 trans.commit();
	}
	else
	{
		
		 Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
		    KametiOwner owner=new KametiOwner(cnic);
		    KametiParty kp=new KametiParty(kname,capecity,ins,0,capecity,d,cnic);
	}
    /*
    Scanner obj= new Scanner(System.in);
	System.out.println("Party ");
	System.out.println("Enter your ID");
	String pname=obj.nextLine();
    KametiParty p=new KametiParty(pname);
    p.setKametiName(pname);
    p.setCapecity(15);
    Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
    p.setDates(d);
    session.save(p);
    
    ArrayList<KametiParty> pr = new ArrayList<KametiParty>();
    KametiOwner acc=session.get(KametiOwner.class, 3);
    pr.add(p);
    acc.setParties(pr);
    session.update(acc);
    */
       
      /* 
   
    Scanner obj= new Scanner(System.in);
	System.out.println("Please Register yourself!");   //registration
	
	System.out.println("Enter First Name");
	String fname=obj.nextLine();
	System.out.println("Enter Last Name");
	String lname=obj.nextLine();
	System.out.println("Enter CNIC");
	int cnic=obj.nextInt();
	System.out.println("Enter Address");
	String addr=obj.next();
	System.out.println("Enter Contact");
	String cont=obj.next();
	System.out.println("Enter Gender");
	String gen=obj.next();
	 obj.close();
	//KametiParty parties=new KametiParty();
	    
	
         // Create CriteriaBuilder
	 if(!FileFlag)
	 {   CriteriaBuilder builder = session.getCriteriaBuilder();

         // Create CriteriaQuery
         CriteriaQuery<Accounts> criteria = builder.createQuery(Accounts.class);

         // Specify criteria root
         criteria.from(Accounts.class);

         // Execute query
         List<Accounts> entityList = session.createQuery(criteria).getResultList();

         for (Accounts e : entityList) {
         if(e.getCNIC()==cnic)
         {
        	 System.out.println("Duplicate found");
        	 flag=false;
        	 break;
         }
         }
     
	 if(flag)
	{session.save(KametiParty.register_member(cnic, fname, lname, addr, cont, gen,FileFlag));
	
	
     trans.commit();
	}
	 }
	 else
	 {
		 KametiParty.register_member(cnic, fname, lname, addr, cont, gen,FileFlag);
	 }
     */
 
}
}
