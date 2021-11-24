package com.gs.VeterinaryCare.DataResource;

import androidx.annotation.NonNull;

public class AnimalsData {
    private int ImageOfAnimal;
    private String AnimalName;
    private String AnimalPageURL;



    public AnimalsData(int imageOfAnimal, @NonNull String animalName, @NonNull String animalPageURL) {
        this.ImageOfAnimal = imageOfAnimal;
        this.AnimalName = animalName;
        this.AnimalPageURL = animalPageURL;
    }

/*    public void setImageOfAnimal(int imageOfAnimal) {
        ImageOfAnimal = imageOfAnimal;
    }

    public void setAnimalName(String animalName) {
        AnimalName = animalName;
    }

    public void setAnimalPageURL(String animalPageURL) {
        AnimalPageURL = animalPageURL;
    }*/

    public int getImageOfAnimal() {
        return ImageOfAnimal;
    }

    @NonNull
    public String getAnimalName() {
        return AnimalName;
    }

    @NonNull
    public String getAnimalPageURL(){
        return AnimalPageURL;
    }
}
