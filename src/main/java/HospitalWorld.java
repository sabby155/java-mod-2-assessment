import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospitalWorld {
    // Simple logging method
    public static void log(String message) {
        System.out.println(message);
    }

    // Main runner method

    public static void main(String[] args) {
        // Initiate

        log("Hello! Let's manage a hospital together.");

        // Initiate hospital - with a user-selected name

        log("What would you like to call this hospital?");
        String userHospitalName = getUserInput();
        log("You chose to call this hospital '" + userHospitalName + "'. Cool.");

        // Create hospital with user-selected name
        Hospital userHospital = new Hospital(userHospitalName);

        // Initialize user-selection of Doctors - with name, employer and specialty

        log("Let's add some Doctors to this hospital.");
        log("How many Doctors would you like to add?");

        try {

            int amountOfDoctorsWanted = Integer.parseInt(getUserInput());
            int doctorsAdded = 0;

            log("Okay. You want to add " + amountOfDoctorsWanted + " Doctor(s) to this hospital. Ambitous!");

            while (doctorsAdded < amountOfDoctorsWanted) {

                // Doctor name selection

                log("Please provide Doctor name.");
                String userDoctorName = getUserInput();
                log("This Doctor's name is " + userDoctorName);

                // Grab hospital's pre-defined list of specialties

                String[] userHospitalSpecialties = userHospital.getSpecialtiesList();
                log("Please choose this Doctor's specialty from the hospital's " + userHospitalSpecialties.length
                        + " specializations: ");

                // Specific specialty-selecion printer

                int counter = 1;
                for (String specialty : userHospitalSpecialties) {
                    log("Choose '" + (counter++) + "' for " + specialty);
                }

                // Doctor specialty selection

                int userDoctorSelection = Integer.parseInt(getUserInput());

                if (userDoctorSelection <= 4) {
                    String userDoctorSpecialty = userHospitalSpecialties[userDoctorSelection - 1];
                    log("You selected: " + userDoctorSpecialty);

                    // Create Doctor with user-selected name, specialty and hospital

                    Doctor newDoctor = new Doctor(userDoctorName, userDoctorSpecialty, userHospitalName);

                    log("Dr. " + newDoctor.getName() + " from the " + newDoctor.getSpecialty()
                            + " department is in the system.");

                    // Add this Doctor to the user's hospital list of doctors

                    userHospital.addDoctor(newDoctor);

                    // Print that hospital's list of doctors

                    userHospital.printDoctorsList();

                    // Increment Doctor counter

                    doctorsAdded++;
                } else {
                    log("Something went wrong");
                    return;
                }

            }

        } catch (NumberFormatException e) {
            log("Are you sure you picked a number?");
            return;
        }

        // Initialize user-selection of Patients - with name and symptom

        log("Let's add some Patients to this hospital.");
        log("How many Patients would you like to add?");

        try {
            int amountOfPatientsWanted = Integer.parseInt(getUserInput());
            int patientsAdded = 0;

            while (patientsAdded < amountOfPatientsWanted) {

                // Initiate user-defined patient - with name and symptom attributes

                log("Please provide Patient name.");
                String userPatientName = getUserInput();
                log("This Patient's name is " + userPatientName);

                // Grab hospital's pre-defined list of symptoms

                String[] userHospitalSymptoms = userHospital.getSymptomsList();
                log("Please choose a symptom from one of the " + userHospitalSymptoms.length
                        + " main symptoms we treat");

                // Specific symptom-selecion printer

                int symptomCounter = 1;
                for (String symptom : userHospitalSymptoms) {
                    log("Choose '" + (symptomCounter++) + "' for " + symptom);
                }

                // Patient symptom selection

                int userSymptomSelection = Integer.parseInt(getUserInput());

                if (userSymptomSelection <= 4) {
                    String userPatientSymptom = userHospitalSymptoms[userSymptomSelection - 1];
                    log("You selected: " + userPatientSymptom);

                    // Create Patient with user-selected name and symptom

                    Patient newPatient = new Patient(userPatientName, userPatientSymptom);

                    // Check if we have a Doctor to match this patient's symptoms

                    userHospital.matchPatientWithDoctor(newPatient, userSymptomSelection);

                    // Cobfirm patient registry either way

                    log(newPatient.getName() + " is now in our system.");

                    // Increment Patientcounter

                    patientsAdded++;

                } else {
                    log("Something went wrong");
                    return;
                }

            }

        } catch (NumberFormatException e) {
            log("Are you sure you picked a number?");
            return;
        }

        getAllHospitalInfo(userHospital);
    }

    private static void getAllHospitalInfo(Hospital hospital) {
        log("+---~~~+-------------------------~~~---+");

        log("It's time to display all the info from the hospital");

        // Print Hospital object details

        String hospitalName = hospital.getName();
        log("Hospital name: " + hospitalName);

        hospital.printSpecialtiesList();

        hospital.printDoctorsList();

        // Print Hospital's Doctor object details

        List<Doctor> doctors = hospital.getDoctorsList();

        for (Doctor doctor : doctors) {
            log("Dr. " + doctor.getName() + "'s " + "specialty is " + doctor.getSpecialty());
            log("Dr. " + doctor.getName() + "'s " + "employer is " + doctor.getHospitalEmployer());
            doctor.printPatientsList();
        }

        hospital.printPatientsList();

        // Print Hospital's Patient object details

        List<Patient> patients = hospital.getPatientsList();

        for (Patient patient : patients) {
            log("Patient " + patient.getName() + "'s " + "symptoms is " + patient.getSymptom());
        }

        log("+---~~~+-------------------------~~~---+");
    }

    private static String getUserInput() {
        try {
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            return userInput;
        } catch (InputMismatchException e) {
            return null;
        }
    }

}
