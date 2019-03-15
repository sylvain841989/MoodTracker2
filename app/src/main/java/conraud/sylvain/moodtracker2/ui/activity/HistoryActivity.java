package conraud.sylvain.moodtracker2.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import conraud.sylvain.moodtracker2.data.Mood;
import conraud.sylvain.moodtracker2.R;
import conraud.sylvain.moodtracker2.utils.Save;


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
            convertView = getLayoutInflater().inflate(R.layout.activity_history_item,null);
            int[] colors = getResources().getIntArray(R.array.colorsArray);


            RelativeLayout relativeLayout = convertView.findViewById(R.id.activity_history_item);
            TextView textView = convertView.findViewById(R.id.activity_history_item_text_view);
            ImageView imageView = convertView.findViewById(R.id.activity_history_item_image_view);

            relativeLayout.setBackgroundColor(colors[moodArray[position].getMood()]);
            if(moodArray[position].getComment() == null)
                imageView.setVisibility(View.INVISIBLE);

            int height = parent.getMeasuredHeight();
            int width = (parent.getMeasuredWidth())/100;
            RelativeLayout.LayoutParams layoutParams;

            layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = ((moodArray[position].getMood()*15)+40)*width;
            layoutParams.height=height/7;
            relativeLayout.setLayoutParams(layoutParams);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HistoryActivity.this, moodArray[position].getComment(),Toast.LENGTH_SHORT).show();
                }
            });

            textView.setText(pastTime[position]);
            return convertView;
        }
    }
}
