package com.example.brian.gfit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.gfit.R;
import com.example.brian.gfit.model.TrainingSchedule;

import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingHolder> {
    private List<TrainingSchedule> mList;
    private Context mContext;
    private OnItemTrainingClick mListener;

    public TrainingAdapter(List<TrainingSchedule> mList, Context mContext, OnItemTrainingClick mListener) {
        this.mList = mList;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    public interface OnItemTrainingClick {
        void OnTrainingClick(TrainingSchedule trainingSchedule);
    }

    @Override
    public TrainingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainingHolder(LayoutInflater.from(mContext).inflate(R.layout.item_training_schedule, parent, false));
    }

    @Override
    public void onBindViewHolder(final TrainingHolder holder, int position) {
        holder.bind(mList.get(position));
        if (mListener == null)
            return;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnTrainingClick(mList.get(holder.getAdapterPosition()));
            }
        });
        if (position==mList.size()-1){
            holder.viewMargin.setVisibility(View.GONE);
        }else
            holder.viewMargin.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class TrainingHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imgTraining;
        View viewMargin;

        TrainingHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_train);
            tvDescription = itemView.findViewById(R.id.tv_description);
            imgTraining = itemView.findViewById(R.id.imv_training);
            viewMargin=itemView.findViewById(R.id.view_margin);
        }

        void bind(TrainingSchedule trainingSchedule) {
            tvName.setText(trainingSchedule.getName());
            tvDescription.setText(trainingSchedule.getDescription());
            imgTraining.setBackgroundResource(mContext.getResources().getIdentifier(trainingSchedule.getImage(), "drawable", mContext.getPackageName()));
        }
    }
}
