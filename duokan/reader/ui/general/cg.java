package com.duokan.reader.ui.general;

import com.duokan.reader.InputContentCache;
import com.duokan.reader.common.cache.p;
import com.duokan.reader.common.cache.r;

public class cg {
    private static r a = new ch();
    private static p b = new ci();
    private final String c;

    public void a(cj cjVar) {
        InputContentCache.putObject(this.c, cjVar, a);
    }

    public void a() {
        InputContentCache.remove(this.c);
    }
}
