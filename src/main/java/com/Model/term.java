package com.Model;

public class term {
    private int id;
    private String term;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "term{" +
                "id=" + id +
                ", term=" + term +
                '}';
    }
}
