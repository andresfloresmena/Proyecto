package sistema.presentation.empleado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.application.Application;
import sistema.logic.Empleado;
import sistema.logic.Service;


public class Controller {
    Model model;
    View view;

    public Controller(Model modelEmpleado, View viewEmpleado) {
        this.model = modelEmpleado;
        this.view = viewEmpleado;

        modelEmpleado.setEmpleado(new Empleado());
        modelEmpleado.setEmpleados(new ArrayList<>());
        modelEmpleado.setEmpleados(Service.instance().empleadoAll());
        modelEmpleado.setSucursales(Service.instance().sucursalAll());

        view.setModel(modelEmpleado);
        view.setController(this);
    }


    public void show(){
        Application.window.setContentPane(view.getPanel1());
        Application.window.setVisible(true);
    }

    public void hide(){
        this.view.setVisible(false);
        Application.PRINCIPAL.show();
    }


    public void EmpleadoGet(String cedula){
        try {
            Empleado Empleado = Service.instance().empleadoGet(cedula);
            model.setEmpleado(Empleado);
            model.setEmpleados(Arrays.asList(Empleado));
            model.commit();
        } catch (Exception ex) {
            model.setEmpleado(new Empleado());
            model.setEmpleados(new ArrayList<>());
            model.commit();
        }
    }


    public void  EmpleadoSearch(String cedula){
        List<Empleado> Empleados= Service.instance().empleadoSearch(cedula);
        model.setEmpleado(new Empleado(cedula,"", "", 0,"", 0));
        model.setEmpleados(Empleados);
        model.commit();
    }

    public void EmpleadoEdit(int row){
        Empleado Empleado = model.getEmpleados().get(row);
        model.setEmpleado(Empleado);
        model.commit();
    }

    public void EmpleadoAdd(Empleado Empleado){
        try {
            Service.instance().empleadoAdd(Empleado);
            model.setEmpleado(new Empleado("","", "", 0, "", 0));
            model.setEmpleados(Arrays.asList(Empleado));
            model.commit();
        } catch (Exception ex) {

        }

    }
}
