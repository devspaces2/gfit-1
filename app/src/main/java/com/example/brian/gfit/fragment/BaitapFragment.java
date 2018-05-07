package com.example.brian.gfit.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brian.gfit.R;
import com.example.brian.gfit.adapter.BaiTapAdapter;
import com.example.brian.gfit.model.BaiTap;
import com.example.brian.gfit.util.Constance;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaitapFragment extends Fragment {

    public static BaitapFragment createInstance(){
        return new BaitapFragment();
    }
    private SearchView searchView;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baitap, container, false);;
        searchView = view.findViewById(R.id.baitap_search_view);
        recyclerView = view.findViewById(R.id.my_main_recycler_view);
        List<BaiTap> data = Constance.createListBaiTap();
        BaiTapAdapter adapter = new BaiTapAdapter(getContext(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
