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
import uk.ac.sheffield.vtts.model.Constant;
import uk.ac.sheffield.vtts.model.Memory;

public class Constant_add_dialog extends JDialog{

	/**
	 * Dialog window for Constant creation
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
	private String constant_name;
	private boolean added = false;
	private Constant constant;

	public Constant_add_dialog(final Memory memory){
		super();
		this.constant_name = "";
		name_input = new JTextField();
		value_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		valueJLabel = new JLabel("Value:");
		typeJMenu = new JMenu();
		constant = new Constant();
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
				constant_name = name_input.getText();
				constant.setName(name_input.getText());
				constant.setType(typeJMenu.getText());
				constant.setContent(value_input.getText());
				memory.addParameter(constant);
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
		jButton.setName(constant_name);
		jButton.setSize(50,40);
		return jButton;
	}
	
	public JLabel get_generated_label() {
		JLabel jLabel = new JLabel("Constant: "+constant_name);
		jLabel.setSize(90, 40);
		return jLabel;
	}
	
	public boolean isCreated() {
		return this.added;
	}
}
