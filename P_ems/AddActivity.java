import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddActivity extends JFrame
{ 
  Container c;
  JLabel labId ,labName;
  JTextField txtId,txtName;
  JButton btnAdd,btnBack;

   AddActivity()
{
  c=getContentPane();
  c.setLayout(new FlowLayout());
   
   labId=new JLabel("enter Id");
   labName=new JLabel("enter name");
   txtId=new JTextField(20);
   txtName=new JTextField(20);
   btnAdd=new JButton("Add emp");
   btnBack=new JButton("Back");
  
   Font f=new Font("Arial",Font.BOLD,25);
   labId.setFont(f);
   txtId.setFont(f);
   labName.setFont(f);
   txtName.setFont(f);
   btnAdd.setFont(f);
   btnBack.setFont(f);
   
    c.add(labId);
    c.add(txtId);
    c.add(labName);
    c.add(txtName);
   c.add(btnAdd);
   c.add(btnBack);

  ActionListener a2=(ae) -> {
   MainActivity a1=new MainActivity();
   dispose();
};
  btnBack.addActionListener(a2);  

 ActionListener a1=(ae) -> {
 try{
   DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
   String url= "jdbc:mysql://localhost:3306/emp28dec22";
   Connection con=DriverManager.getConnection(url,"root","abc456");
   
   String sql="insert into emp values(?,?)";
   PreparedStatement pst=con.prepareStatement(sql);

   int id=Integer.parseInt(txtId.getText());
   String name=txtName.getText();

   pst.setInt(1,id);
   pst.setString(2,name);
   pst.executeUpdate();
 JOptionPane.showMessageDialog(c," succesfullu added emp ");
  con.close();
  txtName.setText("");
  txtId.setText("");
  txtId.requestFocus();
}
catch(SQLException e)
{ JOptionPane.showMessageDialog(c,"issue "+e); }   
   

};
  btnAdd.addActionListener(a1);
  

   setTitle("add page");
   setSize(500,400);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);

}


}