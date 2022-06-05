package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class cliente implements Serializable {

    private Integer id_cliente;
    private String correo;
    private Integer usuario_id;
    private Integer suscripcion_id;

    //Se define el constructor
    public cliente(Integer id_cliente, String correo, Integer usuario_id, Integer suscripcion_id) {
        this.usuario_id = usuario_id;
        this.id_cliente = id_cliente;
        this.suscripcion_id= suscripcion_id;
        this.correo = correo;
    }

    //Getter y Setter
    public Integer getId_cliente() {return id_cliente;}
    public void setId_cliente(Integer id_cliente) {this.id_cliente = id_cliente;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public Integer getUsuario_id() {return usuario_id;}
    public void setUsuario_id(Integer usuario_id) {this.usuario_id = usuario_id;}
    public Integer getSuscripcion_id() {return suscripcion_id;}
    public void setSuscripcion_id(Integer suscripcion_id) {this.suscripcion_id = suscripcion_id;}
}
