package fr.mycompany.travelapp.data.model;

public class Favoris {
    private String name;
    private String address;
    private String imageUrl;

    public Favoris(){
        name ="";
        address="";
        imageUrl="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
