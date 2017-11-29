package com.luosnn.tv;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener ,View.OnClickListener {

    private ListView listview;
    private List<Map<String,String>> list = null;
    Map<String,String> map;
    Button back;
    Button have;
    Button feed;
    int i = 0;
    String tv[] = {"CCTV-1高清","CCTV-2高清","CCTV-3高清","CCTV-4高清","CCTV-5高清","CCTV-5+高清","CCTV-6高清"
            ,"CCTV-7高清","CCTV-8高清","CCTV-9高清","CCTV-10高清","CCTV-12高清","CCTV-14高清","CGTN高清","CHC高清"
            ,"北京卫视高清","北京文艺高清","北京体育高清","北京影视高清","北京新闻高清","北京纪实高清","湖南卫视高清"
            ,"浙江卫视高清","江苏卫视高清","东方卫视高清","安徽卫视高清","黑龙江卫视高清","辽宁卫视高清","深圳卫视高清"
            ,"广东卫视高清","天津卫视高清","湖北卫视高清","山东卫视高清","重庆卫视高清","上海纪实高清","四川卫视高清"
            ,"金鹰纪实高清","福建东南卫视高清","河北卫视高清","江西卫视高清","中国教育电视台1高清","全纪实高清高清" ,"凤凰卫视中文台","凤凰卫视资讯台"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        have = findViewById(R.id.have);
        have.setOnClickListener(this);
        feed = findViewById(R.id.feed);
        feed.setOnClickListener(this);
        i++;

        if(i==1){
            if (!isWifi(this)){
                tixing();
            }else {

            }
        }else {

        }

        list = new ArrayList<Map<String, String>>();
        for (int i = 0;i<tv.length;i++){
            map = new HashMap<>();
            map.put("tv_txt",tv[i]);
            list.add(map);
        }
        String from[] = {"tv_txt"};
        int to[] = {R.id.item_txt};
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item,from,to);
        listview = findViewById(R.id.lv);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this );


    }
    private void delay(int ms){
        try {
            Thread.currentThread();
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }
    private void tixing(){
        delay(1000);
        AlertDialog.Builder ad = new AlertDialog.Builder(Main.this);
        ad.setIcon(R.drawable.logo);
        ad.setTitle("开发者友情提示：");
        ad.setMessage("“ 请使用校园WIFI观看财大Tv ”。");
        ad.show();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
                Intent intent0 = new Intent(Main.this,TV.class);
                intent0.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv1hd");
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(Main.this,TV.class);
                intent1.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv2hd");
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(Main.this,TV.class);
                intent2.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv3hd");
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(Main.this,TV.class);
                intent3.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv4hd");
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(Main.this,TV.class);
                intent4.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv5hd");
                startActivity(intent4);
                break;
                case 5:
                    Intent intent5 = new Intent(Main.this,TV.class);
                    intent5.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv5phd");
                    startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(Main.this,TV.class);
                intent6.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv6hd");
                startActivity(intent6);
                break;
                case 7:
                    Intent intent7 = new Intent(Main.this,TV.class);
                    intent7.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv7hd");
                    startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(Main.this,TV.class);
                intent8.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv8hd");
                startActivity(intent8);
                break;
                case 9:
                    Intent intent9 = new Intent(Main.this,TV.class);
                    intent9.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv9hd");
                    startActivity(intent9);
                break;
            case 10:
                Intent intent10 = new Intent(Main.this,TV.class);
                intent10.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv10hd");
                startActivity(intent10);
                break;
                case 11:
                    Intent intent11 = new Intent(Main.this,TV.class);
                    intent11.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv12hd");
                    startActivity(intent11);
                break;
            case 12:
                Intent intent12 = new Intent(Main.this,TV.class);
                intent12.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cctv14hd");
                startActivity(intent12);
                break;
                case 13:
                    Intent intent13 = new Intent(Main.this,TV.class);
                    intent13.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cgtnhd");
                    startActivity(intent13);
                break;
            case 14:
                Intent intent14 = new Intent(Main.this,TV.class);
                intent14.putExtra("url","http://tv.huel.edu.cn/player.html?channel=chchd");
                startActivity(intent14);
                break;
                case 15:
                    Intent intent15 = new Intent(Main.this,TV.class);
                    intent15.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv1hd");
                    startActivity(intent15);
                break;
            case 16:
                Intent intent16 = new Intent(Main.this,TV.class);
                intent16.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv2hd");
                startActivity(intent16);
                break;
                case 17:
                    Intent intent17 = new Intent(Main.this,TV.class);
                    intent17.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv6hd");
                    startActivity(intent17);
                break;
            case 18:
                Intent intent18 = new Intent(Main.this,TV.class);
                intent18.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv4hd");
                startActivity(intent18);
                break;
                case 19:
                    Intent intent19 = new Intent(Main.this,TV.class);
                    intent19.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv9hd");
                    startActivity(intent19);
                break;
            case 20:
                Intent intent20 = new Intent(Main.this,TV.class);
                intent20.putExtra("url","http://tv.huel.edu.cn/player.html?channel=btv11hd");
                startActivity(intent20);
                break;
                case 21:
                    Intent intent21 = new Intent(Main.this,TV.class);
                    intent21.putExtra("url","http://tv.huel.edu.cn/player.html?channel=hunanhd");
                    startActivity(intent21);
                break;

            case 22:
                Intent intent22 = new Intent(Main.this,TV.class);
                intent22.putExtra("url","http://tv.huel.edu.cn/player.html?channel=zjhd");
                startActivity(intent22);
                break;
                case 23:
                    Intent intent23 = new Intent(Main.this,TV.class);
                    intent23.putExtra("url","http://tv.huel.edu.cn/player.html?channel=jshd");
                    startActivity(intent23);
                break;
            case 24:
                Intent intent24 = new Intent(Main.this,TV.class);
                intent24.putExtra("url","http://tv.huel.edu.cn/player.html?channel=dfhd");
                startActivity(intent24);
                break;
            case 25:
                Intent intent25 = new Intent(Main.this,TV.class);
                intent25.putExtra("url","http://tv.huel.edu.cn/player.html?channel=ahhd");
                startActivity(intent25);
                break;
            case 26:
                Intent intent26 = new Intent(Main.this,TV.class);
                intent26.putExtra("url","http://tv.huel.edu.cn/player.html?channel=hljhd");
                startActivity(intent26);
                break;
            case 27:
                Intent intent27 = new Intent(Main.this,TV.class);
                intent27.putExtra("url","http://tv.huel.edu.cn/player.html?channel=lnhd");
                startActivity(intent27);
                break;
            case 28:
                Intent intent28 = new Intent(Main.this,TV.class);
                intent28.putExtra("url","http://tv.huel.edu.cn/player.html?channel=szhd");
                startActivity(intent28);
                break;
                case 29:
                    Intent intent29 = new Intent(Main.this,TV.class);
                    intent29.putExtra("url","http://tv.huel.edu.cn/player.html?channel=gdhd");
                    startActivity(intent29);
                break;
            case 30:
                Intent intent30 = new Intent(Main.this,TV.class);
                intent30.putExtra("url","http://tv.huel.edu.cn/player.html?channel=tjhd");
                startActivity(intent30);
                break;
                case 31:
                    Intent intent31 = new Intent(Main.this,TV.class);
                    intent31.putExtra("url","http://tv.huel.edu.cn/player.html?channel=hbhd");
                    startActivity(intent31);
                break;
            case 32:
                Intent intent32 = new Intent(Main.this,TV.class);
                intent32.putExtra("url","http://tv.huel.edu.cn/player.html?channel=sdhd");
                startActivity(intent32);
                break;
                case 33:
                    Intent intent33 = new Intent(Main.this,TV.class);
                    intent33.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cqhd");
                    startActivity(intent33);
                break;
            case 34:
                Intent intent34 = new Intent(Main.this,TV.class);
                intent34.putExtra("url","http://tv.huel.edu.cn/player.html?channel=docuchina");
                startActivity(intent34);
                break;
                case 35:
                    Intent intent35 = new Intent(Main.this,TV.class);
                    intent35.putExtra("url","http://tv.huel.edu.cn/player.html?channel=schd");
                    startActivity(intent35);
                break;
            case 36:
                Intent intent36 = new Intent(Main.this,TV.class);
                intent36.putExtra("url","http://tv.huel.edu.cn/player.html?channel=gedocu");
                startActivity(intent36);
                break;
                case 37:
                    Intent intent37 = new Intent(Main.this,TV.class);
                    intent37.putExtra("url","http://tv.huel.edu.cn/player.html?channel=dnhd");
                    startActivity(intent37);
                break;
            case 38:
                Intent intent38 = new Intent(Main.this,TV.class);
                intent38.putExtra("url","http://tv.huel.edu.cn/player.html?channel=hebhd");
                startActivity(intent38);
                break;
                case 39:
                    Intent intent39 = new Intent(Main.this,TV.class);
                    intent39.putExtra("url","http://tv.huel.edu.cn/player.html?channel=jxhd");
                    startActivity(intent39);
                break;
            case 40:
                Intent intent40 = new Intent(Main.this,TV.class);
                intent40.putExtra("url","http://tv.huel.edu.cn/player.html?channel=cetv1hd");
                startActivity(intent40);
                break;
            case 41:
                Intent intent41 = new Intent(Main.this,TV.class);
                intent41.putExtra("url","http://tv.huel.edu.cn/player.html?channel=documentaryhd");
                startActivity(intent41);
                break;
            case 42:
                Intent intent42 = new Intent(Main.this,TV.class);
                intent42.putExtra("url","http://tv.huel.edu.cn/player.html?channel=fhzw");
                startActivity(intent42);
                break;
            case 43:
                Intent intent43 = new Intent(Main.this,TV.class);
                intent43.putExtra("url","http://tv.huel.edu.cn/player.html?channel=fhzx");
                startActivity(intent43);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                System.exit(0);
                break;
            case R.id.have:
                AlertDialog.Builder ad = new AlertDialog.Builder(Main.this);
                ad.setIcon(R.drawable.logo);
                ad.setTitle("开发者友情提示：");
                ad.setMessage("“ 为了财大同学更加方便的观看财大网络电视，开发者对财大网络电视进行适配，如有不足请进行反馈 ”。");
                ad.show();

                break;
            case R.id.feed:
                startActivity(new Intent(Main.this,Feed.class));
                break;
        }
    }
}

