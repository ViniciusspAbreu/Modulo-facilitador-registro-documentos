/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaprotocolos;

import com.mysql.jdbc.Connection;
import controle.ConnectionConsulta;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vinicius
 */
public class telaPrincipal extends javax.swing.JFrame {
    String gender;
    String filename = null;
    byte[] person_image=null;
    ConnectionConsulta conecta = new ConnectionConsulta();
    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
        show_user();
        conecta.conectaBanco();
    }
    java.sql.Connection conexion = null;
    public ArrayList<User> userList(){
        ArrayList<User> userList = new ArrayList<>();
         try{
        Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.16.41:3306/projetojava";
            String usuarioDB = "todos";
            String passwordDB = "1234";
            conexion = DriverManager.getConnection(servidor,usuarioDB, passwordDB);
            String query1="SELECT * FROM TABELAIMAGENS";
            Statement st= conexion.createStatement();
            ResultSet rs= st.executeQuery(query1);
            User user;
            while(rs.next()){
                user=new User(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("gender"),rs.getString("knowledege"),rs.getString("subject"),rs.getBytes("images"));
                userList.add(user);
            }
            
         }
         catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
         return userList;
    }
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getid();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getaddress();
            row[3]=list.get(i).getgender();
            row[4]=list.get(i).getknowledege();
            row[5]=list.get(i).getsubject();
            row[6]=list.get(i).getImage();
            model.addRow(row);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        coreJava = new javax.swing.JCheckBox();
        PHP = new javax.swing.JCheckBox();
        subject = new javax.swing.JComboBox<>();
        jButtonsave = new javax.swing.JButton();
        jButtonreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display = new javax.swing.JTable();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabelImagem = new javax.swing.JLabel();
        jButtonSeleionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        jLabel3.setText("Gender");

        jLabel4.setText("Knowledge");

        jLabel5.setText("Subject");

        buttonGroup1.add(male);
        male.setText("Male");

        buttonGroup1.add(female);
        female.setText("Female");

        coreJava.setText(" Java");

        PHP.setText(" PHP");

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer cienc", "artes" }));

        jButtonsave.setText("Save");
        jButtonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsaveActionPerformed(evt);
            }
        });

        jButtonreset.setText("Reset");
        jButtonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonresetActionPerformed(evt);
            }
        });

        jTable_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "address", "gender", "knowledege", "subject", "images"
            }
        ));
        jTable_Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DisplayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabelImagem.setToolTipText("");
        jLabelImagem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImagemMouseClicked(evt);
            }
        });

        jButtonSeleionar.setText("Selecionar");
        jButtonSeleionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleionarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addComponent(jButtonsave))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(coreJava)
                                .addGap(18, 18, 18)
                                .addComponent(PHP))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(update)
                                        .addGap(12, 12, 12)
                                        .addComponent(delete)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonreset))
                                    .addComponent(jButtonSeleionar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(142, 142, 142)))
                                .addGap(35, 35, 35)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(male)
                                .addGap(22, 22, 22)
                                .addComponent(female))
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addComponent(jLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(male)
                                    .addComponent(female))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5)
                                .addGap(21, 21, 21)
                                .addComponent(jButtonsave))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coreJava)
                                    .addComponent(PHP))
                                .addGap(34, 34, 34)
                                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(update)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(delete)
                                            .addComponent(jButtonreset))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSeleionar)))))
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsaveActionPerformed
        // TODO add your handling code here:
        java.sql.Connection conexion = null;
          try{
          //  Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.16.41:3306/projetojava";
            String usuarioDB = "todos";
            String passwordDB = "1234";
            conexion = DriverManager.getConnection(servidor,usuarioDB, passwordDB);
            String query = "insert into tabelaimagens(name,address,gender,knowledege,subject,images)values(?,?,?,?,?,?)";
            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1, name.getText());
            pst.setString(2, address.getText());
            if(male.isSelected()){
                gender="Male";
            }
            if(female.isSelected()){
                gender="Female";
            }
            pst.setString(3, gender);
            String knowledge="";
            if(coreJava.isSelected()){
                knowledge+=coreJava.getText()+" ";
            }
            if(PHP.isSelected()){
                knowledge+=PHP.getText()+" ";
            }
            pst.setString(4, knowledge);
            String course;
            course=subject.getSelectedItem().toString();
            pst.setString(5, course);
            pst.setBytes(6,person_image);
            pst.executeUpdate();
                   
            DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_jButtonsaveActionPerformed

    private void jButtonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonresetActionPerformed
        // TODO add your handling code here:
        name.setText("");
        address.setText("");
        buttonGroup1.clearSelection();
        coreJava.setSelected(false);
        PHP.setSelected(false);
        subject.setSelectedIndex(0);
        jLabelImagem.setIcon(null);
    }//GEN-LAST:event_jButtonresetActionPerformed

    private void jTable_DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DisplayMouseClicked
        // TODO add your handling code here:
        int i = jTable_Display.getSelectedRow();
        TableModel model =jTable_Display.getModel();
        name.setText(model.getValueAt(i,1).toString());
        address.setText(model.getValueAt(i,2).toString());
        String sex = model.getValueAt(i,3).toString();
        if(sex.equals("Male")){
            male.setSelected(true);
        }
        else{
            female.setSelected(true);
        }
        String knowledege = model.getValueAt(i,4).toString();
        switch(knowledege){
            case " Java ":
            coreJava.setSelected(true);
            PHP.setSelected(false);
            break;
            case " PHP ":
            PHP.setSelected(true);
            coreJava.setSelected(false);
            break;
            default:
            coreJava.setSelected(true);
            PHP.setSelected(true);
            break;
        }
        String subject1 = model.getValueAt(i,5).toString();
        switch(subject1){
            case "Computer cienc":
                subject.setSelectedIndex(0);
                break;
                case "artes":
                subject.setSelectedIndex(1);
                break;
                       }  
        
    jLabelImagem.setIcon(null);
    byte[] img = (userList().get(i).getImage());
    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(jLabelImagem.getWidth(),jLabelImagem.getHeight(),Image.SCALE_SMOOTH));
    jLabelImagem.setIcon(imageIcon);

   



    }//GEN-LAST:event_jTable_DisplayMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
         java.sql.Connection conexion = null;
          try{
          //  Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.16.41:3306/projetojava";
            String usuarioDB = "todos";
            String passwordDB = "1234";
            conexion = DriverManager.getConnection(servidor,usuarioDB, passwordDB);
            int row = jTable_Display.getSelectedRow();
            String value = (jTable_Display.getModel().getValueAt(row, 0).toString());
            String query ="UPDATE tabelaimagens SET name=?, address=?, gender=?, knowledege=?, subject=?, images=? where id="+value;
            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setString(1, name.getText());
            pst.setString(2, address.getText());
            if(male.isSelected()){
                gender="Male";
            }
            if(female.isSelected()){
                gender="Female";
            }
            pst.setString(3, gender);
            String Knowledge="";
            if(coreJava.isSelected()){
                Knowledge+=coreJava.getText()+" ";
            }
            if(PHP.isSelected()){
                Knowledge+=PHP.getText()+" ";
            }
            pst.setString(4, Knowledge);
            String course;
            course=subject.getSelectedItem().toString();
            pst.setString(5, course);
            pst.setBytes(6, person_image);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
          }
        
            catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
          
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        java.sql.Connection conexion = null;
          try{
          //  Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.16.41:3306/projetojava";
            String usuarioDB = "todos";
            String passwordDB = "1234";
            conexion = DriverManager.getConnection(servidor,usuarioDB, passwordDB);
            int row = jTable_Display.getSelectedRow();
            String value = (jTable_Display.getModel().getValueAt(row, 0).toString());
            String query="DELETE FROM tabelaimagens where id="+value;
            PreparedStatement pst = conexion.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
             }
        
            catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButtonSeleionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleionarActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jLabelImagem.getWidth(),jLabelImagem.getHeight(),Image.SCALE_SMOOTH));
        jLabelImagem.setIcon(imageIcon);
        try{
            File image = new File(filename);
            FileInputStream  fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf= new byte[1024];
            for(int readNum;(readNum=fis.read(buf))!=-1;){
                bos.write(buf,0,readNum);
        }
            person_image=bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_jButtonSeleionarActionPerformed

    private void jLabelImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagemMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jLabelImagemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        try{
//            conecta.conectaBanco();
//            conecta.executaSQL("select * from usuarios where destinatario = 'TDP' and recebimento = 'Não recebido' order by id");
//            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
//            JasperPrint jpPrint = JasperFillManager.fillReport("\\\\hp2017\\E\\Citrix\\Matriz ireport\\ireport\\RelatorioCadastros.jasper", new HashMap(), relatResul);
//            JasperViewer jv = new JasperViewer(jpPrint,false);
//            jv.setVisible(true);
//            jv.toFront();
//            conecta.desconecta();
//        }catch (JRException ex) {
//            JOptionPane.showMessageDialog(rootPane,"Erro ao chamar o relatório!\nErro:"+ ex);
//        }

 try{       
            conecta.conectaBanco();
            conecta.executaSQL("select * from tabelaimagens order by id");
      
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            JasperPrint jpPrint = JasperFillManager.fillReport("\\\\hp2017\\E\\Citrix\\RelatorioCadastros.jasper", new HashMap(), relatResul);
            JasperViewer jv = new JasperViewer(jpPrint,false);
          
            
            jv.show();
           // jv.setVisible(true);
           // jv.toFront();
           
          
           //abrindo maximizado
           //viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
        }catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao chamar o relatório!\nErro:"+ ex);
        }
 
 
 
 
 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox PHP;
    private javax.swing.JTextField address;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox coreJava;
    private javax.swing.JButton delete;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSeleionar;
    private javax.swing.JButton jButtonreset;
    private javax.swing.JButton jButtonsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}