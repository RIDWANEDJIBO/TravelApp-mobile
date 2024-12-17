package fr.mycompany.travelapp.data.model;

public class Hotel extends Lieu {

    private String altName; // Nom alternatif
    private String phone; // Téléphone
    private boolean wheelchairAccessible; // Accessibilité fauteuil roulant
    private int buildingLevels; // Nombre d'étages


    public Hotel() {
        super();
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public int getBuildingLevels() {
        return buildingLevels;
    }

    public void setBuildingLevels(int buildingLevels) {
        this.buildingLevels = buildingLevels;
    }
}
