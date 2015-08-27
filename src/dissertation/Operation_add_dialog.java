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

public class Operation_add_dialog extends JDialog{

	/**
	 * Dialog window for Operation creation
	 * @author zhangyan
	 */
	
    private Map<String,JButton> buttons_input = new HashMap<String,JButton>();
    private Map<String,Input> inputs = new HashMap<String,Input>();
    
    private Map<String,JButton> buttons_output = new HashMap<String,JButton>();
    private Map<String,Output> outputs = new HashMap<String,Output>();
	
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
	
	public Operation_add_dialog(){
		super();
		this.operation_name = "";
		name_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		inputJLabel = new JLabel("Inputs:");// add
		outputJLabel = new JLabel("Outputs:");// add
		
		jScrollPane_input = new JScrollPane();
		jPanel_input = new JPanel();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		add_input = new JButton("Add Input");
		
		jScrollPane_output = new JScrollPane();// add
		jPanel_output = new JPanel();
		add_output = new JButton("Add Output");
		
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
		jScrollPane_output.setSize(200, 100);
		jPanel_output.setPreferredSize(new Dimension(150,300));
		inputJLabel.setSize(40,16);
		inputJLabel.setLocation(100, 70);
		jScrollPane_output.setLocation(350, 100);
		add_output.setLocation(395, 200);
		outputJLabel.setSize(50, 16);
		outputJLabel.setLocation(400, 70);
		
		
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
				
				if (input_add_dialog.isCreated()) {
					//operation.addParameter(input_add_dialog.getInput());
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
					
					
				}
				//System.out.println(operation.getInputs());
			}
		});
		
		// end of --- listeners registration=====================================================

		jScrollPane_input.setViewportView(jPanel_input);
		jScrollPane_output.setViewportView(jPanel_output);//add
		
		panel.add(jScrollPane_input);
		panel.add(nameJLabel);
		panel.add(name_input);
		panel.add(ok);
		panel.add(cancel);
		panel.add(add_input);
		
		panel.add(inputJLabel);//add
		panel.add(jScrollPane_output);
		panel.add(add_output);
		panel.add(outputJLabel);
		
		
		container.add(panel);
		
	}
	
	
	
	
	
	
	/**
	 * input panel modifiers--------------
	 */
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
	
	
	
	
	// top level modifiers========================================================/
	
	public Operation getOperation() {
		Operation result = new Operation(name_input.getText());
		
		Set<String> keySet = inputs.keySet();
		for (String keyString : keySet) {
			Input input = inputs.get(keyString);
			result.addParameter(input);		
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
