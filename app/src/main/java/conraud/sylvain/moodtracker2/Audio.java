package conraud.sylvain.moodtracker2;

import android.content.Context;
import android.media.MediaPlayer;



public class Audio {
    static   int lastPosition;
    static boolean playOk =true;
    static void playSound(int position, Context context){

        if(position != lastPosition && playOk){
            switch (position){
                case 0:MediaPlayer.create(context,R.raw.very_sad).start();
                    break;
                case 1:MediaPlayer.create(context,R.raw.disapointed).start();
                    break;
                case 2:MediaPlayer.create(context,R.raw.normal).start();
                    break;
                case 3:MediaPlayer.create(context,R.raw.happy).start();
                    break;
                case 4:MediaPlayer.create(context,R.raw.very_happy).start();
                    break;
            }
            playOk =false;
            lastPosition = position;
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    playOk = true;
                }
            },1000);
        }

    }



}
