package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class celda implements Serializable {

    private Integer id_celda;
    private String ubicacion;
    private Boolean estado;
    private String placa_id;

    //Se define el constructor
    public celda(Integer id_celda, String ubicacion, Boolean estado, String placa_id) {
        this.id_celda = id_celda;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.placa_id = placa_id;
    }

    //Getter y Setter
    public String getPlaca_id() {return placa_id;}
    public void setPlaca_id(String placa_id) {this.placa_id = placa_id;}
    public Integer getId_celda() {return id_celda;}
    public void setId_celda(Integer id_celda) {this.id_celda = id_celda;}
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}
    public Boolean getEstado() {return estado;}
    public void setEstado(Boolean estado) {this.estado = estado;}
}
