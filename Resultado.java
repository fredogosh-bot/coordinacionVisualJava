import java.io.Serializable;

public class Resultado implements Serializable {
    private int errores;
    private long cronometro;
    private String IdAdulto;
    private String ejercicio;


    public Resultado() {
        this.IdAdulto = "HEGA000001HDFRRL21";
        this.ejercicio = "Ejercicio 1";
        this.errores = 0;
        this.cronometro = 0;
    }

    public Resultado(String IdAdulto, String ejercicio, int errores, long cronometro) {
        this.IdAdulto = IdAdulto;
        this.ejercicio = ejercicio;
        this.errores = errores;
        this.cronometro = cronometro;
    }

    public int getErrores() {
        return errores;
    }

    public long getCronometro() {
        return cronometro;
    }

    public String getIdAdulto() {
        return IdAdulto;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public void setCronometro(long cronometro) {
        this.cronometro = cronometro;
    }

    public void setIdAdulto(String IdAdulto) {
        this.IdAdulto = IdAdulto;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

}
