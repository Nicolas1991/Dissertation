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

public class Input_edit_dialog extends JDialog{

	/**
	 * Dialog window for Input edit
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JLabel name_input;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JTextField type_input;
	private JButton ok;
	private JButton cancel;
	private String input_name;
	private boolean deleted = false;
	private boolean modified = false;
	private Input input;
	private JButton delete;

	
	public Input_edit_dialog(String input_name){
		super();
		this.input_name = input_name;
		name_input = new JLabel(input_name);
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		type_input = new JTextField();
		input = new Input();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		delete = new JButton("Delete");

		init();
		setModal(true);
		setSize(400, 300);
		setTitle("Edit Input");

		
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
		delete.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		name_input.setLocation(150,30);
		type_input.setLocation(150,90);
		ok.setLocation(250, 220);
		delete.setLocation(50, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				input_name = name_input.getText();
				input.setName(name_input.getText());
				input.setType(type_input.getText());
				modified = true;
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
				
				deleted = true;
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
	
	public boolean isDeleted() {
		return this.deleted;
	}
	
	public Input getInput() {
		return this.input;
	}
	
	public boolean isModified() {
		return this.modified;
	}
}
