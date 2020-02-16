package test.nexeo.statement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import test.nexeo.operation.Operation;
import test.nexeo.operation.Type;


public class StatementsTest {

	History<Statement> statements;
	
	@Before
	public void init() {

		statements = new Statements();
	}
	
	@Test
	public void when_adding_new_statement_line_then_statements_container_should_contain_statement_line() {
	
		Operation operation = new Operation(Type.DEPOSIT, new Date(), 1000);
		Statement statement = new Statement(operation, 1599);
		
		statements.add(statement);
		
		assertThat(statements.getAll()).containsExactly(statement);
	}
}
