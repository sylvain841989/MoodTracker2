package conraud.sylvain.moodtracker2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public abstract class Save extends AppCompatActivity {

    static String KEY_SAVE_POSITION = "keySavePosition";
    static String KEY_SAVE_COMMENT = "keySaveComment";
    static Mood moodArray[] = new Mood[7];

    static SharedPreferences preferences;
    static String mCurrentComment;
    static int mCurrentMood;

    static void savePosition (int position){

       preferences.edit().putInt(KEY_SAVE_POSITION,position).apply();
       mCurrentMood = position;
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

    static void loadHistory(Context context){
        for(int i = 0 ; i<moodArray.length ; i++){

            String comment = context.getSharedPreferences("PREF", MODE_PRIVATE).getString("commentHistory"+i,null);
            int mood = context.getSharedPreferences("PREF",MODE_PRIVATE).getInt("moodHistory"+i,3);
            moodArray[i]= new Mood(comment,mood);
        }

    }

    static void saveHistory(){
        for (int i = 0; i<moodArray.length ; i++){
            preferences.edit().putString("commentHistory"+i, moodArray[i].comment).apply();
            preferences.edit().putInt("moodHistory"+i, moodArray[i].mood).apply();

        }
    }

    static void addMood(){
        moodArray[0] = null;
        for (int i = 0 ; i<moodArray.length -1 ; i++){
            moodArray[i] = moodArray[i+1];
        }
        preferences.edit().putString("commentHistory6",null).apply();
        moodArray[6] = new Mood(mCurrentComment, mCurrentMood);
        mCurrentComment = null;
        saveHistory();
        preferences.edit().putInt(KEY_SAVE_POSITION,3).apply();

    }


}
