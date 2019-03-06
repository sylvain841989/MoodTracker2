package conraud.sylvain.moodtracker2;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save.preferences = getSharedPreferences("PREF",MODE_PRIVATE);
        Save.loadHistory(this);

        //if new date
        Save.addMood();


        this.configureViewPager();

    }

    void configureViewPager(){

        ViewPager viewPager = findViewById(R.id.activity_main_vertical_view_pager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorsArray)));
        viewPager.setCurrentItem(Save.getPosition(this));

    }


}
