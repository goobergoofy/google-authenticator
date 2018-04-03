import java.io.File;
import java.util.Random;

public class finalNameClass {

    Random rand = new Random();
    String current_user = System.getProperty("user.name");

    private String final_name = "entry.json";
    private File entry_file = new File("/Users/" + current_user + "/Documents/entry.json");
    private File renamed_file = new File("/Users/" + current_user + "/Documents/" + final_name);

    public String getFinal_name() {
        return final_name;
    }
    public File getEntry_file() {
        return entry_file;
    }
    public File getRenamed_file() {
        return renamed_file;
    }

}
