package com.example.myride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static long   longid;
    public static String time;
    public static String cost;
    ListView tripList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trips);


        tripList=findViewById(R.id.tripList);

        DBtrips db=new DBtrips(this);

        select s= new select();
        String s1= new String();
        String s2= new String();
        String date=new String();


        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2022-02-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2022-02-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2022-02-28");
      /*   db.CreateTrip("Cairo","Alexandria","100 LE","7:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","100 LE","1:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","100 LE","4:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","100 LE","7:00","2021-08-26");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2021-08-26");
        db.CreateTrip("Cairo","Alexandria","100 LE","4:00","2021-08-26");
        db.CreateTrip("Dahab","Alexandria","100 LE","10:00","1-2-2021");
        db.CreateTrip("Dahab","Cairo","200 LE","10:00","2021-08-18");
        db.CreateTrip("Dahab","Cairo","200 LE","1:00","2021-08-18");
        db.CreateTrip("Dahab","Cairo","200 LE","4:00","2021-08-18");
        db.CreateTrip("Dahab","Cairo","200 LE","7:00","2021-08-18");
        db.CreateTrip("Dahab","Cairo","160 LE","10:00","2021-08-19");
        db.CreateTrip("Dahab","Cairo","160 LE","1:00","2021-08-19");
        db.CreateTrip("Dahab","Cairo","160 LE","4:00","2021-08-19");
        db.CreateTrip("Dahab","Cairo","160 LE","7:00","2021-08-19");
        db.deleteAll();
        db.dropBus();*/


        /*
        //-----------trips fro date 26--------------------//
       // db.CreateTrip("Cairo","Alexandria","100 LE","7:00","2021-08-26");
        //db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2021-08-26");
        //db.CreateTrip("Cairo","Alexandria","100 LE","4:00","2021-08-26");
        db.CreateTrip("Cairo","Alexandria","100 LE","6:00","2021-08-26");
        db.CreateTrip("Cairo","Alexandria","100 LE","10:00","2021-08-26");
        db.CreateTrip("Cairo","Alexandria","100 LE","12:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","1:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","4:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","7:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","6:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","10:00","2021-08-26");
        db.CreateTrip("Cairo","Dahab","400 LE","12:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","1:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","4:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","7:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","6:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","10:00","2021-08-26");
        db.CreateTrip("Cairo","Hurghada","400 LE","12:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","1:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","4:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","7:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","6:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","10:00","2021-08-26");
        db.CreateTrip("Cairo","North Coast","400 LE","12:00","2021-08-26");

        db.CreateTrip("ِِِAlexandria","Cairo","100 LE","7:00","2021-08-26");
        db.CreateTrip("Alexandria","Cairo","100 LE","1:00","2021-08-26");
        db.CreateTrip("Alexandria","Cairo","100 LE","4:00","2021-08-26");
        db.CreateTrip("Alexandria","Cairo","100 LE","6:00","2021-08-26");
        db.CreateTrip("Alexandria","Cairo","100 LE","10:00","2021-08-26");
        db.CreateTrip("Alexandria","Cairo","100 LE","12:00","2021-08-26");
        db.CreateTrip("ِِِHurghada","Cairo","100 LE","7:00","2021-08-26");
        db.CreateTrip("Hurghada","Cairo","100 LE","1:00","2021-08-26");
        db.CreateTrip("Hurghada","Cairo","100 LE","4:00","2021-08-26");
        db.CreateTrip("Hurghada","Cairo","100 LE","6:00","2021-08-26");
        db.CreateTrip("Hurghada","Cairo","100 LE","10:00","2021-08-26");
        db.CreateTrip("Hurghada","Cairo","100 LE","12:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","7:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","1:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","4:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","6:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","10:00","2021-08-26");
        db.CreateTrip("Dahab","Cairo","100 LE","12:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","7:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","1:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","4:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","6:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","10:00","2021-08-26");
        db.CreateTrip("North Coast","Cairo","100 LE","12:00","2021-08-26");

        //----------trips for date 28-----------//
        db.CreateTrip("Cairo","Alexandria","100 LE","7:00","2021-08-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2021-08-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","4:00","2021-08-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","6:00","2021-08-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","10:00","2021-08-28");
        db.CreateTrip("Cairo","Alexandria","100 LE","12:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","1:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","4:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","7:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","6:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","10:00","2021-08-28");
        db.CreateTrip("Cairo","Dahab","400 LE","12:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","1:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","4:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","7:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","6:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","10:00","2021-08-28");
        db.CreateTrip("Cairo","Hurghada","400 LE","12:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","1:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","4:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","7:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","6:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","10:00","2021-08-28");
        db.CreateTrip("Cairo","North Coast","400 LE","12:00","2021-08-28");

        db.CreateTrip("ِِِAlexandria","Cairo","100 LE","7:00","2021-08-28");
        db.CreateTrip("Alexandria","Cairo","100 LE","1:00","2021-08-28");
        db.CreateTrip("Alexandria","Cairo","100 LE","4:00","2021-08-28");
        db.CreateTrip("Alexandria","Cairo","100 LE","6:00","2021-08-28");
        db.CreateTrip("Alexandria","Cairo","100 LE","10:00","2021-08-28");
        db.CreateTrip("Alexandria","Cairo","100 LE","12:00","2021-08-28");
        db.CreateTrip("ِِِHurghada","Cairo","100 LE","7:00","2021-08-28");
        db.CreateTrip("Hurghada","Cairo","100 LE","1:00","2021-08-28");
        db.CreateTrip("Hurghada","Cairo","100 LE","4:00","2021-08-28");
        db.CreateTrip("Hurghada","Cairo","100 LE","6:00","2021-08-28");
        db.CreateTrip("Hurghada","Cairo","100 LE","10:00","2021-08-28");
        db.CreateTrip("Hurghada","Cairo","100 LE","12:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","7:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","1:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","4:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","6:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","10:00","2021-08-28");
        db.CreateTrip("Dahab","Cairo","100 LE","12:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","7:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","1:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","4:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","6:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","10:00","2021-08-28");
        db.CreateTrip("North Coast","Cairo","100 LE","12:00","2021-08-28");

        //---------------------trips for date 27-------------//
        db.CreateTrip("Cairo","Alexandria","100 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","12:00","2021-08-27");

        db.CreateTrip("ِِِAlexandria","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("ِِِHurghada","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","12:00","2021-08-27");

        db.CreateTrip("Cairo","Alexandria","100 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Alexandria","100 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Dahab","400 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","Hurghada","400 LE","12:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","1:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","4:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","7:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","6:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","10:00","2021-08-27");
        db.CreateTrip("Cairo","North Coast","400 LE","12:00","2021-08-27");

        db.CreateTrip("ِِِAlexandria","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Alexandria","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("ِِِHurghada","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Hurghada","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("Dahab","Cairo","100 LE","12:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","7:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","1:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","4:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","6:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","10:00","2021-08-27");
        db.CreateTrip("North Coast","Cairo","100 LE","12:00","2021-08-27");*/





        s1=s.getSpin1();
        s2=s.getSpin2();
        date=s.getDate();

        ArrayList<trips>Trips =db.getTrips(s1,s2,date);
        TripAdapter tripAdapter =new TripAdapter(MainActivity.this,R.layout.list_item,Trips);
        tripList.setAdapter(tripAdapter);

        tripList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,  long id) {
                trips selectedTrip=(trips)parent.getItemAtPosition(position);
                Intent seats = new Intent(getApplicationContext(),Seat.class );

                time=selectedTrip.getTime();
                longid =(long)db.ReturnID(s.getSpin1(),s.getSpin2(),time,s.getDate());
                cost=selectedTrip.getPrice();
                startActivity(seats);
            }
        });


    }
    public long returnBUSID(){
        return longid;
    }
    public String returnTime(){return time;}
    public String returnCost(){return cost;}
}