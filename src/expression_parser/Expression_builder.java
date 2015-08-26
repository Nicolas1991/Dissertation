package expression_parser;
import java.util.ArrayList;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Function;



public class Expression_builder {

	private static final String Equals = "=";
	private static final String MoreThan = ">";
	private static final String LessThan = "<";

	public static Function parse(String q) throws NullPointerException{
		
		
		if (q!=null) {
			// preprocess for deleting redundant spaces and ignore upper case
			String rawExpression = q.toLowerCase().trim();     
			
			
			//*****************************Assignments***********************************/
			// equal expression builder 
			if (rawExpression.matches("[a-z0-9]+=[a-z0-9]+")) {
				Assignment assignment = new Assignment("equals");
				String[] paras = rawExpression.split("=");
				for (String para : paras) {
					Function equal = Expression_builder.parse(para);
					assignment.addExpression(equal);
				}
				return assignment;
				
				
				throw new NullPointerException();
			}
			
			// moreThan expression builder 
			else if(rawExpression.matches("[a-z0-9]+>[a-z0-9]+")){
				
				Assignment assignment = new Assignment("moreThan");
				String[] paras = rawExpression.split(">");
				for (String para : paras) {
					Function equal = Expression_builder.parse(para);
					assignment.addExpression(equal);
				}
				return assignment;
				
				
				throw new NullPointerException();
			}
			
			// lessThan expression builder
			else if(rawExpression.matches("[a-z0-9]+<[a-z0-9]+")){
				
				Assignment assignment = new Assignment("lessThan");
				String[] paras = rawExpression.split("<");
				for (String para : paras) {
					Function equal = Expression_builder.parse(para);
					assignment.addExpression(equal);
				}
				return assignment;
				
				
				throw new NullPointerException();
			}
			
			//************** atomic expression builder ******************************/
			else if(rawExpression.matches("[a-z]+")){
				return new AtomicQuery(rawExpression);
			}
			else{
				
				throw new NullPointerException();
			}
		}
		else{
			
			throw new NullPointerException();
		}
	}
	/**
	 * 
	 * @param 
	 * s   -processed string query sentence 
	 * @return Query , if the query is in correct format
	 */
	
	private static ArrayList<String> mySplit(String s){
		
		ArrayList<String> result = new ArrayList<>();
		StringBuffer temp = new StringBuffer();
		int flag = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i)==40) {
				flag++;
			}
			if (s.codePointAt(i)==41) {
				flag--;
			}
			if (flag==0) {
				if (s.codePointAt(i)==44) {
					result.add(temp.toString());
					temp = new StringBuffer();
				}
				else {
					temp.append(s.charAt(i));
				}
			}
			else {
				temp.append(s.charAt(i));
			}
		}
		result.add(temp.toString());
		
		return result;
	}
}
