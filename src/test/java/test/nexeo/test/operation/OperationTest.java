package test.nexeo.test.operation;

import java.util.Date;

import org.junit.Test;

import test.nexeo.operation.Operation;
import test.nexeo.operation.Type;

public class OperationTest {

	@Test(expected=IllegalArgumentException.class)
	public void when_type_is_null_then_should_throw_exception() {
		new Operation(null, new Date(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void when_date_is_null_then_should_throw_exception() {
		new Operation(Type.DEPOSIT, null, 0);
	}
	
}
