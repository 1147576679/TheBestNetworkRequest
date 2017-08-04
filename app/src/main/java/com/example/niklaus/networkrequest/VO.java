package com.example.niklaus.networkrequest;

/**
 * Created by Niklaus on 2017/8/4.
 */

public class VO {
    /**
     * id : 20790
     * type :
     * type_id :
     * title : 大家都在买「第80期」
     * pic : http://bt.img.17gwx.com/topic/2/7/cFFZbVE/800x440?v=2
     * is_recommend : true
     * is_show_like : true
     * islike : false
     * ispraise : false
     * views : 16114
     * praises : 2222
     * likes : 2172
     * comments : 2
     * items : 7
     * update_time : 1501243200
     * dateline : 1501243200
     * create_time_str : 07月28日
     * datestr : 07月28日
     * pics : []
     * user : {"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}
     * video : {}
     * channel : {}
     */

    public String id;
    public String type;
    public String type_id;
    public String title;
    public String pic;
    public boolean is_recommend;
    public boolean is_show_like;
    public boolean islike;
    public boolean ispraise;
    public String views;
    public String praises;
    public String likes;
    public String comments;
    public String items;
    public String update_time;
    public String dateline;
    public String create_time_str;
    public String datestr;
    public UserBean user;

    public static class UserBean {
        /**
         * user_id : 1
         * nickname : 小糖君
         * avatar : http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4
         * is_official : 1
         * article_topic_count :
         * post_count :
         */

        public String user_id;
        public String nickname;
        public String avatar;
        public int is_official;
        public String article_topic_count;
        public String post_count;

        @Override
        public String toString() {
            return "UserBean{" +
                    "user_id='" + user_id + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", is_official=" + is_official +
                    ", article_topic_count='" + article_topic_count + '\'' +
                    ", post_count='" + post_count + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VO{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", type_id='" + type_id + '\'' +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", is_recommend=" + is_recommend +
                ", is_show_like=" + is_show_like +
                ", islike=" + islike +
                ", ispraise=" + ispraise +
                ", views='" + views + '\'' +
                ", praises='" + praises + '\'' +
                ", likes='" + likes + '\'' +
                ", comments='" + comments + '\'' +
                ", items='" + items + '\'' +
                ", update_time='" + update_time + '\'' +
                ", dateline='" + dateline + '\'' +
                ", create_time_str='" + create_time_str + '\'' +
                ", datestr='" + datestr + '\'' +
                ", user=" + user +
                '}';
    }
}
