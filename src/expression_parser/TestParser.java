package expression_parser;

import uk.ac.sheffield.vtts.model.Assignment;
import dissertation.ExpressionParser;

public class TestParser {

	public TestParser(){
		
	}
	public static void main(String[] args) {
		ExpressionParser expressionParser
		= new ExpressionParser("balance = amount");
		Assignment assignment = expressionParser.parseAssignment();
		System.out.println(assignment);
	}
	
}
