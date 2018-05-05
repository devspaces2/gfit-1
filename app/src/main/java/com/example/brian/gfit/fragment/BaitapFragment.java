package com.example.brian.gfit.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brian.gfit.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaitapFragment extends Fragment {

    public static BaitapFragment createInstance(){
        return new BaitapFragment();
    }
    private SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_baitap, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView = (SearchView) getActivity().findViewById(R.id.baitap_search_view);
    }
}
