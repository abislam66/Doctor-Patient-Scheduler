import java.util.HashMap;

public class Resultmaps {
    public HashMap<String, Integer> map1;  // doctors → hours
    public HashMap<String, Integer> map2;  // patients → hours

    public HashMap<String, String> docSpec; // doctor → specialty
    public HashMap<String, String> patSpec; // patient → specialty

    public Resultmaps(
            HashMap<String, Integer> map1,
            HashMap<String, Integer> map2,
            HashMap<String, String> docSpec,
            HashMap<String, String> patSpec
    ) {
        this.map1 = map1;
        this.map2 = map2;
        this.docSpec = docSpec;
        this.patSpec = patSpec;
    }
}
