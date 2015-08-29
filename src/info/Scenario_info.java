package info;

import uk.ac.sheffield.vtts.model.Scenario;

public class Scenario_info {

	private Scenario scenario;
	private String scenario_name = "";
	private String binding_String = "";
	private String condition_String = "";
	private String effect_String = "";
		
	public Scenario_info(){
		
	}
	
	public Scenario_info(String name){
		this.scenario_name = name;
		scenario = new Scenario(name);
	}
	
	public Scenario_info(
			String name,
			String bindingString,
			String conditionString,
			String effectString){
		this.scenario_name = name;
		this.binding_String = bindingString;
		this.condition_String = conditionString;
		this.effect_String = effectString;
	}
	
	public void setBindingString(String bindingString) {
		binding_String = bindingString;
	}
	
	public void setConditionString(String conditionString) {
		condition_String = conditionString;
	}
	
	public void setEffectString(String effectString) {
		effect_String = effectString;
	}
	
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	public Scenario getScenario() {
		return this.scenario;
	}
	
	public String getBindingString() {
		return this.binding_String;
	}
	
	public String getConditionString() {
		return this.condition_String;
	}
	
	public String getEffectString() {
		return this.effect_String;
	}
	
	public String getName() {
		return this.scenario_name;
	}
	
	
}
