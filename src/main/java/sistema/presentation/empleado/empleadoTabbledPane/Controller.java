package sistema.presentation.empleado.empleadoTabbledPane;

import sistema.application.Application;
import sistema.logic.Empleado;
import sistema.logic.Service;
import sistema.presentation.empleado.empleadoTabbledPane.Controller;
import sistema.presentation.empleado.empleadoTabbledPane.Model;

import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller( View view, Model model) {
        model.setEmpleados(Service.instance().empleadosSearch(""));
        this.model = model;
        this.view = view;

        view.setModel(model);
        view.setController(this);
    }

    public void show(){
        Application.window.setContentPane(view.getPanel());
    }

    public void hide(){

        this.view.setVisible(false);
    }

    public void exit(){
        Service.instance().store();
    }

    public void searchEmpleado(String filtro){
        List<Empleado> rows = Service.instance().empleadosSearch(filtro);
        model.setEmpleados(Service.instance().empleadosSearch(filtro));
        model.commit();
    }

    public void empleadosAgregar(){
        this.hide();
        Application.EMPLEADOS_AGREGAR.show();
    }


    public View getView() {
        return view;
    }
}