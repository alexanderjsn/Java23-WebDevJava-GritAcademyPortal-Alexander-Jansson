package org.example;

public class Suggestion {
    private String term;

    public Suggestion() {}

    public Suggestion(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}