package com.example.brian.gfit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.gfit.R;

public class DetailExerciseActivity extends AppCompatActivity {
    public static final String KEY_NAME = "KEY_NAME", KEY_DETAIL = "KEY_DETAIL", KEY_IMAGE = "KEY_IMAGE";

    String name, detail, imageName;
    ImageView imvDetail, imvBack;
    TextView tvDetail, tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_exercise);
        if (getIntent() != null) {
            name = getIntent().getStringExtra(KEY_NAME);
            detail = getIntent().getStringExtra(KEY_DETAIL);
            imageName = getIntent().getStringExtra(KEY_IMAGE);
        }
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        tvTitle.setText(name);
        tvDetail.setText(detail);
        imvDetail.setBackgroundResource(getResources().getIdentifier(imageName,"drawable",getPackageName()));
    }

    private void initView() {
        imvBack = findViewById(R.id.imv_back);
        imvDetail = findViewById(R.id.imv_detail);
        tvDetail = findViewById(R.id.tv_detail);
        tvTitle = findViewById(R.id.tv_title);
    }
}
