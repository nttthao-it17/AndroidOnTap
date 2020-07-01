package com.nttt.dangkythanhvien;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {
    private TextView tv_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        tv_done = (TextView) findViewById(R.id.tv_hello);
        setDataByExtras();
    }
    public void setDataByExtras() {
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.TEXT);

        tv_done.setText("Xin chào " + text);
    }
}
