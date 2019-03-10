package conraud.sylvain.moodtracker2.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import conraud.sylvain.moodtracker2.UI.PageFragment;
import conraud.sylvain.moodtracker2.R;

public class PageAdapter extends FragmentPagerAdapter {
    private int[] colors;
    int[] smileys = {R.drawable.smiley_sad ,R.drawable.smiley_disappointed,R.drawable.smiley_normal,R.drawable.smiley_happy,R.drawable.smiley_super_happy};

    public PageAdapter(FragmentManager fm, int[] colors) {
        super(fm);
        this.colors = colors;
    }

    @Override
    public Fragment getItem(int position) {

        return new PageFragment().newInstance(position,colors[position],smileys[position]);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
