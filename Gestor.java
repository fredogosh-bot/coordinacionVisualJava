import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//______Para leer archivos__________________

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Gestor {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestor de Ejercicios");
        JButton button = new JButton("Mostrar Estadísticas");

        frame.setLayout(null);

        button.setBounds(150, 20, 200, 40);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para mostrar las estadísticas
                JOptionPane.showMessageDialog(frame, "Aquí se mostrarán las estadísticas.");

            }
        });

        
        frame.add(button);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
