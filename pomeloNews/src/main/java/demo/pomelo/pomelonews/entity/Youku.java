package demo.pomelo.pomelonews.entity;

import java.util.List;

/**
 * Created by UnclePomelo on 2017/2/17.
 */
public class Youku {

    /**
     * page : 1
     * count : 10
     * total : 500
     * videos : [{"view_count":2100958,"up_count":0,"down_count":0,"id":"XMjUxNDI1NDA1Mg==","title":"七里香之2015","thumbnail":"https://r1.ykimg.com/0541040858A4FE2A6F0C44094E9B90E8","user":{"user_id":11563590,"user_name":"Darkic"},"published":"2017-02-16 09:19:34","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxNDI1NDA1Mg==.html","quality":"高清","seconds":"4:08"},{"view_count":419609,"up_count":179,"down_count":0,"id":"XMjUwOTgwODQ0OA==","title":"papi酱的周一放送\u2014\u2014男默女泪之男默","thumbnail":"https://r1.ykimg.com/0541010158A166F9641DA4177D3ABB7C","user":{"user_id":811143503,"user_name":"papi酱"},"published":"2017-02-13 18:00:12","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUwOTgwODQ0OA==.html","quality":"超清","seconds":"4:32"},{"view_count":334789,"up_count":0,"down_count":0,"id":"XMjUxMDk4MDk0MA==","title":"妹子用辣椒喷雾报复男友 玩得也太大了吧！","thumbnail":"https://r1.ykimg.com/05410408589AAF516F0A41D7070DB1D1","user":{"user_id":383354827,"user_name":"护球像亨利2014"},"published":"2017-02-14 10:11:07","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxMDk4MDk0MA==.html","quality":"超清","seconds":"1:43"},{"view_count":328670,"up_count":34,"down_count":0,"id":"XMjUxMTQwMjY5Ng==","title":"傻缺与天才之间仅有一念之差！极限运动挑战触目惊心","thumbnail":"https://r1.ykimg.com/0541040858A2AB786F0E32542779B15E","user":{"user_id":1045445187,"user_name":"体坛内外"},"published":"2017-02-14 14:54:26","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxMTQwMjY5Ng==.html","quality":"1080P","seconds":"1:37"},{"view_count":247453,"up_count":175,"down_count":1,"id":"XMjUwODMxNDAyOA==","title":"实拍：不顾路人感受 佛山4名男子狂跳ppap","thumbnail":"https://r1.ykimg.com/0541040858A0239E6F0AA025F499ABE3","user":{"user_id":812086962,"user_name":"Lee潔氏"},"published":"2017-02-12 16:36:49","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUwODMxNDAyOA==.html","quality":"1080P","seconds":"3:00"},{"view_count":186397,"up_count":11,"down_count":3,"id":"XMjUxMDU0NTA2OA==","title":"大咖笑料 偷吃萌宠爆笑来袭！原来他们才是偷吃界的鼻祖","thumbnail":"https://r1.ykimg.com/0541010158A1DA42641DA4177DD7E23B","user":{"user_id":129960264,"user_name":"QM工作室"},"published":"2017-02-14 00:14:36","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxMDU0NTA2OA==.html","quality":"1080P","seconds":"2:19"},{"view_count":149261,"up_count":0,"down_count":0,"id":"XMjUwOTc4NDg2OA==","title":"萌宠物语 一只流浪猫的故事 我的心灵安全感是因为你的善良","thumbnail":"https://r1.ykimg.com/0541040858A169B66F0E2687B4159131","user":{"user_id":832069076,"user_name":"奴家人"},"published":"2017-02-13 19:00:08","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUwOTc4NDg2OA==.html","quality":"1080P","seconds":"3:55"},{"view_count":120358,"up_count":0,"down_count":0,"id":"XMjUxNjE0NzA3Mg==","title":"萌宠物语 一只流浪猫的故事 其实不被人伤害是所有猫咪的愿望","thumbnail":"https://r1.ykimg.com/0541040858A66F186F0A929EB1F22F94","user":{"user_id":832069076,"user_name":"奴家人"},"published":"2017-02-17 11:17:36","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxNjE0NzA3Mg==.html","quality":"1080P","seconds":"3:28"},{"view_count":82621,"up_count":0,"down_count":0,"id":"XMjUxMTMyNDIxNg==","title":"爆笑：吉祥物 \u201c三角恋\u201d，两\u201c男牛\u201d争风吃醋当街斗殴~","thumbnail":"https://r1.ykimg.com/0541040858A28A0E6F0A601125236E9C","user":{"user_id":1111263821,"user_name":"kyzy001647"},"published":"2017-02-14 14:04:00","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUxMTMyNDIxNg==.html","quality":"标清","seconds":"1:19"},{"view_count":73810,"up_count":108,"down_count":4,"id":"XMjUwNzE5NzYyNA==","title":"笑死不偿命 笑哭！看妹子如何坑队友","thumbnail":"https://r1.ykimg.com/05410408589F05C86F0C75061B922CF4","user":{"user_id":715614983,"user_name":"半辈子工作室"},"published":"2017-02-11 20:16:32","category":"搞笑","link":"http://v.youku.com/v_show/id_XMjUwNzE5NzYyNA==.html","quality":"1080P","seconds":"3:27"}]
     */

    private int page;
    private int count;
    private int total;
    private List<VideosBean> videos;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public static class VideosBean {
        /**
         * view_count : 2100958
         * up_count : 0
         * down_count : 0
         * id : XMjUxNDI1NDA1Mg==
         * title : 七里香之2015
         * thumbnail : https://r1.ykimg.com/0541040858A4FE2A6F0C44094E9B90E8
         * user : {"user_id":11563590,"user_name":"Darkic"}
         * published : 2017-02-16 09:19:34
         * category : 搞笑
         * link : http://v.youku.com/v_show/id_XMjUxNDI1NDA1Mg==.html
         * quality : 高清
         * seconds : 4:08
         */

        private boolean isPlayed = true;

        private int view_count;
        private String up_count;
        private String down_count;
        private String id;
        private String title;
        private String thumbnail;
        private UserBean user;
        private String published;
        private String category;
        private String link;
        private String quality;
        private String seconds;


        public boolean isPlayed() {
            return isPlayed;
        }

        public void setPlayed(boolean played) {
            isPlayed = played;
        }

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public String getUp_count() {
            return up_count;
        }

        public void setUp_count(String up_count) {
            this.up_count = up_count;
        }

        public String getDown_count() {
            return down_count;
        }

        public void setDown_count(String down_count) {
            this.down_count = down_count;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getSeconds() {
            return seconds;
        }

        public void setSeconds(String seconds) {
            this.seconds = seconds;
        }

        public static class UserBean {
            /**
             * user_id : 11563590
             * user_name : Darkic
             */

            private int user_id;
            private String user_name;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }
        }
    }
}