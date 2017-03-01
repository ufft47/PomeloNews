package demo.pomelo.pomelonews.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UnclePomelo on 2017/2/4.
 */

public class PicLoop implements Serializable {
    //轮播图片地址
    private List<String> picUrls = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<String> urls = new ArrayList<>();
    private List<String > ids = new ArrayList<>();

    public PicLoop(List<String> picUrls,List<String> title,List<String> url,List<String> ids) {
        this.picUrls = picUrls;
        this.titles = title;
        this.urls = url;
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public List<String> getImageList() {
        return picUrls;
    }

    public void setImageList(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getUrls() {
        return urls;
    }
}
