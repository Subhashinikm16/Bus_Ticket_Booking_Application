package bankapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class TransactionHistory {
    Scanner scanner=new Scanner(System.in);
 	Date date1 = new Date();
	public void printDetails(Customer customer){
   	 System.out.println();
   	 System.out.println("Your Account Details:");
 	System.out.printf("%-17s  %-17s","User Id:",customer.getUserId());
 	System.out.println();
 	System.out.printf("%-17s  %-17s","Name: ",customer.getUserName());
 	System.out.println();
 	System.out.printf("%-17s  %-17s","Email Id: ",customer.getEmailId());
 	System.out.println();
 	System.out.printf("%-17s  %-17s","Mobile Number: ",customer.getMobileNumber());
 	System.out.println();
    String str = String.format("%tc", date1 );
 	System.out.printf("%-17s  %-17s","Account Number: ",customer.getAccountNumber());
 	System.out.println();
 	System.out.printf("%-17s  %-17s","IFSC Code: ",customer.getIFSCCode());
 	System.out.println();
 	System.out.printf("%-17s  %-17s","UPI Id: ",customer.getUPIId());
 	System.out.println();
  	 System.out.printf("%-17s  %-17s","Account Balance: ",customer.getBalance());
  	System.out.println();

	}
	
    public void deposit(Customer customer) {
   	 System.out.println();
   	 System.out.print("Enter Amount to Deposit:");
   	 int depositAmount=scanner.nextInt();
   	 customer.setBalance(customer.getBalance()+depositAmount);
   	 System.out.println("Sucessfully Deposited.. Amount "+depositAmount+" Rupees");
     Date date = new Date();
     String str = String.format("%tc", date );
   	 Transaction deposit=new Transaction(str,"Deposit",depositAmount,customer.getBalance(),depositAmount,"Self Deposit");
   	 customer.transactions.add(deposit);
   	 System.out.println("Now Your Account Balance is: "+customer.getBalance());
   	 System.out.println();
    }
    
    public void withdraw(Customer customer){
   	 System.out.println();
   	 System.out.println("Enter Amount to Withdraw");
   	 int withdrawAmount=scanner.nextInt();
   	 if(withdrawAmount<=customer.getBalance()) {
   		 customer.setBalance(customer.getBalance()-withdrawAmount);
   	   	 System.out.println("Sucessfully Withdrawn.. Amount "+withdrawAmount+" Rupees");
   		 System.out.println("Now Your Balance is: "+customer.getBalance());
   	 }
   	 else {
   		 System.out.println("Sorry...InsufficientBalance...");
   		 System.out.println("Your Account Balance is "+customer.getBalance()+" try to withdraw amount within your balance");
   	 }
     Date date = new Date();
     String str = String.format("%tc", date );
   	 Transaction withdraw=new Transaction( str,"Withdraw",withdrawAmount,customer.getBalance(),withdrawAmount,"Self Withdraw");
   	 customer.transactions.add(withdraw);
   	 System.out.println();
    }
    
    public void transfer(Customer receiver,Customer customer){
   	 System.out.println("Enter amount to transfer money");
   	 int transferAmount=scanner.nextInt();
   	 if(transferAmount<=receiver.getBalance()) {
   		 customer.setBalance(customer.getBalance()-transferAmount);
   		 receiver.setBalance(receiver.getBalance()+transferAmount);
   		 System.out.println("Money transfer successfully completed..");
   		 System.out.println("Now your Balance is "+customer.getBalance());
   	 }
   	 else {
   		 System.out.println("Sorry..Insuffient Balance");
   	 }
     Date date = new Date();
     String str = String.format("%tc", date );
   	 Transaction transfer=new Transaction(str,"Transfer",transferAmount,customer.getBalance(),transferAmount,customer.getUserName());
   	customer.transactions.add(transfer);
   	 System.out.println();
    }
    
    public void transaction(Customer customer) {
    	int index=1;
 	    System.out.println("Your Transaction Details");
 	    System.out.println();
    	System.out.printf("%-5s | %-17s | %-17s | %-34s | %-19s | %-17s","S.No","Transaction Id","Transaction Type","Date and Time","Transfered Amount","Account Balance");
    	System.out.println();
    	System.out.println();
 	    for(Transaction t:customer.transactions) {
     	System.out.printf("%-5s | %-17s | %-17s | %-34s | %-19s | %-17s",index++,t.getTransactionId(),t.getOperationType(),t.getDate(),t.getTransactionAmount(),t.getCurrentBalance());
     	System.out.println();
     	System.out.println();
 	   }
    }
}
