package com.gs.VeterinaryCare.Adapters;

import static com.gs.VeterinaryCare.VeterinaryApplication.*;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;
import com.gs.VeterinaryCare.WebViewActivity.WebViewActivity;

public class AnimalCardAdapter extends FirebaseRecyclerAdapter<AnimalsData,AnimalCardAdapter.CardViewHolder> {

    boolean isFav = false;
    FirebaseDatabase veterinaryCareDB = FirebaseDatabase.getInstance();
    DatabaseReference userNodeRef = veterinaryCareDB.getReference("Users");
    DatabaseReference favNodeRef;

    public AnimalCardAdapter(@NonNull FirebaseRecyclerOptions<AnimalsData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CardViewHolder holder, int position, @NonNull AnimalsData model) {
        holder.animalName.setText(model.getAnimalName());
        Glide.with(holder.animalImage.getContext()).load(model.getImageURL()).into(holder.animalImage);

        if (position == getItemCount() - 1) {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            params.bottomMargin = 140;
            holder.itemView.setLayoutParams(params);
        }

        if (isUserLoggedIn()) {
            favNodeRef = userNodeRef.child(getUser().getUserID()).child("Favourites");
            Query favQuery = favNodeRef;

            favQuery.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    holder.favButton.setImageResource(snapshot.hasChild(model.getAnimalName()) ? R.drawable.outline_favorite_24 : R.drawable.baseline_favorite_border_24);
                    isFav = snapshot.hasChild(model.getAnimalName());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(holder.cardView.getContext(), "Database Error!", Toast.LENGTH_SHORT).show();
                }
            });

            holder.favButton.setOnClickListener(view -> {
                if (!isFav) {
                    favNodeRef.child(model.getAnimalName()).setValue(model);
                    holder.favButton.setImageResource(R.drawable.outline_favorite_24);
                    isFav = true;
                } else {
                    favNodeRef.child(model.getAnimalName()).removeValue();
                    holder.favButton.setImageResource(R.drawable.baseline_favorite_border_24);
                    isFav = false;
                }
            });
        } else {
            holder.favButton.setOnClickListener(view -> Toast.makeText(holder.cardView.getContext(), "Please Login!!", Toast.LENGTH_SHORT).show());
        }

        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.cardView.getContext(), WebViewActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("AnimalName",model.getAnimalName());
            intent.putExtra("PageURL",model.getPageURL());
            holder.cardView.getContext().startActivity(intent);
        });
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new CardViewHolder(cardView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView animalImage, favButton;
        MaterialTextView animalName;
        MaterialCardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage = itemView.findViewById(R.id.animalImageView);
            animalName = itemView.findViewById(R.id.animalNameTextView);
            cardView = itemView.findViewById(R.id.cardViewHolder);
            favButton = itemView.findViewById(R.id.favCardButton);
        }
    }

}
