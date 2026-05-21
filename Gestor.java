import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

        JFrame frame = new JFrame("Gestor de Estadisticas");
        frame.setSize(590, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        // === 1. COMPONENTES DE BÚSQUEDA (Arriba) ===
        JTextField campoBusqueda = new JTextField();
        campoBusqueda.setBounds(20, 20, 230, 30);
        frame.add(campoBusqueda);

        JButton botonBuscar = new JButton("Buscar CURP");
        botonBuscar.setBounds(260, 20, 130, 30);
        frame.add(botonBuscar);

        JButton botonMostrarTodo = new JButton("Mostrar Todo");
        botonMostrarTodo.setBounds(400, 20, 130, 30);
        frame.add(botonMostrarTodo);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane barraDesplazamiento = new JScrollPane(textArea);
        barraDesplazamiento.setBounds(20, 20, 550, 620);
        frame.add(barraDesplazamiento);

        ArrayList<Estadistica> listaRegistros = new ArrayList<>();
        String nombreArchivo = "Estadisticas/test.csv"; // El archivo que se tiene que utilizar
        String linea;

        try (BufferedReader lectorDatos = new BufferedReader(new FileReader(nombreArchivo))) {
            StringBuilder contenidoConsolidado = new StringBuilder("=== REGISTROS DETECTADOS ===\n\n");
            
            while ((linea = lectorDatos.readLine()) != null) {
                String[] datos = linea.split(",");
                String curp = datos[0].trim();
                int errores = Integer.parseInt(datos[1].trim());
                String ejercicio = datos[2].trim();

                String tiempo = datos[3].trim();
                
                // Los datos en estricto orden
                listaRegistros.add(new Estadistica(curp, errores, ejercicio, tiempo));
                
                contenidoConsolidado.append("CURP: ").append(curp)
                                    .append(" |  Ejercicio: ").append(ejercicio)
                                    .append(" |  Errores: ").append(errores)
                                    .append(" |  Tiempo: ").append(tiempo).append("\n");
            }
            
            // Colocamos todo el texto acumulado dentro del JTextArea
            textArea.setText(contenidoConsolidado.toString());

        } catch (IOException ex) {
            // Si ocurre un error al leer el archivo, se muestra un mensaje de error para informar al usuario
            JOptionPane.showMessageDialog(frame, "Error al cargar los datos automáticamente: " + ex.getMessage());
            textArea.setText("No se pudieron cargar los registros.");
        }
        
        
        
        
        frame.setVisible(true);

    }
}
