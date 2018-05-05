package com.example.brian.gfit.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.brian.gfit.R;
import com.example.brian.gfit.fragment.BaitapFragment;
import com.example.brian.gfit.fragment.DinhDuongFragment;
import com.example.brian.gfit.fragment.GiaoanFragment;
import com.example.brian.gfit.fragment.KienThucFragment;
import com.example.brian.gfit.fragment.LichTapFragment;
import com.example.brian.gfit.util.BottomNavigationViewHelper;

public class MainActivity2 extends AppCompatActivity {
    Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bai_tap:
                    fragment = BaitapFragment.createInstance();
                    break;
                case R.id.lich_tap:
                    fragment = LichTapFragment.createInstance();
                    break;
                case R.id.giao_an:
                    fragment = GiaoanFragment.createInstance();
                    break;
                case R.id.dinh_duong:
                    fragment = DinhDuongFragment.createIntance();
                    break;
                case R.id.kien_thuc:
                    fragment = KienThucFragment.createInstance();
                    break;

            }
            item.setChecked(true);
            startFragment(fragment);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.bai_tap);
    }

    protected void startFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frl_layout, fragment);
            ft.commit();
        }
    }
}
