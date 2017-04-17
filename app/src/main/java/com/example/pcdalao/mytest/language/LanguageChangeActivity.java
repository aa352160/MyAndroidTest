package com.example.pcdalao.mytest.language;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.pcdalao.mytest.R;

import java.util.Locale;

public class LanguageChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_change);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics dm = getResources().getDisplayMetrics();
                Configuration config = getResources().getConfiguration();
                config.locale=Locale.SIMPLIFIED_CHINESE;
                getResources().updateConfiguration(config,dm);
            }
        });
    }
}
