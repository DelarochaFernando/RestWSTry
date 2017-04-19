package com.example.jmata.restwstry;

/**
 * Created by jmata on 17/04/2017.
 */
public class Persona {

    private String id;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Nacimiento;
    private String sexo;

    public Persona(String id, String nombre, String apellido1, String apellido2, String nacimiento,
    String sexo){

        this.id = id;
        this.Nombre = nombre;
        this.Apellido1 = apellido1;
        this.Apellido2 = apellido2;
        this.Nacimiento = nacimiento;
        this.sexo = sexo;
        //for updating purposes
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        Nacimiento = nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
