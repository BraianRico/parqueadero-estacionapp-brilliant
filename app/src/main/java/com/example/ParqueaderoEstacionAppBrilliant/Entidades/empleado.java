package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class empleado implements Serializable {

    private Integer id_empleado;
    private String usr;
    private String password;
    private Integer usuario_id;


    //Se define el constructor
    public empleado(){}

    public empleado(Integer id_empleado, String usr, String password, Integer usuario_id) {
        this.id_empleado = id_empleado;
        this.usr = usr;
        this.password = password;
        this.usuario_id = usuario_id;
    }

    //Getter y Setter
    public Integer getUsuario_id() {return usuario_id;}
    public void setUsuario_id(Integer usuario_id) {this.usuario_id = usuario_id;}
    public Integer getId_empleado() {return id_empleado;}
    public void setId_empleado(Integer id_empleado) {this.id_empleado = id_empleado;}
    public String getUsr() {return usr;}
    public void setUsr(String usr) {this.usr = usr;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
