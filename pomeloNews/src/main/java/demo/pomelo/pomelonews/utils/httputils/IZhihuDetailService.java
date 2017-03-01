package demo.pomelo.pomelonews.utils.httputils;

import demo.pomelo.pomelonews.entity.ZhihuDetail;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by UnclePomelo on 2017/2/16.
 */

public interface IZhihuDetailService {
    @GET("api/2/news/{id}")
    Observable<ZhihuDetail> getZhihuDetail(@Path("id") String id);
}
