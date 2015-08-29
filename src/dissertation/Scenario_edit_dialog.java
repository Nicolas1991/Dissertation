package dissertation;
import info.Scenario_info;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Binding;
import uk.ac.sheffield.vtts.model.Memory;
import uk.ac.sheffield.vtts.model.Scenario;


public class Scenario_edit_dialog extends JDialog{

	/**
	 * Dialog window for scenario creation and editing
	 * @author zhangyan
	 */
	
	private Scenario scenario;
	private Memory memory;
	private String scenario_name;
	private boolean added = false;
	private boolean modified = false;
	private boolean deleted = false;
	private Scenario_info scenario_info;
	
	private static final long serialVersionUID = 1L;
	private JTextField name_scenario;
	private JLabel nameJLabel;
	private JButton ok;
	private JButton cancel;
	private JButton bindingButton;
	private JButton conditionButton;
	private JButton effectButton;
	private JLabel binding_status;
	private JLabel condition_status;
	private JLabel effect_status;
	private JScrollPane jScrollPane_binding;
	private JScrollPane jScrollPane_condition;
	private JScrollPane jScrollPane_effect;
	private JEditorPane jEditorPane_binding;
	private JEditorPane jEditorPane_condition;
	private JEditorPane jEditorPane_effect;
	private JLabel bindingLabel;
	private JLabel conditionLabel;
	private JLabel effectLabel;
	
	private JButton delete;
	
	public Scenario_edit_dialog(Memory memory){
		super();
		scenario_info = new Scenario_info();
		scenario = new Scenario();
		this.memory = memory;
		this.scenario_name = "";
		init();

		setTitle("Scenario Editor");
		Container container = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		// creation process listeners registration================================================================
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				scenario_name = name_scenario.getText();
				scenario.setName(scenario_name);
				if (scenario_name.compareToIgnoreCase("")==0) {
					scenario_info = new Scenario_info(
							scenario_name,
							jEditorPane_binding.getText(),
							jEditorPane_condition.getText(),
							jEditorPane_effect.getText());
				}
				added = true;
				dispose();
			}
		});
		
		jEditorPane_binding.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				System.out.println(jEditorPane_binding.getText());
			}
		});
		
		// end of --- creation process listeners registration=====================================================

		jScrollPane_binding.setViewportView(jEditorPane_binding);
		jScrollPane_condition.setViewportView(jEditorPane_condition);
		jScrollPane_effect.setViewportView(jEditorPane_effect);
		
		
		panel.add(nameJLabel);
		panel.add(name_scenario);
		panel.add(ok);
		panel.add(cancel);
		panel.add(bindingButton);
		panel.add(conditionButton);
		panel.add(effectButton);
		panel.add(binding_status);
		panel.add(condition_status);
		panel.add(effect_status);
		panel.add(jScrollPane_binding);
		panel.add(jScrollPane_condition);
		panel.add(jScrollPane_effect);
		panel.add(bindingLabel);
		panel.add(conditionLabel);
		panel.add(effectLabel);
		
		container.add(panel);
	}
	
	public Scenario_edit_dialog(Scenario scenario,Memory memory){
		super();
		this.scenario = scenario;
		this.memory = memory;
		this.scenario_name = "";
		init();

		setTitle("Scenario Editor");
		Container container = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		// creation process listeners registration================================================================
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				scenario_name = name_scenario.getText();
				Scenario_edit_dialog.this.scenario.setName(scenario_name);
				added = true;
				dispose();
			}
		});
		
		// end of --- creation process listeners registration=====================================================

		jScrollPane_binding.setViewportView(jEditorPane_binding);
		jScrollPane_condition.setViewportView(jEditorPane_condition);
		jScrollPane_effect.setViewportView(jEditorPane_effect);
		
		
		panel.add(nameJLabel);
		panel.add(name_scenario);
		panel.add(ok);
		panel.add(cancel);
		panel.add(bindingButton);
		panel.add(conditionButton);
		panel.add(effectButton);
		panel.add(binding_status);
		panel.add(condition_status);
		panel.add(effect_status);
		panel.add(jScrollPane_binding);
		panel.add(jScrollPane_condition);
		panel.add(jScrollPane_effect);
		panel.add(bindingLabel);
		panel.add(conditionLabel);
		panel.add(effectLabel);
		
		container.add(panel);
	}
	
	private void init() {
		
		name_scenario = new JTextField();
		nameJLabel = new JLabel("Name:");
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		bindingButton = new JButton("Save Binding");
		conditionButton = new JButton("Save Condition");
		effectButton = new JButton("Save Effect");
		binding_status = new JLabel("unchecked");
		condition_status = new JLabel("unchecked");
		effect_status = new JLabel("unchecked");
		jScrollPane_binding = new JScrollPane();
		jScrollPane_condition = new JScrollPane();
		jScrollPane_effect = new JScrollPane();
		jEditorPane_binding = new JEditorPane();
		jEditorPane_condition = new JEditorPane();
		jEditorPane_effect = new JEditorPane();
		bindingLabel = new JLabel("Binding");
		conditionLabel = new JLabel("Condition");
		effectLabel = new JLabel("Effect");
		
		
		jEditorPane_binding.setText("test");
		
		//size and location settings 
		nameJLabel.setSize(40,28);
		name_scenario.setSize(150,28);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		bindingButton.setSize(150, 50);
		conditionButton.setSize(150, 50);
		effectButton.setSize(150, 50);
		binding_status.setSize(100, 50);
		condition_status.setSize(100, 30);
		effect_status.setSize(100, 30);
		jScrollPane_binding.setSize(400, 100);
		jScrollPane_condition.setSize(400, 100);
		jScrollPane_effect.setSize(400, 100);
		jEditorPane_binding.setSize(200, 100);
		jEditorPane_condition.setSize(200, 100);
		jEditorPane_effect.setSize(200, 100);
		bindingLabel.setSize(100, 30);
		conditionLabel.setSize(100, 30);
		effectLabel.setSize(100, 30);
		
		nameJLabel.setLocation(100,30);
		name_scenario.setLocation(150,30);
		ok.setLocation(700, 520);
		cancel.setLocation(600, 520);
		bindingButton.setLocation(500, 130);
		conditionButton.setLocation(500, 280);
		effectButton.setLocation(500, 430);
		binding_status.setLocation(700, 130);
		condition_status.setLocation(700, 290);
		effect_status.setLocation(700, 440);
		jScrollPane_binding.setLocation(40, 100);
		jScrollPane_condition.setLocation(40, 260);
		jScrollPane_effect.setLocation(40, 410);
		bindingLabel.setLocation(40, 70);
		conditionLabel.setLocation(40, 230);
		effectLabel.setLocation(40, 380);
		
		// common listeners registration================================================================
		
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		setModal(true);
		setSize(800, 600);
		// end of --- common listeners registration=====================================================

	}
	
	private boolean inGoodFormat_binding(String input) {
		boolean result = false;
		Binding current_binding = new Binding();
		String[] singleLineStrings = input.split("\n");
		for (String singleLine : singleLineStrings) {
			String processingString = singleLine.trim();
			ExpressionParser expressionParser = new ExpressionParser(processingString, memory);
			try {
				Assignment assignment = expressionParser.parseAssignment();
				if (assignment!=null) {
					result = true;
					current_binding.addAssignment(assignment);
					current_binding.execute();
				}
				else {
					result = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("==========");
				result = false;
				break;
			}
			
		}
		
		if (result) {
			scenario.addBinding(current_binding);
		}
		return result;
	}
	
	private boolean inGoodFormat_condition() {
		boolean result = false;
		
		
		
		return result;
	}
	
	private boolean inGoodFormat_effect() {
		boolean result = false;
		
		
		
		return result;
	}
	
	public JButton get_generated_button() {
		JButton jButton = new JButton("Scenario:"+scenario_name);
		jButton.setName(scenario_name);
		jButton.setSize(100,30);
		jButton.setText(scenario_name);
		return jButton;
	}
	
	public boolean isCreated() {
		return this.added;
	}
	
	public Scenario getScenario() {
		return this.scenario;
	}
	
	public boolean isModified() {
		return this.modified;
	}
	
	public boolean isDeleted() {
		return this.deleted;
	}
	
	public Scenario_info getScenario_info() {
		return this.scenario_info;
	}
}
