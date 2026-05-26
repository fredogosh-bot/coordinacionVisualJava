

public class Resultado {
    private int errores;
    private long cronometro;
    private String idAdulto;
    private String ejercicio;


    public Resultado() {
        this.idAdulto = "HEGA000001HDFRRL21";
        this.ejercicio = "Ejercicio 1";
        this.errores = 0;
        this.cronometro = 0;
    }


    public String convertidorTiempo(long segundos){

        long minutos = segundos / 60;
        long segundosRestantes = segundos % 60;
    
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
        return tiempoFormateado;
    }

    public int getErrores() {
        return errores;
    }

    public long getCronometro() {
        return cronometro;
    }

    public String getIdAdulto() {
        return idAdulto;
    }

    public String getEjercicio() {
        return ejercicio;
    }


}
