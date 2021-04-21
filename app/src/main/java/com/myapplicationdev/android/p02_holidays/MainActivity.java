package com.myapplicationdev.android.p02_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    HolidaySelectAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvYear);

        al = new ArrayList<String>();
        al.add("Secular");
        aa = new HolidaySelectAdapter(this, R.layout.holiday, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedYear = al.get(position);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //based on item add info to intent
                intent.putExtra("year", selectedYear);
                startActivity(intent);
            }
        });
    }
}