package com.example.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {
    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNumber;
    private TextView email;
    private TextView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        setupUIViews();
        initToolbar();
        seupDetails();
    }
    private void setupUIViews(){
        toolbar = findViewById(R.id.ToolbarFacultyDetails);
        facultyImage = findViewById(R.id.ivFaculty);
        facultyName = findViewById(R.id.tvFacultySelName);
        phoneNumber = findViewById(R.id.tvPhoneNumber);
        email = findViewById(R.id.tvEmail);
        place = findViewById(R.id.tvPlace);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void  seupDetails(){
        int faculty_pos = FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_FACULTY,0);
        String[] facultyNames = getResources().getStringArray(R.array.faculty_name);
        int[] facultyImages = new int[]{R.drawable.book, R.drawable.calender, R.drawable.contact, R.drawable.timetable,R.drawable.settings,R.drawable.play,R.drawable.timetable,R.drawable.calender};
        int[] facultyArray = new int[]{R.array.jeya,R.array.vani,R.array.devi,R.array.sasi,R.array.anish,R.array.mal,R.array.thiru,R.array.soun};
        String[] facultyDetails = getResources().getStringArray(facultyArray[faculty_pos]);
        phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        place.setText(facultyDetails[2]);
        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultyNames[faculty_pos]);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
