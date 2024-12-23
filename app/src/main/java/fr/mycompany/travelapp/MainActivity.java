package fr.mycompany.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.mycompany.travelapp.data.model.Restaurant;
import fr.mycompany.travelapp.ui.resultats.CafeActivity;
import fr.mycompany.travelapp.ui.resultats.HotelActivity;
import fr.mycompany.travelapp.ui.resultats.MuseumActivity;
import fr.mycompany.travelapp.ui.resultats.ParkActivity;
import fr.mycompany.travelapp.ui.resultats.RestaurantActivity;
import fr.mycompany.travelapp.ui.resultats.ShoppingActivity;

public class MainActivity extends AppCompatActivity {
    private Button hotelButton;
    private Button restaurantButton;
    private Button cafeButton;
    private Button shoppingButton;
    private Button museumButton;
    private Button parkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotelButton = findViewById(R.id.hotelButton);
        restaurantButton = findViewById(R.id.restaurantButton);
        cafeButton = findViewById(R.id.cafeButton);
        shoppingButton = findViewById(R.id.shoppingButton);
        museumButton = findViewById(R.id.museumButton);
        parkButton = findViewById(R.id.parkButton);


        hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HotelActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","hotel");
                startActivity(intent);

            }
        });
        restaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","restaurant");
                startActivity(intent);

            }
        });
        cafeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CafeActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","cafe");
                startActivity(intent);

            }
        });
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","shopping");
                startActivity(intent);

            }
        });
        museumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MuseumActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","museum");
                startActivity(intent);

            }
        });
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ParkActivity.class);
                intent.putExtra("longitude",-1.912823);
                intent.putExtra("latitude",34.689404);
                intent.putExtra("category","park");
                startActivity(intent);

            }
        });



    }
}