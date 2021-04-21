package com.myapplicationdev.android.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvholidayName, tvholidayDate;
    private ImageView ivHolidayImage;

    public HolidayAdapter(Context context, int resources, ArrayList<Holiday> objects) {
        super(context, resources, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvholidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvholidayDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);
        ivHolidayImage = (ImageView) rowView.findViewById(R.id.imageView1);

        Holiday currholiday = holiday.get(position);
        tvholidayName.setText(currholiday.getName());

        if (currholiday.getImage())
            ivHolidayImage.setImageResource(R.drawable.labourday);
        else
            ivHolidayImage.setImageResource(R.drawable.newyear);

        return rowView;
    }


}