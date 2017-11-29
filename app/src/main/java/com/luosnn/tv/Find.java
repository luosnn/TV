package com.luosnn.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by 罗什什 on 2017/11/29.
 */

public class Find extends Activity {
    ListView listView;
    ArrayAdapter adapter;
    List list;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bug);
        listView = findViewById(R.id.finlv);
        list = new ArrayList();
        button = findViewById(R.id.flush);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobQuery<Bug> query = new BmobQuery<Bug>();
//查询playerName叫“比目”的数据
                query.addWhereEqualTo("Bug", "String");
//返回50条数据，如果不加上这条语句，默认返回10条数据
                query.setLimit(50);
//执行查询方法
                query.findObjects(new FindListener<Bug>() {
                    @Override
                    public void done(List<Bug> list, BmobException e) {
                        if (e==null){
                            for (Bug bug: list) {
                                //获得playerName的信息
                                bug.getString();
                                list.add(bug);
                            }

                        }else {
                            Toast.makeText(Find.this, "查询失败，检查重试", Toast.LENGTH_SHORT).show();
                        }
                    }



                });
            }
        });

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }
}
