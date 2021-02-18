package com.example.animeproject.ui.adapters.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animeproject.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class HistoricAnimeItemViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView image;
    private TextView title;
    private CardView parentLayout;

    public HistoricAnimeItemViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.historic_circle_image);
        title = itemView.findViewById(R.id.historic_title);
        parentLayout = itemView.findViewById(R.id.historic_parent_layout);
    }

    public CircleImageView getImage() {
        return image;
    }

    public void setImage(CircleImageView image) {
        this.image = image;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public CardView getParentLayout() {
        return parentLayout;
    }

    public void setParentLayout(CardView parentLayout) {
        this.parentLayout = parentLayout;
    }
}
