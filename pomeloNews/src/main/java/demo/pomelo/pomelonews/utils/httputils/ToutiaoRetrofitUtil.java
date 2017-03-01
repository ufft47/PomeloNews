package demo.pomelo.pomelonews.utils.httputils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import demo.pomelo.pomelonews.entity.News_Toutiao;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub1_FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub2_FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub3_FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub4_FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub5_FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FistFragment.Sub6_FirstFragment;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by UnclePomelo on 2017/1/18.
 */


public class ToutiaoRetrofitUtil {

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    private ToutiaoRetrofitUtil(String url, Map<String, Object> params) {
        //创建OKHttp对象
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(8000, TimeUnit.MILLISECONDS)
                    .writeTimeout(8000, TimeUnit.MILLISECONDS)
                    .connectTimeout(8000, TimeUnit.MILLISECONDS)
                    .build();
        }

        //创建retrofit对象
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//用于返回Rxjava调用,非必须
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        //创建InewsToutiaoService接口对象
        INewsToutiaoService newsToutiaoService = retrofit.create(INewsToutiaoService.class);
        Observable<News_Toutiao> observable = newsToutiaoService.getNews(params);

        switch (params.get("type").toString()){
            case "top":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub1_FirstFragment.newInstance().subscriber);
            break;
            case "shehui":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub2_FirstFragment.newInstance().subscriber);
            break;
            case "yule":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub3_FirstFragment.newInstance().subscriber);
            break;
            case "tiyu":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub4_FirstFragment.newInstance().subscriber);
            break;
            case "keji":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub5_FirstFragment.newInstance().subscriber);
            break;
            case "shishang":
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //转发到Sub1_FirstFragment中的subscriber
                        .subscribe(Sub6_FirstFragment.newInstance().subscriber);
                break;
        }
    }


    //获取单例
    public static ToutiaoRetrofitUtil getInstance(String url, Map<String, Object> params) {
        final ToutiaoRetrofitUtil INSTANCE = new ToutiaoRetrofitUtil(url, params);
        return INSTANCE;
    }
}





