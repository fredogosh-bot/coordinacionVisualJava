import javax.swing.*;

public class IUResultados extends JPanel {

    protected final static String[] NOMBRES_COLUMNAS = {"ID Adulto", "Ejercicio", "Errores", "Cronómetro"};
    
    protected JLabel etiquetas[];
    protected JTextField campos[];
    protected JButton hacerTarea1, hacerTarea2;
    protected JPanel panelInternoCentral, panelInternoInferior;

    protected int tamaño;

    public static final int ID_ADULTO = 0, EJERCICIO = 1, ERRORES = 2, CRONOMETRO = 3;

    public IUResultados(int miTamaño) {

        tamaño = miTamaño;
        etiquetas = new JLabel[tamaño];
        campos = new JTextField[tamaño];

        for (int i = 0; i < tamaño; i++) {
            panelInternoCentral.add(etiquetas[i]);
            panelInternoCentral.add(campos[i]);

        }
    }
}