package com.example.emilia.przepisy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ZalogujActivity extends AppCompatActivity {

    EditText Userlogin, Userpassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaloguj);

        Userlogin = (EditText) findViewById(R.id.editTextLogin);
        Userpassword = (EditText) findViewById(R.id.editTextPassword);
        loginButton = (Button) findViewById(R.id.logInButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login = Userlogin.getText().toString();
                final String password = Userpassword.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(ZalogujActivity.this);
                String url = "http://www.google.com";

                //Request a string response from the provided URL
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ZalogujActivity.this, "dfdsfsd" + response, Toast.LENGTH_SHORT).show();
                        Log.i("My success", "" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ZalogujActivity.this, "my error: " + error, Toast.LENGTH_SHORT).show();
                        Log.i("My error", "" + error);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> map = new HashMap<String, String>();
                        map.put("login", login);
                        map.put("password", password);
                        return map;
                    }
                };

                //Add the request to the RequestQueue
                queue.add(stringRequest);
            }
        });
    }
        //Instantiate the RequestQueue



}
