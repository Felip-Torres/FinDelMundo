/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adminusers.dto;

import java.sql.Date;

/**
 *
 * @author Alumne
 */
public class Intent {
    private int id, idUsuari, idEjercicio;
    private Date Inici, Fi;
    private String Videofile;
    
    public Intent(){
        
    }

    public Intent(int id, int idUsuari, int idEjercicio, Date IniciDate, Date Fi, String Videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idEjercicio = idEjercicio;
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
    
    
    
}