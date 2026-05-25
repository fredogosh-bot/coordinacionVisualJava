import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorArchivo {

    private final String nombreArchivo = "Resultados.csv";

    // Método exclusivo para serializar y guardar un objeto Resultado
    public boolean guardarResultado(Resultado resultado) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            
            // 1. Extraemos los datos del objeto usando sus getters
            String id = resultado.getIdAdulto();
            String ejercicio = resultado.getEjercicio();
            int errores = resultado.getErrores();
            long tiempo = resultado.getCronometro();
            
            // 2. Construimos la línea del CSV separada por comas
            // Ejemplo: HEGA000001HDFRRL21,Ejercicio 1,0,45
            String lineaCSV = String.format("%s,%s,%d,%d", id, ejercicio, errores, tiempo);
            
            // 3. Escribimos la línea y añadimos un salto de línea al final
            escritor.write(lineaCSV);
            escritor.newLine(); 
            
            return true; // Todo salió bien
            
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el CSV: " + ioException.getMessage());
            return false;
        }
    }
}