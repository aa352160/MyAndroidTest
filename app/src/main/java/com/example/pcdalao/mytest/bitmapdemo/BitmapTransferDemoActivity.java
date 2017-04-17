package com.example.pcdalao.mytest.bitmapdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pcdalao.mytest.R;

import java.io.ByteArrayOutputStream;

public class BitmapTransferDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_transfer_demo);

        final ImageView imageView=(ImageView)findViewById(R.id.image);
//        String bitmapString = getIntent().getStringExtra("bitmap");
//        Bitmap bitmapFromString = getBitmapFromString(bitmapString);
//        imageView.setImageBitmap(bitmapFromString);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Drawable drawable=imageView.getDrawable();
                BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                intent.putExtra("bitmap",getStringFromBitmap(bitmap));
                setResult(1,intent);
                finish();
            }
        });
    }

    private Bitmap getBitmapFromString(String jsonString) {
        byte[] decodedString = Base64.decode(jsonString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    private String getStringFromBitmap(Bitmap bitmapPicture) {
 /*
 * This functions converts Bitmap picture to a string which can be
 * JSONified.
 * */
        final int COMPRESSION_QUALITY = 100;
        String encodedImage;
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
                byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encodedImage;
    }
}
