package demo.pomelo.pomelonews.utils.httputils;

import java.util.Map;

import demo.pomelo.pomelonews.entity.News_Toutiao;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by UnclePomelo on 2017/1/18.
 */

public interface INewsToutiaoService {
        @GET("toutiao/index")
        Observable<News_Toutiao> getNews(@QueryMap Map<String,Object> params);
}
