import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoResultados extends JFrame {

    private final String nombreArchivo = "RESULTADOS/Resultados.csv";

    private JButton botonFinalizar;

    // Variables simuladas que vendrían del estado actual de tu aplicación
    private String idAdultoActual = "HEGA000001HDFRRL21";
    private String ejercicioActual = "Ejercicio de Coordinación 1";
    private int erroresCometidos = 233;
    private long tiempoTranscurridoSegundos = 544; 

    public boolean guardarResultado(Resultado resultado) {

        // Creamos un objeto File para analizar la ruta del archivo
        File archivo = new File(nombreArchivo);
        
        // carpeta contenedora 
        File directorioPadre = archivo.getParentFile();
        
        // SEGURIDAD: Si la carpeta no existe, la creamos dinamicamente
        if (directorioPadre != null && !directorioPadre.exists()) {
            // mkdirs() crea la carpeta
            directorioPadre.mkdirs(); 
        }


        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            
            String id = resultado.getIdAdulto();
            String ejercicio = resultado.getEjercicio();
            int errores = resultado.getErrores();
            long tiempo = resultado.getCronometro();
            
            //
            String lineaCSV = String.format("%s,%s,%d,%d", id, ejercicio, errores, tiempo);
            
            escritor.write(lineaCSV);
            escritor.newLine(); // salto de linea para el siguiente registro
            
            return true; // todo salió bien
            
        } catch (IOException ioException) {
            System.err.println("Error al escribir en el CSV: " + ioException.getMessage());
            return false;
        }
    }


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
    }

    public void agregarResultado() {
        // 1. se valida que los datos existan o estén completos
        if (idAdultoActual == null || idAdultoActual.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: No hay una sesión de usuario activa.", 
                                          "Datos Incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. aqui se crea un nuevo Objeto Resultado 
        Resultado nuevoResultado = new Resultado(
            idAdultoActual, 
            ejercicioActual, 
            erroresCometidos, 
            tiempoTranscurridoSegundos
        );

        // 3. Le pedimos al controlador que lo mande a guardar al disco duro
        boolean exito = guardarResultado(nuevoResultado);

        // 4. Avisamos al usuario del estatus de la operación gráfica
        if (exito) {
            JOptionPane.showMessageDialog(this, "¡Ejercicio finalizado y datos guardados de forma segura!", 
                                          "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
            botonFinalizar.setEnabled(false); // Deshabilitamos para evitar doble envío
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron salvar las estadísticas en el archivo.", 
                                          "Error de Archivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ArchivoResultados();
    }
}