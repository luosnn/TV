package com.luosnn.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import cn.bmob.v3.Bmob;

/**
 * Created by 罗什什 on 2017/11/28.
 */

public class Welcome extends Activity {
    Handler handler = new Handler();
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome);
        Bmob.initialize(this, "e63b1892c55843668313aadabee6ea83");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,Main.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
