package org.example;

import java.io.*;

public class MP3 {
    public static void leerInfo(String direccion) {
        File cancion = new File(direccion);
        try (RandomAccessFile raf = new RandomAccessFile(cancion, "r")) {

            raf.seek(raf.length() - 128);

            byte[] bytes = null;

            bytes = new byte[3];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[30];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[4];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[28];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            bytes = new byte[1];
            raf.read(bytes);
            System.out.println(new String(bytes, "UTF-8"));


        } catch (Exception e) {

        }


    }

    public static void escribirInfo() {

    }
}
