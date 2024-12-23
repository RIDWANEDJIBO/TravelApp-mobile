package fr.mycompany.travelapp.data.service;


import fr.mycompany.travelapp.data.responseModel.HotelsResponse;
import fr.mycompany.travelapp.data.responseModel.UnsplashResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashApi {
    @GET("search/photos")
    Call<UnsplashResponse> searchPhotos(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("client_id") String clientId
    );
}
