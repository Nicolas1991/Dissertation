package expression_parser;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Binding;
import uk.ac.sheffield.vtts.model.Condition;
import uk.ac.sheffield.vtts.model.Constant;
import uk.ac.sheffield.vtts.model.Expression;
import uk.ac.sheffield.vtts.model.Memory;
import uk.ac.sheffield.vtts.model.Predicate;
import uk.ac.sheffield.vtts.model.Scenario;
import uk.ac.sheffield.vtts.model.Variable;
import dissertation.ExpressionParser;

public class TestParser {

	public TestParser(){
		
	}
	public static void main(String[] args) {
		
		Scenario scenario = new Scenario();
		Memory memory = new Memory("abc");
		memory.addParameter(new Variable("balance", "Integer"));
		memory.addParameter(new Variable("amount", "Integer"));
		memory.addParameter(new Constant("zero", "Integer"));
//		Binding binding = new Binding();
		
		char i = 0;
		
//		
//		binding.addAssignment();
//		memory.addBinding();
		String test = "balance=minus(amount,zero";
		try {
			ExpressionParser expressionParser
			= new ExpressionParser(test,memory);
			Assignment assignment = expressionParser.parseAssignment();
			//assignment.evaluate();
			
			System.out.println(assignment.getType());
			
			
			
			
			
			
			
			
			
			
			
			
			//Expression expression = expressionParser.parseExpression();
//			System.out.println(expression.getType());
//			Condition condition = new Condition();
//			if (expression instanceof Predicate) {
//				System.out.println("predicate got");
//				condition.addPredicate((Predicate)expression);
//				scenario.addCondition(condition);
//			}
//			else {
//				System.out.println("format wrong");
//			}
//			System.out.println(assignment);
//			Binding binding = new Binding();
//			binding.addAssignment(assignment);
//			memory.addBinding(binding);
//			memory.addBinding(binding);
//			System.out.println(memory.getBinding().getAssignments().toString());
//			Expression expression = expressionParser.parseExpression();
//			System.out.println(expression.evaluate());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		
	}
	
}
