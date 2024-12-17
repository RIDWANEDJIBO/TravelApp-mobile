package fr.mycompany.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.CentreCommercial;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class CentreCommercialAdapter extends RecyclerView.Adapter<CentreCommercialAdapter.CentreCommercialViewHolder> {
    private List<CentreCommercial> centresCommerciaux;
    private Context context;

    @NonNull
    @Override
    public CentreCommercialAdapter.CentreCommercialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CentreCommercialViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CentreCommercialAdapter.CentreCommercialViewHolder holder, int position) {
        CentreCommercial centreCommercial = this.centresCommerciaux.get(position);
        holder.Bind(centreCommercial);
    }

    @Override
    public int getItemCount() {
        return this.centresCommerciaux.size();
    }

    public void UpdateData(List<CentreCommercial> newCentresCommerciaux) {
        this.centresCommerciaux.clear();
        this.centresCommerciaux.addAll(newCentresCommerciaux);
        notifyDataSetChanged(); // Notifie le RecyclerView des modifications
    }

    public static class CentreCommercialViewHolder extends RecyclerView.ViewHolder {
        private HotelItemBinding binding;

        public CentreCommercialViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(CentreCommercial centreCommercial){
            binding.lieuTitle.setText(centreCommercial.getName());
            binding.lieuRat.setText(String.valueOf(4.4));
            binding.lieuAddress.setText(centreCommercial.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
        }
    }
}
