package demo.pomelo.pomelonews.view.fragment.FistFragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.News_Toutiao;
import demo.pomelo.pomelonews.provider.DataBeanViewProvider;
import demo.pomelo.pomelonews.utils.GetScreenParameter;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.Subscriber;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

public class Sub5_FirstFragment extends BaseSubFragment{

    private static Sub5_FirstFragment sub5_firstFragment;

    int screenHeight;
    //判断是否往上，往下移动
    boolean isMoveDown = true;
    boolean isMoveUp = false;

    //动画
    private ObjectAnimator navigationToDownAnim;
    private ObjectAnimator navigationToUpAnim;

    private static final String TYPE = "type";
    private  Items items = null;  //相当于List<Object>
    private List<News_Toutiao.ResultBean.DataBean> listBean = new ArrayList<>();
    private LinearLayoutManager mLayoutManager = null;
    private  MultiTypeAdapter mAdapter = null;
    private RecyclerView recyclerView = null;
    private DataBeanViewProvider mProvider = null;


    public  static Sub5_FirstFragment newInstance(){
        if(sub5_firstFragment==null){
            sub5_firstFragment = new Sub5_FirstFragment();
        }
        return sub5_firstFragment;
    }


    /**
     * RxJava框架的观察者
     * 用于实时更新网络请求到的数据
     */
    public Subscriber<News_Toutiao> subscriber = new Subscriber<News_Toutiao>() {
        @Override
        public void onCompleted() {}

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(News_Toutiao newsToutiao) {

            items.clear();
            items.addAll(newsToutiao.getResult().getData());
            mAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO
        items = new Items();
        mAdapter = new MultiTypeAdapter(items);
        mProvider = new DataBeanViewProvider(items);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first_sub_1, container, false);
        //下拉刷新控件
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewGroup.findViewById(R.id.swipeRefreshLayout_fragment_first_sub_1);
        initSwipeRefresh(swipeRefreshLayout);

        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_fragment_first_sub_1);
        mLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        recyclerView.setLayoutManager(mLayoutManager);


        if(listBean==null){
            listBean.add(new News_Toutiao.ResultBean.DataBean());
            items.addAll(listBean);
        }

        //注册类型和View的对应关系
        mAdapter.register(News_Toutiao.ResultBean.DataBean.class,mProvider);
        mProvider.setOnRecyclerViewItemClickListener(this);
        recyclerView.setAdapter(mAdapter);

        //监听滑动
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                setAnimator();//设置动画
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

    //初始下拉刷新
    private void initSwipeRefresh(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeResources(R.color.colorSwipeRefreshLayout);
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                requestRetrofit("keji");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            requestRetrofit("keji");
        }else {
        }
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
}


