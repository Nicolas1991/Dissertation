package dissertation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JTextField type_input;
	private JButton ok;
	private JButton cancel;
	private String variable_name;
	private boolean added = false;
	private Variable variable;

	public Variable_add_dialog(final Memory memory){
		super();
		setTitle("Variable");
		this.variable_name = "";
		name_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		type_input = new JTextField();
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
		name_input.setSize(150,28);
		type_input.setSize(100, 28);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		name_input.setLocation(150,30);
		type_input.setLocation(150,90);
		ok.setLocation(250, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean flag = true;
				while (flag) {
					try {
						String name = name_input.getText();
						String type = type_input.getText();
						Variable variable = new Variable(name, type);
						variable.evaluate();
						flag = false;
					} catch (Exception e2) {
						// TODO: pop up error window
						System.out.println("variable type error");
					}
				}
				
				variable_name = name_input.getText();
				variable.setName(name_input.getText());
				variable.setType(type_input.getText());
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
		panel.add(name_input);
		panel.add(type_input);
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
