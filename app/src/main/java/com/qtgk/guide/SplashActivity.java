package com.qtgk.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends Activity {

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this).load("http://b.hiphotos.baidu.com/zhidao/pic/item/0b46f21fbe096b63bf4092bc08338744eaf8ac85.jpg").error(R.mipmap.splash).centerCrop().into(imageView);
        mSharedPreferences = getSharedPreferences("guide", Context.MODE_PRIVATE);
        final boolean isFistLauncher = mSharedPreferences.getBoolean("launcher", true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFistLauncher) {
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class).
                            setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class).
                            setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            }
        }, 1000 * 3);
    }

}
