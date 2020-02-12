/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.eduit.course.laboratories.laboratory4;

import java.io.IOException;

/**
 *
 * @author lucas
 */
public class FrmChat extends javax.swing.JFrame implements IChat{
    
    private static ReciveMessage reciveMessage;

    public FrmChat() {
        initComponents();
        startManager();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHost = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnAddContact = new javax.swing.JButton();
        lblMessageSend = new javax.swing.JLabel();
        jspMessageSend = new javax.swing.JScrollPane();
        txtMessageSend = new javax.swing.JTextArea();
        btnSendMessage = new javax.swing.JButton();
        lblIncomingMessage = new javax.swing.JLabel();
        jspIncomingMessages = new javax.swing.JScrollPane();
        txtIncomingMessage = new javax.swing.JTextArea();
        pnlServerMessages = new javax.swing.JPanel();
        sPnlServerMessage = new javax.swing.JScrollPane();
        txtServerMessages = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setLocationByPlatform(true);
        setResizable(false);

        lblHost.setText("Host");

        lblPort.setText("Port");

        btnAddContact.setText("Add Contact");

        lblMessageSend.setText("Send Message");

        txtMessageSend.setColumns(20);
        txtMessageSend.setRows(5);
        jspMessageSend.setViewportView(txtMessageSend);

        btnSendMessage.setText("Send Message");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        lblIncomingMessage.setText("Incoming messages");

        txtIncomingMessage.setEditable(false);
        txtIncomingMessage.setColumns(20);
        txtIncomingMessage.setRows(5);
        jspIncomingMessages.setViewportView(txtIncomingMessage);

        pnlServerMessages.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Messages"));

        txtServerMessages.setEditable(false);
        txtServerMessages.setColumns(20);
        txtServerMessages.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txtServerMessages.setForeground(new java.awt.Color(255, 0, 0));
        txtServerMessages.setRows(5);
        sPnlServerMessage.setViewportView(txtServerMessages);

        javax.swing.GroupLayout pnlServerMessagesLayout = new javax.swing.GroupLayout(pnlServerMessages);
        pnlServerMessages.setLayout(pnlServerMessagesLayout);
        pnlServerMessagesLayout.setHorizontalGroup(
            pnlServerMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPnlServerMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        pnlServerMessagesLayout.setVerticalGroup(
            pnlServerMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPnlServerMessage)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspIncomingMessages)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSendMessage)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblHost)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHost))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblPort)
                                    .addGap(8, 8, 8)
                                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnAddContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMessageSend)
                                .addComponent(jspMessageSend, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblIncomingMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlServerMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlServerMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMessageSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblHost)
                                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPort)
                                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddContact))
                            .addComponent(jspMessageSend, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(lblIncomingMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jspIncomingMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        try {
            String host = txtHost.getText();
            int port = Integer.parseInt(txtPort.getText());
            String message = txtMessageSend.getText();
            MessageSender messageSender = new MessageSender(host, port, message);
            messageSender.start();
        } catch (IOException ex) {
            setErrorMessage(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSendMessageActionPerformed
 
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
            java.util.logging.Logger.getLogger(FrmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChat().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddContact;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JScrollPane jspIncomingMessages;
    private javax.swing.JScrollPane jspMessageSend;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblIncomingMessage;
    private javax.swing.JLabel lblMessageSend;
    private javax.swing.JLabel lblPort;
    private javax.swing.JPanel pnlServerMessages;
    private javax.swing.JScrollPane sPnlServerMessage;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextArea txtIncomingMessage;
    private javax.swing.JTextArea txtMessageSend;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextArea txtServerMessages;
    // End of variables declaration//GEN-END:variables

    private void startManager() {
        try {
            MessageReceiver messageReceiver = new MessageReceiver(8080, this);
            new Thread(messageReceiver).start();
        } catch (IOException ex) {
            setErrorMessage(ex.getMessage());
        }
    }
    
    @Override
    public void setErrorMessage(String message){
        txtServerMessages.setText(txtServerMessages.getText().concat("\nERROR: ").concat(message));
    }

    @Override
    public void setInfoMessage(String message) {
        this.txtServerMessages.setText(txtServerMessages.getText().concat("\nINFO: ").concat(message));
    }

    @Override
    public void setMessageSent(String message) {
        this.txtIncomingMessage.setText(txtIncomingMessage.getText().concat("\n").concat(message));
    }
}
