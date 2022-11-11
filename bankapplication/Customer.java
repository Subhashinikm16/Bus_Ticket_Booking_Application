package bankapplication;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    Scanner ob=new Scanner(System.in);
	private String userName;
    private String emailId;
    private String mobileNumber;
    private String password;
    private static int staticAccountNumber=221067000;
    private static String IFSC_Code="TAMCHE903";
    private String UPI_Id="@upi";
    private static int userId=100;
    private int accountNumber;
    private int balance;
    ArrayList<Transaction> transactions=new ArrayList<>();
    Customer(String name,String mobileno,String emailId,String pwd,int initialAmount){
    	 this.userId=userId++;
    	 this.userName=name;
    	 this.mobileNumber=mobileno;
    	 this.password=pwd;
    	 this.emailId=emailId;
    	 this.balance=initialAmount;
    	 this.accountNumber=staticAccountNumber++;
    	 this.IFSC_Code=IFSC_Code;
    	 this.UPI_Id=this.mobileNumber+this.UPI_Id;
    }
    public String getUserName() {
 		return userName;
 	}
 	public void setUserName(String userName) {
 		this.userName = userName;
 	}
 	public String getEmailId() {
 		return emailId;
 	}
 	public void setEmailId(String emailId) {
 		this.emailId = emailId;
 	}
 	public String getMobileNumber() {
 		return mobileNumber;
 	}
 	public void setMobileNumber(String mobileNumber) {
 		this.mobileNumber = mobileNumber;
 	}
 	public String getPassword() {
 		return password;
 	}
 	public void setPassword(String password) {
 		this.password = password;
 	}
 	public static int getStaticAccountNumber() {
 		return staticAccountNumber;
 	}
 	public static void setStaticAccountNumber(int staticAccountNumber) {
 		Customer.staticAccountNumber = staticAccountNumber;
 	}
 	public int getAccountNumber() {
 		return accountNumber;
 	}
 	public void setAccountNumber(int accountNumber) {
 		this.accountNumber = accountNumber;
 	}
 	public int getBalance() {
 		return balance;
 	}
 	public void setBalance(int balance) {
 		this.balance = balance;
 	}
 	public static int getUserId() {
 		return userId;
 	}
 	public static void setUserId(int userId) {
 		Customer.userId = userId;
 	}
 	public static String getIFSCCode() {
 		return IFSC_Code;
 	}
 	public String getUPIId() {
 		return UPI_Id;
 	}
}
