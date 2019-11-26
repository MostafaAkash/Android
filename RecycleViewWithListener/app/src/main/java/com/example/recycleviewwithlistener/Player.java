package com.example.recycleviewwithlistener;

public class Player {
    private int imageId;
    private String name;
    private String country;
    private String rankId;

    public Player(int imageId, String name, String country, String rankId) {
        this.imageId = imageId;
        this.name = name;
        this.country = country;
        this.rankId = rankId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getRankId() {
        return rankId;
    }
}