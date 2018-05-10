package com.example.li.wardrobe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    public void init(){
        //欢迎界面初始化，显示版本号，延迟三秒后进入主界面
        TextView tv_version = findViewById(R.id.tv_version);
        try{
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            tv_version.setText("version"+packageInfo.versionName);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            tv_version.setText("version");
        }
        //利用timer让欢迎界面延迟3秒后跳转，timer由一个线程，该线程不断执行task
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                StartActivity.this.finish();
            }
        };
        timer.schedule(timerTask,3000);
    }

}
