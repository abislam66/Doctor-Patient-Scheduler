import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Scheduler {

    public static boolean Schedule(int index, List<HashMap.Entry<String, Integer>> patientList, List<HashMap.Entry<String, Integer>> doctorList, HashMap<String, HashSet<String>> schedule, HashMap<String, String> docSpec, HashMap<String, String> patSpec) {
        if (index == patientList.size()) return true;
        String patient = patientList.get(index).getKey();
        int need = patientList.get(index).getValue();
        for (int i = 0; i < doctorList.size(); i++) {
            String doctor = doctorList.get(i).getKey();
            int hoursLeft = doctorList.get(i).getValue();
            //  SPECIALTY CHECK
            if (!docSpec.get(doctor).equalsIgnoreCase(patSpec.get(patient))) {
                continue;
            }//AVAILABLE HOURS CHECK
            if (hoursLeft < need) continue;
            // choose
            doctorList.get(i).setValue(hoursLeft - need);
            schedule.putIfAbsent(doctor, new HashSet<>());
            schedule.get(doctor).add(patient);
            // recurse
            if (Schedule(index + 1, patientList, doctorList, schedule, docSpec, patSpec))
                return true;
            // undo
            doctorList.get(i).setValue(hoursLeft);
            schedule.get(doctor).remove(patient);
        }
        return false;
    }
}
