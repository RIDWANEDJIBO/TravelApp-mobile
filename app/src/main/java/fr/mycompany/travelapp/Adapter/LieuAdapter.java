package fr.mycompany.travelapp.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.ArrayList;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.Lieu;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class LieuAdapter extends RecyclerView.Adapter<LieuAdapter.LieuViewHolder> {

    private ArrayList<Lieu> lieux;
    private Context context;


    public LieuAdapter(ArrayList<Lieu> lieux){
        this.lieux = lieux;
    }

    @NonNull
    @Override
    public LieuAdapter.LieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LieuViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull LieuAdapter.LieuViewHolder holder, int position) {
        Lieu lieu = lieux.get(position);
        holder.Bind(lieu);
    }




    @Override
    public int getItemCount() {
        return lieux.size();
    }

    public static class LieuViewHolder extends RecyclerView.ViewHolder {

        private HotelItemBinding binding;

        public LieuViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(Lieu lieu){
            binding.lieuTitle.setText(lieu.getNom());
            binding.lieuRat.setText(String.valueOf(lieu.getRating()));
            binding.lieuTime.setText(lieu.getTime());
            binding.lieuAddress.setText(lieu.getAddress());


            if (lieu.getImgUrl()!=null && !lieu.getImgUrl().isEmpty()){
                Glide
                        .with(itemView.getContext())
                        .load(lieu.getImgUrl())
                        .into(binding.lieuImage);
            }
            else{
                binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
            }

        }
    }
}
