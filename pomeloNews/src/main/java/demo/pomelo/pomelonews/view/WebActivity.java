package demo.pomelo.pomelonews.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.view.fragment.FistFragment.WebViewFragment;


/**
 * Created by UnclePomelo on 2017/1/29.
 */

public class WebActivity extends AppCompatActivity {

    Toolbar toolbar = null;
    ImageView imageShare = null;
    FragmentManager manager = null;
    String urlStr = null;
    String titleStr = null;

    OnKeyBackClickListener onKeyBackClickListener = null;  //返回键点击监听

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web);
        initView();
        Intent intent = this.getIntent();
        String url = intent.getStringExtra("url");
        this.urlStr = url; //给url赋值
        this.titleStr = intent.getStringExtra("title");
        setDefaultFragment(url);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    private void initView() {
        imageShare = (ImageView) findViewById(R.id.iv_icon_toolbar_activity_web);
        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareUrl();
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_web);
        toolbar.setTitleTextColor(Color.rgb(103, 103, 103)); //深灰色
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //需要写在setSupportActionBar之后
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onKeyBackClickListener != null) {
                    //返回前一个页面
                    onKeyBackClickListener.onKeyBackClick();
                }
            }
        });


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }


    //系统默认的分享页面
    public void shareUrl() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, titleStr + "\n" + urlStr); //第一个参数，将信息传给打开的应用
        shareIntent.setType("text/plain");

        //设置分享列表的标题，并且每次都显示分享列表
        startActivity(Intent.createChooser(shareIntent, "分享到"));
    }


    /**
     * 设置默认的
     */
    private void setDefaultFragment(String url) {
            manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.framelayout_activity_web, WebViewFragment.newInstance(url), "webFragment")
                    .commit();
    }

    //返回键的回调接口
    public interface OnKeyBackClickListener {
        void onKeyBackClick();
    }

    //暴露给外部调用的方法
    public void setOnKeyBackClickListener(OnKeyBackClickListener onKeyBackClickListener) {
        this.onKeyBackClickListener = onKeyBackClickListener;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (onKeyBackClickListener != null) {
                onKeyBackClickListener.onKeyBackClick();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
