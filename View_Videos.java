
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class View_Videos extends javax.swing.JFrame {

    /**
     * Creates new form View_Videos
     */
    public View_Videos(String catname) {
        initComponents();
        
        jLabel1.setText("Category: "+catname);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        jLabel1.setText("Category "+catname);
        
        loadVideos(catname);
    }
    
    void loadVideos(String catname)
    {
        String ans = MyClient.getVideoFromServer(catname);
        
        JOptionPane.showMessageDialog(this, ans);
        
        generateDynamicButtons(ans);
    }
    
    void generateDynamicButtons(String ans)
    {
        StringTokenizer st = new StringTokenizer(ans,";");
        
        int n = st.countTokens();
        
        for(int i=1; i<=n; i++)
        {
            String singlevideo = st.nextToken();
            
            StringTokenizer st2 = new StringTokenizer(singlevideo,",");
            
            int vid = Integer.parseInt(st2.nextToken());
            String videoname = st2.nextToken();
            String photo = st2.nextToken();
            
            JButton bt = new JButton();
            
            bt.setText(videoname);

            try
            {
                BufferedImage bi = ImageIO.read(new File(photo));
                
                bi = scale(bi, 150,150);
                
                bt.setIcon(new ImageIcon(bi));
            
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            bt.setVerticalTextPosition(SwingConstants.BOTTOM);
            bt.setHorizontalTextPosition(SwingConstants.CENTER);
            
            bt.setBounds(100+(210*i),100,200,200);
            
            jPanel1.add(bt);
            
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    Single_Video_Detail obj = new Single_Video_Detail(vid);
                    obj.setVisible(true);
                }
            });
        }
        jPanel1.setVisible(false);
        jPanel1.setVisible(true);
    }
    public static BufferedImage scale(BufferedImage src, int w, int h)
    {
    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
    for (x = 0; x < w; x++) {
        int newX = x * ww / w;
        for (y = 0; y < h; y++) {
            int col = src.getRGB(newX, ys[y]);
            img.setRGB(x, y, col);
    }
    }
    return img;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 10, 400, 54);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 660, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(View_Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Videos("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
