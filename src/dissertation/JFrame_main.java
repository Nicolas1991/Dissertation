/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissertation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import uk.ac.sheffield.vtts.model.Memory;
import uk.ac.sheffield.vtts.model.Protocol;


/**
 *
 * @author zhangyan
 */
public class JFrame_main extends javax.swing.JFrame {
    
    private Protocol protocol = new Protocol();
    private final Memory memory = new Memory();
    private List<JButton> buttons_memory = new LinkedList<JButton>();
    private List<JLabel> labels_memory = new LinkedList<JLabel>();
    /**
     * Creates new form NewJFrame
     */
    public JFrame_main() {
        initComponents();
        protocol.addMemory(new Memory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel_main = new javax.swing.JPanel();
        jLabel_protocol_name = new javax.swing.JLabel();
        jButton_GenerateXML = new javax.swing.JButton();
        jTextField_protocol_name = new javax.swing.JTextField();
        jLabel_memory = new javax.swing.JLabel();
        jScrollPane_constants = new javax.swing.JScrollPane();
        jPanel_constant = new javax.swing.JPanel();
        jButton_add_constant = new javax.swing.JButton();
        jButton_add_viarable = new javax.swing.JButton();
        jLabel_broker = new javax.swing.JLabel();
        jButton_add_memoryBinding = new javax.swing.JButton();
        jLabel_operation = new javax.swing.JLabel();
        jScrollPane_operation = new javax.swing.JScrollPane();
        jPanel_operation = new javax.swing.JPanel();
        jLabel_operation_added_operation = new javax.swing.JLabel();
        jButton_operation_added_edit = new javax.swing.JButton();
        jButton_add_operation = new javax.swing.JButton();
        jLabel_constants_constant = new javax.swing.JLabel();
        jLabel_constants_viarable = new javax.swing.JLabel();
        jButton_import = new javax.swing.JButton();
        jScrollPane_overview = new javax.swing.JScrollPane();
        jPanel_binding = new javax.swing.JPanel();
        jScrollPane_variable = new javax.swing.JScrollPane();
        jPanel_variable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Broker@Cloud Specification Editor");

        jLabel_protocol_name.setText("Protocol Name:");

        jButton_GenerateXML.setText("Generate XML");
        jButton_GenerateXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenerateXMLActionPerformed(evt);
            }
        });

        jTextField_protocol_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_protocol_nameActionPerformed(evt);
            }
        });

        jLabel_memory.setText("Memory:");

        jScrollPane_constants.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel_constant.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel_constantLayout = new javax.swing.GroupLayout(jPanel_constant);
        jPanel_constant.setLayout(jPanel_constantLayout);
        jPanel_constantLayout.setHorizontalGroup(
            jPanel_constantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel_constantLayout.setVerticalGroup(
            jPanel_constantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jScrollPane_constants.setViewportView(jPanel_constant);

        jButton_add_constant.setText("Add Constant");
        jButton_add_constant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_constantActionPerformed(evt);
            }
        });

        jButton_add_viarable.setText("Add Viarable");
        jButton_add_viarable.setMaximumSize(new java.awt.Dimension(130, 29));
        jButton_add_viarable.setMinimumSize(new java.awt.Dimension(130, 29));

        jLabel_broker.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel_broker.setText("Broker@Cloud Specification Editor");

        jButton_add_memoryBinding.setText("Add Binding Expression");
        jButton_add_memoryBinding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_memoryBindingActionPerformed(evt);
            }
        });

        jLabel_operation.setText("Operation:");

        jScrollPane_operation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel_operation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_operation_added_operation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel_operation_added_operation.setText("Operation");

        jButton_operation_added_edit.setText("Edit");

        javax.swing.GroupLayout jPanel_operationLayout = new javax.swing.GroupLayout(jPanel_operation);
        jPanel_operation.setLayout(jPanel_operationLayout);
        jPanel_operationLayout.setHorizontalGroup(
            jPanel_operationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_operationLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel_operation_added_operation, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton_operation_added_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel_operationLayout.setVerticalGroup(
            jPanel_operationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_operationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_operationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_operation_added_operation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_operation_added_edit))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jScrollPane_operation.setViewportView(jPanel_operation);

        jButton_add_operation.setText("Add Operation");
        jButton_add_operation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_operationActionPerformed(evt);
            }
        });

        jLabel_constants_constant.setText("Constant");

        jLabel_constants_viarable.setText("Viarable");

        jButton_import.setText("Inport State Machine");
        jButton_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_importActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_bindingLayout = new javax.swing.GroupLayout(jPanel_binding);
        jPanel_binding.setLayout(jPanel_bindingLayout);
        jPanel_bindingLayout.setHorizontalGroup(
            jPanel_bindingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel_bindingLayout.setVerticalGroup(
            jPanel_bindingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        jScrollPane_overview.setViewportView(jPanel_binding);

        jPanel_variable.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel_variableLayout = new javax.swing.GroupLayout(jPanel_variable);
        jPanel_variable.setLayout(jPanel_variableLayout);
        jPanel_variableLayout.setHorizontalGroup(
            jPanel_variableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        jPanel_variableLayout.setVerticalGroup(
            jPanel_variableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        jScrollPane_variable.setViewportView(jPanel_variable);

        jLabel1.setText("Binding");

        javax.swing.GroupLayout jPanel_mainLayout = new javax.swing.GroupLayout(jPanel_main);
        jPanel_main.setLayout(jPanel_mainLayout);
        jPanel_mainLayout.setHorizontalGroup(
            jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addContainerGap(645, Short.MAX_VALUE)
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_GenerateXML, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_import, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addGap(0, 267, Short.MAX_VALUE)
                .addComponent(jButton_add_operation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_memory)
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addComponent(jLabel_protocol_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_protocol_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel_broker, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_add_memoryBinding, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_mainLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jScrollPane_operation, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_mainLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel_operation))
                            .addGroup(jPanel_mainLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_add_viarable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane_constants, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_mainLayout.createSequentialGroup()
                                                .addComponent(jLabel_constants_constant)
                                                .addGap(135, 135, 135))
                                            .addComponent(jButton_add_constant))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane_variable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_constants_viarable))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane_overview, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_mainLayout.setVerticalGroup(
            jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_protocol_name)
                    .addComponent(jTextField_protocol_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_broker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_memory)
                .addGap(5, 5, 5)
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_constants_constant)
                    .addComponent(jLabel_constants_viarable)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane_variable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(jScrollPane_constants, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_add_constant)
                            .addComponent(jButton_add_viarable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addComponent(jScrollPane_overview, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_add_memoryBinding, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)))
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addComponent(jScrollPane_operation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_add_operation))
                    .addGroup(jPanel_mainLayout.createSequentialGroup()
                        .addComponent(jLabel_operation)
                        .addGap(8, 8, 8)
                        .addComponent(jButton_import, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_GenerateXML, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButton_GenerateXMLActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
     
    }                                                   

    private void jTextField_protocol_nameActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
        this.protocol = new Protocol(jTextField_protocol_name.getText());
    	protocol.addMemory(memory);
    }                                                        

    private void jButton_add_constantActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        Constant_add_dialog constant_add_dialog = new Constant_add_dialog(memory);
    	constant_add_dialog.setLocationRelativeTo(jButton_add_constant);
    	constant_add_dialog.setVisible(true);
    	
    	if (constant_add_dialog.isCreated()) {
    		JButton jButton = constant_add_dialog.get_generated_button();
        	JLabel jLabel = constant_add_dialog.get_generated_label();
        	jButton.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				jButton_added_edit_constantActionPerformed(e);
    				
    			}
    		});
        	this.buttons_memory.add(jButton);
        	this.labels_memory.add(jLabel);
        	
        	reload_memory_panel();
		}
    	
    	
    }                                                    

    private void jButton_add_operationActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void jButton_importActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButton_add_memoryBindingActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void jButton_added_edit_constantActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
    	String constant_name = ((JButton)evt.getSource()).getName();
    	
    	// pop up edit dialog window
    	Constant_edit_dialog constant_edit_dialog = new Constant_edit_dialog(memory, constant_name);
    	constant_edit_dialog.setLocationRelativeTo((JButton)evt.getSource());
		constant_edit_dialog.setVisible(true);
        
		if (constant_edit_dialog.isDeleted()) {
			System.out.println("deleting constant--");
			for (JButton jButton : buttons_memory) {
				if (jButton.getName().compareToIgnoreCase(constant_name)==0) {
					buttons_memory.remove(jButton);
					break;
				}
			}
			
			for (JLabel jLabel : labels_memory) {
				if (jLabel.getName().compareToIgnoreCase(constant_name)==0) {
					labels_memory.remove(jLabel);
					break;
				}
			}
			reload_memory_panel();
		}
        
        System.out.println("finished editing constant.");
        
    }
    
    
    // model modifiers======================================================================
    private void reload_memory_panel(){
    	int init_y_position = 10;
    	jPanel_constant.removeAll();
    	for (JButton jButton : buttons_memory) {
			jButton.setLocation(120, init_y_position+5);
    		jPanel_constant.add(jButton);
    		init_y_position = init_y_position+70;
		}
    	init_y_position = 10;
    	for (JLabel jLabel : labels_memory) {
			jLabel.setLocation(10, init_y_position);
    		jPanel_constant.add(jLabel);
    		init_y_position = init_y_position+70;
		}
    	jPanel_constant.setPreferredSize(
    			new Dimension(jPanel_constant.getWidth(), jPanel_constant.getHeight()+init_y_position));
    	jPanel_constant.revalidate();
    	validate();
    	repaint();
    	System.out.println(buttons_memory.size());
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_GenerateXML;
    private javax.swing.JButton jButton_add_constant;
    private javax.swing.JButton jButton_add_memoryBinding;
    private javax.swing.JButton jButton_add_operation;
    private javax.swing.JButton jButton_add_viarable;
    private javax.swing.JButton jButton_import;
    private javax.swing.JButton jButton_operation_added_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_broker;
    private javax.swing.JLabel jLabel_constants_constant;
    private javax.swing.JLabel jLabel_constants_viarable;
    private javax.swing.JLabel jLabel_memory;
    private javax.swing.JLabel jLabel_operation;
    private javax.swing.JLabel jLabel_operation_added_operation;
    private javax.swing.JLabel jLabel_protocol_name;
    private javax.swing.JPanel jPanel_binding;
    private javax.swing.JPanel jPanel_constant;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JPanel jPanel_operation;
    private javax.swing.JPanel jPanel_variable;
    private javax.swing.JScrollPane jScrollPane_constants;
    private javax.swing.JScrollPane jScrollPane_operation;
    private javax.swing.JScrollPane jScrollPane_overview;
    private javax.swing.JScrollPane jScrollPane_variable;
    private javax.swing.JTextField jTextField_protocol_name;
    // End of variables declaration                   
}
