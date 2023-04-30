
import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;


public class AppointmentTableModel extends AbstractTableModel {
    private final String[] columnName = {"ID", "Patient's First Name", "Patient's Last Name", "Date Of Birth", "Mobile Number", "Name of the Doctor", "Reserved date", "Reserved Time Slot", "Doc Fee"};
    private final ArrayList<Patient> patientList;
    private final ArrayList<Consultation> consultationList;

    public AppointmentTableModel(ArrayList<Patient> listOfPatients, ArrayList<Consultation> consultationList) {
        this.patientList = listOfPatients;
        this.consultationList = consultationList;
    }

    @Override
    public int getRowCount() {
        return patientList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = patientList.get(rowIndex).getPatientID();
        } else if (columnIndex == 1) {
            temp = patientList.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            temp = patientList.get(rowIndex).getSurname();
        }else if (columnIndex == 3) {
            temp = patientList.get(rowIndex).getDob();
        } else if (columnIndex == 4) {
            temp = patientList.get(rowIndex).getMobileNumber();
        } else if (columnIndex == 5) {
            temp = consultationList.get(rowIndex).getDoctorName();
        } else if (columnIndex == 6) {
            temp = consultationList.get(rowIndex).get_date();
        } else if (columnIndex == 7) {
            temp = consultationList.get(rowIndex).get_timeSlot();
        } else if (columnIndex == 8) {
            temp = consultationList.get(rowIndex).get_cost();
        }
        return temp;
    }

//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex)
//    {
//        return true;
//    }
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        Patient row = ConsultationGUI.patientList.get(rowIndex);
//        if (0 == columnIndex) {
//            row.getPatientID((Integer) aValue);
//        } else if (1 == columnIndex) {
//            row.getName((String) aValue);
//        } else if (2 == columnIndex) {
//            row.getSurname((String) aValue);
//        } else if (3 == columnIndex) {
//            row.set_dOB((LocalDate) aValue);
//
//        }  else if (4 == columnIndex) {
//            row.set_mobileNumber((String) aValue);
//        } else if (5 == columnIndex) {
//            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
//        } else if (6 == columnIndex) {
//            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
//        } else if (7 == columnIndex) {
//            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
//        } else if (8 == columnIndex) {
//            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
//        }else if (9 == columnIndex) {
//            JOptionPane.showMessageDialog(null, "You can't change the values in this field!", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("forbidden.png"));
//        }
//        ConsultationGUI.SaveInFile();
//    }

    public String getColumnName(int col) {
        return columnName[col];
    }

    public Class getColumnClass(int col) {
        if (col == 0) {
            return int.class;
        } else if (col == 1) {
            return String.class;
        } else if (col == 2) {
            return String.class;
        } else if (col == 3) {
            return LocalDate.class;
        } else if (col == 4) {
            return String.class;
        } else if (col == 5) {
            return String.class;
        } else if (col == 6) {
            return LocalDate.class;
        } else if (col == 7) {
            return String.class;
        } else if (col == 8) {
            return String.class;
        } else {
            return null;
        }
    }
}
