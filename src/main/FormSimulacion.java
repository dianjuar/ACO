package main;

//-Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true

import Agentes.AgenteVirtual;
import MapaContexto.Mapa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static main.EnEsperaSimulacion.mat;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.SlickException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FormSimulacion extends javax.swing.JFrame 
{    
    private CanvasGameContainer contenedorDeLaSimulacion;
    private Game simulacion;

    private boolean ejecutando;
    private final ImageIcon play, stop;
    
    private AgenteVirtual aVirtual[];
    
    private JFileChooser fc;
    private final String extesionDeLosMapas;
        
    public FormSimulacion()
    {
        ejecutando = false;
        play = new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/play.png"));
        stop = new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/stop.png"));
        
        initComponents();        
        
        try {
            cargarSimulacion();
        } catch (SlickException ex) {
            Logger.getLogger(FormSimulacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        cargarVariables();
        
        
        extesionDeLosMapas = "mapaco";
        
        fc = new JFileChooser( System.getProperty("user.home") );
        FileNameExtensionFilter filtroACO = new FileNameExtensionFilter("Mapa de Simulación (*."+extesionDeLosMapas+")",extesionDeLosMapas);
        fc.setFileFilter(filtroACO);
    }
    
    private void cargarSimulacion() throws SlickException
    {
        simulacion = new Game(panelSimulacion.getWidth(), false);
        contenedorDeLaSimulacion = new CanvasGameContainer( simulacion);        
        contenedorDeLaSimulacion.setBounds(0, 0, Game.width, Game.width);
        contenedorDeLaSimulacion.getContainer().setAlwaysRender(true);       
        contenedorDeLaSimulacion.requestFocus();
        contenedorDeLaSimulacion.start();     
        panelSimulacion.add( contenedorDeLaSimulacion );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        panelSimulacion = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        SliderAlfa = new javax.swing.JSlider();
        LabelAlfa = new javax.swing.JLabel();
        SliderBeta = new javax.swing.JSlider();
        LabelBeta = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        SliderQ = new javax.swing.JSlider();
        LabelQ = new javax.swing.JLabel();
        LabelTasDeEvaporacion = new javax.swing.JLabel();
        SliderTasaDeEvaporacion = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LabelDistanciaHEntreNodos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SliderDistanciaEntreNodos = new javax.swing.JSlider();
        SliderTamanoDelGrafo = new javax.swing.JSlider();
        jLabel10 = new javax.swing.JLabel();
        LabelTamanoDelGrafo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CheckBoxGrafoPorDefecto = new javax.swing.JCheckBox();
        parametrosAgentes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SliderVelocidadVirtual = new javax.swing.JSlider();
        LabelVelocidadAgenteVirtual1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SliderNumeroDeAgentes = new javax.swing.JSlider();
        LabelNumeroDeAgentes = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        Nuevo = new javax.swing.JButton();
        BotonEmpezarSimulacion = new javax.swing.JButton();
        AbrirMapaGuardado = new javax.swing.JButton();
        GuardarMapa = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setMinimumSize(null);

        Titulo.setFont(new java.awt.Font("Droid Sans Mono", 1, 30)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Ant Colony Optimization (ACO)");
        Titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanel5.setBackground(new java.awt.Color(197, 197, 197));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Animación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(1, 1, 1));
        jPanel5.setPreferredSize(new java.awt.Dimension(666, 666));

        panelSimulacion.setPreferredSize(new java.awt.Dimension(647, 647));

        javax.swing.GroupLayout panelSimulacionLayout = new javax.swing.GroupLayout(panelSimulacion);
        panelSimulacion.setLayout(panelSimulacionLayout);
        panelSimulacionLayout.setHorizontalGroup(
            panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        panelSimulacionLayout.setVerticalGroup(
            panelSimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panelSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(197, 197, 197));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros ACO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(1, 1, 1));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setPreferredSize(new java.awt.Dimension(666, 666));

        jPanel13.setBackground(new java.awt.Color(197, 197, 197));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Alfa");

        SliderAlfa.setMajorTickSpacing(100);
        SliderAlfa.setMaximum(1000);
        SliderAlfa.setPaintTicks(true);
        SliderAlfa.setValue(150);
        SliderAlfa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderAlfaStateChanged(evt);
            }
        });

        LabelAlfa.setText("1.5");

        SliderBeta.setMajorTickSpacing(10);
        SliderBeta.setMaximum(0);
        SliderBeta.setMinimum(-100);
        SliderBeta.setPaintTicks(true);
        SliderBeta.setToolTipText("");
        SliderBeta.setValue(-20);
        SliderBeta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderBetaStateChanged(evt);
            }
        });

        LabelBeta.setText("-0.2");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Beta");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Q");

        SliderQ.setMajorTickSpacing(5);
        SliderQ.setMaximum(50);
        SliderQ.setMinimum(1);
        SliderQ.setPaintTicks(true);
        SliderQ.setValue(25);
        SliderQ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderQStateChanged(evt);
            }
        });

        LabelQ.setText("25.0");

        LabelTasDeEvaporacion.setText("0.10");

        SliderTasaDeEvaporacion.setMajorTickSpacing(20);
        SliderTasaDeEvaporacion.setPaintLabels(true);
        SliderTasaDeEvaporacion.setPaintTicks(true);
        SliderTasaDeEvaporacion.setValue(10);
        SliderTasaDeEvaporacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTasaDeEvaporacionStateChanged(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Tasa de Evaporacion");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderTasaDeEvaporacion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(LabelTasDeEvaporacion)
                .addGap(38, 38, 38))
            .addComponent(jSeparator2)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SliderAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderQ, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelQ, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SliderTasaDeEvaporacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTasDeEvaporacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SliderAlfa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SliderBeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(SliderQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel13.getAccessibleContext().setAccessibleName("");

        jPanel8.setBackground(new java.awt.Color(197, 197, 197));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros Contexto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(1, 1, 1));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setPreferredSize(new java.awt.Dimension(666, 666));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Distancia horizontal");

        LabelDistanciaHEntreNodos.setText("0.1");
        LabelDistanciaHEntreNodos.setEnabled(false);

        jLabel6.setText("mts");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("entre nodos");

        SliderDistanciaEntreNodos.setMajorTickSpacing(100);
        SliderDistanciaEntreNodos.setMaximum(1000);
        SliderDistanciaEntreNodos.setMinimum(1);
        SliderDistanciaEntreNodos.setPaintTicks(true);
        SliderDistanciaEntreNodos.setValue(10);
        SliderDistanciaEntreNodos.setEnabled(false);
        SliderDistanciaEntreNodos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderDistanciaEntreNodosStateChanged(evt);
            }
        });

        SliderTamanoDelGrafo.setMajorTickSpacing(5);
        SliderTamanoDelGrafo.setMaximum(30);
        SliderTamanoDelGrafo.setMinimum(3);
        SliderTamanoDelGrafo.setPaintTicks(true);
        SliderTamanoDelGrafo.setValue(8);
        SliderTamanoDelGrafo.setEnabled(false);
        SliderTamanoDelGrafo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTamanoDelGrafoStateChanged(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Tamaño del Grafo");

        LabelTamanoDelGrafo.setText("8.0");
        LabelTamanoDelGrafo.setEnabled(false);

        jLabel7.setText("NxN");

        CheckBoxGrafoPorDefecto.setSelected(true);
        CheckBoxGrafoPorDefecto.setText("¿Grafo por Defecto?");
        CheckBoxGrafoPorDefecto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CheckBoxGrafoPorDefectoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderTamanoDelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTamanoDelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CheckBoxGrafoPorDefecto)
                .addGap(112, 112, 112))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderDistanciaEntreNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelDistanciaHEntreNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(CheckBoxGrafoPorDefecto)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SliderTamanoDelGrafo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTamanoDelGrafo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(SliderDistanciaEntreNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(LabelDistanciaHEntreNodos, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parametrosAgentes.setBackground(new java.awt.Color(197, 197, 197));
        parametrosAgentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros Agentes Virtuales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        parametrosAgentes.setForeground(new java.awt.Color(1, 1, 1));
        parametrosAgentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        parametrosAgentes.setPreferredSize(new java.awt.Dimension(666, 666));

        jLabel3.setText("Velocidad");

        SliderVelocidadVirtual.setMajorTickSpacing(50);
        SliderVelocidadVirtual.setMaximum(500);
        SliderVelocidadVirtual.setPaintTicks(true);
        SliderVelocidadVirtual.setValue(10);
        SliderVelocidadVirtual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderVelocidadVirtualStateChanged(evt);
            }
        });

        LabelVelocidadAgenteVirtual1.setText("0.10");

        jLabel4.setText("mts/s");

        jLabel5.setText("Numero de Agentes");

        SliderNumeroDeAgentes.setMajorTickSpacing(50);
        SliderNumeroDeAgentes.setMaximum(300);
        SliderNumeroDeAgentes.setMinimum(1);
        SliderNumeroDeAgentes.setPaintLabels(true);
        SliderNumeroDeAgentes.setPaintTicks(true);
        SliderNumeroDeAgentes.setValue(10);
        SliderNumeroDeAgentes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderNumeroDeAgentesStateChanged(evt);
            }
        });

        LabelNumeroDeAgentes.setText("10");

        javax.swing.GroupLayout parametrosAgentesLayout = new javax.swing.GroupLayout(parametrosAgentes);
        parametrosAgentes.setLayout(parametrosAgentesLayout);
        parametrosAgentesLayout.setHorizontalGroup(
            parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametrosAgentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderVelocidadVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(LabelVelocidadAgenteVirtual1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
            .addGroup(parametrosAgentesLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderNumeroDeAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelNumeroDeAgentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        parametrosAgentesLayout.setVerticalGroup(
            parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametrosAgentesLayout.createSequentialGroup()
                .addGroup(parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LabelVelocidadAgenteVirtual1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(parametrosAgentesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SliderVelocidadVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametrosAgentesLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(parametrosAgentesLayout.createSequentialGroup()
                        .addGroup(parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderNumeroDeAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(parametrosAgentesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LabelNumeroDeAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel10.setBackground(new java.awt.Color(197, 197, 197));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros Contexto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(1, 1, 1));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.setPreferredSize(new java.awt.Dimension(666, 666));

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/nuevo.png"))); // NOI18N
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        BotonEmpezarSimulacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/play.png"))); // NOI18N
        BotonEmpezarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmpezarSimulacionActionPerformed(evt);
            }
        });

        AbrirMapaGuardado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/open.png"))); // NOI18N
        AbrirMapaGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirMapaGuardadoActionPerformed(evt);
            }
        });

        GuardarMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/guardar.png"))); // NOI18N
        GuardarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarMapaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AbrirMapaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GuardarMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEmpezarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonEmpezarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AbrirMapaGuardado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GuardarMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(parametrosAgentes, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(parametrosAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEmpezarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmpezarSimulacionActionPerformed
        
        boolean errores = false;
        
        if(ejecutando)
        {
            //Se detubo la simulacion                   
            simulacion.enterState(Game.STATE_EnEspera);
            BotonEmpezarSimulacion.setIcon(play);
            
        }
        else
        {
            if( EnEsperaSimulacion.puntoFinal == null || EnEsperaSimulacion.puntoInicial == null )
            {
                JOptionPane.showMessageDialog(null, 
                                              "Debe establecer un punto final e inicial", //Mensaje
                                              "Punto inicial o final noestablecido", //Título
                                              JOptionPane.WARNING_MESSAGE); //Tipo de mensaje
                errores = true;
            }
            else
            {
                cargarVariables();            
                BotonEmpezarSimulacion.setIcon(stop);
                int numeroDeAgentes = SliderNumeroDeAgentes.getValue();

                Game.setMapa(new Mapa(mat));
                Game.mapa.inicializarGrafoFeromonas(numeroDeAgentes);

                aVirtual = new AgenteVirtual[numeroDeAgentes];

                for (int i = 0; i < aVirtual.length; i++)              
                   aVirtual[i] = new AgenteVirtual(i, AgenteVirtual.velocidad, Mapa.cuadroInicial);


                simulacion.getGameSimulacion().setaVirtual(aVirtual);

                simulacion.enterState( Game.STATE_Ejecucion );    
            }             
        }
            
        if(!errores)
        {
            activarElementos(ejecutando);
            ejecutando = !ejecutando;
        }
    }//GEN-LAST:event_BotonEmpezarSimulacionActionPerformed
    
    private void activarElementos(boolean active)
    {
        SliderNumeroDeAgentes.setEnabled(active);
        LabelNumeroDeAgentes.setEnabled(active);
        
        CheckBoxGrafoPorDefecto.setEnabled(active);
        
        SliderTamanoDelGrafo.setEnabled(active);
        LabelTamanoDelGrafo.setEnabled(active);
        SliderDistanciaEntreNodos.setEnabled(active);
        LabelDistanciaHEntreNodos.setEnabled(active);
        
        
        //-----
        SliderTamanoDelGrafo.setEnabled(!CheckBoxGrafoPorDefecto.isSelected() && active);
        SliderDistanciaEntreNodos.setEnabled(!CheckBoxGrafoPorDefecto.isSelected() && active);
        LabelTamanoDelGrafo.setEnabled(!CheckBoxGrafoPorDefecto.isSelected() && active);
        LabelDistanciaHEntreNodos.setEnabled(!CheckBoxGrafoPorDefecto.isSelected() && active);
        
    }
    
    private final int convertQ=1;
    private final int convertaAlfa=100;
    private final int convertaBeta=100;
    private final int convertaVelicidadAV=100;
    private final int convertaEvap=100;
    private final int convertDistanciaHEntreNodos=100;
    private final int convertTamanoDelGrafo=1;
    private final int convertNumeroAgentes=1;    
    
    private void cargarVariables()
    {
        AgenteVirtual.velocidad =
                        sliderToFloat(SliderVelocidadVirtual, LabelVelocidadAgenteVirtual1, convertaVelicidadAV);
        ACO.VariablesACO.TasaDeEvaporacionFeromona = 
                        sliderToFloat( SliderTasaDeEvaporacion, LabelTasDeEvaporacion, convertaEvap);
        ACO.VariablesACO.Alfa = 
                        sliderToFloat(SliderAlfa, LabelAlfa,convertaAlfa);
        ACO.VariablesACO.Beta = 
                        sliderToFloat(SliderBeta, LabelBeta,convertaBeta);
        ACO.VariablesACO.Q = 
                        sliderToFloat(SliderQ, LabelQ,convertQ);
        
        Mapa.setLongitudArcoHorizontal( 
                sliderToFloat(SliderDistanciaEntreNodos, LabelDistanciaHEntreNodos, convertDistanciaHEntreNodos) );
        Game.setImgTamanosyEscalas( SliderTamanoDelGrafo.getValue() );
    }
    
    private float sliderToFloat(javax.swing.JSlider s, JLabel l, int convert)
    {
        float valor = (float) s.getValue()/convert;
        l.setText(String.valueOf(valor));
            
        return valor;
    }
        
    private void SliderTasaDeEvaporacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderTasaDeEvaporacionStateChanged
        ACO.VariablesACO.TasaDeEvaporacionFeromona = 
                sliderToFloat( SliderTasaDeEvaporacion, LabelTasDeEvaporacion, convertaEvap);
    }//GEN-LAST:event_SliderTasaDeEvaporacionStateChanged

    private void SliderAlfaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderAlfaStateChanged
        ACO.VariablesACO.Alfa = 
                sliderToFloat(SliderAlfa, LabelAlfa, convertaAlfa);
    }//GEN-LAST:event_SliderAlfaStateChanged

    private void SliderBetaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderBetaStateChanged
        ACO.VariablesACO.Beta = 
                sliderToFloat(SliderBeta, LabelBeta, convertaBeta);
    }//GEN-LAST:event_SliderBetaStateChanged

    private void SliderQStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderQStateChanged
        ACO.VariablesACO.Q = 
                sliderToFloat(SliderQ, LabelQ, convertQ);
    }//GEN-LAST:event_SliderQStateChanged

    private void SliderVelocidadVirtualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderVelocidadVirtualStateChanged
        AgenteVirtual.velocidad =
                sliderToFloat(SliderVelocidadVirtual, LabelVelocidadAgenteVirtual1, convertaVelicidadAV);
    }//GEN-LAST:event_SliderVelocidadVirtualStateChanged

    private void SliderDistanciaEntreNodosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderDistanciaEntreNodosStateChanged
        Mapa.setLongitudArcoHorizontal( 
                sliderToFloat(SliderDistanciaEntreNodos, LabelDistanciaHEntreNodos, convertDistanciaHEntreNodos) );
    }//GEN-LAST:event_SliderDistanciaEntreNodosStateChanged

    private void SliderTamanoDelGrafoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderTamanoDelGrafoStateChanged
        
        EnEsperaSimulacion.setMat( 
                (int) sliderToFloat(SliderTamanoDelGrafo, LabelTamanoDelGrafo, convertTamanoDelGrafo) );
        
    }//GEN-LAST:event_SliderTamanoDelGrafoStateChanged

    private void CheckBoxGrafoPorDefectoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CheckBoxGrafoPorDefectoStateChanged
        SliderTamanoDelGrafo.setEnabled(!CheckBoxGrafoPorDefecto.isSelected());
        SliderDistanciaEntreNodos.setEnabled(!CheckBoxGrafoPorDefecto.isSelected());
        LabelTamanoDelGrafo.setEnabled(!CheckBoxGrafoPorDefecto.isSelected());
        LabelDistanciaHEntreNodos.setEnabled(!CheckBoxGrafoPorDefecto.isSelected());
        
        if(CheckBoxGrafoPorDefecto.isSelected())
        {
            SliderTamanoDelGrafo.setValue(8);
            SliderDistanciaEntreNodos.setValue(10); 
            EnEsperaSimulacion.setMatPorDefecto();
            EnEsperaSimulacion.bloquearEdicion(true);
        }
        else
            EnEsperaSimulacion.bloquearEdicion(false);
    }//GEN-LAST:event_CheckBoxGrafoPorDefectoStateChanged

    private void SliderNumeroDeAgentesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderNumeroDeAgentesStateChanged
        sliderToFloat(SliderNumeroDeAgentes, LabelNumeroDeAgentes, convertNumeroAgentes);
    }//GEN-LAST:event_SliderNumeroDeAgentesStateChanged

    private void AbrirMapaGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirMapaGuardadoActionPerformed
      
        if(fc.showOpenDialog(AbrirMapaGuardado) == JFileChooser.APPROVE_OPTION) 
        {
                try
                {   
                //Creamos el objeto del archivo que vamos a leer
                File archivoActual = fc.getSelectedFile();

                //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
                FileReader lectorArchivo = new FileReader(archivoActual);

                //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
                BufferedReader br = new BufferedReader(lectorArchivo);

                String l="";
                //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo

                String aux="";/*variable auxiliar*/

                while(true)
                //este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
                {
                    aux=br.readLine();
                    //leemos una linea de texto y la guardamos en la variable auxiliar

                    if(aux!=null)
                        l=l+aux+"\n";
                        /*si la variable aux tiene datos se va acumulando en la variable l,
                        * en caso de ser nula quiere decir que ya nos hemos leido todo
                        * el archivo de texto*/
                    else
                        break;
                }

                br.close();
                lectorArchivo.close();
                
                CheckBoxGrafoPorDefecto.setSelected(false);
                EnEsperaSimulacion.setMat(l,SliderTamanoDelGrafo);
            }
            catch(IOException e)
            {
                System.err.println("Error al abrir el archivo");
            }
            
        }
        
    }//GEN-LAST:event_AbrirMapaGuardadoActionPerformed
    
    private void GuardarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarMapaActionPerformed
       
        if(fc.showSaveDialog(GuardarMapa)==JFileChooser.APPROVE_OPTION)
        {
            try
            {
                FileWriter w;
                
                w = new FileWriter( fc.getSelectedFile()+"."+extesionDeLosMapas );
                w.write( matToText() );
                w.close();
                
            }
            catch(IOException e)
            {
                System.err.println("Error al escribir en el archivo");
            };
        }
        
    }//GEN-LAST:event_GuardarMapaActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
       
        CheckBoxGrafoPorDefecto.setSelected(false);
        EnEsperaSimulacion.setMat(      
                (int) sliderToFloat(SliderTamanoDelGrafo, LabelTamanoDelGrafo, convertTamanoDelGrafo) );
        
    }//GEN-LAST:event_NuevoActionPerformed

    private String matToText()
    {
        String sMat = "";
        
        for (int i = 0; i < mat.length; i++) 
        {
            for (int j = 0; j < mat.length; j++) 
            {
                sMat += String.valueOf( mat[i][j] );
            }
            
            if(i != mat.length -1)
                sMat += "\n";
            else
                sMat += "END";
        }
        
        return sMat;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirMapaGuardado;
    private javax.swing.JButton BotonEmpezarSimulacion;
    private javax.swing.JCheckBox CheckBoxGrafoPorDefecto;
    private javax.swing.JButton GuardarMapa;
    private javax.swing.JLabel LabelAlfa;
    private javax.swing.JLabel LabelBeta;
    private javax.swing.JLabel LabelDistanciaHEntreNodos;
    private javax.swing.JLabel LabelNumeroDeAgentes;
    private javax.swing.JLabel LabelQ;
    private javax.swing.JLabel LabelTamanoDelGrafo;
    private javax.swing.JLabel LabelTasDeEvaporacion;
    private javax.swing.JLabel LabelVelocidadAgenteVirtual1;
    private javax.swing.JButton Nuevo;
    private javax.swing.JSlider SliderAlfa;
    private javax.swing.JSlider SliderBeta;
    private javax.swing.JSlider SliderDistanciaEntreNodos;
    private javax.swing.JSlider SliderNumeroDeAgentes;
    private javax.swing.JSlider SliderQ;
    private javax.swing.JSlider SliderTamanoDelGrafo;
    private javax.swing.JSlider SliderTasaDeEvaporacion;
    private javax.swing.JSlider SliderVelocidadVirtual;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel panelSimulacion;
    private javax.swing.JPanel parametrosAgentes;
    // End of variables declaration//GEN-END:variables
}