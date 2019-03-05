package conraud.sylvain.moodtracker2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public abstract class Save extends AppCompatActivity {

    static String KEY_SAVE_POSITION = "keySavePosition";
    static String KEY_SAVE_COMMENT = "keySaveComment";


    static SharedPreferences preferences;
    static String mCurrentComment;
    static void savePosition (int position){

       preferences.edit().putInt(KEY_SAVE_POSITION,position).apply();
    }

    static int getPosition(Context context){
        int result;

        result =context.getSharedPreferences("PREF",MODE_PRIVATE).getInt(KEY_SAVE_POSITION,3);

        return result;
    }

    static void saveComment(String comment)
    {
        preferences.edit().putString(KEY_SAVE_COMMENT,comment).apply();
        mCurrentComment = comment;
    }





}
