package conraud.sylvain.moodtracker2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class PageFragment extends Fragment {

    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";
    public static final String KEY_SMILEY = "smiley";





    public PageFragment() {
        // Required empty public constructor
    }


    public static PageFragment newInstance(int position, int color, int smiley) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        args.putInt(KEY_SMILEY,smiley);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        RelativeLayout relativeLayout = result.findViewById(R.id.fragment_page_relative_layout);
        ImageView imageViewSmiley = result.findViewById(R.id.fragment_page_image_view_smiley);
        ImageView imageViewAddComment = result.findViewById(R.id.fragment_page_image_view_addComment);
        ImageView imageViewHistory = result.findViewById(R.id.fragment_page_image_view_history);
        int position = getArguments().getInt(KEY_POSITION);
        int color = getArguments().getInt(KEY_COLOR);
        int smiley = getArguments().getInt(KEY_SMILEY);

        relativeLayout.setBackgroundColor(color);
        imageViewSmiley.setImageResource(smiley);

        imageViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        imageViewAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.comment);
                final EditText editText = new EditText(getContext());
                editText.setText(Save.mCurrentComment);
                editText.setFilters(new InputFilter[]{ new InputFilter.LengthFilter(150) });
                builder.setView(editText);
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Save.saveComment(editText.getText().toString());
                    }
                });
                builder.create().show();

            }
        });

        return result;
    }




}
