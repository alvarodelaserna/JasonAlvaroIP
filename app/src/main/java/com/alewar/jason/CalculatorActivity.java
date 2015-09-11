package com.alewar.jason;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class CalculatorActivity extends Activity implements View.OnClickListener{

    private final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    //    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private EditText e_day, e_month, e_year;
    private TextView twenty, thirty, thirtyOne;
    private Button calculate, reset;
    private RelativeLayout result;
    private SimpleDateFormat sdf;
    private Calendar c, c1, c2, c3;
    private String dateInString;
    private Context mContext;
    private ImageButton calendar_icon;

    private TextView currentMonth, currentYear;
    private Button selectedDayMonthYearButton;
    private ImageView prevMonth, nextMonth, prevYear, nextYear;
    private GridView calendarView;
    private GridCellAdapter adapter;
    private Calendar _calendar;
    @SuppressLint("NewApi")
    private int month, year;
    @SuppressWarnings("unused")
    @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
    private final DateFormat dateFormatter = new DateFormat();
    private static final String dateTemplate = "dd-MM-yyyy";
    private String theday, themonth, theyear;
    private Dialog dialog;
    private String[] dateToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mContext = this;
        c = Calendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        String t = sdf.format(today);
        dateToday = t.split("-");
        result = (RelativeLayout)findViewById(R.id.result);
        e_day = (EditText)findViewById(R.id.day);
        e_month = (EditText)findViewById(R.id.month);
        e_year = (EditText)findViewById(R.id.year);
        twenty = (TextView)findViewById(R.id.twenty_months);
        thirty = (TextView)findViewById(R.id.thirty_months);
        thirtyOne = (TextView)findViewById(R.id.thirtyone_months);
        calculate = (Button)findViewById(R.id.button_calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = Calendar.getInstance();
                c2 = Calendar.getInstance();
                c3 = Calendar.getInstance();
                if (e_day.getText().toString().equals("") || e_month.getText().toString().equals("") || e_year.getText().toString().equals("")||Integer.valueOf(e_month.getText().toString())>12||Integer.valueOf(e_day.getText().toString())>31) {
                    Toast.makeText(mContext, "Invalid date format", Toast.LENGTH_SHORT).show();
                } else{
                    dateInString = e_day.getText().toString() + "-" + e_month.getText().toString() + "-" + e_year.getText().toString();
                    try {
                        c1.setTime(sdf.parse(dateInString));
                        c2.setTime(sdf.parse(dateInString));
                        c3.setTime(sdf.parse(dateInString));
                        add20months(c1);
                        add30months(c2);
                        add31months(c3);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        Log.e("DATE ERR", "PARSE DATE EXCEPTION");
                    }
                    result.setVisibility(View.VISIBLE);
                }
            }
        });
        reset = (Button)findViewById(R.id.button_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setVisibility(View.INVISIBLE);
                e_day.setText(dateToday[0]);
                e_month.setText(dateToday[1]);
                e_year.setText(dateToday[2]);
            }
        });
        e_day.setText(dateToday[0]);
        e_month.setText(dateToday[1]);
        e_year.setText(dateToday[2]);
        e_day.requestFocus();
        calendar_icon = (ImageButton)findViewById(R.id.calendar);
        calendar_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.my_calendar_view);
                _calendar = Calendar.getInstance(Locale.getDefault());
                month = _calendar.get(Calendar.MONTH) + 1;
                year = _calendar.get(Calendar.YEAR);
//                selectedDayMonthYearButton = (Button) dialog.findViewById(R.id.selectedDayMonthYear);
//                selectedDayMonthYearButton.setText("Selected: ");

                currentYear = (TextView) dialog.findViewById(R.id.currentYear);
                currentYear.setText(dateToday[2]);
                prevYear = (ImageView) dialog.findViewById(R.id.prevYear);
                prevYear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        year--;
                        setGridCellAdapterToDate(month, year);
                    }
                });
                prevMonth = (ImageView) dialog.findViewById(R.id.prevMonth);
                prevMonth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (month <= 1) {
                            month = 12;
                            year--;
                        } else {
                            month--;
                        }
                        setGridCellAdapterToDate(month, year);
                    }
                });

                currentMonth = (TextView) dialog.findViewById(R.id.currentMonth);
                currentMonth.setText(getMonth(Integer.valueOf(dateToday[1])));

                nextMonth = (ImageView) dialog.findViewById(R.id.nextMonth);
                nextMonth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (month > 11) {
                            month = 1;
                            year++;
                        } else {
                            month++;
                        }
                        setGridCellAdapterToDate(month, year);
                    }
                });

                nextYear = (ImageView) dialog.findViewById(R.id.nextYear);
                nextYear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        year++;
                        setGridCellAdapterToDate(month, year);
                    }
                });

                calendarView = (GridView) dialog.findViewById(R.id.calendar);

                // Initialised
                adapter = new GridCellAdapter(mContext, R.id.calendar_day_gridcell, month, year);
                adapter.notifyDataSetChanged();
                calendarView.setAdapter(adapter);
                dialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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

    private void add20months(Calendar c){
        c.add(Calendar.MONTH, 20);
        sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date resultdate = new Date(c.getTimeInMillis());   // Get new time
        dateInString = sdf.format(resultdate);
        twenty.setText(dateInString);
    }
    private void add30months(Calendar c){
        c.add(Calendar.MONTH, 30);
        sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date resultdate = new Date(c.getTimeInMillis());   // Get new time
        dateInString = sdf.format(resultdate);
        thirty.setText(dateInString);
    }
    private void add31months(Calendar c){
        c.add(Calendar.MONTH, 31);
        sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date resultdate = new Date(c.getTimeInMillis());   // Get new time
        dateInString = sdf.format(resultdate);
        thirtyOne.setText(dateInString);
    }

    /**
     *
     * @param month
     * @param year
     */
    private void setGridCellAdapterToDate(int month, int year) {
        adapter = new GridCellAdapter(getApplicationContext(),
                R.id.calendar_day_gridcell, month, year);
        _calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
        currentMonth.setText(getMonth(month));
        currentYear.setText(String.valueOf(year));
        adapter.notifyDataSetChanged();
        calendarView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == prevMonth) {
            if (month <= 1) {
                month = 12;
                year--;
            } else {
                month--;
            }
//            Log.d(tag, "Setting Prev Month in GridCellAdapter: " + "Month: "
//                    + month + " Year: " + year);
            setGridCellAdapterToDate(month, year);
        }
        if (v == nextMonth) {
            if (month > 11) {
                month = 1;
                year++;
            } else {
                month++;
            }
//            Log.d(tag, "Setting Next Month in GridCellAdapter: " + "Month: "
//                    + month + " Year: " + year);
            setGridCellAdapterToDate(month, year);
        }

    }

    // Inner Class
    public class GridCellAdapter extends BaseAdapter implements View.OnClickListener {
        private static final String tag = "GridCellAdapter";
        private final Context _context;

        private final List<String> list;
        private static final int DAY_OFFSET = 1;
        private final String[] weekdays = new String[] { "Sun", "Mon", "Tue",
                "Wed", "Thu", "Fri", "Sat" };
        private final String[] months = { "January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        private final int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30,
                31, 30, 31 };
        private int daysInMonth;
        private int currentDayOfMonth;
        private int currentWeekDay;
        private Button gridcell;
        private TextView num_events_per_day;
        private final HashMap<String, Integer> eventsPerMonthMap;
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");

        // Days in Current Month
        public GridCellAdapter(Context context, int textViewResourceId, int month, int year) {
            super();
            this._context = context;
            this.list = new ArrayList<String>();
//            Log.d(tag, "==> Passed in Date FOR Month: " + month + " "
//                    + "Year: " + year);
            Calendar calendar = Calendar.getInstance();
            setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
            setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
//            Log.d(tag, "New Calendar:= " + calendar.getTime().toString());
//            Log.d(tag, "CurrentDayOfWeek :" + getCurrentWeekDay());
//            Log.d(tag, "CurrentDayOfMonth :" + getCurrentDayOfMonth());

            // Print Month
            printMonth(month, year);

            // Find Number of Events
            eventsPerMonthMap = findNumberOfEventsPerMonth(year, month);
        }

        private String getMonthAsString(int i) {
            return months[i];
        }

        private String getWeekDayAsString(int i) {
            return weekdays[i];
        }

        private int getNumberOfDaysOfMonth(int i) {
            return daysOfMonth[i];
        }

        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * Prints Month
         *
         * @param mm
         * @param yy
         */
        private void printMonth(int mm, int yy) {
//            Log.d(tag, "==> printMonth: mm: " + mm + " " + "yy: " + yy);
            int trailingSpaces = 0;
            int daysInPrevMonth = 0;
            int prevMonth = 0;
            int prevYear = 0;
            int nextMonth = 0;
            int nextYear = 0;

            int currentMonth = mm - 1;
            String currentMonthName = getMonthAsString(currentMonth);
            daysInMonth = getNumberOfDaysOfMonth(currentMonth);

//            Log.d(tag, "Current Month: " + " " + currentMonthName + " having "
//                    + daysInMonth + " days.");

            GregorianCalendar cal = new GregorianCalendar(yy, currentMonth, 1);
//            Log.d(tag, "Gregorian Calendar:= " + cal.getTime().toString());

            if (currentMonth == 11) {
                prevMonth = currentMonth - 1;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                nextMonth = 0;
                prevYear = yy;
                nextYear = yy + 1;
//                Log.d(tag, "*->PrevYear: " + prevYear + " PrevMonth:"
//                        + prevMonth + " NextMonth: " + nextMonth
//                        + " NextYear: " + nextYear);
            } else if (currentMonth == 0) {
                prevMonth = 11;
                prevYear = yy - 1;
                nextYear = yy;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                nextMonth = 1;
//                Log.d(tag, "**--> PrevYear: " + prevYear + " PrevMonth:"
//                        + prevMonth + " NextMonth: " + nextMonth
//                        + " NextYear: " + nextYear);
            } else {
                prevMonth = currentMonth - 1;
                nextMonth = currentMonth + 1;
                nextYear = yy;
                prevYear = yy;
                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
//                Log.d(tag, "***---> PrevYear: " + prevYear + " PrevMonth:"
//                        + prevMonth + " NextMonth: " + nextMonth
//                        + " NextYear: " + nextYear);
            }

            int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
            trailingSpaces = currentWeekDay;

//            Log.d(tag, "Week Day:" + currentWeekDay + " is "
//                    + getWeekDayAsString(currentWeekDay));
//            Log.d(tag, "No. Trailing space to Add: " + trailingSpaces);
//            Log.d(tag, "No. of Days in Previous Month: " + daysInPrevMonth);

            if (cal.isLeapYear(cal.get(Calendar.YEAR)))
                if (mm == 2)
                    ++daysInMonth;
                else if (mm == 3)
                    ++daysInPrevMonth;

            // Trailing Month days
            for (int i = 0; i < trailingSpaces; i++) {
//                Log.d(tag,
//                        "PREV MONTH:= "
//                                + prevMonth
//                                + " => "
//                                + getMonthAsString(prevMonth)
//                                + " "
//                                + String.valueOf((daysInPrevMonth
//                                - trailingSpaces + DAY_OFFSET)
//                                + i));
                list.add(String
                        .valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET)
                                + i)
                        + "-GREY"
                        + "-"
                        + getMonthAsString(prevMonth)
                        + "-"
                        + prevYear);
            }

            // Current Month Days
            for (int i = 1; i <= daysInMonth; i++) {
//                Log.d(currentMonthName, String.valueOf(i) + " "
//                        + getMonthAsString(currentMonth) + " " + yy);
                if (i == getCurrentDayOfMonth()) {
                    list.add(String.valueOf(i) + "-BLUE" + "-"
                            + getMonthAsString(currentMonth) + "-" + yy);
                } else {
                    list.add(String.valueOf(i) + "-WHITE" + "-"
                            + getMonthAsString(currentMonth) + "-" + yy);
                }
            }

            // Leading Month days
            for (int i = 0; i < list.size() % 7; i++) {
//                Log.d(tag, "NEXT MONTH:= " + getMonthAsString(nextMonth));
                list.add(String.valueOf(i + 1) + "-GREY" + "-"
                        + getMonthAsString(nextMonth) + "-" + nextYear);
            }
        }

        /**
         * NOTE: YOU NEED TO IMPLEMENT THIS PART Given the YEAR, MONTH, retrieve
         * ALL entries from a SQLite database for that month. Iterate over the
         * List of All entries, and get the dateCreated, which is converted into
         * day.
         *
         * @param year
         * @param month
         * @return
         */
        private HashMap<String, Integer> findNumberOfEventsPerMonth(int year,
                                                                    int month) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            return map;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) _context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.screen_gridcell, parent, false);
            }

            // Get a reference to the Day gridcell
            gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
            gridcell.setOnClickListener(this);

            // ACCOUNT FOR SPACING

            Log.d(tag, "Current Day: " + getCurrentDayOfMonth());
            String[] day_color = list.get(position).split("-");
            theday = day_color[0];
            themonth = day_color[2];
            theyear = day_color[3];
            if ((!eventsPerMonthMap.isEmpty()) && (eventsPerMonthMap != null)) {
                if (eventsPerMonthMap.containsKey(theday)) {
                    num_events_per_day = (TextView) row
                            .findViewById(R.id.num_events_per_day);
                    Integer numEvents = (Integer) eventsPerMonthMap.get(theday);
                    num_events_per_day.setText(numEvents.toString());
                }
            }

            // Set the Day GridCell
            gridcell.setText(theday);
            gridcell.setTag(theday + "-" + themonth + "-" + theyear);
//            Log.d(tag, "Setting GridCell " + theday + "-" + themonth + "-"
//                    + theyear);

            if (day_color[1].equals("GREY")) {
                gridcell.setTextColor(getResources()
                        .getColor(R.color.lightgray));
            }
            if (day_color[1].equals("WHITE")) {
                gridcell.setTextColor(getResources().getColor(
                        R.color.lightgray02));
            }
            if (day_color[1].equals("BLUE")) {
                gridcell.setTextColor(getResources().getColor(R.color.orrange));
            }
            return row;
        }



        @Override
        public void onClick(View view) {
            String date_month_year = (String) view.getTag();
//            selectedDayMonthYearButton.setText("Selected: " + date_month_year);
//            Log.e("Selected date", date_month_year);
            String[] arr = date_month_year.split("-");
            setDay(arr[0]);
            setMonth(arr[1]);
            e_year.setText(arr[2]);
            dialog.dismiss();
        }

        public int getCurrentDayOfMonth() {
            return currentDayOfMonth;
        }

        private void setCurrentDayOfMonth(int currentDayOfMonth) {
            this.currentDayOfMonth = currentDayOfMonth;
        }

        public void setCurrentWeekDay(int currentWeekDay) {
            this.currentWeekDay = currentWeekDay;
        }

        public int getCurrentWeekDay() {
            return currentWeekDay;
        }
    }

    private void setDay(String day){
        String aux = "";
        if(Integer.valueOf(day)<10){
            aux = "0"+day;
        }else{
            aux = day;
        }
        e_day.setText(aux);
    }

    private void setMonth(String month){
        for(int i=0;i<months.length;i++){
            if(month.equals(months[i])){
                String aux = "";
                if(i<9){
                    i++;
                    aux = "0"+String.valueOf(i);
                }else{
                    i++;
                    aux = String.valueOf(i);
                }
                e_month.setText(aux);
            }
        }
    }

    private String getMonth(int month){
        return months[month-1];
    }
}
