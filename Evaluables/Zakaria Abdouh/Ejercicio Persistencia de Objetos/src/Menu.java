import java.io.*;
import java.util.*;

public class Menu {

        private int opcion;

        public void mostrar() {
            System.out.println("**MI VIDEOCLUB**");
            System.out.println("------------------");
            System.out.println("        ");
            System.out.println("Menú: ");
            System.out.println("1. Insertar Película");
            System.out.println("2. Modificar Película");
            System.out.println("3. Eliminar Pelicula");
            System.out.println("4. Visualizar Pelicula");
            System.out.println("5. Salir");

        }

        public int leerOpcion() {
            do {
                opcion = leerEntero("Seleccione una opción: ");
            } while (opcion < 0 || opcion > 5);
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
