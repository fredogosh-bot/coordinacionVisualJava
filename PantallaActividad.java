

import javax.swing.JOptionPane;

public class PantallaActividad extends javax.swing.JFrame {

    /*========== Atributos ===========================================*/
    private ControlActividad controlador;
    private javax.swing.JLabel[] etiquetasTira;
    private String idPatronActual = "Ejercicio 1";
    private String tipoActividad = "Coordinacion Visual";

    /*========== Constructor =========================================*/
    public PantallaActividad() {
        initComponents();
        
        etiquetasTira = new javax.swing.JLabel[]{
            jLabel1, jLabel2, jLabel3, jLabel4,
            jLabel5, jLabel6, jLabel7, jLabel8
        };
        
        btnSiguiente.setVisible(false);
        lblAviso.setVisible(false);
        
        controlador = new ControlActividad(this);
        
        // Bienvenida - cronómetro arranca DESPUÉS de aceptar
        JOptionPane.showMessageDialog(null,
            "Que tal amigo, para esta actividad tendras que relacionar las figuras con los colores corresponientes en los recuadros centrales empesando " +
            "desde arriba hacia abajo, de izquierda hacia la derecha. TU PUEDES!!!;",
            "Instrucciones",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Arranca cronómetro, timer de inactividad y carga imágenes
        controlador.iniciarCronometro();
        
        reproducirAudioInstrucciones();
    }

    /*========== Carga de imágenes ===================================*/
    public void cargarImagenesNivel() {
        String[] rutas = new String[8];
        for (int i = 0; i < 8; i++) {
            rutas[i] = controlador.getRutaImagen(i);
        }
        cargarImagenesDesdeRutas(rutas);
    }
    
    public void cargarImagenesDesdeRutas(String[] rutas) {
    for (int i = 0; i < rutas.length && i < etiquetasTira.length; i++) {
        escalarImagen(rutas[i], etiquetasTira[i]);
    }
    }
    
private void escalarImagen(String ruta, javax.swing.JLabel label) {
    // getResource es el estándar de Maven que busca dentro de src/main/resources
    java.net.URL url = getClass().getResource(ruta);
    
    if (url != null) {
        javax.swing.ImageIcon icono = new javax.swing.ImageIcon(url);
        java.awt.Image imagen = icono.getImage().getScaledInstance(
            116, 111, 
            java.awt.Image.SCALE_SMOOTH
        );
        label.setIcon(new javax.swing.ImageIcon(imagen));
    } else {
        label.setIcon(null);
        System.err.println("❌ Error: No se encontró el recurso en: " + ruta);
    }
}

    /*========== Métodos de la pantalla ==============================*/
    public void eliminarFiguraDePantalla(int numeroFila) {
        int index = numeroFila - 1;
        if (index >= 0 && index < etiquetasTira.length) {
            etiquetasTira[index].setIcon(null);
            etiquetasTira[index].setOpaque(true);
            etiquetasTira[index].setBackground(PanelPrincipal.getBackground());
            etiquetasTira[index].repaint();
        }
    }
    
    public void resetearLabels() {
    for (int i = 0; i < etiquetasTira.length; i++) {
        etiquetasTira[i].setIcon(null); // Borra la imagen de la ronda anterior
        
        // 🔥 ESTO ES LO QUE ARREGLA TU PROBLEMA:
        etiquetasTira[i].setOpaque(true); // Le dice a Java que pinte el fondo del JLabel
        etiquetasTira[i].setBackground(java.awt.Color.WHITE); // Obliga a que el recuadro sea BLANCO
        
        etiquetasTira[i].repaint(); // Fuerza a la pantalla a redibujarse de inmediato
    }
}
    
    public void mostrarBotonSiguiente() {
        btnSiguiente.setVisible(true);
    }
    
    public void ocultarBotonSiguiente() {
        btnSiguiente.setVisible(false);
    }
    
    public void mostrarAviso() {
        lblAviso.setText("!!!Recuerda usar ambos dedos, al elegir las figuras");
        lblAviso.setVisible(true);
    }
    
    public void ocultarAviso() {
        lblAviso.setVisible(false);
    }
    
    public void mostrarMensajeAnimo() {
    lblAviso.setText("¡Bien hecho, sigue así! 💪");
    lblAviso.setVisible(true);
    
    new javax.swing.Timer(2000, e -> {
        lblAviso.setVisible(false);
        ((javax.swing.Timer)e.getSource()).stop();
    }).start();
}
    
    public void reproducirAudioInstrucciones() {
        // Reservado para audio futuro
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        PanelPrincipal = new javax.swing.JPanel();
        btnCirculoNaranja = new javax.swing.JButton();
        btnCirculoCafe = new javax.swing.JButton();
        btnCirculoMorado = new javax.swing.JButton();
        btnCirculoCeleste = new javax.swing.JButton();
        btnCirculoAzul = new javax.swing.JButton();
        btnCirculoRojo = new javax.swing.JButton();
        btnCirculoAmarillo = new javax.swing.JButton();
        btnCirculoVerde = new javax.swing.JButton();
        btnCirculoVacio = new javax.swing.JButton();
        btnCuadradoVacio = new javax.swing.JButton();
        btnTrianguloVacio = new javax.swing.JButton();
        btnPentagonoVacio = new javax.swing.JButton();
        btnEstrellaVacio = new javax.swing.JButton();
        btnCorazonVacio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(0, 153, 153));

        btnCirculoNaranja.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoNaranja.png")); // NOI18N
        btnCirculoNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoNaranjaActionPerformed(evt);
            }
        });

        btnCirculoCafe.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoCafe.png")); // NOI18N
        btnCirculoCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoCafeActionPerformed(evt);
            }
        });

        btnCirculoMorado.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoMorado.png")); // NOI18N
        btnCirculoMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoMoradoActionPerformed(evt);
            }
        });

        btnCirculoCeleste.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoCeleste.png")); // NOI18N
        btnCirculoCeleste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoCelesteActionPerformed(evt);
            }
        });

        btnCirculoAzul.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoAzul.png")); // NOI18N
        btnCirculoAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoAzulActionPerformed(evt);
            }
        });

        btnCirculoRojo.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CierculoRojo.png")); // NOI18N
        btnCirculoRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoRojoActionPerformed(evt);
            }
        });

        btnCirculoAmarillo.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CierculoAmarillo.png")); // NOI18N
        btnCirculoAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoAmarilloActionPerformed(evt);
            }
        });

        btnCirculoVerde.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CirculoVerde.png")); // NOI18N
        btnCirculoVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoVerdeActionPerformed(evt);
            }
        });

        btnCirculoVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CierculoVacio.png")); // NOI18N
        btnCirculoVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoVacioActionPerformed(evt);
            }
        });

        btnCuadradoVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CuadradoVacio.png")); // NOI18N
        btnCuadradoVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadradoVacioActionPerformed(evt);
            }
        });

        btnTrianguloVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\TrianguloVacio.png")); // NOI18N
        btnTrianguloVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloVacioActionPerformed(evt);
            }
        });

        btnPentagonoVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\PentagonoVacio.png")); // NOI18N
        btnPentagonoVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPentagonoVacioActionPerformed(evt);
            }
        });

        btnEstrellaVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\EstrellaVacio.png")); // NOI18N
        btnEstrellaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstrellaVacioActionPerformed(evt);
            }
        });

        btnCorazonVacio.setIcon(new javax.swing.ImageIcon("C:\\Users\\erick\\Documents\\BUAP\\Ingenieria en Software\\Cordinacion Visual\\CordinacionVisualJA\\src\\main\\java\\trabajos\\cordinacionvisualja\\Botones\\CorazonVacio.png")); // NOI18N
        btnCorazonVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorazonVacioActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(204, 0, 51));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR\n");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(51, 255, 0));
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jLabel1.setOpaque(true);

        jLabel2.setOpaque(true);

        jLabel3.setOpaque(true);

        jLabel4.setOpaque(true);

        jLabel5.setOpaque(true);

        jLabel6.setOpaque(true);

        jLabel7.setOpaque(true);

        jLabel8.setOpaque(true);

        lblAviso.setBackground(new java.awt.Color(255, 255, 51));
        lblAviso.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        lblAviso.setText("!!!Recuerda usar ambos dedos, al elejir las figuras");
        lblAviso.setOpaque(true);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCirculoMorado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCirculoVerde))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCirculoAmarillo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCirculoAzul))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCirculoRojo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCirculoCeleste)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnCirculoNaranja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCirculoCafe)
                                .addGap(44, 44, 44)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)))
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnCuadradoVacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCirculoVacio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPentagonoVacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrianguloVacio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnEstrellaVacio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorazonVacio))
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAviso)
                .addGap(110, 110, 110))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCirculoNaranja, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnCirculoCafe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCirculoVerde)
                                    .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCirculoAzul)
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(btnCirculoMorado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCirculoAmarillo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCirculoCeleste)
                                    .addComponent(btnCirculoRojo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCirculoVacio)
                            .addComponent(btnCuadradoVacio))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPentagonoVacio)
                            .addComponent(btnTrianguloVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEstrellaVacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCorazonVacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(lblAviso))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/*====================================BOTONES DE COLORES===========================*/    
    private void btnCirculoCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoCafeActionPerformed
        controlador.seleccionarColor("Cafe");
    }//GEN-LAST:event_btnCirculoCafeActionPerformed

    private void btnCirculoNaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoNaranjaActionPerformed
        controlador.seleccionarColor("Naranja");
    }//GEN-LAST:event_btnCirculoNaranjaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            if (controlador.tiraPendiente()) {
            System.exit(0); // Sale sin guardar si la tira está incompleta
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCirculoMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoMoradoActionPerformed
        controlador.seleccionarColor("Morado");
    }//GEN-LAST:event_btnCirculoMoradoActionPerformed

    private void btnCirculoCelesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoCelesteActionPerformed
        controlador.seleccionarColor("Celeste");
    }//GEN-LAST:event_btnCirculoCelesteActionPerformed

    private void btnCirculoAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoAzulActionPerformed
        controlador.seleccionarColor("Azul");
    }//GEN-LAST:event_btnCirculoAzulActionPerformed

    private void btnCirculoRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoRojoActionPerformed
        controlador.seleccionarColor("Rojo");
    }//GEN-LAST:event_btnCirculoRojoActionPerformed

    private void btnCirculoAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoAmarilloActionPerformed
        controlador.seleccionarColor("Amarillo");
    }//GEN-LAST:event_btnCirculoAmarilloActionPerformed

    private void btnCirculoVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoVerdeActionPerformed
        controlador.seleccionarColor("Verde");

    }//GEN-LAST:event_btnCirculoVerdeActionPerformed

/*====================================BOTONES DE FORMA===========================*/
    private void btnCuadradoVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadradoVacioActionPerformed
        controlador.seleccionarForma("Cuadrado");
    }//GEN-LAST:event_btnCuadradoVacioActionPerformed

    private void btnCirculoVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoVacioActionPerformed
        controlador.seleccionarForma("Circulo");
    }//GEN-LAST:event_btnCirculoVacioActionPerformed

    private void btnPentagonoVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPentagonoVacioActionPerformed
        controlador.seleccionarForma("Pentagono");
    }//GEN-LAST:event_btnPentagonoVacioActionPerformed

    private void btnTrianguloVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloVacioActionPerformed
        controlador.seleccionarForma("Triangulo");
    }//GEN-LAST:event_btnTrianguloVacioActionPerformed

    private void btnEstrellaVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstrellaVacioActionPerformed
        controlador.seleccionarForma("Estrella");
    }//GEN-LAST:event_btnEstrellaVacioActionPerformed

    private void btnCorazonVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorazonVacioActionPerformed
        controlador.seleccionarForma("Corazon");
    }//GEN-LAST:event_btnCorazonVacioActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
       controlador.ejecutarBotonSiguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btnCirculoAmarillo;
    private javax.swing.JButton btnCirculoAzul;
    private javax.swing.JButton btnCirculoCafe;
    private javax.swing.JButton btnCirculoCeleste;
    private javax.swing.JButton btnCirculoMorado;
    private javax.swing.JButton btnCirculoNaranja;
    private javax.swing.JButton btnCirculoRojo;
    private javax.swing.JButton btnCirculoVacio;
    private javax.swing.JButton btnCirculoVerde;
    private javax.swing.JButton btnCorazonVacio;
    private javax.swing.JButton btnCuadradoVacio;
    private javax.swing.JButton btnEstrellaVacio;
    private javax.swing.JButton btnPentagonoVacio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnTrianguloVacio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblAviso;
    // End of variables declaration//GEN-END:variables
}
