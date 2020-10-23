package com.doedelhi.pankhpractice.domain;

import android.arch.persistence.room.Entity;

@Entity
public class HighlightWords {

    private int position;

    private String word;

    private boolean isHighlighted;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
    }
}
