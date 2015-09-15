package com.alewar.jason.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.alewar.jason.R;


public class PickCountryActivity extends Activity {

    private String[] countries;
    private String whichCountry, type;
    private Spinner spinner;
    private Button button;
    private Context mContext;
    int countryIndex;
    private TextView head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_country);

        mContext = this;

        head = (TextView)findViewById(R.id.section);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        head.setText(type);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichCountry = countries[countryIndex];
                DisplayCountry(countryIndex, whichCountry);
            }
        });

        initialiseCountries();
        spinnerSetup();
    }

    private void spinnerSetup() {
        ArrayAdapter<String> adapterCountries = new ArrayAdapter(this, R.layout.spinner_item, countries);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCountries);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                countryIndex = parentView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing
            }
        });
    }

    private void initialiseCountries() {
        if(type.equals("PCT")){
            countries = getResources().getStringArray(R.array.array_pct);
        }else if(type.equals("EP")){
            countries = getResources().getStringArray(R.array.array_euro);
        }
    }

    private void DisplayCountry(int index, String name){
        Intent intent = new Intent(mContext, CountryActivity.class);
        intent.putExtra("country", index);
        intent.putExtra("name", name);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
