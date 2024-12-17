package fr.mycompany.travelapp.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.Hotel;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.LieuViewHolder> {

    private ArrayList<Hotel> hotels;
    private Context context;


    public HotelAdapter(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public HotelAdapter.LieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LieuViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.LieuViewHolder holder, int position) {
        Hotel hotel = this.hotels.get(position);
        holder.Bind(hotel);
    }




    @Override
    public int getItemCount()
    {
        return hotels.size();
    }

    public void updateData(List<Hotel> newHotels) {
        this.hotels.clear();
        this.hotels.addAll(newHotels);
        notifyDataSetChanged(); // Notifie le RecyclerView des modifications
    }


    public static class LieuViewHolder extends RecyclerView.ViewHolder {

        private HotelItemBinding binding;

        public LieuViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void Bind(Hotel hotel){
            binding.lieuTitle.setText(hotel.getName());
            binding.lieuRat.setText(String.valueOf(4.4));
            binding.lieuAddress.setText(hotel.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);


//            if (hotel.getImgUrl()!=null && !lieu.getImgUrl().isEmpty()){
//                Glide
//                        .with(itemView.getContext())
//                        .load(lieu.getImgUrl())
//                        .into(binding.lieuImage);
//            }
//            else{
//                binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);
//            }

        }
    }
}
