/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.Controlador.Forms;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Administrador
 */
public class EntradaModificarPerfilForm extends org.apache.struts.action.ActionForm {
    
    private String nombre, apellidos, nomusuario, email, foto, perfil, pdf, location, password, error;
    private int usuarioId;
    private java.util.Date fechaNac;
    private String fechaNac2;
    
    //private FormFile fotoFile;
    //private FormFile pdfFile;
    
    
    /*public FormFile getFotoFile(){
        return fotoFile;
    }
    public FormFile getPdfFile(){
        return pdfFile;
    }
    
    public void setFotoFile(FormFile fotoFile){
        this.foto = fotoFile.getFileName();
        this.fotoFile = fotoFile;
    }
    
    public void setPdfFile(FormFile pdfFile){
        this.pdf = pdfFile.getFileName();
        this.pdfFile = pdfFile;
    }*/
    
    public java.util.Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(java.util.Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFechaNac2() {
        return fechaNac2;
    }

   
    public void setFechaNac2(String fechaNac2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fnac;
        fnac= new java.util.Date();
        
        try{
            fnac =  formatter.parse(fechaNac2);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(fnac);
        this.fechaNac2 = fechaNac2;
        this.fechaNac = fnac;
    }
    /**
     *
     */
    public EntradaModificarPerfilForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        return errors;
    }

 
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



    public void setFechaNac(String ano, String mes, String dia) {
        // de esta forma este metodo seria inutil
        
    }
    
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
    
    
}
