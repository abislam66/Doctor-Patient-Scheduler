
import java.util.HashMap;
import java.util.List;
//CHOOSING DOCTOR WITH AVAILABLE HOURS
public class getindex {
    public static Integer index(int index_of_patient, List<HashMap.Entry<String, Integer>> list_of_patients, List<HashMap.Entry<String, Integer>> list_of_doctors) {
        int index=-1;
        int remaining_hours = 1000000;
        int patientHours = list_of_patients.get(index_of_patient).getValue();
        for (int j = 0; j < list_of_doctors.size(); j++) {
            int doctorHours = list_of_doctors.get(j).getValue();
            if (doctorHours >= patientHours) {
                if (doctorHours < remaining_hours) {
                    remaining_hours = doctorHours;
                    index = j;
                }
            }
        }
            return index;
        }
    }
