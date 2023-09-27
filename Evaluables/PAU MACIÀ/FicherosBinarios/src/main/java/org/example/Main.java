package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int eleccion=0;
        do {


            System.out.println("1. Leer info. MP3");
            System.out.println("2. Escribir info. MP3");
            System.out.println("3. Salir");
            System.out.println("\nElige una opción: ");
            eleccion=sc.nextInt();
            if (eleccion==1){
                leerInfo();
            } else if (eleccion==2) {
                MP3.escribirInfo();
            } else if (eleccion==3) {
                return;
            }
        }while (eleccion<1 || eleccion>3);
    }

    public static void leerInfo(){
        try (BufferedReader lectura = new BufferedReader(new FileReader("direcciones.txt"))){
            String linea = null;
            do{
                linea = lectura.readLine();
                if (linea!=null){
                    MP3.leerInfo(linea);
                }

            }while(linea!=null);
        }catch (Exception e){

        }
    }


}