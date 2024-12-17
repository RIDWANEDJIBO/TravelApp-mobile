package fr.mycompany.travelapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import fr.mycompany.travelapp.data.model.Hotel;
import fr.mycompany.travelapp.data.repository.LieuRepository;

public class HotelViewModel extends ViewModel {
    private final String apiKey;
    private final LieuRepository repository = new LieuRepository();
    private LiveData<List<Hotel>> HotelsLiveData;

    public HotelViewModel(String apiKey){
        this.apiKey = apiKey;
    }



    public LiveData<List<Hotel>>  getHotelsLiveData(String categorie, String filter)
    {   if (HotelsLiveData == null)
        {
            this.HotelsLiveData = repository.getHotels(categorie, filter, apiKey);
        }
        return this.HotelsLiveData;
    }
}
