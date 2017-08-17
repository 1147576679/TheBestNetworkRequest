package com.example.niklaus.networkrequest;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Niklaus on 2017/8/4.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("recommend/index?app_id=com.jzyd.BanTang&client_id=bt_app_android&client_secret=ffcda7a1c4ff338e05c42e7972ba7b8d&track_user_id=&oauth_token=&track_deviceid=864394010748616&track_device_info=Nexus+6&channel_name=bantang&app_installtime=1481879391&app_versions=5.8.7&os_versions=4.4.2&screensize=720&v=19")
    Observable<DTO> you(
            @Field("page") int page,
            @Field("pagesize") int pageSize);

    @FormUrlEncoded
    @POST("recommend/index?app_id=com.jzyd.BanTang&client_id=bt_app_android&client_secret=ffcda7a1c4ff338e05c42e7972ba7b8d&track_user_id=&oauth_token=&track_deviceid=864394010748616&track_device_info=Nexus+6&channel_name=bantang&app_installtime=1481879391&app_versions=5.8.7&os_versions=4.4.2&screensize=720&v=19")
    Flowable<DTO> whatFuck(
            @Field("page") int page,
            @Field("pagesize") int pageSize);
}
