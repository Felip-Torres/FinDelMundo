/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adminusers.dataacces;

import com.mycompany.adminusers.dto.Usuari;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumne
 */
public class DataAcces {
    private Connection getConnection(){
        Connection connection = null;
        
        String coString="jdbc:sqlserver://localhost;database=simulapdb202315101357;encrypt=true;trustServerCertificate=true;"+"user=felip;password=12;";
        try {
            connection = DriverManager.getConnection(coString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    public ArrayList<Usuari> getUsuaris(){
        ArrayList<Usuari> usuaris = new ArrayList<>();
        
        String sql = "select * from Usuaris";
        
        Connection connection = getConnection();
        try {
            PreparedStatement seleStatement = connection.prepareStatement(sql);
            ResultSet result=seleStatement.executeQuery();
            while (result.next()) {
                Usuari user = new Usuari();
                user.setId(result.getInt("Id"));
                user.setNom(result.getString("Nom"));
                user.setEmail(result.getString("Email"));
                user.setPasswordHash(result.getString("PasswordHash"));
                //user.setFoto(result.getBytes("Foto"));
                user.setInstructor(result.getBoolean("IsInstructor"));
                usuaris.add(user);
            }
            seleStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuaris;
    }
    
    public void addUsuari(Object id, Object atributo, Object nuevo){
        
        String sql = "Update Usuaris set " + atributo+"=" +nuevo+" WHERE Id="+ id;
        
        Connection connection = getConnection();
        try {
           
            PreparedStatement seleStatement = connection.prepareStatement(sql);
            ResultSet result=seleStatement.executeQuery();
            while (result.next()) {
                Usuari user = new Usuari();
                user.setId(result.getInt("Id"));
                user.setNom(result.getString("Nom"));
                user.setEmail(result.getString("Email"));
                user.setPasswordHash(result.getString("PasswordHash"));
                //user.setFoto(result.getBytes("Foto"));
                user.setInstructor(result.getBoolean("IsInstructor"));
             
            }
            seleStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
    }
}
