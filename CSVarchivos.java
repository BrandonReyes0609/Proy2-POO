


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author audre.
 */
public class EjemploCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<FichaMedica> usuarios = new ArrayList<FichaMedica>(); /// para hacer link con el ingreso de datos
        
        
        //ExportarCSV(usuarios);
        
        ImportarCSV();
    }
    
    public static void ExportarCSV(List<FichaMedica> usuarios) {
        String salidaArchivo = "Usuarios_medico.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe
        
        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }
        
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Apellidos");
            salidaCSV.write("Edad");
            salidaCSV.write("Peso");
            salidaCSV.write("Ejercicio");
            salidaCSV.write("Cantidad Comida");
            salidaCSV.write("Género");
            salidaCSV.write("IMC");
            salidaCSV.write("Estatura");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
            for(Usuario user : usuarios) {
                salidaCSV.write(user.getNombre());
                salidaCSV.write(user.getApellidos());
                salidaCSV.write(user.getEdad());
                salidaCSV.write(user.getPeso());
                salidaCSV.write(user.getRealizaEjercicio());
                salidaCSV.write(user.getNumComida());
                salidaCSV.write(user.getSexo());
                salidaCSV.write(user.getDatoIMC());
                salidaCSV.write(user.getEstatura());
                
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
    
    public static void ImportarCSV() {
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista donde se guardan los datos del archivo
            
            CsvReader leerUsuarios = new CsvReader("Usuarios_medico.csv");
            leerUsuarios.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String nombre = leerUsuarios.get(0);
                String telefono = leerUsuarios.get(1);
                String email = leerUsuarios.get(2);
                
                usuarios.add(new Usuario(nombre, telefono, email)); // Añade la informacion a la lista
            }
            
            leerUsuarios.close(); // Cierra el archivo
            
            for(Usuario user : usuarios) {
                System.out.println(user.getNombre() + " , "
                    + user.getTelefono() + " , "
                    +user.getEmail());
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
