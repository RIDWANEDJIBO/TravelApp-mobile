package fr.mycompany.travelapp.ui.resultats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import fr.mycompany.travelapp.Adapter.RestaurantAdapter;
import fr.mycompany.travelapp.databinding.ActivityRestaurantBinding;
import fr.mycompany.travelapp.viewModel.LieuViewModel;
import fr.mycompany.travelapp.viewModel.injection.HotelViewModelFactory;

public class RestaurantActivity extends AppCompatActivity {
    private ActivityRestaurantBinding binding;
    private Intent intent;
    private double latitude = 34.689404;
    private double longitude =-1.912823;
    private String category = "restaurant";
    private LieuViewModel lieuViewModel;
    private RestaurantAdapter adapter;
    private final String apiKey = "e4c34a66df174a229066590ee94189e5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // initialisation des resources

        intent = getIntent();
        adapter = new RestaurantAdapter(new ArrayList<>());
        binding.listItem.setLayoutManager(new LinearLayoutManager(this));
        binding.listItem.setAdapter(adapter);

        // creation du ViewModel via ViewModelProvides

        HotelViewModelFactory factory = new HotelViewModelFactory(apiKey);
        lieuViewModel = new ViewModelProvider(this,factory).get(LieuViewModel.class);



        // recuperation des extraData

        handleIntentData();


        // Observer Les Données
        lieuViewModel.getCategorie().observe(this, categorie -> {
            if (categorie != null) {
                lieuViewModel.getFilter().observe(this, filter -> {
                    if (filter != null) {
                        // Recharger les données avec les nouvelles valeurs
                        lieuViewModel.getRestaurantLiveData(categorie, filter).observe(this, restaurants -> {
                            if (restaurants != null) {
                                binding.progressBar.setVisibility(View.GONE);
                                adapter.updateData(restaurants);
                            } else {
                                Toast.makeText(this, "Aucun résultat trouvé", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });

        binding.backBtn.setOnClickListener(view -> finish());


    }

    private void handleIntentData() {
        this.latitude = intent.getDoubleExtra("latitude", 0);
        this.longitude = intent.getDoubleExtra("longitude", 0);
        this.category = intent.getStringExtra("category");

        if (latitude == 0 || longitude == 0 || category == null) {
            Toast.makeText(this, "Données invalides. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }else {
            lieuViewModel.setCategorie(lieuViewModel.searchCategorie(category));
            lieuViewModel.setFilter("circle:" + longitude + "," + latitude + "," + 10000);
        }


    }


}