package demo.pomelo.pomelonews.entity;

import java.util.List;

/**
 * Created by UnclePomelo on 2017/2/12.
 */
public class Zhihu {

    //本地字段，用户recyclerview保存状态
    public boolean isSelected = false;

    /**
     * date : 20170212
     * news : [{"title":"《罪夜之奔》讲的故事很强，塑造的人物更强","url":"http://news-at.zhihu.com/api/2/news/9214033","image":"http://pic3.zhimg.com/37bbf3fa7af3eca79b9472738fdc23e6.jpg","share_url":"http://daily.zhihu.com/story/9214033","thumbnail":"http://pic1.zhimg.com/d0db25e2d5fe4088cc3bd07abea43e4c.jpg","ga_prefix":"021221","id":9214033},{"title":"「制作」和「製作」，在日本影视里是不同两件事","url":"http://news-at.zhihu.com/api/2/news/9213763","image":"http://pic3.zhimg.com/17e8481783f3584f729f3ebcaafde64e.jpg","share_url":"http://daily.zhihu.com/story/9213763","thumbnail":"http://pic3.zhimg.com/a8ab9c039de8337e49fa845341cdd072.jpg","ga_prefix":"021220","id":9213763},{"title":"在「习惯性流产」带来的恐惧面前，我们更要担心过度医疗","url":"http://news-at.zhihu.com/api/2/news/9208538","image":"http://pic3.zhimg.com/fd8e71a5f63c90136c4553ba8d1f1dfe.jpg","share_url":"http://daily.zhihu.com/story/9208538","thumbnail":"http://pic1.zhimg.com/ff8d2630f0c9c24d923913b5f9e6f368.jpg","ga_prefix":"021219","id":9208538},{"title":"学了这些知识，品红酒时不会露怯","url":"http://news-at.zhihu.com/api/2/news/9215477","image":"http://pic4.zhimg.com/a8ee39d95854dbff6133807eed5e4297.jpg","share_url":"http://daily.zhihu.com/story/9215477","thumbnail":"http://pic4.zhimg.com/7a9e1843a7cd78df19f005381a3fc67b.jpg","ga_prefix":"021218","id":9215477},{"title":"要考人工智能自学能力的这道题，人也给不出统一的答案","url":"http://news-at.zhihu.com/api/2/news/9217118","image":"http://pic4.zhimg.com/6f92bcb5b0012cc7db09a812a104f6f3.jpg","share_url":"http://daily.zhihu.com/story/9217118","thumbnail":"http://pic4.zhimg.com/6d7221f434c95baeca8616eaf00c32c7.jpg","ga_prefix":"021217","id":9217118},{"title":"在精神病院上班是怎样的体验？","url":"http://news-at.zhihu.com/api/2/news/9201268","image":"http://pic4.zhimg.com/7134e867add31b1e6735fa91a7a08a93.jpg","share_url":"http://daily.zhihu.com/story/9201268","thumbnail":"http://pic1.zhimg.com/75177bebae1a940cb46990247d7b5858.jpg","ga_prefix":"021216","id":9201268},{"title":"冷不到一定程度，还真不好意思称自己为「寒潮」","url":"http://news-at.zhihu.com/api/2/news/9216589","image":"http://pic4.zhimg.com/13b67094e310c5a1fd624ef8e04ffa87.jpg","share_url":"http://daily.zhihu.com/story/9216589","thumbnail":"http://pic4.zhimg.com/c9d787544287e68fe54e1a7603699983.jpg","ga_prefix":"021215","id":9216589},{"title":"宇宙「大爆炸」的时候，其实只产生了最轻的几种元素","url":"http://news-at.zhihu.com/api/2/news/9216684","image":"http://pic1.zhimg.com/c9dcb6a27ad72686c6f8fa58a04c3fd0.jpg","share_url":"http://daily.zhihu.com/story/9216684","thumbnail":"http://pic1.zhimg.com/8ed9eecfaab427bb3cbac74ac6400070.jpg","ga_prefix":"021214","id":9216684},{"title":"4 个简单动作，缓解膝关节疼痛","url":"http://news-at.zhihu.com/api/2/news/9215512","image":"http://pic4.zhimg.com/8c4c1a4d3f584e9c292d1f3b06546af7.jpg","share_url":"http://daily.zhihu.com/story/9215512","thumbnail":"http://pic3.zhimg.com/f389c60d29c484f7b40f1ff6a1fb2002.jpg","ga_prefix":"021213","id":9215512},{"title":"大误 · 找对象也分阶段","url":"http://news-at.zhihu.com/api/2/news/9216143","image":"http://pic3.zhimg.com/9e0be7bc3444c5aa0706ef2ce2ae4fe6.jpg","share_url":"http://daily.zhihu.com/story/9216143","thumbnail":"http://pic4.zhimg.com/2ad2ae3400ebfc485cbd15a0b8d2c4b7.jpg","ga_prefix":"021212","id":9216143},{"title":"为什么火电在今天的中国依然能够占据一半多的发电量？","url":"http://news-at.zhihu.com/api/2/news/9215505","image":"http://pic4.zhimg.com/208f736dc9753a7ba185dacd75e7fbbf.jpg","share_url":"http://daily.zhihu.com/story/9215505","thumbnail":"http://pic3.zhimg.com/6edc2cb52ace82e2d02eb5933aab23d2.jpg","ga_prefix":"021211","id":9215505},{"title":"顺藤摸瓜，从论文的参考文献列表里打开新世界","url":"http://news-at.zhihu.com/api/2/news/9212710","image":"http://pic2.zhimg.com/9fb6d0b53ccada0fda9df190cdc69e81.jpg","share_url":"http://daily.zhihu.com/story/9212710","thumbnail":"http://pic4.zhimg.com/a5ef77e08c7d8e25b12e681faad1af73.jpg","ga_prefix":"021210","id":9212710},{"title":"戴上面具，忘记身份，来一场穿越回 18 世纪的盛大狂欢","url":"http://news-at.zhihu.com/api/2/news/9215487","image":"http://pic3.zhimg.com/84b3ea924bfb08d617c138a39b43a986.jpg","share_url":"http://daily.zhihu.com/story/9215487","thumbnail":"http://pic4.zhimg.com/ef93ef54676cd818fda478fde80dc0e3.jpg","ga_prefix":"021209","id":9215487},{"title":"一张街拍人像的细致后期，我们来逐步拆解","url":"http://news-at.zhihu.com/api/2/news/9198768","image":"http://pic2.zhimg.com/15c1a42ff333f3e9264e6c45be0c6a95.jpg","share_url":"http://daily.zhihu.com/story/9198768","thumbnail":"http://pic4.zhimg.com/1f3f42091bb62ad54acd097c10fc57af.jpg","ga_prefix":"021208","id":9198768},{"title":"好好睡觉的益处比想象中更多，比如不再变胖","url":"http://news-at.zhihu.com/api/2/news/9198590","image":"http://pic1.zhimg.com/e475c9be7836111a07db912c4e4a6388.jpg","share_url":"http://daily.zhihu.com/story/9198590","thumbnail":"http://pic2.zhimg.com/2f3808c8c9460d6d54b0f76adeec6761.jpg","ga_prefix":"021207","id":9198590},{"title":"学会优雅实用的 Markdown 写作，从这篇文章开始吧","url":"http://news-at.zhihu.com/api/2/news/9215495","image":"http://pic2.zhimg.com/ac6bcce6341607ec3168bba3604e4de9.jpg","share_url":"http://daily.zhihu.com/story/9215495","thumbnail":"http://pic4.zhimg.com/fa07f8a96756f913c106aab35005b17f.jpg","ga_prefix":"021207","id":9215495},{"title":"多少杯长岛冰茶，才可以换你半晚安睡？","url":"http://news-at.zhihu.com/api/2/news/9207261","image":"http://pic1.zhimg.com/2abd84eecbd8a72fb66214b5700ef75c.jpg","share_url":"http://daily.zhihu.com/story/9207261","thumbnail":"http://pic1.zhimg.com/05fa5f4c27757693d78fcd1bd4fc596c.jpg","ga_prefix":"021207","id":9207261},{"title":"瞎扯 · 如何正确地吐槽","url":"http://news-at.zhihu.com/api/2/news/9207228","image":"http://pic4.zhimg.com/201fff8544f44e250b043a8c080a358f.jpg","share_url":"http://daily.zhihu.com/story/9207228","thumbnail":"http://pic3.zhimg.com/7ae0e40aafdc500bc806fc4422f160ee.jpg","ga_prefix":"021206","id":9207228}]
     * is_today : true
     * top_stories : [{"image_source":"《梦旅人》","title":"在精神病院上班是怎样的体验？","url":"http://news-at.zhihu.com/api/2/news/9201268","image":"http://pic4.zhimg.com/7134e867add31b1e6735fa91a7a08a93.jpg","share_url":"http://daily.zhihu.com/story/9201268","ga_prefix":"021216","id":9201268},{"image_source":"《志明与春娇》","title":"多少杯长岛冰茶，才可以换你半晚安睡？","url":"http://news-at.zhihu.com/api/2/news/9207261","image":"http://pic1.zhimg.com/2abd84eecbd8a72fb66214b5700ef75c.jpg","share_url":"http://daily.zhihu.com/story/9207261","ga_prefix":"021207","id":9207261},{"image_source":"Yestone.com 版权图片库","title":"学会优雅实用的 Markdown 写作，从这篇文章开始吧","url":"http://news-at.zhihu.com/api/2/news/9215495","image":"http://pic2.zhimg.com/ac6bcce6341607ec3168bba3604e4de9.jpg","share_url":"http://daily.zhihu.com/story/9215495","ga_prefix":"021207","id":9215495},{"image_source":"《星球大战 3：绝地归来》","title":"30 年前的山寨玩具，现在成了收藏家疯狂追捧的宝物","url":"http://news-at.zhihu.com/api/2/news/9213254","image":"http://pic4.zhimg.com/f80e9e067e4ff96424408103500d3e5f.jpg","share_url":"http://daily.zhihu.com/story/9213254","ga_prefix":"021116","id":9213254},{"image_source":"Yestone.com 版权图片库","title":"代孕的可行性，我们从这三个层面来聊聊","url":"http://news-at.zhihu.com/api/2/news/9211663","image":"http://pic3.zhimg.com/b523514eaaa726492b9df3b604db2486.jpg","share_url":"http://daily.zhihu.com/story/9211663","ga_prefix":"021108","id":9211663}]
     * display_date : 2017.2.12 星期日
     */

    private String date;
    private boolean is_today;
    private String display_date;
    private List<NewsBean> news;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isIs_today() {
        return is_today;
    }

    public void setIs_today(boolean is_today) {
        this.is_today = is_today;
    }

    public String getDisplay_date() {
        return display_date;
    }

    public void setDisplay_date(String display_date) {
        this.display_date = display_date;
    }

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class NewsBean {
        /**
         * title : 《罪夜之奔》讲的故事很强，塑造的人物更强
         * url : http://news-at.zhihu.com/api/2/news/9214033
         * image : http://pic3.zhimg.com/37bbf3fa7af3eca79b9472738fdc23e6.jpg
         * share_url : http://daily.zhihu.com/story/9214033
         * thumbnail : http://pic1.zhimg.com/d0db25e2d5fe4088cc3bd07abea43e4c.jpg
         * ga_prefix : 021221
         * id : 9214033
         */

        private String title;
        private String url;
        private String image;
        private String share_url;
        private String thumbnail;
        private String ga_prefix;
        private String id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class TopStoriesBean {
        /**
         * image_source : 《梦旅人》
         * title : 在精神病院上班是怎样的体验？
         * url : http://news-at.zhihu.com/api/2/news/9201268
         * image : http://pic4.zhimg.com/7134e867add31b1e6735fa91a7a08a93.jpg
         * share_url : http://daily.zhihu.com/story/9201268
         * ga_prefix : 021216
         * id : 9201268
         */

        private String image_source;
        private String title;
        private String url;
        private String image;
        private String share_url;
        private String ga_prefix;
        private String id;

        public String getImage_source() {
            return image_source;
        }

        public void setImage_source(String image_source) {
            this.image_source = image_source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}