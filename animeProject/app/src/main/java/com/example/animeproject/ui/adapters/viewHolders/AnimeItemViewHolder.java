package com.example.animeproject.ui.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animeproject.R;


public class AnimeItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView title;
    private TextView description;
    private CardView parentLayout;

    public AnimeItemViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image_anime_item);
        title = itemView.findViewById(R.id.title_anime_item);
        description = itemView.findViewById(R.id.description_anime_item);
        parentLayout = itemView.findViewById(R.id.parent_layout);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public CardView getParentLayout() {
        return parentLayout;
    }

    public void setParentLayout(CardView parentLayout) {
        this.parentLayout = parentLayout;
    }
}
