package com.example.brian.gfit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.gfit.R;
import com.example.brian.gfit.model.DetailExercise;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {
    private Context mContext;
    private List<DetailExercise> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(DetailExercise detailExercise);
    }

    public DetailAdapter(Context mContext, List<DetailExercise> mList, OnItemClickListener mListener) {
        this.mContext = mContext;
        this.mList = mList;
        this.mListener = mListener;
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_detail, parent);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailHolder holder, int position) {
        final DetailExercise data = mList.get(position);
        holder.bind(data);
        if (mListener == null)
            return;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnItemClick(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class DetailHolder extends RecyclerView.ViewHolder {
        ImageView imvDetail;
        TextView tvTile;

        DetailHolder(View itemView) {
            super(itemView);
            tvTile = itemView.findViewById(R.id.tv_item_detail);
            imvDetail = itemView.findViewById(R.id.imv_detail);
        }

        void bind(DetailExercise data) {
            tvTile.setText(data.getTitle());
            imvDetail.setBackgroundResource(mContext.getResources().getIdentifier(data.getImage(), "drawable", mContext.getPackageName()));
        }
    }
}
