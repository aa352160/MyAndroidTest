package com.example.pcdalao.mytest.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

public class DataBaseActivity extends AppCompatActivity {
    public Button button;
    public Button button1;
    public Button button2;
    public Button button3;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        textView=(TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDBManager dbManager=new TaskDBManager(DataBaseActivity.this);
                dbManager.addTask(100,true,false,true);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDBManager dbManager=new TaskDBManager(DataBaseActivity.this);
                TaskDBManager.TaskBean taskBean = dbManager.queryTaskState(100);
                textView.setText("id:"+taskBean.getTaskId()+
                                 ",isCheckIn:"+taskBean.isCheckIn()+
                                 ",isAnswer:"+taskBean.isAnswer()+
                                 ",isCheckOut:"+taskBean.isCheckOut());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDBManager dbManager=new TaskDBManager(DataBaseActivity.this);
                dbManager.cleanTaskState();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDBManager dbManager=new TaskDBManager(DataBaseActivity.this);
                dbManager.changeTaskState(100,2,true);
            }
        });
    }
}
