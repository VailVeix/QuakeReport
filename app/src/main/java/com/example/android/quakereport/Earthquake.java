package com.example.android.quakereport;

public class Earthquake {

    private String mRating;
    private String mCity;
    private String mDate;

    public Earthquake(String rating, String city, String date){
        mRating = rating;
        mCity = city;
        mDate = date;
    }

    public String getRating(){
        return mRating;
    }

    public String getCity(){
        return mCity;
    }

    public String getDate(){
        return mDate;
    }
}
