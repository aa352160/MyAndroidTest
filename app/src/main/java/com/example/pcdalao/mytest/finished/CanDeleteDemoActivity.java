package com.example.pcdalao.mytest.finished;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pcdalao.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class CanDeleteDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_delete_demo);

        List data=new ArrayList();
        data.add(new Object());
        data.add(new Object());
        data.add(new Object());
        final TaskFeedbackRadioView mView=(TaskFeedbackRadioView)findViewById(R.id.task_view);
        mView.setDatas(data);

        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CanDeleteDemoActivity.this,mView.getSelect(),Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mView.getVisibility()==View.GONE){
                    mView.setVisibility(View.VISIBLE);
                }else{
                    mView.setVisibility(View.GONE);
                }
            }
        });
    }
}
