import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class extract_names {

    public static Resultmaps extract_name(String file) throws FileNotFoundException {
        HashMap<String, Integer> doctors = new HashMap<>();
        HashMap<String, Integer> patients = new HashMap<>();
        // specialty maps
        HashMap<String, String> doctorSpecialty = new HashMap<>();
        HashMap<String, String> patientSpecialty = new HashMap<>();
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("type")) continue;

                String[] arr = line.split(",");

                String type = arr[0].trim();
                String name = arr[1].trim();
                String specialty = arr[2].trim();
                int hours = Integer.parseInt(arr[3].trim());

                if (type.equalsIgnoreCase("doctor")) {
                    doctors.put(name, hours);
                    doctorSpecialty.put(name, specialty);
                } else {
                    patients.put(name, hours);
                    patientSpecialty.put(name, specialty);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        // RETURN ALL 4 MAPS
        return new Resultmaps(doctors, patients, doctorSpecialty, patientSpecialty);
    }
}
