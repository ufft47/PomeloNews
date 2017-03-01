package demo.pomelo.pomelonews.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by UnclePomelo on 2017/2/16.
 */

public class GetScreenParameter {
    private int screenWidth;
    private int screenHeight;
    private Context context;

    public GetScreenParameter(Context context){
        this.context = context;
    }

    public int getScreenWidth(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        return screenWidth;
    }

    public int getScreenHeight(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;

        return screenHeight;
    }

}
