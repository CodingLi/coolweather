package com.example.keen.progressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ProgressDialog pd;


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            pd.dismiss();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.bartest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = ProgressDialog.show(MainActivity.this, "标题", "加载中，请稍后...");
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(true); //设置点击外面可以被取消
                //开启一个新线程,在新线程中执行耗时的方法
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        spandTimeMethod();
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });
    }


    private void spandTimeMethod(){
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
