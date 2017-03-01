package demo.pomelo.pomelonews.app;

import android.app.Application;

import com.youku.player.YoukuPlayerConfig;

/**
 * Created by UnclePomelo on 2017/2/22.
 */

public class MyApplication extends Application {
    //请在这里输入你的应用的clientId，clientSecret
    public static final String CLIENT_ID_WITH_AD = "326f34e2ea60f5c9";
    public static final String CLIENT_SECRET_WITH_AD = "0780d486c45d7057adb7c23da6147481";
    @Override
    public void onCreate() {
        super.onCreate();
        YoukuPlayerConfig.setLog(true);
        /**设置client_id和client_secret*/
        YoukuPlayerConfig.setClientIdAndSecret(CLIENT_ID_WITH_AD,CLIENT_SECRET_WITH_AD);
        /**sdk初始化*/
        YoukuPlayerConfig.onInitial(getApplicationContext(), "528a34396e9040f3");
    }
}
