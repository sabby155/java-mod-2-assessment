import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialty;
    private String hospitalEmployer;
    private List<Patient> patientsList = new ArrayList<Patient>();

    public Doctor(String name, String specialty, String hospitalEmployer) {
        this.name = name;
        this.specialty = specialty;
        this.hospitalEmployer = hospitalEmployer;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getHospitalEmployer() {
        return hospitalEmployer;
    }

    public int getPatientsListSize() {
        return patientsList.size();
    }

    public void addPatient(Patient patient) {
        patientsList.add(patient);
        System.out.println("Successfully added " + patient.getName() + " to Dr. " + name + "'s roster.");
    }

    public void printPatientsList() {
        if (patientsList.isEmpty()) {
            System.out.println(name + " currently has no patients.");
        } else {
            System.out.println(name + "s " + "Patient list is now: ");
            for (Patient patient : patientsList) {
                System.out.println(patient.getName());
            }
        }
    }

}
