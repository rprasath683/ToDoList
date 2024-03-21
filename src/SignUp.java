import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {
    private Font font = new Font("Roboto", Font.PLAIN, 20);
    private Font HeadingFont = new Font("Roboto", Font.BOLD, 30);
    private Font buttonFont = new Font("Roboto", Font.BOLD, 25);
    JButton submitBtn, clearBtn;
    JTextField firstNameTxt, lastNameTxt, emailTxt, mobileTxt, usernameTxt, passwordTxt, conformPasswordTxt, dobTxt;
    JLabel firstNameLbl, lastNameLbl, emailLbl, mobileLbl, usernameLbl, passwordLbl, conformPasswordLbl, dobLbl,
            mandatoryLbl, checkpassLbl;

    SignUp() {
        JLabel heading = new JLabel(" CREATE ACCOUNT ");
        heading.setFont(HeadingFont);
        heading.setBounds(350, 30, 300, 50);
        heading.setForeground(Color.BLACK);

        firstNameLbl = new JLabel("First Name ");
        firstNameLbl.setBounds(40, 120, 200, 40);
        firstNameLbl.setFont(font);

        firstNameTxt = new JTextField();
        firstNameTxt.setBounds(230, 122, 200, 30);
        firstNameTxt.setFont(font);

        usernameLbl = new JLabel("User Name ");
        usernameLbl.setBounds(40, 180, 200, 40);
        usernameLbl.setFont(font);

        usernameTxt = new JTextField();
        usernameTxt.setBounds(230, 182, 200, 30);
        usernameTxt.setFont(font);

        passwordLbl = new JLabel("Password ");
        passwordLbl.setBounds(40, 240, 200, 40);
        passwordLbl.setFont(font);

        passwordTxt = new JTextField();
        passwordTxt.setBounds(230, 242, 200, 30);
        passwordTxt.setFont(font);

        conformPasswordLbl = new JLabel("Conform Password ");
        conformPasswordLbl.setBounds(40, 300, 200, 40);
        conformPasswordLbl.setFont(font);

        conformPasswordTxt = new JTextField();
        conformPasswordTxt.setBounds(230, 304, 200, 30);
        conformPasswordTxt.setFont(font);

        lastNameLbl = new JLabel("Last Name ");
        lastNameLbl.setBounds(500, 120, 200, 40);
        lastNameLbl.setFont(font);

        lastNameTxt = new JTextField();
        lastNameTxt.setBounds(670, 122, 200, 30);
        lastNameTxt.setFont(font);

        emailLbl = new JLabel("Email Id ");
        emailLbl.setBounds(500, 180, 200, 40);
        emailLbl.setFont(font);

        emailTxt = new JTextField();
        emailTxt.setBounds(670, 182, 200, 30);
        emailTxt.setFont(font);

        mobileLbl = new JLabel("Mobile Number ");
        mobileLbl.setBounds(500, 240, 200, 40);
        mobileLbl.setFont(font);

        mobileTxt = new JTextField();
        mobileTxt.setBounds(670, 246, 200, 30);
        mobileTxt.setFont(font);

        dobLbl = new JLabel("Date Of Birth ");
        dobLbl.setBounds(500, 300, 200, 40);
        dobLbl.setFont(font);

        dobTxt = new JTextField();
        dobTxt.setBounds(670, 304, 200, 30);
        dobTxt.setFont(font);

        submitBtn = new JButton("Create");
        submitBtn.setBounds(250, 420, 200, 50);
        submitBtn.setFont(buttonFont);
        submitBtn.addActionListener(this);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(500, 420, 200, 50);
        clearBtn.setFont(buttonFont);
        clearBtn.addActionListener(this);

        mandatoryLbl = new JLabel("Please Fill All The Mandatory Fields !...");
        mandatoryLbl.setBounds(200, 500, 600, 50);
        mandatoryLbl.setFont(HeadingFont);
        mandatoryLbl.setVisible(false);
        mandatoryLbl.setForeground(Color.RED);

        checkpassLbl = new JLabel("Password and Conform Password Are Not Same !... ");
        checkpassLbl.setBounds(40, 350, 700, 40);
        checkpassLbl.setFont(font);
        checkpassLbl.setVisible(false);
        checkpassLbl.setForeground(Color.RED);


        this.setSize(1000, 600);
        this.setLayout(null);
        this.add(heading);
        this.add(firstNameLbl);
        this.add(firstNameTxt);
        this.add(usernameLbl);
        this.add(usernameTxt);
        this.add(passwordLbl);
        this.add(passwordTxt);
        this.add(conformPasswordLbl);
        this.add(conformPasswordTxt);
        this.add(lastNameLbl);
        this.add(lastNameTxt);
        this.add(mobileLbl);
        this.add(mobileTxt);
        this.add(emailLbl);
        this.add(emailTxt);
        this.add(dobLbl);
        this.add(dobTxt);
        this.add(submitBtn);
        this.add(clearBtn);
        this.add(mandatoryLbl);
        this.add(checkpassLbl);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

    }
    public void clear()
    {
        firstNameTxt.setText(null);
        lastNameTxt.setText(null);
        passwordTxt.setText(null);
        conformPasswordTxt.setText(null);
        emailTxt.setText(null);
        mobileTxt.setText(null);
        dobTxt.setText(null);
        usernameTxt.setText(null);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {
            try {
                    mandatoryLbl.setVisible(false);
                    checkpassLbl.setVisible(false);
                if (!usernameTxt.getText().equals("") &&
                        !firstNameTxt.getText().equals("") &&
                        !lastNameTxt.getText().equals("") &&
                        !passwordTxt.getText().equals("") && !conformPasswordTxt.getText().equals("") &&
                        !emailTxt.getText().equals("") &&
                        !mobileTxt.getText().equals("") &&
                        !dobTxt.getText().equals("")) {

                    if (passwordTxt.getText().equals(conformPasswordTxt.getText())) {
                        //Password ps = new Password();
                        String username = usernameTxt.getText(),
                                password = passwordTxt.getText(),
                                encryptpass = Password.encrypt(password),
                                firstName = firstNameTxt.getText(),
                                lastName = lastNameTxt.getText(),
                                email = emailTxt.getText(),
                                dob = dobTxt.getText();

                        long mobile = Long.parseLong(mobileTxt.getText());

                        try {
                            //Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                                    "123456789");
                            Statement st = con.createStatement();
                            int rs = st.executeUpdate("insert into account( firstname, lastname, userName, password , emailId,dob , mobileNumber) values('"+firstName+"','"+lastName+"', '"+username+"','"+encryptpass+"','"+email+"','"+dob+"',"+mobile+");");

                            if (rs == 1) {
                                new Login();
                                dispose();

                            } else {

                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                    else
                    {
                        checkpassLbl.setVisible(true);
                    }
                } 
                else {
                    mandatoryLbl.setVisible(true);

                }

            } catch (Exception ex) {

            }

        } else if (e.getSource() == clearBtn) {
            clear();
            mandatoryLbl.setVisible(false);
            checkpassLbl.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new SignUp();
    }

}
