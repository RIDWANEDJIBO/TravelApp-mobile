package fr.mycompany.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.Musee;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class MuseAdapter extends RecyclerView.Adapter<MuseAdapter.MuseViewHolder> {
    private List<Musee> musees;
    private Context context;


    @NonNull
    @Override
    public MuseAdapter.MuseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MuseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseAdapter.MuseViewHolder holder, int position) {
        Musee musee = this.musees.get(position);
        holder.Bind(musee);
    }

    @Override
    public int getItemCount() {
        return this.musees.size();
    }

    public void Update(List<Musee> newMusee) {
        this.musees.clear();
        this.musees.addAll(newMusee);
        notifyDataSetChanged();
    }

    public static class MuseViewHolder extends RecyclerView.ViewHolder {
        private HotelItemBinding binding;

        public MuseViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(Musee musee){
            binding.lieuTitle.setText(musee.getName());
            binding.lieuRat.setText(String.valueOf(4.4));
            binding.lieuAddress.setText(musee.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
        }

    }
}