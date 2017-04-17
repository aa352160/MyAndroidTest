package com.example.pcdalao.mytest.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;


/**
 * Created by pan jh on 2017/4/12.
 */

public class UploadByRxjava {
    private List<String> dataList;
    private List<String> resultList;

    public UploadByRxjava(){
        resultList=new ArrayList<>();
        dataList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("String "+i);
        }
    }

    public void startUpload(){
        if (dataList==null){
            return;
        }
        uploadResponse();
    }

    private void uploadResponse() {
        Observable.from(dataList)
                .concatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        //此处省略转型部分
                        return Observable.just(s+" is callback");
                    }
                }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        resultList.add(s);
                    }
                });
    }

    public List<String> getResultList(){
        return resultList;
    }
}
