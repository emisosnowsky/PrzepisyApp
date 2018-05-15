package com.example.emilia.przepisy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlownyActivity extends AppCompatActivity{

    Button przepisyB = null;
    Button zalogujB = null;
    Button zarejestrujB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glowny);

        przepisyB = (Button) findViewById(R.id.przepisyButton);
        zalogujB = (Button) findViewById(R.id.zalogujButton);
        zarejestrujB = (Button) findViewById(R.id.zarejestrujButton);

        przepisyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), WybierzPrzepisyActivity.class);
                startActivity(i);
            }
        });

        zalogujB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ZalogujActivity.class);
                startActivity(i);
            }
        });

        zarejestrujB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ZarejestrujActivity.class);
                startActivity(i);
            }
        });

    }

}
