package com.example.ac1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ac1.R;

public class MainActivity extends AppCompatActivity {
    Button btnZooDetails, btnIguatemiDetails, btnParqueDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnZooDetails = findViewById(R.id.btnZooDetails);
        btnIguatemiDetails = findViewById(R.id.btnIguatemiDetails);
        btnParqueDetails = findViewById(R.id.btnParqueDetails);

        // Ao clicar no botão de "Saiba Mais" para o Hospital Dr. Miguel Soeiro
        btnZooDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsAcitivity.class);
            intent.putExtra("place", "hms");  // Hospital Dr. Miguel Soeiro
            startActivity(intent);
        });

        // Ao clicar no botão de "Saiba Mais" para a Farmácia Unimed
        btnIguatemiDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsAcitivity.class);
            intent.putExtra("place", "farmacia");  // Farmácia Unimed
            startActivity(intent);
        });

        // Ao clicar no botão de "Saiba Mais" para o Unimed Shopping
        btnParqueDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsAcitivity.class);
            intent.putExtra("place", "unimedshop");  // Unimed Shopping
            startActivity(intent);
        });
    }
}
