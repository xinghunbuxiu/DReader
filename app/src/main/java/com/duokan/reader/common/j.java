package com.duokan.reader.common;

import com.duokan.reader.common.webservices.WebSession;

public abstract class j extends WebSession {
    private static final String a = j.class.getName();

    public j() {
        super(a);
    }

    public void open() {
        open(CacheStrategy.DISABLE_CACHE);
    }

    public void open(long j) {
        open(CacheStrategy.DISABLE_CACHE, j);
    }
}
