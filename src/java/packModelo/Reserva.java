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
    private Integer idReserva;
    private String email;
    private String matricula;
    private Date fechaInicio;
    private Date fechaFin;
    private String lugar;
    private String cocheRecogido;
    private String cocheEntregado;
    private String pagoExtra;
    private Time retraso;

    public Reserva(Integer pIdReserva, String pEmail, String pMatricula, Date pFechaInicio, Date pFechaFin, String pLugar, String pCocheRecogido, String pCocheEntregado, String pPagoExtra, Time pRetraso) {
       
        idReserva = pIdReserva;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Time getRetraso() {
        return retraso;
    }

    public void setRetraso(Time retraso) {
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

    

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }


}
