
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Resultados {
    
    private String idAdulto;
    private int errores;
    private String ejercicio;
    private long cronometro;
    
    private final String NOMBRE_ARCHIVO = "Reporte_Coordinacion_Visual.csv";
    
    public Resultados() {
        this.idAdulto = "HEGA000001HDFRRL21";
        this.ejercicio = "Figuras Con Colores";
        this.errores = 0;
        this.cronometro = 0;
    }


    public String getIdAdulto() {
        return idAdulto;
    }

    public void setIdAdulto(String idAdulto) {
        this.idAdulto = idAdulto;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public long getCronometro() {
        return cronometro;
    }

    public void setCronometro(long cronometro) {
        this.cronometro = cronometro;
    }
    
    
    
    public boolean guardar() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(NOMBRE_ARCHIVO, true);
            pw = new PrintWriter(fichero);
            pw.println(this.idAdulto + "," + this.errores + "," + 
                      this.ejercicio + "," + this.cronometro);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        } finally {
            try {
                if (pw != null) pw.close();       // ← cierra PrintWriter primero
                if (fichero != null) fichero.close(); // ← luego el FileWriter
            } catch (IOException e2) {
                System.out.println("Error al cerrar: " + e2.getMessage());
            }
        }
    }
    
    public boolean actualizar() {
        return true;
    }
}