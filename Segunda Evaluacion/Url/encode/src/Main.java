import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String original = "THe string ü@foo-bar";
        // en java 8 hay que pasar el charset con el metodo toString
        String encoded = URLEncoder.encode(original, StandardCharsets.UTF_8);
        System.out.println(original);
        System.out.println(encoded);
    }
}
