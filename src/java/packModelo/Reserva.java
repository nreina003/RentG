/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packModelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class Reserva {
    private Integer idReservas;
    private String email;
    private String matricula;
    private String fechaInicio;
    private String fechaFin;
    private String lugar;
    private String cocheRecogido;
    private String cocheEntregado;
    private String pagoExtra;
    private String retraso;

    public Reserva(Integer pIdReservas, String pEmail, String pMatricula, String pFechaInicio, String pFechaFin, String pLugar, String pCocheRecogido, String pCocheEntregado, String pPagoExtra, String pRetraso) {
       
        idReservas = pIdReservas;
        email = pEmail;
        matricula = pMatricula;
        fechaInicio = pFechaInicio;
        fechaFin = pFechaFin;
        lugar = pLugar;
        cocheRecogido = pCocheRecogido;
        cocheEntregado = pCocheEntregado;
        pagoExtra = pPagoExtra;
        retraso = pRetraso;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRetraso() {
        return retraso;
    }

    public void setRetraso(String retraso) {
        this.retraso = retraso;
    }


    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCocheRecogido() {
        return cocheRecogido;
    }

    public void setCocheRecogido(String cocheRecogido) {
        this.cocheRecogido = cocheRecogido;
    }

    public String getCocheEntregado() {
        return cocheEntregado;
    }

    public void setCocheEntregado(String cocheEntregado) {
        this.cocheEntregado = cocheEntregado;
    }

    public String getPagoExtra() {
        return pagoExtra;
    }

    public void setPagoExtra(String pagoExtra) {
        this.pagoExtra = pagoExtra;
    }

    

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }


}
