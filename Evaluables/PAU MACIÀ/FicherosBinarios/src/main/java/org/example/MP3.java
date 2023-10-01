package org.example;

import java.io.*;
import java.util.Scanner;

public class MP3 {
    public static void leerInfo(String direccion) {
        File cancion = new File(direccion);
        try (RandomAccessFile raf = new RandomAccessFile(cancion, "r")) {

            raf.seek(raf.length() - 128);

            byte[] bytes = null;

            bytes = new byte[3];
            raf.read(bytes);
            System.out.println();
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println("Titulo: "+new String(bytes));
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println("Artista: "+new String(bytes));
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println("Album: "+new String(bytes));
            bytes = new byte[4];
            raf.read(bytes);
            System.out.println("Año: "+new String(bytes));
            bytes = new byte[28];
            raf.read(bytes);
            System.out.println("Comentario: "+new String(bytes));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println("Tiene numero pista: "+new String(bytes));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println("Número pista: "+new String(bytes));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println("Género: "+new String(bytes));


        } catch (Exception e) {
            System.out.println("Problema");
        }


    }

    public static void escribirInfo(String direccion) {
        Scanner sc = new Scanner(System.in);
        String comentario="";
        int anyo=0;
        int pista=0;
        File cancion = new File(direccion);
        try(RandomAccessFile raf = new RandomAccessFile(cancion, "r")){

            do{
                System.out.println("Escribe el número de pista: ");
                pista = sc.nextInt();
            }while(pista<1 || pista>9);

            do{
                System.out.println("Escribe el año de lanzamiento: ");
                anyo = sc.nextInt();
            }while(anyo<0 || anyo>9999);

            do{

            }while(comentario.length());

            System.out.println("Escribe un comentario: ");
            comentario = sc.nextLine();

        }catch (Exception e){
            System.out.println("Problema.");
        }

    }

}