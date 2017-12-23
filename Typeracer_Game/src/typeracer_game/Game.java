/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer_game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Anuj_descifrado
 */
public class Game extends javax.swing.JFrame 
{
    float current_speed;
    String users_word;
    int flag = 0;
    int start_time;
    int end_time;
    String para = null;
    int space = 0, error_count = 0;
    int count = 0, totalWords;
    StringTokenizer words;
    String correct_word = "";
    String name="";

    /**
     * Creates new form NewJFrame
     */
    public Game() 
    {
        initComponents();
        showPara();
        paraTextPane.setEditable(false);
        currentInputTF.requestFocus(true);
        words = new StringTokenizer(para);
        totalWords = words.countTokens();
        start_time = (int) System.currentTimeMillis();
    }

    private void showPara() //generating Randon Pharagraph
    {
        String thisLine = null;
        int a;
        a = (int)(Math.random() * 10);//A random number between 0 and 9
        System.out.println("a is " + a);
        try 
        {
            // open input stream Para.txt for fetching require pragraphs.
            // Here paragraphs are stored as single lines.
            BufferedReader buffRdr = new BufferedReader(new FileReader("Para.txt"));
            while ((thisLine = buffRdr.readLine()) != null) 
            {
                char ch = thisLine.charAt(0);
                thisLine = thisLine.substring(1);//After removing First letteri.e. the index number
                int ch1 = (ch - '0');
                if (ch1 == a) //get the para corresponding to a
                {
                    para = "";
                    para = para + thisLine;
                    System.out.println(para);
                    paraTextPane.setText(para);
                    return;
                }
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
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

        jProgressBar1 = new javax.swing.JProgressBar();
        finishButton = new javax.swing.JButton();
        currentInputTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        paraDisplayer = new javax.swing.JScrollPane();
        paraTextPane = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        display_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        best_speed_tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        finishButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        currentInputTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                currentInputTFKeyTyped(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 51, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("# Start Writting The Each Word Of Following Pharagraph As\n  It Is  Along With Proper Punctuations And Spellings\n# Try To Minimize Typing Errors As Much As Possible\n# Best Of Luck");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jInternalFrame1.setTitle("Pharagraph");
        jInternalFrame1.setVisible(true);

        paraTextPane.setEditable(false);
        paraDisplayer.setViewportView(paraTextPane);
        paraTextPane.getAccessibleContext().setAccessibleParent(jTextArea1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paraDisplayer)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paraDisplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/typeracer_game/com.bonfiremedia.typeracer.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 310);

        display_name.setEditable(false);
        display_name.setBackground(new java.awt.Color(0, 0, 51));
        display_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        display_name.setForeground(new java.awt.Color(0, 255, 0));
        display_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("BEST SPEED");

        best_speed_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                best_speed_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(finishButton)
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame1)
                    .addComponent(currentInputTF))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(display_name))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(best_speed_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(display_name)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(best_speed_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(currentInputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(finishButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        JOptionPane.showMessageDialog(this, "You exit without completing game!!!");
        this.setVisible(false);
        GameStarter obj = new GameStarter();
        obj.setVisible(true);        
    }//GEN-LAST:event_finishButtonActionPerformed

    private void currentInputTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentInputTFKeyTyped

        char ch = evt.getKeyChar();
        System.out.print(ch);
        if (ch == KeyEvent.VK_SPACE) //Matches work whenever you press space
        {
            space++;
            float itime = (int) System.currentTimeMillis();
            current_speed = space / ((float) (itime - start_time) / 1000f);
            System.out.printf("Curent_speed is: %.2f", current_speed);
            users_word = currentInputTF.getText();
            users_word = users_word.trim();//removed extra spaces
            if (flag == 0) 
            {
                correct_word = words.nextToken();
                flag = 1;
            }
            if (users_word.equals(correct_word)) 
            {
                currentInputTF.setBackground(Color.WHITE);
                System.out.println("word matched");
                count++;
                if (words.hasMoreTokens()) //if more words are present
                {
                    correct_word = words.nextToken();
                    
                }
                else//no more words ahead
                {                                         //The game is over.
                    end_time = (int) System.currentTimeMillis();
                    System.out.println("you are done");
                    float time = (end_time - start_time) / 1000f;
                    System.out.println("time is" + time + " " + space + " " + error_count);
                    float speed = (float) space / time;//no. of spaces(words) per unit time
                    Math.ceil(speed);
                    System.out.println("speed in words per second: " + speed);
                    float accuracy = (float) ((float) (space - error_count) / (float) space) * 100;//in percentage
                    accuracy = (float) Math.ceil(accuracy);
                    System.out.println("accuracy is" + accuracy);
                    JOptionPane.showMessageDialog(this, "Your accuracy is: " + accuracy + "% " + "\nYour typing speed is: " + speed);
                    this.setVisible(false);
                    try
                    {
                        Class.forName("java.sql.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/typerace","root","modi");
                        Statement stmt=con.createStatement();
                        String q="insert into user values('"+(name)+"','"+(accuracy)+"','"+(error_count)+"','"+(speed)+"');";
                        stmt.executeUpdate(q);
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,e.getMessage());
                    }
                    GameStarter obj = new GameStarter();
                    obj.setVisible(true);
                    
                }
            }
            else
            {
                error_count++;
                currentInputTF.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Typing error");
            }
            users_word = "";
            currentInputTF.setText("");
        }
    }//GEN-LAST:event_currentInputTFKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       name=JOptionPane.showInputDialog(this, "ENTER USER NAME");
       display_name.setText("All The Best "+name);
       try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/typerace","root","modi");
            Statement stmt=con.createStatement();
            String q="Select Speed from user order by speed";
            ResultSet rs=stmt.executeQuery(q);
            rs.next();
            best_speed_tf.setText(rs.getString("Speed"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void best_speed_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_best_speed_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_best_speed_tfActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField best_speed_tf;
    public javax.swing.JTextField currentInputTF;
    private javax.swing.JTextField display_name;
    private javax.swing.JButton finishButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane paraDisplayer;
    private javax.swing.JTextPane paraTextPane;
    // End of variables declaration//GEN-END:variables
}
