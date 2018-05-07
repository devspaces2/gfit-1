package com.example.brian.gfit.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.brian.gfit.OnClickBaiTapListener;
import com.example.brian.gfit.R;
import com.example.brian.gfit.activity.ListDetailActivity;
import com.example.brian.gfit.adapter.BaiTapAdapter;
import com.example.brian.gfit.model.BaiTap;
import com.example.brian.gfit.util.Constance;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaitapFragment extends Fragment implements OnClickBaiTapListener {

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
        BaiTapAdapter adapter = new BaiTapAdapter(getContext(),data,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(BaiTap baiTap) {
        Intent i = new Intent(this.getActivity(),ListDetailActivity.class);
        i.putExtra("KEY_TITLE",baiTap.getTenbaitap());
        startActivity(i);
    }
}
