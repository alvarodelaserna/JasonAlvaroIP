package com.alewar.jason;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


public class ContactActivity extends Activity {

    private String[] country, country_code, all;
    private Context mContext;
    int countryIndex;
    private Button send_mail;
    private Spinner spinner;
    private EditText name, phone, email;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mContext = this;
        // get Shared Preferences and editor
        prefs = getSharedPreferences("com.alewar.jason", Context.MODE_PRIVATE);
        editor = prefs.edit();
        // storing string resources into Array
        all = getResources().getStringArray(R.array.array_of_countries);
        country = new String[all.length];
        country_code = new String[all.length];
        for(int i=0; i<all.length; i++){
            String[] aux = all[i].split("-");
            country[i] = aux[0];
            country_code[i] = aux[1];
        }
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone_number);
        email = (EditText)findViewById(R.id.email_address);
        name.requestFocus();
        spinner = (Spinner) findViewById(R.id.countries);
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
                String prefix = country_code[countryIndex];
                String[] content = phone.getText().toString().split("-");
                if(content.length == 1){
                    phone.setText("+" + prefix + "-");
                }else {
                    phone.setText("+" + prefix + "-" + content[1]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        send_mail = (Button)findViewById(R.id.contact);
        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] phone_content = phone.getText().toString().split("-");
                if(name.getText().toString().matches("")||email.getText().toString().matches("")||phone_content.length==1){
                    Toast.makeText(mContext, "There are empty fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isValidEmail(email.getText())){
                        Toast.makeText(mContext, "Invalid e-mail address", Toast.LENGTH_SHORT).show();
                    }else{
                        editor.putString("name", name.getText().toString());
                        editor.putString("phone", phone.getText().toString());
                        editor.putString("email", email.getText().toString());
                        editor.putInt("index", countryIndex);
                        editor.commit();
                        if(phoneNumberIsValid()) {
                            String[] countryPrefix = all[countryIndex].split("-");
                            sendEmail(name.getText().toString(), countryPrefix[0], phone.getText().toString(), email.getText().toString());
                        }
                    }
                }
            }
        });
        name.setText(prefs.getString("name", ""));
        phone.setText(prefs.getString("phone", ""));
        email.setText(prefs.getString("email", ""));
        spinner.setSelection(prefs.getInt("index", 0));
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
//        int countryCodeIndex = numberProto.getCountryCode();
//        String countryCode = phoneUtil.getRegionCodeForCountryCode(countryCodeIndex);

        boolean isValid = phoneUtil.isValidNumber(numberProto);
        if (isValid) {
            // get the valid number’s international format
//            String internationalFormat = phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
//            Toast.makeText(mContext,"Phone number VALID: " + internationalFormat,Toast.LENGTH_SHORT).show();
            return true;
        } else {
            // prompt the user when the number is invalid
            Toast.makeText(mContext,"Invalid phone number: " + phone.getText().toString(),Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void sendEmail(String name, String country, String phone, String email) {
//        String[] recipients = {"timmoorcroft@gmail.com", "jason.c.moorcroft@gmail.com"};
        String text = "Hello, I require your assistance.\n\nName: "+name+"\nFrom: "+country+"\nPhone number: "+phone+"\ne-mail address: "+email+"\nPlease contact me ASAP.\nBest regards, \n"+name;
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "alvaro.delaserna@gmail.com,sirhawk14@hotmail.com", null));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "timmoorcroft@gmail.com,Gary.LeBlanc@parkip.com," +
                "msekac@parkip.com,nikita.levitan@parkip.com", null));
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_contact, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed(){
        editor.putString("name", name.getText().toString());
        editor.putString("phone", phone.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putInt("index", countryIndex);
        editor.commit();
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
}
