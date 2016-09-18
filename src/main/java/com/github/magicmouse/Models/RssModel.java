package com.github.magicmouse.Models;

/**
 * Created by Peter on 2016-09-18.
 */
public class RssModel {

    String query;

    public RssModel() {
    }

    public RssModel(String query) {
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
        return "RssModel{" +
                "query='" + query + '\'' +
                '}';
    }
}
