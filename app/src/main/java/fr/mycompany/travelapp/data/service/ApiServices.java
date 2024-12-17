package fr.mycompany.travelapp.data.service;


import fr.mycompany.travelapp.data.responseModel.HotelsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("/v2/places")
    Call<HotelsResponse> getHotels(
            @Query("categories") String category,
            @Query("filter") String filter,
            @Query("apiKey") String apiKey
    );
}
