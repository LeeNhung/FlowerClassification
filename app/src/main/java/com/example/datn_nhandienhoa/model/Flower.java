package com.example.datn_nhandienhoa.model;

import java.io.Serializable;

public class Flower implements Serializable {
    private int id;
    private String name;
    private String origin;
    private String description;

    private String url, utility;

    public Flower() {
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public Flower(int id, String name, String origin, String description, String url, String utility) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.url = url;
        this.utility = utility;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Flower(int id, String name, String origin, String description, String url) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
