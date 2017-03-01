package demo.pomelo.pomelonews.utils.httputils;

import java.util.concurrent.TimeUnit;

import demo.pomelo.pomelonews.view.fragment.ThirdFragment.DetailFragment;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by UnclePomelo on 2017/2/16.
 */

public class ZhihuDetailRetrofitUtil {
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public ZhihuDetailRetrofitUtil(String baseUrl, String id){
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder()
                    .writeTimeout(8000, TimeUnit.MILLISECONDS)
                    .readTimeout(8000,TimeUnit.MILLISECONDS)
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


        IZhihuDetailService zhihuDetailService = retrofit.create(IZhihuDetailService.class);
        zhihuDetailService.getZhihuDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(DetailFragment.newInstance(id,"ZhihuDetailRetrofitUtil").zhihuDetailAction);
    }

    public static ZhihuDetailRetrofitUtil newInstance(String baseurl, String id){
        final ZhihuDetailRetrofitUtil zhihuDetailRetrofit = new ZhihuDetailRetrofitUtil(baseurl,id);
        return zhihuDetailRetrofit;
    }
}
