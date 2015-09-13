package com.alewar.jason;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import com.alewar.jason.activities.CountryActivity;
import com.alewar.jason.core.ParkIP;
import com.alewar.jason.core.ParkIPDBHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by alvaro on 11/09/15.
 */
public class Utils {

    private static final String TAG = Utils.class.getCanonicalName();
    private static int countryIndex;
    private static TextView acronym, agreement, language, trans, forms,
            deadline, power_of_attorney, assignments, translation_extension, excess_claim_fee, examination_request,
            country_acronym_pct, power_of_attorney_pct, assignments_pct, language_pct, excess_claim_fee_pct, examination_request_pct,
            country_acronym_dpc, power_of_attorney_dpc, assignments_dpc, language_dpc, excess_claim_fee_dpc, examination_request_dpc,
            country_acronym_euro;
    private static String[] countryArray;

    public static void spinnerSetup(){

    }

    public static void getDisplayByCountry(CountryActivity countryActivity, String name, String[] countries){
        countryArray = countries;
        switch (name){
            case "Albania": // Albania
                countryIndex = 0;
                createEURO(countryActivity, "No", "Albanian", "Claims (Albanian)", "Yes");
                break;
            case "Algeria": // Algeria
                countryIndex = 1;
                createPCT(countryActivity, "31 months", "Yes", "Yes", "Arabic", "Yes", "No", "N/A");
                break;
            case "Argentina": // Argentina
                countryIndex = 2;
                createDPC(countryActivity, "Yes", "Sometimes", "Spanish", "Yes", "Deferred");
                break;
            case "ARIPO": // ARIPO
                countryIndex = 3;
                createDPC(countryActivity, "Yes", "Yes", "English", "No", "Deferred");
                break;
            case "Australia": // Australia
                countryIndex = 4;
                createPCT(countryActivity, "31 months", "No", "No", "English", "N/A", "No", "Deferred");
                break;
            case "Austria": // Austria
                countryIndex = 5;
                createEURO(countryActivity, "No", "German", "Yes", "Yes");
                break;
            case "Bangladesh": // Bangladesh
                countryIndex = 6;
                createDPC(countryActivity, "Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Belgium": // Belgium
                countryIndex = 7;
                createEURO(countryActivity, "No", "French, Dutch and German", "Yes", "No");
                break;
            case "Belize": // Belize
                countryIndex = 8;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "English", "N/A", "No", "Deferred");
                break;
            case "Bolivia": // Bolivia
                countryIndex = 9;
                createDPC(countryActivity, "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Bosnia & Herzegovina": // Bosnia & Herzegovina
                countryIndex = 10;
                createEURO(countryActivity, "No", "Bosnian, Croatian and Serbian", "Claims (Bosnian)", "Yes");
                break;
            case "Brazil": // Brazil
                countryIndex = 11;
                createPCT(countryActivity, "30 months", "Yes", "Sometimes", "Portuguese", "Yes", "No", "Deferred");
                break;
            case "Bulgaria": // Bulgaria
                countryIndex = 12;
                createEURO(countryActivity, "No", "Bulgarian", "Yes", "Yes");
                break;
            case "Canada": // Canada
                countryIndex = 13;
                createPCTandDPC(countryActivity, "30 months", "No", "No", "English/French", "No", "No", "Deferred",
                        "No", "No", "English/French", "No", "Deferred");
                break;
            case "Chile": // Chile
                countryIndex = 14;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "Spanish", "No", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "China": // China
                countryIndex = 15;
                createPCTandDPC(countryActivity, "30 months", "Yes", "Sometimes", "Chinese", "No", "Yes", "Deferred",
                        "No", "Sometimes", "Chinese", "Yes", "Deferred");
                break;
            case "Colombia": // Colombia
                countryIndex = 16;
                createPCT(countryActivity, "31 months", "Yes", "Yes", "Spanish", "No", "Yes", "Deferred");
                break;
            case "Costa Rica": // Costa Rica
                countryIndex = 17;
                createPCT(countryActivity, "31 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred");
                break;
            case "Croatia": // Croatia
                countryIndex = 18;
                createEURO(countryActivity, "Yes", "English", "Claims (Croatian)", "Yes");
                break;
            case "Cyprus": // Cyprus
                countryIndex = 19;
                createEURO(countryActivity, "No", "Greek", "Yes", "Yes");
                break;
            case "Czech Republic": // Czech Republic
                countryIndex = 20;
                createEURO(countryActivity, "No", "Czech", "Yes", "Yes");
                break;
            case "Denmark": // Denmark
                countryIndex = 21;
                createEURO(countryActivity, "Yes", "Danish", "Claims (Danish)", "No");
                break;
            case "Dominican Republic": // Dominican Republic
                countryIndex = 22;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Ecuador": // Ecuador
                countryIndex = 23;
                createPCT(countryActivity, "30 months", "Yes", "No", "Spanish", "No", "Yes", "No");
                break;
            case "Egypt": // Egypt
                countryIndex = 24;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "Arabic & English", "No", "No", "Deferred",
                        "Yes", "Yes", "Arabic", "No", "Deferred");
                break;
            case "El Salvador": // El Salvador
                countryIndex = 25;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred");
                break;
            case "Estonia": // Estonia
                countryIndex = 26;
                createEURO(countryActivity, "No", "Estonian", "Yes", "Yes");
                break;
            case "Eurasia": // Eurasia
                countryIndex = 27;
                createPCTandDPC(countryActivity, "31 months", "No", "No", "Russian", "Yes", "Yes", "Included",
                        "No", "No", "Russian", "Yes", "Deferred");
                break;
            case "Europe": // Europe
                countryIndex = 28;
                createPCTandDPC(countryActivity, "31 months", "No", "No", "English/French/German", "N/A", "Yes", "Included",
                        "No", "No", "English/French/German", "Yes", "Included");
                break;
            case "Finland": // Finland
                countryIndex = 29;
                createEURO(countryActivity, "Yes", "Finnish (Swedish)", "Claims (Finnish)", "No");
                break;
            case "France": // France
                countryIndex = 30;
                createEURO(countryActivity, "Yes", "English, French and German", "No", "No");
                break;
            case "Gulf Cooperation Council": // Gulf Cooperation Council
                countryIndex = 31;
                createDPC(countryActivity, "Yes", "Yes", "English & Arabic", "No", "Deferred");
                break;
            case "Georgia": // Georgia
                countryIndex = 32;
                createPCT(countryActivity, "31 months", "Yes", "Yes", "Georgian", "Yes", "No", "Deferred");
                break;
            case "Germany": // Germany
                countryIndex = 33;
                createPCTandDPCandEURO(countryActivity, "30 months", "Recommended", "No", "German", "No", "Yes", "Deferred",
                        "Recommended", "No", "German", "Yes", "Deferred", "Yes", "English, French and German", "No", "No");
                break;
            case "Greece": // Greece
                countryIndex = 34;
                createEURO(countryActivity, "No", "Greek", "Yes", "Yes");
                break;
            case "Guatemala": // Guatemala
                countryIndex = 35;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Honduras": // Honduras
                countryIndex = 36;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "No", "No", "Deferred");
                break;
            case "Hong Kong": // Hong Kong
                countryIndex = 37;
                createPCT(countryActivity, "36 months", "No", "No", "English/Chinese", "No", "No", "N/A");
                break;
            case "Hungary": // Hungary
                countryIndex = 38;
                createEURO(countryActivity, "Yes", "Hungarian", "Claims (Hungarian)", "Yes");
                break;
            case "Iceland": // Iceland
                countryIndex = 39;
                createEURO(countryActivity, "Yes", "Icelandic", "Claims (Icelandic)", "No");
                break;
            case "India": // India
                countryIndex = 40;
                createPCTandDPC(countryActivity, "31 months", "Yes", "Yes", "English", "N/A", "Yes", "Deferred",
                        "Yes", "Yes", "English", "Yes", "Deferred");
                break;
            case "Indonesia": // Indonesia
                countryIndex = 41;
                createPCT(countryActivity, "31 months", "Yes", "Yes", "Indonesian", "Yes", "Yes", "Deferred");
                break;
            case "Ireland": // Ireland
                countryIndex = 42;
                createEURO(countryActivity, "No", "Irish & English", "No", "Yes");
                break;
            case "Israel": // Israel
                countryIndex = 43;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "English/Hebrew", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English/Hebrew", "Yes", "Deferred");
                break;
            case "Italy": // Italy
                countryIndex = 44;
                createEURO(countryActivity, "No", "Italian", "Yes", "Yes");
                break;
            case "Japan": // Japan
                countryIndex = 45;
                createPCTandDPC(countryActivity, "30 months", "No", "No", "Japanese", "Yes", "No", "Deferred",
                        "No", "No", "Japanese", "No", "Deferred");
                break;
            case "Jordan": // Jordan
                countryIndex = 46;
                createDPC(countryActivity, "Yes", "Yes", "English & Arabic", "No", "Deferred");
                break;
            case "Kenia": // Kenia
                countryIndex = 47;
                createPCT(countryActivity, "30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred");
                break;
            case "Latvia": // Latvia
                countryIndex = 48;
                createEURO(countryActivity, "Yes", "Latvian", "Claims (Latvian)", "Yes");
                break;
            case "Lebanon": // Lebanon
                countryIndex = 49;
                createDPC(countryActivity, "Yes", "Yes", "English & French", "No", "Deferred");
                break;
            case "Lithuania": // Lithuania
                countryIndex = 50;
                createEURO(countryActivity, "Yes", "Lithuanian", "Claims (Lithuanian)", "Yes");
                break;
            case "Luxembourg": // Luxembourg
                countryIndex = 51;
                createEURO(countryActivity, "Yes", "English", "No", "No");
                break;
            case "Macedonia": // Macedonia
                countryIndex = 52;
                createEURO(countryActivity, "No", "Macedonian", "Claims (Macedonian)", "Yes");
                break;
            case "Malaysia": // Malaysia
                countryIndex = 53;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Malta": // Malta
                countryIndex = 54;
                createEURO(countryActivity, "No", "Maltese & English", "Yes", "Yes");
                break;
            case "Mexico": // Mexico
                countryIndex = 55;
                createPCTandDPC(countryActivity, "30 months", "Yes", "Sometimes", "Spanish", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Included");
                break;
            case "Monaco": // Monaco
                countryIndex = 56;
                createEURO(countryActivity, "Yes", "French & English", "No", "Yes");
                break;
            case "Montenegro": // Montenegro
                countryIndex = 57;
                createEURO(countryActivity, "No", "Serbian", "Yes", "Yes");
                break;
            case "Morocco": // Morocco
                countryIndex = 58;
                createPCT(countryActivity, "31 months", "Yes", "No", "French/Arabic", "No", "Yes", "Deferred");
                break;
            case "The Netherlands": // The Netherlands
                countryIndex = 59;
                createEURO(countryActivity, "Yes", "Dutch", "Claims (Dutch)", "No");
                break;
            case "New Zealand": // New Zealand
                countryIndex = 60;
                createPCT(countryActivity, "31 months", "No", "No", "English", "N/A", "No", "Included");
                break;
            case "Nicaragua": // Nicaragua
                countryIndex = 61;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Included");
                break;
            case "Nigeria": // Nigeria
                countryIndex = 62;
                createPCT(countryActivity, "30 months", "Yes", "No", "English", "No", "No", "Included");
                break;
            case "Norway": // Norway
                countryIndex = 63;
                createPCTandEURO(countryActivity, "31 months", "Yes", "No", "Norwegian", "Yes", "Yes", "Included",
                        "Yes", "Norwegian", "Yes", "Yes");
                break;
            case "OAPI": // OAPI
                countryIndex = 64;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "English/French", "No", "Yes", "Deferred",
                        "Yes", "Yes", "English/French", "No", "Deferred");
                break;
            case "Pakistan": // Pakistan
                countryIndex = 65;
                createDPC(countryActivity, "Yes", "Yes", "English", "Yes", "Included");
                break;
            case "Panama": // Panama
                countryIndex = 66;
                createPCTandDPC(countryActivity, "30 months", "Yes", "Yes", "Spanish", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Paraguay": // Paraguay
                countryIndex = 67;
                createDPC(countryActivity, "Yes", "Yes", "Spanish", "No", "Deferred");
                break;
            case "Peru": // Peru
                countryIndex = 68;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "Spanish", "No", "Yes", "No");
                break;
            case "Philippines": // Philippines
                countryIndex = 69;
                createPCTandDPC(countryActivity, "30 months", "Yes", "No", "English", "N/A", "Yes", "Deferred",
                        "Yes", "No", "English", "Yes", "Deferred");
                break;
            case "Poland": // Poland
                countryIndex = 70;
                createEURO(countryActivity, "No", "Polish", "Yes", "Yes");
                break;
            case "Portugal": // Portugal
                countryIndex = 71;
                createEURO(countryActivity, "No", "Portuguese", "Yes", "No");
                break;
            case "Romania": // Romania
                countryIndex = 72;
                createEURO(countryActivity, "No", "Romanian", "Yes", "Yes");
                break;
            case "Russia": // Russia
                countryIndex = 73;
                createPCTandDPC(countryActivity, "31 months", "No", "No", "Russian", "Yes", "Yes", "Deferred",
                        "No", "No", "Russian", "Yes", "Deferred");
                break;
            case "San Marino": // San Marino
                countryIndex = 74;
                createEURO(countryActivity, "No", "Italian", "Yes", "Yes");
                break;
            case "Serbia": // Serbia
                countryIndex = 75;
                createEURO(countryActivity, "No", "Serbian", "Yes", "Yes");
                break;
            case "Singapore": // Singapore
                countryIndex = 76;
                createPCTandDPC(countryActivity, "30 months", "No", "No", "English", "N/A", "No", "**",
                        "No", "No", "English", "No", "Deferred");
                break;
            case "Slovakia": // Slovakia
                countryIndex = 77;
                createEURO(countryActivity, "No", "Slovak", "Yes", "Yes");
                break;
            case "Slovenia": // Slovenia
                countryIndex = 78;
                createEURO(countryActivity, "No", "Slovenian", "Claims (Slovenian)", "Yes");
                break;
            case "South Africa": // South Africa
                countryIndex = 79;
                createPCTandDPC(countryActivity, "31 months", "Yes", "Yes", "English", "N/A", "No", "Deferred",
                        "Yes", "Yes", "English", "No", "Deferred");
                break;
            case "South Korea": // South Korea
                countryIndex = 80;
                createPCTandDPC(countryActivity, "31 months", "Yes", "No", "Korean", "No", "No", "Deferred",
                        "Yes", "No", "Korean", "No", "Deferred");
                break;
            case "Spain": // Spain
                countryIndex = 81;
                createEURO(countryActivity, "No", "Spanish", "Yes", "No");
                break;
            case "Sweden": // Sweden
                countryIndex = 82;
                createEURO(countryActivity, "Yes", "Swedish", "Claims (Swedish)", "No");
                break;
            case "Switzerland/Liechtenstein": // Switzerland/Liechtenstein
                countryIndex = 83;
                createEURO(countryActivity, "Yes", "English, French, German, Italian and German (Liechtenstein)", "No", "Yes");
                break;
            case "Syria": // Syria
                countryIndex = 84;
                createPCT(countryActivity, "31 months", "Yes", "No", "Arabic", "Yes", "Yes", "Deferred");
                break;
            case "Taiwan": // Taiwan
                countryIndex = 85;
                createDPC(countryActivity, "Yes", "No", "Chinese", "No", "Deferred");
                break;
            case "Thailand": // Thailand
                countryIndex = 86;
                createPCTandDPC(countryActivity, "30 months", "Yes", "Yes", "Thai", "No", "No", "Deferred",
                        "Yes", "Yes", "Thai", "No", "Deferred");
                break;
            case "Tunisia": // Tunisia
                countryIndex = 87;
                createPCT(countryActivity, "30 months", "Yes", "No", "English/Arabic/French", "No", "Yes", "Included");
                break;
            case "Turkey": // Turkey
                countryIndex = 88;
                createEURO(countryActivity, "No", "Turkish", "Yes", "Yes");
                break;
            case "Ukraine": // Ukraine
                countryIndex = 89;
                createPCTandDPC(countryActivity, "31 months", "Yes", "No", "Ukrainian", "Yes", "Yes", "Deferred",
                        "Yes", "No", "Ukrainian", "Yes", "Deferred");
                break;
            case "United Arab Emirates": // United Arab Emirates
                countryIndex = 90;
                createPCT(countryActivity, "30 months", "Yes", "Yes", "English & Arabic", "No", "No", "Deferred");
                break;
            case "United Kingdom": // United Kingdom
                countryIndex = 91;
                createPCTandDPCandEURO(countryActivity, "31 months", "No", "No", "English", "N/A", "No", "Included",
                        "No", "No", "English", "No", "Deferred", "Yes", "English, French and German", "No", "No");
                break;
            case "United States": // United States
                countryIndex = 92;
                createPCTandDPC(countryActivity, "30 months", "Yes", "Yes", "English", "N/A", "Yes", "Included",
                        "Yes", "Yes", "English", "Yes", "Included");
                break;
            case "Uruguay": // Uruguay
                countryIndex = 93;
                createDPC(countryActivity, "Yes", "No", "Spanish", "Yes", "Deferred");
                break;
            case "Venezuela": // Venezuela
                countryIndex = 94;
                createDPC(countryActivity, "Yes", "Yes", "Spanish", "No", "N/A");
                break;
            case "Vietnam": // Vietnam
                countryIndex = 95;
                createPCTandDPC(countryActivity, "31 months", "Yes", "Sometimes", "Vietnamese", "Yes", "No", "Deferred",
                        "Yes", "Yes", "Vietnamese", "No", "Deferred");
                break;
        }
    }

    private static void createPCT(CountryActivity countryActivity, String deadLine, String PoA, String assign, String lang,
                                  String translationExtension, String excessCF, String examReq){
        countryActivity.setContentView(R.layout.pct_layout);
        acronym = (TextView) countryActivity.findViewById(R.id.country_acronym);
        acronym.setText(countryArray[countryIndex]);
        deadline = (TextView) countryActivity.findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney = (TextView) countryActivity.findViewById(R.id.power_of_attorney);
        power_of_attorney.setText(PoA);
        assignments = (TextView) countryActivity.findViewById(R.id.assignments);
        assignments.setText(assign);
        language = (TextView) countryActivity.findViewById(R.id.language);
        language.setText(lang);
        translation_extension = (TextView) countryActivity.findViewById(R.id.translation_extension);
        translation_extension.setText(translationExtension);
        excess_claim_fee = (TextView) countryActivity.findViewById(R.id.excess_claim_fee);
        excess_claim_fee.setText(excessCF);
        examination_request = (TextView) countryActivity.findViewById(R.id.examination_request);
        examination_request.setText(examReq);
    }

    private static void createDPC(CountryActivity countryActivity, String PoA, String assign, String lang, String excessCF, String examReq){
        countryActivity.setContentView(R.layout.dpc_layout);
        acronym = (TextView) countryActivity.findViewById(R.id.country_acronym);
        acronym.setText(countryArray[countryIndex]);
        power_of_attorney = (TextView) countryActivity.findViewById(R.id.power_of_attorney);
        power_of_attorney.setText(PoA);
        assignments = (TextView) countryActivity.findViewById(R.id.assignments);
        assignments.setText(assign);
        language = (TextView) countryActivity.findViewById(R.id.language);
        language.setText(lang);
        excess_claim_fee = (TextView) countryActivity.findViewById(R.id.excess_claim_fee);
        excess_claim_fee.setText(excessCF);
        examination_request = (TextView) countryActivity.findViewById(R.id.examination_request);
        examination_request.setText(examReq);
    }

    private static void createEURO(CountryActivity countryActivity, String londonAg, String lang, String transReq, String form){
        countryActivity.setContentView(R.layout.euro_layout);
        acronym = (TextView) countryActivity.findViewById(R.id.country_acronym);
        acronym.setText(countryArray[countryIndex]);
        agreement = (TextView)countryActivity.findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)countryActivity.findViewById(R.id.language);
        language.setText(lang);
        trans = (TextView)countryActivity.findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)countryActivity.findViewById(R.id.forms);
        forms.setText(form);
    }

    private static void createPCTandDPC(CountryActivity countryActivity, String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                        String excClaims_pct, String exReq_pct, String PoA_dpc, String assign_dpc,
                                        String lang_dpc, String excClaims_dpc, String exReq_dpc){
        countryActivity.setContentView(R.layout.pct_dpc_layout);
        country_acronym_dpc = (TextView) countryActivity.findViewById(R.id.country_acronym_dpc);
        country_acronym_dpc.setText(countryArray[countryIndex]);
        country_acronym_pct = (TextView) countryActivity.findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countryArray[countryIndex]);
        deadline = (TextView) countryActivity.findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) countryActivity.findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) countryActivity.findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) countryActivity.findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) countryActivity.findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) countryActivity.findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) countryActivity.findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        power_of_attorney_dpc = (TextView) countryActivity.findViewById(R.id.power_of_attorney_dpc);
        power_of_attorney_dpc.setText(PoA_dpc);
        assignments_dpc = (TextView) countryActivity.findViewById(R.id.assignments_dpc);
        assignments_dpc.setText(assign_dpc);
        language_dpc = (TextView) countryActivity.findViewById(R.id.language_dpc);
        language_dpc.setText(lang_dpc);
        excess_claim_fee_dpc = (TextView) countryActivity.findViewById(R.id.excess_claim_fee_dpc);
        excess_claim_fee_dpc.setText(excClaims_dpc);
        examination_request_dpc = (TextView) countryActivity.findViewById(R.id.examination_request_dpc);
        examination_request_dpc.setText(exReq_dpc);
    }

    private static void createPCTandDPCandEURO(CountryActivity countryActivity, String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                               String excClaims_pct, String exReq_pct, String PoA_dpc, String assign_dpc,
                                               String lang_dpc, String excClaims_dpc, String exReq_dpc,
                                               String londonAg, String lang, String transReq, String form){
        countryActivity.setContentView(R.layout.pct_dpc_euro_layout);
        country_acronym_dpc = (TextView) countryActivity.findViewById(R.id.country_acronym_dpc);
        country_acronym_dpc.setText(countryArray[countryIndex]);
        country_acronym_pct = (TextView) countryActivity.findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countryArray[countryIndex]);
        country_acronym_euro = (TextView) countryActivity.findViewById(R.id.country_acronym_euro);
        country_acronym_euro.setText(countryArray[countryIndex]);
        deadline = (TextView) countryActivity.findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) countryActivity.findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) countryActivity.findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) countryActivity.findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) countryActivity.findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) countryActivity.findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) countryActivity.findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        power_of_attorney_dpc = (TextView) countryActivity.findViewById(R.id.power_of_attorney_dpc);
        power_of_attorney_dpc.setText(PoA_dpc);
        assignments_dpc = (TextView) countryActivity.findViewById(R.id.assignments_dpc);
        assignments_dpc.setText(assign_dpc);
        language_dpc = (TextView) countryActivity.findViewById(R.id.language_dpc);
        language_dpc.setText(lang_dpc);
        excess_claim_fee_dpc = (TextView) countryActivity.findViewById(R.id.excess_claim_fee_dpc);
        excess_claim_fee_dpc.setText(excClaims_dpc);
        examination_request_dpc = (TextView) countryActivity.findViewById(R.id.examination_request_dpc);
        examination_request_dpc.setText(exReq_dpc);
        agreement = (TextView)countryActivity.findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)countryActivity.findViewById(R.id.language_euro);
        language.setText(lang);
        trans = (TextView)countryActivity.findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)countryActivity.findViewById(R.id.forms);
        forms.setText(form);
    }

    private static void createPCTandEURO(CountryActivity countryActivity, String deadLine, String PoA_pct, String assign_pct, String lang_pct, String transExt,
                                         String excClaims_pct, String exReq_pct,
                                         String londonAg, String lang, String transReq, String form){
        countryActivity.setContentView(R.layout.pct_euro_layout);
        country_acronym_pct = (TextView) countryActivity.findViewById(R.id.country_acronym_pct);
        country_acronym_pct.setText(countryArray[countryIndex]);
        country_acronym_euro = (TextView) countryActivity.findViewById(R.id.country_acronym_euro);
        country_acronym_euro.setText(countryArray[countryIndex]);
        deadline = (TextView) countryActivity.findViewById(R.id.deadline);
        deadline.setText(deadLine);
        power_of_attorney_pct = (TextView) countryActivity.findViewById(R.id.power_of_attorney_pct);
        power_of_attorney_pct.setText(PoA_pct);
        assignments_pct = (TextView) countryActivity.findViewById(R.id.assignments_pct);
        assignments_pct.setText(assign_pct);
        language_pct = (TextView) countryActivity.findViewById(R.id.language_pct);
        language_pct.setText(lang_pct);
        translation_extension = (TextView) countryActivity.findViewById(R.id.translation_extension);
        translation_extension.setText(transExt);
        excess_claim_fee_pct = (TextView) countryActivity.findViewById(R.id.excess_claim_fee_pct);
        excess_claim_fee_pct.setText(excClaims_pct);
        examination_request_pct = (TextView) countryActivity.findViewById(R.id.examination_request_pct);
        examination_request_pct.setText(exReq_pct);
        agreement = (TextView)countryActivity.findViewById(R.id.london_agreement);
        agreement.setText(londonAg);
        language = (TextView)countryActivity.findViewById(R.id.language_euro);
        language.setText(lang);
        trans = (TextView)countryActivity.findViewById(R.id.translations_required);
        trans.setText(transReq);
        forms = (TextView)countryActivity.findViewById(R.id.forms);
        forms.setText(form);
    }
}
