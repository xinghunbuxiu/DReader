package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;

public abstract class n extends WebSession {
    private static final String a = n.class.getName();

    public n() {
        super(a);
    }

    public void open() {
        open(CacheStrategy.DISABLE_CACHE);
    }

    public void open(long j) {
        open(CacheStrategy.DISABLE_CACHE, j);
    }
}
