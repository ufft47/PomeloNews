package demo.pomelo.pomelonews.view.fragment.ThirdFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.AnimLoading;
import demo.pomelo.pomelonews.entity.Zhihu;
import demo.pomelo.pomelonews.provider.AnimLoadingViewProvider;
import demo.pomelo.pomelonews.provider.ZhihuItemViewProvider;
import demo.pomelo.pomelonews.utils.httputils.ZhihuRetrofitUtil;
import demo.pomelo.pomelonews.view.fragment.BaseFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FourthFragment.FourthFragment;
import demo.pomelo.pomelonews.view.fragment.SecondFragment.SecondFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.functions.Action1;

import static android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

/**
 * Created by UnclePomelo on 2017/2/15.
 */

public class MoreItemFragment extends BaseFragment implements ZhihuItemViewProvider.OnItemClickListener {
    private static MoreItemFragment moreItemFragment;

    FragmentManager fragmentManager;
    ZhihuItemViewProvider zhihuItemViewProvider;

    MultiTypeAdapter mAdapter;
    Items items;
    AnimLoading animLoading = new AnimLoading(); //底部动画
    int date = -1;

    public static MoreItemFragment newIntance() {
        if (moreItemFragment == null) {
            moreItemFragment = new MoreItemFragment();
        }
        return moreItemFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化FragmentManager
        fragmentManager = getFragmentManager();
        requestZhihuRetrofit("http://news-at.zhihu.com/",
                new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_third_more, container, false);
        ImageView ivBack = (ImageView) viewGroup.findViewById(R.id.iv_back_fragment_third_more);

        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_fragment_third_more);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        items = new Items();
        items.add(animLoading);

        zhihuItemViewProvider = new ZhihuItemViewProvider();
        //设置监听
        zhihuItemViewProvider.setOnItemClickListener(this);

        mAdapter = new MultiTypeAdapter(items);
        mAdapter.register(Zhihu.NewsBean.class, zhihuItemViewProvider);
        mAdapter.register(AnimLoading.class, new AnimLoadingViewProvider());

        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                final Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, date--);

                int lastVisiblePosition = mLayoutManager.findLastVisibleItemPosition();
                int itemCount = mLayoutManager.getItemCount();
                boolean isBottom = lastVisiblePosition>=itemCount-1;
                if(isBottom){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             requestZhihuRetrofit("http://news-at.zhihu.com/"
                                     ,new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
                        }
                    },1500);
                }
            }
        });


        //添加点击事件
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示的部分导航栏
                mainActivity.bottomNavigationBar.unHide(true);
                mainActivity.bottomNavigationBar.unHide();
                if (fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentManager.popBackStack("MoreItemFragment", POP_BACK_STACK_INCLUSIVE);
                    fragmentTransaction
                            .hide(FirstFragment.newInstance())
                            .hide(SecondFragment.newInstance())
                            .hide(FourthFragment.newInstance())
                            .show(ThirdFragment.newInstance())
                            .commit();
                }
            }
        });
        return viewGroup;
    }


    //请求加载知乎信息
    private void requestZhihuRetrofit(String url, String date) {
        ZhihuRetrofitUtil.newInstance(url, date, "MoreItemFragment");
    }

    //观察者
    public Action1<Zhihu> zhihuAction = new Action1<Zhihu>() {

        @Override
        public void call(Zhihu zhihu) {
            int beginPosition = items.indexOf(animLoading);
            items.addAll(beginPosition, zhihu.getNews());
            mAdapter.notifyItemRangeChanged(beginPosition, zhihu.getNews().size());
        }
    };

    //点击事件回调
    @Override
    public void onItemClick(String id) {
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .add(R.id.framelayout_activity_main, DetailFragment.newInstance(id,"MoreItemFragment"), "DetailFragment")
                    .addToBackStack("DetailFragment")
                    .hide(MoreItemFragment.newIntance())
                    .show(DetailFragment.newInstance(id,"MoreItemFragment"))
                    .commit();
        }
    }
}
