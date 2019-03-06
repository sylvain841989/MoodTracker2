package conraud.sylvain.moodtracker2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        int[] resultMood = {0,0,0,0,0};
        Mood[] arrayMood = Save.moodArray;
        PieChartView pieChartView=findViewById(R.id.id_activity_statistic_chartPie);
        List<SliceValue> piedata = new ArrayList<>();




        for (Mood mood : arrayMood){
            resultMood[mood.mood]+=1;
        }

        if(resultMood[0] > 0 )
            piedata.add(new SliceValue(resultMood[0],0xffde3c50).setLabel("sad"));
        if(resultMood[1] > 0 )
            piedata.add(new SliceValue(resultMood[1],0xff9b9b9b).setLabel("disappointed"));
        if(resultMood[2] > 0 )
            piedata.add(new SliceValue(resultMood[2],0xa5468ad9).setLabel("normal"));
        if(resultMood[3] > 0 )
            piedata.add(new SliceValue(resultMood[3],0xffb8e986).setLabel("happy"));
        if(resultMood[4] > 0 )
            piedata.add(new SliceValue(resultMood[4],0xfff9ec4f).setLabel("very happy"));

        PieChartData pieChartData = new PieChartData(piedata);
        pieChartData.setHasLabels(true);
        pieChartView.setPieChartData(pieChartData);
    }


}