package demo.pomelo.pomelonews.view.fragment.FistFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.adapter.FirstFragmentAdapter;
import demo.pomelo.pomelonews.view.fragment.BaseFragment;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

/**
 * 底部第一个选项
 */
public class FirstFragment extends BaseFragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    private static FirstFragment firstFragment;

    List<String> listTitles = new ArrayList<String>();
    List<Fragment> listFragment = new ArrayList<Fragment>();

    private static final String INDEX = "index";

    public static FirstFragment newInstance() {
        if(firstFragment == null){
            firstFragment = new FirstFragment();
        }
        return firstFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            listTitles.add("推荐");
            listTitles.add("社会");
            listTitles.add("娱乐");
            listTitles.add("体育");
            listTitles.add("科技");
            listTitles.add("时尚");
            listFragment.add(Sub1_FirstFragment.newInstance());
            listFragment.add(Sub2_FirstFragment.newInstance());
            listFragment.add(Sub3_FirstFragment.newInstance());
            listFragment.add(Sub4_FirstFragment.newInstance());
            listFragment.add(Sub5_FirstFragment.newInstance());
            listFragment.add(Sub6_FirstFragment.newInstance());

        }

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first, container, false);

        init(viewGroup);
        return viewGroup;
    }

    private void init(ViewGroup viewGroup) {
        tabLayout = (TabLayout) viewGroup.findViewById(R.id.tablayout_fragment_first);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager = (ViewPager) viewGroup.findViewById(R.id.viewpager_fragment_first);
        FirstFragmentAdapter firstFragmentAdapter =
                new FirstFragmentAdapter(getChildFragmentManager(), listTitles, listFragment);

        viewPager.setAdapter(firstFragmentAdapter);
        //将TabLayout与Viewpager关联
        tabLayout.setupWithViewPager(viewPager);
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        //显示
//        if (isVisibleToUser) {
//
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.show(mainActivity.fragmentManager.findFragmentByTag("position0"))
//                    .commit();
//        } else {
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.hide(mainActivity.fragmentManager.findFragmentByTag("position0"))
//                    .commit();
//        }
//    }

}
