package com.luosnn.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.select.Elements;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 罗什什 on 2017/11/29.
 */

public class Feed extends Activity implements View.OnClickListener {
    Button button;
    EditText editText;
    Button look;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.feed);
        editText = findViewById(R.id.want);
        button = findViewById(R.id.tto);
        button.setOnClickListener(this);
        look = findViewById(R.id.look);
        look.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tto:
            String s = editText.getText().toString();
            if (s == null) {
                return;
            } else {
                Bug bug = new Bug();
                bug.setString(s);
                bug.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(Feed.this, "提交成功，谢谢合作", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Feed.this, "提交失败，检查重试", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            break;
            case R.id.look:

                startActivity(new Intent(Feed.this,Find.class));
                break;
    }}}

