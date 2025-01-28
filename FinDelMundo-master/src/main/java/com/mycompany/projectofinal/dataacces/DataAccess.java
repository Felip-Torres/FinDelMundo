package com.mycompany.projectofinal.dataacces;

import com.mycompany.projectofinal.dto.Intent;
import com.mycompany.projectofinal.dto.Review;
import com.mycompany.projectofinal.dto.Usuari;
import java.io.FileReader;
import java.io.IOException;
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
 * Clase encargada de gestionar el acceso a los datos de la base de datos.
 * Proporciona métodos para obtener usuarios, intentos, reviews y para insertar, actualizar y eliminar datos relacionados.
 * 
 * @author felip
 */
public class DataAccess {

    /**
     * Establece una conexión con la base de datos utilizando las propiedades especificadas en el archivo "connexio.conf".
     * 
     * @return La conexión a la base de datos.
     */
    private Connection getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("connexio.conf"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Connection connection = null;
        String coString = "jdbc:sqlserver://localhost;database=simulapdb202315101357;";
        try {
            connection = DriverManager.getConnection(coString, properties);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    /**
     * Devuelve el usuario con el email indicado.
     * 
     * @param email El email del usuario a obtener.
     * @return El objeto Usuari correspondiente al email, o null si no existe.
     */
    public Usuari getUsuario(String email) {
        Usuari user = null;
        if (email.equals("")) return null; // Si el email está vacío, se evita un error.
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
        if (user.getEmail() == null) return null; // Si el usuario devuelto no tiene email, es que no existe.
        return user;
    }

    /**
     * Devuelve los usuarios que no son instructores.
     * 
     * @return Una lista de objetos Usuari que no son instructores.
     */
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

    /**
     * Devuelve los intentos sin review de todos los usuarios.
     * 
     * @return Una lista de objetos Intent que no tienen review asociada.
     */
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

    /**
     * Devuelve los intentos de un usuario especificado por su nombre.
     * 
     * @param nom El nombre del usuario cuyos intentos se quieren obtener.
     * @return Una lista de objetos Intent del usuario indicado.
     */
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

    /**
     * Elimina un intento y su correspondiente review si existe.
     * 
     * @param idIntent El ID del intento a eliminar.
     */
    public void eliminarIntento(int idIntent) {
        // Elimina la review asociada antes de eliminar el intento.
        String sql = "DELETE FROM Review WHERE IdIntent = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idIntent);
            selectStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Elimina el intento.
        sql = "DELETE FROM Intents WHERE Id = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idIntent);
            selectStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserta una nueva review para un intento.
     * 
     * @param IdIntent El ID del intento.
     * @param IdReviewer El ID del revisor.
     * @param Valoracio La valoración de la review.
     * @param Comentari El comentario de la review.
     * @return El ID de la review insertada.
     */
    public int insertReview(int IdIntent, int IdReviewer, int Valoracio, String Comentari) {
        int id = 0;
        String sql = "INSERT INTO Review (IdIntent, IdReviewer, Valoracio, Comentari)"
                + " VALUES (?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, IdIntent);
            insertStatement.setInt(2, IdReviewer);
            insertStatement.setInt(3, Valoracio);
            insertStatement.setString(4, Comentari);

            int result = insertStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Creating review failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long longResult = generatedKeys.getLong(1);
                    id = longResult.intValue();
                } else {
                    throw new SQLException("Creating review failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Devuelve la review de un intento específico.
     * 
     * @param idIntent El ID del intento.
     * @return El objeto Review correspondiente al intento.
     */
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

    /**
     * Actualiza una review existente.
     * 
     * @param Id El ID de la review a actualizar.
     * @param Valoracio La nueva valoración de la review.
     * @param Comentari El nuevo comentario de la review.
     */
    public void updateReview(int Id, int Valoracio, String Comentari) {
        String sql = "UPDATE Review SET Valoracio=?, Comentari=? WHERE Id=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(1, Valoracio);
            updateStatement.setString(2, Comentari);
            updateStatement.setInt(3, Id);

            int result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Error en la actualización");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
