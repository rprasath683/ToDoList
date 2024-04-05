import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class NewSignUp extends JFrame implements ActionListener {
    private Font font = new Font("Roboto", Font.PLAIN, 20);

    private Font HeadingFont = new Font("Roboto", Font.BOLD, 30);
    private Font buttonFont = new Font("Roboto", Font.BOLD, 25);
    JButton submitBtn, clearBtn;
    JTextField firstNameTxt, lastNameTxt, emailTxt, mobileTxt, usernameTxt, passwordTxt, conformPasswordTxt, dobTxt;
    JLabel firstNameLbl, lastNameLbl, emailLbl, mobileLbl, usernameLbl,         passwordLbl, conformPasswordLbl, dobLbl,mandatoryLbl, checkpassLbl,checkuserLbl;
    private Color labelColor = new Color(42, 49, 50);
    private Font labelFont = new Font("Roboto", Font.BOLD, 20);

    NewSignUp() {
        //// ///////////// heading //////////////
        JLabel heading = new JLabel(" CREATE ACCOUNT ");
        heading.setFont(HeadingFont);
        heading.setBounds(100, 20, 300, 50);
        heading.setForeground(Color.BLACK);
        ////////////////////////////////////

        ///////////////// First Name //////////////
        firstNameLbl = new JLabel("First Name ");
        firstNameLbl.setBounds(40, 80, 400, 30);
        firstNameLbl.setFont(labelFont);
        firstNameLbl.setForeground(labelColor);
        ////////////////////////////////////

        ///////////////// FirstName Text Field //////////////

        firstNameTxt = new JTextField();
        firstNameTxt.setBounds(40, 110, 400, 30);
        firstNameTxt.setFont(font);

        ////////////////////////////////////

        ///////////////// LastName Label //////////////

        lastNameLbl = new JLabel("Last Name ");
        lastNameLbl.setBounds(40, 140, 400, 30);
        lastNameLbl.setFont(labelFont);
        lastNameLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// LastName Text Field //////////////

        lastNameTxt = new JTextField();
        lastNameTxt.setBounds(40, 170, 400, 30);
        lastNameTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// UserName Label //////////////

        usernameLbl = new JLabel("User Name ");
        usernameLbl.setBounds(40, 200, 400, 30);
        usernameLbl.setFont(labelFont);
        usernameLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// USerName Text Field //////////////

        usernameTxt = new JTextField();
        usernameTxt.setBounds(40, 230, 400, 30);
        usernameTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// Password label //////////////

        passwordLbl = new JLabel("Password ");
        passwordLbl.setBounds(40, 260, 400, 30);
        passwordLbl.setFont(labelFont);
        passwordLbl.setForeground(labelColor);

        
        ////////////////////////////////////

        ///////////////// Password Text Field //////////////

        passwordTxt = new JTextField();
        passwordTxt.setBounds(40, 290, 400, 30);
        passwordTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// ConformPassword label //////////////

        conformPasswordLbl = new JLabel("Conform Password ");
        conformPasswordLbl.setBounds(40, 320, 200, 30);
        conformPasswordLbl.setFont(labelFont);
        conformPasswordLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// ConformPassword Text Field //////////////

        conformPasswordTxt = new JTextField();
        conformPasswordTxt.setBounds(40, 350, 400, 30);
        conformPasswordTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// Email Label //////////////

        emailLbl = new JLabel("Email Id ");
        emailLbl.setBounds(40, 380, 400, 30);
        emailLbl.setFont(labelFont);
        emailLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// Email Text Field //////////////

        emailTxt = new JTextField();
        emailTxt.setBounds(40, 410, 400, 30);
        emailTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// Mobile label //////////////


        mobileLbl = new JLabel("Mobile Number ");
        mobileLbl.setBounds(40, 440, 400, 30);
        mobileLbl.setFont(labelFont);
        mobileLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// Mobile Text Field //////////////

        mobileTxt = new JTextField();
        mobileTxt.setBounds(40, 470, 400, 30);
        mobileTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// Date Of Birth Label //////////////

        dobLbl = new JLabel("Date Of Birth ");
        dobLbl.setBounds(40, 500, 400, 30);
        dobLbl.setFont(labelFont);
        dobLbl.setForeground(labelColor);
        
        ////////////////////////////////////

        ///////////////// Date Of Birth Text Field //////////////

        dobTxt = new JTextField();
        dobTxt.setBounds(40, 530, 400, 30);
        dobTxt.setFont(font);
        
        ////////////////////////////////////

        ///////////////// Create Account Button //////////////
        
        submitBtn = new JButton("Create Account");
        submitBtn.setBounds(40, 595, 400, 40);
        submitBtn.setFont(buttonFont);
        submitBtn.setBackground(new Color(49, 71, 58));
        submitBtn.setBorder(BorderFactory.createEtchedBorder());
        submitBtn.setForeground(new Color(237, 244, 242));;
        submitBtn.addActionListener(this);
        
        ////////////////////////////////////

        ///////////////// Clear Button //////////////

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(40, 650, 400, 40);
        clearBtn.setFont(buttonFont);
        clearBtn.addActionListener(this);
        clearBtn.setBorder(BorderFactory.createEtchedBorder());
        clearBtn.setBackground(new Color(49, 71, 58));
        clearBtn.setForeground(new Color(237, 244, 242));;
        clearBtn.addActionListener(this);
        
        ////////////////////////////////////

        ///////////////// Mandatory Fields //////////////
        

        mandatoryLbl = new JLabel("Please Fill All The Fields !...");
        mandatoryLbl.setBounds(70, 555, 400, 40);
        mandatoryLbl.setFont(font);
        mandatoryLbl.setVisible(false);
        mandatoryLbl.setForeground(Color.RED);
        
        ////////////////////////////////////

        ///////////////// Check Password Label //////////////

        checkpassLbl = new JLabel("Password Does Not Match !... ");
        checkpassLbl.setBounds(230, 315, 300, 40);
        checkpassLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        checkpassLbl.setVisible(false);
        checkpassLbl.setForeground(Color.RED);
        
        
        ////////////////////////////////////

        ///////////////// Check Password Label //////////////

        checkuserLbl = new JLabel("This Username Already Exists "); 
        checkuserLbl.setBounds(230, 200, 300, 40);
        checkuserLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        checkuserLbl.setVisible(false);
        checkuserLbl.setForeground(Color.RED);
        
        
        ////////////////////////////////////

        ///////////////// JFrame settings //////////////

        this.setSize(500, 750);
        this.setTitle("To Do List");
        this.getContentPane().setBackground(new Color(167, 190, 174));
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        ////////////////////////////////////

        ///////////////// Add Elements To JFrame //////////////

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
        this.add(checkuserLbl);
        
        ////////////////////////////////////

       

        

    }
    public Boolean IscheckUserNameExist(String username) 
    {
        
                Statement st;
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root","123456789");
                    st = con.createStatement();
                    ResultSet rs = st.executeQuery(
                        "select count(username) from account where username='" + username + "'");
                        if(rs.next())
                        {
                            if(rs.getInt(1)==0)
                            {
                                return true;
                            }
                            else
                            {
                                return false;
                            }
                            
                        }
                        else
                        {
                            return false;
                        }
                } catch (SQLException e) {
                   
                    e.printStackTrace();
                    return false;
                }
                
        
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

    // int rs = st.executeUpdate("insert into newList(ListName,IsDeleted,Username)value('task one','false','Ram')");
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {
            try {
                    mandatoryLbl.setVisible(false);
                    checkpassLbl.setVisible(false);
                    checkuserLbl.setVisible(false);
                if (!usernameTxt.getText().equals("") &&
                        !firstNameTxt.getText().equals("") &&
                        !lastNameTxt.getText().equals("") &&
                        !passwordTxt.getText().equals("") && !conformPasswordTxt.getText().equals("") &&
                        !emailTxt.getText().equals("") &&
                        !mobileTxt.getText().equals("") &&
                        !dobTxt.getText().equals("")
                        ) // Checks All The Fields Are Filled Are Not
                        {
                            
                        
                    if(IscheckUserNameExist(usernameTxt.getText().trim()))
                    {
                        if (passwordTxt.getText().equals(conformPasswordTxt.getText())) // Checks Wether the Password And Conform Password Matches
                     {
                        
                        String username = usernameTxt.getText(),
                                password = passwordTxt.getText(),
                                encryptpass = Password.encrypt(password),
                                firstName = firstNameTxt.getText(),
                                lastName = lastNameTxt.getText(),
                                email = emailTxt.getText(),
                                dob = dobTxt.getText();

                        long    mobile = Long.parseLong(mobileTxt.getText());

                        try {
                            //Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                                    "123456789");
                            Statement st = con.createStatement();
                            int rs = st.executeUpdate("insert into account( firstname, lastname, userName, password , emailId,dob , mobileNumber) values('"+firstName+"','"+lastName+"', '"+username+"','"+encryptpass+"','"+email+"','"+dob+"',"+mobile+");");

                            if (rs == 1) {
                                new NewLogin();
                                dispose();

                            } else {
                                clear();
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
                    else{
                        checkuserLbl.setVisible(true);

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
            checkuserLbl.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewSignUp();
    }

}

