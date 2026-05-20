import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//______Para leer archivos__________________

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Gestor {




    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestor de Ejercicios");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane barraDesplazamiento = new JScrollPane(textArea);
        barraDesplazamiento.setBounds(20, 20, 440, 620);
        frame.add(barraDesplazamiento);

        ArrayList<Estadistica> listaRegistros = new ArrayList<>();
        String nombreArchivo = "test.csv"; // El archivo de tu compañero
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            StringBuilder contenidoConsolidado = new StringBuilder("=== REGISTROS DETECTADOS ===\n\n");
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                String curp = datos[0].trim();
                String ejercicio = datos[1].trim();
                int errores = Integer.parseInt(datos[2].trim());
                String tiempo = datos[3].trim();
                
                // Guardamos en la lista por si necesitas filtrar después
                listaRegistros.add(new Estadistica(curp, errores, ejercicio, tiempo));
                
                // Acumulamos el texto formateado
                contenidoConsolidado.append("ID: ").append(curp)
                                    .append("  |  Ejercicio: ").append(ejercicio)
                                    .append("  |  Errores: ").append(errores)
                                    .append("  |  Tiempo: ").append(tiempo).append("\n");
            }
            
            // Colocamos todo el texto acumulado dentro del JTextArea
            textArea.setText(contenidoConsolidado.toString());

        } catch (IOException ex) {
            // Si el archivo de tu compañero no está o falla, avisamos en pantalla
            JOptionPane.showMessageDialog(frame, "Error al cargar los datos automáticamente: " + ex.getMessage());
            textArea.setText("No se pudieron cargar los registros.");
        }
        
        
        
        
        frame.setVisible(true);

    }
}
