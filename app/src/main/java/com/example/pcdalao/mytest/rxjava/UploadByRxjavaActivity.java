package com.example.pcdalao.mytest.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

import java.util.List;

public class UploadByRxjavaActivity extends AppCompatActivity {
    UploadByRxjava uploadByRxjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_by_rxjava);

        Button button=(Button)findViewById(R.id.button);
        final TextView textView=(TextView)findViewById(R.id.textView);

        startUpload();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> resultList = uploadByRxjava.getResultList();
                String s="";
                for (String s1 : resultList) {
                    s+=s1;
                }
                textView.setText(s);
            }
        });
    }

    private void startUpload() {
        uploadByRxjava=new UploadByRxjava();
        uploadByRxjava.startUpload();
    }
}
