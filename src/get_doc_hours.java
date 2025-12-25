import java.util.HashMap;
import java.util.List;

//GETTING DOCTOR HOURS
public class get_doc_hours {
    public static Integer check_hours(List<HashMap.Entry<String, Integer>> list){
        int total=0;
        for(int i=0;i<list.size();i++){
            total+=list.get(i).getValue();
        }
        return total;
    }
}
