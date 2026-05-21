import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//______Para leer archivos__________________

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class Gestor {


    // Metodo para actualizar el área de texto con los datos de la lista de estadisticas
    private static void actualizarAreaTexto(ArrayList<Estadistica> lista, JTextArea textArea) {
        StringBuilder contenido = new StringBuilder("=== REGISTROS ===\n\n");
        
        for (Estadistica est : lista) {
            contenido.append("CURP: ").append(est.curp)
                     .append("  |  Ejercicio: ").append(est.ejercicio)
                     .append("  |  Errores: ").append(est.errores)
                     .append("  |  Tiempo: ").append(est.tiempo).append("\n");
        }    
        
        textArea.setText(contenido.toString());

    }

    private static String convertidorTiempo(int segundos){

        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
    
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
        return tiempoFormateado;
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestor de Estadisticas");
        frame.setSize(590, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        // COMPONENTES DE BÚSQUEDA
        JTextField campoBusqueda = new JTextField();
        campoBusqueda.setBounds(20, 20, 230, 30);
        frame.add(campoBusqueda);

        JButton botonBuscar = new JButton("Buscar CURP");
        botonBuscar.setBounds(260, 20, 130, 30);
        frame.add(botonBuscar);

        JButton botonMostrarTodo = new JButton("Mostrar Todo");
        botonMostrarTodo.setBounds(400, 20, 130, 30);
        frame.add(botonMostrarTodo);

        //Area del texto que muestra los resultados
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane barraDesplazamiento = new JScrollPane(textArea);
        barraDesplazamiento.setBounds(20, 60, 550, 570);
        frame.add(barraDesplazamiento);

        ArrayList<Estadistica> listaRegistros = new ArrayList<>();
        String nombreArchivo = "Estadisticas/test.csv"; // El archivo que se tiene que utilizar
        String linea;

        //LECTURA DE ARCHIVO

        try (BufferedReader lectorDatos = new BufferedReader(new FileReader(nombreArchivo))) {
            
            while ((linea = lectorDatos.readLine()) != null) {
                String[] datos = linea.split(",");
                String curp = datos[0].trim();
                int errores = Integer.parseInt(datos[1].trim());
                String ejercicio = datos[2].trim(); 
                String tiempo = convertidorTiempo(Integer.parseInt(datos[3].trim()));
                
                // Los datos en estricto orden
                listaRegistros.add(new Estadistica(curp, errores, ejercicio, tiempo));
            }

            actualizarAreaTexto(listaRegistros, textArea);
            

        } catch (IOException ex) {
            // Si ocurre un error al leer el archivo, se muestra un mensaje de error para informar al usuario
            JOptionPane.showMessageDialog(frame, "Error al cargar los datos automáticamente: " + ex.getMessage());
            textArea.setText("No se pudieron cargar los registros.");
        }
        
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curpBuscada = campoBusqueda.getText().trim();
                
                if (curpBuscada.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, escribe una CURP para buscar.");
                    return;
                }
                
                ArrayList<Estadistica> resultadosFiltrados = new ArrayList<>();
                

                for (Estadistica est : listaRegistros) {
                    // equalsIgnoreCase es para comparar sin distincion de mayusculas o minusculas
                    if (est.curp.equalsIgnoreCase(curpBuscada)) {
                        resultadosFiltrados.add(est);
                    }
                }
                
                if (resultadosFiltrados.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No se encontró ningún registro para la CURP: " + curpBuscada);
                } else {
                    // Refrescamos la pantalla solo con los resultados encontrados
                    actualizarAreaTexto(resultadosFiltrados, textArea);
                }
            }
        });


        botonMostrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoBusqueda.setText(""); // Limpiamos la barra
                actualizarAreaTexto(listaRegistros, textArea); // Restauramos todos los datos
            }
        });

        frame.setVisible(true);
    }
        
    
}
