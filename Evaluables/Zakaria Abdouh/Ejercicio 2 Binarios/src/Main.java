import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int opcion;
        menu.mostrar();
        opcion = menu.leerOpcion();
        while (opcion != 0 && opcion !=3) {
            switch (opcion) {
                case 0:
                    break;

                case 1:
                    System.out.println("Introduce la ruta del archivo que contiene la información:");
                    String ruta = sc.nextLine();
                    MP3.leerInfo(ruta);
                    break;
                case 2:
                    System.out.println("Introduce la ruta del archivo mp3 de la cancion:");
                    String archivoesribir = sc.nextLine();
                    MP3.escribirInfo(archivoesribir);
                    break;


            }
        }
    }




}

