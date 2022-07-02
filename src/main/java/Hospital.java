import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private List<Doctor> doctorsList = new ArrayList<Doctor>(); // List of Doctor objects
    private List<Patient> patientsList = new ArrayList<Patient>(); // List of Patient objects
    private String[] specialtiesList = { "Dermatology", "Psychiatry",
            "Gastroenterology", "General Practioner" }; // List of pre-defined specialties
    private String[] symptomsList = { "Skin-related issue", "Mental/emotional issue",
            "Digestive issue", "Miscellaneous issue" }; // List of pre-defined symptoms

    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public String[] getSpecialtiesList() {
        return specialtiesList;
    }

    public String[] getSymptomsList() {
        return symptomsList;
    }

    public void printSpecialtiesList() {
        System.out.println("Specialty departments in " + this.name + " : ");
        for (String specialty : specialtiesList) {
            System.out.println(specialty);
        }
    }

    public void printDoctorsList() {
        System.out.println("Doctors on rotation in " + this.name + " : ");
        for (Doctor doctor : doctorsList) {
            System.out.println(doctor.getName());
        }
    }

    public void printPatientsList() {
        System.out.println("Patients currently registered in: " + this.name + " : ");
        for (Patient patient : patientsList) {
            System.out.println(patient.getName());
        }
    }

    public void addDoctor(Doctor doctor) {
        doctorsList.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctorsList.remove(doctor);
    }

    public void matchPatientWithDoctor(Patient patient, int patientSymptomInt) {

        patientsList.add(patient);

        for (Doctor doctor : doctorsList) {

            String doctorSpecialty = doctor.getSpecialty();
            String patientSymptom = specialtiesList[patientSymptomInt - 1];

            if (doctorSpecialty == patientSymptom) {
                System.out.println("We have a doctor for this issue.");
                doctor.addPatient(patient);
            } else {
                continue;
            }

        }
    }

}
