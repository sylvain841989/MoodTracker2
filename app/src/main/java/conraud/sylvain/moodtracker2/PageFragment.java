package conraud.sylvain.moodtracker2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        ImageView imageView = result.findViewById(R.id.fragment_page_image_view_smiley);

        int position = getArguments().getInt(KEY_POSITION);
        int color = getArguments().getInt(KEY_COLOR);
        int smiley = getArguments().getInt(KEY_SMILEY);

        relativeLayout.setBackgroundColor(color);
        imageView.setImageResource(smiley);

        return result;
    }




}
