import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoResultados {

    private final String nombreArchivo = "RESULTADOS/Resultados.csv";

    // Variables simuladas que vendrían del estado actual de tu aplicación
    
    

    public boolean guardarResultado(Resultado resultadoActual) {

        // Creamos un objeto File para analizar la ruta del archivo
        File archivo = new File(nombreArchivo);
        
        // carpeta contenedora 
        File directorioPadre = archivo.getParentFile();
        
        // SEGURIDAD: Si la carpeta no existe, se crea dinamicamente
        if (directorioPadre != null && !directorioPadre.exists()) {
            // mkdirs() crea la carpeta
            directorioPadre.mkdirs(); 
        }


        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            
            String id = resultadoActual.getIdAdulto();
            String ejercicio = resultadoActual.getEjercicio();
            int errores = resultadoActual.getErrores();
            String tiempo = resultadoActual.convertidorTiempo(resultadoActual.getCronometro());
            
            //
            String lineaCSV = String.format("%s,%s,%d,%s", id, ejercicio, errores, tiempo);
            
            escritor.write(lineaCSV);
            escritor.newLine(); // salto de linea para el siguiente registro
            
            return true; // todo salió bien
            
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el CSV: " + ioException.getMessage());
            return false;
        }
    }


    
}