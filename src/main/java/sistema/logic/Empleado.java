package sistema.logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;


@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    @XmlID
    private String cedula;
    private String nombre;
    private String telefono;
    private double salario;
    private String sucursal;


    public Empleado(String cedula, String nombre, String telefono, double salario, String sucursal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
        this.sucursal = sucursal;

    }

    public Empleado() {
        this.cedula = "";
        this.nombre = "";
        this.telefono = "";
        this.salario = 0;
        this.sucursal = "";

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }



    @Override
    public String toString() {
        return "Empleado{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", salario=" + salario +
                ", sucursal='" + sucursal + '\'' +
                '}';
    }
}
