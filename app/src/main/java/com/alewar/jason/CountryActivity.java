package com.alewar.jason;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CountryActivity extends Activity {

    private TextView acronym, agreement, language, trans, forms,
            deadline, power_of_attorney, assignments, translation_extension, excess_claim_fee, examination_request,
            country_acronym_pct, power_of_attorney_pct, assignments_pct, language_pct, excess_claim_fee_pct, examination_request_pct,
            country_acronym_dpc, power_of_attorney_dpc, assignments_dpc, language_dpc, excess_claim_fee_dpc, examination_request_dpc,
            country_acronym_euro;
    private String[] countries;
    private String name;
    private int country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countries = getResources().getStringArray(R.array.array_of_country_abbreviations);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        getDisplayByCountry(name);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_country, menu);
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

    private void getDisplayByCountry(String name){
        switch (name){
            case "Albania": // Albania
                country = 0;
                createEURO("No", "Albanian", "Claims (Albanian)", "Yes");
                break;
            case "Algeria": // Algeria
                country = 1;
                createPCT("31 months", "Yes", "Yes", "Arabic", "Yes", "No", "N/A");
                break;
            case "Argentina": // Argentina
                country = 2;
                createDPC("Yes", "Sometimes", "Spanish", "Yes", "Deferred");
                break;
            case "ARIPO": // ARIPO
                country = 3;
                createDPC("Yes", "Yes", "English", "No", "Deferred");
                break;
            case "Australia": // Australia
                country = 4;
                createPCT("31 months", "No", "No", "English", "N/A", "No", "Deferred");
                break;
            case "Austria": // Austria
                country = 5;
                createEURO("No", "German", "Yes", "Yes");
                break;
            case "Bangladesh": // Bangladesh
                country = 6;
                createDPC("Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Belgium": // Belgium
                country = 7;
                createEURO("No", "French, Dutch and German", "Yes", "No");
                break;
            case "Belize": // Belize
                country = 8;
                createPCT("30 months", "Yes", "Yes", "English", "N/A", "No", "Deferred");
                break;
            case "Bolivia": // Bolivia
                country = 9;
                createDPC("Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Bosnia & Herzegovina": // Bosnia & Herzegovina
                country = 10;
                createEURO("No", "Bosnian, Croatian and Serbian", "Claims (Bosnian)", "Yes");
                break;
            case "Brazil": // Brazil
                country = 11;
                createPCT("30 months", "Yes", "Sometimes", "Portuguese", "Yes", "No", "Deferred");
                break;
            case "Bulgaria": // Bulgaria
                country = 12;
                createEURO("No", "Bulgarian", "Yes", "Yes");
                break;
            case "Canada": // Canada
                country = 13;
                createPCTandDPC("30 months", "No", "No", "English/French", "No", "No", "Deferred",
                        "No", "No", "English/French", "No", "Deferred");
                break;
            case "Chile": // Chile
                country = 14;
                createPCTandDPC("30 months", "Yes", "No", "Spanish", "No", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "China": // China
                country = 15;
                createPCTandDPC("30 months", "Yes", "Sometimes", "Chinese", "No", "Yes", "Deferred",
                        "No", "Sometimes", "Chinese", "Yes", "Deferred");
                break;
            case "Colombia": // Colombia
                country = 16;
                createPCT("31 months", "Yes", "Yes", "Spanish", "No", "Yes", "Deferred");
                break;
            case "Costa Rica": // Costa Rica
                country = 17;
                createPCT("31 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred");
                break;
            case "Croatia": // Croatia
                country = 18;
                createEURO("Yes", "English", "Claims (Croatian)", "Yes");
                break;
            case "Cyprus": // Cyprus
                country = 19;
                createEURO("No", "Greek", "Yes", "Yes");
                break;
            case "Czech Republic": // Czech Republic
                country = 20;
                createEURO("No", "Czech", "Yes", "Yes");
                break;
            case "Denmark": // Denmark
                country = 21;
                createEURO("Yes", "Danish", "Claims (Danish)", "No");
                break;
            case "Dominican Republic": // Dominican Republic
                country = 22;
                createPCT("30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Ecuador": // Ecuador
                country = 23;
                createPCT("30 months", "Yes", "No", "Spanish", "No", "Yes", "No");
                break;
            case "Egypt": // Egypt
                country = 24;
                createPCTandDPC("30 months", "Yes", "No", "Arabic & English", "No", "No", "Deferred",
                        "Yes", "Yes", "Arabic", "No", "Deferred");
                break;
            case "El Salvador": // El Salvador
                country = 25;
                createPCT("30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred");
                break;
            case "Estonia": // Estonia
                country = 26;
                createEURO("No", "Estonian", "Yes", "Yes");
                break;
            case "Eurasia": // Eurasia
                country = 27;
                createPCTandDPC("31 months", "No", "No", "Russian", "Yes", "Yes", "Included",
                        "No", "No", "Russian", "Yes", "Deferred");
                break;
            case "Europe": // Europe
                country = 28;
                createPCTandDPC("31 months", "No", "No", "English/French/German", "N/A", "Yes", "Included",
                        "No", "No", "English/French/German", "Yes", "Included");
                break;
            case "Finland": // Finland
                country = 29;
                createEURO("Yes", "Finnish (Swedish)", "Claims (Finnish)", "No");
                break;
            case "France": // France
                country = 30;
                createEURO("Yes", "English, French and German", "No", "No");
                break;
            case "Gulf Cooperation Council": // Gulf Cooperation Council
                country = 31;
                createDPC("Yes", "Yes", "English & Arabic", "No", "Deferred");
                break;
            case "Georgia": // Georgia
                country = 32;
                createPCT("31 months", "Yes", "Yes", "Georgian", "Yes", "No", "Deferred");
                break;
            case "Germany": // Germany
                country = 33;
                createPCTandDPCandEURO("30 months", "Recommended", "No", "German", "No", "Yes", "Deferred",
                        "Recommended", "No", "German", "Yes", "Deferred", "Yes", "English, French and German", "No", "No");
                break;
            case "Greece": // Greece
                country = 34;
                createEURO("No", "Greek", "Yes", "Yes");
                break;
            case "Guatemala": // Guatemala
                country = 35;
                createPCT("30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Honduras": // Honduras
                country = 36;
                createPCT("30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Hong Kong": // Hong Kong
                country = 37;
                createPCT("36 months", "No", "No", "English/Chinese", "No", "No", "N/A");
                break;
            case "Hungary": // Hungary
                country = 38;
                createEURO("Yes", "Hungarian", "Claims (Hungarian)", "Yes");
                break;
            case "Iceland": // Iceland
                country = 39;
                createEURO("Yes", "Icelandic", "Claims (Icelandic)", "No");
                break;
            case "India": // India
                country = 40;
                createPCTandDPC("31 months", "Yes", "Yes", "English", "N/A", "Yes", "Deferred",
                        "Yes", "Yes", "English", "Yes", "Deferred");
                break;
            case "Indonesia": // Indonesia
                country = 41;
                createPCT("31 months", "Yes", "Yes", "Indonesian", "Yes", "Yes", "Deferred");
                break;
            case "Ireland": // Ireland
                country = 42;
                createEURO("No", "Irish & English", "No", "Yes");
                break;
            case "Israel": // Israel
                country = 43;
                createPCTandDPC("30 months", "Yes", "No", "English/Hebrew", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English/Hebrew", "Yes", "Deferred");
                break;
            case "Italy": // Italy
                country = 44;
                createEURO("No", "Italian", "Yes", "Yes");
                break;
            case "Japan": // Japan
                country = 45;
                createPCTandDPC("30 months", "No", "No", "Japanese", "Yes", "No", "Deferred",
                        "No", "No", "Japanese", "No", "Deferred");
                break;
            case "Jordan": // Jordan
                country = 46;
                createDPC("Yes", "Yes", "English & Arabic", "No", "Deferred");
                break;
            case "Kenia": // Kenia
                country = 47;
                createPCT("30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred");
                break;
            case "Latvia": // Latvia
                country = 48;
                createEURO("Yes", "Latvian", "Claims (Latvian)", "Yes");
                break;
            case "Lebanon": // Lebanon
                country = 49;
                createDPC("Yes", "Yes", "English & French", "No", "Deferred");
                break;
            case "Lithuania": // Lithuania
                country = 50;
                createEURO("Yes", "Lithuanian", "Claims (Lithuanian)", "Yes");
                break;
            case "Luxembourg": // Luxembourg
                country = 51;
                createEURO("Yes", "English", "No", "No");
                break;
            case "Macedonia": // Macedonia
                country = 52;
                createEURO("No", "Macedonian", "Claims (Macedonian)", "Yes");
                break;
            case "Malaysia": // Malaysia
                country = 53;
                createPCTandDPC("30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Malta": // Malta
                country = 54;
                createEURO("No", "Maltese & English", "Yes", "Yes");
                break;
            case "Mexico": // Mexico
                country = 55;
                createPCTandDPC("30 months", "Yes", "Sometimes", "Spanish", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Included");
                break;
            case "Monaco": // Monaco
                country = 56;
                createEURO("Yes", "French & English", "No", "Yes");
                break;
            case "Montenegro": // Montenegro
                country = 57;
                createEURO("No", "Serbian", "Yes", "Yes");
                break;
            case "Morocco": // Morocco
                country = 58;
                createPCT("31 months", "Yes", "No", "French/Arabic", "No", "Yes", "Deferred");
                break;
            case "The Netherlands": // The Netherlands
                country = 59;
                createEURO("Yes", "Dutch", "Claims (Dutch)", "No");
                break;
            case "New Zealand": // New Zealand
                country = 60;
                createPCT("31 months", "No", "No", "English", "N/A", "No", "Included");
                break;
            case "Nicaragua": // Nicaragua
                country = 61;
                createPCT("30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Included");
                break;
            case "Nigeria": // Nigeria
                country = 62;
                createPCT("30 months", "Yes", "No", "English", "No", "No", "Included");
                break;
            case "Norway": // Norway
                country = 63;
                createPCTandEURO("31 months", "Yes", "No", "Norwegian", "Yes", "Yes", "Included",
                        "Yes", "Norwegian", "Yes", "Yes");
                break;
            case "OAPI": // OAPI
                country = 64;
                createPCTandDPC("30 months", "Yes", "No", "English/French", "No", "Yes", "Deferred",
                        "Yes", "Yes", "English/French", "No", "Deferred");
                break;
            case "Pakistan": // Pakistan
                country = 65;
                createDPC("Yes", "Yes", "English", "Yes", "Included");
                break;
            case "Panama": // Panama
                country = 66;
                createPCTandDPC("30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Paraguay": // Paraguay
                country = 67;
                createDPC("Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Peru": // Peru
                country = 68;
                createPCT("30 months", "Yes", "Yes", "Spanish", "No", "Yes", "No");
                break;
            case "Philippines": // Philippines
                country = 69;
                createPCTandDPC("30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Poland": // Poland
                country = 70;
                createEURO("No", "Polish", "Yes", "Yes");
                break;
            case "Portugal": // Portugal
                country = 71;
                createEURO("No", "Portuguese", "Yes", "No");
                break;
            case "Romania": // Romania
                country = 72;
                createEURO("No", "Romanian", "Yes", "Yes");
                break;
            case "Russia": // Russia
                country = 73;
                createPCTandDPC("31 months", "No", "No", "Russian", "Yes", "Yes", "Deferred",
                        "No", "No", "Russian", "Yes", "Deferred");
                break;
            case "San Marino": // San Marino
                country = 74;
                createEURO("No", "Italian", "Yes", "Yes");
                break;
            case "Serbia": // Serbia
                country = 75;
                createEURO("No", "Serbian", "Yes", "Yes");
                break;
            case "Singapore": // Singapore
                country = 76;
                createPCTandDPC("30 months", "No", "No", "English", "N/A", "No", "**",
                        "No", "No", "English", "No", "Deferred");
                break;
            case "Slovakia": // Slovakia
                country = 77;
                createEURO("No", "Slovak", "Yes", "Yes");
                break;
            case "Slovenia": // Slovenia
                country = 78;
                createEURO("No", "Slovenian", "Claims (Slovenian)", "Yes");
                break;
            case "South Africa": // South Africa
                country = 79;
                createPCTandDPC("31 months", "Yes", "Yes", "English", "N/A", "No", "Deferred",
                        "Yes", "Yes", "English", "No", "Deferred");
                break;
            case "South Korea": // South Korea
                country = 80;
                createPCTandDPC("31 months", "Yes", "No", "Korean", "No", "No", "Deferred",
                        "Yes", "No", "Korean", "No", "Deferred");
                break;
            case "Spain": // Spain
                country = 81;
                createEURO("No", "Spanish", "Yes", "No");
                break;
            case "Sweden": // Sweden
                country = 82;
                createEURO("Yes", "Swedish", "Claims (Swedish)", "No");
                break;
            case "Switzerland/Liechtenstein": // Switzerland/Liechtenstein
                country = 83;
                createEURO("Yes", "English, French, German, Italian and German (Liechtenstein)", "No", "Yes");
                break;
            case "Syria": // Syria
                country = 84;
                createPCT("31 months", "Yes", "No", "Arabic", "Yes", "Yes", "Deferred");
                break;
            case "Taiwan": // Taiwan
                country = 85;
                createDPC("Yes", "No", "Chinese", "No", "Deferred");
                break;
            case "Thailand": // Thailand
                country = 86;
                createPCTandDPC("30 months", "Yes", "Yes", "Thai", "No", "No", "Deferred",
                        "Yes", "Yes", "Thai", "No", "Deferred");
                break;
            case "Tunisia": // Tunisia
                country = 87;
                createPCT("30 months", "Yes", "No", "English/Arabic/French", "No", "Yes", "Included");
                break;
            case "Turkey": // Turkey
                country = 88;
                createEURO("No", "Turkish", "Yes", "Yes");
                break;
            case "Ukraine": // Ukraine
                country = 89;
                createPCTandDPC("31 months", "Yes", "No", "Ukrainian", "Yes", "Yes", "Deferred",
                        "Yes", "No", "Ukrainian", "Yes", "Deferred");
                break;
            case "United Arab Emirates": // United Arab Emirates
                country = 90;
                createPCT("30 months", "Yes", "Yes", "English & Arabic", "No", "No", "Deferred");
                break;
            case "United Kingdom": // United Kingdom
                country = 91;
                createPCTandDPCandEURO("31 months", "No", "No", "English", "N/A", "No", "Included",
                        "No", "No", "English", "No", "Deferred", "Yes", "English, French and German", "No", "No");
                break;
            case "United States": // United States
                country = 92;
                createPCTandDPC("30 months", "Yes", "Yes", "English", "N/A", "Yes", "Included",
                        "Yes", "Yes", "English", "Yes", "Included");
                break;
            case "Uruguay": // Uruguay
                country = 93;
                createDPC("Yes", "No", "Spanish", "Yes", "Deferred");
                break;
            case "Venezuela": // Venezuela
                country = 94;
                createDPC("Yes", "Yes", "Spanish", "No", "N/A");
                break;
            case "Vietnam": // Vietnam
                country = 95;
                createPCTandDPC("31 months", "Yes", "Sometimes", "Vietnamese", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Vietnamese", "No", "Deferred");
                break;
        }
    }

    private void createPCT(String deadLine, String PoA, String assign, String lang,
                           String translationExtension, String excessCF, String examReq){
        setContentView(R.layout.pct_layout);
        acronym = (TextView) findViewById(R.id.country_acronym);
        acronym.setText(countries[country]);
        deadline = (TextView) findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney = (TextView) findViewById(R.id.power_of_attorney);
        power_of_attorney.setText(PoA);
        assignments = (TextView) findViewById(R.id.assignments);
        assignments.setText(assign);
        language = (TextView) findViewById(R.id.language);
        language.setText(lang);
        translation_extension = (TextView) findViewById(R.id.translation_extension);
        translation_extension.setText(translationExtension);
        excess_claim_fee = (TextView) findViewById(R.id.excess_claim_fee);
        excess_claim_fee.setText(excessCF);
        examination_request = (TextView) findViewById(R.id.examination_request);
        examination_request.setText(examReq);
    }

    private void createDPC(String PoA, String assign, String lang, String excessCF, String examReq){
        setContentView(R.layout.dpc_layout);
        acronym = (TextView) findViewById(R.id.country_acronym);
        acronym.setText(countries[country]);
        power_of_attorney = (TextView) findViewById(R.id.power_of_attorney);
        power_of_attorney.setText(PoA);
        assignments = (TextView) findViewById(R.id.assignments);
        assignments.setText(assign);
        language = (TextView) findViewById(R.id.language);
        language.setText(lang);
        excess_claim_fee = (TextView) findViewById(R.id.excess_claim_fee);
        excess_claim_fee.setText(excessCF);
        examination_request = (TextView) findViewById(R.id.examination_request);
        examination_request.setText(examReq);
    }

    private void createEURO(String londonAg, String lang, String transReq, String form){
        setContentView(R.layout.euro_layout);
        acronym = (TextView) findViewById(R.id.country_acronym);
        acronym.setText(countries[country]);
        agreement = (TextView)findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)findViewById(R.id.language);
        language.setText(lang);
        trans = (TextView)findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)findViewById(R.id.forms);
        forms.setText(form);
    }

    private void createPCTandDPC(String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                 String excClaims_pct, String exReq_pct, String PoA_dpc, String assign_dpc,
                                 String lang_dpc, String excClaims_dpc, String exReq_dpc){
        setContentView(R.layout.pct_dpc_layout);
        country_acronym_dpc = (TextView) findViewById(R.id.country_acronym_dpc);
        country_acronym_dpc.setText(countries[country]);
        country_acronym_pct = (TextView) findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countries[country]);
        deadline = (TextView) findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        power_of_attorney_dpc = (TextView) findViewById(R.id.power_of_attorney_dpc);
        power_of_attorney_dpc.setText(PoA_dpc);
        assignments_dpc = (TextView) findViewById(R.id.assignments_dpc);
        assignments_dpc.setText(assign_dpc);
        language_dpc = (TextView) findViewById(R.id.language_dpc);
        language_dpc.setText(lang_dpc);
        excess_claim_fee_dpc = (TextView) findViewById(R.id.excess_claim_fee_dpc);
        excess_claim_fee_dpc.setText(excClaims_dpc);
        examination_request_dpc = (TextView) findViewById(R.id.examination_request_dpc);
        examination_request_dpc.setText(exReq_dpc);
    }

    private void createPCTandDPCandEURO(String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                 String excClaims_pct, String exReq_pct, String PoA_dpc, String assign_dpc,
                                 String lang_dpc, String excClaims_dpc, String exReq_dpc,
                                 String londonAg, String lang, String transReq, String form){
        setContentView(R.layout.pct_dpc_euro_layout);
        country_acronym_dpc = (TextView) findViewById(R.id.country_acronym_dpc);
        country_acronym_dpc.setText(countries[country]);
        country_acronym_pct = (TextView) findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countries[country]);
        country_acronym_euro = (TextView) findViewById(R.id.country_acronym_euro);
        country_acronym_euro.setText(countries[country]);
        deadline = (TextView) findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        power_of_attorney_dpc = (TextView) findViewById(R.id.power_of_attorney_dpc);
        power_of_attorney_dpc.setText(PoA_dpc);
        assignments_dpc = (TextView) findViewById(R.id.assignments_dpc);
        assignments_dpc.setText(assign_dpc);
        language_dpc = (TextView) findViewById(R.id.language_dpc);
        language_dpc.setText(lang_dpc);
        excess_claim_fee_dpc = (TextView) findViewById(R.id.excess_claim_fee_dpc);
        excess_claim_fee_dpc.setText(excClaims_dpc);
        examination_request_dpc = (TextView) findViewById(R.id.examination_request_dpc);
        examination_request_dpc.setText(exReq_dpc);
        agreement = (TextView)findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)findViewById(R.id.language_euro);
        language.setText(lang);
        trans = (TextView)findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)findViewById(R.id.forms);
        forms.setText(form);
    }

    private void createPCTandEURO(String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                        String excClaims_pct, String exReq_pct,
                                        String londonAg, String lang, String transReq, String form){
        setContentView(R.layout.pct_euro_layout);
        country_acronym_pct = (TextView) findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countries[country]);
        country_acronym_euro = (TextView) findViewById(R.id.country_acronym_euro);
        country_acronym_euro.setText(countries[country]);
        deadline = (TextView) findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        agreement = (TextView)findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)findViewById(R.id.language_euro);
        language.setText(lang);
        trans = (TextView)findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)findViewById(R.id.forms);
        forms.setText(form);
    }
}
