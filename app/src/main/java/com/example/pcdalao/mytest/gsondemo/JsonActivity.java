package com.example.pcdalao.mytest.gsondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pan jh on 2017/2/7.
 */

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        TextView textView1=(TextView) findViewById(R.id.textView3);
        TextView textView2=(TextView) findViewById(R.id.textView4);
        TextView textView3=(TextView) findViewById(R.id.textView5);

        String json=stringBuilder();
        try {
            JSONObject jsonObject=new JSONObject(json);
            String contentBody=jsonObject.getString("contentBody");
            JSONArray jsonArray=jsonObject.getJSONArray("extra");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String infoTitle = jsonObject1.getString("infoTitle");
                String converPath = jsonObject1.getString("coverPath");
                String infoUrl = jsonObject1.getString("infoUrl");
                if (i==0){
                    textView2.setText(infoTitle+"  "+converPath+"   "+infoUrl);
                }else{
                    textView3.setText(infoTitle+"  "+converPath+"   "+infoUrl);
                }
            }
            Gson gson=new Gson();
            JsonBean jsonBean = gson.fromJson(stringBuilder(), JsonBean.class);
            textView1.setText(contentBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String stringBuilder() {
        return "{\n" +
                "\t\t\t\"contentBody\":\"推荐课程\",\n" +
                "\t\t\t\"extra\":\n" +
                "\t\t\t[\n" +
                "\t\t\t\t{\"infoTitle\":\"标题\",\"coverPath\":\"封面\",\"infoUrl\":\"H5路径\"},\n" +
                "\t\t\t\t{\"infoTitle\":\"11111\",\"coverPath\":\"222222\",\"infoUrl\":\"333333\"}\n" +
                "\t\t\t]\n" +
                "\t\t}";
    }
}
