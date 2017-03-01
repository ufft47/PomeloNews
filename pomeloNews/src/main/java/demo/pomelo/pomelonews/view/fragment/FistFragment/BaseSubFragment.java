package demo.pomelo.pomelonews.view.fragment.FistFragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import demo.pomelo.pomelonews.utils.httputils.ToutiaoRetrofitUtil;
import demo.pomelo.pomelonews.provider.DataBeanViewProvider;
import demo.pomelo.pomelonews.view.MainActivity;

/**
 * Created by UnclePomelo on 2017/1/30.
 */

public class BaseSubFragment extends Fragment implements DataBeanViewProvider.OnRecyclerViewItemClickListener {

    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mainActivity = (MainActivity) context;
    }

    //请求网络
    public void requestRetrofit(String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("type", type);
        params.put("key", "bdd5ce16247fe9e58a7bfab4b065d9ab");
        ToutiaoRetrofitUtil.getInstance("http://v.juhe.cn/", params);
    }


    //ViewProvider中的回调方法,点击Item打开一个WebViewFragment
    @Override
    public void OnItemClick(View view, String url, String title) {
        Intent intent = new Intent();
        intent.setAction("open.webView");
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        //发送广播
        view.getContext().sendBroadcast(intent);
        Log.i("TAG","广播发送成功");
    }
}
