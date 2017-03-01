package demo.pomelo.pomelonews.utils.httputils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import demo.pomelo.pomelonews.view.fragment.SecondFragment.SecondFragment;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by UnclePomelo on 2017/2/17.
 */

public class YoukuRetrofitUtil {

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public YoukuRetrofitUtil(String baseUrl,Map<String,Object> params){
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(8000, TimeUnit.MILLISECONDS)
                    .writeTimeout(8000,TimeUnit.MILLISECONDS)
                    .connectTimeout(8000,TimeUnit.MILLISECONDS)
                    .build();
        }

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        IYoukuService youkuService = retrofit.create(IYoukuService.class);
        youkuService.getYouku(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(SecondFragment.newInstance().youkuAction);
    }

    public static YoukuRetrofitUtil newInstance(String baseUrl,Map<String,Object> params){
        final YoukuRetrofitUtil youkuRetrofitUtil = new YoukuRetrofitUtil(baseUrl,params);
        return youkuRetrofitUtil;
    }
}
