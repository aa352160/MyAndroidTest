package com.example.pcdalao.mytest.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by pan jh on 2017/1/10.
 */

public class RxjavaTestActivity extends AppCompatActivity {

    Subscription subscription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_test);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);

        //最简单的使用
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("111111111111");
                subscriber.onNext("222222222222");
                subscriber.onNext("333333333333");
                subscriber.onCompleted();
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                textView.setText(s);
            }
        });

        //map和just使用方法
        Observable.just(1, 2, 3)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer + "String";
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                textView2.setText(s);
            }
        });

        List<String> datas = new ArrayList<>();
        datas.add("this is NO.1");
        datas.add("this is NO.2");
        datas.add("this is NO.3");
        datas.add("this is NO.4");
        datas.add("this is NO.5");
        datas.add("this is NO.6");

        //flatMap使用方法
//        Observable.from(datas).flatMap(new Func1<String, Observable<String>>() {
//            @Override
//            public Observable<String> call(String s) {
//                return Observable.from(s.split(""));
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("jh352160",s);
//            }
//        });

        // distinct  去重
        // zipwith  输入两个observable，返回一个observable
//        Observable.from(datas).flatMap(new Func1<String, Observable<String>>() {
//            @Override
//            public Observable<String> call(String s) {
//                return Observable.from(s.split(""));
//            }
//        }).distinct().toSortedList().flatMap(new Func1<List<String>, Observable<String>>() {
//            @Override
//            public Observable<String> call(List<String> strings) {
//                return Observable.from(strings);
//            }
//        }).zipWith(Observable.range(1, 100), new Func2<String, Integer, String>() {
//            @Override
//            public String call(String strings, Integer integer) {
//                return integer.toString() + strings;
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("jh352160", s);
//            }
//        });

        //filter过滤
//        Observable.range(0,10).
//                filter(new Func1<Integer, Boolean>() {
//                    @Override
//                    public Boolean call(Integer integer) {
//                        return integer%2==0;
//                    }
//                }).
//                subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        Log.i("jh352160",integer+"");
//                    }
//                });

        subscription=Observable.interval(2000, java.util.concurrent.TimeUnit.MILLISECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Log.d("jh352160", aLong.toString());
                Log.d("jh352160",Thread.currentThread().getName());
                if (aLong>10){
                    unbind();
                }
            }
        });
    }

    private void unbind(){
        subscription.unsubscribe();
    }
}
