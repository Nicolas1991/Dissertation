package expression_parser;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Memory;
import uk.ac.sheffield.vtts.model.Variable;
import dissertation.ExpressionParser;

public class TestParser {

	public TestParser(){
		
	}
	public static void main(String[] args) {
		
		Memory memory = new Memory("abc");
		memory.addParameter(new Variable("balance", "Integer"));
		memory.addParameter(new Variable("amount", "Integer"));
		
		try {
			ExpressionParser expressionParser
			= new ExpressionParser("balance = minus(amount,balance",memory);
			Assignment assignment = expressionParser.parseAssignment();
			System.out.println(assignment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		
	}
	
}
