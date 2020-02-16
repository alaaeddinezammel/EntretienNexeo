package test.nexeo.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import test.nexeo.exception.NegativeAmountException;
import test.nexeo.operation.Operation;
import test.nexeo.operation.Type;
import test.nexeo.statement.Statement;
import test.nexeo.statement.Statements;



public class AccountTest {

	Account Account;
	
	@Before
	public void init() {

		Account = new Account(0, new Statements());
	}
	
	@Test
	public void when_1000_are_deposited_then_account_balance_increases_by_1000() throws NegativeAmountException {

		double oldBalance = Account.getBalance();
		Account.deposit(1000);
		
		assertThat(Account.getBalance() - oldBalance).isEqualTo(1000);
	}
	
	@Test
	public void when_1000_are_withdrawed_then_account_balance_decreases_by_1000() throws NegativeAmountException {

		double oldBalance = Account.getBalance();
		Account.withdraw(1000);
		
		assertThat(oldBalance - Account.getBalance()).isEqualTo(1000);
	}

	@Test(expected=NegativeAmountException.class)
	public void when_negative_amount_is_supplied_for_deposit_then_should_throw_exception() throws NegativeAmountException {

		Account.deposit(-1000);
	}
	
	@Test(expected=NegativeAmountException.class)
	public void when_negative_amount_is_supplied_for_withdraw_then_should_throw_exception() throws NegativeAmountException {

		Account.withdraw(-1000);
	}
	
	@Test
	public void when_1000_are_deposited_then_account_history_contains_deposit_operation_of_1000_with_corresponding_balance() throws NegativeAmountException {
		
		Account.deposit(1000);
		
		Operation operation = new Operation(Type.DEPOSIT, new Date(), 1000);
		Statement expectedStatement = new Statement(operation, 1000);
		
		assertThat(Account.getHistory()).containsExactly(expectedStatement);
	}
	
	@Test
	public void when_1000_are_withdrawed_then_account_history_contains_withdraw_operation_of_1000_with_corresponding_balance() throws NegativeAmountException {
		
		Account.withdraw(1000);
		
		Operation operation = new Operation(Type.WITHDRAW, new Date(), 1000);
		Statement expectedStatement = new Statement(operation, -1000);
		
		assertThat(Account.getHistory()).containsExactly(expectedStatement);
	}
}
