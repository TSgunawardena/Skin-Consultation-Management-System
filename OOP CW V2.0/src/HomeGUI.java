import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomeGUI extends JFrame  {
    private final JButton button1;

    public HomeGUI(){

        //Adding background image to the frame
        JLabel background = new JLabel(new ImageIcon("images\\background.jpg"));
        background.setBounds(0,0,1500,1000);

        JLabel header = new JLabel(new ImageIcon("images\\logo.png"));
        header.setBounds(450, -170, 500 ,500);

        JLabel image = new JLabel(new ImageIcon("images\\logo1.png"));
        image.setBounds(1000,300,500, 500);


        //Adding buttons
        button1 = new JButton("Doctors Information");
        button1.setBounds(500,250,400,75);
        button1.setIcon(new ImageIcon("images\\icon1.png"));
        button1.setFont(new Font("Times New Roman", Font.BOLD,26));
        button1.setBackground(new Color(134, 213, 148));
        button1.setFocusable(false);
        button1.addActionListener(e -> {
            if (e.getSource() == button1){
                dispose();
                new DoctorListGUI();
            }
        });
                background.add(button1);

        //Adding second button to the frame
        JButton button2 = new JButton("Book a Consultation");
        button2.setBounds(500,350,400,75);
        button2.setIcon(new ImageIcon("images\\icon2.png"));
        button2.setFont(new Font("Times New Roman", Font.BOLD,26));
        button2.setBackground(new Color(134, 213, 148));
        button2.setFocusable(false);
        button2.addActionListener(e -> {
            dispose();
            new ConsultationGUI();
        });
                background.add(button2);

        //Adding third button to the frame

        JButton button3 = new JButton("View a Consultation");
        button3.setBounds(500,450,400,75);
        button3.setIcon(new ImageIcon("images\\icon3.png"));
        button3.setFont(new Font("Times New Roman", Font.BOLD,26));
        button3.setBackground(new Color(134, 213, 148));
        button3.setFocusable(false);
        button3.addActionListener(e -> {
            dispose();
            new AppointmentsGUI();
        });
        background.add(button3);
        //Adding fourth button to the frame

        JButton button4 = new JButton("Exit");
        button4.setBounds(500,550,400,75);
        button4.setIcon(new ImageIcon("images\\icon4.png"));
        button4.setFont(new Font("Times New Roman", Font.BOLD,26));
        button4.setBackground(new Color(134, 213, 148));
        button4.setFocusable(false);
        button4.addActionListener(e -> dispose());
                background.add(button4);

        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(header);
        this.add(image);
        this.add(background);
    }

}


