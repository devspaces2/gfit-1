package com.example.brian.gfit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brian.gfit.R;
import com.example.brian.gfit.adapter.TrainingAdapter;
import com.example.brian.gfit.model.TrainingSchedule;
import com.example.brian.gfit.util.Constance;

public class LichTapFragment extends Fragment {
    RecyclerView rcvLichTap;
    TrainingAdapter adapter;
    ImageView imvAdd, imvBack;
    TextView tvTitle;

    public static LichTapFragment createInstance() {
        return new LichTapFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_lich_tap, container, false);
        rcvLichTap = view.findViewById(R.id.rcv_lich_tap);
        tvTitle = view.findViewById(R.id.tv_title);
        imvAdd = view.findViewById(R.id.imv_add);
        imvBack = view.findViewById(R.id.imv_back);
        initData();
        return view;
    }

    private void initData() {
        adapter = new TrainingAdapter(Constance.createListTraining(), getContext(), new TrainingAdapter.OnItemTrainingClick() {
            @Override
            public void OnTrainingClick(TrainingSchedule trainingSchedule) {
                //using intent in here
                Toast.makeText(getContext(), "Click training item", Toast.LENGTH_SHORT).show();
            }
        });
        rcvLichTap.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvLichTap.setAdapter(adapter);
        imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Click add", Toast.LENGTH_SHORT).show();
            }
        });
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount()>0){
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
    }
}
