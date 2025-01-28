package com.mycompany.projectofinal.dto;

/**
 * Aquesta classe representa una review dins el sistema, incloent informació 
 * com l'ID de la review, l'ID de l'intent revisat, l'ID del revisor, 
 * la valoració i el comentari.
 */
public class Review {
    private int Id, IdIntent, IdReviewer, Valoracio;
    private String Comentari;

    /**
     * Constructor per defecte de la classe Review.
     */
    public Review() {
    }

    /**
     * Constructor amb tots els camps per inicialitzar una instància de Review.
     * 
     * @param Id identificador de la review.
     * @param IdIntent identificador de l'intent revisat.
     * @param IdReviewer identificador del revisor.
     * @param Valoracio valoració donada en la review.
     * @param Comentari comentari de la review.
     */
    public Review(int Id, int IdIntent, int IdReviewer, int Valoracio, String Comentari) {
        this.Id = Id;
        this.IdIntent = IdIntent;
        this.IdReviewer = IdReviewer;
        this.Valoracio = Valoracio;
        this.Comentari = Comentari;
    }

    /**
     * Obté l'ID de la review.
     * 
     * @return l'identificador de la review.
     */
    public int getId() {
        return Id;
    }

    /**
     * Defineix l'ID de la review.
     * 
     * @param Id identificador de la review.
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obté l'ID de l'intent revisat.
     * 
     * @return l'identificador de l'intent revisat.
     */
    public int getIdIntent() {
        return IdIntent;
    }

    /**
     * Defineix l'ID de l'intent revisat.
     * 
     * @param IdIntent identificador de l'intent revisat.
     */
    public void setIdIntent(int IdIntent) {
        this.IdIntent = IdIntent;
    }

    /**
     * Obté l'ID del revisor.
     * 
     * @return l'identificador del revisor.
     */
    public int getIdReviewer() {
        return IdReviewer;
    }

    /**
     * Defineix l'ID del revisor.
     * 
     * @param IdReviewer identificador del revisor.
     */
    public void setIdReviewer(int IdReviewer) {
        this.IdReviewer = IdReviewer;
    }

    /**
     * Obté la valoració de la review.
     * 
     * @return la valoració donada.
     */
    public int getValoracio() {
        return Valoracio;
    }

    /**
     * Defineix la valoració de la review.
     * 
     * @param Valoracio valoració donada a l'intent.
     */
    public void setValoracio(int Valoracio) {
        this.Valoracio = Valoracio;
    }

    /**
     * Obté el comentari de la review.
     * 
     * @return el comentari de la review.
     */
    public String getComentari() {
        return Comentari;
    }

    /**
     * Defineix el comentari de la review.
     * 
     * @param Comentari text del comentari de la review.
     */
    public void setComentari(String Comentari) {
        this.Comentari = Comentari;
    }

    /**
     * Converteix la review a una representació en forma de cadena de text.
     * 
     * @return una cadena de text amb la informació de la review.
     */
    @Override
    public String toString() {
        return "Review{" + "Id=" + Id + ", IdIntent=" + IdIntent 
               + ", IdReviewer=" + IdReviewer + ", Valoracio=" + Valoracio 
               + ", Comentari=" + Comentari + '}';
    }
}
