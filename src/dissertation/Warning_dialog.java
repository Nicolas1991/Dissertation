package dissertation;

import javax.swing.JDialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Warning_dialog extends JDialog{
	
	/**
	 * warning dialog window
	 * @author zhangyan
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nameJLabel;
	private JButton ok;

	public Warning_dialog(String warning_message){
		super();
		nameJLabel = new JLabel(warning_message);
		ok = new JButton("OK");
		init();
		setModal(true);
		setSize(300, 200);
		
	}
	
	private void init() {
		
		Container container = getContentPane();
		JPanel panel = new JPanel();
		
		
		panel.setLayout(null);
		nameJLabel.setSize(300,90);
		ok.setSize(75, 30);
		
		nameJLabel.setLocation(60,10);
		ok.setLocation(125, 120);
		
		// listeners registration=====================================================
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		
		// end of --- listeners registration=====================================================

		panel.add(nameJLabel);
		panel.add(ok);		
		container.add(panel);
		
	}
	
	public static void showWarning(String warning_message) {
		Warning_dialog warning_dialog = new Warning_dialog(warning_message);
		warning_dialog.setLocationRelativeTo(null);
		warning_dialog.setVisible(true);
	}
}
