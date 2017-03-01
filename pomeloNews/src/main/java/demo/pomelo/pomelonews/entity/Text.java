package demo.pomelo.pomelonews.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UnclePomelo on 2017/2/5.
 */

public class Text {

    List<Zhihu> zhihus = new ArrayList<>();
    String text;

    public Text(String text){
        this.text = text;
    }

    public void addZhihus(Zhihu zhihu){
        zhihus.add(zhihu);
    }

    public List<Zhihu> getZhihus() {
        return zhihus;
    }

    public String getText() {
        return text;
    }
}
