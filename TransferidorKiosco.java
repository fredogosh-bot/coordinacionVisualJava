import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TransferidorKiosco extends JFrame {

    private JLabel etiquetaArchivo;
    private JButton botonSeleccionar;
    private JButton botonTransferir;
    
    private File archivoSeleccionado = null;
    // Cambia esto por la ruta de montaje de tu USB (ej. "E:\\" en Windows o "/media/usuario/MI_USB" en Linux)
    private final String RUTA_USB = "/media/tu_usuario/NOMBRE_USB/"; 

    public TransferidorKiosco() {
        super("Asistente de Transferencia Única");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centra la ventana

        // 1. Componentes visuales
        etiquetaArchivo = new JLabel("Ningún archivo seleccionado.");
        etiquetaArchivo.setBounds(20, 20, 400, 30);
        add(etiquetaArchivo);

        botonSeleccionar = new JButton("Seleccionar Documento");
        botonSeleccionar.setBounds(20, 70, 180, 35);
        add(botonSeleccionar);

        botonTransferir = new JButton("Transferir a USB");
        botonTransferir.setBounds(230, 70, 180, 35);
        botonTransferir.setEnabled(false); // Apagado hasta que elijan un archivo
        add(botonTransferir);

        // 2. Lógica para SELECCIONAR el archivo (Sin poder abrirlo)
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser explorador = new JFileChooser();
                explorador.setDialogTitle("Seleccione el archivo a transferir");
                explorador.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                int resultado = explorador.showOpenDialog(TransferidorKiosco.this);
                
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    archivoSeleccionado = explorador.getSelectedFile();
                    // Solo mostramos el nombre en la interfaz, el usuario no puede ejecutarlo
                    etiquetaArchivo.setText("Archivo listo: " + archivoSeleccionado.getName());
                    botonTransferir.setEnabled(true); // Encendemos el botón de copia
                }
            }
        });

        // 3. Lógica para COPIAR en segundo plano
        botonTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File carpetaDestino = new File(RUTA_USB);

                // Validación de hardware: ¿La USB está realmente conectada?
                if (!carpetaDestino.exists() || !carpetaDestino.canWrite()) {
                    JOptionPane.showMessageDialog(TransferidorKiosco.this, 
                        "Error: No se detecta la USB o no se tienen permisos de escritura.", 
                        "Dispositivo No Encontrado", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Construimos la ruta de destino exacta dentro de la USB
                    File archivoDestino = new File(carpetaDestino, archivoSeleccionado.getName());
                    
                    // Copia binaria directa (reemplaza si ya existe un archivo con el mismo nombre)
                    Files.copy(archivoSeleccionado.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    
                    JOptionPane.showMessageDialog(TransferidorKiosco.this, 
                        "¡Archivo transferido con éxito a la USB!", 
                        "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        
                    // Reiniciamos la interfaz por seguridad
                    archivoSeleccionado = null;
                    etiquetaArchivo.setText("Ningún archivo seleccionado.");
                    botonTransferir.setEnabled(false);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TransferidorKiosco.this, 
                        "Error al transferir el archivo: " + ex.getMessage(), 
                        "Fallo de E/S", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Ejecutamos la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TransferidorKiosco().setVisible(true);
        });
    }
}