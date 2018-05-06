package com.example.brian.gfit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.gfit.R;
import com.example.brian.gfit.model.GiaoAn;

import java.util.List;

public class GiaoAnAdapter extends RecyclerView.Adapter<GiaoAnAdapter.GiaoAnHolder> {
    private List<GiaoAn> mList;
    private Context mContext;
    private OnGiaoAnClickListener mListener;

    public interface OnGiaoAnClickListener {
        void OnGiaoAnClick(GiaoAn giaoAn);
    }

    public GiaoAnAdapter(List<GiaoAn> mList, Context mContext, OnGiaoAnClickListener mListener) {
        this.mList = mList;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @Override
    public GiaoAnAdapter.GiaoAnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GiaoAnHolder(LayoutInflater.from(mContext).inflate(R.layout.item_giao_and, parent, false));
    }

    @Override
    public void onBindViewHolder(final GiaoAnAdapter.GiaoAnHolder holder, int position) {
        holder.bind(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnGiaoAnClick(mList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class GiaoAnHolder extends RecyclerView.ViewHolder {
        TextView tvShort, tvTitle, tvCount;
        ImageView imvDes;

        GiaoAnHolder(View itemView) {
            super(itemView);
            imvDes = itemView.findViewById(R.id.imv_temp);
            tvCount = itemView.findViewById(R.id.tv_count);
            tvTitle = itemView.findViewById(R.id.tv_name);
            tvShort = itemView.findViewById(R.id.tv_short_title);
        }

        void bind(GiaoAn giaoAn) {
            imvDes.setBackgroundResource(mContext.getResources().getIdentifier(giaoAn.getImage(), "drawable", mContext.getPackageName()));
            tvCount.setText(giaoAn.getCount() > 1 ? giaoAn.getCount() + " exercises" : giaoAn.getCount() + " exercise");
            tvTitle.setText(giaoAn.getName());
            tvShort.setText(giaoAn.getName().substring(0, 1).toUpperCase());
        }
    }
}
