package info;

import java.util.HashMap;
import uk.ac.sheffield.vtts.model.Operation;

public class Operation_info {

	private String operation_name = "";
	private Operation operation;
	private HashMap<String, Scenario_info> scenario_infos;
	
	public Operation_info(){
		this.operation = new Operation();
		this.scenario_infos = new HashMap<String, Scenario_info>();
	}
	
	public Operation_info(String operation_name){
		
		this.operation_name = operation_name;
		operation = new Operation();
		scenario_infos = new HashMap<String, Scenario_info>();
		
		
	}
	
	public void setName(String operation_name) {
		this.operation_name = operation_name;
	}
	
	
	public void addScenario_info(Scenario_info scenario_info) {
		scenario_infos.put(scenario_info.getName(), scenario_info);
	}
	
	public void deleteScenario_info(String scenario_name) {
		scenario_infos.remove(scenario_name);
	}
	
	public String getName() {
		return this.operation_name;
	}
	
	public Operation getOperation() {
		return this.operation;
	}
	
	public HashMap<String, Scenario_info> getScenario_infos() {
		return this.scenario_infos;
	}
	
	public Scenario_info getScenario_info(String scenario_name) {
		Scenario_info scenario_info = scenario_infos.get(scenario_name);
		return scenario_info;
	}
	
}
