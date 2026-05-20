public class Estadisticas {
    
    public int IdAdulto;
    public int errores;
    public String ejercicio;
    public String tiempo;


    public Estadisticas(int IdAdulto, int errores, String ejercicio, String tiempo) {
        this.IdAdulto = IdAdulto;
        this.errores = errores;
        this.ejercicio = ejercicio;
        this.tiempo = tiempo;
    }

    public int getIdAdulto() {
        return IdAdulto;
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
