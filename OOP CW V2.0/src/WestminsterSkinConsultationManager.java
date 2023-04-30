import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    public static WestminsterSkinConsultationManager skinSystem = new WestminsterSkinConsultationManager();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    static final int MAX_DOCTORS = 10;

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in); // Scanner to read user input
        skinSystem.loadData(); // Load data from file
        System.out.println("\n\n" +

                "_ _ _ ____ ____ _  _ _ _  _ _ ____ ___ ____ ____    ____ _  _ _ _  _    ____ ____ _  _ ____ _  _ _    ___ ____ ___ _ ____ _  _    _  _ ____ _  _ ____ ____ ____ ____ \n" +
                "| | | |___ [__  |\\/| | |\\ | | [__   |  |___ |__/    [__  |_/  | |\\ |    |    |  | |\\ | [__  |  | |     |  |__|  |  | |  | |\\ |    |\\/| |__| |\\ | |__| | __ |___ |__/ \n" +
                "|_|_| |___ ___] |  | | | \\| | ___]  |  |___ |  \\    ___] | \\_ | | \\|    |___ |__| | \\| ___] |__| |___  |  |  |  |  | |__| | \\|    |  | |  | | \\| |  | |__] |___ |  \\ \n" +
                "                                                                                                                                                                     \n");


        while (true) {

            System.out.println("""
                                        
                                        
                      / \\\\ / \\\\ / \\\\ / \\\\ \\ 
                        ( M | E | N | U )
                      \\\\_/ \\\\_/ \\\\_/ \\\\_/ \\
                    A -   Add Doctor
                    D -   Delete Doctor
                    P -   Print Doctors
                    S -   Save
                    G -   GUI
                    E -   Exit
                    Enter your Selection:
                    """);

            String menu = read.nextLine();

            switch (menu) {
                case "A" -> skinSystem.addDoctor(); //add doctor
                case "D" -> skinSystem.deleteDoctor(); //delete doctor
                case "P" -> skinSystem.printDoctor(); //print doctors
                case "S" -> skinSystem.saveData(); //save data
                case "G" -> {
                    ConsultationGUI.LoadFromFile(); //load data
                    new HomeGUI();
                }
                case "E" -> System.exit(0); //exit the program
                default -> System.out.println("Enter the correct option");

            }

        }

    }


    public void addDoctor() {
        Scanner scanner = new Scanner(System.in);
        if (doctors.size() < MAX_DOCTORS) {


            String name = StringInputValidation("First Name", "Names");
            String sureName = StringInputValidation("Last name", "Names");
            LocalDate dob = DateValidator();
            String phoneNumber = StringInputValidation("Phone Number", "Phone");
            String medicalLicenceNumber = StringInputValidation("Medical Licence Number", "Medical Licence Number");
            String specialization = "";
            boolean validSpecialization = false;

            while (!validSpecialization) {
                System.out.println("Select doctor's specialization from options below: ");
                System.out.println("""
                        \t1. Cosmetic Dermatology
                        \t2. Medical Dermatology
                        \t3. Paediatric Dermatology
                        \t4. Surgical Dermatology
                        """);
                System.out.print("Enter option: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    specialization = "Cosmetic Dermatology";
                    validSpecialization = true;
                } else if (choice == 2) {
                    specialization = "Medical Dermatology";
                    validSpecialization = true;
                } else if (choice == 3) {
                    specialization = "Paediatric Dermatology";
                    validSpecialization = true;
                } else if (choice == 4) {
                    specialization = "Surgical Dermatology";
                    validSpecialization = true;
                } else {
                    System.out.println("Invalid option! Please try again. \n");
                }
            }
            doctors.add(new Doctor(name, sureName, dob, phoneNumber, medicalLicenceNumber, specialization));
        }
        else {
            System.out.println("Maximum number of doctors reached!");

        }

    }


    public void deleteDoctor() {
        Scanner read = new Scanner(System.in);

        int count = 0;
        for (Doctor details : doctors) {
            count++;
            System.out.println("Doctor " + count + "    - " + details.getName() + " " + details.getSurname() + "   - " + details.getMedicalLicenceNumber());
        }


        String deleteNumber = StringInputValidation("Medical Licence Number", "Medical Licence Number");
        int counter = 0;

        for (int i = 0; i < doctors.size(); i++) {
            if (deleteNumber.equals(doctors.get(i).getMedicalLicenceNumber())) {
                showDoctor(doctors.get(i), i + 1, 4);
                System.out.println("------ The Doctor Has Been Removed ------\n\n");
                doctors.remove(i);
                break;
            } else counter = counter + 1;
            if (counter == doctors.size()) {
                System.out.println("No Medical License Number Found");
            }

        }

    }

    public void printDoctor() {
//        doctors.add(new Doctor("Tharusha", "Gunawardena", LocalDate.of(2001, 1, 23), "0771266006", "123456789","Paediatric Dermatology" ));
//        doctors.add(new Doctor("saminda", "gune", LocalDate.of(1845, 4, 12), "0773053181", "789465132","Surgical Dermatology" ));
//        doctors.add(new Doctor("peter", "parker", LocalDate.of(1910, 6, 13), "0779786145", "741852963","Cosmetic Dermatology" ));
//        doctors.add(new Doctor("dia", "teeksana", LocalDate.of(1973, 4, 30), "0777645123","369258147", "Medical Dermatology" ));
//        doctors.add(new Doctor("mahinda", "rajapaksha", LocalDate.of(1999, 12, 4), "0717897413","987654321","Surgical Dermatology" ));
//        doctors.add(new Doctor("Kimi", "Raikkonen", LocalDate.of(1981, 05, 28), "0771472583","363741258", "Surgical Dermatology" ));
//        doctors.add(new Doctor("basil", "Rajapaksha", LocalDate.of(1966, 12, 31), "0789637891", "753159789","Surgical Dermatology" ));
//        doctors.add(new Doctor("ken", "block", LocalDate.of(1989, 04, 18), "0781597535", "741846563","Cosmetic Dermatology" ));
//        doctors.add(new Doctor("Sebastian", "Vettel", LocalDate.of(1899, 06, 03), "0713571598", "753963741","Paediatric Dermatology" ));
//        doctors.add(new Doctor("namal", "rajapaksha", LocalDate.of(2002, 2, 8), "0775196244", "945612371","Medical Dermatology"));

        Doctor[] sorted = doctors.toArray(new Doctor[doctors.size()]);

        Arrays.sort(sorted, new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareToIgnoreCase(d2.getSurname());
            }
        });

        for (int i = 0; i < sorted.length; i++) {
            System.out.println("Doctor " + (i + 1));
            System.out.println(sorted[i]);
        }       System.out.println("------ The Doctors Have Been Printed ------\n\n");

    }

    public void saveData() {
        try {

            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("database.txt"));

            for (Doctor details : doctors) {
                objectOutput.writeObject(details);
            }
            objectOutput.close();
            System.out.println("""
                                       
                               DATA SAVED
                                       
                    """);

        } catch (IOException e) {
            System.out.println("   _   _   _   _   _  \n" +
                    "  / \\ / \\ / \\ / \\ / \\ \n" +
                    " ( E | R | R | O | R )\n" +
                    "  \\_/ \\_/ \\_/ \\_/ \\_/ ");

        }

    }


    public void loadData() {
        doctors.clear();

        try {
            FileInputStream fileInput = new FileInputStream("database.txt");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            while (fileInput.available() > 0) {
                doctors.add((Doctor) objectInput.readObject());
            }

            objectInput.close();

            System.out.println("""
                                      
                                DATA LOADED
                                        
                    """);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("   _   _   _   _   _  \n" +
                    "  / \\ / \\ / \\ / \\ / \\ \n" +
                    " ( E | R | R | O | R )\n" +
                    "  \\_/ \\_/ \\_/ \\_/ \\_/ ");
        }
    }


    private void showDoctor(Doctor details, int number, int detailCount) {

        String[] Data = {"First Name           -   ", "Surname             -   ", "Date of Birth       -   ", "Phone Number        -   ", "Medical Reg No      -   ", "Specialization      -   "};
        String[] content = {details.getName(), details.getSurname(), String.valueOf(details.getDob()), details.getMobileNumber(), String.valueOf(details.getMedicalLicenceNumber()), details.getSpecialisation()};
        System.out.println("\n---------------     Doctor " + number + " Details     ---------------");
        for (int i = 0; i < detailCount; i++) {
            System.out.println(Data[i] + content[i]);
        }
        System.out.println("----------------------------------------------------\n");

    }


    private String StringInputValidation(String details, String display) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the " + details + " : ");
        String input = scanner.next();
        if (display.equals("Names")) {
            while (!input.matches("[a-zA-Z]+")) {
                System.out.println(input + " Can Only Contain Letters Enter The " + input + " again : ");
                input = scanner.nextLine();
            }
            return input;
        } else if (display.equals("Phone")) {
            while (!(input.matches("[0-9]+") && (input.length() == 10))) {
                System.out.println("Invalid Format \nEnter the Phone Number Again :");
                input = scanner.nextLine();
            }
            return input;
        } else if (display.equals("Medical Licence Number")) {
            while (!(input.matches("[\\w ]+"))) {
                System.out.println("Invalid Format \nEnter the Medical Licence Number Again :");
                input = scanner.nextLine();
            }
            return input;
        } else return input;

    }


    private LocalDate DateValidator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of Birth (yyyy-mm-dd) : ");
        String dateStr = scanner.nextLine();

        while (true) {
            try {
                LocalDate.parse(dateStr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Enter the date in Correct Format [yyyy-mm-dd]");
                dateStr = scanner.nextLine();
            }
        }

        return LocalDate.parse(dateStr);
    }

    private static int IntValidation(Scanner read) {
        int integer;
        while (true) {
            try {
                integer = read.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please Enter the Input again :");
                read.next();
            }
        }
        return integer;
    }

}
