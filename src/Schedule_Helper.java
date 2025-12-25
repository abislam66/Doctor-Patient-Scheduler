import java.util.*;

public class Schedule_Helper {

    public static boolean get_schedule(
            HashMap<String, Integer> doctors,
            HashMap<String, Integer> patients,
            HashMap<String, String> docSpec,
            HashMap<String, String> patSpec,
            HashMap<String, HashSet<String>> schedule) {
        List<Map.Entry<String, Integer>> patientList = new ArrayList<>(patients.entrySet());
        patientList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        List<Map.Entry<String, Integer>> doctorList = new ArrayList<>(doctors.entrySet());
        boolean result = Scheduler.Schedule(0, patientList, doctorList, schedule, docSpec, patSpec);
        return result;
    }
}
