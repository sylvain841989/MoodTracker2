package conraud.sylvain.moodtracker2;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class HistoryActivity extends AppCompatActivity {
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.line_history,null);

            RelativeLayout relativeLayout = convertView.findViewById(R.id.line_history_relative_layout);
            TextView textView = convertView.findViewById(R.id.line_history_text_view);

            int height = parent.getMeasuredHeight();
            relativeLayout.setMinimumHeight(height/7);

            textView.setText(pastTime[position]);
            return convertView;
        }
    }
}
