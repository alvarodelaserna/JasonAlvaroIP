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
import com.alewar.jason.Utils;


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
