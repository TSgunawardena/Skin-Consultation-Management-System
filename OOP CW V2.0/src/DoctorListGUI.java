import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class DoctorListGUI extends JFrame implements Serializable {
    private JButton backToHomeButton;
    private JButton sortByName;
    private JTable table;

    DoctorListGUI() {

        //Adding background image to the frame
        JLabel background = new JLabel(new ImageIcon("images\\background.jpg"));
        background.setBounds(0, 0, 1500, 1000);

        // Adding back to home button
        backToHomeButton = new JButton();
        backToHomeButton.setIcon(new ImageIcon("images\\HomeIcon.png"));
        backToHomeButton.setBackground(new Color(134, 213, 148));
        backToHomeButton.setBounds(1270, 35, 100, 50);
        backToHomeButton.setFocusable(false);

        this.add(backToHomeButton);
        backToHomeButton.addActionListener(e -> {
            if (e.getSource() == backToHomeButton) {
                backToHomeButton.setBackground(new Color(133, 212, 147));
                this.dispose();
                new HomeGUI();
            }
        });

        //Adding buttons
        sortByName = new JButton("Sort by Name");
        sortByName.setFont(new Font("Times New Roman", Font.BOLD,26));
        sortByName.setBackground(new Color(134, 213, 148));
        sortByName.setBounds(70, 705,200,50);
        this.add(sortByName);
        sortByName.addActionListener(e -> {
            if (e.getSource() == sortByName) {
                table.getRowSorter().toggleSortOrder(1);
            }
        });


        //Code for the Frame
        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        this.add(ScrollPane());


        this.add(background);
    }
    private JScrollPane ScrollPane() {
        final JScrollPane scrollPane;
        //Creating an object of custom table model class
        DoctorTableModel model = new DoctorTableModel(WestminsterSkinConsultationManager.doctors);

        // Creating a table
        table = new JTable(model);
        table.setBackground(new Color(105, 217, 124));
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(199, 80, 80));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Serif", Font.BOLD, 13));
        table.setRowHeight(53);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(90, 50));
        table.getTableHeader().setForeground(new Color(255, 45, 0));
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 120, 1300, 583);
        return scrollPane;
    }

}
