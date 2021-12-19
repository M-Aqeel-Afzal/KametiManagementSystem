import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

//@MappedSuperclass
@Entity
public class Accounts {
	@Id
	@Column(name = "CNIC")
	private int id;
	private String FName;
	private String LName;
	private String Address;
	private String Contact;
	private String Gender;
	@Transient
	boolean agreementSign=false;
private int Registration_ID;
private String Registration_Date;
public Accounts()
{
	id = 0;
	FName = "";
	LName = "";
	Address = "";
	Contact = "";
	Gender = "";
		Registration_ID = 0; 
	Registration_Date ="";
}



public Accounts(int CNIC, String fName, String lName, String address, String contact, String gender,
		int registration_ID, String registration_Date,boolean fileFlag) {
	super();
	id = CNIC;
	FName = fName;
	LName = lName;
	Address = address;
	Contact = contact;
	Gender = gender;
	Registration_ID = registration_ID;
	Registration_Date = registration_Date;
	String temp="";
	boolean flag=true;
	if(fileFlag)
	{
		Filehandling.Account_Registration(this);
	}
}


public int getRegistration_ID() {
	return Registration_ID;
}



public void setRegistration_ID(int registration_ID) {
	Registration_ID = registration_ID;
}



public String getRegistration_Date() {
	return Registration_Date;
}



public void setRegistration_Date(String registration_Date) {
	Registration_Date = registration_Date;
}



public boolean isAgreementSign() {
	return agreementSign;
}

public void setAgreementSign(boolean agreementSign) {
	this.agreementSign = agreementSign;
}
public int getCNIC() {
	return id;
}
public void setCNIC(int cNIC) {
	id = cNIC;
}
public String getFName() {
	return FName;
}
public void setFName(String fName) {
	FName = fName;
}
public String getLName() {
	return LName;
}
public void setLName(String lName) {
	LName = lName;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getContact() {
	return Contact;
}
public void setContact(String contact) {
	Contact = contact;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
} 
static Accounts getAccount(Session session,int cnic)
{
	  // Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // Create CriteriaQuery
    CriteriaQuery<Accounts> criteria = builder.createQuery(Accounts.class);

    // Specify criteria root
    criteria.from(Accounts.class);

    // Execute query
    List<Accounts> entityList = session.createQuery(criteria).getResultList();

    for (Accounts e : entityList) {
    if(e.getCNIC()==cnic)
    {
   	 return e;
    }
    }
    return null;
}
}
