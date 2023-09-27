package org.example;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MP3 {

    public static void LeerInfoMP3(String nombreArchivo){
        try {
            File f = new File("src/main/resources/" + nombreArchivo);
            FileInputStream lectura = new FileInputStream(f);
            //DataInputStream dataInputStream = new DataInputStream(lectura);
            byte[] arrayBytes = new byte[(int)f.length()];

            lectura.read(arrayBytes);


        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }


    }

    public static void EscribitMP3(String nombreArchivo){
        try {
            File f = new File("src/main/resources/" + nombreArchivo);
            FileOutputStream escritura = new FileOutputStream(f);

        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }


}
