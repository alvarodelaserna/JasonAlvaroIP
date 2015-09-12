package com.alewar.jason.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.alewar.jason.R;
import com.alewar.jason.core.ParkIP;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;


public class ContactActivity extends Activity {

    private String[] country, country_code, all;
    private Context mContext;
    int countryIndex;
    private Button send_mail;
    private Spinner spinner;
    private EditText name, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mContext = this;

        getCountriesAndCountryCodes();
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone_number);
        email = (EditText)findViewById(R.id.email_address);
        name.requestFocus();
        name.setText(ParkIP.getUser().getUsername());
        phone.setText(ParkIP.getUser().getPhoneNumber());
        email.setText(ParkIP.getUser().getEmail());

        spinner = (Spinner) findViewById(R.id.countries);
        spinnerSetup();

        send_mail = (Button)findViewById(R.id.contact);
        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] phone_content = phone.getText().toString().split("-");
                if (name.getText().toString().matches("") || email.getText().toString().matches("") || phone_content.length == 1) {
                    Toast.makeText(mContext, "There are empty fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (!isValidEmail(email.getText())) {
                        Toast.makeText(mContext, "Invalid e-mail address", Toast.LENGTH_SHORT).show();
                    } else {
                        ParkIP.getUser().setName(name.getText().toString());
                        ParkIP.getUser().setPhoneNumber(phone.getText().toString());
                        ParkIP.getUser().setEmail(email.getText().toString());
                        ParkIP.getUser().setLastPickedCountryIndex(countryIndex);
                        if (phoneNumberIsValid()) {
                            String[] countryPrefix = all[countryIndex].split("-");
                            sendEmail(name.getText().toString(), countryPrefix[0], phone.getText().toString(), email.getText().toString());
                        }
                    }
                }
            }
        });
    }

    private void spinnerSetup() {
        ArrayAdapter<String> adapterCountries = new ArrayAdapter(this, R.layout.spinner_item, country);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCountries);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                countryIndex = parentView.getSelectedItemPosition();
                String prefix = country_code[countryIndex];
                String[] content = phone.getText().toString().split("-");
                if (content.length == 1) {
                    phone.setText("+" + prefix + "-");
                } else {
                    phone.setText("+" + prefix + "-" + content[1]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        spinner.setSelection(ParkIP.getUser().getCountryIndex());
    }

    private void getCountriesAndCountryCodes() {
        all = getResources().getStringArray(R.array.array_of_countries);
        country = new String[all.length];
        country_code = new String[all.length];
        for(int i=0; i<all.length; i++){
            String[] aux = all[i].split("-");
            country[i] = aux[0];
            country_code[i] = aux[1];
        }
    }

    private boolean phoneNumberIsValid(){
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber numberProto = null;
        try {
            // phone must begin with '+'
            numberProto = phoneUtil.parse(phone.getText().toString(), "");
        } catch (NumberParseException e) {
            Log.e("ContactActivity", e.getMessage());
        }

        boolean isValid = phoneUtil.isValidNumber(numberProto);
        if (isValid) {
           return true;
        } else {
            Toast.makeText(mContext,"Invalid phone number: " + phone.getText().toString(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void sendEmail(String name, String country, String phone, String email) {
        String text = "Hello, I require your assistance.\n\nName: "+name+"\nFrom: "+country+"\nPhone number: "+phone+"\ne-mail address: "+email+"\nPlease contact me ASAP.\nBest regards, \n"+name;
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "timmoorcroft@gmail.com,Gary.LeBlanc@parkip.com," +
                "msekac@parkip.com,nikita.levitan@parkip.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Help needed");
        emailIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
    }

    public boolean isValidEmail(CharSequence target){
        if(target == null){
            return false;
        }else{
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public void onBackPressed(){
        ParkIP.getUser().setName(name.getText().toString());
        ParkIP.getUser().setPhoneNumber(phone.getText().toString());
        ParkIP.getUser().setEmail(email.getText().toString());
        ParkIP.getUser().setLastPickedCountryIndex(countryIndex);
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
}
