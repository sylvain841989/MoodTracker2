package conraud.sylvain.moodtracker2;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class HistoryActivity extends AppCompatActivity {
    Mood moodArray[] = Save.moodArray;
    String[] pastTime = new String[]{"Il y a une semaine","Il y a 6 jours","Il y a 5 jours","Il y a 4 jours","Il y a 3 jours","Avant-hier","Hier"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView listView = findViewById(R.id.activity_history_list_view);
        listView.setEnabled(false);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);




    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.line_history,null);
            int[] colors = getResources().getIntArray(R.array.colorsArray);


            RelativeLayout relativeLayout = convertView.findViewById(R.id.line_history_relative_layout);
            TextView textView = convertView.findViewById(R.id.line_history_text_view);
            ImageView imageView = convertView.findViewById(R.id.line_history_image_view);

            relativeLayout.setBackgroundColor(colors[moodArray[position].mood]);
            if(moodArray[position].comment == null)
                imageView.setVisibility(View.INVISIBLE);

            int height = parent.getMeasuredHeight();
            int width = (parent.getMeasuredWidth())/100;
            RelativeLayout.LayoutParams layoutParams;

            layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = ((moodArray[position].mood*15)+40)*width;
            layoutParams.height=height/7;
            relativeLayout.setLayoutParams(layoutParams);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HistoryActivity.this, moodArray[position].comment,Toast.LENGTH_SHORT).show();
                }
            });

            textView.setText(pastTime[position]);
            return convertView;
        }
    }
}
