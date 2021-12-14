package com.gs.VeterinaryCare.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

import java.util.ArrayList;


public class AnimalCardAdapter extends FirebaseRecyclerAdapter<AnimalsData,AnimalCardAdapter.CardViewHolder> {

    public AnimalCardAdapter(@NonNull FirebaseRecyclerOptions<AnimalsData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardViewHolder holder, int position, @NonNull AnimalsData model) {
        holder.animalName.setText(model.getAnimalName());
        Glide.with(holder.animalImage.getContext()).load(model.getImageURL()).into(holder.animalImage);
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new CardViewHolder(cardView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        ImageView animalImage;
        TextView animalName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage = (ImageView) itemView.findViewById(R.id.animalImageView);
            animalName = (TextView) itemView.findViewById(R.id.animalNameTextView);
        }
    }

}
