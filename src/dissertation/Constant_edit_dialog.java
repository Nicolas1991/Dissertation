package dissertation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Constant;
import uk.ac.sheffield.vtts.model.Memory;

public class Constant_edit_dialog extends JDialog{

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
	private JTextField type_input;
	private JButton delete;
	private JButton ok;
	private JButton cancel;
	private String constant_name;
	private boolean deleted = false;
	
	private Constant constant;

	public Constant_edit_dialog(final Memory memory,String constant_name){
		super();
		setTitle("Constant");
		this.constant_name = constant_name;
		name_input = new JLabel(constant_name);
		value_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		valueJLabel = new JLabel("Value:");
		type_input = new JTextField();
		constant = new Constant();
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
		type_input.setSize(100, 28);
		ok.setSize(75, 30);
		delete.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		valueJLabel.setLocation(40,150);
		name_input.setLocation(150,30);
		type_input.setLocation(150,90);
		value_input.setLocation(150,150);
		ok.setLocation(250, 220);
		delete.setLocation(50, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean flag = true;
				try {
					String name = name_input.getText();
					String type = type_input.getText();
					Constant constant = new Constant(name, type);
					System.out.println(constant.evaluate());
				} catch (Exception e2) {
					// TODO: pop up error window
					System.out.println("Constant type error");
					flag = false;

				}
				if (flag) {
					constant_name = name_input.getText();
					constant.setName(name_input.getText());
					constant.setType(type_input.getText());
					constant.setContent(value_input.getText());
					memory.addParameter(constant);
					//System.out.println(memory.getParameter(name_input.getText()));
					dispose();
				}
				else {
					Warning_dialog.showWarning("This data type can't be evaluated.");
				}
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
				Set<Constant> constants = memory.getConstants();
				for (Constant constant : constants) {
					System.out.println(constant+"----");
					if (constant.getName().compareToIgnoreCase(constant_name)==0) {
						memory.deleteConstant(constant_name);
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
		panel.add(type_input);
		panel.add(ok);
		panel.add(delete);
		panel.add(cancel);
		
		container.add(panel);
		
	}
	
	public boolean isDeleted() {
		return this.deleted;
	}
	
	
}
