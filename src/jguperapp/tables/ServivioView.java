/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jguperapp.tables;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Adrianlrx <adrianlrx@gmail.com>
 */
public class ServivioView extends JPanel {
    
    public ServivioView() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(jguperapp.JGuperApp.class).getContext().getResourceMap(ServivioView.class);
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(resourceMap.getString("entityManager.persistenceUnit")).createEntityManager(); // NOI18N
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(resourceMap.getString("query.query")); // NOI18N
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        serCodigoLabel = new javax.swing.JLabel();
        cliCodigoLabel = new javax.swing.JLabel();
        eqCodigoLabel = new javax.swing.JLabel();
        funCodigoLabel = new javax.swing.JLabel();
        serEstadoLabel = new javax.swing.JLabel();
        serMontoLabel = new javax.swing.JLabel();
        serCodigoField = new javax.swing.JTextField();
        cliCodigoField = new javax.swing.JTextField();
        eqCodigoField = new javax.swing.JTextField();
        funCodigoField = new javax.swing.JTextField();
        serEstadoField = new javax.swing.JTextField();
        serMontoField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setName("Form"); // NOI18N

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${serCodigo}"));
        columnBinding.setColumnName("Ser Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliCodigo}"));
        columnBinding.setColumnName("Cli Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${eqCodigo}"));
        columnBinding.setColumnName("Eq Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${funCodigo}"));
        columnBinding.setColumnName("Fun Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${serEstado}"));
        columnBinding.setColumnName("Ser Estado");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${serMonto}"));
        columnBinding.setColumnName("Ser Monto");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);

        masterScrollPane.setViewportView(masterTable);

        serCodigoLabel.setText(resourceMap.getString("serCodigoLabel.text")); // NOI18N
        serCodigoLabel.setName("serCodigoLabel"); // NOI18N

        cliCodigoLabel.setText(resourceMap.getString("cliCodigoLabel.text")); // NOI18N
        cliCodigoLabel.setName("cliCodigoLabel"); // NOI18N

        eqCodigoLabel.setText(resourceMap.getString("eqCodigoLabel.text")); // NOI18N
        eqCodigoLabel.setName("eqCodigoLabel"); // NOI18N

        funCodigoLabel.setText(resourceMap.getString("funCodigoLabel.text")); // NOI18N
        funCodigoLabel.setName("funCodigoLabel"); // NOI18N

        serEstadoLabel.setText(resourceMap.getString("serEstadoLabel.text")); // NOI18N
        serEstadoLabel.setName("serEstadoLabel"); // NOI18N

        serMontoLabel.setText(resourceMap.getString("serMontoLabel.text")); // NOI18N
        serMontoLabel.setName("serMontoLabel"); // NOI18N

        serCodigoField.setName("serCodigoField"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.serCodigo}"), serCodigoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), serCodigoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        cliCodigoField.setName("cliCodigoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cliCodigo}"), cliCodigoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), cliCodigoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        eqCodigoField.setName("eqCodigoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.eqCodigo}"), eqCodigoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), eqCodigoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        funCodigoField.setName("funCodigoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.funCodigo}"), funCodigoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), funCodigoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        serEstadoField.setName("serEstadoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.serEstado}"), serEstadoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), serEstadoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        serMontoField.setName("serMontoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.serMonto}"), serMontoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), serMontoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(formListener);

        refreshButton.setText(resourceMap.getString("refreshButton.text")); // NOI18N
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(formListener);

        newButton.setText(resourceMap.getString("newButton.text")); // NOI18N
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(formListener);

        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serCodigoLabel)
                    .addComponent(cliCodigoLabel)
                    .addComponent(eqCodigoLabel)
                    .addComponent(funCodigoLabel)
                    .addComponent(serEstadoLabel)
                    .addComponent(serMontoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serCodigoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(cliCodigoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(eqCodigoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(funCodigoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(serEstadoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(serMontoField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serCodigoLabel)
                    .addComponent(serCodigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliCodigoLabel)
                    .addComponent(cliCodigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eqCodigoLabel)
                    .addComponent(eqCodigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funCodigoLabel)
                    .addComponent(funCodigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serEstadoLabel)
                    .addComponent(serEstadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serMontoLabel)
                    .addComponent(serMontoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                ServivioView.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                ServivioView.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ServivioView.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ServivioView.this.deleteButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<jguperapp.tables.Servicio> toRemove = new ArrayList<jguperapp.tables.Servicio>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            jguperapp.tables.Servicio s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(s);
            entityManager.remove(s);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        jguperapp.tables.Servicio s = new jguperapp.tables.Servicio();
        entityManager.persist(s);
        list.add(s);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<jguperapp.tables.Servicio> merged = new ArrayList<jguperapp.tables.Servicio>(list.size());
            for (jguperapp.tables.Servicio s : list) {
                merged.add(entityManager.merge(s));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cliCodigoField;
    private javax.swing.JLabel cliCodigoLabel;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField eqCodigoField;
    private javax.swing.JLabel eqCodigoLabel;
    private javax.swing.JTextField funCodigoField;
    private javax.swing.JLabel funCodigoLabel;
    private java.util.List<jguperapp.tables.Servicio> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField serCodigoField;
    private javax.swing.JLabel serCodigoLabel;
    private javax.swing.JTextField serEstadoField;
    private javax.swing.JLabel serEstadoLabel;
    private javax.swing.JTextField serMontoField;
    private javax.swing.JLabel serMontoLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(ServivioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServivioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServivioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServivioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ServivioView());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
