package com.example.niklaus.networkrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ShopVM mShopVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShopVM = new ShopVM();
    }

    public void btnClick(View view) {
//        observable();
//        flowable();
//        mShopVM.getData(1, 20, new DataCallback<List<VO>>() {
//            @Override
//            public void onNext(List<VO> vos) {
//                outputLog(vos);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i("tag", "onComplete: 执行了");
//            }
//
//            @Override
//            public void onError(String msg, @Nullable Throwable e) {
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//
//        });

//        mShopVM.getDataFlow(1, 20, new DataCallback<List<VO>>() {
//            @Override
//            public void onNext(List<VO> vos) {
//                outputLog(vos);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i("tag", "onComplete: 执行了");
//            }
//
//            @Override
//            public void onSubscribe(Subscription s) {
//                s.request(1);
//            }
//        });
        Observable.just(1, 2, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    private void flowable() {
        ApiClient.getInstance().getApiService()
                .whatFuck(1, 20)
                .subscribeOn(Schedulers.io())
                .map(new Function<DTO, List<VO>>() {
                    @Override
                    public List<VO> apply(@NonNull DTO dto) throws Exception {
                        return dto.data.trasform();
                    }
                })
//                .flatMap(new Function<DTO, Publisher<List<VO>>>() {
//                    @Override
//                    public Publisher<List<VO>> apply(@NonNull DTO dto) throws Exception {
//                        return Flowable.fromArray(dto.data.trasform());
//                    }
//                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VO>>() {
                    @Override
                    public void accept(List<VO> voList) throws Exception {
                        outputLog(voList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    private void observable() {
        ApiClient.getInstance().getApiService()
                .you(1, 20)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<DTO, ObservableSource<List<VO>>>() {
                    @Override
                    public ObservableSource<List<VO>> apply(@NonNull DTO dto) throws Exception {
                        List<VO> voList = dto.data.trasform();
                        return Observable.fromArray(voList);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VO>>() {
                    @Override
                    public void accept(List<VO> vos) throws Exception {
                        Log.i("tag", "accept: " + vos.size());
                        outputLog(vos);
                    }
                });
    }

    public void outputLog(List<VO> datas) {
        for (int i = 0; i < datas.size(); i++) {
            Log.i("tag", "outputLog: " + datas.get(i));
        }
    }

    public void create() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }

    public static void main(String[] args) {
//        Flowable.just(1, 2, 3, 4)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        System.out.println(integer);
//                    }
//                });

        Flowable<Integer> ob1 = Flowable.just(1, 2, 3, 4, 5);
        Flowable<String> ob2 = Flowable.just("A", "B", "C", "D", "E");
        Flowable<String> ob3 = Flowable.just("X", "Y", "Z");
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong < 5;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println(aLong);
                    }
                });
    }
}
