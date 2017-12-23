/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer_game;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author iosdev474
 */
public class Server extends javax.swing.JFrame {

    static ServerSocket serverSocket;
    static Socket socket;
    static Users[] user = new Users[10];
    static int port;
    String onlineplayers="Admin",leaderboard="Admin:30";
    /**
     * Creates new form Server
     */
    public Server(int port) {
        initComponents();
        this.port=port;
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                socket = serverSocket.accept();
                for(int i=0;i<10;i++){
                    if(user[i]==null){
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        user[i]=new Users(out,in,user,i,this);
                        Thread thread = new Thread(user[i]);
                        thread.start();
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addtoleaderboard(String score){
        leaderboard=leaderboard+","+score;
    }
    
    public void addtoonlineplayers(String name){
        onlineplayers=onlineplayers+","+name;
    }
    
    public void removeonlineplayer(String name){
        onlineplayers = onlineplayers.replaceAll(","+name, "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server(port).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
class Users implements Runnable{
	DataOutputStream out;
	DataInputStream in;
	Users[] user = new Users[10];
        String onlineplayers="";
        int pid;
        Server server;
	public Users(DataOutputStream out, DataInputStream in,Users[] user,int pid,Server server){
		this.out=out;
		this.in=in;
		this.pid=pid;
                this.user=user;
                this.server=server;
	}
	public void run(){
            while(true){
                try{
                    String message = in.readUTF();
                    if(message.equals("0")){        //add name to online users
                        String name;
                        name=in.readUTF();
                        server.addtoonlineplayers(name);
                    }
                    else if(message.equals("1")){               //return online players
                        out.writeUTF(server.onlineplayers);
                    }
                    else if(message.equals("2")){           //add to leaderboard
                        String result = in.readUTF();
                        server.addtoleaderboard(result);
                    }
                    else if(message.equals("3")){               //return leaderboard
                        out.writeUTF(server.leaderboard);
                    }
                    else if(message.equals("4")){
                        String name = in.readUTF();
                        server.removeonlineplayer(name);
                    }
                }catch(IOException e){
                    user[pid]=null;
                }
            }
	}
}