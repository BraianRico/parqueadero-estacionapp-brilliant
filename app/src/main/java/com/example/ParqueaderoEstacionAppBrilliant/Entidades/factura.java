package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class factura implements Serializable {

    private String fecha_factura;
    private Integer valor;
    private Integer meses;
    private Integer suscripcion_id;

    //Se define el constructor
    public  factura(){}
    public factura(Integer id_factura, String fecha_factura, Integer valor, Integer meses, Integer suscripcion_id) {
        this.id_factura = id_factura;
        this.fecha_factura = fecha_factura;
        this.valor = valor;
        this.meses = meses;
        this.suscripcion_id = suscripcion_id;
    }
    //Getter y Setter
    private Integer id_factura;
    public Integer getId_factura() {
        return id_factura;
    }
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }
    public String getFecha_factura() {
        return fecha_factura;
    }
    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Integer getMeses() {
        return meses;
    }
    public void setMeses(Integer meses) {
        this.meses = meses;
    }
    public Integer getSuscripcion_id() {
        return suscripcion_id;
    }
    public void setSuscripcion_id(Integer suscripcion_id) {
        this.suscripcion_id = suscripcion_id;
    }


}
