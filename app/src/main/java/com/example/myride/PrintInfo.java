package com.example.myride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myride.trips;
import java.sql.Time;
import java.util.Date;

public class PrintInfo extends AppCompatActivity {

    DBtrips newSeat =new DBtrips(this);
    MainActivity S =new MainActivity();
    select currntdate =new select();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_info);


        PersonalInfo info=new PersonalInfo();

        EditText paymentMethod=(EditText)findViewById(R.id.paymentMethod);
        EditText name=(EditText)findViewById(R.id.personname);
        EditText number=(EditText)findViewById(R.id.phonenumber);

        name.setText(info.getName());
        number.setText(info.getPhoneNumber());
        paymentMethod.setText(info.getPaymentMethod());


        MainActivity m=new MainActivity();
        select tripInfo=new select();
        String SEATS="";
        Seat currentSeats= new Seat();
        int [] array=currentSeats.GVarr();
        for(int i=0;i<23;i++)
        {
            if(array[i]==1)
            {
                int NUM= i+1;
                SEATS=SEATS+String.valueOf(NUM)+"   ";
            }
        }
        if(SEATS.equals("")){
            SEATS="No selected seats";
        }
        EditText fCity=(EditText)findViewById(R.id.fcity);
        EditText tCity=(EditText)findViewById(R.id.tcity);
        EditText date=(EditText)findViewById(R.id.date);
        EditText time=(EditText)findViewById(R.id.time);
        EditText seats=(EditText)findViewById(R.id.seats);
        EditText cost=(EditText)findViewById(R.id.cost);

        fCity.setText(tripInfo.getSpin1());
        tCity.setText(tripInfo.getSpin2());
        date.setText(tripInfo.getDate());
        time.setText(m.returnTime());
        cost.setText(m.returnCost());
        seats.setText(SEATS);

        Button B=(Button)findViewById(R.id.confirmbutton);

        B.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Seat currentSeats= new Seat();
                int [] arr=currentSeats.GVarr();
                for(int i=0;i<23;i++)
                {
                    if(arr[i]==1)
                    {
                        newSeat.Addseat((int)S.returnBUSID(),currntdate.getDate(),String.valueOf(i));
                        arr[i]=0;
                    }
                }
                Intent i = new Intent(PrintInfo.this,finalactivity.class);
                startActivity(i);

            }

        });

    }
}