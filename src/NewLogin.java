
import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
//import java.io.*;
import java.sql.*;


public class NewLogin extends JFrame implements ActionListener {
    
    private Font font = new Font("Sans-Serif", Font.PLAIN, 25);
    private Font HeadingFont = new Font("Roboto", Font.BOLD, 30);
    JButton submitBtn, clearBtn,createBtn;
    JTextField userTxt;
    JPasswordField passtxt;
    private Color labelColor = new Color(42, 49, 50);
    private Font labelFont = new Font("Roboto", Font.BOLD, 20);
    JLabel checkpassLbl,mandatoryLbl,label;
    
    
    

    NewLogin() {
        this.setTitle("To Do List");
        this.setSize(500, 600);

        JLabel heading = new JLabel("LOGIN PAGE");
        heading.setFont(HeadingFont);
        heading.setBounds(160, 50, 400, 50);
        heading.setForeground(labelColor);

        JLabel userLbl = new JLabel("Username  ");
        userLbl.setFont(labelFont);
        userLbl.setBounds(50, 160, 400, 30);
        userLbl.setForeground(labelColor);

        userTxt = new JTextField();
        userTxt.setFont(font);
        userTxt.setBounds(50, 200, 400, 30);
        // userTxt.setBorder(BorderFactory.createEtchedBorder());
        

        JLabel passLbl = new JLabel("Password   ");
        passLbl.setFont(labelFont);
        passLbl.setBounds(50, 240, 400, 30);
        passLbl.setForeground(labelColor);

        passtxt = new JPasswordField();
        passtxt.setFont(font);
        passtxt.setBounds(50, 280, 400, 30);
        // passtxt.setFocusable(false);
        // passtxt.setBorder(BorderFactory.createEtchedBorder());

        submitBtn = new JButton("Login");
        submitBtn.setFont(font);
        submitBtn.setBounds(50, 340, 400, 40);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);
        submitBtn.setBackground(new Color(49, 71, 58));
        submitBtn.setBorder(BorderFactory.createEtchedBorder());
        submitBtn.setForeground(new Color(237, 244, 242));;
        

        clearBtn = new JButton("Clear");
        clearBtn.setFont(font);
        clearBtn.setBounds(50, 400, 400, 40);
        clearBtn.setFocusable(false);
        clearBtn.setBorder(BorderFactory.createEtchedBorder());
        clearBtn.setBackground(new Color(49, 71, 58));
        clearBtn.setForeground(new Color(237, 244, 242));;
        clearBtn.addActionListener(this);

        createBtn = new JButton("Create New Account !"); 
        createBtn.setFont(font);
        createBtn.setBounds(50, 460, 400, 40);
        createBtn.setFocusable(false);
        createBtn.setBorder(BorderFactory.createEtchedBorder());
        createBtn.setBackground(new Color(49, 71, 58));
        createBtn.setForeground(new Color(237, 244, 242));;
        createBtn.addActionListener(this);

        checkpassLbl = new JLabel("Password Must Be Minimum  8 Digits !..");
        checkpassLbl.setBounds(170, 235, 300, 40);
        checkpassLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        checkpassLbl.setVisible(false);
        checkpassLbl.setForeground(Color.RED);

        mandatoryLbl = new JLabel("Username or PassWord Field Must Not Be Empty ");
        mandatoryLbl.setBounds(40, 100, 440, 40);
        mandatoryLbl.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        mandatoryLbl.setVisible(false);
        mandatoryLbl.setForeground(Color.RED);

        label = new JLabel("Username or PassWord Field Mismatch ");
        label.setBounds(70, 100, 400, 40);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        label.setVisible(false);
        label.setForeground(Color.RED);

        this.add(heading);
        this.add(userLbl);
        this.add(userTxt);
        this.add(userLbl);
        this.add(passLbl);
        this.add(passtxt);
        this.add(submitBtn);
        this.add(clearBtn);
        this.add(createBtn);
        this.add(checkpassLbl);
        this.add(mandatoryLbl);
        this.add(label);


        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(167, 190, 174));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setForeground(Color.white);

        submitBtn.addKeyListener( new KeyAdapter() {

            
    
            public void keyPressed(KeyEvent e) {
    
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    
                    LoginClick();
    
                }
    
            }
    
        });

    }
    public void clear()
    {
        userTxt.setText("");
        passtxt.setText("");
    }

    public void LoginClick()
    {
        mandatoryLbl.setVisible(false);
        checkpassLbl.setVisible(false);
        String username = userTxt.getText().trim();
        char[]arr = passtxt.getPassword();
        String password = new String(arr) ;
        if (!username.equals("") && !password.equals("")) {
            System.out.println("C1");
            if(password.length()>=8)
            {

            
            try {
                String epw =Password.encrypt(password);
                Class.forName(
                    "com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                        "123456789");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                        "select * from account where username='" + username + "' and password='" + epw + "'");

                    //System.out.println(username+"\n"+password);

                if (rs.next()) {
                    System.setProperty("User", username);
                    HomePage page = new HomePage();
                    page.load();
                    dispose();

                } else {
                    label.setVisible(true);
                    clear();
                    userTxt.setFocusable(true);

                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }
        else
        {
           checkpassLbl.setVisible(true);
           passtxt.setText("");
           passtxt.setFocusable(true);
        }
     }
     else
    {
        mandatoryLbl.setVisible(true);
    }

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            
          
            LoginClick();

        }
        else if(e.getSource()==clearBtn)
        {
            clear();
            mandatoryLbl.setVisible(false);
            checkpassLbl.setVisible(false);
            label.setVisible(false);
        }
        else if(e.getSource()==createBtn)
        {
            new NewSignUp();
            dispose();
        }
        
        
    }

    public static void main(String[] args) {

        new NewLogin();
    }

}
