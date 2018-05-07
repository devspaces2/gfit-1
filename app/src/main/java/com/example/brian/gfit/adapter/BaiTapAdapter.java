package com.example.brian.gfit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.gfit.OnClickBaiTapListener;
import com.example.brian.gfit.R;
import com.example.brian.gfit.model.BaiTap;

import java.util.List;

public class BaiTapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BaiTap> data;
    private OnClickBaiTapListener listener;
    public BaiTapAdapter(Context context, List<BaiTap> data, OnClickBaiTapListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType){
            case 0: {
                View view = inflater.inflate(R.layout.item_left_baitap,parent,false);
                return new BaiTapHolderLeft(view);
            }
            case 1:{
                View view = inflater.inflate(R.layout.item_right_baitap,parent,false);
                return new BaiTapHolderRight(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()){
            case 0:{
                BaiTapHolderLeft left = (BaiTapHolderLeft) holder;
                left.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(data.get(position));
                    }
                });
                left.onBind(data.get(position));
            } break;
            case 1:{
                BaiTapHolderRight right = (BaiTapHolderRight) holder;
                right.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(data.get(position));
                    }
                });
                right.onBind(data.get(position));
            }break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class BaiTapHolderLeft extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        BaiTapHolderLeft(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.my_textview_left);
            imageView = itemView.findViewById(R.id.my_imageview_left);
        }
        void onBind(BaiTap baiTap){
            imageView.setBackgroundResource(baiTap.getImage());
            textView.setText(baiTap.getTenbaitap());
        }
    }
    class BaiTapHolderRight extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        BaiTapHolderRight(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.my_textview_right);
            imageView = itemView.findViewById(R.id.my_imageview_right);
        }
        void onBind(BaiTap baiTap){
            imageView.setBackgroundResource(baiTap.getImage());
            textView.setText(baiTap.getTenbaitap());
        }
    }
}
