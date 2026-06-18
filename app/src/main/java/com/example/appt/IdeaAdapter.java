package com.example.appt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IdeaAdapter extends RecyclerView.Adapter<IdeaAdapter.ViewHolder> {

    private List<ContentItem> ideaList;

    public IdeaAdapter(List<ContentItem> ideaList) {
        this.ideaList = ideaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_card_yellow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContentItem item = ideaList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.titleView.setText(item.getTitle());
        holder.descView.setText(item.getDescription());
        holder.keywordView.setText(item.getKeyword());
    }

    @Override
    public int getItemCount() {
        return ideaList.size();
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
