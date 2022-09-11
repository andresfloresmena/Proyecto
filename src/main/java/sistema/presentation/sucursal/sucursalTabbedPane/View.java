package sistema.presentation.sucursal.sucursalTabbedPane;

import sistema.presentation.sucursal.sucursalTabbedPane.SucursalTableModel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

public class  View extends javax.swing.JFrame implements java.util.Observer   {

    private JTabbedPane tabbedPane;
    private JPanel panel;
    private JLabel referenciaLbl;
    private JTable sucursalesTable;
    private JButton borrarButton;
    private JButton reporteButton;
    private JTextField referenciaTxtField;
    private JButton buscarReferenciaButton;

    private JButton buscarButton;
    private JButton agregarEmpleadoBtn;
    private JButton agregarSucursalBtn;


    private JTable sucursales;



    public View() {

        buscarReferenciaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String texto = referenciaTxtField.getText();
                texto=texto.replaceAll(" ", "");
                if (texto.length() != 0) {
                    JOptionPane.showMessageDialog(null, "Buscando...");
                }else{
                    JOptionPane.showMessageDialog(null, "¡El campo no puede estar vacio!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        referenciaTxtField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar();
                boolean mayusculas = key >= 65 && key <= 90;
                boolean minusculas = key >= 97 && key <= 122;
                boolean espacio = key == 32;

                if (!(minusculas || mayusculas || espacio))
                {
                    e.consume();
                }
            }
        });


        agregarSucursalBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.sucursalesAgregar();
            }
        });
    }
    Controller controller;
    Model model;

    public void setController(Controller controllerPrincipal){
        this.controller = controllerPrincipal;
    }

    public Controller getController() {
        return controller;
    }

    public void setModel(Model model){
        this.model=model;
        model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {SucursalTableModel.CODIGO, SucursalTableModel.REFERENCIA, SucursalTableModel.DIRECCION, SucursalTableModel.ZONAJE};
        sucursalesTable.setModel(new SucursalTableModel(cols, model.getSucursales()));
        sucursalesTable.setRowHeight(30);
        this.panel.revalidate();


    }

    public JTable getSucursales() {
        return sucursales;
    }


    public void setSucursales(JTable sucursales) {
        this.sucursales = sucursales;
    }



    public JPanel getPanel() {
        return panel;
    }

}
