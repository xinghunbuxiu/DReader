package com.duokan.core.b.a;

import android.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class HttpConfig {
    public int connectTimeout = 5000;
    public int readTimeout = 10000;
    public int c = 0;
    public int d = 8192;
    public List<Pair> pairLists = null;

    public HttpConfig a(int i) {
        this.c = i;
        return this;
    }

    public HttpConfig b(int i) {
        this.d = i;
        return this;
    }

    public HttpConfig setPairList(List<Pair> list) {
        this.pairLists = list;
        return this;
    }

    public HttpConfig addPair(String first, String second) {
        if (this.pairLists == null) {
            this.pairLists = new LinkedList();
        }
        this.pairLists.add(new Pair(first, second));
        return this;
    }
}
