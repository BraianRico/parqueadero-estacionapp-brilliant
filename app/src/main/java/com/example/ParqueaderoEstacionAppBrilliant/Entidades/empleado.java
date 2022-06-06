package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class empleado implements Serializable {

    private String id_empleado;
    private String usr;
    private String password;


    //Se define el constructor
    public empleado(){}

    public empleado(String id_empleado, String usr, String password) {
        this.id_empleado = id_empleado;
        this.usr = usr;
        this.password = password;
    }

    //Getter y Setter
    public String getId_empleado() {return id_empleado;}
    public void setId_empleado(String id_empleado) {this.id_empleado = id_empleado;}
    public String getUsr() {return usr;}
    public void setUsr(String usr) {this.usr = usr;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
