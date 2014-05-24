/*
 * JGuperView.java
 */

package jguperapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;
import jguperapp.tables.ClienteView;
import jguperapp.tables.CompraView;
import jguperapp.tables.EquipoView;
import jguperapp.tables.FuncionariosView;
import jguperapp.tables.ProductoView;
import jguperapp.tables.ProveedorView;
import jguperapp.tables.RecursosView;
import jguperapp.tables.ServicioView;
import jguperapp.tables.UsuarioView;
import jguperapp.tables.VentaView;
import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.TaskMonitor;

/**
 * The application's main frame.
 */
public class JGuperView extends FrameView {

    public JGuperView(SingleFrameApplication app) {
        super(app);

        initComponents();
        initFrames();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
            aboutBox = new JGuperAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        JGuperApp.getApplication().show(aboutBox);
    }
    
    @Action
    public void newCliente(){
        JFrame frame = new JFrame("Cliente");
        frame.setContentPane(clienteView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newCompra(){
        JFrame frame = new JFrame("Compra");
        frame.setContentPane(compraView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newEquipo(){
        JFrame frame = new JFrame("Equipo");
        frame.setContentPane(equipoView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newFuncionarios(){
        JFrame frame = new JFrame("Funcionarios");
        frame.setContentPane(funcionariosView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newProducto(){
        JFrame frame = new JFrame("Producto");
        frame.setContentPane(productoView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newProveedor(){
        JFrame frame = new JFrame("Proveedor");
        frame.setContentPane(proveedorView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newRecurso(){
        JFrame frame = new JFrame("Recursos");
        frame.setContentPane(recursosView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newServicio(){
        JFrame frame = new JFrame("Servicio");
        frame.setContentPane(servicioView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newUsuario(){
        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(usuarioView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }
    
    @Action
    public void newVenta(){
        JFrame frame = new JFrame("Venta");
        frame.setContentPane(ventaView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        JFrame mainFrame = JGuperApp.getApplication().getMainFrame();
        frame.setLocationRelativeTo(mainFrame);
        JGuperApp.getApplication().show(frame);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnEquipo = new javax.swing.JButton();
        btnFuncionario = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnRecursos = new javax.swing.JButton();
        btnServicio = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu mFile = new javax.swing.JMenu();
        mNuevo = new javax.swing.JMenu();
        miNCliente = new javax.swing.JMenuItem();
        miNCompra = new javax.swing.JMenuItem();
        miNEquipo = new javax.swing.JMenuItem();
        miNFuncionarios = new javax.swing.JMenuItem();
        miNProduct = new javax.swing.JMenuItem();
        miNProvee = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem miSalir = new javax.swing.JMenuItem();
        javax.swing.JMenu MHelp = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(jguperapp.JGuperApp.class).getContext().getActionMap(JGuperView.class, this);
        btnCliente.setAction(actionMap.get("newCliente")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(jguperapp.JGuperApp.class).getContext().getResourceMap(JGuperView.class);
        btnCliente.setText(resourceMap.getString("btnCliente.text")); // NOI18N
        btnCliente.setName("btnCliente"); // NOI18N

        btnCompra.setAction(actionMap.get("newCompra")); // NOI18N
        btnCompra.setText(resourceMap.getString("btnCompra.text")); // NOI18N
        btnCompra.setName("btnCompra"); // NOI18N

        btnEquipo.setAction(actionMap.get("newEquipo")); // NOI18N
        btnEquipo.setText(resourceMap.getString("btnEquipo.text")); // NOI18N
        btnEquipo.setName("btnEquipo"); // NOI18N

        btnFuncionario.setAction(actionMap.get("newFuncionarios")); // NOI18N
        btnFuncionario.setText(resourceMap.getString("btnFuncionario.text")); // NOI18N
        btnFuncionario.setName("btnFuncionario"); // NOI18N

        btnProducto.setAction(actionMap.get("newProducto")); // NOI18N
        btnProducto.setText(resourceMap.getString("btnProducto.text")); // NOI18N
        btnProducto.setName("btnProducto"); // NOI18N

        btnProveedor.setAction(actionMap.get("newProveedor")); // NOI18N
        btnProveedor.setText(resourceMap.getString("btnProveedor.text")); // NOI18N
        btnProveedor.setName("btnProveedor"); // NOI18N

        btnRecursos.setAction(actionMap.get("newRecurso")); // NOI18N
        btnRecursos.setText(resourceMap.getString("btnRecursos.text")); // NOI18N
        btnRecursos.setName("btnRecursos"); // NOI18N

        btnServicio.setAction(actionMap.get("newServicio")); // NOI18N
        btnServicio.setText(resourceMap.getString("btnServicio.text")); // NOI18N
        btnServicio.setName("btnServicio"); // NOI18N

        btnUsuario.setAction(actionMap.get("newUsuario")); // NOI18N
        btnUsuario.setText(resourceMap.getString("btnUsuario.text")); // NOI18N
        btnUsuario.setName("btnUsuario"); // NOI18N

        btnVenta.setAction(actionMap.get("newVenta")); // NOI18N
        btnVenta.setText(resourceMap.getString("btnVenta.text")); // NOI18N
        btnVenta.setName("btnVenta"); // NOI18N

        jButton1.setAction(actionMap.get("quit")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(btnRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(161, 161, 161))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCliente)
                    .addComponent(btnProducto))
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompra)
                    .addComponent(btnProveedor))
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEquipo)
                    .addComponent(btnRecursos))
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionario)
                    .addComponent(btnServicio))
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuario)
                    .addComponent(btnVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        btnVenta.getAccessibleContext().setAccessibleName(resourceMap.getString("btnVenta.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        mFile.setText(resourceMap.getString("mFile.text")); // NOI18N
        mFile.setName("mFile"); // NOI18N

        mNuevo.setText(resourceMap.getString("mNuevo.text")); // NOI18N
        mNuevo.setName("mNuevo"); // NOI18N

        miNCliente.setAction(actionMap.get("newCliente")); // NOI18N
        miNCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        miNCliente.setText(resourceMap.getString("miNCliente.text")); // NOI18N
        miNCliente.setName("miNCliente"); // NOI18N
        mNuevo.add(miNCliente);

        miNCompra.setAction(actionMap.get("newCompra")); // NOI18N
        miNCompra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        miNCompra.setText(resourceMap.getString("miNCompra.text")); // NOI18N
        miNCompra.setName("miNCompra"); // NOI18N
        mNuevo.add(miNCompra);

        miNEquipo.setAction(actionMap.get("newEquipo")); // NOI18N
        miNEquipo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        miNEquipo.setText(resourceMap.getString("miNEquipo.text")); // NOI18N
        miNEquipo.setName("miNEquipo"); // NOI18N
        mNuevo.add(miNEquipo);

        miNFuncionarios.setAction(actionMap.get("newFuncionarios")); // NOI18N
        miNFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        miNFuncionarios.setText(resourceMap.getString("miNFuncionarios.text")); // NOI18N
        miNFuncionarios.setName("miNFuncionarios"); // NOI18N
        mNuevo.add(miNFuncionarios);

        miNProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        miNProduct.setText(resourceMap.getString("miNProduct.text")); // NOI18N
        miNProduct.setName("miNProduct"); // NOI18N
        mNuevo.add(miNProduct);

        miNProvee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        miNProvee.setText(resourceMap.getString("miNProvee.text")); // NOI18N
        miNProvee.setName("miNProvee"); // NOI18N
        mNuevo.add(miNProvee);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        mNuevo.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        mNuevo.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        mNuevo.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        mNuevo.add(jMenuItem4);

        mFile.add(mNuevo);

        miSalir.setAction(actionMap.get("quit")); // NOI18N
        miSalir.setText(resourceMap.getString("miSalir.text")); // NOI18N
        miSalir.setName("miSalir"); // NOI18N
        mFile.add(miSalir);

        menuBar.add(mFile);

        MHelp.setText(resourceMap.getString("MHelp.text")); // NOI18N
        MHelp.setName("MHelp"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        MHelp.add(aboutMenuItem);

        menuBar.add(MHelp);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addGap(122, 122, 122)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusAnimationLabel)
                        .addContainerGap())))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnEquipo;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRecursos;
    private javax.swing.JButton btnServicio;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu mNuevo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miNCliente;
    private javax.swing.JMenuItem miNCompra;
    private javax.swing.JMenuItem miNEquipo;
    private javax.swing.JMenuItem miNFuncionarios;
    private javax.swing.JMenuItem miNProduct;
    private javax.swing.JMenuItem miNProvee;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    
    private ClienteView clienteView;
    private CompraView compraView;
    private EquipoView equipoView;
    private FuncionariosView funcionariosView;
    private ProductoView productoView;
    private ProveedorView proveedorView;
    private RecursosView recursosView;
    private ServicioView servicioView;
    private UsuarioView usuarioView;
    private VentaView ventaView;

    private void initFrames(){
        clienteView = new ClienteView();
        compraView = new CompraView();
        equipoView = new EquipoView();
        funcionariosView = new FuncionariosView();
        productoView = new ProductoView();
        proveedorView = new ProveedorView();
        recursosView = new RecursosView();
        servicioView = new ServicioView();
        usuarioView = new UsuarioView();
        ventaView = new VentaView();
    }
}
