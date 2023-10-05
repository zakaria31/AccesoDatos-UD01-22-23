
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<String> actores= new ArrayList<>();
    static List<String> directores = new ArrayList<>();

        public static void leerdatosPelicula(){
            System.out.println("Introduce el titulo de la pelicula");
            String titulo=sc.nextLine();

            Integer numeroactores;
            do {
                System.out.println("Introduzca el numero de actores (NO mas de 10 actores) :");
                numeroactores = sc.nextInt();
                sc.nextLine();
            }while(numeroactores<=0||numeroactores>10);
            String actor;
            for(int i=1;i<=numeroactores;i++){

                System.out.println("Introduce el nombre del actor  :");
                actor = sc.nextLine();
                actores.add(actor);


            }


            int numerodirectores;
            do {
                System.out.println("Introduzca el numero de directores (NO mas de 5 directores) :");
                numerodirectores = sc.nextInt();
                sc.nextLine();
            }while(numerodirectores<=0||numerodirectores>5);

            String director;
            for(int j=1;j<=numerodirectores;j++){

                System.out.println("Introduce el nombre del  Director  :");
                director=sc.nextLine();
                directores.add(director);


            }

            LocalDate salida=LocalDate.now();
            int dia,mes,anio;
            do {
                System.out.println("Introduzca el dia de salida: ");
                dia = sc.nextInt();
                sc.nextLine();
            }while(dia<0||dia>31);
            do {
                System.out.println("Introduzca el mes de salida: ");
                mes = sc.nextInt();
                sc.nextLine();
            }while(mes<0||mes>12);
            do {
                System.out.println("Introduzca el año de salida: ");
                anio = sc.nextInt();
                sc.nextLine();
            }while(anio<1899||anio>2023);

            String fechaFormateada = String.format("%02d/%02d/%d", dia, mes, anio);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocalDate = LocalDate.parse(fechaFormateada, formato);

            //sc.nextLine();

            String Formato;
            System.out.println("Introduzca el formato de la pelicula");
            Formato = sc.nextLine();

            Pelicula p = new Pelicula(titulo,actores,directores,fechaLocalDate,Formato);

            insertarPelicula("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio Persistencia de Objetos\\src\\Peliculas.dat",p);

        }


        public static void insertarPelicula(String nombreFichero, Pelicula nuevaPelicula) {
            // Recuperamos todas las películas del fichero en una lista
            List<Pelicula> listaPeliculas = obtenerListaPeliculas(nombreFichero);

            // Añadimos la nueva película a la lista
            listaPeliculas.add(nuevaPelicula);

            // guardamos la lista actualizada en el fichero
            guardarListaPeliculas(nombreFichero, listaPeliculas);
        }

        // Método para obtener la lista de películas desde el archivo .dat
        public static List<Pelicula> obtenerListaPeliculas(String nombreFichero) {
            List<Pelicula> listaPeliculas = new ArrayList<>();
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreFichero))) {
                while (true) {
                    Pelicula pelicula;
                    try {
                        pelicula = (Pelicula) entrada.readObject();
                    } catch (EOFException e) {
                        // Se alcanzó el final del archivo
                        break; // Salir del bucle cuando llegamos al final del archivo
                    }
                    listaPeliculas.add(pelicula);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return listaPeliculas;
        }


    // Método para guardar la lista de películas en el fichero .dat
        public static void guardarListaPeliculas(String nombreFichero, List<Pelicula> listaPeliculas) {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
                for (Pelicula pelicula : listaPeliculas) {
                    salida.writeObject(pelicula);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public static void modificarFormato(String titulo) {


        // Sacamos todas las películas del archivo en una lista
        List<Pelicula> listaPeliculas = obtenerListaPeliculas("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio Persistencia de Objetos\\src\\Peliculas.dat");

        boolean modificada = false;

        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Introduce el nuevo formato de la película:");
                String nuevoFormato = sc.nextLine();
                pelicula.setFormato(nuevoFormato);
                modificada = true;
                System.out.println("Formato de la película modificado correctamente.");
                break;
            }
        }

        if (!modificada) {
            System.out.println("La película no existe dentro del archivo.");
        } else {
            guardarListaPeliculas("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio Persistencia de Objetos\\src\\Peliculas.dat", listaPeliculas);
        }
    }


// Método para eliminar una película por título
    public static void eliminarPeliculaPorTitulo(String titulo) {

        List<Pelicula> listaPeliculas = obtenerListaPeliculas("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio Persistencia de Objetos\\src\\Peliculas.dat");

        boolean eliminada = false;
        Iterator<Pelicula> lista = listaPeliculas.iterator();

        while (lista.hasNext()) {
            Pelicula pelicula = lista.next();
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                lista.remove();
                eliminada = true;
                System.out.println("Película eliminada con correctamente.");
                break;
            }
        }

        if (!eliminada) {
            System.out.println("La película no fue encontrada.");
        } else {
            // Guardamos la lista actualizada en el archivo .dat
            guardarListaPeliculas("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio Persistencia de Objetos\\src\\Peliculas.dat", listaPeliculas);
        }
    }


    public static void verPeliculaPorTitulo(String titulo) {


        List<Pelicula> listaPeliculas = obtenerListaPeliculas("C:\\\\Users\\\\ZakaYuns\\\\Desktop\\\\Zakaria\\\\2ºDAM\\\\ACCESO DATOS\\\\Proyectos IntelliJ\\\\Ejercicio Persistencia de Objetos\\\\src\\\\Peliculas.dat");

        boolean encontrada = false;

        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                encontrada = true;
                System.out.println("Película encontrada:");
                System.out.println(pelicula.visualizar());
                break;
            }
        }

        if (encontrada==false) {
            System.out.println("La película introducida no existe.");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        int opcion;
        menu.mostrar();
        opcion = menu.leerOpcion();
        while (opcion != 0 && opcion !=5) {
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    leerdatosPelicula();
                    break;
                case 2:
                    String modtitulo;
                    System.out.println("Introduce el titulo de la película a modificar: ");
                    modtitulo=sc.nextLine();
                    modificarFormato(modtitulo);
                   break;
                case 3:
                    String elimtitulo;
                    System.out.println("Introduce el titulo de la pelicula a eliminar: ");
                    elimtitulo=sc.nextLine();
                    eliminarPeliculaPorTitulo(elimtitulo);
                    break;
                case 4:
                    String vertitulo;
                    System.out.println("Introduce el titulo de la película a buscar: ");
                    vertitulo=sc.nextLine();
                    verPeliculaPorTitulo(vertitulo);
                    break;
            }
        }

    }
}