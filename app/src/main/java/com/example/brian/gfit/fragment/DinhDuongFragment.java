package com.example.brian.gfit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brian.gfit.R;

public class DinhDuongFragment extends Fragment {
    public static DinhDuongFragment createIntance(){
        return new DinhDuongFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_dinh_duong,container,false);
        return v;
    }
}
