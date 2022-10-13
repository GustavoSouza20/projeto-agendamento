/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.DAO.EspecialidadeDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 22282225
 */
public class JPanelEspecialidades extends javax.swing.JPanel {

    /**
     * Creates new form JPanelEspecialidades
     */
    public JPanelEspecialidades() {
        initComponents();
        EspecialidadeDAO.criarListaDeEspecialidades();
        ajustarTabela();
        prenccherTabela();
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeEspecialidades = new javax.swing.JTable();
        buttonExcluir = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonAdicionar = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Especialidades ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 290));
        setLayout(null);

        tabelaDeEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaDeEspecialidades);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 780, 220);

        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/botao-x.png"))); // NOI18N
        buttonExcluir.setToolTipText("Excluir Especialidade");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });
        add(buttonExcluir);
        buttonExcluir.setBounds(660, 240, 130, 40);

        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/editar (1).png"))); // NOI18N
        buttonEditar.setToolTipText("Alterar Especialidade ");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });
        add(buttonEditar);
        buttonEditar.setBounds(530, 240, 130, 40);

        buttonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/adicionar.png"))); // NOI18N
        buttonAdicionar.setToolTipText("Adicionar Especialidade");
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });
        add(buttonAdicionar);
        buttonAdicionar.setBounds(400, 240, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        EspecialidadesJDialog d = new EspecialidadesJDialog(null, true);
        d.setVisible(true);
        prenccherTabela();

    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
       int linha = tabelaDeEspecialidades.getSelectedRow();
        if (linha != 1) {
            
            excluirEspecialidade(linha);
        }else{
            JOptionPane.showMessageDialog(this,
                    "Por Favor,Selecione a especialidade que você deseja excluir!!",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE);
        
        
        }
        
        
    }//GEN-LAST:event_buttonExcluirActionPerformed
    private void excluirEspecialidade(int linha){
    
    String codigoStr = tabelaDeEspecialidades.getValueAt(linha, 0).toString();
       Integer codigo = Integer.valueOf(codigoStr);
        
       int resposta = JOptionPane.showConfirmDialog(this, "você confirma a exclusão?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       EspecialidadeDAO.excluir(codigo);
       
       
       prenccherTabela();
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDeEspecialidades;
    // End of variables declaration//GEN-END:variables

    private void prenccherTabela() {

        
        tabelaDeEspecialidades.setModel(EspecialidadeDAO.getTabelaEspecialidades()); 
        ajustarTabela();
    }

    private  void ajustarTabela(){
    
        //Impedir que o usuario movemente as calunas
        tabelaDeEspecialidades.getTableHeader().setReorderingAllowed(false);
        
        //bloquear a edição das celulas da tabela
        tabelaDeEspecialidades.setDefaultEditor(Object.class, null);
        
        // Definir a largura das calunas
        tabelaDeEspecialidades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabelaDeEspecialidades.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaDeEspecialidades.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabelaDeEspecialidades.getColumnModel().getColumn(2).setPreferredWidth(490);
        
    }
    
    
}
