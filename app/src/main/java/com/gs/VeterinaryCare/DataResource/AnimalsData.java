package com.gs.VeterinaryCare.DataResource;


public class AnimalsData {
    private String animalName;
    private String imageURL;
    private String pageURL;
    private int type;

    public AnimalsData(){

    }

    public AnimalsData(String animalName, String imageURL, String pageURL, int type) {
        this.animalName = animalName;
        this.imageURL = imageURL;
        this.pageURL = pageURL;
        this.type = type;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
