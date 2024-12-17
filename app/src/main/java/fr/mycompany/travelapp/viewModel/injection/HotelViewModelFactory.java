package fr.mycompany.travelapp.viewModel.injection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import fr.mycompany.travelapp.viewModel.HotelViewModel;

public class HotelViewModelFactory implements ViewModelProvider.Factory {
    private final String apiKey;

    public HotelViewModelFactory(String apiKey) {
        this.apiKey = apiKey;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HotelViewModel.class)) {
            return modelClass.cast(new HotelViewModel(apiKey));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}