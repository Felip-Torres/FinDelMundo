/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.dto;

import java.sql.Date;

/**
 *
 * @author Alumne
 */
public class Intent {
    private int id, idUsuari, idEjercicio, idReview;
    private Date Inici, Fi;
    private String Videofile, Estado;
    
    public Intent(){
        
    }

    public Intent(int id, int idUsuari, int idEjercicio, int idReview, Date IniciDate, Date Fi, String Videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idEjercicio = idEjercicio;
        this.idReview = idReview;
        this.Inici = IniciDate;
        this.Fi = Fi;
        this.Videofile = Videofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(int val) {
        if(idReview!=0){
            if(val<3){
                this.Estado="Suspendido";
            }else{
                this.Estado="Aprobado";
            }
        }else{
            this.Estado="Pendiente";
        }
            
    }

    public Date getInici() {
        return Inici;
    }

    public void setInici(Date Inici) {
        this.Inici = Inici;
    }

    public Date getFi() {
        return Fi;
    }

    public void setFi(Date Fi) {
        this.Fi = Fi;
    }

    public String getVideofile() {
        return Videofile;
    }

    public void setVideofile(String Videofile) {
        this.Videofile = Videofile;
    }

    @Override
    public String toString() {
        return "Intent{" + "id=" + id + ", idUsuari=" + idUsuari + ", idEjercicio=" + idEjercicio + ", IniciDate=" + Inici + ", Fi=" + Fi + ", Videofile=" + Videofile + '}';
    }
    
    public String[] toArrayString() {
        String[] st = new String[8];
    
        // Convertimos los atributos a String y los asignamos al array
        st[0] = String.valueOf(id); 
        st[1] = String.valueOf(idUsuari);
        st[2] = String.valueOf(idEjercicio);
        st[3] = (Inici != null) ? Inici.toString() : "";
        st[4] = (Fi != null) ? Fi.toString() : "";
        st[5] = Videofile;
        st[6] = String.valueOf(idReview); 
        st[7] = Estado;
    
    return st;
}
    
    
}
