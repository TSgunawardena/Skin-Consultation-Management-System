import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Objects;

public class ConsultationGUI extends JFrame implements Serializable
{

    public static final ArrayList<Patient> patientList = new ArrayList<>();
    public static final ArrayList<Consultation> consultationList = new ArrayList<>();
    private JButton backToHomeBtn;
    private final JTextField textFieldForFName, textFieldForLname, textFieldForMobile, labelForDate, labelForDate1 ;
    private final JTextArea textAreaForNotes;
    private final JRadioButton male;
    private String dob, pickedDate, nameOfTheSelectedDoctor;
    public LocalDate date, pickedDate1;
    private JComboBox<String> comboBoxForDocName;
    private JComboBox<Object> jComboBoxForTime;
    String[] doctorNames;
    private final DefaultComboBoxModel<Object> timeslotboxmodel = new DefaultComboBoxModel<>();

    ConsultationGUI() {

        //Adding background image to the frame
        JLabel background = new JLabel(new ImageIcon("images\\background.jpg"));
        background.setBounds(0,0,1500,1000);

        backToHomeBtn = new JButton();
        backToHomeBtn.setIcon(new ImageIcon("images\\HomeIcon.png"));
        backToHomeBtn.setBackground(new Color(134, 213, 148));
        backToHomeBtn.setBounds(50, 35, 100, 50);
        backToHomeBtn.setFocusable(false);

        this.add(backToHomeBtn);
        backToHomeBtn.addActionListener(e -> {
            if (e.getSource() == backToHomeBtn) {
                backToHomeBtn.setBackground(new Color(133, 212, 147));
                this.dispose();
                new HomeGUI();
            }
        });

        background.add(backToHomeBtn);

        JLabel image = new JLabel(new ImageIcon("images\\back1.png"));
        image.setBounds(1000,-50,500, 500);

        JLabel footer = new JLabel(new ImageIcon("images\\doc.png"));
        footer.setBounds(300,475,300, 300);

        JLabel patientDetails = new JLabel("Patient Details");
        patientDetails.setFont(new Font("Comic Sans MS", Font.BOLD,  40));
        patientDetails.setBounds(450, 50, 400, 100);
        this.add(patientDetails);

        textFieldForFName = new JTextField();
        textFieldForFName.setBounds(200, 150, 200, 40);
        textFieldForFName.setBackground(new Color(203, 200, 200));
        textFieldForFName.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(textFieldForFName);


        JLabel forFirstName = new JLabel("First Name:");
        forFirstName.setBounds(50, 150, 150, 35);
        forFirstName.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(forFirstName);

        textFieldForLname = new JTextField();
        textFieldForLname.setBounds(800, 150, 200, 40);
        textFieldForLname.setBackground(new Color(203, 200, 200));
        textFieldForLname.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(textFieldForLname);

        JLabel forLName = new JLabel("Last Name:");
        forLName.setBounds(650,150, 100, 35);
        forLName.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(forLName);

        labelForDate = new JTextField(String.valueOf(LocalDate.now()));
        labelForDate.setBounds(200, 200, 200, 40);
        labelForDate.setBackground(new Color(203, 200, 200));
        labelForDate.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(labelForDate);

        JLabel forDOB = new JLabel("Date Of Birth:");
        forDOB.setBounds(50,200, 130,50);
        forDOB.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(forDOB);

        textFieldForMobile = new JTextField();
        textFieldForMobile.setBounds(800, 200, 200, 40);
        textFieldForMobile.setBackground(new Color(203, 200, 200));
        textFieldForMobile.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(textFieldForMobile);


        JLabel forMobile = new JLabel("Mobile Number:");
        forMobile.setBounds(650,200, 150, 35);
        forMobile.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(forMobile);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Verdana", Font.PLAIN, 18));
        gender.setBounds(400, 285, 100,60);
        this.add(gender);


        male = new JRadioButton("Male");
        male.setFont(new Font("Verdana", Font.PLAIN, 15));
        male.setBackground(new Color(203, 200, 200));
        male.setSelected(true);
        male.setBounds(500,300,100,30);
        this.add(male);


        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setBackground(new Color(203, 200, 200));
        female.setSelected(false);
        female.setBounds(620,300,100,30);
        this.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel addConsultation = new JLabel("Add Consultation");
        addConsultation.setFont(new Font("Comic Sans MS", Font.BOLD,  40));
        addConsultation.setBounds(930, 360, 500, 50);
        this.add(addConsultation);

        JLabel forDate = new JLabel("Book a Date:");
        forDate.setBounds(650, 430, 120, 35);
        forDate.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(forDate);

        labelForDate1 = new JTextField(String.valueOf(LocalDate.now()));
        labelForDate1.setBounds(800, 430, 200, 40);
        labelForDate1.setBackground(new Color(203, 200, 200));
        labelForDate1.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(labelForDate1);

        JLabel selectDocLabel = new JLabel("Select a Doctor:");
        selectDocLabel.setBounds(1035,430, 200, 35);
        selectDocLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(selectDocLabel);


        JLabel labelForDuration = new JLabel("Time Slot:");
        labelForDuration.setBounds(1035, 510, 150, 35);
        labelForDuration.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(labelForDuration);

        JLabel labelForNote = new JLabel("Add Notes:");
        labelForNote.setBounds(650, 550, 100, 35);
        labelForNote.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(labelForNote);

        textAreaForNotes = new JTextArea();
        textAreaForNotes.setLineWrap(true);
        textAreaForNotes.setBounds(800,400,200,75);
        textAreaForNotes.setBackground(new Color(203, 200, 200));
        textAreaForNotes.setFont(new Font("Verdana", Font.PLAIN, 15));
        textAreaForNotes.setOpaque(true);

        JScrollPane textAreaScroll = new JScrollPane(textAreaForNotes);
        textAreaScroll.setBounds(800, 550, 200, 75);
        this.add(textAreaScroll);

        JLabel labelForImg = new JLabel("Upload an Image");
        labelForImg.setBounds(1040, 590, 170, 35);
        labelForImg.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(labelForImg);

        JButton fileChooser = new JButton("Browse");
        fileChooser.setBounds(1210, 590, 150, 35);
        fileChooser.setBackground(new Color(134, 213, 148));
        fileChooser.setFont(new Font("Times New Roman", Font.BOLD,20));
        this.add(fileChooser);
        fileChooser.addActionListener(ae -> {
            if (ae.getSource() == fileChooser) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showSaveDialog(null);
            }
        });

        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(DoctorNames());
        this.add(labelForDate);
        this.add(labelForDate1);
        this.add(Book());
        this.add(ResetBtn());
        this.add(ListOfAppointments());
        this.add(TimeSlot());
        this.add(footer);
        this.add(image);
        this.add(background);
    }

    private JComboBox<String> DoctorNames() {

        doctorNames = new String[WestminsterSkinConsultationManager.doctors.size()];
        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
            String fullName = WestminsterSkinConsultationManager.doctors.get(i).getFullName();
            doctorNames[i] = fullName;
        }
        comboBoxForDocName = new JComboBox<>(doctorNames);
        comboBoxForDocName.setBounds(1190, 423, 200, 50);
        comboBoxForDocName.setBackground(new Color(203, 200, 200));
        comboBoxForDocName.setFont(new Font("Verdana", Font.PLAIN, 15));


        return comboBoxForDocName;
    }
    private JComboBox<Object> TimeSlot() {
        timeslotboxmodel.addElement("-- Select --");
        timeslotboxmodel.addElement("9.00 a.m. - 10.00 a.m.");
        timeslotboxmodel.addElement("10.00 a.m. - 11.00 a.m.");
        timeslotboxmodel.addElement("11.00 a.m. - 12.00 p.m.");
        timeslotboxmodel.addElement("12.00 p.m. - 13.00 p.m.");
        timeslotboxmodel.addElement("13.00 p.m. - 14.00 p.m.");
        timeslotboxmodel.addElement("14.00 p.m. - 15.00 p.m.");
        timeslotboxmodel.addElement("15.00 p.m. - 16.00 p.m.");
        timeslotboxmodel.addElement("16.00 p.m. - 17.00 p.m.");
        timeslotboxmodel.addElement("17.00 p.m. - 18.00 p.m.");
        timeslotboxmodel.addElement("18.00 p.m. - 19.00 p.m.");


        jComboBoxForTime = new JComboBox<>(timeslotboxmodel);
        jComboBoxForTime.setBounds(1190, 503, 200, 50);
        jComboBoxForTime.setBackground(new Color(203, 200, 200));
        jComboBoxForTime.setFont(new Font("Verdana", Font.PLAIN, 15));

        return jComboBoxForTime;
    }

    private JButton Book() {
        JButton book = new JButton("Book Now");
        book.setBounds(1250, 700, 150, 50);
        book.setFont(new Font("Times New Roman", Font.BOLD,20));
        book.setBackground(new Color(134, 213, 148));
        book.setForeground(Color.BLACK);
        book.addActionListener(ae -> {
            if (ae.getSource() == book) {
                if (!textFieldForFName.getText().isEmpty() && !textFieldForLname.getText().isEmpty() && !labelForDate.getText().isEmpty() && !textFieldForMobile.getText().isEmpty()) {
                    String fName = textFieldForFName.getText();
                    String lName = textFieldForLname.getText();
                    dob = labelForDate.getText();
                    date = LocalDate.parse(dob);
                    String mobile = textFieldForMobile.getText();

                    String doctorName = (String) DoctorNames().getSelectedItem();
                    pickedDate = labelForDate.getText();
                    pickedDate1 = LocalDate.parse(pickedDate);
                    String time = (String) TimeSlot().getSelectedItem();
                    String notes = textAreaForNotes.getText();
                    double consultationFee = calculateConsultationFee( fName, lName);
                    Consultation consultation = new Consultation(doctorName, pickedDate1, time, notes, consultationFee);
                    Patient patient = new Patient(fName, lName, date, mobile, patientList.size());
                    patientList.add(patient);
                    consultationList.add(consultation);

                    JOptionPane.showMessageDialog(this, "Your consultation reserved Successfully! " +
                            " Your consultation fee is " + consultationFee);

                    SaveInFile();

                }else {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields");
                }
            }
        });

        return book;

    }

    private boolean DoctorAvailable() {
        for (Consultation consultation :
                consultationList) {
            if (consultation.get_timeSlot().equals(jComboBoxForTime.getSelectedItem()) &&
                    Objects.equals(comboBoxForDocName.getSelectedItem(), consultation.getDoctorName()) &&
                    LocalDate.parse(labelForDate.getText()).equals(consultation.get_date())) {
                nameOfTheSelectedDoctor = (String) comboBoxForDocName.getSelectedItem();
                return true;
            }
        }
        return false;
    }

    private double calculateConsultationFee( String fName, String lName) {
        // Search for patient in the list
        for (Patient patient : patientList) {
            if (fName.equalsIgnoreCase(patient.getName()) && lName.equalsIgnoreCase(patient.getSurname())) {
                // Return £25 for returning patients
                return 25.0;
            }
        }
        // Return £15 for new patients
        return 15.0;
    }

    private JButton ListOfAppointments() {
        JButton listOfAppointment = new JButton("List of Appointments");
        listOfAppointment.setBounds(650, 700, 300, 50);
        listOfAppointment.setFont(new Font("Times New Roman", Font.BOLD,20));
        listOfAppointment.setBackground(new Color(134, 213, 148));
        listOfAppointment.addActionListener(ae -> {
            if (ae.getSource() == listOfAppointment) {
                new AppointmentsGUI();
                dispose();
            }
        });
        return listOfAppointment;
    }

    private JButton ResetBtn() {
        JButton reset = new JButton("Reset");
        reset.setBounds(1070, 700, 90, 50);
        reset.setFont(new Font("Times New Roman", Font.BOLD,20));
        reset.setBackground(new Color(134, 213, 148));
        reset.setForeground(Color.RED);
        reset.addActionListener(ae -> {
            if (ae.getSource() == reset) {
                ResetData();
            }
        });
        return reset;
    }

    private void ResetData() {
        String def = "";
        textFieldForFName.setText(def);
        textFieldForLname.setText(def);
        textFieldForMobile.setText(def);
        labelForDate.setText(String.valueOf(LocalDate.now()));
        labelForDate.setText(def);
        textAreaForNotes.setText(def);
        labelForDate.setText(def);
        textAreaForNotes.setText(def);
    }

    public static void SaveInFile() {
        try {
            FileOutputStream fo = new FileOutputStream("PatientList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Patient patient :
                    patientList) {
                oos.writeObject(patient);
            }
            fo.close();
            oos.close();


            FileOutputStream fo1 = new FileOutputStream("Consultation.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fo1);

            for (Consultation consultation :
                    consultationList) {
                oos1.writeObject(consultation);
            }
            fo1.close();
            oos1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void LoadFromFile() {
        try {
            FileInputStream fis = new FileInputStream("PatientList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileInputStream fis1 = new FileInputStream("Consultation.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            while (true) {
                try {
                    Patient patient = (Patient) ois.readObject();
                    Consultation consultation = (Consultation) ois1.readObject();
                    patientList.add(patient);
                    consultationList.add(consultation);
                } catch (Exception e) {
                    break;
                }
            }
            fis1.close();
            ois1.close();
            fis.close();
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
