package dissertation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Input;

public class Input_add_dialog extends JDialog{

	/**
	 * Dialog window for Input creation
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name_input;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JTextField type_input;
	private JButton ok;
	private JButton cancel;
	private String input_name;
	private boolean added = false;
	private Input input;

	public Input_add_dialog(){
		super();
		this.input_name = "";
		name_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		type_input = new JTextField();
		input = new Input();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		init();
		setModal(true);
		setSize(400, 300);
		
	}
	
	private void init() {
		
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
//				boolean flag = true;
//				while (flag) {
//					try {
//						String name = name_input.getText();
//						String type = type_input.getText();
//						Input input = new Input(name, type);
//						System.out.println(input.evaluate());
//						flag = false;
//					} catch (Exception e2) {
//						// TODO: pop up error window
//						System.out.println("input type error");
//					}
//				}
				input_name = name_input.getText();
				input.setName(name_input.getText());
				input.setType(type_input.getText());
				added = true;
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
		jButton.setName(input_name);
		jButton.setSize(50,30);
		jButton.setText(input_name);
		return jButton;
	}
	
	public JLabel get_generated_label() {
		JLabel jLabel = new JLabel(input_name);
		jLabel.setName(input_name);
		jLabel.setSize(90, 40);
		return jLabel;
	}
	
	public boolean isCreated() {
		return this.added;
	}
	
	public Input getInput() {
		return this.input;
	}
}
