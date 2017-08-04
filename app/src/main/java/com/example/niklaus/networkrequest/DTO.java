package com.example.niklaus.networkrequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklaus on 2017/8/4.
 */

public class DTO {

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

    public DataBean data;

    public static class DataBean implements Transform<List<VO>> {

        public List<TopicList> topic;

        @Override
        public List<VO> trasform() {
            List<VO> datas = new ArrayList<>();
            for (int i = 0; i < topic.size(); i++) {
                datas.add(topic.get(i).trasform());
            }
            return datas;
        }

        public static class TopicList implements Transform<VO> {
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

            @Override
            public VO trasform() {
                VO vo = new VO();
                vo.id = id;
                vo.type = type;
                vo.type_id = type_id;
                vo.title = title;
                vo.pic = pic;
                vo.is_recommend = is_recommend;
                vo.is_show_like = is_show_like;
                vo.islike = islike;
                vo.ispraise = ispraise;
                vo.views = views;
                vo.praises = praises;
                vo.likes = likes;
                vo.comments = comments;
                vo.items = items;
                vo.update_time = update_time;
                vo.dateline = dateline;
                vo.create_time_str = create_time_str;
                vo.datestr = datestr;
                vo.user = user.trasform();
                return vo;
            }

            public static class UserBean implements Transform<VO.UserBean> {
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
                public VO.UserBean trasform() {
                    VO.UserBean userBean = new VO.UserBean();
                    userBean.user_id = user_id;
                    userBean.nickname = nickname;
                    userBean.is_official = is_official;
                    userBean.avatar = avatar;
                    userBean.article_topic_count = article_topic_count;
                    userBean.post_count = post_count;
                    return userBean;
                }
            }
        }
    }
}
