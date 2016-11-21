package com.shuiyouwen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("TAG", "按钮被点击了");
            }
        };

        Button btnClick = (Button) findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just(runnable).throttleFirst(2, TimeUnit.SECONDS)
                        .subscribe(new Action1<Runnable>() {
                            @Override
                            public void call(Runnable runnable) {
                                runnable.run();
                            }
                        });
            }
        });
    }
}
