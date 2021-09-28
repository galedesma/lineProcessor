package com.accenture.lineProcessor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Line {
    private String fecha;
    private String tipoReporte;
    private String tipoDato;
    private String subtipoDato;
    private String valor;
    private String fechaProceso;
    private String idCarga;

    public Line(){

    }

    public Line(String fecha, String tipoReporte, String tipoDato, String subtipoDato, String valor, String fechaProceso, String idCarga){
        this.fecha = fecha;
        this.tipoReporte = tipoReporte;
        this.tipoDato = tipoDato;
        this.subtipoDato = subtipoDato;
        this.valor = valor;
        this.fechaProceso = fechaProceso;
        this.idCarga = idCarga;
    }
}
