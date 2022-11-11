package bankapplication;

import java.util.Date;

public class Transaction {
private static int staticTranctionId=100;
String operationType;
private int amount;
private long currentBalance;
private int transactionId;
private String amountFrom;
private int transactionAmount;
private String date;
public Transaction( String date,String opertationType,int amount, long currentBalance,int transactionAmount,String amountFrom) {
	this.date=date;
	this.operationType = opertationType;
	this.transactionAmount=transactionAmount;
	this.amount = amount;
	this.currentBalance = currentBalance;
	this.transactionId=staticTranctionId++;
	this.transactionAmount=transactionAmount;
	this.amountFrom=amountFrom;
}
public String getOperationType() {
	return operationType;
}
public void setOperationType(String operationType) {
	this.operationType = operationType;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public long getCurrentBalance() {
	return currentBalance;
}
public void setCurrentBalance(long currentBalance) {
	this.currentBalance = currentBalance;
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public String getAmountFrom() {
	return amountFrom;
}
public int getTransactionAmount() {
	return transactionAmount;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
}
