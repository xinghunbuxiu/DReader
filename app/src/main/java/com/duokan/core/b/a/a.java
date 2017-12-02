package com.duokan.core.b.a;

import android.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class a {
    public int a = 5000;
    public int b = 10000;
    public int c = 0;
    public int d = 8192;
    public List e = null;

    public a a(int i) {
        this.c = i;
        return this;
    }

    public a b(int i) {
        this.d = i;
        return this;
    }

    public a a(List list) {
        this.e = list;
        return this;
    }

    public a a(String str, String str2) {
        if (this.e == null) {
            this.e = new LinkedList();
        }
        this.e.add(new Pair(str, str2));
        return this;
    }
}
