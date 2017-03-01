package demo.pomelo.pomelonews.utils.httputils;

import demo.pomelo.pomelonews.entity.Zhihu;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by UnclePomelo on 2017/2/12.
 */

public interface IZhihuService {
    @GET("api/2/news/latest")
    Observable<Zhihu> getZhihuLatest();

    @GET("api/2/news/before/{date}")
    Observable<Zhihu> getZhihuBefore(@Path("date") String date);

}
