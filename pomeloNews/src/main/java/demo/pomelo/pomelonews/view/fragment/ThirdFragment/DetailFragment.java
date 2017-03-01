package demo.pomelo.pomelonews.view.fragment.ThirdFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.ZhihuDetail;
import demo.pomelo.pomelonews.utils.httputils.ZhihuDetailRetrofitUtil;
import demo.pomelo.pomelonews.view.fragment.BaseFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FourthFragment.FourthFragment;
import demo.pomelo.pomelonews.view.fragment.SecondFragment.SecondFragment;
import rx.functions.Action1;

import static android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

/**
 * Created by UnclePomelo on 2017/2/16.
 */

public class DetailFragment extends BaseFragment {
    private static DetailFragment detailFragment;

    WebView webView;
    TextView tvTitle;

    public static DetailFragment newInstance(String id, String source) {
        if (detailFragment == null) {
            detailFragment = new DetailFragment();
        }
        if (source != "ZhihuDetailRetrofitUtil") {
            Bundle bundle = new Bundle();
            bundle.putString("source", source);
            bundle.putString("id", id);
            detailFragment.setArguments(bundle);
        }
        return detailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestZhihuDetail(detailFragment.getArguments().getString("id"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_third_detail, container, false);
        ImageView ivBack = (ImageView) viewGroup.findViewById(R.id.iv_back_fragment_third_detail);
        tvTitle = (TextView) viewGroup.findViewById(R.id.tv_title_fragment_third_detail);
        webView = (WebView) viewGroup.findViewById(R.id.webview_fragment_third_detail);
        //设置是否在当前WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//设置图片单列显示
//        webSettings.setTextSize(WebSettings.TextSize.LARGEST);
        webSettings.setTextZoom(300);
        //设置加载进来的页面自适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true); //设置支持缩放
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  //设置 缓存模式
        webSettings.setAppCacheEnabled(true); //开启缓存
        webSettings.setDomStorageEnabled(true);

        File cacheDirPath = mainActivity.getExternalCacheDir();
        //设置  Application Caches 缓存目录
        webSettings.setAppCachePath(cacheDirPath.toString());

        //点击返回监听
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.popBackStack("DetailFragment", POP_BACK_STACK_INCLUSIVE);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    if (detailFragment.getArguments().get("source") == "ThirdFragment") {
                        fragmentTransaction
                                .hide(FirstFragment.newInstance())
                                .hide(SecondFragment.newInstance())
                                .hide(FourthFragment.newInstance())
                                .show(ThirdFragment.newInstance())
                                .commit();
                    } else if (detailFragment.getArguments().get("source") == "MoreItemFragment") {
                        fragmentTransaction.show(MoreItemFragment.newIntance())
                                .commit();
                    }
                }
            }
        });

        return viewGroup;
    }


    public void requestZhihuDetail(String id) {
        ZhihuDetailRetrofitUtil.newInstance("http://news-at.zhihu.com/", id);
    }

    //观察者
    public Action1<ZhihuDetail> zhihuDetailAction = new Action1<ZhihuDetail>() {
        @Override
        public void call(ZhihuDetail zhihuDetail) {
            if (zhihuDetail.getTitle().length() >= 10) {
                tvTitle.setText(zhihuDetail.getTitle().substring(0,10)+"...");
            }else {
                tvTitle.setText(zhihuDetail.getTitle());
            }
            if (webView != null) {
                webView.loadDataWithBaseURL(null, zhihuDetail.getBody(), "text/html", "utf-8", null);
            }
        }
    };
}
