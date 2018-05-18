package com.duokan.core.p027b.p028a;

import android.util.Pair;
import java.util.LinkedList;
import java.util.List;


public class HttpConfig {
    
    public int connectTimeout = 5000;
    
    public int readTimeout = 10000;
    
    public int f547c = 0;
    
    public int f548d = 8192;
    
    public List<Pair<String, String>> pairLists = null;

    
    public HttpConfig m721a(int i) {
        this.f547c = i;
        return this;
    }

    
    public HttpConfig m724b(int i) {
        this.f548d = i;
        return this;
    }

    
    public HttpConfig setPairList(List<Pair<String, String>> list) {
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
