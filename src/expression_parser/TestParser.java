package expression_parser;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Binding;
import uk.ac.sheffield.vtts.model.Constant;
import uk.ac.sheffield.vtts.model.Expression;
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
		memory.addParameter(new Constant("zero", "Integer"));
//		Binding binding = new Binding();
//		
//		binding.addAssignment();
//		memory.addBinding();
		
		try {
			ExpressionParser expressionParser
			= new ExpressionParser("balance =minus(amount,zero)",memory);
			Assignment assignment = expressionParser.parseAssignment();
			System.out.println(assignment);
			Binding binding = new Binding();
			binding.addAssignment(assignment);
			memory.addBinding(binding);
			memory.addBinding(binding);
			System.out.println(memory.getBinding().getAssignments().toString());
//			Expression expression = expressionParser.parseExpression();
//			System.out.println(expression.evaluate());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		
	}
	
}
