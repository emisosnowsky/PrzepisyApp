package com.example.emilia.przepisy;

import android.content.Intent;
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

public class ZarejestrujActivity extends AppCompatActivity {


    Button signInButton;
    EditText editTextFirstName, editTextLastName, editTextLogin, editTextMail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zarejestruj);

        signInButton = (Button) findViewById(R.id.signInButton);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstName = editTextFirstName.getText().toString();
                final String lastName = editTextLastName.getText().toString();
                final String login = editTextLogin.getText().toString();
                final String email = editTextMail.getText().toString();
                final String password = editTextPassword.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(ZarejestrujActivity.this);
                String url = "http://10.0.3.2:8080/addNewUserAndroid";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ZarejestrujActivity.this, "Zarejestrowano: " + response, Toast.LENGTH_SHORT).show();
                        Log.i("Zarejestrowano", "" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ZarejestrujActivity.this, "onErrorResponse" + error, Toast.LENGTH_SHORT).show();
                        Log.i("My onErrorResponse", "" + error);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<>();
                        map.put("firstName", firstName);
                        map.put("lastName", lastName);
                        map.put("login", login);
                        map.put("email", email);
                        map.put("password", password);
                        return map;
                    }
                };

                queue.add(stringRequest);
            }
        });

    }
}
