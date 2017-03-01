package demo.pomelo.pomelonews.utils.httputils;


import java.util.concurrent.TimeUnit;

import demo.pomelo.pomelonews.view.fragment.ThirdFragment.MoreItemFragment;
import demo.pomelo.pomelonews.view.fragment.ThirdFragment.ThirdFragment;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by UnclePomelo on 2017/2/12.
 */

public class ZhihuRetrofitUtil {

    OkHttpClient okHttpClient;
    Retrofit retrofit;

    private ZhihuRetrofitUtil(String baseUrl, String date,String source) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .writeTimeout(8000, TimeUnit.MILLISECONDS)
                    .readTimeout(8000, TimeUnit.MILLISECONDS)
                    .connectTimeout(8000, TimeUnit.MILLISECONDS)
                    .build();
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        IZhihuService zhihuService = retrofit.create(IZhihuService.class);

        if(source == "ThirdFragment"){
            if (date == "") {
                zhihuService.getZhihuLatest()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(ThirdFragment.newInstance().zhihuLatestAction);
            }

            if (date != "") {
                zhihuService.getZhihuBefore(date)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(ThirdFragment.newInstance().zhihuBeforeAction);
            }
        }else if(source == "MoreItemFragment"){
            zhihuService.getZhihuBefore(date)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(MoreItemFragment.newIntance().zhihuAction);
        }
    }

    public static ZhihuRetrofitUtil newInstance(String url, String date,String source) {
        final ZhihuRetrofitUtil zhihuLatestRetrofitUtil = new ZhihuRetrofitUtil(url, date,source);
        return zhihuLatestRetrofitUtil;
    }
}
