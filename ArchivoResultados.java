import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ArchivoResultados extends JFrame {

    private JButton botonFinalizar;
    // Instanciamos nuestro controlador exclusivo para el archivo
    private ControladorArchivo controlador = new ControladorArchivo();

    // Variables simuladas que vendrían del estado actual de tu aplicación
    private String idAdultoActual = "HEGA000001HDFRRL21";
    private String ejercicioActual = "Ejercicio de Coordinación 1";
    private int erroresCometidos = 3;
    private long tiempoTranscurridoSegundos = 45; 

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
        // 1. Validamos que los datos de la sesión existan o estén completos
        if (idAdultoActual == null || idAdultoActual.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: No hay una sesión de usuario activa.", 
                                          "Datos Incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Creamos el objeto Entidad usando el constructor que ya programaste
        Resultado nuevoResultado = new Resultado(
            idAdultoActual, 
            ejercicioActual, 
            erroresCometidos, 
            tiempoTranscurridoSegundos
        );

        // 3. Le pedimos al controlador que lo mande a guardar al disco duro
        boolean exito = controlador.guardarResultado(nuevoResultado);

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