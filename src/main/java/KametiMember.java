
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
@Entity
@Table(name="KametiMember")
public class KametiMember{
	@Id
	private int Member_CNIC;
@OneToOne(cascade=CascadeType.ALL)
private Accounts R_Member;
private String KametiName;
private int Kameti_ID;
private String Agreement = "Aqeel abid sahil umer";
public String getContract() {
	return Agreement;
}
public void setContract(String contract) {
	Agreement = contract;
}
@OneToMany(cascade=CascadeType.ALL)
private List<Transections> payments;
public KametiMember()
{
	KametiName="";
	Kameti_ID=0;
	Member_CNIC=0;
	R_Member= null;
	payments=new ArrayList<Transections>();
}
public Accounts getR_Member() {
	return R_Member;
}
public void setR_Member(Accounts r_Member) {
	R_Member = r_Member;
}
public List<Transections> getPayments() {
	return payments;
}
public void setPayments(Transections trans) {
	payments.add(trans);
}
public KametiMember(String kn,int kid,int cnic,Accounts mem) {
	
	KametiName=kn;
	Kameti_ID=kid;
	Member_CNIC=cnic;
	R_Member= mem;
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
public int getMember_cnic() {
	return Member_CNIC;
}
public void setMember_cnic(int member_ID) {
	Member_CNIC = member_ID;
}
static KametiMember getAccount(Session session,int cnic)
{
	 
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<KametiMember> criteria = builder.createQuery(KametiMember.class);
    criteria.from(KametiMember.class);
    List<KametiMember> entityList = session.createQuery(criteria).getResultList();

    for (KametiMember e : entityList) {
    if(e.getMember_cnic()==cnic)
    {
    	
   	 return e;
    }
    }
    return null;
}
static void Deposite(Session session, double amount,int cnic,Transaction trans)
{
	 CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<KametiMember> criteria = builder.createQuery(KametiMember.class);
	    criteria.from(KametiMember.class);
	    List<KametiMember> entityList = session.createQuery(criteria).getResultList();

	    for (KametiMember e : entityList) {
	    if(e.getMember_cnic()==cnic)
	    {
	    	
	    	KametiParty party=KametiParty.getParty(session,e.getKameti_ID());
	    	String date=java.time.LocalDate.now().toString();
	    	Transections tran=new Transections(date,amount,"EasyPeisa","Deposite");
	    	e.setPayments(tran);
	    	 session.update(e);
	    	 party.addTotal_Balance(amount);
	    	 session.update(party);
	    	 trans.commit();
	    }
	    }
}
static double Withdraw(Session session,int cnic,Transaction trans)
{
	 CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<KametiMember> criteria = builder.createQuery(KametiMember.class);
	    criteria.from(KametiMember.class);
	    List<KametiMember> entityList = session.createQuery(criteria).getResultList();
 double amount=0;
	    for (KametiMember e : entityList) {
	    if(e.getMember_cnic()==cnic)
	    {
	    	
	    	KametiParty party=KametiParty.getParty(session,e.getKameti_ID());
	    	String date=java.time.LocalDate.now().toString();
	    	amount=party.withdrawTotal_Balance();
	    	Transections tran=new Transections(date,amount ,"EasyPeisa","Withdraw");
	    	e.setPayments(tran);
	    	 session.update(e);
	    	 session.update(party);
	    	 trans.commit();
	    }
	    }
	    return amount;
}
}
