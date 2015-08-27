package dissertation;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Input;
import uk.ac.sheffield.vtts.model.Operation;
import uk.ac.sheffield.vtts.model.Output;
import uk.ac.sheffield.vtts.model.Scenario;

public class Operation_add_dialog extends JDialog{

	/**
	 * Dialog window for Operation creation
	 * @author zhangyan
	 */
	
    private Map<String,JButton> buttons_input = new HashMap<String,JButton>();
    private Map<String,Input> inputs = new HashMap<String,Input>();
    
    private Map<String,JButton> buttons_output = new HashMap<String,JButton>();
    private Map<String,Output> outputs = new HashMap<String,Output>();
    
    private Map<String,JButton> buttons_scenario = new HashMap<String,JButton>();
    private Map<String,Scenario> scenarios = new HashMap<String,Scenario>();
	
	
	private static final long serialVersionUID = 1L;
	private JTextField name_input;
	private JLabel nameJLabel;
	private JButton ok;
	private JButton cancel;
	private String operation_name;
	private boolean added = false;

	private JScrollPane jScrollPane_input;
	private JPanel jPanel_input;
	private JButton add_input;
	
	private JScrollPane jScrollPane_output;// add
	private JPanel jPanel_output;
	private JButton add_output;
	private JLabel inputJLabel;
	private JLabel outputJLabel;
	private JScrollPane jScrollPane_scenario;
	private JPanel jPanel_scenario;
	private JButton add_scenario;
	private JLabel scenarioJLabel; 
	
	public Operation_add_dialog(){
		super();
		setTitle("Create an operation");
		this.operation_name = "";
		name_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		jScrollPane_input = new JScrollPane();
		jPanel_input = new JPanel();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		add_input = new JButton("Add Input");
		
		inputJLabel = new JLabel("Inputs:");// add
		outputJLabel = new JLabel("Outputs:");// add
		jScrollPane_output = new JScrollPane();// add
		jPanel_output = new JPanel();
		add_output = new JButton("Add Output");
		
		scenarioJLabel = new JLabel("Scenario:");// add
		jScrollPane_scenario = new JScrollPane();// add
		jPanel_scenario = new JPanel();
		add_scenario = new JButton("Add Scenario");
		
		init();
		setModal(true);
		setSize(800, 600);
		
	}
	/**
	 * initialize operation panel
	 */
	private void init() {
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		
		// set size
		panel.setLayout(null);
		nameJLabel.setSize(40,16);
		name_input.setSize(150,28);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		add_input.setSize(120, 30);
		jScrollPane_input.setSize(200, 100);
		jPanel_input.setPreferredSize(new Dimension(150,300));
		
		// add
		add_output.setSize(120, 30);
		add_scenario.setSize(120, 30);
		jScrollPane_output.setSize(200, 100);
		jPanel_output.setPreferredSize(new Dimension(150,300));
		jScrollPane_scenario.setSize(500, 200);
		jPanel_scenario.setPreferredSize(new Dimension(450,500));
		
		add_output.setLocation(395, 200);
		add_scenario.setLocation(400, 500);
		inputJLabel.setSize(40,16);
		inputJLabel.setLocation(100, 70);
		outputJLabel.setSize(50, 16);
		outputJLabel.setLocation(400, 70);
		scenarioJLabel.setSize(100, 16);
		scenarioJLabel.setLocation(100, 270);
		jScrollPane_output.setLocation(350, 100);
		jScrollPane_scenario.setLocation(70, 300);
		
		
		
		// set location
		nameJLabel.setLocation(40,30);
		name_input.setLocation(100,30);
		ok.setLocation(700, 500);
		cancel.setLocation(700, 450);
		add_input.setLocation(95, 200);
		jScrollPane_input.setLocation(50, 100);

		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				added = true;
				operation_name = name_input.getText();
				dispose();
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		add_input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Input_add_dialog input_add_dialog = new Input_add_dialog();
				input_add_dialog.setVisible(true);
				input_add_dialog.setLocationRelativeTo(null);
				
				if (input_add_dialog.isCreated()) {
					// add a button to input panel for editing
					if (!buttons_input.containsKey(input_add_dialog.getInput().getName())) {
						System.out.println("not included");
						JButton jButton = input_add_dialog.get_generated_button();
						jButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								modify_input(e);
								
							}
						});
						buttons_input.put(
								input_add_dialog.getInput().getName(),
								jButton);
						inputs.put(input_add_dialog.getInput().getName(), input_add_dialog.getInput());
						reload_input_panel();
					}
					else {
						Warning_dialog.showWarning("This Input name is occupied");
					}
				}
			}
		});
		
		//add 
		add_output.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Output_add_dialog output_add_dialog = new Output_add_dialog();
				output_add_dialog.setLocationRelativeTo(null);
				output_add_dialog.setVisible(true);
				
				if (output_add_dialog.isCreated()) {
					if (!buttons_output.containsKey(output_add_dialog.getOutput().getName())) {
						System.out.println("not included");
						JButton jButton = output_add_dialog.get_generated_button();
						jButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								modify_output(e);
								
							}
						});
						buttons_output.put(
								output_add_dialog.getOutput().getName(),
								jButton);
						outputs.put(output_add_dialog.getOutput().getName(), output_add_dialog.getOutput());
						reload_output_panel();
					}
					else {
						Warning_dialog.showWarning("This Output name is occupied");
					}
				}
				
			}
		});
		// end of --- listeners registration=====================================================

		jScrollPane_input.setViewportView(jPanel_input);
		jScrollPane_output.setViewportView(jPanel_output);//add
		jScrollPane_scenario.setViewportView(jPanel_scenario);//add
		
		
		panel.add(jScrollPane_input);
		panel.add(nameJLabel);
		panel.add(name_input);
		panel.add(ok);
		panel.add(cancel);
		panel.add(add_input);
		
		//add
		panel.add(inputJLabel);
		panel.add(outputJLabel);
		panel.add(scenarioJLabel);
		panel.add(add_output);
		panel.add(add_scenario);
		panel.add(jScrollPane_output);
		panel.add(jScrollPane_scenario);
		
		
		container.add(panel);
		
	}
	
	
	
	
	
	
	/**
	 * input panel modifiers--------------
	 */
	
	
	private void modify_input(java.awt.event.ActionEvent evt){
		System.out.println("---");
		String input_name = ((JButton)evt.getSource()).getName();
		Input_edit_dialog input_edit_dialog = new Input_edit_dialog(input_name,inputs.get(input_name));
		input_edit_dialog.setLocationRelativeTo(null);
		input_edit_dialog.setVisible(true);
		// actions------------------------------------------------------
		// modify model
		if (input_edit_dialog.isModified()) {
			Input input = input_edit_dialog.getInput();
			inputs.replace(input_name, input);
			reload_input_panel();
		}
		// delete model
		if (input_edit_dialog.isDeleted()) {
			buttons_input.remove(input_name);
			inputs.remove(input_name);
			reload_input_panel();
		}
	}
	
	private void reload_input_panel(){
    	
    	int init_y_position = 10;
    	jPanel_input.removeAll();
    	Set<String> keys = buttons_input.keySet();
    	for (String input_name : keys) {
			JButton jButton = buttons_input.get(input_name);
			jButton.setLocation(100, init_y_position);
			jPanel_input.add(jButton);
    		init_y_position = init_y_position+70;
		}
    	
    	
    	jPanel_input.setPreferredSize(
    			new Dimension(jPanel_input.getWidth(), jPanel_input.getHeight()+init_y_position));
    	jPanel_input.revalidate();
    	validate();
    	repaint();
    }
	
	private void modify_output(java.awt.event.ActionEvent evt){
		System.out.println("editing output--");
		String output_name = ((JButton)evt.getSource()).getName();
		Output_edit_dialog output_edit_dialog = new Output_edit_dialog(output_name,outputs.get(output_name));
		output_edit_dialog.setLocationRelativeTo(null);
		output_edit_dialog.setVisible(true);
		// actions------------------------------------------------------
		// modify model
		if (output_edit_dialog.isModified()) {
			Output output = output_edit_dialog.getOutput();
			outputs.replace(output_name, output);
			reload_output_panel();
		}
		// delete model
		if (output_edit_dialog.isDeleted()) {
			buttons_output.remove(output_name);
			outputs.remove(output_name);
			reload_output_panel();
		}
	}
	
	private void reload_output_panel(){
    	
    	int init_y_position = 10;
    	jPanel_output.removeAll();
    	Set<String> keys = buttons_output.keySet();
    	for (String output_name : keys) {
			JButton jButton = buttons_output.get(output_name);
			jButton.setLocation(100, init_y_position);
			jPanel_output.add(jButton);
    		init_y_position = init_y_position+70;
		}
    	
    	
    	jPanel_output.setPreferredSize(
    			new Dimension(jPanel_output.getWidth(), jPanel_output.getHeight()+init_y_position));
    	jPanel_output.revalidate();
    	validate();
    	repaint();
    }
	
	
	// top level modifiers========================================================/
	
	public Operation getOperation() {
		Operation result = new Operation(name_input.getText());
		
		Set<String> keySet = inputs.keySet();
		for (String keyString : keySet) {
			Input input = inputs.get(keyString);
			result.addParameter(input);		
		}
		
		Set<String> keySet_output = outputs.keySet();
		for (String keyString : keySet_output) {
			Output output = outputs.get(keyString);
			result.addParameter(output);		
		}
		
		
		return result;
	}
	
	/**
	 * button generation for top level
	 * @return
	 */
	public JButton get_generated_button() {
		JButton jButton = new JButton();
		jButton.setName(operation_name);
		jButton.setSize(300,30);
		jButton.setText("Operation: "+operation_name);
		return jButton;
	}
	
	public JLabel get_generated_label() {
		JLabel jLabel = new JLabel(operation_name);
		jLabel.setName(operation_name);
		jLabel.setSize(90, 40);
		return jLabel;
	}
	
	public boolean isCreated() {
		return this.added;
	}
}
