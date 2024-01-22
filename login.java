package bank.managment.system;

import javax.swing.*;//java frame for login page
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    //login as a contructer is created
    JLabel lablel1 , lable2 ,lable3 ;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
  login(){
      super("Bank Managment System");//used to set title of frame at the top
// bank icon set
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));//(image is stored form memory to i1.)
      Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//(to scale tha image stored in i1.1)
      ImageIcon i3=new ImageIcon(i2);//(to make image show on frame again ImageIcon is used in which i2 is passed )
      /*directly image can't be visible on frame
      * so we use LABELS*/

      JLabel image=new JLabel(i3);
      image.setBounds(370,10,100,100);
      add(image);//added jlable image to frame.


//   CARD ICON IS SET IN FRAME
      ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));//(image is stored form memory to ii1.)
      Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//(to scale tha image stored in ii1.1)
      ImageIcon ii3=new ImageIcon(ii2);//(to make image show on frame again ImageIcon is used in which ii2 is passed )
      /*directly image can't be visible on frame
       * so we use LABELS*/
      JLabel iimage=new JLabel(ii3);
      iimage.setBounds(680,350,100,100);
      add(iimage);//added jlable image to frame.

      lablel1=new JLabel("WELCOME TO ATM");
      lablel1.setForeground(Color.white);
      lablel1.setFont(new Font("AvantGarde",Font.BOLD,38));
      lablel1.setBounds(250,130,450,50);
      add(lablel1);

      lable2 =new JLabel("CARD No:");
      lable2.setFont(new Font("Ralway",Font.BOLD,28));
      lable2.setForeground(Color.white);
      lable2.setBounds(150,190,375,30);
      add(lable2);

      textField2=new JTextField(20);
      textField2.setBounds(325,190,230,30);
      textField2.setFont(new Font("Arial",Font.BOLD,15));
      add(textField2);


      lable3 =new JLabel("PIN :");
      lable3.setFont(new Font("Ralway",Font.BOLD,28));
      lable3.setForeground(Color.white);
      lable3.setBounds(200,250,375,30);
      add(lable3);

      passwordField3=new JPasswordField(15);
      passwordField3.setBounds(325,250,230,30);
      passwordField3.setFont(new Font("Arial",Font.BOLD,15));
      add(passwordField3);


      button1 =new JButton("SIGN IN");
      button1.setFont(new Font("Arial",Font.BOLD,14));
      button1.setForeground(Color.white);
      button1.setBackground(Color.BLACK);
      button1.setBounds(325,300,100,30);
      button1.addActionListener(this);
      add(button1);

      button2 =new JButton("CLEAR");
      button2.setFont(new Font("Arial",Font.BOLD,14));
      button2.setForeground(Color.white);
      button2.setBackground(Color.BLACK);
      button2.setBounds(450,300,100,30);


      button2.addActionListener(this);
      add(button2);


      button3 =new JButton("SIGN UP");
      button3.setFont(new Font("Arial",Font.BOLD,14));
      button3.setForeground(Color.white);
      button3.setBackground(Color.BLACK);
      button3.setBounds(325,350,230,30);
      button3.addActionListener(this);
      add(button3);
//   BACKGROUND IS SET IN FRAME
      ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));//(image is stored form memory to iii1.)
      Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);//(to scale tha image stored in iii1.1)
      ImageIcon iii3 =new ImageIcon(iii2);//(to make image show on frame again ImageIcon is used in which iii2 is passed )
      /*directly image can't be visible on frame
       * so we use LABELS*/
      JLabel iiimage=new JLabel(iii3);
      iiimage.setBounds(0,0,850,480);
      add(iiimage);//added jlable image to frame.

      setLayout(null);
      setSize(850,480);//used to set size of the frame
      setLocation(550,350);//to set the position of frame to open at center form x-axis and y axis

      setVisible(true);//it is used to set frame to be visible by setting its value to true.


    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
          if (e.getSource()==button1){
              Con c = new Con();
              String cardno = textField2.getText();
              String pin = passwordField3.getText();
              String q = "select * from login where card_number = '"+cardno+"' and  pin = '"+pin+"'";
              ResultSet resultSet = c.statement.executeQuery(q);
              if (resultSet.next()){
                  setVisible(false);
                  new main_Class(pin);
              }else {
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
              }

          }else if (e.getSource()==button2){
              textField2.setText("");
              passwordField3.setText("");

          }else if (e.getSource()==button3){
              new signup();
              setVisible(false);

          }


      }catch(Exception E){
          E.printStackTrace();
      }


    }

    public static void main(String args[])
    {
     /*object */   new login();

    }


}
