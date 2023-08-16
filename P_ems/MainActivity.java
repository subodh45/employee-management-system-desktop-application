import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainActivity extends JFrame
{ 
  Container c;
  JButton btnAdd,btnView;

   MainActivity()
{
  c=getContentPane();
  c.setLayout(new FlowLayout());

   btnAdd=new JButton("Add emp");
   btnView=new JButton("View emp");
  
   Font f=new Font("Arial",Font.BOLD,25);
   btnAdd.setFont(f);
   btnView.setFont(f);

   c.add(btnAdd);
   c.add(btnView);

   ActionListener a1=(ae) -> {
   AddActivity a=new AddActivity();
   dispose();
};
  btnAdd.addActionListener(a1);  
   
    ActionListener a2=(ae) -> {
   ViewActivity a=new ViewActivity();
   dispose();
};
  btnView.addActionListener(a2);  

   setTitle("MAin page");
   setSize(500,400);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);

}


}