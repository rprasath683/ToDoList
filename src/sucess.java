import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class sucess extends JFrame {
    private Font font = new Font("Times New Roman", Font.PLAIN, 20);
    private Font namefont = new Font("Times New Roman", Font.BOLD, 22);


    sucess() {
        JLabel label = new JLabel("Hello");
        label.setFont(font);
        String User ="";
        JLabel name = new JLabel();
        JPanel menupanel = new JPanel();
        menupanel.setBackground(Color.BLUE);
        menupanel.setSize(new Dimension(100, 200));
        if(System.getProperty("User")!=null)
        {
            User = System.getProperty("User").toUpperCase();
        }
        name.setText(User);
        name.setFont(namefont);
        name.setForeground(Color.RED);
        menupanel.add(label);
        //label.setHorizontalAlignment(JLabel.LEFT);
        label.setBounds(10,20,100,20);
        menupanel.setLayout(null);
        //label.setBorder(BorderFactory.createBevelBorder(1));

        menupanel.add(name);


        this.setSize(500, 700);
        this.add(menupanel, BorderLayout.NORTH);
        // menupanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.getContentPane().setBackground(new Color(153, 168, 187));
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        new sucess();
    }
}
