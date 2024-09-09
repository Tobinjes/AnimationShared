package com.example.animationandshared;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button login,signup,baypass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        baypass = findViewById(R.id.bypass);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Login button clicked");
                Intent i =new Intent(MainActivity.this , LoginActivity.class);
                startActivity(i);
                finish();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Signup button clicked");
                Intent I =new Intent(MainActivity.this , SignupActivity.class);
                startActivity(I);
                finish();
            }
        });



        baypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
                finish();
            }
        });


    }
}