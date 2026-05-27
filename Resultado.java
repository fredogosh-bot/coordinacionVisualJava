

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

    public String convertidorTiempo(long tiempoEnMilisegundos) {
        long minutos = tiempoEnMilisegundos / 60000;
        long segundos = (tiempoEnMilisegundos % 60000) / 1000;
        long milisegundosRestantes = tiempoEnMilisegundos % 1000;

        return String.format("%02d:%02d.%03d", minutos, segundos, milisegundosRestantes);
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
