package com.example.appt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private List<ContentItem> contentList;
    private int layoutResId;

    // ✅ 선택된 항목 위치 저장
    private int selectedPosition = RecyclerView.NO_POSITION;

    public ContentAdapter(List<ContentItem> contentList, int layoutResId) {
        this.contentList = contentList;
        this.layoutResId = layoutResId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutResId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContentItem item = contentList.get(position);

        holder.imageView.setImageResource(item.getImageResId());
        holder.titleView.setText(item.getTitle());
        holder.descView.setText(item.getDescription());
        holder.keywordView.setText(item.getKeyword());

        // ✅ 현재 항목이 선택된 항목인지 여부에 따라 배경 처리
        holder.itemView.setActivated(position == selectedPosition);

        holder.itemView.setOnClickListener(v -> {
            int prevSelected = selectedPosition;
            selectedPosition = holder.getAdapterPosition();

            // ✅ 이전 항목 비활성화, 현재 항목 활성화
            notifyItemChanged(prevSelected);
            notifyItemChanged(selectedPosition);
        });
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView descView;
        TextView keywordView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardImage);
            titleView = itemView.findViewById(R.id.cardTitle);
            descView = itemView.findViewById(R.id.cardSubtitle);
            keywordView = itemView.findViewById(R.id.cardKeyword);
        }
    }
}

