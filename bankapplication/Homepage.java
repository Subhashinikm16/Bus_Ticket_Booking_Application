package bankapplication;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Homepage {
   ArrayList<Customer> customers=new ArrayList<>();	
   TransactionHistory accounthistory=new TransactionHistory();
   Scanner scanner=new Scanner(System.in);
   public void start(){
	   System.out.println("-------------------------------------------------------------------------");
	   System.out.println("                     WELCOME TO TAMILNADU BANK                           ");
	   System.out.println("-------------------------------------------------------------------------");
	   boolean starting=true;
	   while(starting) {
		   System.out.println();
		   System.out.println("Choose Any Option: ");
		   System.out.println("1.Login to Existing Account \n2.Create a New Savings Account\n3.About Us\n4.Exit");
		   System.out.println();
		   int option=scanner.nextInt();
		   switch(option) {
		   case 1:{
		   login();
		   }
		   break;
		   case 2:{
			   signUp();
		   }
		   break;
		   case 3:{
			   System.out.println("-------------------------------------------------------------------------");
			   System.out.println("************************SAVE YOUR MONEY ON TIME**************************");
			   System.out.println("**************************TamilNadu Bank*********************************");
			   System.out.println("Our Contact details");
			   System.out.println("TamilNadu Bank providing best services to save people's money since 1958....");
			   System.out.println("Our Main Branch Deatails ");
			   System.out.println("34.TamilNadu Bank");
			   System.out.println("Marina Road");
			   System.out.println("Triplicane");
			   System.out.println("Chennai");
			   System.out.println("TamilNadu--6000005");
			   System.out.println("-------------------------------------------------------------------------");
		   }
		   break;
		   case 4:
		   {
			   System.out.println("-------------------------------------------------------------------------");
			   System.out.println("Use Our Bank...Save Your Money...");
			   System.out.println("Thank You...Visit Again...");
			   System.out.println("-------------------------------------------------------------------------");
			   starting=false;
		   }
		   break;
		   default:
			   System.out.println("Invalid Option");
	   }
   }
   }
   public void signUp() {
	   System.out.println();
	   System.out.println("Enter Your Full Name:");
	   String name=scanner.next();
	   scanner.nextLine();
	   String mobileNumber = "";
	   String phoneNumber;
	   boolean isValidph=false;
	   while(!isValidph)
	   {
		   System.out.println("Enter your Mobile Number:");
		   mobileNumber=scanner.next();
		//   scanner.next();
		   if(isValidMobile(mobileNumber)) {
			   isValidph=true;
			   phoneNumber=mobileNumber;
		   }
		   else {
			  System.out.println("Plase Enter Valid Mobile Number");
		   }
	   }
	   String emailId="";
	   boolean isValidemail=false;
	   while(!isValidemail)
	   {
		   System.out.println("Enter Your EmailId:");
		   emailId=scanner.next();
		   if(isValidEmailId(emailId)) {
			   isValidemail=true;
		   }
		   else {
			   System.out.println("Plase Enter Valid Email Id");
		   }
	   }
	   System.out.println("Enter Password: ");
	   String pwd=scanner.next();
	   System.out.println("Deposit your Initial Amount: ");
	   int amount=scanner.nextInt();
	   System.out.println("Account Created Successfully...");
	   System.out.println();
	   Customer customer=new Customer(name,mobileNumber,emailId,pwd,amount);
	   customers.add(customer);
	   accounthistory.printDetails(customer);
   }
   private void loginOperations(Customer customer) {
	   boolean b=true;
	   while(b) {
		   System.out.println();
		   System.out.println("Enter Options to Perform");
		   System.out.println("1.Deposit\n2.Withdraw\n3.Money Transfer\n4.Your Account Details\n5.Transaction Details\n6.SignOut");
		   int options=scanner.nextInt();
		   System.out.println();
		   switch(options) {
		   case 1:{
			   accounthistory.deposit(customer);
		   }
		   break;
		   case 2:{
			   accounthistory.withdraw(customer);
		   }
		   break;
		   case 3:{
			   System.out.println("Enter any options to to transfer Money");
			   System.out.println("1.Via MobileNumber\n2.Via UPI Id\n3.Via Account Number");
			   int transferType=scanner.nextInt();
			   System.out.println();
			   if(transferType==1) {
			   System.out.println("Enter Mobile Number to Tranfer Money");
			   String mobileNumber=scanner.next();
			   int flag=0;
			   for(Customer receiver:customers) {
				   if(receiver.getMobileNumber().equals(mobileNumber)) {
					   System.out.println("Account Details:");
					   System.out.printf("%-17s  %-17s","Name: ",receiver.getUserName());
					   System.out.println();
					   System.out.printf("%-17s  %-17s","Mobile Number: ",receiver.getMobileNumber());
					   System.out.println();
					   System.out.printf("%-17s  %-17s","Email Id: ",receiver.getEmailId());
					   System.out.println();
					   System.out.printf("%-17s  %-17s","Account Number: ",receiver.getAccountNumber());
					   System.out.println();
					   System.out.printf("%-17s  %-17s","IFSC Code: ",receiver.getIFSCCode());
					   System.out.println();
					   System.out.printf("%-17s  %-17s","UPI Id: ",receiver.getUPIId());
					   System.out.println();
					   System.out.println("Please Check the Receiver's Details");
					   System.out.println("If Receiver's details are Correct You Can Proceed");
					   System.out.println("Want to Proceed");
					   System.out.println("1.yes\n2.No");
					   int proceed=scanner.nextInt();
					   if(proceed==1) {
					   accounthistory.transfer(receiver,customer);  
					   flag=1;
					   }else {
						   System.out.println("Try Again");
					   }
				   }
			   }
			   if(flag==0) {
				   System.out.println("Wrong Mobile Number");
			   }
			   }
			   else if(transferType==2) {
				   System.out.println("Enter UPI Id to Tranfer Money");
				   String upiId=scanner.next();
				   int flag=0;
				   for(Customer receiver:customers) {
					   if(receiver.getUPIId().equals(upiId)) {
						   System.out.println("Account Details:");
						   System.out.printf("%-17s  %-17s","Name: ",receiver.getUserName());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Mobile Number: ",receiver.getMobileNumber());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Email Id: ",receiver.getEmailId());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Account Number: ",receiver.getAccountNumber());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","IFSC Code: ",receiver.getIFSCCode());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","UPI Id: ",receiver.getUPIId());
						   System.out.println();
						   System.out.println("Please Check the Receiver's Details");
						   System.out.println("If Receiver's details are Correct You Can Proceed");
						   System.out.println("Want to Proceed");
						   System.out.println("1.yes\n2.No");
						   int proceed=scanner.nextInt();
						   if(proceed==1) {
						   accounthistory.transfer(receiver,customer);  
						   flag=1;
						   }else {
							   System.out.println("Try Again");
						   }
					   }
				   }
				   if(flag==0) {
					   System.out.println("Wrong UPI Id");
				   }
			   }
			   else if(transferType==3) {
				   System.out.println("Enter Account Number to Tranfer Money");
				   int accNumber=scanner.nextInt();
				   int flag=0;
				   for(Customer receiver:customers) {
					   if(receiver.getAccountNumber()==accNumber) {
						   System.out.println("Account Details:");
						   System.out.printf("%-17s  %-17s","Name: ",receiver.getUserName());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Mobile Number: ",receiver.getMobileNumber());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Email Id: ",receiver.getEmailId());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","Account Number: ",receiver.getAccountNumber());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","IFSC Code: ",receiver.getIFSCCode());
						   System.out.println();
						   System.out.printf("%-17s  %-17s","UPI Id: ",receiver.getUPIId());
						   System.out.println();
						   System.out.println("Please Check the Receiver's Details");
						   System.out.println("If Receiver's details are Correct You Can Proceed");
						   System.out.println("Want to Proceed?");
						   System.out.println("1.yes\n2.No");
						   int proceed=scanner.nextInt();
						   if(proceed==1) {
						   accounthistory.transfer(receiver,customer);  
						   flag=1;
						   }else {
							   System.out.println("Try Again");
						   }  
					   }
				   }
				   if(flag==0) {
					   System.out.println("Wrong Account Number");
				   }
			   }
			   System.out.println();
		   }
		   break;
		   case 4:{ 
			   accounthistory.printDetails(customer);
		   }
		   break;
		   case 5:{
			   accounthistory.transaction(customer);
		   }
		   break;
		   case 6:{
			   b=false;
		   }
	   break;
		   }
   }
   }
   private void login(){
	   Scanner ob=new Scanner(System.in);
	   System.out.println();
	   String emailId="";
	   System.out.println("Enter Your EmailId:");
	   emailId=ob.next();
	   System.out.println("Password:");
	   String pwd=ob.next();
	   int flag=1;
	   for(Customer customer:customers) {
		   if(emailId.equals(customer.getEmailId())) {
			   if(pwd.equals(customer.getPassword())) {
				   flag=0;
				   System.out.println("Login Successfully...");
				   System.out.println("Welcome Back "+customer.getUserName());
				   loginOperations(customer);
			   }
		   }
	   }
	   if(flag==1) {
		   System.out.println("Invalid EmailId or Password..");
	   }
	   System.out.println();
   }
   
   public boolean isValidEmailId(String email_id)
   {
	   Pattern emailPattern=Pattern.compile("([a-z]{1,10})([@][a-z]{1,5}[.][a-z | (com)]{3})");
	   Matcher emailMatcher=emailPattern.matcher(email_id);
	   if(emailMatcher.find()) {
		   return true;
	   }
	   return false;
   }
   public boolean isValidMobile(String mobile)
   {
	   Pattern mobilePattern=Pattern.compile("(0 ||91)?[6-9][0-9]{9}");
	   Matcher mobileMatcher=mobilePattern.matcher(mobile);
	   if(mobileMatcher.find())
		   return true;
	   return false;
   }
}

