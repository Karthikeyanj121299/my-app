package com.example.timetable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timetable.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static String[]DayOrder1;
    public static String[]DayOrder2;
    public static String[]DayOrder3;
    public static String[]DayOrder4;
    public static String[]DayOrder5;
    public static String[]Time1;
    public static String[]Time2;
    public static String[]Time3;
    public static String[]Time4;
    public static String[]Time5;
    private String[] PreferredDay;
    private String[] PreferredTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.lvDayDetail);
        toolbar= (Toolbar)findViewById(R.id.ToolbarDayDetail);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        DayOrder1 = getResources().getStringArray(R.array.DayOrder1);
        DayOrder2 = getResources().getStringArray(R.array.DayOrder2);
        DayOrder3 = getResources().getStringArray(R.array.DayOrder3);
        DayOrder4 = getResources().getStringArray(R.array.DayOrder4);
        DayOrder5 = getResources().getStringArray(R.array.DayOrder5);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);

        String selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null);
        if (selected_day.equalsIgnoreCase("DayOrder1")){
            PreferredDay = DayOrder1;
            PreferredTime = Time1;
        }else if (selected_day.equalsIgnoreCase("DayOrder2")){
            PreferredDay = DayOrder2;
            PreferredTime = Time2;
        }else if (selected_day.equalsIgnoreCase("DayOrder3")){
            PreferredDay = DayOrder3;
            PreferredTime = Time3;
        }else if (selected_day.equalsIgnoreCase("DayOrder4")){
            PreferredDay = DayOrder4;
            PreferredTime = Time4;
        }else{
            PreferredDay = DayOrder5;
            PreferredTime = Time5;
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,PreferredDay,PreferredTime);
        listView.setAdapter(simpleAdapter);
    }

    public class SimpleAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject,time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context,String[] subjectArray, String[] timeArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }
            subject = convertView.findViewById(R.id.tvSubjectDayDetails);
            time = convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = convertView.findViewById(R.id.ivDayDetails);
            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;

        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
