package com.example.admin.phanthingoc_kiemtra;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by admin on 6/29/2017.
 */

public class MainActivityPlay extends Activity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private ArrayList<Animal> animals;
    private AnimalAdapter animalAdapter;
    private ImageView im_home;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initializeComponents();
        im_home=findViewById(R.id.img_home);
        im_home.setOnClickListener(this);

    }

    private void initializeComponents() {
        recyclerView=findViewById(R.id.rclView);
        animals=new ArrayList<>();
        animals.add(new Animal(R.drawable.camel, "Left", "camel"));
        animals.add(new Animal(R.drawable.crocodile, "Right","crocodile"));
        animals.add(new Animal(R.drawable.ferret, "Left", "ferret"));
        animals.add(new Animal(R.drawable.monkey, "Right", "monkey"));
        animals.add(new Animal(R.drawable.parrot, "Left", "parrot"));
        animals.add(new Animal(R.drawable.scorpion, "Right", "scorpion"));
        animals.add(new Animal(R.drawable.snake, "Left", "snake"));
        animals.add(new Animal(R.drawable.tiger, "Right", "tiger"));
        animalAdapter=new AnimalAdapter(this, animals);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_home:
                Intent intent=new Intent(MainActivityPlay.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
