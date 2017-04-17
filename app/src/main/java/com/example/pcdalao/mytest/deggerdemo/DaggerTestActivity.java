package com.example.pcdalao.mytest.deggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;
import com.jakewharton.rxbinding.view.RxView;

import javax.inject.Inject;

import rx.functions.Action1;

public class DaggerTestActivity extends AppCompatActivity {

    @Inject User user;
    @Inject Info info;
    UserComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);
        InfoComponent infoComponent=DaggerInfoComponent.builder().infoModule(new InfoModule("AAAA")).build();
        component=DaggerUserComponent.builder().userModule(new UserModule()).infoComponent(infoComponent).build();
        component.inject(this);

        final TextView textView=(TextView)findViewById(R.id.textView);
        Button button=(Button)findViewById(R.id.button);

        RxView.clicks(button).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                textView.setText("name:"+user.getName()+"\nsex:"+user.getSex()+"\nads:"+user.getAds()+"\ninfo:"+info.getMsg());
            }
        });
    }
}
