
package telas;
import DAO.ImovelDAO;
import java.awt.event.KeyEvent;
import javabeans.Imovel;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import validacao.validacaoAddImovel;

public class TelaGAdicionaImovel extends javax.swing.JFrame {
    
    public TelaGAdicionaImovel() {
        this.setResizable(false);
        initComponents();
        
        myInitComponents();
    }
    
    public void myInitComponents() {
        txtLog.setDocument(new JTextFieldLimit(45));
        txtNum.setDocument(new JTextFieldLimit(4));
        txtBairro.setDocument(new JTextFieldLimit(45));
        txtCid.setDocument(new JTextFieldLimit(30));
        txtEst.setDocument(new JTextFieldLimit(25));
        txtCep.setDocument(new JTextFieldLimit(8));
        txtComplemento.setDocument(new JTextFieldLimit(45));
        txtVal.setDocument(new JTextFieldLimit(45));
    }

        class JTextFieldLimit extends PlainDocument {

        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEst = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        txtLog = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBairro = new javax.swing.JTextField();
        txtVal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnD = new javax.swing.JRadioButton();
        btnND = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(435, 482));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("Valor: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 370, -1, -1));

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Cidade: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 167, -1, -1));

        txtCid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidKeyPressed(evt);
            }
        });
        getContentPane().add(txtCid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 165, 173, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Estado: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 193, -1, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel1.setText("Adicionar imóveis");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 18, -1, -1));

        txtEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstKeyPressed(evt);
            }
        });
        getContentPane().add(txtEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 191, 173, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("CEP: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 219, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Logradouro: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 89, -1, -1));

        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
        });
        getContentPane().add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 217, 173, -1));

        txtLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogActionPerformed(evt);
            }
        });
        txtLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLogKeyPressed(evt);
            }
        });
        getContentPane().add(txtLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 87, 173, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("Complemento: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 245, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Número: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 115, -1, -1));

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });
        getContentPane().add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 243, 173, -1));

        txtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumKeyPressed(evt);
            }
        });
        getContentPane().add(txtNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 113, 173, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Endereço");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 55, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Bairro: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 141, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 281, 377, -1));

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });
        getContentPane().add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 139, 173, -1));

        txtVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValActionPerformed(evt);
            }
        });
        txtVal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValKeyPressed(evt);
            }
        });
        getContentPane().add(txtVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 368, 173, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Outras informações");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 302, -1, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setText("Status: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 341, -1, -1));

        buttonGroup1.add(btnD);
        btnD.setText("Disponível");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });
        getContentPane().add(btnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 338, -1, -1));

        buttonGroup1.add(btnND);
        btnND.setText("Não disponível");
        btnND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNDActionPerformed(evt);
            }
        });
        getContentPane().add(btnND, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String logradouro = txtLog.getText();
        String numero = txtNum.getText();
        String bairro = txtBairro.getText();
        String cidade = txtCid.getText();
        String estado = txtEst.getText();
        String cep = txtCep.getText();
        String complemento = txtComplemento.getText();
        String status = "";
        if(btnD.isSelected()){
            status = "1";   
        }else if(btnND.isSelected()){
            status = "2";   
        }
        String valor = txtVal.getText();
        
        validacaoAddImovel validador = new validacaoAddImovel();
        if (validador.valida(logradouro, 
                numero,
                bairro,
                cidade,
                estado,
                cep,
                complemento,
                status,
                valor)){
            try{
                Imovel obj = new Imovel();

                obj.setLogradouro(logradouro);
                obj.setNumero(numero);
                obj.setBairro(bairro);
                obj.setCidade(cidade);
                obj.setEstado(estado);
                obj.setCep(cep);
                obj.setComplemento(complemento);
                obj.setStatus(status);   
                obj.setValor(valor);

                ImovelDAO dao = new ImovelDAO();
                if(dao.adicionarImovel(obj)){
                    JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível adicionar o imóvel");
                }

                JOptionPane.showMessageDialog(null, "Imóvel cadastrado com sucesso!");
                limpar();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao registrar imóvel" + e);
            }
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogActionPerformed

    private void txtValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValActionPerformed

    private void btnNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNDActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtNum.setEditable(false);
        } else {
            txtNum.setEditable(true);
        }
    }//GEN-LAST:event_txtNumKeyPressed

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed
        char c = evt.getKeyChar();
            
        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtCep.setEditable(false);
        } else {
            txtCep.setEditable(true);
        }
    }//GEN-LAST:event_txtCepKeyPressed

    private void txtValKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtVal.setEditable(false);
        } else {
            txtVal.setEditable(true);
        }
    }//GEN-LAST:event_txtValKeyPressed

    private void txtLogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogKeyPressed
        char c = evt.getKeyChar();

        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtLog.setEditable(true);
        } else {
            txtLog.setEditable(false);
            
        }
    }//GEN-LAST:event_txtLogKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)  
                || evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtBairro.setEditable(true);
        } else {
            txtBairro.setEditable(false);
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtCidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidKeyPressed
        char c = evt.getKeyChar();
               
        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtCid.setEditable(true);
        } else {
            txtCid.setEditable(false);
        }
    }//GEN-LAST:event_txtCidKeyPressed

    private void txtEstKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c)
                || evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
                || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            txtEst.setEditable(true);
        } else {
            txtEst.setEditable(false);
        }
    }//GEN-LAST:event_txtEstKeyPressed

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
            java.util.logging.Logger.getLogger(TelaGAdicionaImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGAdicionaImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGAdicionaImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGAdicionaImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGAdicionaImovel().setVisible(true);
            }
        });
    }
    
    public void limpar(){
        txtLog.setText("");
        txtNum.setText("");
        txtBairro.setText("");
        txtCid.setText("");
        txtCep.setText("");
        txtComplemento.setText("");
        txtEst.setText("");
        txtVal.setText("");
        buttonGroup1.clearSelection();
        txtLog.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnD;
    private javax.swing.JRadioButton btnND;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCid;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEst;
    private javax.swing.JTextField txtLog;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtVal;
    // End of variables declaration//GEN-END:variables
}
