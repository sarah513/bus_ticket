package com.example.myride;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBtrips extends SQLiteOpenHelper {

    //decleration for tables and colomnds
    private static final String DB_Name = "TripDB";
    private static final String KEY_ID = "id";//1 2 3
    private static final String FROMCITY = "fromCity";
    private static final String TOCITY = "toCity";
    private static final String TIME = "time";
    private static final String DATE = "date";//
    private static final String PRICE = "price";
    private static final String TableTrip = "tripsTable";
    private static final String TableSeat = "SeatTablee";
    private static final String TableBus = "BUS_TABLE";
    private static final String SEAT_No = "SEAT_NO";

    //date//busid//seat
    public DBtrips(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // table creation queries
        String Create_TripTable = "create table " + TableTrip + " (" + KEY_ID + " integer primary key , " + FROMCITY + " varchar(30) , " + TOCITY + " varchar(30) , " + TIME + " varchar(6) ," + PRICE + " varchar(4), " + DATE + " varchar(11))";
        String Create_SeatTable = "create table " + TableSeat + " (" + KEY_ID + " integer , " + SEAT_No + " integer  , " + DATE + " varchar(11) , primary key(" + KEY_ID + "," + SEAT_No + "," + DATE + "))";


        db.execSQL(Create_TripTable);
        db.execSQL(Create_SeatTable);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Drop_TripTable = "DROP table if exists " + TableTrip + "; ";
        String Drop_SEATTable = "DROP table if exists " + TableSeat + "; ";
        db.execSQL(Drop_TripTable);
        db.execSQL(Drop_SEATTable);
        onCreate(db);

    }

    //--------------------------------------------------------------------------------------//


                                                    //--------------SCREEN 2 FUNCTIONS----------------//

    // FUNCTION TO CREATE TRIPS ,ELI EHNA ELI hnd5lha
    public void CreateTrip(String FCity, String TCity, String price, String time, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FROMCITY, FCity);
        values.put(TOCITY, TCity);
        values.put(PRICE, price);
        values.put(TIME, time);
        values.put(DATE, date);


        db.insert(TableTrip, null, values);
    }



    // ---- function to get all trips has specific info
    public ArrayList<trips> getTrips(String fcity, String tcity, String date) {
        ArrayList<trips> trip = new ArrayList<trips>();
        String[] str = {fcity, tcity, date};
        String SelectQuery = "select " + FROMCITY + " , " + TOCITY + ", " + PRICE + " , " + TIME + " from " + TableTrip + " " +
                "where " + FROMCITY + " like ? and " + TOCITY + " like ? and " + DATE + " like ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SelectQuery, str);

        if (cursor.moveToFirst()) {
            do {

                String Fcity = cursor.getString(cursor.getColumnIndex(FROMCITY));
                String Tcity = cursor.getString(cursor.getColumnIndex(TOCITY));
                String price = cursor.getString(cursor.getColumnIndex(PRICE));
                String time = cursor.getString(cursor.getColumnIndex(TIME));
                trips Trip = new trips(Fcity, Tcity, price, time);
                trip.add(Trip);
            } while (cursor.moveToNext());
        }
        return trip;
    }

    // -- to get the ID of BUSES
    public int ReturnID(String FCity, String TCity, String time, String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] str = {FCity, TCity, time, date};
        String selectQuery = "select " + KEY_ID + " from " + TableTrip + " where " + FROMCITY + " like ? and " + TOCITY + " like ? and " + TIME + " like ? and " + DATE + " like ?";
        Cursor cursor = db.rawQuery(selectQuery, str);
        int ID = 0;
        if (cursor.moveToFirst()) {
            do {
                ID = cursor.getInt(cursor.getColumnIndex(KEY_ID));

            } while (cursor.moveToNext());
        }
        return ID;
    }


                                                //--------------SCREEN 3 FUNCTIONS----------------//


    //---function to add seats that has been ticketed
    public void Addseat(int ID, String date, String seat_No) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID, ID);
        values.put(DATE, date);
        values.put(SEAT_No, seat_No);
        db.insert(TableSeat, null, values);
    }

    //--- funtcion to get selected seats on bus with this ID
    public ArrayList<Integer> getSeats(int ID, String date) {
        ArrayList<Integer> seats = new ArrayList<>();
        String[] str = {String.valueOf(ID), date};
        String SelectQuery = "select "+KEY_ID+" , " + SEAT_No + "  from " + TableSeat + " " +
                "where " + KEY_ID + " like ? and " + DATE + " like ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SelectQuery, str);//hena l mfrud a search 3la l seat no wel date bs wla  l mfrud yb2a feh paramter kman yakhud l key_id ?

        if (cursor.moveToFirst()) {
            do {
                String Seat_number = cursor.getString(cursor.getColumnIndex("SEAT_NO"));
               /* String Date = cursor.getString(cursor.getColumnIndex(DATE));
                String key_id = cursor.getString(cursor.getColumnIndex(KEY_ID));*/
                seats.add(Integer.parseInt(Seat_number));
            } while (cursor.moveToNext());
        }
        return seats;
    }





    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableTrip, null, null);
        db.delete(TableBus, null, null);

        db.close();
    }


}


