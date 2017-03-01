package demo.pomelo.pomelonews.entity;

/**
 * Created by UnclePomelo on 2017/2/5.
 */

public class Connect {

    private int iconRes;  //图标资源
    private String info;  //电话或email地址
    private String way;   //MOBILE  EMAIL
    private int sendRes;

    public Connect(int iconRes, String info, String way, int msgRes){
        this.iconRes = iconRes;
        this.info = info;
        this.way = way;
        this.sendRes = msgRes;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getInfo() {
        return info;
    }

    public String getWay() {
        return way;
    }

    public int getSendRes() {
        return sendRes;
    }
}
