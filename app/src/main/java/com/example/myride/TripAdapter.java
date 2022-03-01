package com.example.myride;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends ArrayAdapter<trips> {

    Context context;

    public TripAdapter(@NonNull Context context,int resource, @NonNull List<trips> objects) {
        super(context,resource, objects);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        TextView FromCity=(TextView) convertView.findViewById(R.id.from);
        TextView ToCity=(TextView) convertView.findViewById(R.id.to);
        TextView price=(TextView) convertView.findViewById(R.id.price);
        TextView time=(TextView) convertView.findViewById(R.id.time2);

        trips currentPosition= getItem(position);

        FromCity.setText(currentPosition.getFromCity());
        ToCity.setText(currentPosition.getToCity());
        time.setText(currentPosition.getTime());
        price.setText(currentPosition.getPrice());

        return convertView;
    }
}
