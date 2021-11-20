package com.gs.VeterinaryCare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.RecyclerView;


import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;
import com.gs.VeterinaryCare.WebViewActivity.WebViewActivity;


import java.util.ArrayList;

public class AnimalCardAdapter extends RecyclerView.Adapter<AnimalCardAdapter.animalViewHolder> {

    public ArrayList<AnimalsData> animalsDataArrayList;
    public Context context;


    public AnimalCardAdapter(ArrayList<AnimalsData> animalsDataArrayList, Context context) {
        this.animalsDataArrayList = animalsDataArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public animalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View animalCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new animalViewHolder(animalCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull animalViewHolder holder, int position) {
        final AnimalsData atCardPosition = animalsDataArrayList.get(position);

        holder.animalImage.setImageResource(animalsDataArrayList.get(position).getImageOfAnimal());
        holder.animalName.setText(animalsDataArrayList.get(position).getAnimalName());

        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Loading URL...",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("PageURL",atCardPosition.getAnimalPageURL());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animalsDataArrayList.size();
    }

    //Animal View Holder Class
    //Declaring Variables To Assign The itemViews of info_card.xml
    //And Provided To The Recycler View Adapter To Put The Content Into It That Variables
    public static class animalViewHolder extends RecyclerView.ViewHolder {

        public ImageView animalImage;
        public TextView animalName;
        public CardView parentLayout;


        public animalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalImage = itemView.findViewById(R.id.animalImageView);
            animalName = itemView.findViewById(R.id.animalNameTextView);
            parentLayout = itemView.findViewById(R.id.cardViewHolder);
        }
    }
}
