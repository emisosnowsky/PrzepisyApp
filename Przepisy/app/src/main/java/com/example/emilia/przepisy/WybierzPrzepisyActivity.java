package com.example.emilia.przepisy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class WybierzPrzepisyActivity extends AppCompatActivity {


    private Spinner mSpinner = null;
    private Button ChooseButton = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybierz_przepisy);



        mSpinner = (Spinner) findViewById(R.id.MealSpinner);
        ChooseButton = (Button) findViewById(R.id.ChooseMealButton);

        ChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mySelection = mSpinner.getSelectedItem().toString();
                Intent i = new Intent(view.getContext(), PrzepisyActivity.class);
                i.putExtra("KeyForSending",mySelection);
                setResult(RESULT_OK, i);
                startActivity(i);
                Toast.makeText(WybierzPrzepisyActivity.this, "Wybrano "+mySelection, Toast.LENGTH_SHORT).show();
            }
        });

        //display data sent to us
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String chosenValue = extras.getString("KeyForSending");

            if(chosenValue !=null){
                Toast.makeText(this, chosenValue, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
