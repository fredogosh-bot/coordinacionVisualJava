
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ArchivoResultados {

    private final String nombreArchivo = "RESULTADOS/Resultados.csv";

    
    private void generarArchivoFisico(File archivoBase) throws IOException {
        
        archivoBase.createNewFile();
    }
    
    public boolean prepararArchivoNuevo() {
        File archivo = new File(nombreArchivo);
        File directorioPadre = archivo.getParentFile();
        
        if (directorioPadre != null && !directorioPadre.exists()) {
            directorioPadre.mkdirs(); 
        }

        try {
            // Si el archivo no existe, lo crea. Si ya existe, no lo borra.
            if (!archivo.exists()) {
                generarArchivoFisico(archivo);
                
                // podrá escribir los encabezados del CSV aquí
                try (FileWriter escritor = new FileWriter(archivo)) {
                    escritor.write("CURP,Ejercicio,Errores,Tiempo\n");
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al preparar el archivo: " + e.getMessage());
            return false;
        }
    }

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
            
            String id = resultadoActual.obtenerCurp();
            String ejercicio = resultadoActual.obtenerEjercicio();
            int errores = resultadoActual.obtenerErrores();
            String tiempo = resultadoActual.convertidorTiempo(resultadoActual.obtenerCronometro());
            
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