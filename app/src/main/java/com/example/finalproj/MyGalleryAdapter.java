package com.example.finalproj;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyGalleryAdapter extends RecyclerView.Adapter<MyGalleryAdapter.ViewHolder> {

    private List<ViewPagerItem> viewPagerItemList;

    public MyGalleryAdapter(List<ViewPagerItem> viewPagerItemList) {
        this.viewPagerItemList = viewPagerItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myviewpager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewPagerItem item = viewPagerItemList.get(position);
        holder.imageView.setImageResource(item.getImageID());
        holder.textViewHeading.setText(item.getHeading());
        holder.textViewDesc.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return viewPagerItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewHeading;
        TextView textViewDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivimage);
            textViewHeading = itemView.findViewById(R.id.tvHeading);
            textViewDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}



