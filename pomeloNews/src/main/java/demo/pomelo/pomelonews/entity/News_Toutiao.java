package demo.pomelo.pomelonews.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.drakeet.multitype.Item;

public class News_Toutiao{

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private ResultBean result;
    @SerializedName("error_code")
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Item {
            /**
             * uniquekey : 39f2a519e8bced1af25ca4e2289367c1
             * title : 大学里面“摆摊”的学姐们，出售的东西五花八门
             * date : 2017-01-19 08:44
             * category : 头条
             * author_name : 图看世界
             * url : http://mini.eastday.com/mobile/170119084415518.html
             * thumbnail_pic_s : http://06.imgmini.eastday.com/mobile/20170119/20170119_4f533036c412e4ab3223f8f184b2ab07_cover_mwpm_03200403.png
             * thumbnail_pic_s02 : http://06.imgmini.eastday.com/mobile/20170119/20170119_7253acfff926dd64336a1b3b2739c0dc_cover_mwpm_03200403.png
             * thumbnail_pic_s03 : http://06.imgmini.eastday.com/mobile/20170119/20170119_1f7df82d44bccafa183a248f60a9eb13_cover_mwpm_03200403.png
             */
            @SerializedName("uniquekey")
            private String uniquekey;
            @SerializedName("title")
            private String title;
            @SerializedName("date")
            private String date;
            @SerializedName("category")
            private String category;
            @SerializedName("author_name")
            private String author_name;
            @SerializedName("url")
            private String url;
            @SerializedName("thumbnail_pic_s")
            private String thumbnail_pic_s;
            @SerializedName("thumbnail_pic_s02")
            private String thumbnail_pic_s02;
            @SerializedName("thumbnail_pic_s03")
            private String thumbnail_pic_s03;

//            protected DataBean(Parcel in) {
//                uniquekey = in.readString();
//                title = in.readString();
//                date = in.readString();
//                category = in.readString();
//                author_name = in.readString();
//                url = in.readString();
//                thumbnail_pic_s = in.readString();
//                thumbnail_pic_s02 = in.readString();
//                thumbnail_pic_s03 = in.readString();
//            }


            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

        }
    }
}