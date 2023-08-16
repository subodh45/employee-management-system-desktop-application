import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class ViewActivity extends JFrame
{ 
  Container c;
 
  TextArea txtArea;
  JButton btnBack;

   ViewActivity()
{
  c=getContentPane();
  c.setLayout(new FlowLayout());
   
  
   txtArea=new TextArea(8,25);
   btnBack=new JButton("Back");
  
   Font f=new Font("Arial",Font.BOLD,25);
   
   txtArea.setFont(f);
   btnBack.setFont(f);
   
    
    c.add(txtArea);
   c.add(btnBack);
  


  ActionListener a3=(ae) -> {
   MainActivity a=new MainActivity();
   dispose();
};
  btnBack.addActionListener(a3);  

    try{
   DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
   String url= "jdbc:mysql://localhost:3306/emp28dec22";
   Connection con=DriverManager.getConnection(url,"root","abc456");
   String sql="select * from emp";
   PreparedStatement pst=con.prepareStatement(sql);
   ResultSet rs=pst.executeQuery();

   StringBuffer info= new StringBuffer();
   while(rs.next())
    info.append("id= "+rs.getInt(1)+ "name="+rs.getString(2)+ "\n");
 txtArea.setText(info.toString());
 
  con.close();
  
}
catch(SQLException e)
{ JOptionPane.showMessageDialog(c,"issue "+e); }   
   


   setTitle("View page");
   setSize(500,400);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);

}


}