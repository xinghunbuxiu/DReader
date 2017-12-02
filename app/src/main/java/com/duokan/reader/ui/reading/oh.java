package com.duokan.reader.ui.reading;

import android.graphics.DrawFilter;

import java.util.LinkedList;

public class oh extends DrawFilter {
    private final LinkedList a = new LinkedList();
    private final LinkedList b = new LinkedList();
    private int c = 0;

    public void a() {
        this.c |= 1;
    }

    public boolean b() {
        return (this.c & 1) == 1;
    }
}
