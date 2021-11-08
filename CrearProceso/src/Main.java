import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ponemos como parámetro de ruta por defecto el ejecutable de acrobat
        String path = "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
        String fileName;
        fileName = getUserPath(sc);
        System.out.println(fileName);
        ProcessLauncher processLauncher = new ProcessLauncher();
        Process process = processLauncher.launch(path, fileName);
        System.out.printf("Lanzado el proceso %s", process.pid());
    }

    /**
     * Metodo que pide al usuario la ruta del archivo a abrir.
     *
     * @param sc
     * @return
     */
    public static String getUserPath(Scanner sc) {
        System.out.println("Por favor, introduzca la ruta del archivo a abrir: ");
        String fileName = sc.nextLine();
        return fileName;

    }
}
