package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int pos, View conView, ViewGroup parent){
        // Recycle old view if exists, otherwise make new
        View newView = conView;
        if(newView == null){
            newView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake quake = getItem(pos);

        TextView ratingView = (TextView) newView.findViewById(R.id.rating);
        ratingView.setText(quake.getRating());

        TextView cityView = (TextView) newView.findViewById(R.id.city);
        cityView.setText(quake.getCityOnly());

        TextView cityDistView = (TextView) newView.findViewById(R.id.cityDist);
        cityDistView .setText(quake.getCityDist());

        TextView dateView = (TextView) newView.findViewById(R.id.date);
        dateView.setText(quake.getDateReg());

        TextView timeView = (TextView) newView.findViewById(R.id.time);
        timeView.setText(quake.getTimeReg());

        return newView;

    }
}
