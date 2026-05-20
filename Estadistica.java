public class Estadistica {
    
    public String curp;
    public int errores;
    public String ejercicio;
    public String tiempo;


    public Estadistica(String curp, int errores, String ejercicio, String tiempo) {
        this.curp = curp;
        this.errores = errores;
        this.ejercicio = ejercicio;
        this.tiempo = tiempo;
    }

    public String getcurp() {
        return curp;
    }

    public int getErrores() {
        return errores;
    }
    public String getEjercicio() {
        return ejercicio;
    }
    public String getTiempo() {
        return tiempo;
    }
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}
