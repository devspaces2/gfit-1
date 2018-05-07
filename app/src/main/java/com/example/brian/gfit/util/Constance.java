package com.example.brian.gfit.util;

import com.example.brian.gfit.R;
import com.example.brian.gfit.model.BaiTap;
import com.example.brian.gfit.model.DetailExercise;
import com.example.brian.gfit.model.GiaoAn;
import com.example.brian.gfit.model.TrainingSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Constance {
    public static List<DetailExercise> createListDetail() {
        List<DetailExercise> mResult = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DetailExercise detailExercise = new DetailExercise("Title" + i, "Detail" + 0, "co_vai");
            mResult.add(detailExercise);
        }
        return mResult;
    }


    public static List<TrainingSchedule> createListTraining() {
        List<TrainingSchedule> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TrainingSchedule trainingSchedule = new TrainingSchedule("co_vai", "name" + i, "description" + i);
            temp.add(trainingSchedule);
        }
        return temp;
    }

    public static List<GiaoAn> createListGiaoAn() {
        List<GiaoAn> temp = new ArrayList<>();
        int aWord = 61;
        for (int i = 0; i < 5; i++) {
            GiaoAn giaoAn = new GiaoAn(Character.toString((char) (97 + i)) + "name", "baitap", new Random().nextInt(10) + 1);
            temp.add(giaoAn);
        }
        return temp;
    }
    public static List<BaiTap> createListBaiTap(){
        List<BaiTap> list = new ArrayList<>();
        list.add(new BaiTap("CHESTS - NGỰC", R.drawable.co_nguc));
        list.add(new BaiTap("SHOULDER - VAI", R.drawable.co_vai));
        list.add(new BaiTap("BACK - LƯNG", R.drawable.co_lung));
        list.add(new BaiTap("ABS - BỤNG", R.drawable.co_bung));
        list.add(new BaiTap("LEGS - CHÂN", R.drawable.co_chan));
        return list;
    }
}
