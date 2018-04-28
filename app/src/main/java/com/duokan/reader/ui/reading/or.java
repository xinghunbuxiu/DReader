package com.duokan.reader.ui.reading;

import android.graphics.DrawFilter;
import java.util.LinkedList;

public class or extends DrawFilter {
    /* renamed from: a */
    private final LinkedList<Integer> f10753a = new LinkedList();
    /* renamed from: b */
    private final LinkedList<Integer> f10754b = new LinkedList();
    /* renamed from: c */
    private int f10755c = 0;

    /* renamed from: a */
    public void m14832a() {
        this.f10755c |= 1;
    }

    /* renamed from: b */
    public boolean m14833b() {
        return (this.f10755c & 1) == 1;
    }
}
