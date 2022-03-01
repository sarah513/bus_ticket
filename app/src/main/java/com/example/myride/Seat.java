package com.example.myride;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Seat extends AppCompatActivity {
    DBtrips db= new DBtrips(this);
    MainActivity m = new MainActivity();
    select currentDate =new select();
    public static int seat;
    public static int counter=0;
    static int[] arr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        select s=new select();
        Button btn= findViewById(R.id.button2);

        DBtrips db=new DBtrips(this);
        int busID=(int)m.returnBUSID();
        String CurrDate=currentDate.getDate();

        arr = new int[25];
        ArrayList <Integer> tempo = db.getSeats(busID,CurrDate);
        for(int i=0;i<tempo.size();i++)
        {
            arr[tempo.get(i)]=2;
        }


        String[] myarr=getResources().getStringArray(R.array.grid);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myarr)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getView(position, convertView, parent);
                String color="#80ffffff";

                    if(arr[position]==2)
                    {
                        color ="#ff0000";
                    }else if(arr[position]==1)
                    {
                        color="#124333";
                    }else if(arr[position]==0){
                        color= "#ffffff";
                    }


                view.setBackgroundColor(Color.parseColor(color));
                return view;
            }
        };

        GridView myGrid=(GridView)findViewById(R.id.Gridview);
        myGrid.setAdapter(adapter);



        myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
                adapter.notifyDataSetChanged();
                if(myGrid.isItemChecked(position))
                {
                    /*view=myGrid.getChildAt(position);
                    view.setBackgroundColor(Color.parseColor("#0000ff"));*/
                }
                else
                {
                    if(arr[position]==2)
                    {
                        view=myGrid.getChildAt(position);
                        view.setBackgroundColor(Color.parseColor("#ff0000"));

                        Toast.makeText(getApplicationContext(),"This seat is not available",Toast.LENGTH_LONG).show();
                    }
                    else if(arr[position]==0){
                        /*view=myGrid.getChildAt(position);
                        view.setBackgroundColor(Color.parseColor("#124333"));*/
                        arr[position]=1;
                        //db.Addseat((int)m.returnBUSID(),s.getDate(),String.valueOf(position));
                        seat=position;

                    } else if(arr[position]==1){
                       /* view=myGrid.getChildAt(position);
                        view.setBackgroundColor(Color.parseColor("#ffffff"));*/
                        arr[position]=0;
                    }
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPersonalInfo= new Intent(getApplicationContext(),PersonalInfo.class);
                startActivity(toPersonalInfo);
            }
        });

    }
    public int returnSeat(){return seat;}
    public static int [] GVarr ()
    {
        return arr;
    }

}