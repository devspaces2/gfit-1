package com.example.brian.gfit.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.brian.gfit.R;
import com.example.brian.gfit.adapter.GiaoAnAdapter;
import com.example.brian.gfit.model.GiaoAn;
import com.example.brian.gfit.util.Constance;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GiaoanFragment extends Fragment {
    RecyclerView rcvGiaoAn;
    CircleImageView imvAdd;
    GiaoAnAdapter adapter;

    public static GiaoanFragment createInstance() {
        return new GiaoanFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_giaoan, container, false);
        imvAdd = view.findViewById(R.id.imv_add);
        rcvGiaoAn = view.findViewById(R.id.rcv_giao_an);
        initData();
        return view;
    }

    private void initData() {
        adapter = new GiaoAnAdapter(Constance.createListGiaoAn(), getContext(), new GiaoAnAdapter.OnGiaoAnClickListener() {
            @Override
            public void OnGiaoAnClick(GiaoAn giaoAn) {
                Toast.makeText(getContext(), "Click Giao An Item", Toast.LENGTH_SHORT).show();
            }
        });
        rcvGiaoAn.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvGiaoAn.setAdapter(adapter);
        imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Add giao an coming soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
