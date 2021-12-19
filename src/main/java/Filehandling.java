import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filehandling {
public static void Account_Registration(Accounts acc)
{
	String temp="";
	boolean flag=true;
	
		try {
		      FileWriter myfile = new FileWriter("accounts.txt",true);
		      
		      try {
		          File myObj = new File("accounts.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals("cnic-"+acc.getCNIC()))
		                	{
		                	flag=false;
		               
		                break;}
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      {  
		    	  myfile.write("cnic-"+acc.getCNIC() +","+"FName-"+ acc.getFName() +"," +"LName-"+ acc.getLName() +"," +"Contect-"+ acc.getContact() +"," +"Address-"+ acc.getAddress() +"," +"Gender-"+ acc.getGender() +"," +"Registration_ID-"+ acc.getRegistration_ID() +"," +"Registration_Date-"+ acc.getRegistration_Date() +"\r\n");
		      myfile.close();
		      System.out.println("Registration Successfull");
		      }
		      else 
		      {
		    	  System.out.println("Account Already Exists");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		
	
	
}
public static void Parties_info(KametiParty p)
{
	String temp="";
	int id=0;
	boolean flag=true;
	
		try {
		      FileWriter myfile = new FileWriter("parties.txt",true);
		      
		      try {
		          File myObj = new File("parties.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals("Kameti_ID"+p.getKameti_ID()))
		                	{id=(int)p.getKameti_ID();
		                	flag=false;
		               
		                break;}
		                id=(int)p.getKameti_ID();
		               
		            }
		            
		          }
		          id++;
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      { 
			
		    	  myfile.write("Owner_cinc-"+p.getOwner_cinc() +","+"Kameti_ID-"+id +","+"KametiName-"+ p.getKametiName()
		    	  +"," +"Capecity-"+ p.getCapecity() +"," +"Total_Members-"+p.getTotal_Members() +","
			      +"vacant_Position-"+ p.getVacant_Position() +"," +"Total_Balance-"+ p.getTotal_Balance() +"," +"installment_per_month-"
			      + p.getInstallment_per_month() +","+"Creation_Date-"+p.getDates().getCreation_Date()+","+"Deadline-"+ p.getDates().getDeadline()+","+"Deposite_Reminder_date-"+
		    	  p.getDates().getDeposite_Reminder_date()+","+"Withdraw_Reminder_date-"+p.getDates().getWithdraw_Reminder_date()+","+"Draw_Date-"+
			      p.getDates().getDraw_Date()+","+"Deposite_Deadline-"+ p.getDates().getDeposite_Deadline()+"\r\n");
		      myfile.close();
		      System.out.println("creation Successfull");
		      }
		      else 
		      {
		    	  System.out.println("Kameti Party Already Exists");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		
	
	
}
public static void KametiOwner_info(KametiOwner owner)
{
	String temp="";
	boolean flag=true;
	
		try {
		      FileWriter myfile = new FileWriter("owner.txt",true);
		      
		      try {
		          File myObj = new File("owner.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals("cnic-"+owner.getOwner_cnic()))
		                	{
		                	flag=false;
		               
		                break;}
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      {  
		    	  myfile.write("cnic-"+owner.getOwner_cnic() +"\r\n");
		      myfile.close();
		      System.out.println("Owner Successfully Added");
		      }
		      else 
		      {
		    	  System.out.println("Owner Allready Exist!");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		
	
	
}
public static void KametiMember_info(KametiMember m)
{
	String temp="";
	boolean flag=true;
	
		try {
		      FileWriter myfile = new FileWriter("member.txt",true);
		      
		      try {
		          File myObj = new File("member.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals("cnic-"+m.getMember_cnic())||temp.equals("Kameti_ID-"+m.getKameti_ID()))
		                	{
		                	flag=false;
		               
		                break;}
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      {  
		    	  myfile.write("cnic-"+m.getMember_cnic() +"\r\n");
		      myfile.close();
		      System.out.println("member Successfully Added");
		      }
		      else 
		      {
		    	  System.out.println("member Allready Exist!");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		
	
	
}
}
