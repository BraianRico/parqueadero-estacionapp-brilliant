package com.example.ParqueaderoEstacionAppBrilliant;

import java.io.Serializable;

//Instancia para las vistas de las listas de celdas

public class Celdas implements Serializable {
    private Integer idCelda;
    private String ubicacion;

    public Celdas(Integer idCelda, String ubicacion) {
        this.idCelda = idCelda;
        this.ubicacion = ubicacion;
    }

    //Se define el constructor
    public Celdas(){ }

    //Getter y Setter
    public Integer getIdCelda() {
        return idCelda;
    }
    public void setIdCelda(Integer idCelda) {
        this.idCelda = idCelda;
    }
    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
