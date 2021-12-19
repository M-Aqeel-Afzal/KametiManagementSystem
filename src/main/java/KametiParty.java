import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Session;
@Entity
@Table(name="KametiParty")
public class KametiParty  {  
private static final AtomicInteger count = new AtomicInteger(0);
private String KametiName;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Kameti_ID;
@Transient
private int Owner_cinc;
private int Capecity;
private int Total_Members;
private double installment_per_month;
private double Total_Balance;
private int vacant_Position;
@Embedded
private Dates dates;
@ManyToMany
private List<KametiMember> Members;
public KametiParty()
{
	Capecity = 0;
	Total_Members = 0;
	this.vacant_Position = 0;
 Members=new  ArrayList<KametiMember>();
}
public List<KametiMember> getMembers() {
	return Members;
}
public void setMembers(KametiMember members) {
	Members.add(members);
}
public double getInstallment_per_month() {
	return installment_per_month;
}
public void setInstallment_per_month(double installment_per_month) {
	this.installment_per_month = installment_per_month;
}
public KametiParty(String name)
{KametiName = name;
	Capecity = 0;
	Total_Members = 0;
	this.vacant_Position = 0;
	
}
public KametiParty(String kametiName, int capecity, double ins,int total_Members, int vacantPosition,Dates d,int owner_cnic) {
	KametiName = kametiName;
	Capecity = capecity;
	Total_Members = total_Members;
	vacant_Position = vacantPosition;
	Total_Balance=0;
	dates=d;
	installment_per_month=ins;
	Owner_cinc=owner_cnic;
	Kameti_ID = count.incrementAndGet(); 
	Filehandling.Parties_info(this);
}
public int getOwner_cinc() {
	return Owner_cinc;
}
public void setOwner_cinc(int owner_cinc) {
	Owner_cinc = owner_cinc;
}
public void setTotal_Balance(double total_Balance) {
	Total_Balance = total_Balance;
}
public Dates getDates() {
	return dates;
}
public void setDates(Dates dates) {
	this.dates = dates;
}
public double getTotal_Balance() {
	return Total_Balance;
}
public void addTotal_Balance(double balance) {
	Total_Balance += balance;
}
public double withdrawTotal_Balance() {
	double b=Total_Balance;
	Total_Balance =0;
	return b;
}
public String getKametiName() {
	return KametiName;
}
public void setKametiName(String kametiName) {
	KametiName = kametiName;
}
public int getKameti_ID() {
	return Kameti_ID;
}
public void setKameti_ID(int kameti_ID) {
	Kameti_ID = kameti_ID;
}
public int getCapecity() {
	return Capecity;
}
public void setCapecity(int capecity) {
	Capecity = capecity;
}
public int getTotal_Members() {
	return Total_Members;
}
public void setTotal_Members(int total_Members) {
	Total_Members = total_Members;
}
public int getVacant_Position() {
	return vacant_Position;
}
public void setVacant_Position(int vacant_Position) {
	this.vacant_Position = vacant_Position;
}
public static Accounts register_member(int cnic,String fn,String ln,String addr,String cont,String gen,boolean FileFlag) 
{
	int Rid = count.incrementAndGet(); 
	String date=java.time.LocalDate.now().toString();
	Accounts register_member= new Accounts(cnic, fn, ln, addr, cont, gen,Rid,date,FileFlag);
	return register_member;
}

static KametiParty getParty(Session session,int id)
{
	  // Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // Create CriteriaQuery
    CriteriaQuery<KametiParty> criteria = builder.createQuery(KametiParty.class);

    // Specify criteria root
    criteria.from(KametiParty.class);

    // Execute query
    List<KametiParty> entityList = session.createQuery(criteria).getResultList();

    for (KametiParty e : entityList) {
    if(e.getKameti_ID()==id)
    {
    	
   	 return e;
    }
    }
    return null;
}
static void ShowParties(Session session)
{
	  // Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // Create CriteriaQuery
    CriteriaQuery<KametiParty> criteria = builder.createQuery(KametiParty.class);

    // Specify criteria root
    criteria.from(KametiParty.class);

    // Execute query
    List<KametiParty> entityList = session.createQuery(criteria).getResultList();

    for (KametiParty e : entityList) {
   System.out.println("Kameti Party ID: "+e.Kameti_ID);
   System.out.println("Kameti Party KametiName: "+e.KametiName);
   System.out.println("Kameti Party Capecity: "+e.Capecity);
   System.out.println("Kameti Party Total_Members: "+e.Total_Members);
   System.out.println("Kameti Party vacant_Position: "+e.vacant_Position);
   e.dates.ShowDates();
    }
    
}

static void ShowPartiesofMember(Session session,int cnic)
{
	  // Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // Create CriteriaQuery
    CriteriaQuery<KametiMember> criteria = builder.createQuery(KametiMember.class);

    // Specify criteria root
    criteria.from(KametiMember.class);

    // Execute query
    List<KametiMember> entityList = session.createQuery(criteria).getResultList();

    for (KametiMember e : entityList) {
    	if(e.getMember_cnic()==cnic)
    	{
    		int kid=e.getKameti_ID();
    		// Create CriteriaBuilder
    	    CriteriaBuilder builder1 = session.getCriteriaBuilder();

    	    // Create CriteriaQuery
    	    CriteriaQuery<KametiParty> criteria1= builder1.createQuery(KametiParty.class);

    	    // Specify criteria root
    	    criteria1.from(KametiParty.class);

    	    // Execute query
    	    List<KametiParty> entityList1 = session.createQuery(criteria1).getResultList();
    	    for (KametiParty k : entityList1) {
    	    	
    	    	if(k.getKameti_ID()==kid)
    	    	{
   System.out.println("Kameti Party ID: "+k.Kameti_ID);
   System.out.println("Kameti Party KametiName: "+k.KametiName);
   System.out.println("Kameti Party Total Balance: "+k.Total_Balance);
   System.out.println("Kameti Party Installment per month: "+k.installment_per_month+"\n\n\n");
   
    	    	}
    	    }
  
    }
    
    }
}
}
