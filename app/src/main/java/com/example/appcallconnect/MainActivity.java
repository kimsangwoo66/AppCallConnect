package com.example.appcallconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ContextCompat.checkSelfPermission(MainActivity.this,
                android.Manifest.permission.RECORD_AUDIO) !=
                PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission
                (MainActivity.this, android.Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE},
                    1);
        }

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Call2.class);
                intent.putExtra("callerId", ((TextView) findViewById(R.id.callerId)).getText().toString());
                intent.putExtra("recipientId", ((TextView) findViewById(R.id.recipientId)).getText().toString());
                startActivity(intent);
            }
        });
    }
}