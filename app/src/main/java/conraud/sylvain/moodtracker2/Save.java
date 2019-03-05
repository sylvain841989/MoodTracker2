package conraud.sylvain.moodtracker2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public abstract class Save extends AppCompatActivity {

    static SharedPreferences preferences;
    static String KEY_SAVE_POSITiON = "keySavePosition";

    static void savePosition (int position){

       preferences.edit().putInt(KEY_SAVE_POSITiON,position).apply();
    }

    static int getPosition(Context context){
        int result;

        result =context.getSharedPreferences("PREF",MODE_PRIVATE).getInt(KEY_SAVE_POSITiON,3);

        return result;
    }





}
