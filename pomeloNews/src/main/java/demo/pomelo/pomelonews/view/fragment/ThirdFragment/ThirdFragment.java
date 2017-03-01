package demo.pomelo.pomelonews.view.fragment.ThirdFragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.AnimLoading;
import demo.pomelo.pomelonews.entity.PicLoop;
import demo.pomelo.pomelonews.entity.Text;
import demo.pomelo.pomelonews.entity.Zhihu;
import demo.pomelo.pomelonews.provider.AnimLoadingViewProvider;
import demo.pomelo.pomelonews.provider.PicLoopProvider;
import demo.pomelo.pomelonews.provider.ZhihuViewProvider;
import demo.pomelo.pomelonews.utils.GetScreenParameter;
import demo.pomelo.pomelonews.utils.httputils.ZhihuRetrofitUtil;
import demo.pomelo.pomelonews.view.fragment.BaseFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FourthFragment.FourthFragment;
import demo.pomelo.pomelonews.view.fragment.SecondFragment.SecondFragment;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.functions.Action1;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

/**
 * 底部第二个选项
 */
public class ThirdFragment extends BaseFragment implements ZhihuViewProvider.onMoreClickListener,ZhihuViewProvider.OnItemClickListener,PicLoopProvider.OnLoopClickListener {
    private static ThirdFragment thirdFragment;

    int screenHeight;
    //判断是否往上，往下移动
    boolean isMoveDown = true;
    boolean isMoveUp = false;

    //动画
    private ObjectAnimator navigationToDownAnim;
    private ObjectAnimator navigationToUpAnim;


    FragmentTransaction transaction = null;
    FragmentManager fragmentManager = null;
    Toolbar toolbar;
    public boolean isRewenLoaded = false;
    Items items;
    MultiTypeAdapter mAdapter;
    //相对于当前时间的日期
    int date = -1;

    Boolean isBottom = false;
    Text textLatest;
    Text textBefore;
    AnimLoading animLoading = new AnimLoading();


    public static ThirdFragment newInstance() {
        if (thirdFragment == null) {
            thirdFragment = new ThirdFragment();
        }
        return thirdFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        requestZhihuRetrofit("http://news-at.zhihu.com/", "");

        requestZhihuRetrofit("http://news-at.zhihu.com/",
                new SimpleDateFormat("yyyyMMdd").format(new Date()));//日期
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_third, container, false);
        toolbar = (Toolbar) viewGroup.findViewById(R.id.toolbar_activity_third);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_fragment_third);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(viewGroup.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        items = new Items();
        textLatest = new Text("今日热闻");

        items.add(animLoading);

        mAdapter = new MultiTypeAdapter(items);

        ZhihuViewProvider zhihuProvider = new ZhihuViewProvider(items);
        PicLoopProvider picLoopProvider = new PicLoopProvider();
        //图片轮播点击监听
        picLoopProvider.setOnLoopClickListener(this);
        //监听more点击事件
        zhihuProvider.setOnMoreClickListener(this);
        //点击监听
        zhihuProvider.setOnItemClickListener(this);
        //注册ViewHolder
        mAdapter.register(PicLoop.class, picLoopProvider);
        mAdapter.register(Zhihu.class, zhihuProvider);
        mAdapter.register(AnimLoading.class, new AnimLoadingViewProvider());

        recyclerView.setAdapter(mAdapter);

        //设置控件动画
        setAnimator();

        //监听滑动
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(final RecyclerView recyclerView, final int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstVisiblePosition = mLayoutManager.findFirstVisibleItemPosition();
                final int lastVisiblePosition = mLayoutManager.findLastVisibleItemPosition();
                int itemCount = mLayoutManager.getItemCount();
                //判断是否滑到底部
                isBottom = lastVisiblePosition >= itemCount - 1;
                if (isBottom && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    final Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE, date--);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            requestZhihuRetrofit("http://news-at.zhihu.com/",
                                    new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
                        }
                    }, 1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0 && isMoveDown) {  //往下移动
                    navigationToDownAnim.start();
                    isMoveDown = false;
                    isMoveUp = true;

                } else if (dy < 0 && isMoveUp) {  //往上移动
                    navigationToUpAnim.start();
                    isMoveDown = true;
                    isMoveUp = false;
                }
            }
        });
        return viewGroup;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //设置动画
    private void setAnimator() {

        GetScreenParameter getScreenParameter = new GetScreenParameter(mainActivity);
        screenHeight = getScreenParameter.getScreenHeight();

        //底部导航栏动画，往下
        navigationToDownAnim = ObjectAnimator.ofFloat(mainActivity.bottomNavigationBar,
                "Y",
                mainActivity.bottomNavigationBar.getTop(),
                screenHeight);
        navigationToDownAnim.setDuration(500);

        //底部导航栏动画，往上
        navigationToUpAnim = ObjectAnimator.ofFloat(mainActivity.bottomNavigationBar,
                "Y",
                screenHeight, mainActivity.bottomNavigationBar.getTop());
        navigationToUpAnim.setDuration(500);
    }


//    //界面可见与不可见
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        //显示
//        if (isVisibleToUser) {
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.show(mainActivity.fragmentManager.findFragmentByTag("position1"))
//                    .commit();
//
//        } else {
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.hide(mainActivity.fragmentManager.findFragmentByTag("position1"))
//                    .commit();
//        }
//    }

    //请求加载知乎信息
    private void requestZhihuRetrofit(String url, String date) {
        ZhihuRetrofitUtil.newInstance(url, date, "ThirdFragment");
    }

    //知乎数据观察者的回调
    public Action1<Zhihu> zhihuBeforeAction = new Action1<Zhihu>() {
        //第一次加载
        private boolean isFirstLoad = true;
        //每次item加载起始位置
        int beginPosition;
        Text textBefore;

        @Override
        public void call(Zhihu zhihuBefore) {
            //先加载今日热闻
            if (isRewenLoaded) {
                if (isFirstLoad) {
                    //第一次加载
                    beginPosition = items.indexOf(animLoading);
                    items.add(beginPosition, zhihuBefore);
                    mAdapter.notifyItemRangeChanged(beginPosition, 1);
                    isFirstLoad = false;
                } else {
                    beginPosition = items.indexOf(animLoading);
                    items.add(beginPosition, zhihuBefore);
                    mAdapter.notifyItemRangeChanged(beginPosition, 1);
                }
            }
        }
    };

    //今日热闻
    public Action1<Zhihu> zhihuLatestAction = new Action1<Zhihu>() {
        //第一次加载
        private boolean isFirstLoad = true;

        int beginPosition;
        //图片轮播
        private List<String> picUrls = new ArrayList<>();
        private List<String> titles = new ArrayList<>();
        private List<String> urls = new ArrayList<>();
        private List<String> ids = new ArrayList<>();
        @Override
        public void call(Zhihu zhihuLatest) {

            if (isFirstLoad) {
                //图片轮播地址
                for (int i = 0; i < zhihuLatest.getTop_stories().size(); i++) {
                    picUrls.add(zhihuLatest.getTop_stories().get(i).getImage());
                    titles.add(zhihuLatest.getTop_stories().get(i).getTitle());
                    urls.add(zhihuLatest.getTop_stories().get(i).getUrl());
                    ids.add(zhihuLatest.getTop_stories().get(i).getId());
                }
                items.add(0, new PicLoop(picUrls, titles, urls,ids));
//                textLatest.addZhihus(zhihuLatest);
//                beginPosition = items.indexOf(textLatest);
                items.add(1, zhihuLatest);
                mAdapter.notifyItemRangeChanged(0, 2);

                isFirstLoad = false;
                isRewenLoaded = true;
            } else {
                //TODO 局部刷新
            }
        }
    };

    //点击more按钮加载更多
    @Override
    public void onMoreClick(Zhihu zhihu, Context context) {
        //TODO 点击创建一个新的Fragment
        if (!MoreItemFragment.newIntance().isAdded()) {
            mainActivity.bottomNavigationBar.hide(true);
            mainActivity.bottomNavigationBar.hide();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.framelayout_activity_main, MoreItemFragment.newIntance())
                    .addToBackStack("MoreItemFragment")
                    .hide(FirstFragment.newInstance())
                    .hide(SecondFragment.newInstance())
                    .hide(ThirdFragment.newInstance())
                    .hide(FourthFragment.newInstance())
                    .show(MoreItemFragment.newIntance())
                    .commit();
        }
    }

    //Item点击监听
    @Override
    public void onItemClick(String id) {
        if(!DetailFragment.newInstance(id,"ThirdFragment").isAdded()){
            mainActivity.bottomNavigationBar.hide(true);
            mainActivity.bottomNavigationBar.hide();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.framelayout_activity_main, DetailFragment.newInstance(id,"ThirdFragment"))
                    .addToBackStack("DetailFragment")
                    .hide(FirstFragment.newInstance())
                    .hide(SecondFragment.newInstance())
                    .hide(ThirdFragment.newInstance())
                    .hide(FourthFragment.newInstance())
                    .show(DetailFragment.newInstance(id,"ThirdFragment"))
                    .commit();
        }
    }


    //图片轮播监听
    @Override
    public void onLoopClick(String id) {
        if(!DetailFragment.newInstance(id,"ThirdFragment").isAdded()){
            mainActivity.bottomNavigationBar.hide(true);
            mainActivity.bottomNavigationBar.hide();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.framelayout_activity_main, DetailFragment.newInstance(id,"ThirdFragment"))
                    .addToBackStack("DetailFragment")
                    .hide(FirstFragment.newInstance())
                    .hide(SecondFragment.newInstance())
                    .hide(ThirdFragment.newInstance())
                    .hide(FourthFragment.newInstance())
                    .show(DetailFragment.newInstance(id,"ThirdFragment"))
                    .commit();
        }
    }
}
