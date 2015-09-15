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
                Utils.goToPCT();
            }
        });
        eu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goToEU();
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goToCalculator();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.goToContact();
            }
        });
    }
}
