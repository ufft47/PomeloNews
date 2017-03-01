package demo.pomelo.pomelonews.view;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.service.MyService;
import demo.pomelo.pomelonews.view.fragment.FistFragment.FirstFragment;
import demo.pomelo.pomelonews.view.fragment.FourthFragment.FourthFragment;
import demo.pomelo.pomelonews.view.fragment.SecondFragment.SecondFragment;
import demo.pomelo.pomelonews.view.fragment.ThirdFragment.ThirdFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    //    Toolbar toolbar;
    public BottomNavigationBar bottomNavigationBar;
    long exitTime = 0;  //按返回键后返回的时间

    public  FragmentManager fragmentManager = null;

    List<Fragment> fragmentList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, MyService.class));
        bindService(new Intent(this, MyService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        },BIND_AUTO_CREATE);
        setContentView(R.layout.activity_main);
        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(SecondFragment.newInstance());
        fragmentList.add(ThirdFragment.newInstance());
        fragmentList.add(FourthFragment.newInstance());
        initView();
    }

    @Override
        protected void onSaveInstanceState(Bundle outState) {
            //注释掉，防止Fragment在Activity销毁的时候保存状态
//        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onResume() {
        super.onResume();
        //注册广播接收者
        registBroadcastReceiver();
    }
    //动态注册广播接收者
    private void registBroadcastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("open.webView");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播接收者
        unregisterReceiver(receiver);
    }


    //广播接收者,开启一个新的Fragment装WebView
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intentToWeb = new Intent(MainActivity.this, WebActivity.class);
            intentToWeb.putExtra("url", intent.getStringExtra("url"));
            intentToWeb.putExtra("title", intent.getStringExtra("title"));
            startActivity(intentToWeb);
        }
    };


    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_activity_main);
        //为底部导航栏添加子项
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "主页"))
                .setActiveColor(R.color.colorBottomNavigationBarSelected)  //设置选中颜色
                .addItem(new BottomNavigationItem(R.drawable.ic_video_white_24dp, "视频")) //设置图标，文字
                .setActiveColor(R.color.colorBottomNavigationBarSelected)
                .addItem(new BottomNavigationItem(R.drawable.ic_discover_white_24dp, "发现"))
                .setActiveColor(R.color.colorBottomNavigationBarSelected)
                .addItem(new BottomNavigationItem(R.drawable.ic_account_circle_white_24dp, "关于"))
                .setActiveColor(R.color.colorBottomNavigationBarSelected)
                .setFirstSelectedPosition(0)  //设置第一次选中的位置
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();//所有的设置需在调用该方法前完成
        bottomNavigationBar.setAnimationDuration(180);
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.framelayout_activity_main, fragmentList.get(0), "fragment0");
        transaction.commit();
    }

    //管理Fragment显示
    private void ManageFragmentShow(int position) {
//        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //判断Fragment是否被添加
        if (!fragmentList.get(position).isAdded()) {
            //没有被添加执行的操作
            if (fragmentList.get(position) != null) {
                transaction
                        .add(R.id.framelayout_activity_main, fragmentList.get(position), "fragment" + position)
                        .show(fragmentList.get(position))
                        .commit();
            }
        } else {
            //被添加了则显示show操作
            transaction
                    .show(fragmentManager.findFragmentByTag("fragment" + position))
                    .commit();
        }
    }

    //底部导航栏回调方法
    @Override
    public void onTabSelected(int position) {
        Log.i("TAG","onTabSelected"+position);
        ManageFragmentShow(position);
    }

    //底部导航栏回调方法
    @Override
    public void onTabUnselected(int position) {
//        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
                .hide(fragmentManager.findFragmentByTag("fragment" + position))
                .commit();
    }

    //底部导航栏回调方法
    @Override
    public void onTabReselected(int position) {

    }


    //Activity的按键监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                exitTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
