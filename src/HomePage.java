import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

class ListLabel extends JPanel {
    int index=1;
    JLabel listItem;
    JCheckBox delCBox;
    JPanel pannel;
    private Font font = new Font("Sans-Serif", Font.PLAIN, 25);
    ListLabel( int y)
    {
        
        this.setLayout(null);
        this.setBounds(15, y, 460, 35);

        
         
        
        listItem= new JLabel();
        listItem.setBounds(50,5,250,25);
        listItem.setFont(font);

        delCBox = new JCheckBox();
        delCBox.setBounds(420,0,35,35);
        delCBox.setBackground(new Color(195, 141, 158));
        delCBox.setVisible(false);
        //delCBox.setVisible();
        
        this.add(delCBox);
        this.add(listItem);
        this.setVisible(true);
        this.setBackground(new Color(195, 141, 158));

    }

    public JLabel getlistItem() {
        return listItem;
    }

    public JCheckBox getdelcheckBox() {
        return delCBox;
    }
}

public class HomePage extends JFrame implements ActionListener {

    JPanel topPanel, bottomPanel, addPanel , demoJPanel;
    JLabel greetLbl, nameLbl ,demoLabel;
    private Font labelFont = new Font("Roboto", Font.BOLD, 20);
    private Font font = new Font("Sans-Serif", Font.PLAIN, 25);
    private Font HeadingFont = new Font("Roboto", Font.BOLD, 25);
    private Color panneColor = new Color(42, 49, 50);
    // private Color pannelLblColor = new Color(42, 49, 50);
    private JButton addBtn, deleteBtn, settingBtn, LogoutBtn, pannelAddBtn;
    private JTextField newTaskTxt;
    String username;

    
   
    private ArrayList<ListLabel> LI = new ArrayList<>();
    // private JScrollPane contentPane ;

    private int y = 0;
    

    HomePage() {
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 500, 50);
        topPanel.setBackground(panneColor);
        topPanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 615, 500, 50);
        bottomPanel.setBackground(panneColor);
        bottomPanel.setLayout(null);

        addPanel = new JPanel();
        addPanel.setBounds(0, 50, 500, 50);
        addPanel.setBackground(new Color(167, 190, 174));
        addPanel.setLayout(null);

        demoJPanel = new JPanel();
        demoJPanel.setBounds(0,100,500,550);
        demoJPanel.setBackground(new Color(167, 190, 174));
        demoJPanel.setLayout(null);
       // demoJPanel.setBackground(Color.RED);
        

        greetLbl = new JLabel("Welcome : ");
        greetLbl.setBounds(20, 10, 150, 30);
        greetLbl.setFont(labelFont);
        greetLbl.setForeground(new Color(167, 190, 174));

        nameLbl = new JLabel("Ram");
        nameLbl.setBounds(130, 10, 250, 30);
        nameLbl.setFont(HeadingFont);
        nameLbl.setForeground(new Color(197, 0, 26));

        username = System.getProperty("User");
        if (!System.getProperty("User").equals("")) {
            nameLbl.setText(username);
        }

        newTaskTxt = new JTextField();
        newTaskTxt.setBounds(20, 10, 300, 30);
        newTaskTxt.setFont(font);

        pannelAddBtn = new JButton("Add");
        pannelAddBtn.setBounds(350, 5, 120, 40);
        pannelAddBtn.setBackground(new Color(115, 96, 91));
        pannelAddBtn.setFocusable(false);
        pannelAddBtn.setBorder(new EtchedBorder(new Color(167, 190, 174), panneColor));
        pannelAddBtn.setForeground(Color.LIGHT_GRAY);
        pannelAddBtn.setBorderPainted(true);
        pannelAddBtn.setFont(font);
        pannelAddBtn.addActionListener(this);

        LogoutBtn = new JButton("Log out");
        LogoutBtn.setBounds(350, 2, 130, 46);
        LogoutBtn.setBackground(panneColor);
        LogoutBtn.setFocusable(false);
        LogoutBtn.setBorder(new EtchedBorder(new Color(167, 190, 174), panneColor));
        LogoutBtn.setForeground(new Color(167, 190, 174));
        LogoutBtn.setBorderPainted(true);
        LogoutBtn.setFont(font);
        LogoutBtn.addActionListener(this);

        addBtn = new JButton("New List");
        addBtn.setBounds(167, 2, 150, 44);
        addBtn.setBackground(panneColor);
        addBtn.setFocusable(false);
        addBtn.setBorder(new EtchedBorder(new Color(167, 190, 174), panneColor));
        addBtn.setForeground(new Color(167, 190, 174));
        addBtn.setBorderPainted(true);
        addBtn.setFont(font);
        addBtn.addActionListener(this);
        

        deleteBtn = new JButton("Delete List");
        deleteBtn.setBounds(10, 2, 150, 44);
        deleteBtn.setBackground(panneColor);
        deleteBtn.setFocusable(false);
        deleteBtn.setBorder(new EtchedBorder(new Color(167, 190, 174), panneColor));
        deleteBtn.setForeground(new Color(167, 190, 174));
        deleteBtn.setBorderPainted(true);
        deleteBtn.setFont(font);
        deleteBtn.addActionListener(this);

        settingBtn = new JButton("⚙️ Settings");
        settingBtn.setBounds(327, 2, 150, 44);
        settingBtn.setBackground(panneColor);
        settingBtn.setFocusable(false);
        settingBtn.setBorder(new EtchedBorder(new Color(167, 190, 174), panneColor));
        settingBtn.setForeground(new Color(167, 190, 174));
        settingBtn.setBorderPainted(true);
        settingBtn.setFont(font);

        // contentPane = new JScrollPane();
        // contentPane.setBounds(0,100,450,550);
        // contentPane.setBackground(new Color(167, 190, 174));
        // contentPane.setLayout(null);
        // contentPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        // contentPane.setBorder(null);
        

        topPanel.add(greetLbl);
        topPanel.add(nameLbl);
        topPanel.add(LogoutBtn);

        bottomPanel.add(addBtn);
        bottomPanel.add(deleteBtn);
        bottomPanel.add(settingBtn);

        addPanel.add(newTaskTxt);
        addPanel.add(pannelAddBtn);
        addPanel.setVisible(false);

        this.add(bottomPanel);
        this.add(topPanel);
        this.add(addPanel);
        this.add(demoJPanel);
        //this.add(contentPane);

        this.setSize(500, 700);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(167, 190, 174));
        this.setResizable(false);
        this.setTitle("To Do List");
        //load();

    }
    public void disposeLabel(){
        for(ListLabel lbl : LI)
        {
            demoJPanel.remove(lbl);
            
        }
    }
    public void load()
    {
        try {
            Class.forName(
                "com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                    "123456789");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from newList where username='" + username+ "' ");

                //System.out.println(username+"\n"+password);

            while(rs.next()) {
                ListLabel lbl = new ListLabel(y);
                lbl.getlistItem().setText(rs.getString(2));
                demoJPanel.add(lbl);
                LI.add(lbl);
                y+=40;
                

            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
           

    }

    public void AddListItem()

    {
        try {
            if(LI.size()<=12)
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDoList_DB", "root",
                "123456789");

        Statement st = con.createStatement();
        int rs = st
                .executeUpdate("insert into newList(ListName,IsDeleted,Username)value('"+newTaskTxt.getText()+"',false,'"+username+"')");

        if (rs == 1) {

            System.out.println("c1");
            ListLabel lbl = new ListLabel(y);
            lbl.getlistItem().setText(newTaskTxt.getText());
            demoJPanel.add(lbl);
            demoJPanel.revalidate();
            LI.add(lbl);
            y+=40;
            
           
            return;
            // JPanel newq = new JPanel();
            // newq.setBounds(50,100,400,50);
            // newq.setBackground(Color.YELLOW);

            // demoJPanel.add(newq);
             
            
            

        }

            }
           
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    Boolean flag = true,deleteFlag=true;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) 
        {

            if (flag) {
                flag = false;
                addPanel.setVisible(true);
                addBtn.setText("Done");
                return;
            }
            else if (!flag) {
                flag = true;
                addPanel.setVisible(false);
                addBtn.setText("New List");

            }

        }
         else if (e.getSource() == LogoutBtn) {
            new NewLogin();
            dispose();
        }
        else if(e.getSource()==pannelAddBtn)
        {
            AddListItem();
            newTaskTxt.setText("");
            
        }
        else if(e.getSource()==deleteBtn)
        {
            System.out.println("Condition");
            disposeLabel();
            // this.remove(demoJPanel);
            // demoJPanel = new JPanel();
            // demoJPanel.setBounds(0,100,500,550);
            // demoJPanel.setBackground(new Color(167, 190, 174));
            // demoJPanel.setLayout(null);
            demoJPanel.revalidate();
            
            load();
    
           
            
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }

}
