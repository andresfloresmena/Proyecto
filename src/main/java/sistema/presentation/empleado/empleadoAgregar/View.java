package sistema.presentation.empleado.empleadoAgregar;

import java.awt.event.*;
import java.util.Observable;

import sistema.application.Application;
import sistema.logic.Empleado;
import sistema.logic.Service;

import javax.swing.*;
import javax.swing.border.Border;


public class View extends javax.swing.JFrame implements java.util.Observer {
    Controller controller;
    Model model;
    private JPanel panel1;
    private JTextField sucursalEmpleadoTxt;
    private JTextField salarioEmpleadoTxt;
    private JTextField telefonoEmpleadoTxt;
    private JTextField nombreEmpleadoTxt;
    private JTextField cedulaEmpleadoTxt;
    private JButton guardarEmpleadoBtn;
    private JButton cancelarEmpleadoBtn;

    public View() {

       cancelarEmpleadoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setLabelsTxt();
                controller.hide();
                clearBordersFields();
            }
        });


        guardarEmpleadoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String campoCedula = cedulaEmpleadoTxt.getText();
                String campoNombre = nombreEmpleadoTxt.getText();
                String campoTelefono = telefonoEmpleadoTxt.getText();
                String campoSalario = salarioEmpleadoTxt.getText();
                String campoSucursal = sucursalEmpleadoTxt.getText();


                campoCedula = campoCedula.replaceAll(" ", "");
                campoNombre = campoNombre.replaceAll(" ", "");
                campoTelefono = campoTelefono.replaceAll(" ", "");
                campoSalario = campoSalario.replaceAll(" ", "");
                campoSucursal = campoSucursal.replaceAll(" ", "");



                if (campoNombre.isEmpty()) {
                    nombreEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }

                if (campoTelefono.isEmpty()) {
                    telefonoEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }

                if (campoSalario.isEmpty()) {
                    salarioEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }

                if (campoSucursal.isEmpty()) {
                    sucursalEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }

                if(validateFields()){
                    int value = JOptionPane.showConfirmDialog(null, "¿Desea guardar?");
                    double salarioParsiado = Double.valueOf(campoSalario);
                    if (JOptionPane.OK_OPTION == value) {
                        try {
                            Empleado a = Service.instance().empleadoGet(campoCedula);
                            if(!a.getCedula().equals(campoCedula)){
                                controller.EmpleadoAdd(new Empleado(campoCedula, campoNombre, campoTelefono, salarioParsiado, Service.instance().sucursaleSearch(campoSucursal)));
                                JOptionPane.showMessageDialog(null, "Guardado con exito");
                                setLabelsTxt();
                                controller.hide();
                                clearBordersFields();
                            }else{
                                JOptionPane.showMessageDialog (null, "Empleado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "¡Los campos no pueden estar vacios!", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        guardarEmpleadoBtn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String campoCedula = cedulaEmpleadoTxt.getText();
                    String campoNombre = nombreEmpleadoTxt.getText();
                    String campoTelefono = telefonoEmpleadoTxt.getText();
                    String campoSalario = salarioEmpleadoTxt.getText();
                    String campoSucursal = sucursalEmpleadoTxt.getText();


                    campoCedula = campoCedula.replaceAll(" ", "");
                    campoNombre = campoNombre.replaceAll(" ", "");
                    campoTelefono = campoTelefono.replaceAll(" ", "");
                    campoSalario = campoSalario.replaceAll(" ", "");
                    campoSucursal = campoSucursal.replaceAll(" ", "");
                    if(validateFields()){
                        int value = JOptionPane.showConfirmDialog(null, "¿Desea guardar?");
                        double salarioParsiado = Double.valueOf(campoSalario);
                        if (JOptionPane.OK_OPTION == value) {
                            try {
                                if(Service.instance().empleadoGet(campoCedula) == null)
                                controller.EmpleadoAdd(new Empleado(campoCedula, campoNombre, campoTelefono, salarioParsiado, Service.instance().sucursaleSearch(campoSucursal)));
                                JOptionPane.showMessageDialog(null, "Guardado con exito");
                                setLabelsTxt();
                                controller.hide();
                                clearBordersFields();
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Los campos no pueden estar vacios!", "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        cancelarEmpleadoBtn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    controller.hide();
                    clearBordersFields();
                }
            }
        });
        cedulaEmpleadoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(cedulaEmpleadoTxt.getText().isEmpty()){
                    cedulaEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }
            }
        });
        nombreEmpleadoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(nombreEmpleadoTxt.getText().isEmpty()){
                    nombreEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }
            }
        });

        telefonoEmpleadoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(telefonoEmpleadoTxt.getText().isEmpty()){
                    telefonoEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }
            }
        });

        salarioEmpleadoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(salarioEmpleadoTxt.getText().isEmpty()){
                    salarioEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }
            }
        });

        sucursalEmpleadoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(sucursalEmpleadoTxt.getText().isEmpty()){
                    sucursalEmpleadoTxt.setBorder(Application.BORDER_NOBORDER);
                }
            }
        });


    }

    Border b = cedulaEmpleadoTxt.getBorder();

    public void setController(Controller controller){
        this.controller=controller;
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

    private boolean validateFields() {
        boolean valid = true;
        Border b = cedulaEmpleadoTxt.getBorder();
        if (cedulaEmpleadoTxt.getText().isEmpty()) {
            valid = false;
            cedulaEmpleadoTxt.setBorder(Application.BORDER_ERROR);
        } else {
            cedulaEmpleadoTxt.setToolTipText(null);
            cedulaEmpleadoTxt.setBorder(b);
        }
        b = nombreEmpleadoTxt.getBorder();
        if (nombreEmpleadoTxt.getText().length() == 0) {
            valid = false;
            nombreEmpleadoTxt.setBorder(Application.BORDER_ERROR);
        } else {
            nombreEmpleadoTxt.setBorder(b);
            nombreEmpleadoTxt.setToolTipText(null);
        }
        b = telefonoEmpleadoTxt.getBorder();
        if (telefonoEmpleadoTxt.getText().length() == 0) {
            valid = false;
            telefonoEmpleadoTxt.setBorder(Application.BORDER_ERROR);
        } else {
            telefonoEmpleadoTxt.setBorder(b);
            telefonoEmpleadoTxt.setToolTipText(null);
        }
        b = salarioEmpleadoTxt.getBorder();
        if (salarioEmpleadoTxt.getText().length() == 0) {
            valid = false;
            salarioEmpleadoTxt.setBorder(Application.BORDER_ERROR);
        } else {
            salarioEmpleadoTxt.setBorder(b);
        }
        b = sucursalEmpleadoTxt.getBorder();
        if (sucursalEmpleadoTxt.getText().length() == 0) {
            valid = false;
            sucursalEmpleadoTxt.setBorder(Application.BORDER_ERROR);
        } else {
            sucursalEmpleadoTxt.setBorder(null);
        }
        return valid;
    }

    private void setLabelsTxt(){
        cedulaEmpleadoTxt.setText("");
        nombreEmpleadoTxt.setText("");
        telefonoEmpleadoTxt.setText("");
        salarioEmpleadoTxt.setText("");
        sucursalEmpleadoTxt.setText("");
    }

    private void clearBordersFields() {
        cedulaEmpleadoTxt.setBorder(b);
        nombreEmpleadoTxt.setBorder(b);
        telefonoEmpleadoTxt.setBorder(b);
        salarioEmpleadoTxt.setBorder(b);
        sucursalEmpleadoTxt.setBorder(b);
    }

    @Override
    public void update(Observable o, Object arg) {
        Empleado empleado = model.getEmpleado();

        cedulaEmpleadoTxt.setText(empleado.getCedula());
        nombreEmpleadoTxt.setText(empleado.getNombre());
        telefonoEmpleadoTxt.setText(empleado.getTelefono());
        salarioEmpleadoTxt.setText(String.valueOf(empleado.getSalario()));
        sucursalEmpleadoTxt.setText(empleado.getSucursal().getReferencia());

        //controller.getControllerPrincipal().getView().getEmpleados().setModel(new EmpleadoTableModel(model.getEmpleados()));


    }

    public JPanel getPanel1() {
        return panel1;
    }
}
