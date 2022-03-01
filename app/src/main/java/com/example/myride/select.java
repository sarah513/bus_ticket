package com.example.myride;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;



    public class select extends AppCompatActivity {

        public static String spin1, spin2, date;

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select);

            TextView FCity=findViewById(R.id.FCity);
            TextView SCity=findViewById(R.id.SCity);


            // SPINNER FOR SECOND CITY
            Spinner spinnerTo = (Spinner) findViewById(R.id.spinner_to);
            ArrayAdapter<CharSequence> adapterTo = ArrayAdapter.createFromResource(this,
                    R.array.cities, android.R.layout.simple_spinner_item);
            adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTo.setAdapter(adapterTo);
            spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spin2 =spinnerTo.getSelectedItem().toString();
                    SCity.setText(spin2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



            //SPINNER FOR FISRT CITY
            Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner_from);

            ArrayAdapter<CharSequence> adapterFrom = ArrayAdapter.createFromResource(this,
                    R.array.cities, android.R.layout.simple_spinner_item);
            adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFrom.setAdapter(adapterFrom);
            spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spin1 =spinnerFrom.getSelectedItem().toString();
                    FCity.setText(spin1);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



            //SPINNER FOR DATE
            Spinner spinnerDate = (Spinner) findViewById(R.id.spinnerDate);
            ArrayList<String> dates = new ArrayList<String>();
            LocalDate today = java.time.LocalDate.now();
            for (int i = 0; i < 30; i++) {
                dates.add(today.plusDays(i).toString());
            }
            ArrayAdapter dateAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dates);
            dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDate.setAdapter(dateAdapter);

            spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    date =spinnerDate.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            Button search = findViewById(R.id.button);
            DBtrips TDB = new DBtrips(this);


            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent Trips = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Trips);

                }
            });

        }


        public String getSpin1(){
            return spin1;
        }
        public String getSpin2(){
            return spin2;
        }
        public String getDate(){
            return date;
        }

    }