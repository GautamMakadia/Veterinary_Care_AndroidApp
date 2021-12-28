package com.gs.VeterinaryCare.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;
import com.gs.VeterinaryCare.WebViewActivity.WebViewActivity;

public class AnimalCardAdapter extends FirebaseRecyclerAdapter<AnimalsData,AnimalCardAdapter.CardViewHolder> {

    public AnimalCardAdapter(@NonNull FirebaseRecyclerOptions<AnimalsData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardViewHolder holder, int position, @NonNull AnimalsData model) {
        holder.animalName.setText(model.getAnimalName());
        Glide.with(holder.animalImage.getContext()).load(model.getImageURL()).into(holder.animalImage);
        holder.animalCardView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.animalCardView.getContext(), WebViewActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("AnimalName",model.getAnimalName());
            intent.putExtra("PageURL",model.getPageURL());
            holder.animalCardView.getContext().startActivity(intent);
        });
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new CardViewHolder(cardView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView animalImage;
        MaterialTextView animalName;
        MaterialCardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage =  itemView.findViewById(R.id.animalImageView);
            animalName =  itemView.findViewById(R.id.animalNameTextView);
            animalCardView = itemView.findViewById(R.id.cardViewHolder);
        }
    }

}
