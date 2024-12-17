package fr.mycompany.travelapp.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import fr.mycompany.travelapp.data.service.ApiServices;
import fr.mycompany.travelapp.data.responseModel.HotelsResponse;
import fr.mycompany.travelapp.data.mapper.Mapper;
import fr.mycompany.travelapp.data.service.RetrofitClient;
import fr.mycompany.travelapp.data.model.Hotel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LieuRepository {
    private final ApiServices apiServices;
    public LieuRepository()
    {
        this.apiServices = RetrofitClient.getRetrofitInstance().create(ApiServices.class);
    }

    public LiveData<List<Hotel>> getHotels(String categorie, String filter, String apiKey){

        MutableLiveData<List<Hotel>> HotelsLiveData = new MutableLiveData<>();

        Call<HotelsResponse> call = apiServices.getHotels(
                categorie,
                filter,
                apiKey
        );

        call.enqueue(new Callback<HotelsResponse>() {
            @Override
            public void onResponse(Call<HotelsResponse> call, Response<HotelsResponse> response) {
                if (response.isSuccessful() && response.body()!=null){
                    List<Hotel> hotels = Mapper.ResponseToHotels(response.body());
                    HotelsLiveData.postValue(hotels);
                }
                else {
                    HotelsLiveData.postValue(null);
                    Log.e("LieuRepository", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<HotelsResponse> call, Throwable t) {
                HotelsLiveData.postValue(null);
                Log.e("LieuRepository", "Error: " + t.getMessage());
            }
        });


        return HotelsLiveData;

    }

}
