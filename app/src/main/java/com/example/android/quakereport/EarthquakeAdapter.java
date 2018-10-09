package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import org.w3c.dom.Text;

import java.text.DecimalFormat;
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
        ratingView.setText(formatDouble(quake.getRating()));

        GradientDrawable magnitudeCircle = (GradientDrawable) ratingView.getBackground();
        int magnitudeColor = getMagnitudeColor((int)quake.getRating());
        magnitudeCircle.setColor(magnitudeColor);

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

    private String formatDouble(double mag){
        DecimalFormat format = new DecimalFormat("0.0");
        return format.format(mag);
    }

    private int getMagnitudeColor(int mag){
        int magnitude1Color = 0;
        switch (mag){
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitude1Color;
    }
}
