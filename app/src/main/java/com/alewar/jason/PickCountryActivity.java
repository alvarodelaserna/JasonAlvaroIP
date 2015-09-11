package com.alewar.jason;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class PickCountryActivity extends Activity {

    private String[] country;
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
        if(type.equals("PCT")){
            // storing string resources into Array
            country = getResources().getStringArray(R.array.array_pct);
        }else if(type.equals("EP")){
            // storing string resources into Array
            country = getResources().getStringArray(R.array.array_euro);
        }
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterCountries = new ArrayAdapter(this, R.layout.spinner_item, country);
        // Specify the layout to use when the list of choices appears
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapterCountries);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                countryIndex = parentView.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whichCountry = country[countryIndex];
                DisplayCountry(countryIndex, whichCountry);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_country, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void DisplayCountry(int index, String name){
        Intent intent = new Intent(mContext, CountryActivity.class);
        intent.putExtra("country", index);
        intent.putExtra("name", name);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
