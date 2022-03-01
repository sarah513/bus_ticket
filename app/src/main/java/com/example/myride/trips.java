package com.example.myride;

public class trips {
    private String FromCity,ToCity,Price,Time;
    int id;
    DBtrips DBID;
    public trips(String fromCity, String toCity, String price, String time) {

        FromCity = fromCity;
        ToCity = toCity;
        Price = price;
        Time = time;
    }
    public trips( int id, String fromCity, String toCity, String price, String time) {
        this.id=id;
        FromCity = fromCity;
        ToCity = toCity;
        Price = price;
        Time = time;
    }

    public int getId(){
        return id;
    }
    public String getFromCity() {
        return FromCity;
    }

    public void setFromCity(String fromCity) {
        FromCity = fromCity;
    }

    public String getToCity() {
        return ToCity;
    }

    public void setToCity(String toCity) {
        ToCity = toCity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
