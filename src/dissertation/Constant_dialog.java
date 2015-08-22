package dissertation;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.ac.sheffield.vtts.model.Constant;

public class Constant_dialog extends JDialog{

	/**
	 * Dialog window for Constant editing
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name_input;
	private JTextField value_input;
	private JLabel nameJLabel;
	private JLabel typeJLabel;
	private JLabel valueJLabel;
	private JMenu typeJMenu;
	private JButton delete;
	private JButton ok;
	private JButton cancel;
	
	
	private Constant constant = new Constant();

	public Constant_dialog(){
		super();
		name_input = new JTextField();
		value_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		typeJLabel = new JLabel("Type:");
		valueJLabel = new JLabel("Value:");
		typeJMenu = new JMenu();
		constant = new Constant();
		delete = new JButton("Delete");
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
	
	public static Constant showConstant_dialog(Component relativeTo) {
		Constant_dialog c = new Constant_dialog();
		c.setLocationRelativeTo(relativeTo);
		c.setVisible(true);
		return c.constant;
	}
}
