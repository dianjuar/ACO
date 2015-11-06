package main;

import Networking.*;
import Networking.base.Puertos;


public class InicioRobots_RecepsionDeDatos extends javax.swing.JFrame 
{
    private ResepcionDatos_VisionArtificial resMapa;
    private Conexion_SMA cSMA;
    public static int NfasesCompletadas;

    
    public InicioRobots_RecepsionDeDatos()
    {
        initComponents();
        
        NfasesCompletadas=0;
        
        resMapa = new ResepcionDatos_VisionArtificial(label_paso1,this);
        cSMA = new Conexion_SMA( label_paso2, this);
        Agentes.AgenteFisico.setConexSMA(cSMA);
    }
    
    public void faseCompletada()
    {
        NfasesCompletadas++;
        
        if( NfasesCompletadas == 2)
        {
            this.dispose();
            new FormRobots( cSMA.getNagentes(), 
                            cSMA.getVelocidadMaxima(),
                            cSMA.getVelocidadInicial(),
                            resMapa.getDistanciaEntreCuadros(), 
                            resMapa.getINT_mat()  ).setVisible(true);
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_paso1 = new javax.swing.JLabel();
        label_paso2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        jLabel1.setText("Esperando Parámetros del Módulo de Visión Artificial");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        jLabel2.setText("Esperando Parámetros del Módulo de Agentes Físicos");

        label_paso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/connecting45x45.gif"))); // NOI18N

        label_paso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Img/connecting45x45.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_paso2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_paso1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_paso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_paso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_paso1;
    private javax.swing.JLabel label_paso2;
    // End of variables declaration//GEN-END:variables
}
