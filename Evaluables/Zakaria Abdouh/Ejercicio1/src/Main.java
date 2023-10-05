
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
                //Abrimos el archivo que hemos creado anteriormente con los jugadores y las puntuaciones de cada jugador
                File ficentrada= new File("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio1\\src\\Jugadores.txt");
                try {
                    BufferedReader br = new BufferedReader(new FileReader(ficentrada));
                    String linea;
                    Map<String, Integer> jugadores = new HashMap<>();

                    while ((linea = br.readLine()) != null) {
                        //Rompemos la linea leída en palabras para facilitar el trabajo
                        String[] palabras = linea.split(" ");

                        for (int i = 0; i < palabras.length; i += 2) {
                            String nombreJugador = palabras[i];
                            int preguntasCorrectas = Integer.parseInt(palabras[i + 1]);
                            //Filtramos entre IA  y seres humanos
                            if (!nombreJugador.startsWith("AI")) {
                                jugadores.put(nombreJugador, jugadores.getOrDefault(nombreJugador, 0) + preguntasCorrectas);
                            }
                        }
                    }

                    // Ordenamos los jugadores en orden de mayor a menor por puntos ganados por cada uno
                    List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(jugadores.entrySet());
                    listaOrdenada.sort((valor1, valor2) -> valor2.getValue().compareTo(valor1.getValue()));

                    // Mostramos el ranking de jugadores
                    System.out.println("Ranking de jugadores:");
                    for (Map.Entry<String, Integer> entrada : listaOrdenada) {
                        System.out.println(entrada.getKey() + "=> " + entrada.getValue() + " PUNTOS");
                    }

                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }


}