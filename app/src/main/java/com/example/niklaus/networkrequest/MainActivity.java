package com.example.niklaus.networkrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view){
//        ApiClient.getInstance().getApiService().you(1,20)
//                .subscribeOn(Schedulers.io())
//                .map(new Function<String, List<VO>>() {
//                    @Override
//                    public List<VO> apply(@NonNull String s) throws Exception {
//                        Log.i("tag", "apply: "+s);
//                        JSONArray jsonArray = new JSONObject(s).getJSONObject("data").getJSONArray("topic");
//                        TypeToken<List<VO>> type = new TypeToken<List<VO>>(){};
//                        return new Gson().fromJson(jsonArray.toString(),type.getType());
//                    }
//                })
////                .map(new Function<DTO, List<VO>>() {
////                    @Override
////                    public List<VO> apply(@NonNull DTO dto) throws Exception {
////                        return dto.trasform();
////                    }
////                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<VO>>() {
//                    @Override
//                    public void accept(List<VO> vos) throws Exception {
//                        outputLog(vos);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        throwable.printStackTrace();
//                    }
//                });
        ApiClient.getInstance().getApiService()
                .whatFuck(1,20)
                .subscribeOn(Schedulers.io())
                .map(new Function<DTO, List<VO>>() {
                    @Override
                    public List<VO> apply(@NonNull DTO dto) throws Exception {
                        return dto.data.trasform();
                    }
                })
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

    public void outputLog(List<VO> datas){
        for (int i = 0; i < datas.size(); i++) {
            Log.i("tag", "outputLog: "+datas.get(i));
        }
    }
}
