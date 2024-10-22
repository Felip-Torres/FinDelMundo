/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectofinal.dto;

/**
 *
 * @author Alumne
 */
public class Usuari {
    private int Id;
    private String Nom, Email, PasswordHash;
    private byte[] Foto;
    private boolean instructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Usuari{" + "Id=" + Id + ", Nom=" + Nom + ", Email=" + Email + ", PasswordHash=" + PasswordHash + ", Foto=" + Foto + ", instructor=" + instructor + '}';
    }
    
    public String[] toArrayString(){
        String[] st = new String[6];
        st[0] = String.valueOf(Id);
        st[1] = Nom;
        st[2] = Email;
        st[3] = PasswordHash;
        if(Foto != null) st[4] = Foto.toString();
        st[5] = String.valueOf(instructor);
        return st;
    }
}
