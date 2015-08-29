package dissertation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Expression;
import uk.ac.sheffield.vtts.model.Function;
import uk.ac.sheffield.vtts.model.Memory;
import uk.ac.sheffield.vtts.model.Parameter;
import uk.ac.sheffield.vtts.model.Scope;

/**
 * ExpressionParser is a parser that analyses an Expression or an Assignment.
 * ExpressionParser is constructed with one argument, a String, which is the
 * pretty syntax for a general Expression, or an Assignment.  It provides the
 * two top-level methods <code>parseExpression()</code> and 
 * <code>parseAssignment()</code> to convert the String respectively into an
 * instance of Expression, or an instance of Assignment.  The returned object
 * is an arbitrarily-nested kind of expression.  The parser is able to build
 * nested expressions by calling itself recursively.
 *
 * @author Anthony J H Simons
 * @version 1.0
 */
public class ExpressionParser {
	
	/**
	 * A constant map from operation-names to the names of the model-types
	 * that represent these operations.
	 */
	private static Map<String, String> typeMap;
	static {
		typeMap = new HashMap<String, String>();
		typeMap.put("not", "Proposition");
		typeMap.put("and", "Proposition");
		typeMap.put("or", "Proposition");
		typeMap.put("implies", "Proposition");
		//typeMap.put("equals", "Proposition");


		
		typeMap.put("lessThan", "Comparison");
		typeMap.put("moreThan", "Comparison");
		typeMap.put("notLessThan", "Comparison");
		typeMap.put("notMoreThan", "Comparison");
		typeMap.put("equals", "Comparison");
		typeMap.put("notEquals", "Comparison");
		
		typeMap.put("plus", "Arithmetic");
		typeMap.put("minus", "Arithmetic");
		typeMap.put("times", "Arithmetic");
		typeMap.put("divide", "Arithmetic");
		typeMap.put("negate", "Arithmetic");
		typeMap.put("modulo", "Arithmetic");

		
		// TODO
		// More for you to add here.  Complete this by adding
		// every function name, mapped to the correct model-type.
	}
	
	/**
	 * The input String that you wish to parse.
	 */
	private String input;
	
	/**
	 * The last character read from the input.
	 */
	private char lastChar = 0;
	
	/**
	 * The last index into the input that was read.
	 */
	private int index = 0;
	/**
	 *  Created Memory
	 */
	private Scope memory;
	/**
	 * Returns the next character from the input.
	 * @return
	 */
	private char getChar() {
		if (index < input.length())
			return input.charAt(index++);
		else
			return 0;
	}

	/**
	 * Creates an ExpressionParser to parse the given input String.
	 * @param input the String, containing an expression.
	 */
	public ExpressionParser(String input,Memory memory) throws NullPointerException{
		this.input = input;
		lastChar = getChar();
		this.memory = memory;
	}

	/**
	 * Parses the input expecting it to be an expression.
	 * @return an Expression object.
	 */
	public Expression parseExpression() {
		String name = parseName();
		if (lastChar == '(') {
			// This is the start of a function.
			Function function = getFunction(name);
			for (Expression argument : parseArguments()) {
				function.addExpression(argument);
			}
			return function;
		}
		else if (lastChar == 0) {
			System.out.println("Bad format---from parser");
			throw new NullPointerException();
		}
		else {
			// This is just some kind of parameter.
			return getParameter(name);
		}
	}
	
	/**
	 * Parses the input expecting it to be an Assignment.
	 * @return an Assignment object.
	 */
	public Assignment parseAssignment() {
		Parameter parameter = getParameter(parseName());
		skipSpace();
		String operator = getOperator();
		skipSpace();
		Expression expression = parseExpression();
		Assignment assign = new Assignment(operator);
		assign.addExpression(parameter);
		assign.addExpression(expression);
		return assign;
	}
	
	/**
	 * Parses the input, expecting it to be a bracketed list of further
	 * Expressions.  For each expression in the brackets, invokes the main
	 * parser recursively.  Returns a list of Expressions, which are the
	 * arguments to some higher-level Function.
	 * @return the list of Expressions.
	 */
	private List<Expression> parseArguments() {
		List<Expression> result = new ArrayList<Expression>();
		lastChar = getChar();  // skip the '('
		while (lastChar != ')') {
			// Recursively parses the next expression here.
			Expression argument = parseExpression();
			result.add(argument);
			if (lastChar == ',') {
				lastChar = getChar();  // skip the ','
				skipSpace();
			}
		}
		lastChar = getChar();  // skip the ')'
		return result;
	}
	
	/**
	 * Returns an instance of the right kind of Parameter, with the given
	 * name.  Looks up the name in the environment, returning an instance
	 * of some subclass of Parameter.  The result is an object of one of
	 * the types:  Constant, Variable, Input, Output, Failure.
	 * @param name the name of some kind of Parameter.
	 * @return an instance of the (subclass of) Parameter.
	 */
	private Parameter getParameter(String name) {
		Parameter param = null;
		// TODO
		// Looks up the parameter with the given name from
		// elsewhere in your model -- complete this yourself
		param = memory.getParameter(name);
		return param;
	}
	
	/**
	 * Returns an instance of the right kind of Function, with the given
	 * name.  Looks up the Function's class-name in the typeMap, then creates
	 * an instance of this type, using Java reflection to find the class, find
	 * the class's constructor accepting a String, and invoking this.
	 * @param name the name of some kind of Function.
	 * @return an instance of the (subclass of) Function.
	 */
	private Function getFunction(String name) {
		String typeName = typeMap.get(name);
		String fullName = "uk.ac.sheffield.vtts.model." + typeName;
		try {
			Class<?> type = Class.forName(fullName);
			Constructor<?> creator = type.getConstructor(String.class);
			Object result = creator.newInstance(name);
			return (Function) result;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Converts the next character symbol into an assignment operator name.
	 * @return the assignment operator name.
	 */
	private String getOperator() {
		char opChar = lastChar;
		lastChar = getChar();  // skip the operator char
		switch (opChar) {
		case '<' : return "lessThan";
		case '>' : return "moreThan";
		default : return "equals";
		}
	}

	/**
	 * Returns the next function or parameter name.
	 * @return the function or parameter name.
	 */
	private String parseName() {
		StringBuilder buffer = new StringBuilder();
		while (Character.isAlphabetic(lastChar)) {
			buffer.append(lastChar);
			lastChar = getChar();
		}
		return buffer.toString();
	}

	/**
	 * Skips any whitespace between other tokens
	 */
	private void skipSpace() {
		while (Character.isWhitespace(lastChar)) {
			lastChar = getChar();
		}
	}	
	
}
