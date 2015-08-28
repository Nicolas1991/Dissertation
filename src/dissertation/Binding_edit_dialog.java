package dissertation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import uk.ac.sheffield.vtts.model.Binding;
import uk.ac.sheffield.vtts.model.Memory;

public class Binding_edit_dialog extends JDialog{

	/**
	 * Dialog window for binding creation and editing
	 * @author zhangyan
	 */
	private Memory memory;
	private Binding binding;
	private String binding_String = "";
	private boolean modified = false;
	
	private static final long serialVersionUID = 1L;
	private JButton ok;
	private JButton cancel;
	private JButton bindingButton;
	private JLabel binding_status;
	private JScrollPane jScrollPane_binding;
	private JEditorPane jEditorPane_binding;
	private JLabel bindingLabel;
	
	public Binding_edit_dialog(Memory memory){
		super();
		this.binding = new Binding();
		this.memory = memory;
		init();

		setTitle("Edit Memory Binding");
		Container container = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		// creation process listeners registration================================================================
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				modified = true;
				dispose();
			}
		});
		
		jEditorPane_binding.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				binding_String = jEditorPane_binding.getText();
				System.out.println(jEditorPane_binding.getText());
			}
		});
		
		// end of --- creation process listeners registration=====================================================

		jScrollPane_binding.setViewportView(jEditorPane_binding);
		
		
		panel.add(ok);
		panel.add(cancel);
		panel.add(bindingButton);
		panel.add(binding_status);
		panel.add(jScrollPane_binding);
		panel.add(bindingLabel);
		
		container.add(panel);
	}
	
	public Binding_edit_dialog(String binding_String,Memory memory){
		super();
		this.memory = memory;
		init();

		setTitle("Scenario Editor");
		Container container = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		// creation process listeners registration================================================================
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				
				modified = true;
				dispose();
			}
		});
		
		// end of --- creation process listeners registration=====================================================

		jScrollPane_binding.setViewportView(jEditorPane_binding);
		
		
		panel.add(ok);
		panel.add(cancel);
		panel.add(bindingButton);
		panel.add(binding_status);
		panel.add(jScrollPane_binding);
		panel.add(bindingLabel);
		
		container.add(panel);
	}
	
	private void init() {
		
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		bindingButton = new JButton("Save Binding");
		binding_status = new JLabel("unchecked");
		jScrollPane_binding = new JScrollPane();
		jEditorPane_binding = new JEditorPane();
		bindingLabel = new JLabel("Binding");
		
		
		
		//size and location settings 
		
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		bindingButton.setSize(150, 50);
		binding_status.setSize(100, 50);
		jScrollPane_binding.setSize(400, 300);
		jEditorPane_binding.setSize(200, 300);
		bindingLabel.setSize(100, 30);
		
		ok.setLocation(700, 520);
		cancel.setLocation(600, 520);
		bindingButton.setLocation(500, 130);
		binding_status.setLocation(700, 130);
		jScrollPane_binding.setLocation(40, 100);	
		bindingLabel.setLocation(40, 70);
		
		// common listeners registration================================================================
		
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		setModal(true);
		setSize(800, 600);
		// end of --- common listeners registration=====================================================

	}
	
	private boolean inGoodFormat_binding(String input) {
		boolean result = false;
		
		
		
		return result;
	}
	
	
	public Binding getBinding() {
		return this.binding;
	}
	
	public boolean isModified() {
		return this.modified;
	}
	
	
		
		
		
}
