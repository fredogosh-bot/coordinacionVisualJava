
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FRONTERA: Interfaz exclusiva para el Encargado del centro.
 */
public class InterfazEncargado extends JFrame {

    private JTextField campoCurp;
    private JButton botonCrearSesion;
    private JLabel etiquetaInstruccion;

    private Resultado sesionActual = new Resultado();

    private ArchivoResultados manejadorArchivos = new ArchivoResultados();

    public InterfazEncargado() {
        super("Panel del Encargado - Nueva Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        etiquetaInstruccion = new JLabel("Ingrese la CURP del adulto mayor:");
        etiquetaInstruccion.setBounds(30, 20, 300, 30);
        add(etiquetaInstruccion);

        campoCurp = new JTextField();
        campoCurp.setBounds(30, 60, 320, 30);
        add(campoCurp);

        botonCrearSesion = new JButton("Crear Archivo y Sesión");
        botonCrearSesion.setBounds(100, 110, 180, 35);
        add(botonCrearSesion);

        botonCrearSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curpIngresada = campoCurp.getText().trim();

                // Validación básica
                if (curpIngresada.isEmpty() || curpIngresada.length() < 18) {
                    JOptionPane.showMessageDialog(InterfazEncargado.this, 
                        "Por favor, ingrese una CURP válida.", 
                        "Dato inválido", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                

                sesionActual.setCurp(curpIngresada);

                // Aqui se crea el archivo
                boolean exito = manejadorArchivos.prepararArchivoNuevo();

                if (exito) {
                    JOptionPane.showMessageDialog(InterfazEncargado.this, 
                        "Archivo creado/verificado exitosamente.\nLa sesión para " + curpIngresada + " está lista.", 
                        "Sesión Iniciada", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Aquí, en el futuro, podrías cerrar esta ventana y mandar a llamar
                    // a la PantallaActividad de tu compañero, pasándole el objeto 'sesionActual'
                    campoCurp.setText("");
                } else {
                    JOptionPane.showMessageDialog(InterfazEncargado.this, 
                        "Error al intentar crear el directorio o el archivo CSV.", 
                        "Error del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new InterfazEncargado().setVisible(true);
        });
    }
}
