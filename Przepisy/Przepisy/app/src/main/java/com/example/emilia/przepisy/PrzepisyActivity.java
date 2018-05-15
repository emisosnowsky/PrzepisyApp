package com.example.emilia.przepisy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PrzepisyActivity extends AppCompatActivity {

    //Initial data
    Przepis[] przepisArray = new Przepis[]{
      new Przepis("Jajecznica", "Na rozgrzaną patelnie rozsmarować masło, wbić jajka, mieszać, aż się usmaży.","jajecznica"),
      new Przepis("Naleśniki", "W misce zmiksować mąkę, jajka, szklankę mleka i wodę, następnie smażyć na rozgrzanej patelni.","nalesniki"),
      new Przepis("Kanapki", "Zrobić kanapki z jajkiem, avocado i rzodkiewką, całość przyprawić solą i pieprzem","kanapki"),
      new Przepis("Owsianka","Nalać mleko do miski, podgrzać i dodać płatki owsiane.","owsianka")
    };

    String[] stringArray = new String[]{
            "Jajecznica",
            "Naleśniki",
            "Kanapki",
            "Płatki na mleku",
            "Szakszuka",
            "Bruschetta",
            "Placki jogurtowe z truskawkami",
            "Jaglanka z bananem",
            "Hummus",
            "Jajka gotowane w pomidorach",
            "Omlet ze szpinakiem",
    };

    public static final int DETAIL_REQUEST = 1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepisy);

        listView = (ListView) findViewById(R.id.myListView);

        PrzepisAdapter przepisAdapter = new PrzepisAdapter(getApplicationContext(),R.layout.row,przepisArray);

        if(listView != null){
            listView.setAdapter(przepisAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("Przepis", przepisArray[i].title);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(listView.getContext(),WybranyPrzepisActivity.class);
                System.out.println("l: "+l+ ", context"+listView.getContext().toString());
                System.out.println("przepisArray"+przepisArray[i].title);
                listView.getContext().startActivity(intent);
            }
        });
    }

}
