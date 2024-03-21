import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import java.awt.*;
//import java.io.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    private Font font = new Font("Roboto", Font.PLAIN, 20);
    private Font HeadingFont = new Font("Roboto", Font.BOLD, 25);
    JButton submitBtn, clearBtn;
    JTextField userTxt;
    JPasswordField passtxt;

    Login() {
        this.setTitle("To Do List");
        this.setSize(500, 300);

        JLabel heading = new JLabel("LOGIN PAGE");
        heading.setFont(HeadingFont);
        heading.setBounds(170, 30, 200, 35);
        heading.setForeground(Color.BLACK);

        JLabel userLbl = new JLabel("Username : ");
        userLbl.setFont(font);
        userLbl.setBounds(70, 100, 150, 25);
        userLbl.setForeground(Color.BLACK);

        userTxt = new JTextField();
        userTxt.setFont(font);
        userTxt.setBounds(200, 100, 230, 25);
        userTxt.setBorder(BorderFactory.createEtchedBorder());

        JLabel passLbl = new JLabel("Password  : ");
        passLbl.setFont(font);
        passLbl.setBounds(70, 150, 150, 25);
        passLbl.setForeground(Color.BLACK);

        passtxt = new JPasswordField();
        passtxt.setFont(font);
        passtxt.setBounds(200, 150, 230, 25);
        // passtxt.setFocusable(false);
        passtxt.setBorder(BorderFactory.createEtchedBorder());

        submitBtn = new JButton("Login");
        submitBtn.setFont(font);
        submitBtn.setBounds(150, 200, 100, 30);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);

        clearBtn = new JButton("Clear");
        clearBtn.setFont(font);
        clearBtn.setBounds(290, 200, 100, 30);
        clearBtn.setFocusable(false);

        this.add(heading);
        this.add(userLbl);
        this.add(userTxt);
        this.add(userLbl);
        this.add(passLbl);
        this.add(passtxt);
        this.add(submitBtn);
        this.add(clearBtn);

        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(116, 100, 188));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setForeground(Color.white);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String username = userTxt.getText().trim();
            char[]arr = passtxt.getPassword();
            String password = new String(arr) ;
            if (!username.equals("") && !password.equals("")) {
                try {
                    String epw =Password.encrypt(password);
                    Class.forName(
                        "com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                            "123456789");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(
                            "select * from account where username='" + username + "' and password='" + epw + "'");

                        System.out.println(username+"\n"+password);

                    if (rs.next()) {
                        System.setProperty("User", username);
                        new sucess();
                        dispose();

                    } else {
                        new Login();
                        dispose();

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();

                }

            }

        }
    }

    public static void main(String[] args) {

        new Login();
    }

}
