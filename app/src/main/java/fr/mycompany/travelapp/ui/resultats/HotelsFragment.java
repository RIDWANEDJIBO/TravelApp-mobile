package fr.mycompany.travelapp.ui.resultats;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import fr.mycompany.travelapp.Adapter.HotelAdapter;
import fr.mycompany.travelapp.databinding.FragmentHotelsBinding;
import fr.mycompany.travelapp.viewModel.HotelViewModel;
import fr.mycompany.travelapp.viewModel.injection.HotelViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends Fragment {

    private FragmentHotelsBinding binding;
    private HotelViewModel hotelViewModel;
    private HotelAdapter adapter;
    private final String apiKey = "e4c34a66df174a229066590ee94189e5";

    public HotelsFragment() {
        // Required empty public constructor
    }


    public static HotelsFragment newInstance() {
        HotelsFragment fragment = new HotelsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHotelsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialisation de l'adaptateur et du LayoutManager
        adapter = new HotelAdapter(new ArrayList<>());
        binding.listItem.setAdapter(adapter);

        // Initialisation du RecyclerView
        binding.listItem.setLayoutManager(new LinearLayoutManager(requireContext()));

        //Création du ViewModel via ViewModelProvider

        HotelViewModelFactory factory = new HotelViewModelFactory(apiKey);
        hotelViewModel = new ViewModelProvider(this,factory).get(HotelViewModel.class);

        // Observer les données
        String categorie = "accommodation.hotel";
        String filter = "circle:2.3522,48.8566,5000";
        hotelViewModel.getHotelsLiveData(categorie, filter).observe(getViewLifecycleOwner(), hotels -> {
            if (hotels != null) {
                adapter.updateData(hotels);
            } else {
                Toast.makeText(this.getContext(), "Erreur de chargement des données", Toast.LENGTH_SHORT).show();
            }
        });

    }
}