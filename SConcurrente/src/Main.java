

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        StringBuilder cp = new StringBuilder();
        cp.append(System.getProperty("user.dir"));
        cp.append(File.separator);
        cp.append("out");
        cp.append(File.separator);
        cp.append("production");
        cp.append(File.separator);
        cp.append("Sconcurrente");
        cp.append(File.separator);

        ProcessBuilder processBuilder1 = new ProcessBuilder("java", "-cp", cp.toString(), Adder.class.getName(), "1", "500", "A");
        Process process1 = processBuilder1.start();
        ProcessBuilder processBuilder2 = new ProcessBuilder("java", "-cp", cp.toString(), Adder.class.getName(), "500", "1000", "B");
        Process process2 = processBuilder2.start();

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
        String result1 = bufferedReader1.readLine();
        System.out.println(String.format("Process 1 result is %s", result1));

        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
        String result2 = bufferedReader2.readLine();
        System.out.println(String.format("Process 2 result is %s", result2));

        process1.waitFor();
        process2.waitFor();
        System.out.println("Finished parent process");
    }
}