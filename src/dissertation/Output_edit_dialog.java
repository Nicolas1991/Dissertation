package dissertation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Output;


public class Output_edit_dialog extends JDialog{

	/**
	 * Dialog window for Output edit
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JLabel name_output;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JTextField type_output;
	private JButton ok;
	private JButton cancel;
	private String output_name;
	private boolean deleted = false;
	private boolean modified = false;
	private Output output;
	private JButton delete;

	
	public Output_edit_dialog(String output_name,Output output){
		super();
		this.output = output;
		this.output_name = output_name;
		name_output = new JLabel(output_name);
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		type_output = new JTextField();
		output = new Output();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		delete = new JButton("Delete");

		init();
		setModal(true);
		setSize(400, 300);
		setTitle("Edit Output");

		
	}
	
	private void init() {
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		
		
		panel.setLayout(null);
		nameJLabel.setSize(40,16);
		typeJLabel.setSize(40,16);
		name_output.setSize(150,28);
		type_output.setSize(100, 28);
		ok.setSize(75, 30);
		delete.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		name_output.setLocation(150,30);
		type_output.setLocation(150,90);
		ok.setLocation(250, 220);
		delete.setLocation(50, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				output_name = name_output.getText();
				output.setName(name_output.getText());
				output.setType(type_output.getText());
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
		panel.add(name_output);
		panel.add(type_output);
		panel.add(ok);
		panel.add(cancel);
		panel.add(delete);
		
		container.add(panel);
		
	}
	
	public JButton get_generated_button() {
		JButton jButton = new JButton("Edit");
		jButton.setName(output_name);
		jButton.setSize(50,30);
		jButton.setText(output_name);
		return jButton;
	}
	
	
	public boolean isDeleted() {
		return this.deleted;
	}
	
	public Output getOutput() {
		return this.output;
	}
	
	public boolean isModified() {
		return this.modified;
	}
}
