package com.gs.VeterinaryCare.DataResource;

public class AnimalsData {
    private int ImageOfAnimal;
    private String AnimalName;
    private String AnimalPageURL;



    public AnimalsData(int imageOfAnimal, String animalName, String animalPageURL) {
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

    public String getAnimalName() {
        return AnimalName;
    }

    public String getAnimalPageURL(){
        return AnimalPageURL;
    }
}
