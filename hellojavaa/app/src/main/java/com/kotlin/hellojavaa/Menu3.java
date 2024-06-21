package com.kotlin.hellojavaa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class Menu3 extends Activity {

    ListView listView;
    String countryList[] = {"Indonesia", "Japan", "India", "Netherlands", "United Kingdom", "United States", "Palestine", "Israel", "Ghana", "Oman", "Korea"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);
        if(countryList.length > 7) {
            Arrays.sort(countryList);
        }
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1, countryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedCountry = countryList[i];
                String value = adapter.getItem(i);
                Toast.makeText(Menu3.this, "Selected Country: " + value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
