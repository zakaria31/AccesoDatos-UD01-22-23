package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.RandomAccess;

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

            byte[] bytes;
            Charset charset = StandardCharsets.ISO_8859_1;
            int posicion, dato;
            String artista, album, comentario, genero;
            char[] cabecera = new char[3];
            char[] titulo = new char[30];
            char aux;
            int anyo, numeroPista;
            boolean tieneNumeroPista;

            for (String l: lineas){
                File f2 = new File(l);
                FileInputStream lecturaBinario = new FileInputStream(f);
                RandomAccessFile raf = new RandomAccessFile(f2, "r");
                //DataInputStream dataInputStream = new DataInputStream(lecturaBinario);
                bytes = new byte[(int) f2.length()];
                lecturaBinario.read(bytes);


                posicion = ((int)f2.length() - 128);
                raf.seek(posicion);
                for(int i = 0; i < cabecera.length; i++){
                    aux = raf.readChar();
                    cabecera[i] = aux;
                }

                for(int s = 0; s < titulo.length; s++){
                    aux = raf.readChar();
                    titulo[s] = aux;
                }
                String cabeceraA = new String(cabecera);
                String tituloT = new String(titulo);
                System.out.println("Cabecera -> " + cabeceraA);
                System.out.println("Titulo -> " + tituloT);
                System.out.println("A");

                lecturaBinario.close();


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