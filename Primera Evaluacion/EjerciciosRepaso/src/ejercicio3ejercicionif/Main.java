package ejercicio3ejercicionif;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Nif nif = new Nif();
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduzca el número del dni");
        int dni = sc.nextInt();
        nif.read(dni);
        System.out.println(nif.toString());
    }
}
