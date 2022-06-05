package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class suscripcion implements Serializable {

    private Integer id_suscripcion;
    private String fecha_inicio;
    private String fecha_final;
    private Integer estado_suscripcion;
    private Integer celda_id;

    //Se define el constructor
        public suscripcion(Integer id_suscripcion, String fecha_inicio, String fecha_final, Integer estado_suscripcion, Integer celda_id) {
        this.id_suscripcion = id_suscripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.estado_suscripcion = estado_suscripcion;
        this.celda_id = celda_id;
    }

    //Getter y Setter
    public Integer getId_suscripcion() {
        return id_suscripcion;
    }
    public void setId_suscripcion(Integer id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public String getFecha_final() {
        return fecha_final;
    }
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
    public Integer getEstado() {
        return estado_suscripcion;
    }
    public void setEstado(Integer estado) {
        this.estado_suscripcion = estado;
    }
    public Integer getCelda_id() {
        return celda_id;
    }
    public void setCelda_id(Integer celda_id) {
        this.celda_id = celda_id;
    }
}
