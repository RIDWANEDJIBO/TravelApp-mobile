package fr.mycompany.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.Parc;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class ParcAdapter extends RecyclerView.Adapter<ParcAdapter.ParcViewHolder> {
    private List<Parc> parks;
    private Context context;


    @NonNull
    @Override
    public ParcAdapter.ParcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ParcViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ParcAdapter.ParcViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ParcViewHolder extends RecyclerView.ViewHolder {
        private HotelItemBinding binding;


        public ParcViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(Parc parc){
            binding.lieuTitle.setText(parc.getName());
            binding.lieuRat.setText(String.valueOf(4.4));
            binding.lieuAddress.setText(parc.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
        }
    }
}
