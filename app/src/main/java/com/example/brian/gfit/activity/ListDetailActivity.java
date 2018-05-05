package com.example.brian.gfit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brian.gfit.R;
import com.example.brian.gfit.adapter.DetailAdapter;
import com.example.brian.gfit.model.DetailExercise;
import com.example.brian.gfit.util.Constance;

public class ListDetailActivity extends AppCompatActivity {
    public static final String KEY_TITLE = "KEY_TITLE";
    RecyclerView rcvExercise;
    DetailAdapter adapter;
    TextView tvTitle;
    ImageView imvBack;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        if (getIntent() != null)
            title = getIntent().getStringExtra(KEY_TITLE);
        if (title == null) {
            finish();
            Toast.makeText(this, "Error when start" + this.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        }
        initData();
    }

    private void initData() {
        tvTitle = findViewById(R.id.tv_title);
        imvBack = findViewById(R.id.imv_back);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvTitle.setText(title);
        rcvExercise = findViewById(R.id.rcv_detail);
        adapter = new DetailAdapter(this, Constance.createListDetail(), new DetailAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(DetailExercise detailExercise) {
                Intent i = new Intent(ListDetailActivity.this, DetailExerciseActivity.class);
                i.putExtra(DetailExerciseActivity.KEY_NAME, detailExercise.getTitle());
                i.putExtra(DetailExerciseActivity.KEY_IMAGE, detailExercise.getImage());
                i.putExtra(DetailExerciseActivity.KEY_DETAIL, detailExercise.getDetail());
                startActivity(i);
            }
        });
        rcvExercise.setLayoutManager(new LinearLayoutManager(this));
        rcvExercise.setAdapter(adapter);
    }
}
