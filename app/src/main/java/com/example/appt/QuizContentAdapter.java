package com.example.appt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizContentAdapter extends RecyclerView.Adapter<QuizContentAdapter.ViewHolder> {

    private List<QuizContentItem> contentList;

    public QuizContentAdapter(List<QuizContentItem> contentList) {
        this.contentList = contentList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle, cardSubtitle, cardKeyword;

        public ViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardTitle = itemView.findViewById(R.id.cardTitle);
            cardSubtitle = itemView.findViewById(R.id.cardSubtitle);
            cardKeyword = itemView.findViewById(R.id.cardKeyword);
        }
    }

    @NonNull
    @Override
    public QuizContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_list_yellow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizContentAdapter.ViewHolder holder, int position) {
        QuizContentItem item = contentList.get(position);
        holder.cardTitle.setText(item.getTitle());
        holder.cardSubtitle.setText(item.getSubtitle());
        holder.cardKeyword.setText(item.getKeyword());
        holder.cardImage.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }
}
