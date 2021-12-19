import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transections")
public class Transections {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Trasection_ID;
private String Trasection_Date;
private double Amount;
private String Payment_Method;
private String Payment_type;

public Transections()
{
	Trasection_Date = "";
	Amount = 0;
	Payment_Method = "";
	Payment_type="";
}
public Transections(String trasection_Date, double amount, String payment_Method,String pay_type) {
	
	Trasection_Date = trasection_Date;
	Amount = amount;
	Payment_Method = payment_Method;
	Payment_type=pay_type;
}
public String getPayment_type() {
	return Payment_type;
}
public void setPayment_type(String payment_type) {
	Payment_type = payment_type;
}
public int getTrasection_ID() {
	return Trasection_ID;
}
public void setTrasection_ID(int trasection_ID) {
	Trasection_ID = trasection_ID;
}
public String getTrasection_Date() {
	return Trasection_Date;
}
public void setTrasection_Date(String trasection_Date) {
	Trasection_Date = trasection_Date;
}
public double getAmount() {
	return Amount;
}
public void setAmount(double amount) {
	Amount = amount;
}
public String getPayment_Method() {
	return Payment_Method;
}
public void setPayment_Method(String payment_Method) {
	Payment_Method = payment_Method;
}
}
