package fr.mycompany.travelapp.data.mapper;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

import fr.mycompany.travelapp.data.model.Cafe;
import fr.mycompany.travelapp.data.model.CentreCommercial;
import fr.mycompany.travelapp.data.model.Hotel;
import fr.mycompany.travelapp.data.model.Musee;
import fr.mycompany.travelapp.data.model.Parc;
import fr.mycompany.travelapp.data.model.Restaurant;
import fr.mycompany.travelapp.data.responseModel.CafeResponse;
import fr.mycompany.travelapp.data.responseModel.CentreCommercialResponse;
import fr.mycompany.travelapp.data.responseModel.HotelsResponse;
import fr.mycompany.travelapp.data.responseModel.MuseResponse;
import fr.mycompany.travelapp.data.responseModel.ParcResponse;
import fr.mycompany.travelapp.data.responseModel.RestaurantResponse;

public interface Mapper {
    public static List<Hotel> ResponseToHotels(HotelsResponse response) {
        List<Hotel> hotels = new ArrayList<>();
        for (HotelsResponse.Feature feature : response.getFeatures()) {
            HotelsResponse.Feature.Properties props = feature.getProperties();
            HotelsResponse.Feature.Geometry geom = feature.getGeometry();

            Hotel hotel = new Hotel();

            hotel.setName(props.getName());
            hotel.setAddress(props.getFormatted());
            hotel.setLatitude(geom.getCoordinates()[1]);
            hotel.setLongitude(geom.getCoordinates()[0]);
            hotel.setWebsite(props.getWebsite());
            hotel.setPhone(props.getPhone());
            hotel.setWheelchairAccessible(props.isWheelchair());
            hotel.setBuildingLevels(props.getBuilding() != null ? props.getBuilding().getLevels() : 0);

            hotels.add(hotel);
        }
        return hotels;
    }

    public static List<Restaurant> ResponseToRestaurants(RestaurantResponse response) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (RestaurantResponse.Feature feature : response.getFeatures()) {
            RestaurantResponse.Feature.Properties properties = feature.getProperties();
            Restaurant restaurant = new Restaurant();

            // Mapping des propriétés depuis le Feature
            restaurant.setName(properties.getName());
            restaurant.setOldName(properties.getOldName());
            restaurant.setPhone(properties.getContact() != null ? properties.getContact().getPhone() : "");
            restaurant.setEmail(properties.getContact() != null ? properties.getContact().getEmail() : "");
            restaurant.setOpeningHours(properties.getOpeningHours());
            restaurant.setDescription(properties.getDescription());

            // Accessibilité
            if (properties.getFacilities() != null) {
                restaurant.setWheelchairAccessible(properties.getFacilities().isWheelchair());
                restaurant.setWheelchairToilets(properties.getFacilities().isToilets());
            }

            // Réseaux sociaux
            restaurant.setTwitterHandle(properties.getDatasource().getRaw().getTwitter());
            restaurant.setFacebookPage(properties.getDatasource().getRaw().getFacebook());

            // Ajouter à la liste
            restaurants.add(restaurant);
        }

        return restaurants;
    }

    public static List<Cafe> ResponseToCafe(CafeResponse response){
        List<Cafe> cafes = new ArrayList<>();


        for (CafeResponse.Feature feature : response.getFeatures()) {
            CafeResponse.Feature.Properties properties = feature.getProperties();
            Cafe cafe = new Cafe();

            // Mapping des propriétés depuis le Feature
            cafe.setName(properties.getName());
            cafe.setInternationalName(properties.getName_international());
            cafe.setPhone(properties.getContact() != null ? properties.getContact().getPhone() : "");
            cafe.setOpeningHours(properties.getOpening_hours());
            cafe.setWebsite(properties.getWebsite());

            // Accessibilité
            if (properties.getFacilities() != null) {
                cafe.setWheelchairAccessible(properties.getFacilities().isWheelchair());
                cafe.setInternetAccess(properties.getFacilities().isInternet_access());
                cafe.setAirConditioning(properties.getFacilities().isAir_conditioning());
                cafe.setOutdoorSeating(properties.getFacilities().isOutdoor_seating());
            }

            // Lien Wikidata
            cafe.setWikidataLink(properties.getWiki_and_media() != null ? properties.getWiki_and_media().getWikidata() : "");

            // Ajouter à la liste
            cafes.add(cafe);
        }

        return cafes;

    }

    public static List<CentreCommercial> ResponseToCentreCommercial(CentreCommercialResponse response){
        List<CentreCommercial> centres = new ArrayList<>();

        for (CentreCommercialResponse.Feature feature : response.getFeatures()) {
            CentreCommercialResponse.Feature.Properties properties = feature.getProperties();
            CentreCommercial centre = new CentreCommercial();

            centre.setName(properties.getName());
            centre.setPhone(properties.getContact() != null ? properties.getContact().getPhone() : "");
            centre.setOpeningHours(properties.getOpening_hours());
            centre.setWebsite(properties.getWebsite());
            centre.setAddress(properties.getFormatted());

            // falities informations
            if (properties.getFacilities() != null){
                centre.setWheelchairAccessible(properties.getFacilities().isWheelchair());
                centre.setHasToilets(properties.getFacilities().isToilets());
            }

            centre.setBuildingType(properties.getBuilding() != null ? properties.getBuilding().getType() : "");
            centre.setBuildingHeight(properties.getBuilding() != null ? properties.getBuilding().getHeight() : 0);
            centre.setStartDate(properties.getBuilding() != null ? properties.getBuilding().getStart_date() : 0);
            centre.setCommercialType(properties.getCommercial() != null ? properties.getCommercial().getType() : "");

            // Lien Wikidata et Wikipedia
            centre.setWikidataLink(properties.getWiki_and_media() != null ? properties.getWiki_and_media().getWikidata() : "");
            centre.setWikipediaLink(properties.getWiki_and_media() != null ? properties.getWiki_and_media().getWikipedia() : "");

        }

        return centres;

    }

    public static List<Musee> ResponseToMusee(MuseResponse response){
        List<Musee> musees = new ArrayList<>();

        for (MuseResponse.Feature feature : response.getFeatures()){
            MuseResponse.Feature.Properties properties = feature.getProperties();
            MuseResponse.Feature.Geometry geom = feature.getGeometry();
            Musee musee = new Musee();

            musee.setName(properties.getName());
            musee.setAddress(properties.getFormatted());
            musee.setLatitude(geom.getCoordinates()[0]); // Latitude
            musee.setLongitude(geom.getCoordinates()[1]); // Longitude
            musee.setWebsite(properties.getWebsite());

            // Propriétés spécifiques à Musee
            musee.setPhone(properties.getContact() != null ? properties.getContact().getPhone() : "");
            musee.setOpeningHours(properties.getOpening_hours());
            musee.setOperator(properties.getOperator());

            if (properties.getFacilities() != null) {
                musee.setWheelchairAccessible(properties.getFacilities().isWheelchair());
            }

            if (properties.getHeritage() != null) {
                musee.setHeritageLevel(properties.getHeritage().getLevel());
                musee.setHeritageRef(properties.getHeritage().getRef());
                musee.setHeritageInscriptionDate(properties.getHeritage().getInscription_date());
            }

            if (properties.getBuilding() != null) {
                musee.setBuildingType(properties.getBuilding().getType());
                musee.setBuildingHeight(properties.getBuilding().getHeight());
                musee.setBuildingStartDate(properties.getBuilding().getStart_date());
            }

            if (properties.getWiki_and_media() != null) {
                musee.setWikidataLink(properties.getWiki_and_media().getWikidata());
                musee.setWikipediaLink(properties.getWiki_and_media().getWikipedia());
                musee.setWikimediaCommons(properties.getWiki_and_media().getWikimedia_commons());
            }

            musees.add(musee);
        }


        return musees;
    }

    public static List<Parc> ResponseToParc(ParcResponse response){
        List<Parc> parcs = new ArrayList<>();

        for (ParcResponse.Feature feature : response.getFeatures()) {
            ParcResponse.Feature.Properties properties = feature.getProperties();
            ParcResponse.Feature.Geometry geom = feature.getGeometry();

            Parc parc = new Parc();

            // Propriétés héritées de Lieu
            parc.setName(properties.getName());
            parc.setAddress(properties.getFormatted());
            parc.setLatitude(geom.getCoordinates()[1]); // Latitude
            parc.setLongitude(geom.getCoordinates()[0]); // Longitude
            parc.setWebsite(properties.getWebsite());

            // Propriétés spécifiques à Parc
            parc.setOpeningHours(properties.getOpening_hours());

            if (properties.getFacilities() != null) {
                parc.setWheelchairAccessible(properties.getFacilities().isWheelchair());
            }

            if (properties.getHeritage() != null) {
                parc.setHeritageLevel(properties.getHeritage().getLevel());
            }

            if (properties.getDatasource() != null && properties.getDatasource().getRaw() != null) {
                parc.setImageUrl(properties.getDatasource().getRaw().getImage());
                parc.setPanoramaImageUrl(properties.getDatasource().getRaw().getImage_panorama());
            }

            if (properties.getName_international() != null) {
                parc.setNameInInternationalLanguages(properties.getName_international());
            }

            parcs.add(parc);
        }

        return parcs;
    }
}
