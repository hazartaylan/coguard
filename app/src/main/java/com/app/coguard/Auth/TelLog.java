package com.app.coguard.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.coguard.R;

public class TelLog extends AppCompatActivity {
Button devam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        devam=findViewById(R.id.devam);
        devam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TelLog.this,Auth2.class);
                startActivity(intent);
                finish();
            }
        });

    }
}