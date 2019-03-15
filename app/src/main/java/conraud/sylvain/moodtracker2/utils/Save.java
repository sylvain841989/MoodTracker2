package conraud.sylvain.moodtracker2.utils;

import android.content.Context;
import android.content.SharedPreferences;

import conraud.sylvain.moodtracker2.data.Mood;

import static android.content.Context.MODE_PRIVATE;

public abstract class Save{

    public static String KEY_SAVE_POSITION = "keySavePosition";
    public static String KEY_SAVE_COMMENT = "keySaveComment";
    public static Mood moodArray[] = new Mood[7];
    public static SharedPreferences preferences;
    public static String mCurrentComment;
    public static int mCurrentMood;

    public static void saveDay(int date){
        preferences.edit().putInt("date",date).apply();
    }
    public static int daySaved( Context context){
        return context.getSharedPreferences("PREF", MODE_PRIVATE).getInt("date",0);
    }

    public static void savePosition (int position){

       preferences.edit().putInt(KEY_SAVE_POSITION,position).apply();
       mCurrentMood = position;
    }

    public static int getPosition(Context context){
        int result;

        result =context.getSharedPreferences("PREF",MODE_PRIVATE).getInt(KEY_SAVE_POSITION,3);

        return result;
    }

    public static void saveComment(String comment)
    {
        preferences.edit().putString(KEY_SAVE_COMMENT,comment).apply();
        mCurrentComment = comment;
    }

    public static void loadHistory(Context context){
        for(int i = 0 ; i<moodArray.length ; i++){

            String comment = context.getSharedPreferences("PREF", MODE_PRIVATE).getString("commentHistory"+i,null);
            int mood = context.getSharedPreferences("PREF",MODE_PRIVATE).getInt("moodHistory"+i,3);
            moodArray[i]= new Mood(comment,mood);
        }
    }
   public static void saveHistory(){
        for (int i = 0; i<moodArray.length ; i++){
            preferences.edit().putString("commentHistory"+i, moodArray[i].getComment()).apply();
            preferences.edit().putInt("moodHistory"+i, moodArray[i].getMood()).apply();

        }
    }
    public static void addMood(){
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
