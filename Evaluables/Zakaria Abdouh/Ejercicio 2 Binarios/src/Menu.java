import java.io.*;
import java.util.*;

public class Menu {

        private int opcion;

        public void mostrar() {
            System.out.println("**GESTIÓN DE MÚSICA MP3**");
            System.out.println("1. Leer Info. MP3");
            System.out.println("2. Escribir Info. MP3");
            System.out.println("3. SALIR");
            System.out.println("0. FIN");
        }

        public int leerOpcion() {
            do {
                opcion = leerEntero("Introduzca opción: ");
            } while (opcion < 0 || opcion > 3);
            return opcion;
        }

        public static int leerEntero(String s) {
            Scanner sc = new Scanner(System.in);
            boolean repetir;
            int n = 0;
            do {
                repetir = false;
                try {
                    System.out.print(s);
                    n = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Valor de menú no válido");
                    repetir = true;
                    sc.nextLine();
                }
            } while (repetir);
            return n;
        }


}
