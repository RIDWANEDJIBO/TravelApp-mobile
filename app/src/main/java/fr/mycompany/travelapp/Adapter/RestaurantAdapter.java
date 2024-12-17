package fr.mycompany.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.model.Restaurant;
import fr.mycompany.travelapp.databinding.HotelItemBinding;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private List<Restaurant> restaurants;
    private Context context;

    @NonNull
    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        HotelItemBinding binding = HotelItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new RestaurantViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.RestaurantViewHolder holder, int position) {
        Restaurant restaurant = this.restaurants.get(position);
        holder.Bind(restaurant);
    }

    @Override
    public int getItemCount() {
        return this.restaurants.size();
    }

    public void updateData(List<Restaurant> newRestaurants) {
        this.restaurants.clear();
        this.restaurants.addAll(newRestaurants);
        notifyDataSetChanged(); // Notifie le RecyclerView des modifications
    }


    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public HotelItemBinding binding;

        public RestaurantViewHolder(@NonNull  HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void Bind(Restaurant restaurant){
            binding.lieuTitle.setText(restaurant.getName());
            binding.lieuRat.setText(String.valueOf(2.4));
            binding.lieuAddress.setText(restaurant.getAddress());
            binding.lieuImage.setImageResource(R.drawable.hotel_demo_img);



        }
    }
}


