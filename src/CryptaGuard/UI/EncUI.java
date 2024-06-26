
package capstone.UI;

//Class Imports
import capstone.encryption.Decryption;
import capstone.encryption.Encryption;
import capstone.fileio.FileIO;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class EncUI extends javax.swing.JFrame {

    static FileIO fio = new FileIO();
    public EncUI() {
        initComponents();
    }
  
   
    private void initComponents() {

        encryptPanel = new javax.swing.JPanel();
        decButton = new javax.swing.JButton();
        encButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        fileNameLbl = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        fcBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        titleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        decButton.setText("Decrypt");
        decButton.setMaximumSize(new java.awt.Dimension(69, 23));
        decButton.setMinimumSize(new java.awt.Dimension(69, 23));
        decButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decButtonActionPerformed(evt);
            }
        });

        encButton.setText("Encrypt");
        encButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encButtonActionPerformed(evt);
            }
        });

        infoTextArea.setColumns(20);
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        statusLabel.setLabelFor(infoTextArea);
        statusLabel.setText("Status:");

        fileNameLbl.setLabelFor(fileTextField);
        fileNameLbl.setText("Filename:");

        fileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileTextFieldActionPerformed(evt);
            }
        });

        fcBtn.setText("...");
        fcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.setMaximumSize(new java.awt.Dimension(69, 23));
        exitBtn.setMinimumSize(new java.awt.Dimension(69, 23));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        titleLbl.setBackground(new java.awt.Color(45, 60, 78));
        titleLbl.setFont(new java.awt.Font("Old English Text MT", 3, 36)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(153, 0, 153));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setLabelFor(this);
        titleLbl.setText("CryptaGuard");

        javax.swing.GroupLayout encryptPanelLayout = new javax.swing.GroupLayout(encryptPanel);
        encryptPanel.setLayout(encryptPanelLayout);
        encryptPanelLayout.setHorizontalGroup(
            encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(encryptPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(statusLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encryptPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(encryptPanelLayout.createSequentialGroup()
                        .addComponent(fileNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileTextField)
                        .addGap(18, 18, 18)
                        .addComponent(fcBtn))
                    .addGroup(encryptPanelLayout.createSequentialGroup()
                        .addComponent(encButton)
                        .addGap(106, 106, 106)
                        .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        encryptPanelLayout.setVerticalGroup(
            encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameLbl)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fcBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(encryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encButton)
                    .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(encryptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(encryptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    private void decButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String output;

        String pw = getUserPassword();
        infoTextArea.append("\nAction Selected:    Decrypt File:  " + fio.getEncFile().getName());

        if(!pw.equals("")){
            try {
                infoTextArea.append("\nDecrypting File...");
                output = Decryption.decrypt(fio.getEncFile(),pw);
                infoTextArea.append("\nDecryption Successful");
                infoTextArea.append("\nOutput File Name:    \n" + output);
            }
            catch(BadPaddingException e)
            {
                infoTextArea.append("Wrong Password Given Try again");
            } 
            
            catch (Exception ex) {
                Logger.getLogger(EncUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            infoTextArea.append("\nFile Decryption Cancelled");
            fileTextField.setText("");            
        }

        cleanup();        

    }

    private void encButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String output;
        infoTextArea.append("\nAction Selected:   Encrypt File");
        String pw=getUserPassword();
        
        if(!pw.equals("")){
            try {

                infoTextArea.append("\nEncrypting File...");
                output = Encryption.encrypt(fio.getDecFile(),pw);
                infoTextArea.append("\nEncryption Successful");
                infoTextArea.append("\nOutput File Name:  \n " + output);
            } catch (Exception ex) {
                infoTextArea.append("\nFile Encryption Failed:  \n" + ex);
            }
        }else{
            infoTextArea.append("\nNo Password Entered\nFile Encryption Cancelled");
            fileTextField.setText("");
        }

        cleanup();

    }

    
    private static String getUserPassword() {
        
        JPasswordField pwd = new JPasswordField(15);
        String pw = "";
        int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
        if (action < 0) {
            JOptionPane.showMessageDialog(null, "Cancelling ");
        } else {
            pw = new String(pwd.getPassword());
        }

       
        return pw;
    }
    private void fcBtnActionPerformed(java.awt.event.ActionEvent evt) {
        File file = selectFile();
        if(file!=null){
            if (fio.isEncrypted(file)) {
                encButton.setEnabled(false);
                fio.setEncFile(file);
            } else {
                decButton.setEnabled(false);
                fio.setDecFile(file);
            }
            infoTextArea.append("\nFile Selected:  " + file.getName());
            fileTextField.setText(file.getAbsolutePath());
        }else{
            infoTextArea.append("\nFile Selection Cancelled");
        }        
    }

    private void fileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileTextFieldActionPerformed
        Path path = Paths.get(fileTextField.getText()).toAbsolutePath();
        infoTextArea.append("\n Selected FIle Path:"+path.toString());
        if (Files.exists(path)) {
            if (fio.isEncrypted(path)) {
                encButton.setEnabled(false);
                fio.setEncFile(path);                
            } else {
                decButton.setEnabled(false);
                fio.setDecFile(path);
            }
        } else {
            infoTextArea.append("***Error:  File cannot be found, please check that the correct location was entered. ***");
        }

    }

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        fileTextField.setText("");
        fio.cleanup();
        JOptionPane.showMessageDialog(null, "Thank you for using EncryptThis!!");
        System.exit(0);
        
    }
    public File selectFile() {
        JFileChooser fc = new JFileChooser();
        int action = fc.showOpenDialog(null);
        if(action==JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile();
        }else{
            return null;
        }               
        
    }
   
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new EncUI().setVisible(true);
        });
    }

    private javax.swing.JButton decButton;
    private javax.swing.JButton encButton;
    private javax.swing.JPanel encryptPanel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton fcBtn;
    private javax.swing.JLabel fileNameLbl;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titleLbl;
    

    private void cleanup() {
        fileTextField.setText("");
        decButton.setEnabled(true);
        encButton.setEnabled(true);
        fio.cleanup();
    }
    
}
