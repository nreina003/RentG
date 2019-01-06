/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packModelo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Responsable {

    private Integer idrs;
    private String nombre;
    private String contraseña;
    private String email;
    private String movil;
    private String foto;
    private Integer dni;

    public Responsable(Integer pIdrs, String pNombre, String pContraseña, String pEmail, String pMovil, String pFoto, Integer pDni) {
        idrs = pIdrs;
        nombre = pNombre;
        contraseña = pContraseña;
        email = pEmail;
        movil = pMovil;
        foto = pFoto;
        dni = pDni;
    }

    public Integer getIdrs() {
        return idrs;
    }

    public void setIdrs(Integer idrs) {
        this.idrs = idrs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
