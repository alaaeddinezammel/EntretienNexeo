package test.nexeo.account;

import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import test.nexeo.exception.NegativeAmountException;
import test.nexeo.operation.Operation;
import test.nexeo.operation.Type;
import test.nexeo.statement.History;
import test.nexeo.statement.Statement;
import test.nexeo.statement.Statements;


public class Account {

	private double accountAmount;
	private History<Statement> history;
	
	public Account(double initialAmount, History<Statement> history) {
		this.accountAmount = initialAmount;
		
		if (history != null) {
			this.history = history;
		}
		else {
			this.history = new Statements();
		}
	}

	public void deposit(double deposit) throws NegativeAmountException {

		if (deposit < 0) {
			throw new NegativeAmountException();
		}
		
		makeOperation(Type.DEPOSIT, deposit);
	}

	public void withdraw(double withdraw) throws NegativeAmountException {

		if (withdraw < 0) {
			throw new NegativeAmountException();
		}
		
		makeOperation(Type.WITHDRAW, -withdraw);
	}

	public double getBalance() {
		return accountAmount;
	}
	
	public List<Statement> getHistory() {
		return history.getAll();
	}
	
	public void print(PrintStream printer) {
		history.print(printer);
	}
	
	private void makeOperation(Type type, double amount) {
		
		accountAmount += amount;
		
		addToHistory(type, Math.abs(amount));
	}
	
	private void addToHistory(Type type, double value) {
		Operation operation = new Operation(type, new Date(), value);
		Statement statement = new Statement(operation, getBalance());
		history.add(statement);
	}
}