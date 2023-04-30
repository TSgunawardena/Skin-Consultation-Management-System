import java.io.Serializable;
import java.time.LocalDate;



public class Consultation implements Serializable {
    private final String doctorName;
    private final LocalDate date;
    private final String timeSlot;
    private String notes;
    private final double cost;




    public Consultation (String name, LocalDate date, String time, String notes, double costOfTheConsultation){
        this.doctorName = name;

        this.date = date;
        this.timeSlot = time;
        this.notes = notes;
       this.cost = costOfTheConsultation;
    }
    public String get_timeSlot() {
        return timeSlot;
    }

    public double get_cost() {
        return cost;
    }

    public String get_notes() {
        return notes;
    }

    public void set_notes(String _notes) {
        this.notes = _notes;
    }

    public String getDoctorName(){
        return doctorName;
    }
    public LocalDate get_date(){
        return date;
    }
}
