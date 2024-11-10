package com.mycompany.projectofinal.dataacces;


import com.mycompany.projectofinal.dto.Intent;
import com.mycompany.projectofinal.dto.Review;
import com.mycompany.projectofinal.dto.Usuari;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class DataAccess {

    private Connection getConnection(){
        Properties properties=new Properties();
        try {
            properties.load(new FileReader("connexio.conf"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Connection connection=null;
        String coString="jdbc:sqlserver://localhost;database=simulapdb202315101357;encrypt=true;trustServerCertificate=true;";
        try {
             connection=DriverManager.getConnection(coString, properties);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }

    public Usuari getUsuario(String email) {
        Usuari user = null;
        if(email.equals(""))return null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            user = new Usuari();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("IsInstructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user.getEmail()==null)return null;
        return user;
    }

    public ArrayList<Usuari> getUsuarios() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE IsInstructor=0";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("IsInstructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    public ArrayList<Intent> getIntentosSinReview() {
        ArrayList<Intent> intents = new ArrayList<>();
        String sql = "SELECT i.Id as Id, IdUsuari, IdExercici, Timestamp_Inici, Timestamp_Fi, VideoFile, r.Id as IdReview, Valoracio FROM Intents i"
                + " INNER JOIN Usuaris u ON i.IdUsuari=u.Id"
                + " INNER JOIN Exercicis e ON i.IdExercici=e.Id"
                + " LEFT JOIN Review r ON i.Id=r.IdIntent"
                + " WHERE i.Id NOT IN (SELECT IdIntent FROM Review)"
                + " ORDER BY Timestamp_Inici";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Intent attempt = new Intent();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUsuari(resultSet.getInt("IdUsuari"));
                attempt.setIdEjercicio(resultSet.getInt("IdExercici"));
                attempt.setInici(resultSet.getDate("Timestamp_Inici"));
                attempt.setFi(resultSet.getDate("Timestamp_Fi"));
                attempt.setVideofile(resultSet.getString("VideoFile"));
                attempt.setIdReview(resultSet.getInt("IdReview"));
                attempt.setEstado(resultSet.getInt("Valoracio"));
                intents.add(attempt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intents;
    }
    
    public ArrayList<Intent> getIntentosDeUsuario(String nom) {
        ArrayList<Intent> intents = new ArrayList<>();
        String sql = "SELECT i.Id as Id, IdUsuari, IdExercici, Timestamp_Inici, Timestamp_Fi, VideoFile, r.Id as IdReview, Valoracio  FROM Intents i"
                + " INNER JOIN Usuaris u ON i.IdUsuari=u.Id"
                + " INNER JOIN Exercicis e ON i.IdExercici=e.Id"
                + " LEFT JOIN Review r ON i.Id=r.IdIntent"
                + " WHERE nom=?"
                + " ORDER BY Timestamp_Inici";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            selectStatement.setString(1, nom);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Intent attempt = new Intent();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUsuari(resultSet.getInt("IdUsuari"));
                attempt.setIdEjercicio(resultSet.getInt("IdExercici"));
                attempt.setInici(resultSet.getDate("Timestamp_Inici"));
                attempt.setFi(resultSet.getDate("Timestamp_Fi"));
                attempt.setVideofile(resultSet.getString("VideoFile"));
                attempt.setIdReview(resultSet.getInt("IdReview"));
                attempt.setEstado(resultSet.getInt("Valoracio"));
                intents.add(attempt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intents;
    }
    
    public void eliminarIntento(int idIntent) {
        String sql = "DELETE FROM Intents WHERE Id = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idIntent);
            ResultSet resultSet = selectStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertReview(int IdIntent, int IdReviewer, int Valoracio, String Comentari) {
        int result = 0;
        String sql = "INSERT INTO dbo.Review (IdIntent, IdReviewer, Valoracio, Comentari)"
                + " VALUES (?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, IdIntent);
            insertStatement.setInt(2, IdReviewer);
            insertStatement.setInt(3, Valoracio);
            insertStatement.setString(4, Comentari);

            result = insertStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Creating review failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long longResult = generatedKeys.getLong(1);
                    result = longResult.intValue();
                } else {
                    throw new SQLException("Creating review failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Review getReview(int idIntent) {
        Review review = null;
        String sql = "SELECT * FROM Review WHERE IdIntent = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idIntent);
            ResultSet resultSet = selectStatement.executeQuery();
            review = new Review();
            while (resultSet.next()) {
                review.setId(resultSet.getInt("Id"));
                review.setIdIntent(resultSet.getInt("IdIntent"));
                review.setIdReviewer(resultSet.getInt("IdReviewer"));
                review.setValoracio(resultSet.getInt("Valoracio"));
                review.setComentari(resultSet.getString("Comentari"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return review;
    }
    
    public void updateReview(int Id, int Valoracio, String Comentari) {
        int result = 0;
        String sql = "UPDATE Review SET Valoracio=?, Comentari=? WHERE Id=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(1, Valoracio);
            updateStatement.setString(2, Comentari);
            updateStatement.setInt(3, Id);

            result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Error en la actualizacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
