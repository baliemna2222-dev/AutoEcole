package AutoEcole;
import com.google.gson.Gson;

public class Testjson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson("Hello JSON");
        System.out.println(json);
    }
}