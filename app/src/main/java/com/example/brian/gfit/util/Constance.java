package com.example.brian.gfit.util;

import com.example.brian.gfit.model.DetailExercise;

import java.util.ArrayList;
import java.util.List;

public class Constance {
    public static List<DetailExercise> createListDetail() {
        List<DetailExercise> mResult = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DetailExercise detailExercise = new DetailExercise("Title" + i, "Detail" + 0, "co_vai");
            mResult.add(detailExercise);
        }
        return mResult;
    }
}
