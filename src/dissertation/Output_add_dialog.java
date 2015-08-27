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

public class Output_add_dialog extends JDialog{

	/**
	 * Dialog window for Output creation
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name_output;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JTextField type_output;
	private JButton ok;
	private JButton cancel;
	private String output_name;
	private boolean added = false;
	private Output output;

	public Output_add_dialog(){
		super();
		setTitle("Add an output");
		this.output_name = "";
		name_output = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		type_output = new JTextField();
		output = new Output();
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
		name_output.setSize(150,28);
		type_output.setSize(100, 28);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		
		nameJLabel.setLocation(40,30);
		typeJLabel.setLocation(40,90);
		name_output.setLocation(150,30);
		type_output.setLocation(150,90);
		ok.setLocation(250, 220);
		cancel.setLocation(150, 220);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				output_name = name_output.getText();
				output.setName(name_output.getText());
				output.setType(type_output.getText());
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
		panel.add(name_output);
		panel.add(type_output);
		panel.add(ok);
		panel.add(cancel);
		
		container.add(panel);
		
	}
	
	public JButton get_generated_button() {
		JButton jButton = new JButton("Output:"+output_name);
		jButton.setName(output_name);
		jButton.setSize(100,30);
		jButton.setText(output_name);
		return jButton;
	}
	
	
	public boolean isCreated() {
		return this.added;
	}
	
	public Output getOutput() {
		return this.output;
	}
}
