

public class Resultado {
    
    private int errores;
    private long cronometro;
    private String curp;
    private String ejercicio;


    public Resultado() {
        this.curp = "SIN_ASIGNAR";
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

    public String getCurp() {
        return curp;
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

    public void setCurp(String curp) {
        this.curp = curp;
    }


}
