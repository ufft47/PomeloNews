package demo.pomelo.pomelonews.utils.httputils;

import java.util.Map;

import demo.pomelo.pomelonews.entity.Youku;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by UnclePomelo on 2017/2/17.
 */

public interface IYoukuService {
    @GET("quality/video/by/keyword.json")
    Observable<Youku> getYouku(@QueryMap Map<String,Object> params);
}
