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

    /*Forma de como utilizar el metodo guardarResultado() dentro de la interfaz gráfica, se puede adaptar a tu diseño actual
    public ArchivoResultados() {
        super("Archivos de Resultados");
        setLayout(null); // O el layout que decidas usar

        botonFinalizar = new JButton("Finalizar Ejercicio");
        botonFinalizar.setBounds(100, 100, 200, 40);
        
        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento){
                agregarResultado();
            }
        });

        add(botonFinalizar);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }*/

    
}