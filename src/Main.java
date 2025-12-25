import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Final_project {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter CSV filename: ");
        String filename = input.nextLine();
        try {
            Resultmaps results = extract_names.extract_name(filename);
            HashMap<String, Integer> doctors = results.map1;
            HashMap<String, Integer> patients = results.map2;
            HashMap<String, String> docSpec = results.docSpec;
            HashMap<String, String> patSpec = results.patSpec;
            HashMap<String, HashSet<String>> schedule = new HashMap<>();

            //  PRINTING DOCTORS & PATIENTS
            System.out.println("\n===== INPUT DATA =====");
            // Print doctors
            for (String doc : doctors.keySet()) {
                System.out.println("doctor, " + doc + ", " +
                        docSpec.get(doc) + ", " +
                        doctors.get(doc));
            }
            // Print patients
            for (String pat : patients.keySet()) {
                HashSet<String> acceptable = new HashSet<>();
                for (String doc : doctors.keySet()) {
                    if (docSpec.get(doc).equalsIgnoreCase(patSpec.get(pat))) {
                        acceptable.add(doc);
                    }
                }
                System.out.println("patient, " + pat + ", " +
                        patSpec.get(pat) + ", "  +
                        patients.get(pat));
            }

            boolean possible = Schedule_Helper.get_schedule(doctors, patients, docSpec, patSpec, schedule);
            if (!possible) {
                System.out.println("\nNo schedule could be generated.");
            } else {
                System.out.println("\n FINAL SCHEDULE ");
                for (String doctor : schedule.keySet()) {
                    String specialty = docSpec.get(doctor);
                    for (String patient : schedule.get(doctor)) {
                        System.out.println(doctor +"("+ specialty + ")"+" sees " + patient);
                    }
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }
}
