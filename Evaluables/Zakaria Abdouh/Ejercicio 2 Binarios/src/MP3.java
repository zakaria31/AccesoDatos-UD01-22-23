import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public  class MP3 {
    public static Integer numeroAleatrio(){
        Random random = new Random();
        int numero=random.nextInt(80)+1;
        return numero;
    }

    public static void escribirInfo(String ruta) throws FileNotFoundException {
        File archivo = new File(ruta);
        //La ruta debe apuntar siempre a donde se localiza el archivo de texto
        File txt = new File("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio 2 Binarios\\src\\datoscanciones.txt");
        try(FileInputStream leerbinario = new FileInputStream(archivo)){
            //saltamos los bytes que no nos sirven ya que la informacion se encuentra en los últimos 128

            leerbinario.skip(leerbinario.available()-128);
            byte[] arraydatos= new byte[128];

            leerbinario.read(arraydatos);
            String tag=new String(arraydatos,0,3);
            if(tag.equals("TAG")) {
                String titulo = new String(arraydatos, 3, 30, "UTF-8").trim();
                String artista = new String(arraydatos, 33, 30, "UTF-8").trim();
                String album = new String(arraydatos, 63, 30, "UTF-8").trim();
                String anio = new String(arraydatos, 93, 4, "UTF-8").trim();
                Genero genero = Genero.values()[numeroAleatrio()];

                System.out.println("Titulo: "+titulo);
                System.out.println("Artista: "+artista);
                System.out.println("Album: "+album);
                System.out.println("Año: " +anio);

                String datos="----------------"+ "\n" +"Titulo: " + titulo + "\n" +
                        "Genero: " + genero + "\n" +
                        "Año: " + anio + "\n" +
                        "Álbum: " + album + "\n"+ "---------------";

                FileOutputStream fos = new FileOutputStream("C:\\Users\\ZakaYuns\\Desktop\\Zakaria\\2ºDAM\\ACCESO DATOS\\Proyectos IntelliJ\\Ejercicio 2 Binarios\\src\\datoscanciones.txt");
                // Convierto la cadena de datos en bytes y la escribo en el archivo
                byte[] bytes = datos.getBytes(StandardCharsets.UTF_8);
                fos.write(bytes);

                System.out.println("Datos escritos en el archivo datoscanciones.txt correctamente.");

            }
        } catch (Exception ex) {
            System.out.println("Se han producido los siguientes errores: "+ex.getMessage());
        }

    }
    public static void leerInfo(String ruta){
        //CONTROLAREMOS EN ESTE CASO CANCIÓN POR CANCION, ES DECIR, NOS PASARÁN LA CANCIÓN Y NOSTROS MOSTRAREMOS LA INFORMACION
        File archivo = new File(ruta);
        try(FileInputStream leerbinario = new FileInputStream(archivo)){
            //saltamos los bytes que no nos sirven ya que la informacion se encuentra en los últimos 128

            leerbinario.skip(leerbinario.available()-128);
            byte[] arraydatos= new byte[128];

            leerbinario.read(arraydatos);
            String tag=new String(arraydatos,0,3);
            if(tag.equals("TAG")){
                String titulo=new String(arraydatos,3,30,"UTF-8").trim();
                String artista = new String(arraydatos, 33, 30, "UTF-8").trim();
                String album = new String(arraydatos, 63, 30, "UTF-8").trim();
                String anio = new String(arraydatos, 93, 4, "UTF-8").trim();
                String genero = new String(arraydatos, 127, 1, "UTF-8").trim();

                System.out.println("Titulo: "+titulo);
                System.out.println("Artista: "+artista);
                System.out.println("Album: "+album);
                System.out.println("Año: " +anio);
                System.out.println("Genero: "+Genero.values()[numeroAleatrio()]);

            }


        } catch (Exception ex) {
            System.out.println("Se han producido los siguientes errores: "+ex.getMessage());
        }

    }
}
