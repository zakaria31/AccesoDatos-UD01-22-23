package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MP3 {
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
                /*System.out.println("Titulo -> " );
                System.out.println("Artista -> ");
                System.out.println("Álbum -> ");
                System.out.println("Pista -> ");
                System.out.println("Anyo -> ");
                System.out.println("Comentario -> ");
                System.out.println("Género -> ");*/
            }


            Charset charset = StandardCharsets.ISO_8859_1;

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

                raf.seek(+1);
                byte[] numPista = new byte[1];
                raf.read(numPista);
                String numeroPista = new String(numPista);

                byte[] genero = new byte[1];
                raf.read(genero);
                String gener = new String(genero);

                System.out.println("Titulo -> " + tituloT);
                System.out.println("A");

                raf.close();

            }


        } catch (IOException e) {
            System.out.println("Error -> " + e.getMessage());
        }

    }
    public static void EscribitMP3(String nombreArchivo){
        try {
            File f = new File("src/main/resources/" + nombreArchivo);
            FileOutputStream escritura = new FileOutputStream(f);

        } catch (FileNotFoundException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}