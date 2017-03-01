package demo.pomelo.pomelonews.view.fragment.FistFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.view.WebActivity;

/**
 * Created by UnclePomelo on 2017/1/24.
 */

public class WebViewFragment extends Fragment implements WebActivity.OnKeyBackClickListener {

    private static WebViewFragment webViewFragment;
     WebView webView = null;

    public static WebViewFragment newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
       if(webViewFragment==null){
           webViewFragment = new WebViewFragment();
       }
        webViewFragment.setArguments(bundle);
        return webViewFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof WebActivity) {
            ((WebActivity) getActivity()).setOnKeyBackClickListener(this);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first_webview, container, false);
        webView = (WebView) viewGroup.findViewById(R.id.wv_fragment_first_webview);
        //设置是否在当前WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(true); //设置支持缩放

        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        webView.loadUrl(url);
        return viewGroup;
    }

    //自定义返回键监听的回调方法
    @Override
    public void onKeyBackClick() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            if (getActivity() instanceof WebActivity) {
                getActivity().finish();
            }
        }
    }

}
