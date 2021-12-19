import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class Dates  {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//private int id;
private String Creation_Date;
private String Deadline;
private String Deposite_Reminder_date;
private String Withdraw_Reminder_date;
private String Draw_Date;
private String Deposite_Deadline;
public Dates()
{
	Creation_Date = "";
	Deadline =  "";
	Deposite_Reminder_date =  "";
	Withdraw_Reminder_date =  "";
	Draw_Date =  "";
	Deposite_Deadline =  "";
}
public Dates(String creation_Date, String deadline, String deposite_Reminder_date, String withdraw_Reminder_date,
		String draw_Date, String deposite_Deadline) {
	Creation_Date = creation_Date;
	Deadline = deadline;
	Deposite_Reminder_date = deposite_Reminder_date;
	Withdraw_Reminder_date = withdraw_Reminder_date;
	Draw_Date = draw_Date;
	Deposite_Deadline = deposite_Deadline;
}
                                                //Getter and Setters
public String getCreation_Date() {
	return Creation_Date;
}
public void setCreation_Date(String creation_Date) {
	Creation_Date = creation_Date;
}
public String getDeadline() {
	return Deadline;
}
public void setDeadline(String deadline) {
	Deadline = deadline;
}
public String getDeposite_Reminder_date() {
	return Deposite_Reminder_date;
}
public void setDeposite_Reminder_date(String deposite_Reminder_date) {
	Deposite_Reminder_date = deposite_Reminder_date;
}
public String getWithdraw_Reminder_date() {
	return Withdraw_Reminder_date;
}
public void setWithdraw_Reminder_date(String withdraw_Reminder_date) {
	Withdraw_Reminder_date = withdraw_Reminder_date;
}
public String getDraw_Date() {
	return Draw_Date;
}
public void setDraw_Date(String draw_Date) {
	Draw_Date = draw_Date;
}
public String getDeposite_Deadline() {
	return Deposite_Deadline;
}
public void setDeposite_Deadline(String deposite_Deadline) {
	Deposite_Deadline = deposite_Deadline;
}
void ShowDates()
{
	
System.out.println("Kameti Party Creation_Date: "+this.Creation_Date);
System.out.println("Kameti Party Deadline: "+this.Deadline);
System.out.println("Kameti Party Deposite_Reminder_date: "+this.Deposite_Reminder_date);
System.out.println("Kameti Party Withdraw_Reminder_date: "+this.Withdraw_Reminder_date);
System.out.println("Kameti Party Draw_Date: "+this.Draw_Date);
System.out.println("Kameti Party Deposite_Deadline: "+this.Deposite_Deadline+"\n\n\n");

}
/*
@Override
public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder();
    hcb.append(Creation_Date);
    return hcb.toHashCode();
}
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Dates)) {
        return false;
    }
    Dates that = (Dates) obj;
    EqualsBuilder eb = new EqualsBuilder();
    eb.append(Creation_Date, that.Creation_Date);
    return eb.isEquals();
}*/
}
