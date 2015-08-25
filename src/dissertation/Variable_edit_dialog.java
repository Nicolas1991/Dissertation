package dissertation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Constant;
import uk.ac.sheffield.vtts.model.Variable;
import uk.ac.sheffield.vtts.model.Memory;

public class Variable_edit_dialog extends JDialog{

	/**
	 * Dialog window for Constant editing
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JLabel name_input;
	private JTextField value_input;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JLabel valueJLabel;
	private JMenu typeJMenu;
	private JButton delete;
	private JButton ok;
	private JButton cancel;
	private String variable_name;
	private boolean deleted = false;
	
	private Variable variable;

	public Variable_edit_dialog(final Memory memory,String variable_name){
		super();
		this.variable_name = variable_name;
		name_input = new JLabel(variable_name);
		value_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		valueJLabel = new JLabel("Value:");
		typeJMenu = new JMenu();
		variable = new Variable();
		delete = new JButton("Delete");
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
		delete.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		valueJLabel.setLocation(40,150);
		name_input.setLocation(150,30);
		typeJMenu.setLocation(150,90);
		value_input.setLocation(150,150);
		ok.setLocation(250, 220);
		delete.setLocation(50, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				variable.setName(variable_name);
				variable.setType(typeJMenu.getText());
				variable.setContent(value_input.getText());
				memory.addParameter(variable);
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
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(constant_name);
				Set<Variable> variables = memory.getVariables();
				for (Variable variable : variables) {
					System.out.println(variable+"----");
					if (variable.getName().compareToIgnoreCase(variable_name)==0) {
						memory.deleteViable(variable_name);
						deleted = true;
					}
				}
				
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
		panel.add(delete);
		panel.add(cancel);
		
		container.add(panel);
		
	}
	
	public boolean isDeleted() {
		return this.deleted;
	}
}
