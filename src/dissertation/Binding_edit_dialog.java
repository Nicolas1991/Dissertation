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

import uk.ac.sheffield.vtts.model.Assignment;
import uk.ac.sheffield.vtts.model.Binding;
import uk.ac.sheffield.vtts.model.Memory;

public class Binding_edit_dialog extends JDialog{

	/**
	 * Dialog window for binding creation and editing
	 * @author zhangyan
	 */
	private Binding binding;
	private String binding_String = "";
	private boolean modified = false;
	
	private static final long serialVersionUID = 1L;
	private JButton ok;
	private JButton cancel;
	private JButton save_binding;
	private JLabel binding_status;
	private JScrollPane jScrollPane_binding;
	private JEditorPane jEditorPane_binding;
	private JLabel bindingLabel;
	
	
	public Binding_edit_dialog(final Memory memory,String binding_String){
		super();
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
		
		jEditorPane_binding.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				Binding_edit_dialog.this.binding_String = jEditorPane_binding.getText();
				if (inGoodFormat_binding(Binding_edit_dialog.this.binding_String, memory)) {
					binding_status.setText("Good Format");
					System.out.println("good format");
					revalidate();
					repaint();
				}
				else {
					binding_status.setText("Bad Format");
					System.out.println("bad format");
				}
			}
		});
		
		save_binding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (inGoodFormat_binding(Binding_edit_dialog.this.binding_String,memory)) {
					Warning_dialog.showWarning("Binding saved, click ok to exit");
				} else {
					Warning_dialog.showWarning("The input String isn't in good format");
				}
				
			}
		});
		// end of --- creation process listeners registration=====================================================

		jScrollPane_binding.setViewportView(jEditorPane_binding);
		jEditorPane_binding.setText(binding_String);
		
		panel.add(ok);
		panel.add(cancel);
		panel.add(save_binding);
		panel.add(binding_status);
		panel.add(jScrollPane_binding);
		panel.add(bindingLabel);
		
		container.add(panel);
	}
	
	private void init() {
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		save_binding = new JButton("Save Binding");
		binding_status = new JLabel("unchecked");
		jScrollPane_binding = new JScrollPane();
		jEditorPane_binding = new JEditorPane();
		bindingLabel = new JLabel("Binding");
		
		
		
		//size and location settings 
		
		ok.setSize(75, 30);
		cancel.setSize(75, 30);
		save_binding.setSize(150, 50);
		binding_status.setSize(100, 50);
		jScrollPane_binding.setSize(400, 300);
		jEditorPane_binding.setSize(200, 300);
		bindingLabel.setSize(100, 30);
		
		ok.setLocation(700, 520);
		cancel.setLocation(600, 520);
		save_binding.setLocation(500, 130);
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
	/**
	 * validate whether the input string is in correct format
	 * @param input
	 * @return
	 */
	private boolean inGoodFormat_binding(String input,Memory memory) {
		boolean result = false;
		Binding current_binding = new Binding();
		String[] singleLineStrings = input.split("\n");
		for (String singleLine : singleLineStrings) {
			String processingString = singleLine.trim();
			ExpressionParser expressionParser = new ExpressionParser(processingString, memory);
			try {
				Assignment assignment = expressionParser.parseAssignment();
				if (assignment!=null) {
					result = true;
					current_binding.addAssignment(assignment);
					//current_binding.execute();
				}
				else {
					result = false;
					break;
				}
			} catch (NullPointerException e) {
				System.out.println("==========");
				result = false;
				break;
			}
			
		}
		
		if (result) {
			binding = current_binding;
		}
		return result;
	}
	
	public String getBindingString() {
		return this.binding_String;
	}
	
	public Binding getBinding() {
		return this.binding;
	}
	
	public boolean isModified() {
		return this.modified;
	}
	
	
		
		
		
}
