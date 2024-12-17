package fr.mycompany.travelapp.data.responseModel;

import java.util.List;

public class HotelsResponse {

    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public static class Feature {
        private Properties properties;
        private Geometry geometry;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }


        public static class Properties {
            private String name;
            private String formatted; // Adresse complète
            private String phone;
            private String website;
            private boolean wheelchair; // Accessibilité
            private List<String> categories; // Catégories
            private Building building;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFormatted() {
                return formatted;
            }

            public void setFormatted(String formatted) {
                this.formatted = formatted;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public boolean isWheelchair() {
                return wheelchair;
            }

            public void setWheelchair(boolean wheelchair) {
                this.wheelchair = wheelchair;
            }

            public List<String> getCategories() {
                return categories;
            }

            public void setCategories(List<String> categories) {
                this.categories = categories;
            }

            public Building getBuilding() {
                return building;
            }

            public void setBuilding(Building building) {
                this.building = building;
            }

            // Getters et setters pour chaque champ

            public static class Building {
                private int levels; // Nombre d'étages

                public int getLevels() {
                    return levels;
                }

                public void setLevels(int levels) {
                    this.levels = levels;
                }
            }
        }

        public static class Geometry {
            private double[] coordinates; // Longitude et latitude

            public double[] getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(double[] coordinates) {
                this.coordinates = coordinates;
            }
        }

    }

}
