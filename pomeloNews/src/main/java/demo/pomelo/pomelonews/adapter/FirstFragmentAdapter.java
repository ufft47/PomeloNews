package demo.pomelo.pomelonews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

public class FirstFragmentAdapter extends FragmentPagerAdapter {

    List<String> titles = new ArrayList<String>();
    List<Fragment> fragments = new ArrayList<Fragment>();


    public FirstFragmentAdapter(FragmentManager fm, List<String> titles,List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
