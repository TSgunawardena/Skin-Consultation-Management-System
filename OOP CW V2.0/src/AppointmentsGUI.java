import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class AppointmentsGUI extends JFrame implements Serializable {
    private JButton HomeBtn;
    AppointmentsGUI(){
        //Adding background image to the frame
        JLabel background = new JLabel(new ImageIcon("images\\background.jpg"));
        background.setBounds(0, 0, 1500, 1000);


        HomeBtn = new JButton();
        HomeBtn.setIcon(new ImageIcon("images\\HomeIcon.png"));
        HomeBtn.setBackground(new Color(134, 213, 148));
        HomeBtn.setBounds(1127, 30, 100, 50);
        HomeBtn.setFocusable(false);

        this.add(HomeBtn);
        HomeBtn.addActionListener(e -> {
            if (e.getSource() == HomeBtn) {
                HomeBtn.setBackground(new Color(134, 213, 148));
                this.dispose();
                new HomeGUI();
            }
        });
        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(1300, 683);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(Table());
        this.add(background);
    }

    private JScrollPane Table(){
        AppointmentTableModel appointmentTableModel = new AppointmentTableModel(ConsultationGUI.patientList, ConsultationGUI.consultationList);
// Creating a table with the custom table model
        JTable table = new JTable(appointmentTableModel);
        table.setBackground(new Color(105, 217, 124));
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(199, 80, 80));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Serif", Font.PLAIN,13));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(150,50));
        table.getTableHeader().setForeground(new Color(255, 0, 0));
        table.setAutoCreateRowSorter(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(180);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(5).setPreferredWidth(180);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);

        JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(60, 85, 1170, 500);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        return jScrollPane;
    }
}
