package com.example.appt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> dataList;

    public DataAdapter(Context context, List<DataItem> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        TextView cardSubtitle;
        TextView cardKeyword;

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
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_content_card_blue, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        DataItem item = dataList.get(position);
        holder.cardTitle.setText(item.getTitle());
        holder.cardSubtitle.setText(item.getSubtitle());
        holder.cardKeyword.setText(item.getKeyword());
        holder.cardImage.setImageResource(R.drawable.app_logo); // 기본 이미지
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
