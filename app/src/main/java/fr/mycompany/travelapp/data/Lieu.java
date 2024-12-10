package fr.mycompany.travelapp.data;

public class Lieu {

    private String imgUrl;
    private String nom;
    private String address;
    private double rating;
    private String time;
    private String description;


    public Lieu(String nom, String address, double rating, String time, String description) {
        this.nom = nom;
        this.address = address;
        this.rating = rating;
        this.time = time;
        this.description = description;
    }



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImg(String img) {
        this.imgUrl = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
