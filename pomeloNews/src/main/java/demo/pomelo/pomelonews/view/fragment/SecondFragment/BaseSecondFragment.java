package demo.pomelo.pomelonews.view.fragment.SecondFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;

import demo.pomelo.pomelonews.view.MainActivity;

/**
 * Created by UnclePomelo on 2017/2/17.
 */

public class BaseSecondFragment extends Fragment {

    MainActivity mainActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){  //SDK版本小于23的情况
            mainActivity = (MainActivity) activity;
        }
    }

}
