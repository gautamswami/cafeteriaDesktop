
import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.security.spec.ECField;
import java.util.function.IntToDoubleFunction;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import oracle.jdbc.proxy.annotation.Pre;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
        // customer + owner - login+create / menu - order - confirm-total
        // admin - pending+all - update status
public class aa implements ActionListener {
    int billprice = 0;
   
    JFrame main = new JFrame("HOME");
    JPanel logop = new JPanel();
    JPanel mainp = new JPanel();
    JPanel home = new JPanel();
    JPanel menu = new JPanel();
    JPanel items = new JPanel();
    JPanel order = new JPanel();
    JPanel cartpanel = new JPanel();
    /// - - - - - -- - - - - - -* * * ** ** * *** 8 ____________________/////
    /// add a order conformation message before total tab asking that
    // -"your total is 3434 you want to place order and on click of yes save order
    /// to database to show to admin"
    JPanel total = new JPanel();
    JButton menubtn = new JButton("TODAYS MENU");
    /* admin - panels */
    JPanel admin = new JPanel();
    JPanel login = new JPanel();
    JPanel newadmin = new JPanel();
    JPanel adminlist = new JPanel();
    JPanel pendingorder = new JPanel();
    JPanel allorders = new JPanel();
    JLabel carttotallabel = new JLabel();
    JLabel userlabel = new JLabel("USERNAME");
    JLabel passlabel = new JLabel("PASSWORD");
    JTextField username = new JTextField(10);
    JPasswordField password = new JPasswordField(10);
    JLabel namelabel = new JLabel("FULL NAME");
    JLabel newuserlabel = new JLabel("CREATE USERNAME ");
    JLabel newpasslabel = new JLabel("NEW PASSWORD");
    JTextField newusername = new JTextField(10);
    JTextField name = new JTextField(10);
    JTextField newpassword = new JTextField(10);
    JLabel pendinglabel = new JLabel("Pending orders");
    JLabel pendingdetail = new JLabel("PIZZA");
    JCheckBox statuscheck = new JCheckBox();
    // menu items //
    JLabel l1  = new JLabel("COFFE");
    JLabel l2  = new JLabel("COLD COFFE");
    JLabel l3  = new JLabel("VEG MAGGIE");
    JLabel l4  = new JLabel("PASTA");
    JLabel l5  = new JLabel("PANEER BIRYANI");
    JLabel l6  = new JLabel("WHITE SAUCE PASTA");
    JLabel l7  = new JLabel("DOSA");
    JLabel l8  = new JLabel("DUMPLINGS");
    JLabel l9  = new JLabel("CHOCOLATE CAKE");
    JLabel l10  = new JLabel("MEXICAN PANEER SANDWICH");
    JLabel cl1  = new JLabel("COFFE");
    JLabel cl2  = new JLabel("COLD COFFE");
    JLabel cl3  = new JLabel("VEG MAGGIE");
    JLabel cl4  = new JLabel("PASTA");
    JLabel cl5  = new JLabel("PANEER BIRYANI");
    JLabel cl6  = new JLabel("WHITE SAUCE PASTA");
    JLabel cl7  = new JLabel("DOSA");
    JLabel cl8  = new JLabel("DUMPLINGS");
    JLabel cl9  = new JLabel("CHOCOLATE CAKE");
    JLabel cl10  = new JLabel("MEXICAN PANEER SANDWICH");
    JLabel pricelabel = new JLabel();
    JButton remcl1;
    JButton remcl2;
    JButton remcl3;
    JButton remcl4;
    JButton remcl5;
    JButton remcl6;
    JButton remcl7;
    JButton remcl8;
    JButton remcl9;
    JButton remcl10;
    JCheckBox c1 = new JCheckBox("$40");
    JCheckBox c2 = new JCheckBox("$80");
    JCheckBox c3 = new JCheckBox("$100");
    JCheckBox c4 = new JCheckBox("$120");
    JCheckBox c5 = new JCheckBox("$250");
    JCheckBox c6 = new JCheckBox("$180");
    JCheckBox c7 = new JCheckBox("$160");
    JCheckBox c8 = new JCheckBox("$60");
    JCheckBox c9 = new JCheckBox("$200");
    JCheckBox c10 = new JCheckBox("$220");
    JPanel confirmpanel = new JPanel();
    String od1 = " ";
    String od2 = " ";
    String od3 = " ";
    String od4 = " ";
    String od5 = " ";
    String od6 = " ";
    String od7 = " ";
    String od8 = " ";
    String od9 = " ";
    String od10 = " "; 
    


    aa() throws IOException {

        /// --    AMAN SHARMA HOME PAGE   ---  //

        main.setSize(1400, 800);
        main.add(mainp);
        mainp.setSize(1400, 900);
        mainp.setLayout(null);
        mainp.setBackground(Color.gray);
        mainp.add(logop);
        BufferedImage myPicture = ImageIO.read(new File("ft.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        logop.add(picLabel);
        logop.setBounds(30,10,1320,350);
        logop.setBackground(Color.white);
        mainp.add(home);
        home.setBounds(30, 360, 1320, 350);  //-- -- - do y axis to 360 from 370 -- // 
        home.setLayout(null);
        home.setBackground(Color.white);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.add(menubtn);
        menubtn.setBounds(360,20,250,250);
        menubtn.addActionListener(this);
        home.setVisible(true);
        mainp.add(menu);
        menu.setVisible(false);
        menu.setBounds(30, 370, 1320, 350);
        menu.setBackground(Color.DARK_GRAY);
        menu.setLayout(null);
        menu.add(order);

         

        order.setBackground(Color.white);
        order.setBounds(0, 0, 1320, 350);
        order.setLayout(null);
        order.setVisible(true);

        /*  
        VALUES TO BE INSERTED IN DATABSE FROM CONFIRM ORDER FINAL WARNING ORDER BUTTON
        
            INITAIALLY STRING O1,O2,O3... = ""," " -- BLANK
            IN PRESSING ADD STRING = "PIZZA","FAF " ---ORDER
            ON PRESSING REMOVE STRING = " ", " "

            INSERT INTO DB VALUES = ( ""," "," ")--;


        */
        //  cart panel ---- **** ---- -  //
        
        order.add(cartpanel);
        cartpanel.setBackground(new Color(152, 196, 217));
        cartpanel.setBounds(800,0,500,350);
        cartpanel.add(carttotallabel);
        // BoxLayout boxlayout = new BoxLayout(cartpanel, BoxLayout.Y_AXIS);
        // cartpanel.setLayout(null);
        carttotallabel.setText("YOUR ADDED ITEMS ARE ");
        cartpanel.add(Box.createRigidArea(new Dimension(0, 20)));
        carttotallabel.setFont(new Font("Verdana", Font.PLAIN, 34));
        cartpanel.add(cl1);
        /////--------------------- ** to remove this button we will have to use 11 buttons
        remcl1 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od1 = " ";
                cl1.setVisible(false);
                remcl1.setVisible(false);
            }

        });
        cartpanel.add(remcl1);
        remcl1.setVisible(false);
        cl1.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl2);
        remcl2 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od2 = " ";
                cl2.setVisible(false);
                remcl2.setVisible(false);
            }

        });
        cartpanel.add(remcl2);
        remcl2.setVisible(false);
        cl2.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl3);
        remcl3 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od3 = " ";
                cl3.setVisible(false);
                remcl3.setVisible(false);
            }

        });
        cartpanel.add(remcl3);
        remcl3.setVisible(false);
        cl3.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl4);
        remcl4 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od4 = " ";
                cl4.setVisible(false);
                remcl4.setVisible(false);
            }

        });
        cartpanel.add(remcl4);
        remcl4.setVisible(false);
        cl4.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl5);
        remcl5 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od5 = " ";
                cl5.setVisible(false);
                remcl5.setVisible(false);
            }

        });
        cartpanel.add(remcl5);
        remcl5.setVisible(false);
        cl5.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl6);
        remcl6 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od6 = " ";
                cl6.setVisible(false);
                remcl6.setVisible(false);
            }

        });
        cartpanel.add(remcl6);
        remcl6.setVisible(false);
        cl6.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl7);
        remcl7 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od7 = " "; 
                cl7.setVisible(false);
                remcl7.setVisible(false);
            }

        });
        cartpanel.add(remcl7);
        remcl7.setVisible(false);
        cl7.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl8);
        remcl8 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od8 = " ";
                cl8.setVisible(false);
                remcl8.setVisible(false);
            }

        });
        cartpanel.add(remcl8);
        remcl8.setVisible(false);
        cl8.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl9);
        remcl9 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od9 = " ";
                cl9.setVisible(false);
                remcl9.setVisible(false);
            }

        });
        cartpanel.add(remcl9);
        remcl9.setVisible(false);
        cl9.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cartpanel.add(cl10);
        remcl10 = new JButton(new AbstractAction("REMOVE"){

            @Override
            public void actionPerformed(ActionEvent e) {
                od10 = " ";
                cl10.setVisible(false);
                remcl10.setVisible(false);
            }

        });
        cartpanel.add(remcl10);
        remcl10.setVisible(false);
        cl10.setFont(new Font("Verdana", Font.PLAIN, 15));
        cartpanel.add(Box.createRigidArea(new Dimension(0, 10)));
        cl1.setVisible(false);
        cl1.setVisible(false);
        cl2.setVisible(false);
        cl3.setVisible(false);
        cl4.setVisible(false);
        cl5.setVisible(false);
        cl6.setVisible(false);
        cl7.setVisible(false);
        cl8.setVisible(false);cl9.setVisible(false);cl10.setVisible(false);
        /// -- menu start ---//
        order.add(l1);
        l1.setBounds(40,10,150,40);
       l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c1);
        JButton addl1 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                od1 = "COFFE";
               cl1.setVisible(true);
                remcl1.setVisible(true);
            }
            
        });
        order.add(addl1);
        addl1.setBounds(235,10,60,30);
        order.add(l2);
        l2.setBounds(40,50,150,40);
        l2.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c2);
        JButton addl2 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od2 = "COLD COFFE";
                cl2.setVisible(true);
                remcl2.setVisible(true);
            }
            
        });
        order.add(addl2);
        addl2.setBounds(235,50,60,30);
        order.add(l3);
        l3.setBounds(40,90,150,40);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c3);
        JButton addl3 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od3 = "VEG MAGGIE";
                cl3.setVisible(true);
                remcl3.setVisible(true);
            }
            
        });
        order.add(addl3);
        addl3.setBounds(235,90,60,30);
        order.add(l4);
        l4.setBounds(40,130,150,40);
        l4.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c4);
        JButton addl4 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od4 = "PASTA";
                cl4.setVisible(true);
                remcl4.setVisible(true);
            }
            
        });
        order.add(addl4);
        addl4.setBounds(235,130,60,30);
        order.add(l5);
        l5.setBounds(40,170,190,40);
        l5.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c5);
        JButton addl5 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od5 = "PANEER BIRYANI";
                cl5.setVisible(true);
                remcl5.setVisible(true);
            }
            
        });
        order.add(addl5);
        addl5.setBounds(235,170,60,30);
        JPanel line1 = new JPanel();        // line for differentiating order
        order.add(line1);
        line1.setBackground(Color.black);
        line1.setBounds(300,10,3,200);
         order.add(l6);
         l6.setBounds(310,10,220,40);
        l6.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c6);
        JButton addl6 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od6 = "WHITE SAUCE PASTA";
                cl6.setVisible(true);
                remcl6.setVisible(true);
            }
            
        });
        order.add(addl6);
        addl6.setBounds(600,10,60,30);
        order.add(l7);
        l7.setBounds(310,50,220,40);
        l7.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c7);
        JButton addl7 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od7 = "DOSA";
                cl7.setVisible(true);
                remcl7.setVisible(true);
            }
            
        });
        order.add(addl7);
        addl7.setBounds(600,50,60,30);
        order.add(l8);
        l8.setBounds(310,90,220,40);
        l8.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c8);
        JButton addl8 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od8 = "DUMPLINGS";
                cl8.setVisible(true);
                remcl8.setVisible(true);
            }
            
        });
        order.add(addl8);
        addl8.setBounds(600,90,60,30);
        order.add(l9);
        l9.setBounds(310,130,220,40);
        l9.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c9);
        JButton addl9 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od9 = "CHOCOLATE CAKE";
                cl9.setVisible(true);
                remcl9.setVisible(true);
            }
            
        });
        order.add(addl9);
        addl9.setBounds(600,130,60,30);
        order.add(l10);
        l10.setBounds(310,170,290,40);
        l10.setFont(new Font("Verdana", Font.PLAIN, 18));
        order.add(c10);
        JButton addl10 = new JButton(new AbstractAction("ADD") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //// // addd order to cart 
                od10 = "MEXICAN PANEER SANDWICH";
                cl10.setVisible(true);
                remcl10.setVisible(true);
            }
            
        });
        order.add(addl10);
        addl10.setBounds(600,170,60,30);
        
        menu.add(total);
        menu.add(confirmpanel);
        confirmpanel.setBackground(Color.white);
        confirmpanel.setBounds(260,40,680,180);
        confirmpanel.setLayout(null);
        confirmpanel.setVisible(false);
        JLabel warninglabel = new JLabel("CONFIRM ORDER");
        warninglabel.setFont(new Font("Verdana", Font.PLAIN, 27));
        // int price0 = 300000; /// /  - - -  replace total here  price
        JLabel warninglabel2 = new JLabel("YOUR TOTAL IS "+ 280);
        warninglabel2.setFont(new Font("Verdana", Font.PLAIN, 17));
        confirmpanel.add(warninglabel);
        warninglabel.setBounds(230,4,600,40);
        warninglabel2.setBounds(280,45,240,40);
        pricelabel.setBounds(500,45,50,40);
        confirmpanel.add(warninglabel2);
        confirmpanel.add(pricelabel);
        pricelabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        total.setVisible(false);
        total.setBounds(0, 0,1320, 350);
        total.setBackground(Color.white);
        total.setLayout(null);
        mainp.add(admin);
        admin.setLayout(null);
        admin.setBounds(30,370,1320,350);
        admin.setBackground(Color.white);
        admin.setVisible(false);
        JButton yesbtn = new JButton(new AbstractAction("PROCEED") {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conp = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin"); 
                    String sqlp = "insert into neworders values(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psp = conp.prepareStatement(sqlp);
                    psp.setString(1,od1);
                    psp.setString(2,od2);
                    psp.setString(3,od3);
                    psp.setString(4,od4);
                    psp.setString(5,od5);
                    psp.setString(6,od6);
                    psp.setString(7,od7);
                    psp.setString(8,od8);
                    psp.setString(9,od9);
                    psp.setString(10,od10);
                    psp.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ORDERED");
                } catch (SQLException e1) {
                   System.out.println(e1);
                }
                total.setVisible(true);
                confirmpanel.setVisible(false);

            }
            
        });
        JButton backbtn7 = new JButton(new AbstractAction("MODIFY") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
         /* --  // ------ ****   
         if button press add new panel to order select panel where you can remove previous items- - -  - 
         
         -  -  - -- - - ------------------------------------------------
          
          also insted of check box we can give add button and remove button whatever feels easy
                -------------------------------------------------


          add new panel below after press additem button which has item name price and remove btn and total price changing on adding and removing items in this case we can add order button to that panel and remove warning panel 
         */        
                // total.setVisible(true);
              
              
                confirmpanel.setVisible(false);
                order.setVisible(true);
                if(c1.isSelected()){
                    c1.setSelected(false);
                }
                if(c2.isSelected()){
                    c2.setSelected(false);
                }

            }
            
        });
        confirmpanel.add(backbtn7);
        backbtn7.setBounds(250,140,100,30);
        yesbtn.setBounds(370,140,100,30);
        confirmpanel.add(yesbtn);
        JButton adminbtn = new JButton(new AbstractAction("STAFF LOGIN") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                    admin.setVisible(true);
                    home.setVisible(false);
            }

        });
        JButton exitbtn = new JButton(new AbstractAction("EXIT") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
                
            }
            
        });
        home.add(adminbtn);
        adminbtn.setBounds(660, 20, 250, 250);;
        home.add(exitbtn);
        exitbtn.setBounds(1020,20,250,250);
        admin.add(login);
        admin.add(newadmin);
        // login.setLayout(new GridBagLayout());
        login.setLayout(null);
        login.setBackground(Color.white);
        login.setBounds(0,0,1320,350);
        login.add(userlabel);
        userlabel.setBounds(405,5,190,40);
        userlabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        login.add(username);
        username.setBounds(600,5,190,30);
        login.add(passlabel);
        passlabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        passlabel.setBounds(405,80,190,40);
        login.add(password);
        password.setBounds(600,80,190,30);
        JButton backbtn3 = new JButton(new AbstractAction("Back") {  // back from admin login to home

            @Override
            public void actionPerformed(ActionEvent e) {
                
                home.setVisible(true);
                admin.setVisible(false);
                
            }
            
        });
        login.add(backbtn3);
        backbtn3.setBounds(520,160,100,30);
        newadmin.setVisible(false);
        newadmin.setBounds(0,0,1320,350);
        newadmin.setLayout(null);
        newadmin.setBackground(Color.white);
        newadmin.add(namelabel);
        namelabel.setBounds(405,5,190,40);
        namelabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        newadmin.add(name);
        name.setBounds(600,5,190,30);
        newadmin.add(newuserlabel);
        newuserlabel.setBounds(405,80,190,40);
        newuserlabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        newadmin.add(newusername);
        newusername.setBounds(600,80,190,30);
        newadmin.add(newpasslabel);
        newpasslabel.setBounds(405,155,190,40);
        newpasslabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        newadmin.add(newpassword);
        newpassword.setBounds(600,155,190,40);
        JButton backbtn4 = new JButton(new AbstractAction("BACK") {// back to login from create account

            @Override
            public void actionPerformed(ActionEvent e) {
                
                login.setVisible(true);
                newadmin.setVisible(false);
                
            } 
            
        });
        //// match username and add panel account created sucessfully or fail and login button on that panel 
        JButton createbtn1 =  new JButton(new AbstractAction("Create"){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection conc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
                    String sqlc = " insert into admincreate values(?,?,?) ";
                    PreparedStatement psc = conc.prepareStatement(sqlc);
                    // ResultSet rs = ps.executeQuery();
                    // int res = String;
                    psc.setString(1, name.getText());
                    psc.setString(2, newusername.getText());
                    psc.setString(3, newpassword.getText());
                    psc.executeUpdate();
                    JOptionPane.showMessageDialog(null,"ACCOUNT CREATED LOGIN TO PROCEED...");
                    
                }catch(Exception eoc){System.out.println(eoc);}
              
                // try{
                //     Connection conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin") ;
                //     String insert = "insert into logins values('?','?','?');";
                //     PreparedStatement psc = conn2.prepareStatement(insert);
                //     psc.setString(1, name.getText());
                //     psc.setString(1, newusername.getText());
                //     psc.setString(1, newpassword.getText());
                //     psc.execute();
                //     JOptionPane.showMessageDialog(null, "REEGISTERED...");
                // }
                // catch(Exception cr){
                //     System.out.println(cr);
                //     JOptionPane.showMessageDialog(null, cr);
                // }

            // action 1  -save details to database 
            //action 2 - direct to panel 
                newadmin.setVisible(false);
                login.setVisible(true);
                
            }

        });
        newadmin.add(createbtn1);
        createbtn1.setBounds(690,220,90,30);
        newadmin.add(backbtn4);
        backbtn4.setBounds(550,220,90,30);
        // - -- - - - - - ** * * * ** *  - --  - - - //
        // - - AUTHENTICATE USERNAME FROM DATA AND ADD PANEL WORONG USERNAME IF MISMATCH
        admin.add(adminlist);
        adminlist.setVisible(false);
        adminlist.setBackground(Color.white);
        adminlist.setBounds(0,0,1320,350);
        adminlist.setLayout(null);
        JButton backbtn5 = new JButton(new AbstractAction("BACK") {// back to login from create account

            @Override
            public void actionPerformed(ActionEvent e) {
                
                login.setVisible(true);
                adminlist.setVisible(false);
                
            } 
            
        });
        adminlist.add(backbtn5);
        backbtn5.setBounds(340,40,280,280);
        admin.add(pendingorder);
        
        admin.add(allorders);
        allorders.setVisible(false);
        allorders.setBackground(Color.white);
        // allorders.setLayout(null);
        allorders.setBounds(0,0,1320,350);
        /// //  - - .- -/ *** add fields to this panel --- /// 
        allorders.add(pendinglabel);
        allorders.add(pendingdetail);
        JButton backbtn6= new JButton(new AbstractAction("BACK") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                allorders.setVisible(false);
                adminlist.setVisible(true);
                
            }
            
        });
        allorders.add(backbtn6);
        pendingorder.setVisible(false);
        pendingorder.setBackground(Color.white);
        pendingorder.setBounds(0,0,1320,350);
        pendingorder.setLayout(null);
         BoxLayout boxlayout = new BoxLayout(pendingorder, BoxLayout.Y_AXIS);
        pendingorder.setLayout(boxlayout);
        pendingorder.add(pendinglabel);
        pendinglabel.setBounds(405,5,1190,40);
        pendinglabel.setFont(new Font("Verdana", Font.PLAIN,30));

        // pendingorder.add(statuscheck);
        ///// -- - -  add updated sucessfully panel and back buton which directs to adminlist(pending+ all)
        JButton updatebtn = new JButton(new AbstractAction("BACK") {

            @Override
            public void actionPerformed(ActionEvent e) {
               
               pendingorder.setVisible(false);
                adminlist.setVisible(true);
                
            }
            
        });
        pendingorder.add(updatebtn);
        JButton pendingbtn = new JButton(new AbstractAction("   RECENT ORDERS  ") {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{ 
                    Connection conu = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
                    Statement stu = conu.createStatement(); 
                    String sqlu = "select * from orders";
                     ResultSet rsu = stu.executeQuery(sqlu);
                     while(rsu.next()){
                         String ioo1 = rsu.getString("order1");
                         String ioo2 = rsu.getString("order2");
                         String ioo3 = rsu.getString("order3");
                         String ioo4 = rsu.getString("order4");
                         String ioo5 = rsu.getString("order5");
                         String ioo6 = rsu.getString("order6");
                         String ioo7 = rsu.getString("order7");
                         String ioo8 = rsu.getString("order8");
                         String ioo9 = rsu.getString("order9");
                         String ioo10 = rsu.getString("order10");
                         JLabel lu1 = new JLabel(ioo1);
                         pendingorder.add(lu1);
                         JLabel lu2 = new JLabel(ioo2);
                         pendingorder.add(lu2);
                         JLabel lu3 = new JLabel(ioo3);
                         pendingorder.add(lu3);
                         JLabel lu4 = new JLabel(ioo4);
                         pendingorder.add(lu4);
                         JLabel lu5 = new JLabel(ioo5);
                         pendingorder.add(lu5);
                         JLabel lu6 = new JLabel(ioo6);
                         pendingorder.add(lu6);
                         JLabel lu7 = new JLabel(ioo7);
                         pendingorder.add(lu7);
                         JLabel lu8 = new JLabel(ioo8);
                         pendingorder.add(lu8);
                         JLabel lu9 = new JLabel(ioo9);
                         pendingorder.add(lu9);
                         JLabel lu10 = new JLabel(ioo10);
                         pendingorder.add(lu10);
                         System.out.println(ioo1);
                        
                     }
                 }
             catch(Exception e2){
                 System.out.println(e2);
             } 
                pendingorder.setVisible(true);
                adminlist.setVisible(false);
                
            }
            
        });
        JButton allorderbtn = new JButton(new AbstractAction("ALL ORDERS") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                adminlist.setVisible(false);
                allorders.setVisible(true);
                
            }
            
        });
        ///  ---   all orders old  ----/// 

        // adminlist.add(allorderbtn);
        allorderbtn.setBounds(640,40,280,280);
        adminlist.add(pendingbtn);
        pendingbtn.setBounds(640,40,280,280);
      
        JButton loginbtn = new JButton(new AbstractAction("LOGIN") {
                /*
                   boolean login = false
                   if login = true after login 
                   login panel = hidden and if false login panel = visible  

                */
            @Override
            public void actionPerformed(ActionEvent e) {
              
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
                    String username1 = username.getText();
                    String pass1 = password.getText();
                    Statement stm = con.createStatement();

                    String sql = " select * from admincreate where username='"+username1+"' and password = '"+pass1+"' ";
                    ResultSet rs = stm.executeQuery(sql);
                    // PreparedStatement ps = con.prepareStatement(sql);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"WELCOME "+ "  "+username1);
                        login.setVisible(false);
                    adminlist.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD IS WRONG");
                        username.setText("");
                        password.setText("");
                    }
                
                }catch(Exception eo){System.out.println(eo);}
              
                // if(password match )   
                // login.setVisible(false);
                //     adminlist.setVisible(true);
                    //     admin.remove(login);
                // else{set warning panel visible with a try again button}
            }

        });
        JButton createbtn = new JButton(new AbstractAction("CREATE NEW ACCOUNT") {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                newadmin.setVisible(true);
                login.setVisible(false);

            }
            
        });
        login.add(createbtn);  // added create account button 
        login.add(loginbtn);    //added login button - sucessful or fail ??
        loginbtn.setBounds(650,160,140,30);
        createbtn.setBounds(540,210,200,30);
        JButton orderbtn = new JButton(new AbstractAction("order") {  //click to confirm order

            @Override
            public void actionPerformed(ActionEvent e) {
                
     
                    //Et cetera, et cetera
               
          pricelabel.setText("---/");
         

                order.setVisible(false);
                confirmpanel.setVisible(true);
                // total.setVisible(true);
            }

        });
        JButton backbtn = new JButton(new AbstractAction("BACK") { /// back to order

            @Override
            public void actionPerformed(ActionEvent e) {
                
                total.setVisible(false);
                order.setVisible(true);

            }

        });
        JButton backbtn1 = new JButton(new AbstractAction("BACK") { /// back to home

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // order.setVisible(false);
                menu.setVisible(false);

                home.setVisible(true);

            }

        });
        JButton recentbtn = new JButton(new AbstractAction("RECENT Orders") {  //recent orders button added after placing a order

            @Override
            public void actionPerformed(ActionEvent e) {
                
                home.setVisible(false);
                total.setVisible(true);
                order.setVisible(false);
                menu.setVisible(true);

            }

        });
        JButton homebtn = new JButton(new AbstractAction("HOME") {      //press to home from total

            @Override
            public void actionPerformed(ActionEvent e) {
                
                menu.setVisible(false);
                order.setVisible(true);
                total.setVisible(false);
                home.setVisible(true);
                home.add(recentbtn);
                recentbtn.setBounds(40,20,250,250);
            }

        });
        order.add(orderbtn);
       
        order.add(backbtn1);
        orderbtn.setBounds(350, 280, 100, 30);
        backbtn1.setBounds(230, 280, 100, 30);
        // int price = 1900;
        String bill = "********* OUR ORDER IS AS FOLLOWS ";
        JLabel thank = new JLabel("- THANK YOU USING OUR SERVICES - ");
        JLabel totallabel = new JLabel("YOUR ORDER TOTAL IS : 280" );
        total.add(thank);
        thank.setFont(new Font("Verdana", Font.PLAIN, 27));
        thank.setBounds(450,4,590,30);
        total.add(totallabel);
        totallabel.setFont(new Font("Verdana", Font.PLAIN, 17));
        totallabel.setBounds(500, 70, 340, 40);
        backbtn.setBounds(10, 100, 10, 10);
        homebtn.setBounds(590,300, 150, 30);
        total.add(homebtn);     
       
        // total.add(backbtn);
     

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        home.setVisible(false);
        menu.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        aa aa = new aa();
    }
}
