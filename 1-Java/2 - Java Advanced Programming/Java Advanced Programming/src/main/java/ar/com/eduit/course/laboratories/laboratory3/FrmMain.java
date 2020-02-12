package ar.com.eduit.course.laboratories.laboratory3;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class FrmMain extends javax.swing.JFrame {

    private Counter counter1;
    private Counter counter2;
    private Counter counter3;
    private Counter counter4;

    public FrmMain() {
        initComponents();

        loadComboPriority(cmbT1);
        loadComboPriority(cmbT2);
        loadComboPriority(cmbT3);
        loadComboPriority(cmbT4);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblT1 = new javax.swing.JLabel();
        txtT1 = new javax.swing.JTextField();
        btnStartT1 = new javax.swing.JButton();
        btnStopT1 = new javax.swing.JButton();
        btnWaitT1 = new javax.swing.JButton();
        btnNotifyT1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSuspendT1 = new javax.swing.JButton();
        btnResumeT1 = new javax.swing.JButton();
        lblPriority1 = new javax.swing.JLabel();
        cmbT1 = new javax.swing.JComboBox<>();
        chkPauseT1 = new javax.swing.JCheckBox();
        txtPauseT1 = new javax.swing.JTextField();
        lblT2 = new javax.swing.JLabel();
        txtT2 = new javax.swing.JTextField();
        btnStartT2 = new javax.swing.JButton();
        btnStopT2 = new javax.swing.JButton();
        btnWaitT2 = new javax.swing.JButton();
        btnNotifyT2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSuspendT2 = new javax.swing.JButton();
        btnResumeT2 = new javax.swing.JButton();
        lblPriority2 = new javax.swing.JLabel();
        cmbT2 = new javax.swing.JComboBox<>();
        chkPauseT2 = new javax.swing.JCheckBox();
        txtPauseT2 = new javax.swing.JTextField();
        lblT3 = new javax.swing.JLabel();
        txtT3 = new javax.swing.JTextField();
        btnStartT3 = new javax.swing.JButton();
        btnStopT3 = new javax.swing.JButton();
        btnWaitT3 = new javax.swing.JButton();
        btnNotifyT3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnSuspendT3 = new javax.swing.JButton();
        btnResumeT3 = new javax.swing.JButton();
        lblPriority3 = new javax.swing.JLabel();
        cmbT3 = new javax.swing.JComboBox<>();
        chkPauseT3 = new javax.swing.JCheckBox();
        txtPauseT3 = new javax.swing.JTextField();
        lblT4 = new javax.swing.JLabel();
        txtT4 = new javax.swing.JTextField();
        btnStartT4 = new javax.swing.JButton();
        btnStopT4 = new javax.swing.JButton();
        btnWaitT4 = new javax.swing.JButton();
        btnNotifyT4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnSuspendT4 = new javax.swing.JButton();
        btnResumeT4 = new javax.swing.JButton();
        lblPriority4 = new javax.swing.JLabel();
        cmbT4 = new javax.swing.JComboBox<>();
        chkPauseT4 = new javax.swing.JCheckBox();
        txtPauseT4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Threads");

        lblT1.setText("Thread 1");

        txtT1.setEditable(false);

        btnStartT1.setText("Start");
        btnStartT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT1ActionPerformed(evt);
            }
        });

        btnStopT1.setText("Stop");
        btnStopT1.setEnabled(false);
        btnStopT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopT1ActionPerformed(evt);
            }
        });

        btnWaitT1.setText("Wait");
        btnWaitT1.setEnabled(false);
        btnWaitT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitT1ActionPerformed(evt);
            }
        });

        btnNotifyT1.setText("Notify");
        btnNotifyT1.setEnabled(false);
        btnNotifyT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyT1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSuspendT1.setText("Suspend");
        btnSuspendT1.setEnabled(false);
        btnSuspendT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendT1ActionPerformed(evt);
            }
        });

        btnResumeT1.setText("Resume");
        btnResumeT1.setEnabled(false);
        btnResumeT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeT1ActionPerformed(evt);
            }
        });

        lblPriority1.setText("Prioridad");

        cmbT1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cmbT1.setSelectedIndex(-1);

        chkPauseT1.setSelected(true);
        chkPauseT1.setText("Pause");

        txtPauseT1.setText("100");

        lblT2.setText("Thread 2");

        txtT2.setEditable(false);

        btnStartT2.setText("Start");
        btnStartT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT2ActionPerformed(evt);
            }
        });

        btnStopT2.setText("Stop");
        btnStopT2.setEnabled(false);
        btnStopT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopT2ActionPerformed(evt);
            }
        });

        btnWaitT2.setText("Wait");
        btnWaitT2.setEnabled(false);
        btnWaitT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitT2ActionPerformed(evt);
            }
        });

        btnNotifyT2.setText("Notify");
        btnNotifyT2.setEnabled(false);
        btnNotifyT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyT2ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSuspendT2.setText("Suspend");
        btnSuspendT2.setEnabled(false);
        btnSuspendT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendT2ActionPerformed(evt);
            }
        });

        btnResumeT2.setText("Resume");
        btnResumeT2.setEnabled(false);
        btnResumeT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeT2ActionPerformed(evt);
            }
        });

        lblPriority2.setText("Prioridad");

        cmbT2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cmbT2.setSelectedIndex(-1);

        chkPauseT2.setSelected(true);
        chkPauseT2.setText("Pause");

        txtPauseT2.setText("100");

        lblT3.setText("Thread 3");

        txtT3.setEditable(false);

        btnStartT3.setText("Start");
        btnStartT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT3ActionPerformed(evt);
            }
        });

        btnStopT3.setText("Stop");
        btnStopT3.setEnabled(false);
        btnStopT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopT3ActionPerformed(evt);
            }
        });

        btnWaitT3.setText("Wait");
        btnWaitT3.setEnabled(false);
        btnWaitT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitT3ActionPerformed(evt);
            }
        });

        btnNotifyT3.setText("Notify");
        btnNotifyT3.setEnabled(false);
        btnNotifyT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyT3ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSuspendT3.setText("Suspend");
        btnSuspendT3.setEnabled(false);
        btnSuspendT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendT3ActionPerformed(evt);
            }
        });

        btnResumeT3.setText("Resume");
        btnResumeT3.setEnabled(false);
        btnResumeT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeT3ActionPerformed(evt);
            }
        });

        lblPriority3.setText("Prioridad");

        cmbT3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cmbT3.setSelectedIndex(-1);

        chkPauseT3.setSelected(true);
        chkPauseT3.setText("Pause");

        txtPauseT3.setText("100");

        lblT4.setText("Thread 4");

        txtT4.setEditable(false);

        btnStartT4.setText("Start");
        btnStartT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartT4ActionPerformed(evt);
            }
        });

        btnStopT4.setText("Stop");
        btnStopT4.setEnabled(false);
        btnStopT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopT4ActionPerformed(evt);
            }
        });

        btnWaitT4.setText("Wait");
        btnWaitT4.setEnabled(false);
        btnWaitT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitT4ActionPerformed(evt);
            }
        });

        btnNotifyT4.setText("Notify");
        btnNotifyT4.setEnabled(false);
        btnNotifyT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyT4ActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSuspendT4.setText("Suspend");
        btnSuspendT4.setEnabled(false);
        btnSuspendT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendT4ActionPerformed(evt);
            }
        });

        btnResumeT4.setText("Resume");
        btnResumeT4.setEnabled(false);
        btnResumeT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeT4ActionPerformed(evt);
            }
        });

        lblPriority4.setText("Prioridad");

        cmbT4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cmbT4.setSelectedIndex(-1);

        chkPauseT4.setSelected(true);
        chkPauseT4.setText("Pause");

        txtPauseT4.setText("100");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtT1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStopT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWaitT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotifyT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuspendT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResumeT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPriority1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbT1, 0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtT2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStopT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWaitT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotifyT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuspendT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResumeT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPriority2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbT2, 0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtT3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStopT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWaitT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotifyT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuspendT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResumeT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPriority3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbT3, 0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtT4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStopT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWaitT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotifyT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuspendT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResumeT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPriority4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkPauseT3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPauseT3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkPauseT4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPauseT4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkPauseT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPauseT2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkPauseT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPauseT1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuspendT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnResumeT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPriority1)
                        .addComponent(cmbT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkPauseT1)
                        .addComponent(txtPauseT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnStartT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnStopT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnWaitT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNotifyT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblT1)
                                    .addComponent(txtT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuspendT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnResumeT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPriority2)
                        .addComponent(cmbT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkPauseT2)
                        .addComponent(txtPauseT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStopT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWaitT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotifyT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblT2)
                            .addComponent(txtT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuspendT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnResumeT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPriority3)
                        .addComponent(cmbT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkPauseT3)
                        .addComponent(txtPauseT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStopT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWaitT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotifyT3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblT3)
                            .addComponent(txtT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSuspendT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnResumeT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPriority4)
                        .addComponent(cmbT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkPauseT4)
                        .addComponent(txtPauseT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStopT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWaitT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotifyT4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblT4)
                            .addComponent(txtT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT1ActionPerformed
        counter1 = new Counter(txtT1);
        counter1.setPriority(Integer.parseInt(cmbT1.getSelectedItem().toString()));
        counter1.start();
        btnStartT1.setEnabled(false);
        btnStopT1.setEnabled(true);
        btnWaitT1.setEnabled(true);
        btnSuspendT1.setEnabled(true);
    }//GEN-LAST:event_btnStartT1ActionPerformed

    private void btnStartT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT2ActionPerformed
        counter2 = new Counter(txtT2);
        counter2.start();
    }//GEN-LAST:event_btnStartT2ActionPerformed

    private void btnStartT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT3ActionPerformed
        counter3 = new Counter(txtT3);
        counter3.start();
    }//GEN-LAST:event_btnStartT3ActionPerformed

    private void btnStartT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartT4ActionPerformed
        counter4 = new Counter(txtT4);
        counter4.start();
    }//GEN-LAST:event_btnStartT4ActionPerformed

    private void btnStopT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopT1ActionPerformed
        btnStartT1.setEnabled(true);
        btnStopT1.setEnabled(false);
        btnWaitT1.setEnabled(false);
        btnNotifyT1.setEnabled(false);
        btnSuspendT1.setEnabled(false);
        btnResumeT1.setEnabled(false);
        counter1.stop();
    }//GEN-LAST:event_btnStopT1ActionPerformed

    private void btnStopT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopT2ActionPerformed
        btnStartT2.setEnabled(true);
        btnStopT2.setEnabled(false);
        btnWaitT2.setEnabled(false);
        btnNotifyT2.setEnabled(false);
        btnSuspendT2.setEnabled(false);
        btnResumeT2.setEnabled(false);
        counter2.stop();
    }//GEN-LAST:event_btnStopT2ActionPerformed

    private void btnStopT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopT3ActionPerformed
        btnStartT3.setEnabled(true);
        btnStopT3.setEnabled(false);
        btnWaitT3.setEnabled(false);
        btnNotifyT3.setEnabled(false);
        btnSuspendT3.setEnabled(false);
        btnResumeT3.setEnabled(false);
        counter3.stop();
    }//GEN-LAST:event_btnStopT3ActionPerformed

    private void btnStopT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopT4ActionPerformed
        btnStartT4.setEnabled(true);
        btnStopT4.setEnabled(false);
        btnWaitT4.setEnabled(false);
        btnNotifyT4.setEnabled(false);
        btnSuspendT4.setEnabled(false);
        btnResumeT4.setEnabled(false);
        counter4.stop();
    }//GEN-LAST:event_btnStopT4ActionPerformed

    private void btnWaitT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitT1ActionPerformed
        try {
            chkPauseT1.setSelected(true);
            btnNotifyT1.setEnabled(true);
            btnWaitT1.setEnabled(false);
            counter1.wait();
        } catch (InterruptedException ex) {
        }
    }//GEN-LAST:event_btnWaitT1ActionPerformed

    private void btnWaitT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitT2ActionPerformed
        try {
            chkPauseT2.setSelected(true);
            btnNotifyT3.setEnabled(true);
            btnWaitT2.setEnabled(false);
            counter2.wait();
        } catch (InterruptedException ex) {
        }
    }//GEN-LAST:event_btnWaitT2ActionPerformed

    private void btnWaitT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitT3ActionPerformed
        try {
            chkPauseT3.setSelected(true);
            btnNotifyT3.setEnabled(true);
            btnWaitT3.setEnabled(false);
            counter3.wait();
        } catch (InterruptedException ex) {
        }
    }//GEN-LAST:event_btnWaitT3ActionPerformed

    private void btnWaitT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitT4ActionPerformed
        try {
            chkPauseT4.setSelected(true);
            btnNotifyT4.setEnabled(true);
            btnWaitT4.setEnabled(false);
            counter4.wait();
        } catch (InterruptedException ex) {
        }
    }//GEN-LAST:event_btnWaitT4ActionPerformed

    private void btnNotifyT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyT1ActionPerformed
        chkPauseT1.setSelected(false);
        counter1.notify();
    }//GEN-LAST:event_btnNotifyT1ActionPerformed

    private void btnNotifyT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyT2ActionPerformed
        chkPauseT2.setSelected(false);
        counter2.notify();
    }//GEN-LAST:event_btnNotifyT2ActionPerformed

    private void btnNotifyT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyT3ActionPerformed
        chkPauseT3.setSelected(false);
        counter3.notify();
    }//GEN-LAST:event_btnNotifyT3ActionPerformed

    private void btnNotifyT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyT4ActionPerformed
        chkPauseT4.setSelected(false);
        counter4.notify();
    }//GEN-LAST:event_btnNotifyT4ActionPerformed

    private void btnSuspendT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendT1ActionPerformed
        counter1.suspend();
        btnSuspendT1.setEnabled(false);
        btnResumeT1.setEnabled(true);
        btnWaitT1.setEnabled(false);
    }//GEN-LAST:event_btnSuspendT1ActionPerformed

    private void btnSuspendT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendT2ActionPerformed
        counter2.suspend();
        btnSuspendT2.setEnabled(false);
        btnResumeT2.setEnabled(true);
        btnWaitT2.setEnabled(false);
        
    }//GEN-LAST:event_btnSuspendT2ActionPerformed

    private void btnSuspendT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendT3ActionPerformed
        counter3.suspend();
        btnSuspendT3.setEnabled(false);
        btnResumeT3.setEnabled(true);
        btnWaitT3.setEnabled(false);
        
    }//GEN-LAST:event_btnSuspendT3ActionPerformed

    private void btnSuspendT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendT4ActionPerformed
        suspend(btnResumeT4, btnSuspendT4, btnWaitT4, btnStopT4, counter4);
    }//GEN-LAST:event_btnSuspendT4ActionPerformed

    private void btnResumeT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeT1ActionPerformed
        resume(btnResumeT1, btnSuspendT1, btnWaitT1, btnStopT1, counter1);
    }//GEN-LAST:event_btnResumeT1ActionPerformed

    private void btnResumeT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeT2ActionPerformed
        resume(btnResumeT2, btnSuspendT2, btnWaitT2, btnStopT2, counter2);
    }//GEN-LAST:event_btnResumeT2ActionPerformed

    private void btnResumeT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeT3ActionPerformed
        resume(btnResumeT3, btnSuspendT3, btnWaitT3, btnStopT3, counter3);
    }//GEN-LAST:event_btnResumeT3ActionPerformed

    private void btnResumeT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeT4ActionPerformed
        resume(btnResumeT4, btnSuspendT4, btnWaitT4, btnStopT4, counter4);
    }//GEN-LAST:event_btnResumeT4ActionPerformed
    private void suspend(JButton btnResume, JButton btnSuspend, JButton btnWait, JButton btnStop, Counter counter){
        btnResume.setEnabled(true);
        btnSuspend.setEnabled(false);
        btnWait.setEnabled(false);
        btnStop.setEnabled(true);
        counter.suspend();
    }
    
    private void resume(JButton btnResume, JButton btnSuspend, JButton btnWait, JButton btnStop, Counter counter){
        btnResume.setEnabled(false);
        btnSuspend.setEnabled(true);
        btnWait.setEnabled(true);
        btnStop.setEnabled(true);
        counter.resume();
    }
    
    private void loadComboPriority(JComboBox combo) {
        for (Integer i = 1; i <= 10; i++) {
            combo.addItem(i);
        }
        combo.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotifyT1;
    private javax.swing.JButton btnNotifyT2;
    private javax.swing.JButton btnNotifyT3;
    private javax.swing.JButton btnNotifyT4;
    private javax.swing.JButton btnResumeT1;
    private javax.swing.JButton btnResumeT2;
    private javax.swing.JButton btnResumeT3;
    private javax.swing.JButton btnResumeT4;
    private javax.swing.JButton btnStartT1;
    private javax.swing.JButton btnStartT2;
    private javax.swing.JButton btnStartT3;
    private javax.swing.JButton btnStartT4;
    private javax.swing.JButton btnStopT1;
    private javax.swing.JButton btnStopT2;
    private javax.swing.JButton btnStopT3;
    private javax.swing.JButton btnStopT4;
    private javax.swing.JButton btnSuspendT1;
    private javax.swing.JButton btnSuspendT2;
    private javax.swing.JButton btnSuspendT3;
    private javax.swing.JButton btnSuspendT4;
    private javax.swing.JButton btnWaitT1;
    private javax.swing.JButton btnWaitT2;
    private javax.swing.JButton btnWaitT3;
    private javax.swing.JButton btnWaitT4;
    private javax.swing.JCheckBox chkPauseT1;
    private javax.swing.JCheckBox chkPauseT2;
    private javax.swing.JCheckBox chkPauseT3;
    private javax.swing.JCheckBox chkPauseT4;
    private javax.swing.JComboBox<String> cmbT1;
    private javax.swing.JComboBox<String> cmbT2;
    private javax.swing.JComboBox<String> cmbT3;
    private javax.swing.JComboBox<String> cmbT4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblPriority1;
    private javax.swing.JLabel lblPriority2;
    private javax.swing.JLabel lblPriority3;
    private javax.swing.JLabel lblPriority4;
    private javax.swing.JLabel lblT1;
    private javax.swing.JLabel lblT2;
    private javax.swing.JLabel lblT3;
    private javax.swing.JLabel lblT4;
    private javax.swing.JTextField txtPauseT1;
    private javax.swing.JTextField txtPauseT2;
    private javax.swing.JTextField txtPauseT3;
    private javax.swing.JTextField txtPauseT4;
    private javax.swing.JTextField txtT1;
    private javax.swing.JTextField txtT2;
    private javax.swing.JTextField txtT3;
    private javax.swing.JTextField txtT4;
    // End of variables declaration//GEN-END:variables
}
