package fr.mycompany.travelapp.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.Cafe;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CafeViewHolder>{
    private List<Cafe> cafes;

    @NonNull
    @Override
    public CafeAdapter.CafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CafeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeAdapter.CafeViewHolder holder, int position) {
        Cafe cafe = this.cafes.get(position);
        holder.Bind(cafe);
    }

    @Override
    public int getItemCount() {
        return this.cafes.size();
    }

    public void updateData(List<Cafe> newCafes) {
        this.cafes.clear();
        this.cafes.addAll(newCafes);
        notifyDataSetChanged(); // Notifie le RecyclerView des modifications
    }


    public static class CafeViewHolder extends RecyclerView.ViewHolder {
        private HotelItemBinding binding;

        public CafeViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(Cafe cafe){
            binding.lieuTitle.setText(cafe.getName());
            binding.lieuRat.setText(String.valueOf(4.4));
            binding.lieuAddress.setText(cafe.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
        }
    }
}
