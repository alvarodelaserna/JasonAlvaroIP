package com.alewar.jason.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.alewar.jason.R;


public class MainActivity extends Activity {

    private Button pct, eu, calculator, contact;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        pct = (Button)findViewById(R.id.button_pct);
        eu = (Button)findViewById(R.id.button_ep);
        calculator = (Button)findViewById(R.id.button_calculator);
        contact = (Button)findViewById(R.id.button_contact);
        pct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPCT();
            }
        });
        eu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEU();
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCalculator();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContact();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void goToPCT(){
        Intent intent = new Intent(mContext, PickCountryActivity.class);
        intent.putExtra("type", "PCT");
        startActivity(intent);
    }

    private void goToEU(){
        Intent intent = new Intent(mContext, PickCountryActivity.class);
        intent.putExtra("type", "EP");
        startActivity(intent);
    }

    private void goToCalculator(){
        Intent intent = new Intent(mContext, CalculatorActivity.class);
        startActivity(intent);
    }

    private void goToContact(){
        Intent intent = new Intent(mContext, ContactActivity.class);
        startActivity(intent);
    }
}
