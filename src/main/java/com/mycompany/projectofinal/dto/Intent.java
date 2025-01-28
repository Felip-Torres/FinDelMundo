package com.mycompany.projectofinal.dto;

import java.sql.Date;


/**
 * Aquesta classe representa un intent d'execució dins el sistema. Conté informació 
 * com l'ID de l'intent, l'usuari que l'ha realitzat, l'exercici, la review associada, 
 * les dates d'inici i fi, el fitxer de vídeo i l'estat de l'intent.
 */
public class Intent {
    private int id, idUsuari, idEjercicio, idReview;
    private Date Inici, Fi;
    private String Videofile, Estado;

    /**
     * Constructor per defecte de la classe Intent.
     */
    public Intent() {
    }

    /**
     * Constructor complet per inicialitzar una instància de la classe Intent.
     * 
     * @param id identificador de l'intent.
     * @param idUsuari identificador de l'usuari que realitza l'intent.
     * @param idEjercicio identificador de l'exercici associat.
     * @param idReview identificador de la review associada.
     * @param IniciDate data d'inici de l'intent.
     * @param Fi data de finalització de l'intent.
     * @param Videofile nom del fitxer de vídeo associat a l'intent.
     */
    public Intent(int id, int idUsuari, int idEjercicio, int idReview, Date IniciDate, Date Fi, String Videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idEjercicio = idEjercicio;
        this.idReview = idReview;
        this.Inici = IniciDate;
        this.Fi = Fi;
        this.Videofile = Videofile;
    }

    /**
     * Obté l'identificador de l'intent.
     * 
     * @return l'identificador de l'intent.
     */
    public int getId() {
        return id;
    }

    /**
     * Defineix l'identificador de l'intent.
     * 
     * @param id identificador de l'intent.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obté l'identificador de l'usuari que ha realitzat l'intent.
     * 
     * @return l'identificador de l'usuari.
     */
    public int getIdUsuari() {
        return idUsuari;
    }

    /**
     * Defineix l'identificador de l'usuari que ha realitzat l'intent.
     * 
     * @param idUsuari identificador de l'usuari.
     */
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    /**
     * Obté l'identificador de l'exercici associat a l'intent.
     * 
     * @return l'identificador de l'exercici.
     */
    public int getIdEjercicio() {
        return idEjercicio;
    }

    /**
     * Defineix l'identificador de l'exercici associat a l'intent.
     * 
     * @param idEjercicio identificador de l'exercici.
     */
    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    /**
     * Obté l'identificador de la review associada.
     * 
     * @return l'identificador de la review.
     */
    public int getIdReview() {
        return idReview;
    }

    /**
     * Defineix l'identificador de la review associada.
     * 
     * @param idReview identificador de la review.
     */
    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    /**
     * Obté l'estat de l'intent.
     * 
     * @return l'estat de l'intent (Pendiente, Aprobado o Suspendido).
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * Defineix l'estat de l'intent en funció de la valoració de la review.
     * 
     * @param val valor de la valoració associada a l'intent.
     */
    public void setEstado(int val) {
        if (idReview != 0) {
            if (val < 3) {
                this.Estado = "Suspendido";
            } else {
                this.Estado = "Aprobado";
            }
        } else {
            this.Estado = "Pendiente";
        }
    }

    /**
     * Obté la data d'inici de l'intent.
     * 
     * @return la data d'inici de l'intent.
     */
    public Date getInici() {
        return Inici;
    }

    /**
     * Defineix la data d'inici de l'intent.
     * 
     * @param Inici data d'inici de l'intent.
     */
    public void setInici(Date Inici) {
        this.Inici = Inici;
    }

    /**
     * Obté la data de finalització de l'intent.
     * 
     * @return la data de finalització de l'intent.
     */
    public Date getFi() {
        return Fi;
    }

    /**
     * Defineix la data de finalització de l'intent.
     * 
     * @param Fi data de finalització de l'intent.
     */
    public void setFi(Date Fi) {
        this.Fi = Fi;
    }

    /**
     * Obté el nom del fitxer de vídeo associat a l'intent.
     * 
     * @return el nom del fitxer de vídeo.
     */
    public String getVideofile() {
        return Videofile;
    }

    /**
     * Defineix el nom del fitxer de vídeo associat a l'intent.
     * 
     * @param Videofile nom del fitxer de vídeo.
     */
    public void setVideofile(String Videofile) {
        this.Videofile = Videofile;
    }

    /**
     * Converteix l'intent a una representació en forma de cadena de text.
     * 
     * @return una cadena de text amb la informació de l'intent.
     */
    @Override
    public String toString() {
        return "Intent{" + "id=" + id + ", idUsuari=" + idUsuari + ", idEjercicio=" + idEjercicio 
                + ", IniciDate=" + Inici + ", Fi=" + Fi + ", Videofile=" + Videofile + '}';
    }

    /**
     * Converteix l'intent a un array de cadenes de text.
     * 
     * @return un array amb els atributs de l'intent com a cadenes de text.
     */
    public String[] toArrayString() {
        String[] st = new String[8];
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
