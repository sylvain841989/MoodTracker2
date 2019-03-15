package conraud.sylvain.moodtracker2.ui.activity;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import conraud.sylvain.moodtracker2.ui.fragment.PageAdapter;
import conraud.sylvain.moodtracker2.R;
import conraud.sylvain.moodtracker2.utils.Save;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save.preferences = getSharedPreferences("PREF",MODE_PRIVATE);
        Save.loadHistory(this);

        //date
        Calendar calendar = Calendar.getInstance();
        int dateOfTheDay = calendar.get(Calendar.DAY_OF_YEAR);
        //if new date
        if(dateOfTheDay != Save.daySaved(MainActivity.this))
        {
            Save.addMood();
            Save.saveDay(dateOfTheDay);
        }
        this.configureViewPager();
    }
    void configureViewPager(){

        ViewPager viewPager = findViewById(R.id.activity_main_vertical_view_pager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorsArray)));
        viewPager.setCurrentItem(Save.getPosition(this));
    }
}
