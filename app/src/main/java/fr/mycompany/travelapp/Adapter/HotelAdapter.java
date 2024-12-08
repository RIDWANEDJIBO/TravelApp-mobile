package fr.mycompany.travelapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.mycompany.travelapp.R;
import fr.mycompany.travelapp.data.Hotel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private ArrayList<Hotel> item;
    private Context context;


    public HotelAdapter(ArrayList<Hotel> item){
        this.item = item;
    }

    @NonNull
    @Override
    public HotelAdapter.HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotel_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.HotelViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {
        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
