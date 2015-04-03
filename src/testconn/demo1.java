package testconn;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import static testconn.Testconn.DB_URL;

public class demo1 extends JFrame implements ActionListener{
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:8080/database_schema";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "imtoocool007";
    JButton loginbt,regbt,regubt;
    JPanel chek;
    Component txt2[] = new Component[7];
    JTextField txt1[] = new JTextField[2];
    CardLayout cardLayout = new CardLayout();
    JPanel cards = new JPanel();
  demo1() {
      
      cards.setLayout(cardLayout);
      cards.setBackground(new Color(0,0,0,0));
    JPanel panel = new ContentPanel();
    add(panel);
    setSize(500, 300);
    JLabel l1 = new JLabel("<html><font face = 'Andalus' size = 10 color = 'white'>Indian  </font><font face = 'MV Boli'  size = 15 color = 'orange'>Railways</font></html>");
    l1.setForeground(Color.blue);
    JPanel title = new JPanel();
    title.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
    title.setBackground(new Color(0,0,0,0));
    title.add(l1);
    panel.add(title,BorderLayout.PAGE_START);
    
    TitledBorder old = BorderFactory.createTitledBorder(" LOGIN HERE ");
    old.setTitleColor(Color.orange);
    JPanel member = new JPanel();
    chek = new JPanel();
    JPanel empt = new JPanel();
    empt.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
    empt.setBackground(new Color(0,0,0,0));
    JPanel empt1 = new JPanel();
    empt1.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
    empt1.setBackground(new Color(0,0,0,0));
    JPanel empty = new JPanel();
    empty.setBorder(BorderFactory.createEmptyBorder(155, 155, 155, 155));
    empty.setBackground(new Color(0,0,0,0));
    member.setLayout(new BoxLayout(member, BoxLayout.Y_AXIS));
    chek.setLayout(new BoxLayout(chek, BoxLayout.Y_AXIS));
    member.setBorder(old);
    login t1 = new login();
    JLabel lab1[] = new JLabel[2];
    lab1[0] = new JLabel("UserID :");
    lab1[0].setForeground(Color.orange);
    lab1[1] = new JLabel("Password :");
    lab1[1].setForeground(Color.orange);
    
    txt1[0] = new JTextField(10);
    txt1[1] = new JPasswordField(10);
    loginbt = new JButton("Login");
    loginbt.setBackground(Color.orange);
    loginbt.addActionListener(this);
    JPanel left;
    left = t1.createForm(lab1, txt1, 2, 2, 50, 30);
    left.setBackground(new Color(0,0,0,0));
    member.add(left);
    member.add(loginbt);
    member.setBackground(new Color(0,0,0,65));
    chek.add(member);
    chek.setBackground(new Color(0,0,0,0));
    chek.add(empt);
    
    TitledBorder newu = BorderFactory.createTitledBorder(" NEW USER? REGISTER ");
    newu.setTitleColor(Color.orange);
    JPanel newuser = new JPanel();
    newuser.setBorder(newu);
    regbt = new JButton("Register");
    regbt.setBackground(Color.orange);
    regbt.addActionListener(this);
    newuser.add(regbt);
    newuser.setBackground(new Color(0,0,0,65));
    chek.add(newuser);
    chek.add(empty);

    JPanel userreg = new JPanel();
    userreg.setBorder(newu);
    userreg.setLayout(new BoxLayout(userreg, BoxLayout.Y_AXIS));
    
    JLabel lab2[] = new JLabel[7];
    lab2[0] = new JLabel("UserID :");
    lab2[0].setForeground(Color.orange);
    lab2[1] = new JLabel("Password :");
    lab2[1].setForeground(Color.orange);
    lab2[2] = new JLabel("Password :");
    lab2[2].setForeground(Color.orange);
    lab2[3] = new JLabel("Name :");
    lab2[3].setForeground(Color.orange);
    lab2[4] = new JLabel("Email :");
    lab2[4].setForeground(Color.orange);
    lab2[5] = new JLabel("Phone :");
    lab2[5].setForeground(Color.orange);
    lab2[6] = new JLabel("Address :");
    lab2[6].setForeground(Color.orange);
    
    txt2[0] = new JTextField(15);
    txt2[1] = new JPasswordField(15);
    txt2[2] = new JPasswordField(15);
    txt2[3] = new JTextField(15);
    txt2[4] = new JTextField(15);
    txt2[5] = new JTextField(15);
    txt2[6] = new JTextArea(5,15);
    regubt = new JButton("Register");
    regubt.setBackground(Color.orange);
    regubt.addActionListener(this);
    JPanel reg;
    reg = t1.createForm(lab2, txt2, 7, 7, 50, 30);
    reg.setBackground(new Color(0,0,0,0));
    userreg.add(reg);
    userreg.add(regubt);
    userreg.add(empt1);
    userreg.setBackground(Color.black);
    cards.add(chek,Integer.toString(2));
    cards.add(userreg,Integer.toString(1));
    
    
    panel.add(cards,BorderLayout.LINE_START);
    
    
    
  }
public static boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
public static final String md5(final String toEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte[] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            return sb.toString().toLowerCase();
        } catch (Exception exc) {
            return ""; // Impossibru!
        }
    }
public static void queryexecute( String sql){
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      int rs = stmt.executeUpdate(sql);

      /*
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        
         String first = rs.getString("userid");
         String last = rs.getString("Passwd");

         //Display values
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }*/
      //STEP 6: Clean-up environment
     // rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   
}
  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource()==regbt)
      {
          cardLayout.show(cards,Integer.toString(1));
          //chek.setVisible(false);
          //getContentPane().remove(cards);
      }
      if(e.getSource()==loginbt )
      {
          String id = txt1[0].getText();
          String pass = String.copyValueOf(((JPasswordField)txt1[1]).getPassword());
          String psw = md5(pass);
          String sql = "SELECT PASSWD FROM users WHERE USERID = '"+id+"';";
             Connection conn = null;
            Statement stmt = null;
            try{
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               System.out.println("Connecting to database...");
               conn = DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               System.out.println("Creating statement...");
               stmt = conn.createStatement();
               
               ResultSet rs = stmt.executeQuery(sql);

               if(!rs.next())
               {
                      JOptionPane.showMessageDialog(null,"Invalid UserID/Password");
                      return;
               }  
               //STEP 5: Extract data from result set
               while(rs.next()){
                  //Retrieve by column name

                 // String first = rs.getString("userid");
                  String last = rs.getString("Passwd");

                  //Display values
                //  System.out.print(", First: " + first);
                 // System.out.println(", Last: " + last);
                  if(!psw.equals(last))
                  {
                      JOptionPane.showMessageDialog(null,"Invalid UserID/Password");
                      return;
                  }
               }
               JOptionPane.showMessageDialog(null,"yr UserID/Password");
               //you can login
               //STEP 6: Clean-up environment
              rs.close();
               stmt.close();
               conn.close();
            }catch(SQLException se){
               //Handle errors for JDBC
               se.printStackTrace();
            }catch(Exception ea){
               //Handle errors for Class.forName
               ea.printStackTrace();
            }finally{
               //finally block used to close resources
               try{
                  if(stmt!=null)
                     stmt.close();
               }catch(SQLException se2){
               }// nothing we can do
               try{
                  if(conn!=null)
                     conn.close();
               }catch(SQLException se){
                  se.printStackTrace();
               }//end finally try
            }//end try
      }
      if(e.getSource()==regubt)
      {
          int i;
          for(i=0;i<7;i++)
          {
              if(i==6)
              {
                  JTextArea sp = (JTextArea)txt2[i];
                  if("".equals(sp.getText()))
                    {
                        JOptionPane.showMessageDialog(null,"All fields are necessary");
                        break;
                    }
              }
              
              else
              {
                  JTextField sp = (JTextField)txt2[i];
                  if("".equals(sp.getText()))
                    {
                        JOptionPane.showMessageDialog(null,"All fields are necessary");
                        break;
                    }
                  if(i==5)
                    {
                        if(!isNumeric(sp.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"Please enter a valid phone number");
                            sp.setText(null);
                            break;
                        }
                    }
                  if(i==4)
                  {
                      if(!(sp.getText()).contains("@") || !(sp.getText()).contains("."))
                        {
                            JOptionPane.showMessageDialog(null,"Please enter a valid email address");
                            sp.setText(null);
                            break;
                        }  
                  }
              }
          }
            if(i==7)
            {
                JPasswordField sp1 = (JPasswordField)txt2[1];
                JPasswordField sp2 = (JPasswordField)txt2[2];
                String pas=String.copyValueOf(sp1.getPassword());
                if( !pas.equals(String.copyValueOf(sp2.getPassword())))
                  {
                        JOptionPane.showMessageDialog(null,"Passwords donot match");
                        sp1.setText(null);
                        sp2.setText(null);
                        return;
                  }
                JOptionPane.showMessageDialog(null,"Successfully Registered");
                String psw = md5(pas);
                String id = ((JTextField)(txt2[0])).getText();
                String nam = ((JTextField)(txt2[3])).getText();
                String email = ((JTextField)(txt2[4])).getText();
                String phone = ((JTextField)(txt2[5])).getText();
                String addr = ((JTextArea)(txt2[6])).getText();
                String sql="INSERT INTO users values ('"+id+"','"+psw+"','"+phone+"','"+email+"','"+addr+"','"+nam+"');";
                //System.out.print(sql);
                //cardLayout.show(cards,Integer.toString(2));
                queryexecute(sql);
            }
              
          
      }
  }

  public static void main(String[] args) {
    demo1 jrframe = new demo1();
    jrframe.setTitle("Indian Railways Enquiry");
    jrframe.setSize(1000,700);
    jrframe.setVisible(true);
    jrframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}

class ContentPanel extends JPanel {
  Image bgimage = null;

  ContentPanel() {
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage("train1.jpg");
    mt.addImage(bgimage, 0);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    setLayout(new BorderLayout());
        
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int imwidth = bgimage.getWidth(null);
    int imheight = bgimage.getHeight(null);
    g.drawImage(bgimage, 0, 0, getWidth(), getHeight(), null);
  }
}