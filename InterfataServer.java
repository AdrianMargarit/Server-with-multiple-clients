package ServerClienti;

public class InterfataServer extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	public InterfataServer() {
        setVisible(true);
        initComponents();
    }
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Conversations = new javax.swing.JTextArea();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connected to Server!");
        setName("Server");
        setResizable(false);
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel1.setText("Conversations");
        jScrollPane1.setAutoscrolls(true);
        Conversations.setColumns(20);
        Conversations.setEditable(false);
        Conversations.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Conversations.setLineWrap(true);
        Conversations.setRows(5);
        Conversations.setToolTipText("Conversations:");
        Conversations.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Conversations);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pack();
    }
    public static javax.swing.JTextArea Conversations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
}