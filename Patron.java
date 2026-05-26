

public class Patron {
    
    private int ejercicioActualIndex = 0;

    // ===== RESPUESTAS CORRECTAS (independientes de las imágenes) =====
    private String[][] coloresCorrectos = {
        // Tira 1
        {"Naranja","Rojo","Azul","Amarillo","Morado","Celeste","Cafe","Verde"},
        // Tira 2
        {"Rojo","Verde","Azul","Celeste","Cafe","Morado","Amarillo","Naranja"},
        // Tira 3
        {"Cafe","Azul","Morado","Verde","Rojo","Amarillo","Naranja","Celeste"},
        // Tira 4
        {"Azul","Cafe","Celeste","Morado","Naranja","Rojo","Verde","Amarillo"},
        // Tira 5
        {"Celeste","Amarillo","Verde","Cafe","Azul","Naranja","Rojo","Morado"},
        // Tira 6
        {"Verde","Naranja","Morado","Celeste","Amarillo","Cafe","Azul","Rojo"}
    };

    private String[][] formasCorrectas = {
        // Tira 1
        {"Triangulo","Estrella","Corazon","Pentagono","Circulo","Cuadrado","Estrella","Circulo"},
        // Tira 2
        {"Pentagono","Circulo","Estrella","Cuadrado","Triangulo","Corazon","Cuadrado","Triangulo"},
        // Tira 3
        {"Cuadrado","Corazon","Circulo","Estrella","Pentagono","Triangulo","Corazon","Pentagono"},
        // Tira 4
        {"Circulo","Triangulo","Pentagono","Estrella","Corazon","Estrella","Triangulo","Cuadrado"},
        // Tira 5
        {"Corazon","Pentagono","Cuadrado","Circulo","Triangulo","Pentagono","Circulo","Estrella"},
        // Tira 6
        {"Estrella","Cuadrado","Triangulo","Corazon","Cuadrado","Cuadrado","Circulo","Corazon"}
    };

    // ===== RUTAS DE IMÁGENES (solo para mostrar visualmente) =====
    private String[][] rutasImagenes = {
        // Tira 1
        {
            "/trabajos/cordinacionvisualja/Tiras/TrianguloNaranja.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaRoja.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoAmarillo.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoMorado.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoCeleste.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoVerde.png"
        },
        // Tira 2
        {
            "/trabajos/cordinacionvisualja/Tiras/PentagonoRojo.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoVerde.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoCeleste.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonMorado.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoAmarillo.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloNaranja.png"
        },
        // Tira 3
        {
            "/trabajos/cordinacionvisualja/Tiras/CuadradoCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoMorado.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaVerde.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoRojo.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloAmarillo.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonNaranja.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoCeleste.png"
        },
        // Tira 4
        {
            "/trabajos/cordinacionvisualja/Tiras/CirculoAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoCeleste.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaMorada.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonNaranja.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaRoja.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloVerde.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoAmarillo.png"
        },
        // Tira 5
        {
            "/trabajos/cordinacionvisualja/Tiras/CorazonCeleste.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoAmarillo.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoVerde.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/PentagonoNaranja.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoRojo.png",
            "/trabajos/cordinacionvisualja/Tiras/EstrellaMorada.png"
        },
        // Tira 6
        {
            "/trabajos/cordinacionvisualja/Tiras/EstrellaVerde.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoNaranja.png",
            "/trabajos/cordinacionvisualja/Tiras/TrianguloMorado.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonCeleste.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoAmarillo.png",
            "/trabajos/cordinacionvisualja/Tiras/CuadradoCafe.png",
            "/trabajos/cordinacionvisualja/Tiras/CirculoAzul.png",
            "/trabajos/cordinacionvisualja/Tiras/CorazonRojo.png"
        }
    };

    // ===== MÉTODOS =====
    public String obtenerColorCorrecto(int index) {
        return coloresCorrectos[ejercicioActualIndex][index];
    }

    public String obtenerFormaCorrecta(int index) {
        return formasCorrectas[ejercicioActualIndex][index];
    }

    public String getRutaImagen(int filaIndex) {
        return rutasImagenes[ejercicioActualIndex][filaIndex];
    }

    public void avanzarSiguienteEjercicio() {
        if (ejercicioActualIndex < coloresCorrectos.length - 1) {
            ejercicioActualIndex++;
        }
    }

    public String getIdPatron() {
        return "Ejercicio " + (ejercicioActualIndex + 1);
    }

    public boolean hayMasEjercicios() {
        return ejercicioActualIndex < coloresCorrectos.length - 1;
    }
}