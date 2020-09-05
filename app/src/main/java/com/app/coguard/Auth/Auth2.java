package com.app.coguard.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.coguard.MainPage.MainPage;
import com.app.coguard.R;

public class Auth2 extends AppCompatActivity {
Button giris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth2);
        giris=findViewById(R.id.giris);
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Auth2.this, MainPage.class);
                startActivity(i);
                finish();
            }
        });
    }
}