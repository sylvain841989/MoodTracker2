package conraud.sylvain.moodtracker2.UI;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import conraud.sylvain.moodtracker2.R;
import conraud.sylvain.moodtracker2.utils.Save;

public class DialogSMS extends DialogFragment {

    String num , message;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String [] mood = new String[5];
        mood[0] = "Aujourd'hui je suis vraiment triste";
        mood[1] = "Aujourd'hui je ne suis pas au top";
        mood[2] = "Ca pourrait aller mieux mais ça pourrait être pire";
        mood[3] = "Ajourd'hui ca va plutot bien";
        mood[4] = "Aujourd'hui je suis super content";

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_sms,null);
        builder.setView(view);
        builder.setTitle("Send Message");
        final EditText editTextMsg =view.findViewById(R.id.dialog_sms_edit_text_message);
        final EditText editTextNum =view.findViewById(R.id.dialog_sms_edit_text_number);

        if(Save.mCurrentComment == null){
            editTextMsg.setText(mood[Save.mCurrentMood]);
        }else{
            editTextMsg.setText(mood[Save.mCurrentMood] + " car " +Save.mCurrentComment);

        }

        builder.setPositiveButton("Envoyer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                num = editTextNum.getText().toString();
                message = editTextMsg.getText().toString();
                sendSMS(); }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        return builder.create(); }

    void sendSMS(){
        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            if(num.length() == 10 && message!=null){
                SmsManager.getDefault().sendTextMessage(num,null,message,null,null);
                Toast.makeText(getContext(),"SMS envoyé", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getContext(),"erreur de saisi",Toast.LENGTH_SHORT).show();
            }
        }else {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},1);
        }
    }
}
