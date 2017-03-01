package demo.pomelo.pomelonews.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;

import demo.pomelo.pomelonews.view.MainActivity;

/**
 * Created by UnclePomelo on 2017/2/15.
 */

public class BaseFragment extends Fragment {
    public MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            mainActivity = (MainActivity) activity;
        }
    }
}
