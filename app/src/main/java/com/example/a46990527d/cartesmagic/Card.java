package com.example.a46990527d.cartesmagic;

/**
 * Created by 46990527d on 18/10/16.
 */

public class Card {

    private String name;
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
