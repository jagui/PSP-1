import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();

        StringBuilder sb2 = new StringBuilder();
        sb.append("java");
        sb.append(" ");
        sb.append("-cp");
        sb.append(" ");
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append("out");
        sb.append(File.separator);
        sb.append("production");
        sb.append(File.separator);
        sb.append("SumaConcurrente");
        sb.append(" ");
        sb.append(Adder.class.getName());
        sb.append(" ");
        sb.append("1");
        sb.append(" ");
        sb.append("500");
        sb.append(" ");
        sb.append("A");
        // PROCESS TWO
        sb2.append("java");
        sb2.append(" ");
        sb2.append("-cp");
        sb2.append(" ");
        sb2.append(System.getProperty("user.dir"));
        sb2.append(File.separator);
        sb2.append("out");
        sb2.append(File.separator);
        sb2.append("production");
        sb2.append(File.separator);
        sb2.append("SumaConcurrente");
        sb2.append(" ");
        sb2.append(Adder.class.getName());
        sb2.append(" ");
        sb2.append("500");
        sb2.append(" ");
        sb2.append("1000");
        sb2.append(" ");
        sb2.append("B");
        String commandString = sb.toString();

        String commandString2 = sb2.toString();
        String[] command = commandString.split(" ");

        String[] command2 = commandString2.split(" ");
        ProcessBuilder processBuilder1 = new ProcessBuilder(command).inheritIO();
        Process process1 = processBuilder1.start();


        ProcessBuilder processBuilder2 = new ProcessBuilder(command2).inheritIO();
        Process process2 = processBuilder2.start();
        System.out.println("Parent process finished.");
        process1.waitFor();
        process2.waitFor();
        System.out.println("Parent process finished.");


    }
}
