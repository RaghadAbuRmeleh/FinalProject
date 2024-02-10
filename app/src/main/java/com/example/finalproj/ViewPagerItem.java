package com.example.finalproj;


public class ViewPagerItem {
    private int imageID;
    private String heading;
    private String description;

    public ViewPagerItem(int imageID, String heading, String description) {
        this.imageID = imageID;
        this.imageID = imageID;
        this.heading = heading;
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


