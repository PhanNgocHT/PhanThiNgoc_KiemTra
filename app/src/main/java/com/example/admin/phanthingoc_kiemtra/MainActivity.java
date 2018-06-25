package com.example.admin.phanthingoc_kiemtra;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initView();
    }

    private void initView() {
        btnImage= (ImageView) findViewById(R.id.btnImage);
        btnImage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnImage:
                Intent intent=new Intent(MainActivity.this, MainActivityPlay.class);
                startActivity(intent);
                break;

        }
    }

}
