import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Transferidor extends JFrame {

    private JLabel etiquetaArchivo;
    private JButton botonSeleccionar;
    private JButton botonTransferir;
    
    private File archivoSeleccionado = null;

    public Transferidor() {
        super("Asistente de Transferencia Única");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 

        // 1. Componentes visuales
        etiquetaArchivo = new JLabel("Ningún archivo seleccionado.");
        etiquetaArchivo.setBounds(20, 20, 400, 30);
        add(etiquetaArchivo);

        botonSeleccionar = new JButton("Seleccionar Documento");
        botonSeleccionar.setBounds(20, 70, 180, 35);
        add(botonSeleccionar);

        botonTransferir = new JButton("Transferir a USB");
        botonTransferir.setBounds(230, 70, 180, 35);
        botonTransferir.setEnabled(false); 
        add(botonTransferir);

        // 2. Lógica para SELECCIONAR el archivo
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser explorador = new JFileChooser();
                explorador.setDialogTitle("Seleccione el registro a transferir");
                explorador.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                // MEJORA 1: Abrir directamente en la carpeta Resultados
                File carpetaResultados = new File("RESULTADOS");
                // Si la carpeta existe, apuntamos el explorador hacia alla
                if (carpetaResultados.exists()) {
                    explorador.setCurrentDirectory(carpetaResultados);
                }

                // MEJORA 1.1: Filtrar para que SOLO se vean archivos CSV
                FileNameExtensionFilter filtroCSV = new FileNameExtensionFilter("Archivos de Resultados (*.csv)", "csv");
                explorador.setFileFilter(filtroCSV);
                explorador.setAcceptAllFileFilterUsed(false); // Apaga la opcion de "Todos los archivos"
                
                int resultado = explorador.showOpenDialog(Transferidor.this);
                
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    archivoSeleccionado = explorador.getSelectedFile();
                    etiquetaArchivo.setText("Archivo listo: " + archivoSeleccionado.getName());
                    botonTransferir.setEnabled(true); 
                }
            }
        });

        // 3. Lógica para COPIAR en la USB Automática
        botonTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // MEJORA 2: Buscar la USB de forma automatica
                File carpetaDestino = detectarUSB();

                if (carpetaDestino == null) {
                    JOptionPane.showMessageDialog(Transferidor.this, 
                        "Error: No se ha detectado ninguna memoria USB conectada o no hay permisos.", 
                        "USB No Encontrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    File archivoDestino = new File(carpetaDestino, archivoSeleccionado.getName());
                    
                    Files.copy(archivoSeleccionado.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    
                    JOptionPane.showMessageDialog(Transferidor.this, 
                        "¡Archivo transferido con éxito a la USB!\nDestino: " + archivoDestino.getAbsolutePath(), 
                        "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        
                    archivoSeleccionado = null;
                    etiquetaArchivo.setText("Ningún archivo seleccionado.");
                    botonTransferir.setEnabled(false);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Transferidor.this, 
                        "Error al transferir el archivo: " + ex.getMessage(), 
                        "Fallo de E/S", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Metodo Inteligente para buscar una USB conectada dependiendo del Sistema Operativo.
     * @return El directorio raiz de la USB o null si no encuentra nada.
     */
    private File detectarUSB() {
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        // LOGICA PARA WINDOWS
        if (sistemaOperativo.contains("win")) {
            File[] raices = File.listRoots(); // Devuelve C:\, D:\, E:\, etc.
            for (File raiz : raices) {
                // Ignoramos el disco principal C: y buscamos el primer disco con escritura (E:\, F:\...)
                if (!raiz.getAbsolutePath().toLowerCase().contains("c:") && raiz.canWrite()) {
                    return raiz; // Retorna la primera USB que encuentre
                }
            }
        } 
        // LOGICA PARA LINUX (Ubuntu, Mint, Zorin, etc.)
        else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux") || sistemaOperativo.contains("aix")) {
            String usuario = System.getProperty("user.name");
            File rutaMedia = new File("/media/" + usuario); // Generalmente las USB se montan aqui
            
            if (rutaMedia.exists() && rutaMedia.isDirectory()) {
                File[] usbsConectadas = rutaMedia.listFiles();
                if (usbsConectadas != null && usbsConectadas.length > 0) {
                    return usbsConectadas[0]; // Retorna la primera USB conectada en esa carpeta
                }
            }
        }
        
        return null; // Si no encuentra nada, devuelve nulo
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Transferidor().setVisible(true);
        });
    }
}