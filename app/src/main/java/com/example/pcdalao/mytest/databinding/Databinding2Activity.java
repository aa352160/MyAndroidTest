package com.example.pcdalao.mytest.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.example.pcdalao.mytest.R;

public class Databinding2Activity extends AppCompatActivity {

    private com.example.pcdalao.mytest.databinding.ActivityDatabinding2Binding binding;
    private ModleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databinding2);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_databinding2);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setName("this is job change");
            }
        });

        adapter=new ModleAdapter(new Data());
        binding.setAdapter(adapter);
    }

    public class ModleAdapter extends BaseObservable{
        private Data data;
        private String name = "123456";

        public ModleAdapter(Data data){
            this.data=data;
        }

        @Bindable
        public String getName(){
            return data.getJob();
        }

        public int getAge(){
            return data.getAge();
        }

        public String getJob(){
            return data.getJob();
        }

        public void setName(String name){
            data.setJob(name);
//            this.name=name;
            notifyPropertyChanged(BR.name);
        }
    }
}
