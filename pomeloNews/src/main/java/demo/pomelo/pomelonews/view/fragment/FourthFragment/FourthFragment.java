package demo.pomelo.pomelonews.view.fragment.FourthFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.About;
import demo.pomelo.pomelonews.entity.Connect;
import demo.pomelo.pomelonews.entity.Text;
import demo.pomelo.pomelonews.provider.AboutViewProvider;
import demo.pomelo.pomelonews.provider.ConnectViewProvider;
import demo.pomelo.pomelonews.provider.TextViewProvider;
import demo.pomelo.pomelonews.view.fragment.BaseFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

/**
 * 底部第四个选项
 */
public class FourthFragment extends BaseFragment {

    private static FourthFragment fourthFragment;
    private static final String TYPE = "type";
    private Items items;
    private MultiTypeAdapter mAdapter;

    public static FourthFragment newInstance() {
        if (fourthFragment == null) {
            fourthFragment = new FourthFragment();
        }

        return fourthFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(fourthFragment.isHidden()){
            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
            transaction.show(fourthFragment).commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_fourth, container, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_fragment_fourth);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        items = new Items();
        items.add(new About());
        items.add(new Text("Contact Designer"));
        items.add(new Connect(R.drawable.ic_tel_fragment_fourth, "181-1122-2321", "MOBILE", R.drawable.ic_msg_fragment_fourth));
        items.add(new Connect(R.drawable.ic_email_fragment_fourth, "pomeloJiang@gmail.com", "EMAIL", R.drawable.ic_msg_fragment_fourth));
        items.add(new Connect(R.drawable.ic_github_fragment_fourth, "https://github.com/pomeloJiang", "GITHUB", 0));

        mAdapter = new MultiTypeAdapter(items);
        mAdapter.register(About.class, new AboutViewProvider());
        mAdapter.register(Text.class, new TextViewProvider());
        mAdapter.register(Connect.class, new ConnectViewProvider());

        recyclerView.setAdapter(mAdapter);
        return viewGroup;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //显示
        if (isVisibleToUser) {
            Log.i("TAG","Visible");
            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
            transaction.show(mainActivity.fragmentManager.findFragmentByTag("position3"))
                    .commit();
        } else {
            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
            transaction.hide(mainActivity.fragmentManager.findFragmentByTag("position3"))
                    .commit();
        }
    }
}
