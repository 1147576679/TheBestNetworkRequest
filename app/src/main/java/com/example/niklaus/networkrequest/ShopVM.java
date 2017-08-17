package com.example.niklaus.networkrequest;

import com.example.niklaus.networkrequest.rx2vm.DataCallback;
import com.example.niklaus.networkrequest.rx2vm.Rx2Observer;
import com.example.niklaus.networkrequest.rx2vm.Rx2StreamHelper;
import com.example.niklaus.networkrequest.rx2vm.Rx2Subcriber;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Niklaus on 2017/8/8.
 */

public class ShopVM {
    public void getData(int page, int pageSize, DataCallback<List<VO>> callback){
        ApiClient.getInstance().getApiService()
                .you(page,pageSize)
                .compose(Rx2StreamHelper.<DTO>ob_io_main())
                .flatMap(new Function<DTO, ObservableSource<List<VO>>>() {
                    @Override
                    public ObservableSource<List<VO>> apply(@NonNull DTO dto) throws Exception {
                        return Observable.just(dto.data.trasform());
                    }
                })
                .subscribe(new Rx2Observer<>(callback));
    }

    public void getDataFlow(int page, int pageSize, DataCallback<List<VO>> callback){
        ApiClient.getInstance().getApiService()
        .whatFuck(page,pageSize)
        .compose(Rx2StreamHelper.<DTO>flow_io_main())
        .flatMap(new Function<DTO, Publisher<List<VO>>>() {
            @Override
            public Publisher<List<VO>> apply(@NonNull DTO dto) throws Exception {
                return Flowable.just(dto.data.trasform());
            }
        })
        .subscribe(new Rx2Subcriber<>(callback));
    }
}
