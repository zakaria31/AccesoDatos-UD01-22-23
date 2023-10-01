package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MP3 {
    static Scanner sc = new Scanner(System.in);
    public static void LeerInfoMP3(String nombreArchivo) {
        try {

            File f;

            if (nombreArchivo.endsWith(".txt")) {
                f = new File("src/main/resources/" + nombreArchivo);
            } else {
                f = new File("src/main/resources/" + nombreArchivo + ".txt");
            }

            BufferedReader lecturaFichero = new BufferedReader(new FileReader(f));

            ArrayList<String> lineas = new ArrayList<>();
            String linea;

            do {
                linea = lecturaFichero.readLine();
                if (linea != null && !linea.isBlank() && !linea.isEmpty()) {
                    lineas.add(linea);
                }
            } while (linea != null);

            lecturaFichero.close();

            for (String li: lineas) {
                System.out.println(li);
            }

            System.out.println("\n--------------------------------------------------");

            for (String l: lineas){
                File f2 = new File(l);
                RandomAccessFile raf = new RandomAccessFile(f2, "r");

                long posicion = raf.length();
                long puntero = posicion - 128;
                raf.seek(puntero + 3); //El "+3" es porque queremos leer a partir del titulo,
                                           // por lo que los 3 bytes de la cabecera, los saltamos.

                byte[] titulo = new byte[30];
                raf.read(titulo);
                String tituloT = new String(titulo);

                byte[] artista = new byte[30];
                raf.read(artista);
                String artist = new String(artista);

                byte[] album = new byte[30];
                raf.read(album);
                String alb = new String(album);

                byte[] anyo = new byte[4];
                raf.read(anyo);
                String year = new String(anyo);

                byte[] comentario = new byte[28];
                raf.read(comentario);
                String comment = new String(comentario);

                //raf.seek(+1); //Sumamos 1, porque (tiene numero pista) no nos hace falta saberlo, y como ocupa 1byte, pues sumamos 1
                byte [] a = new byte[1];
                raf.read(a);
                String tnp = new String(a);

                byte[] genero = new byte[1];
                raf.read(genero);
                String gener = new String(genero);

                byte[] numPista = new byte[1];
                raf.read(numPista);
                String numeroPista = new String(numPista);

                System.out.println("Titulo -> " + tituloT);
                System.out.println("Artista -> " + artist);
                System.out.println("Álbum -> " + alb);
                System.out.println("Numero Pista -> " + numeroPista);
                System.out.println("Año -> " + year);
                System.out.println("Comentario -> " + comment);
                System.out.println("Género -> " + gener);
                System.out.println("--------------------------------------------------");

                raf.close();
            }

            System.out.println("\n");

        }catch (FileNotFoundException ex){
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Error -> " + e.getMessage());
        }

    }
    public static void EscribirMP3(String nombreArchivo){
        try {
            File f;

            if (nombreArchivo.endsWith(".txt")) {
                f = new File("src/main/resources/" + nombreArchivo);
            } else {
                f = new File("src/main/resources/" + nombreArchivo + ".txt");
            }

            BufferedReader lecturaFichero = new BufferedReader(new FileReader(f));

            ArrayList<String> lineas = new ArrayList<>();
            String linea;

            do {
                linea = lecturaFichero.readLine();
                if (linea != null && !linea.isBlank() && !linea.isEmpty()) {
                    lineas.add(linea);
                }
            } while (linea != null);

            lecturaFichero.close();

            System.out.println("\n--------------------------------------------------");

            for (String l: lineas){
                File f2 = new File(l);
                RandomAccessFile raf = new RandomAccessFile(f2, "rw");

                String titulo, anyo, numPista, comentario;

                //Titulo
                System.out.print("Título -> ");
                titulo = sc.nextLine();

                //Numero Pista
                System.out.print("\tNúmero de pista -> ");
                numPista = sc.nextLine();

                //Año
                System.out.print("\tAño -> ");
                anyo = sc.nextLine();

                //Comentario
                System.out.print("\tComentario -> ");
                comentario = sc.nextLine();

                System.out.println("--------------------------------------------------");

                long posicion = raf.length();
                long puntero = posicion - 128;
                raf.seek(puntero + 3); //El "+3" es porque queremos leer a partir del titulo,
                // por lo que los 3 bytes de la cabecera, los saltamos.

                byte[] title = new byte[30];
                title = titulo.getBytes();
                raf.write(title);
                //raf.writeBytes(titulo);


                raf.seek(puntero + 93);//Sumamos 60 para introducir directamente el anyo
                byte[] year = new byte[4];
                year = anyo.getBytes();
                raf.write(year);
                //raf.writeBytes(anyo);

                byte[] comment = new byte[28];
                comment = comentario.getBytes();
                raf.write(comment);
                //raf.writeBytes(comentario);


                raf.seek(puntero+127);//Sumamos el byte de Tiene Número Pista y del género
                byte[] trackNumber= new byte[1];
                trackNumber = numPista.getBytes();
                raf.write(trackNumber);
                //raf.writeBytes(numPista);

                raf.close();
            }

            System.out.println("\n");

        } catch (FileNotFoundException ex){
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ioex){
            System.out.println("Error -> " + ioex.getMessage());
        }
    }
}