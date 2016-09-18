package com.github.magicmouse.Models;

/**
 * Created by Peter on 2016-09-18.
 */
public class TwitterModel {

    String query;

    public TwitterModel() {
    }

    public TwitterModel(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "TwitterModel{" +
                "query='" + query + '\'' +
                '}';
    }

}
