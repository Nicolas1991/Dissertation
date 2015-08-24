package dissertation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Variable;
import uk.ac.sheffield.vtts.model.Memory;

public class Variable_add_dialog extends JDialog{

	/**
	 * Dialog window for Variable creation
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name_input;
	private JTextField value_input;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JLabel valueJLabel;
	private JMenu typeJMenu;
	private JButton ok;
	private JButton cancel;
	private String variable_name;
	private boolean added = false;
	private Variable variable;

	public Variable_add_dialog(final Memory memory){
		super();
		this.variable_name = "";
		name_input = new JTextField();
		value_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		valueJLabel = new JLabel("Value:");
		typeJMenu = new JMenu();
		variable = new Variable();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		init(memory);
		setModal(true);
		setSize(400, 300);
		
	}
	
	private void init(final Memory memory) {
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		
		
		panel.setLayout(null);
		nameJLabel.setSize(40,16);
		typeJLabel.setSize(40,16);
		valueJLabel.setSize(40,16);
		name_input.setSize(150,28);
		value_input.setSize(150, 28);
		typeJMenu.setSize(100, 20);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		valueJLabel.setLocation(40,150);
		name_input.setLocation(150,30);
		typeJMenu.setLocation(150,90);
		value_input.setLocation(150,150);
		ok.setLocation(250, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				variable_name = name_input.getText();
				variable.setName(name_input.getText());
				variable.setType(typeJMenu.getText());
				variable.setContent(value_input.getText());
				memory.addParameter(variable);
				added = true;
				//System.out.println(memory.getParameter(name_input.getText()));
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
		
		
		// end of --- listeners registration=====================================================

		panel.add(nameJLabel);
		panel.add(typeJLabel);
		panel.add(valueJLabel);
		panel.add(name_input);
		panel.add(value_input);
		panel.add(typeJMenu);
		panel.add(ok);
		panel.add(cancel);
		
		container.add(panel);
		
	}
	
	public JButton get_generated_button() {
		JButton jButton = new JButton("Edit");
		jButton.setName(variable_name);
		jButton.setSize(50,30);
		return jButton;
	}
	
	public JLabel get_generated_label() {
		JLabel jLabel = new JLabel(variable_name);
		jLabel.setName(variable_name);
		jLabel.setSize(90, 40);
		return jLabel;
	}
	
	public boolean isCreated() {
		return this.added;
	}
}
