
import java.io.IOException;
import java.util.Scanner;

public class ProcessLauncher {
    public Process launch(String path, String fileName) {
        ProcessBuilder processBuilder;
        try {
            /*
             se crea un objeto con dos parametros: la ruta del programa que abrirá el pdf, y la otra
             ruta hace referencia al archivo pdf que se quiere abrir.
             */
            processBuilder = new ProcessBuilder(path, fileName);

            return processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserPath(Scanner sc) {
        System.out.println("Por favor, introduzca la ruta del archivo a abrir: ");
        String fileName = sc.nextLine();
        return fileName;

    }
}
