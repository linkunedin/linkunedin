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

    /**
     *
     * @return
     */
    
    
    public java.util.Date getFechaNac() {
        return fechaNac;
    }

    /**
     *
     * @param fechaNac
     */
    public void setFechaNac(java.util.Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     *
     * @return
     */
    public String getFechaNac2() {
        return fechaNac2;
    }

    /**
     *
     * @param fechaNac2
     */
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

    /**
     *
     * @return
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     *
     * @param usuarioId
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     *
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     *
     * @param ano
     * @param mes
     * @param dia
     */
    public void setFechaNac(String ano, String mes, String dia) {
        // de esta forma este metodo seria inutil
        
    }
    
    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public String getNomusuario() {
        return nomusuario;
    }

    /**
     *
     * @param nomusuario
     */
    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     *
     * @return
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     *
     * @param perfil
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     *
     * @return
     */
    public String getPdf() {
        return pdf;
    }

    /**
     *
     * @param pdf
     */
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
    
    
}
