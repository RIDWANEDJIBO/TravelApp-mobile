package fr.mycompany.travelapp.data.model;

public class Cafe extends Lieu {
    private String internationalName; // Nom international
    private String phone; // Téléphone
    private String openingHours; // Horaires d'ouverture
    private boolean wheelchairAccessible; // Accessibilité fauteuil roulant
    private boolean internetAccess; // Internet disponible
    private boolean airConditioning; // Climatisation
    private boolean outdoorSeating; // Places assises à l'extérieur
    private String wikidataLink; // Lien vers Wikidata

    public Cafe(){
        super();
    }


    public String getInternationalName() {
        return internationalName;
    }

    public void setInternationalName(String internationalName) {
        this.internationalName = internationalName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public boolean isInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(boolean internetAccess) {
        this.internetAccess = internetAccess;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isOutdoorSeating() {
        return outdoorSeating;
    }

    public void setOutdoorSeating(boolean outdoorSeating) {
        this.outdoorSeating = outdoorSeating;
    }

    public String getWikidataLink() {
        return wikidataLink;
    }

    public void setWikidataLink(String wikidataLink) {
        this.wikidataLink = wikidataLink;
    }
}
