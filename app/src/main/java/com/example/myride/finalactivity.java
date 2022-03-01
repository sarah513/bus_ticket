package com.example.myride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.StringCharacterIterator;
import java.util.Random;

public class finalactivity extends AppCompatActivity {

    public static String resCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalactivity);

        Button home= findViewById(R.id.button3);
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++)
            sb.append(chars.charAt(r.nextInt(chars.length())));
        resCode= sb.toString();

        EditText code=(EditText)findViewById(R.id.reservationCode);
        code.setText(resCode);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homePage= new Intent(getApplicationContext(),select.class);
                startActivity(homePage);
            }
        });
    }
}