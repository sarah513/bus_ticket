package com.example.myride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonalInfo extends AppCompatActivity {

   public static String paymentMethod;
   public static String name;
   public static String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText personName=(EditText)findViewById(R.id.entername);
        EditText personNumber=(EditText)findViewById(R.id.enterphonenumber);
        personNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        RadioButton rb1=(RadioButton)findViewById(R.id.rb1);
        RadioButton rb2=(RadioButton)findViewById(R.id.rb2);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        Button button=(Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(personName.getText().toString().equals("")||personNumber.getText().toString().equals("")||(!rb1.isChecked()&&!rb2.isChecked())||personNumber.length()!=10)
                    Toast.makeText(getApplicationContext(),"Incomplete Information",Toast.LENGTH_LONG).show();

                else
                {
                    name=personName.getText().toString();
                    phoneNumber=personNumber.getText().toString();
                    if (rb1.isChecked())
                        paymentMethod = "cash";

                    else if (rb2.isChecked())
                        paymentMethod = "credit card";

                    Intent i = new Intent(PersonalInfo.this,PrintInfo.class);
                    startActivity(i);
                }



            }

        });

    }

    public String getName() {
       return name;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

}