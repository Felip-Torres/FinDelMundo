/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.dto;

/**
 *
 * @author Alumne
 */
public class Review {
    private int Id, IdIntent, IdReviewer, Valoracio;
    private String Comentari;

    public Review() {
    }

    public Review(int Id, int IdIntent, int IdReviewer, int Valoracio, String Comentari) {
        this.Id = Id;
        this.IdIntent = IdIntent;
        this.IdReviewer = IdReviewer;
        this.Valoracio = Valoracio;
        this.Comentari = Comentari;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdIntent() {
        return IdIntent;
    }

    public void setIdIntent(int IdIntent) {
        this.IdIntent = IdIntent;
    }

    public int getIdReviewer() {
        return IdReviewer;
    }

    public void setIdReviewer(int IdReviewer) {
        this.IdReviewer = IdReviewer;
    }

    public int getValoracio() {
        return Valoracio;
    }

    public void setValoracio(int Valoracio) {
        this.Valoracio = Valoracio;
    }

    public String getComentari() {
        return Comentari;
    }

    public void setComentari(String Comentari) {
        this.Comentari = Comentari;
    }

    @Override
    public String toString() {
        return "Review{" + "Id=" + Id + ", IdIntent=" + IdIntent + ", IdReviewer=" + IdReviewer + ", Valoracio=" + Valoracio + ", Comentari=" + Comentari + '}';
    }
    
    
    
}
