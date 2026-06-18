// ReportAdapter.java
package com.example.appt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private List<ContentItem> reportList;

    public ReportAdapter(List<ContentItem> reportList) {
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_card_blue, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContentItem item = reportList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.titleView.setText(item.getTitle());
        holder.descView.setText(item.getDescription());
        holder.keywordView.setText(item.getKeyword());
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView, descView, keywordView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardImage);
            titleView = itemView.findViewById(R.id.cardTitle);
            descView = itemView.findViewById(R.id.cardSubtitle);
            keywordView = itemView.findViewById(R.id.cardKeyword);
        }
    }
}
