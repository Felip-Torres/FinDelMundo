package com.mycompany.projectofinal.dto;

/**
 * Aquesta classe representa un usuari del sistema amb les seves propietats 
 * i mètodes d'accés. Inclou informació com l'ID, el nom, l'email, 
 * el hash de la contrasenya, una foto i si és instructor o no.
 */
public class Usuari {
    private int Id;
    private String Nom, Email, PasswordHash;
    private byte[] Foto;
    private boolean instructor;

    /**
     * Obté l'ID de l'usuari.
     * 
     * @return l'identificador de l'usuari.
     */
    public int getId() {
        return Id;
    }

    /**
     * Defineix l'ID de l'usuari.
     * 
     * @param Id l'identificador de l'usuari.
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obté el nom de l'usuari.
     * 
     * @return el nom de l'usuari.
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Defineix el nom de l'usuari.
     * 
     * @param Nom el nom de l'usuari.
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * Obté l'email de l'usuari.
     * 
     * @return l'email de l'usuari.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Defineix l'email de l'usuari.
     * 
     * @param Email l'email de l'usuari.
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Obté el hash de la contrasenya de l'usuari.
     * 
     * @return el hash de la contrasenya.
     */
    public String getPasswordHash() {
        return PasswordHash;
    }

    /**
     * Defineix el hash de la contrasenya de l'usuari.
     * 
     * @param PasswordHash el hash de la contrasenya.
     */
    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    /**
     * Obté la foto de l'usuari en format de byte array.
     * 
     * @return la foto de l'usuari.
     */
    public byte[] getFoto() {
        return Foto;
    }

    /**
     * Defineix la foto de l'usuari en format de byte array.
     * 
     * @param Foto la foto de l'usuari.
     */
    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    /**
     * Comprova si l'usuari és instructor.
     * 
     * @return true si l'usuari és instructor, false en cas contrari.
     */
    public boolean isInstructor() {
        return instructor;
    }

    /**
     * Defineix si l'usuari és instructor.
     * 
     * @param instructor true si l'usuari és instructor, false en cas contrari.
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    /**
     * Converteix l'usuari a una representació en forma de cadena de text.
     * 
     * @return una cadena de text amb la informació de l'usuari.
     */
    @Override
    public String toString() {
        return "Usuari{" + "Id=" + Id + ", Nom=" + Nom + ", Email=" + Email 
               + ", PasswordHash=" + PasswordHash + ", Foto=" + Foto 
               + ", instructor=" + instructor + '}';
    }
    
    /**
     * Converteix la informació de l'usuari a un array de cadenes.
     * 
     * @return un array de cadenes que conté la informació de l'usuari.
     */
    public String[] toArrayString() {
        String[] st = new String[6];
        st[0] = String.valueOf(Id);
        st[1] = Nom;
        st[2] = Email;
        st[3] = PasswordHash;
        st[4] = (Foto != null) ? Foto.toString() : "null";
        st[5] = String.valueOf(instructor);
        return st;
    }
}
