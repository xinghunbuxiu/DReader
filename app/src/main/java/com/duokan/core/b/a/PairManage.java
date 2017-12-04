package com.duokan.core.b.a;

import android.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class PairManage {
    public int a = 5000;
    public int b = 10000;
    public int c = 0;
    public int d = 8192;
    public List<Pair> pairLists = null;

    public PairManage a(int i) {
        this.c = i;
        return this;
    }

    public PairManage b(int i) {
        this.d = i;
        return this;
    }

    public PairManage setPairList(List<Pair> list) {
        this.pairLists = list;
        return this;
    }

    public PairManage getInstance(String first, String second) {
        if (this.pairLists == null) {
            this.pairLists = new LinkedList();
        }
        this.pairLists.add(new Pair(first, second));
        return this;
    }
}
