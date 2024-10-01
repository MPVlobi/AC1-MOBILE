package com.example.ac1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ac1.R;

public class DetailsAcitivity extends AppCompatActivity {
    ImageView img1, img2;
    TextView description;
    Button btnViewMap, btnOpenWebsite, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img1 = findViewById(R.id.imgDetail1);
        img2 = findViewById(R.id.imgDetail2);
        description = findViewById(R.id.txtDescription);
        btnViewMap = findViewById(R.id.btnViewMap);
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite);
        btnCall = findViewById(R.id.btnCall);

        Intent intent = getIntent();
        String place = intent.getStringExtra("place");

        if (place != null) {
            switch (place) {
                case "hms":
                    img1.setImageResource(R.mipmap.hms1);
                    img2.setImageResource(R.mipmap.hms2);
                    description.setText("Hospital Dr. Miguel Soeiro é um hospital moderno localizado em Sorocaba...");
                    setUpActions("geo:0,0?q=Hospital+Dr+Miguel+Soeiro", "https://www.unimed.coop.br/hospitalhms", "tel:15987654321");
                    break;

                case "farmacia":
                    img1.setImageResource(R.mipmap.farmacia);
                    img2.setImageResource(R.mipmap.farmacia2);
                    description.setText("A Farmácia Unimed oferece medicamentos de qualidade e atendimento especializado...");
                    setUpActions("geo:0,0?q=Farmacia+Unimed+Sorocaba", "https://www.unimed.coop.br/farmacia", "tel:15987654322");
                    break;

                case "unimedshop":
                    img1.setImageResource(R.mipmap.unishop2);
                    img2.setImageResource(R.mipmap.unimedshop);
                    description.setText("O Unimed Shopping oferece uma variedade de serviços e conveniências para você...");
                    setUpActions("geo:0,0?q=Unimed+Shopping+Sorocaba", "https://www.unimed.coop.br/shopping", "tel:15987654323");
                    break;

                default:
                    description.setText("Local não encontrado.");
                    break;
            }
        }
    }

    private void setUpActions(String mapUri, String websiteUrl, String phoneNumber) {
        // Ver no Mapa
        btnViewMap.setOnClickListener(v -> {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUri));
            startActivity(mapIntent);
        });

        // Abrir Website
        btnOpenWebsite.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            startActivity(webIntent);
        });

        // Fazer ligação
        btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
            startActivity(callIntent);
        });
    }
}
