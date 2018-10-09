package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    private double mRating;
    private String mCity;
    private long mDate;
    private String moreInfoUrl;

    private String mCityOnly;
    private String mCityDist;

    public Earthquake(double rating, String city, long date, String url){
        mRating = rating;
        mCity = city;
        mDate = date;
        moreInfoUrl = url;
        extractCity();
    }

    private void extractCity(){
        int splitLocation = mCity.indexOf("of");
        if(splitLocation != -1){
            splitLocation += 2;
            mCityDist = mCity.substring(0, splitLocation);
            mCityOnly = mCity.substring(splitLocation, mCity.length());
        }
        else{
            mCityOnly = mCity;
            mCityDist = "Near the";
        }
    }

    public double getRating(){
        return mRating;
    }

    public String getCity(){
        return mCity;
    }

    public long getDateMili(){
        return mDate;
    }

    public String getUrl(){
        return moreInfoUrl;
    }

    public String getDateReg(){
        Date date = new Date(mDate);
        SimpleDateFormat format = new SimpleDateFormat("LLL dd, yyyy");
        return format.format(date);
    }

    public String getTimeReg(){
        Date date = new Date(mDate);
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        return format.format(date);
    }

    public String getCityOnly(){
        return mCityOnly;
    }

    public String getCityDist(){
        return mCityDist;
    }
}
