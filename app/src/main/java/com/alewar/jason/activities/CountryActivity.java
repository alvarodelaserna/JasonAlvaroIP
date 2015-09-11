package com.alewar.jason.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.alewar.jason.R;
import com.alewar.jason.Utils;


public class CountryActivity extends Activity {

    private String[] countries;
    private String name;
    private CountryActivity countryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countryActivity = this;
        countries = getResources().getStringArray(R.array.array_of_country_abbreviations);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Utils.getDisplayByCountry(this, name, countries);
    }
}
