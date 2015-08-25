package dissertation;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Operation_add_dialog extends JDialog{

	/**
	 * Dialog window for Operation creation
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name_input;
	private JLabel nameJLabel;
	private JButton ok;
	private JButton cancel;
	private String operation_name;
	private boolean added = false;

	private JScrollPane jScrollPane_input;
	private JPanel jPanel_input;
	private JButton add_input;
	
	public Operation_add_dialog(){
		super();
		this.operation_name = "";
		name_input = new JTextField();
		nameJLabel = new JLabel("Name:");
		jScrollPane_input = new JScrollPane();
		jPanel_input = new JPanel();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		add_input = new JButton("Add Input");
		init();
		setModal(true);
		setSize(800, 600);
		
	}
	
	private void init() {
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		
		// set size
		panel.setLayout(null);
		nameJLabel.setSize(40,16);
		name_input.setSize(150,28);
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		add_input.setSize(120, 30);
		jScrollPane_input.setSize(200, 100);
		jPanel_input.setPreferredSize(new Dimension(150,300));
		
		// set location
		nameJLabel.setLocation(40,30);
		name_input.setLocation(100,30);
		ok.setLocation(700, 500);
		cancel.setLocation(700, 450);
		add_input.setLocation(95, 200);
		jScrollPane_input.setLocation(50, 100);

		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		
		add_input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		// end of --- listeners registration=====================================================

		jScrollPane_input.setViewportView(jPanel_input);
		
		panel.add(jScrollPane_input);
		panel.add(nameJLabel);
		panel.add(name_input);
		panel.add(ok);
		panel.add(cancel);
		panel.add(add_input);
		
		container.add(panel);
		
	}
	
	public JButton get_generated_button() {
		JButton jButton = new JButton("Edit");
		jButton.setName(operation_name);
		jButton.setSize(50,30);
		return jButton;
	}
	
	public JLabel get_generated_label() {
		JLabel jLabel = new JLabel(operation_name);
		jLabel.setName(operation_name);
		jLabel.setSize(90, 40);
		return jLabel;
	}
	
	public boolean isCreated() {
		return this.added;
	}
	
	
}
