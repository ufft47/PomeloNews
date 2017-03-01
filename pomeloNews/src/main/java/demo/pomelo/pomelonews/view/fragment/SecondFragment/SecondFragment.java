package demo.pomelo.pomelonews.view.fragment.SecondFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.AnimLoading;
import demo.pomelo.pomelonews.entity.Youku;
import demo.pomelo.pomelonews.provider.AnimLoadingViewProvider;
import demo.pomelo.pomelonews.provider.YoukuViewProvider;
import demo.pomelo.pomelonews.utils.httputils.YoukuRetrofitUtil;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import rx.functions.Action1;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

/**
 * Created by UnclePomelo on 2017/1/17.
 */

public class SecondFragment extends BaseSecondFragment {

    private static SecondFragment secondFragment;
    Map<String, Object> params = new HashMap<>();

    private Items items;
    private int page = 1;
    private LinearLayoutManager mLayoutManager;
    private MultiTypeAdapter mAdapter;


    public static SecondFragment newInstance() {
        if (secondFragment == null) {
            secondFragment = new SecondFragment();
        }
        return secondFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        params.put("client_id", "326f34e2ea60f5c9");
        params.put("lengthtype", "1");
        params.put("published", "week");
        params.put("category", "94");
        params.put("count", "10");
        params.put("page", page);
        requestYoukuRetrofit("https://api.youku.com/", params);

    }

    private void requestYoukuRetrofit(String baseurl, Map<String, Object> params) {
        YoukuRetrofitUtil.newInstance(baseurl, params);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_second, container, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recyclerview_fragment_third);
        mLayoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.setLayoutManager(mLayoutManager);
        items = new Items();
        items.add(new AnimLoading());
        mAdapter = new MultiTypeAdapter(items);
        mAdapter.register(Youku.VideosBean.class, new YoukuViewProvider(items));
        mAdapter.register(AnimLoading.class, new AnimLoadingViewProvider());
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int itemCount = mLayoutManager.getItemCount();
                int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
                boolean isBottom = lastVisibleItemPosition >= itemCount - 1;
                if (isBottom && newState == SCROLL_STATE_IDLE) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            params.put("page", ++page);
                            requestYoukuRetrofit("https://api.youku.com/", params);
                        }
                    }, 1500);
                }

            }
        });
        return viewGroup;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        //显示
//        if (isVisibleToUser) {
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.show(mainActivity.fragmentManager.findFragmentByTag("position2"))
//                    .commit();
//        } else {
//            FragmentTransaction transaction = mainActivity.fragmentManager.beginTransaction();
//            transaction.hide(mainActivity.fragmentManager.findFragmentByTag("position2"))
//                    .commit();
//        }
//    }


   public Action1<Youku> youkuAction = new Action1<Youku>() {
       int position = 0;
       @Override
       public void call(Youku youku) {
           items.addAll(position, youku.getVideos());
           mAdapter.notifyItemRangeChanged(position, youku.getVideos().size());
           position += youku.getVideos().size();
       }
   };

}
