
import java.io.File;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Add_Video extends javax.swing.JFrame {
    
    Vector<String> catlist;
    
    File selectedposter;
    File selectedvideo;

    public Add_Video() {

        initComponents();

        setSize(650,550);
        setVisible(true);
                
        loadCategories();
        //Show category names of vector in combo box
        jComboBox1.setModel(new DefaultComboBoxModel<>(catlist));
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    void loadCategories()
    {
        catlist = new Vector<>();
        
        String ans = MyClient.getCategoriesFromServer();
        
        StringTokenizer st = new StringTokenizer(ans,";");
        
        int n = st.countTokens();
        
        for(int i=1;i<=n;i++)
        {
            String singlecat = st.nextToken();
            
            StringTokenizer st2 = new StringTokenizer(singlecat,",");
            
            
            String catname = st2.nextToken();
            //String photo = st2.nextToken();
            
            catlist.add(catname);
            System.out.println(catname);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        tf_title = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_trailer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tf_running = new javax.swing.JTextField();
        btadd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tf_title);
        tf_title.setBounds(190, 70, 390, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Title");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 70, 100, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText(" Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 120, 150, 30);
        getContentPane().add(tf_desc);
        tf_desc.setBounds(190, 120, 390, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Movie Poster");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 180, 110, 20);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 170, 100, 30);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(430, 180, 100, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Video(MP4)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 220, 90, 30);

        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 220, 100, 30);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(430, 220, 50, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Trailer ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 270, 120, 30);
        getContentPane().add(tf_trailer);
        tf_trailer.setBounds(190, 270, 380, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Category");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 330, 100, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(190, 330, 72, 22);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Running Time");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 380, 120, 20);
        getContentPane().add(tf_running);
        tf_running.setBounds(190, 380, 120, 30);

        btadd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btadd.setForeground(new java.awt.Color(153, 153, 153));
        btadd.setText("Add");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(260, 440, 110, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Add New Videos");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(220, 10, 290, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myuploads/background-images/addvideo-background.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 640, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans==jFileChooser1.APPROVE_OPTION)
        {
            selectedposter = jFileChooser1.getSelectedFile();
            jLabel4.setText(selectedposter.getName());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              
        int ans = jFileChooser2.showOpenDialog(this);
        
        if(ans==jFileChooser2.APPROVE_OPTION)
        {
            selectedvideo = jFileChooser2.getSelectedFile();
            jLabel6.setText(selectedvideo.getName());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        
        String videoname = tf_title.getText().trim();
        String description = tf_desc.getText().trim();
        String trailerlink = tf_trailer.getText().trim();
        String catname = jComboBox1.getSelectedItem().toString();
        int runningtime = Integer.parseInt(tf_running.getText().trim());
        
                
        String ans = MyClient.addVideo(videoname, description, selectedposter, selectedvideo, trailerlink, catname, runningtime);
        
        JOptionPane.showMessageDialog(this, ans); 
        
    }//GEN-LAST:event_btaddActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Video.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Video().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tf_desc;
    private javax.swing.JTextField tf_running;
    private javax.swing.JTextField tf_title;
    private javax.swing.JTextField tf_trailer;
    // End of variables declaration//GEN-END:variables
}
