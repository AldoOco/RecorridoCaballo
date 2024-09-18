/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballoAj;
import java.util.Random;
/**
 *
 * @author aldoo
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Random aleatorio = new Random();
        int x = 1;  // El caballo inicia en la casilla superior izquierda
        int y = 1;
        int tamano = 8; // El arreglo es de ocho x ocho
        int contador = 1; // Esta variable lleva la cuenta de las casillas
                           // recorridas
        int ciclos = 0;           // Esta variable cuenta los ciclos que se inten
                           // tan antes de determinar que ya no hay lugares
                           // a los cuales ir                           
        int intentos_fallidos = 0;
        String result = "";
        int Arreglo[][] = new int[tamano + 1][tamano +1];
// Se define el arreglo de 9*9 para evitar el 0
        Arreglo[1][1] = 1;
        int dado1;
        int dado2;
        int casillas_requeridas = 64;
 
// Debido a que se usara la fuerza bruta de la computacion para encontrar un
// recorrido completo se anade este while

        while ( contador < casillas_requeridas ){
            intentos_fallidos++;  // Se incrementa cada que inicia un intento
            contador = 1;    // Dado que ya se ha colocado al caballo en (1,1), se 
                   // inicia el contador en 1
            ciclos = 0;   // Se inicia con 0 ciclos o lanzamientos de dados infructuosos
// Cada vez que se aborta un intento han de limipiarse las casillas, con el siguiente
//par de ciclos se establecen a 0 nuevamente.

        for ( int s = 0; s <= tamano; s++ ){       // Abre for
            for ( int t = 0; t <= tamano; t++ )
                Arreglo[s][t] = 0;
        }       // cierra for
 
//Se ha de colocar el caballo en la esquina superior izquierda cada vez
// desde luego se puede poner en cualquier parte
        x = 1;
        y = 1;
 
        Arreglo[1][1] = 1;
// Mientras no se encuentre un lugar para poner al caballo

        while ( 1000 != ciclos)
// Este ciclo while basicamente se verifica si ya se paso por ahí o si el movimiento que esta por hacerse es legal
            {  // Abre while
            ciclos++;
            dado1 = 1 + aleatorio.nextInt(8);
            dado2 = 1 + aleatorio.nextInt(8);

            if ( Math.abs(Math.abs(x) - Math.abs(dado1)) == 2)
            { // Abre if
                if ( Math.abs(Math.abs(y) - Math.abs(dado2)) == 1  )
 
            if ( 0 == Arreglo[dado1][dado2])
            {   // Abre if
            Arreglo[dado1][dado2] = ++contador;   
            x = dado1;
            y = dado2;
            ciclos = 0;
            }  // Cierra if
            }  //Cierra if

 
            if ( Math.abs(Math.abs(x) - Math.abs(dado1)) == 1)
            {  // abre if
            if ( Math.abs(Math.abs(y) - Math.abs(dado2)) == 2  )
            if ( 0 == Arreglo[dado1][dado2] )
            {    // Abre if
            Arreglo[dado1][dado2] = ++contador;
            x = dado1;
            y = dado2;
            ciclos = 0;
            }  // Cierra if
            }  // Cierra if
 
            }  // Cierra while anidado
            }    // Cierra while
            result += "\nLISTO!";
            result += "\nEl caballo recorrio las 64 casillas.\n";
            for ( int k = 1; k <= 8; k++ )
            {
            for ( int j = 1; j <= 8; j++)
            {   
                //System.out.printf("%5d", Arreglo[k][j]);
                result += Arreglo[k][j] +"\t";    
                } 
            result += "\n";
            }
            
            
            jTextArea2.setText(result);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String result = "";
        jTextArea2.setText(result);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
