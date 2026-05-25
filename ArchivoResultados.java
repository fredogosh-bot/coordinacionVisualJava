    
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArchivoResultados extends JFrame {

    private ObjectOutputStream salida;
    private JButton botonFinalizar; //boton pendiente de nombrar pues no conozco el nombre que se usara

    public ArchivoResultados() {
        super("Archivos de Resultados");
        botonFinalizar = new JButton("Finalizar");
        botonFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                agregarResultado();
            }
        });

        setSize(400, 300);
        setVisible(true);

    }

    public void agregarResultado() {
        
        String IdAdulto = "";
        Resultado resultado;
        String valoresCampos[];
        


        if ()
    }
    


}
