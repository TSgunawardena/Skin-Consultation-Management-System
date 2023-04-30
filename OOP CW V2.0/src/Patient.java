import java.io.Serializable;
import java.time.LocalDate;

public class Patient extends Person implements Serializable {

    private int patientID;

    public Patient(String name, String surname, LocalDate date, String mobileNumber, int patientID) {
        super(name, surname, date, mobileNumber);
        this.patientID = patientID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public int compareTo(Doctor o) {
        return 0;
    }
}
