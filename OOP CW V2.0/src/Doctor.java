import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Person implements Serializable {

    private String medicalLicenceNumber;
    private String specialisation;


    public Doctor(String name, String surname, LocalDate date, String mobileNumber, String medicalLicenceNumber, String specialisation) {
        super(name, surname, date, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;

    }

    @Override
    public int compareTo(Doctor o) {
        return this.getSurname().compareToIgnoreCase(o.getSurname());
    }

    public String toString() {
        return "\tDoctors  Name            : " + getFullName() + "\n" +
                "\tDate of Birth           : " + getDob() + "\n" +
                "\tMobile Number           : " + getMobileNumber() + "\n" +
                "\tMedical License Number  : " + getMedicalLicenceNumber() + "\n" +
                "\tSpecialization          : " + getSpecialisation() + "\n";


    }
}







