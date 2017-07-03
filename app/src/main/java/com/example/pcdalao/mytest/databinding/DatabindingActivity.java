package com.example.pcdalao.mytest.databinding;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pcdalao.mytest.BR;
import com.example.pcdalao.mytest.R;

public class DatabindingActivity extends AppCompatActivity {

    private com.example.pcdalao.mytest.databinding.ActivityDatabindingBinding binding;
    private ModleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databinding);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_databinding);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setName("this is change");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DatabindingActivity.this,Databinding2Activity.class);
                startActivity(intent);
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
            return data.getName();
        }

        public int getAge(){
            return data.getAge();
        }

        public String getJob(){
            return data.getJob();
        }

        public void setName(String name){
            data.setName(name);
//            this.name=name;
            notifyPropertyChanged(BR.name);
        }
    }
}
