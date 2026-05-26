import javax.swing.JOptionPane;

public class ControlActividad{
    
    private int contadorFila = 1;
    private int erroresContados = 0;
    private String colorSeleccionado = "";
    private String formaSeleccionada = "";
    private long tiempoInicio;
    private long ultimoTiempoActividad;
    
    private Resultado resultadoControl = new Resultado();
    private ArchivoResultados manejadorArchivos = new ArchivoResultados();
    
   
    int i = 0;
    
    private Patron patron;
    private PantallaActividad pantalla;
    private javax.swing.Timer timerInactividad;
    
    public ControlActividad(PantallaActividad pantalla) {
        this.pantalla = pantalla;
        this.patron = new Patron();
    }
    
    public void iniciarCronometro() {
        this.tiempoInicio = System.currentTimeMillis();
        this.ultimoTiempoActividad = System.currentTimeMillis();
        
        pantalla.cargarImagenesNivel(); // Carga tira 1
        
        timerInactividad = new javax.swing.Timer(1000, e -> {
            long ahora = System.currentTimeMillis();
            if (ahora - ultimoTiempoActividad > 10000) {
                pantalla.mostrarAviso();
            }
        });
        timerInactividad.start();
    }
    
    public String getRutaImagen(int index) {
        return patron.getRutaImagen(index);
    }
    
    public void seleccionarColor(String color) {
        resetearAviso();
        this.colorSeleccionado = color;
        verificarFila();
    }
    
    public void seleccionarForma(String forma) {
        resetearAviso();
        this.formaSeleccionada = forma;
        verificarFila();
    }
    
    private void resetearAviso() {
        this.ultimoTiempoActividad = System.currentTimeMillis();
        pantalla.ocultarAviso();
    }
    
    private void verificarFila() {
        if (colorSeleccionado.equals("") || formaSeleccionada.equals("")) {
            return;
        }
        
        int indexActual = this.contadorFila - 1;
        String colorCorrecto = patron.obtenerColorCorrecto(indexActual);
        String formaCorrecta = patron.obtenerFormaCorrecta(indexActual);
        
        if (colorSeleccionado.equals(colorCorrecto) && formaSeleccionada.equals(formaCorrecta)) {
            this.ultimoTiempoActividad = System.currentTimeMillis();
            pantalla.ocultarAviso();
            pantalla.eliminarFiguraDePantalla(this.contadorFila);
            pantalla.mostrarMensajeAnimo();
            this.contadorFila++;
            
            if (this.contadorFila > 8) {
                finalizarTira();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                "¡Ups! Inténtalo de nuevo.",
                "Coordinación Visual",
                JOptionPane.WARNING_MESSAGE);
                i++;
                resultadoControl.setErrores(i);
        }
        
        this.colorSeleccionado = "";
        this.formaSeleccionada = "";
    }

    public void guardarResultadosSesion() {
        // Detenemos el reloj y calculamos los segundos totales
        long tiempoFin = System.currentTimeMillis();
        long segundosTranscurridos = (tiempoFin - this.tiempoInicio) / 1000;
        
        // Inyectamos el tiempo final en tu entidad
        resultadoControl.setCronometro(segundosTranscurridos);
        
        // Mandamos a guardar usando tu controlador de archivos
        boolean exito = manejadorArchivos.guardarResultado(resultadoControl);
        
        if (!exito) {
            System.err.println("Advertencia: No se pudo escribir el archivo CSV.");
        }
    }
    
private void finalizarTira() {
    if (timerInactividad != null) timerInactividad.stop();
    
    if (patron.hayMasEjercicios()) {
        pantalla.mostrarBotonSiguiente();
    } else {

        guardarResultadosSesion();
        JOptionPane.showMessageDialog(null,
            "¡Has completado todos los ejercicios!",
            "Fin", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
    
public void ejecutarBotonSiguiente() {
    this.contadorFila = 1;
    this.erroresContados = 0;
    this.ultimoTiempoActividad = System.currentTimeMillis();
    
    // 🔥 1. IMPORTANTE: Primero limpiamos y pintamos los recuadros de blanco
    pantalla.resetearLabels(); 
    
    patron.avanzarSiguienteEjercicio();
    pantalla.ocultarBotonSiguiente();
    
    // 2. Luego cargamos las imágenes de la nueva tira encima de esos recuadros blancos
    pantalla.cargarImagenesNivel(); 
    
    if (timerInactividad != null) timerInactividad.start();
}
    
    public boolean tiraPendiente() {
        return this.contadorFila <= 8;
    }
}