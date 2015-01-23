package main;

//-Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true

import Agentes.AgenteFisico;
import Agentes.AgenteVirtual;
import MapaContexto.Mapa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.SlickException;

public class FormRobots extends javax.swing.JFrame 
{
    private Mapa m;
    
    private CanvasGameContainer contenedorDeLaSimulacion;
    private Game simulacion;
    
    private final String msjBotonEnEspera = "Empezar";
    private final String msjBotonSimulacion = "Parar";
    private boolean ejecutando;
    private final ImageIcon play, stop;
    
    private AgenteVirtual aVirtual[];
    
    public FormRobots()
    {
        ejecutando = false;
        play = new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/play.png"));
        stop = new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/stop.png"));
        
        initComponents();        

        
        crearMapa();
        
        try {
            cargarSimulacion();
        } catch (SlickException ex) {
            Logger.getLogger(FormRobots.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    private void cargarSimulacion() throws SlickException
    {
        simulacion = new Game(panelSimulacion.getWidth(), true);
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
        parametrosAgentes = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        SliderVelocidadVirtual = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CheckAgenteVirutal = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        comboBoxNAgentesVirtual = new javax.swing.JComboBox();
        LabelVelocidadAgenteVirtual1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        SliderVelocidadFisico = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        LabelVelocidadAgenteFisico = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CheckAgenteFisico = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        SliderTasaDeEvaporacion = new javax.swing.JSlider();
        LabelTasDeEvaporacion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        SliderAlfa = new javax.swing.JSlider();
        LabelAlfa = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        SliderBeta = new javax.swing.JSlider();
        LabelBeta = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        SliderQ = new javax.swing.JSlider();
        LabelQ = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textDistanciaEntreNodos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BotonEmpezarSimulacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setMinimumSize(null);

        Titulo.setFont(new java.awt.Font("Droid Sans Mono", 1, 36)); // NOI18N
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

        parametrosAgentes.setBackground(new java.awt.Color(197, 197, 197));
        parametrosAgentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros Agentes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        parametrosAgentes.setForeground(new java.awt.Color(1, 1, 1));
        parametrosAgentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        parametrosAgentes.setPreferredSize(new java.awt.Dimension(666, 666));

        jPanel10.setPreferredSize(new java.awt.Dimension(2, 89));

        SliderVelocidadVirtual.setMajorTickSpacing(15);
        SliderVelocidadVirtual.setPaintLabels(true);
        SliderVelocidadVirtual.setPaintTicks(true);
        SliderVelocidadVirtual.setValue(10);
        SliderVelocidadVirtual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderVelocidadVirtualStateChanged(evt);
            }
        });

        jLabel3.setText("Velocidad");

        jLabel4.setText("mts/s");

        CheckAgenteVirutal.setBackground(new java.awt.Color(197, 197, 197));
        CheckAgenteVirutal.setSelected(true);
        CheckAgenteVirutal.setText("Presentes en la visualización");

        jLabel5.setText("Numero De Agentes");

        comboBoxNAgentesVirtual.setMaximumRowCount(20);
        comboBoxNAgentesVirtual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" }));
        comboBoxNAgentesVirtual.setSelectedIndex(10);
        comboBoxNAgentesVirtual.setToolTipText("");

        LabelVelocidadAgenteVirtual1.setText("0.10");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxNAgentesVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CheckAgenteVirutal)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SliderVelocidadVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelVelocidadAgenteVirtual1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelVelocidadAgenteVirtual1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SliderVelocidadVirtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxNAgentesVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckAgenteVirutal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agentes Virtuales", jPanel10);

        jPanel9.setPreferredSize(new java.awt.Dimension(2, 89));

        SliderVelocidadFisico.setMajorTickSpacing(15);
        SliderVelocidadFisico.setPaintLabels(true);
        SliderVelocidadFisico.setPaintTicks(true);
        SliderVelocidadFisico.setValue(10);
        SliderVelocidadFisico.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderSliderVelocidadFisicoStateChanged(evt);
            }
        });

        jLabel1.setText("Velocidad");

        LabelVelocidadAgenteFisico.setText("0.10");

        jLabel2.setText("mts/s");

        CheckAgenteFisico.setBackground(new java.awt.Color(197, 197, 197));
        CheckAgenteFisico.setSelected(true);
        CheckAgenteFisico.setText("Presentes en la visualización");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CheckAgenteFisico)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SliderVelocidadFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelVelocidadAgenteFisico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SliderVelocidadFisico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelVelocidadAgenteFisico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(CheckAgenteFisico)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agentes Físicos", jPanel9);

        javax.swing.GroupLayout parametrosAgentesLayout = new javax.swing.GroupLayout(parametrosAgentes);
        parametrosAgentes.setLayout(parametrosAgentesLayout);
        parametrosAgentesLayout.setHorizontalGroup(
            parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        parametrosAgentesLayout.setVerticalGroup(
            parametrosAgentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(197, 197, 197));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros ACO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(1, 1, 1));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setPreferredSize(new java.awt.Dimension(666, 666));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setBackground(new java.awt.Color(197, 197, 197));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Tasa de Evap.");

        SliderTasaDeEvaporacion.setMajorTickSpacing(20);
        SliderTasaDeEvaporacion.setPaintLabels(true);
        SliderTasaDeEvaporacion.setPaintTicks(true);
        SliderTasaDeEvaporacion.setValue(10);
        SliderTasaDeEvaporacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderTasaDeEvaporacionStateChanged(evt);
            }
        });

        LabelTasDeEvaporacion.setText("0.10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderTasaDeEvaporacion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelTasDeEvaporacion, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SliderTasaDeEvaporacion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTasDeEvaporacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel4.setBackground(new java.awt.Color(197, 197, 197));

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel16.setBackground(new java.awt.Color(197, 197, 197));

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

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SliderAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(197, 197, 197));

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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SliderBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelBeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane2.setTopComponent(jPanel16);

        jPanel15.setBackground(new java.awt.Color(197, 197, 197));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Q");

        SliderQ.setMajorTickSpacing(10);
        SliderQ.setMinimum(1);
        SliderQ.setPaintTicks(true);
        SliderQ.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderQStateChanged(evt);
            }
        });

        LabelQ.setText("20");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SliderQ, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelQ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SliderQ, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(197, 197, 197));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros Contexto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Andale Mono", 0, 14), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(1, 1, 1));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setPreferredSize(new java.awt.Dimension(666, 666));

        jLabel9.setText("Distancia horizontal entre nodos");

        textDistanciaEntreNodos.setText("0.1");
        textDistanciaEntreNodos.setEnabled(false);

        jLabel10.setText("mts");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDistanciaEntreNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDistanciaEntreNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotonEmpezarSimulacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/PanelDeControl/play.png"))); // NOI18N
        BotonEmpezarSimulacion.setText("Empezar");
        BotonEmpezarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmpezarSimulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parametrosAgentes, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(BotonEmpezarSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parametrosAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonEmpezarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEmpezarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmpezarSimulacionActionPerformed
        
        
        if(ejecutando)
        {
            //Se detubo la simulacion            
            BotonEmpezarSimulacion.setText(msjBotonEnEspera);            
            simulacion.enterState(Game.STATE_EnEspera);
            BotonEmpezarSimulacion.setIcon(play);
            
            comboBoxNAgentesVirtual.setEnabled(true);
        }
        else
        {
             cargarVariables();
          
            comboBoxNAgentesVirtual.setEnabled(false);
            
             BotonEmpezarSimulacion.setText(msjBotonSimulacion);   
             BotonEmpezarSimulacion.setIcon(stop);
             
             int numeroDeAgentes = Integer.valueOf((String) comboBoxNAgentesVirtual.getItemAt(comboBoxNAgentesVirtual.getSelectedIndex() ) );
              
             m.inicializarGrafoFeromonas(numeroDeAgentes);
              aVirtual = new AgenteVirtual[numeroDeAgentes];
              
             for (int i = 0; i < aVirtual.length; i++)              
                aVirtual[i] = new AgenteVirtual(i, AgenteVirtual.velocidad, Mapa.cuadroInicial);
             
            
             simulacion.getGameSimulacion().setaVirtual(aVirtual);
            
             simulacion.enterState( Game.STATE_Ejecucion );
        }
            
        ejecutando = !ejecutando;
    }//GEN-LAST:event_BotonEmpezarSimulacionActionPerformed
    
    private final int convertQ=1;
    private final int convertaAlfa=100;
    private final int convertaBeta=100;
    private final int convertaVelicidadAF=100;
    private final int convertaVelicidadAV=100;
    private final int convertaEvap=100;
    
    private void cargarVariables()
    {
        AgenteFisico.velocidad = 
                sliderToFloat(SliderVelocidadVirtual, LabelVelocidadAgenteFisico,convertaVelicidadAF);
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
    }
    
    private float sliderToFloat(javax.swing.JSlider s, JLabel l, int convert)
    {
        float valor = (float) s.getValue()/convert;
        l.setText(String.valueOf(valor));
            
        return valor;
    }
    
    private void SliderSliderVelocidadFisicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderSliderVelocidadFisicoStateChanged
        AgenteFisico.velocidad = 
                sliderToFloat(SliderVelocidadVirtual, LabelVelocidadAgenteFisico, convertaVelicidadAF);
    }//GEN-LAST:event_SliderSliderVelocidadFisicoStateChanged
    
    private void SliderVelocidadVirtualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderVelocidadVirtualStateChanged
        AgenteVirtual.velocidad =
                sliderToFloat(SliderVelocidadVirtual, LabelVelocidadAgenteVirtual1, convertaVelicidadAV);
    }//GEN-LAST:event_SliderVelocidadVirtualStateChanged

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

    private void crearMapa()
    {
        
        //se supone que la matriz y la longitud la da el modulo de visión artifical 
        int mat[][] =    {{1,1,1,1,1,1,1,1}
                        ,{1,0,0,0,0,0,3,1}
                        ,{1,0,1,1,1,0,0,1}
                        ,{1,0,1,1,0,1,0,1}
                        ,{1,0,1,0,1,1,0,1}
                        ,{1,0,0,1,1,1,0,1}
                        ,{1,2,0,0,0,0,0,1}
                        ,{1,1,1,1,1,1,1,1}
                        };
        
        /*int mat[][] =    {{0,0,3}                     
                         ,{0,0,0}
                         ,{2,1,0}
                         };*/
        
        m = new Mapa(mat);

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
            java.util.logging.Logger.getLogger(FormRobots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRobots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRobots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRobots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRobots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEmpezarSimulacion;
    private javax.swing.JCheckBox CheckAgenteFisico;
    private javax.swing.JCheckBox CheckAgenteVirutal;
    private javax.swing.JLabel LabelAlfa;
    private javax.swing.JLabel LabelBeta;
    private javax.swing.JLabel LabelQ;
    private javax.swing.JLabel LabelTasDeEvaporacion;
    private javax.swing.JLabel LabelVelocidadAgenteFisico;
    private javax.swing.JLabel LabelVelocidadAgenteVirtual1;
    private javax.swing.JSlider SliderAlfa;
    private javax.swing.JSlider SliderBeta;
    private javax.swing.JSlider SliderQ;
    private javax.swing.JSlider SliderTasaDeEvaporacion;
    private javax.swing.JSlider SliderVelocidadFisico;
    private javax.swing.JSlider SliderVelocidadVirtual;
    private javax.swing.JLabel Titulo;
    private javax.swing.JComboBox comboBoxNAgentesVirtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelSimulacion;
    private javax.swing.JPanel parametrosAgentes;
    private javax.swing.JTextField textDistanciaEntreNodos;
    // End of variables declaration//GEN-END:variables
}
