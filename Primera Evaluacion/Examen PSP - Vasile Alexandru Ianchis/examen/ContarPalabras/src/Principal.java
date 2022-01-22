import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path booksPath = Paths.get(System.getProperty("user.dir"), "library");
        String classPath = System.getProperty("user.dir") + File.separator + "out" + File.separator +
                "production" + File.separator + "ContarPalabras";
        File bookFile = new File(String.valueOf(booksPath));
        BufferedReader br1;
        File[] library = bookFile.listFiles();
        // First book
        ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", classPath, WordCounter.class.getName(), library[0].toString());
        Process p1 = pb1.start();
        br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        System.out.println(br1.readLine());
        // Second book
        ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", classPath, WordCounter.class.getName(), library[1].toString());
        Process p2 = pb2.start();
        br1 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        System.out.println(br1.readLine());
        // Third book
        ProcessBuilder pb3 = new ProcessBuilder("java", "-cp", classPath, WordCounter.class.getName(), library[2].toString());
        Process p3 = pb3.start();
        br1 = new BufferedReader(new InputStreamReader(p3.getInputStream()));
        System.out.println(br1.readLine());
        // Fourth book
        ProcessBuilder pb4 = new ProcessBuilder("java", "-cp", classPath, WordCounter.class.getName(), library[3].toString());
        Process p4 = pb4.start();
        br1 = new BufferedReader(new InputStreamReader(p4.getInputStream()));
        System.out.println(br1.readLine());
        // wait for
        p1.waitFor();
        p2.waitFor();
        p3.waitFor();
        p4.waitFor();

    }
}

